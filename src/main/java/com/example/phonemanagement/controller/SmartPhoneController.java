package com.example.phonemanagement.controller;

import com.example.phonemanagement.entity.SmartPhone;
import com.example.phonemanagement.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartPhoneController {
    @Autowired
    private ISmartPhoneService smartPhoneService;

    @PostMapping
    public ResponseEntity<SmartPhone> createSmartPhone(@RequestBody SmartPhone smartPhone){
        return new ResponseEntity<>(smartPhoneService.save(smartPhone), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage(){
        ModelAndView modelAndView = new ModelAndView("/phones/list");
        modelAndView.addObject("smartphones",smartPhoneService.findAll());
        return modelAndView;
    }

    @GetMapping
    public ResponseEntity<Iterable<SmartPhone>> allPhones(){
        return new ResponseEntity<>(smartPhoneService.findAll(),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<SmartPhone> deleteSmartPhone(@PathVariable Long id){
        Optional<SmartPhone> smartPhoneOptional = smartPhoneService.findById(id);
        if(!smartPhoneOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartPhoneService.remove(id);
        return new ResponseEntity<>(smartPhoneOptional.get(),HttpStatus.NO_CONTENT);
    }

    @GetMapping("/update")
    public ModelAndView viewUpdate(@RequestParam Long id){
        return new ModelAndView("phones/update","smartphone",smartPhoneService.findById(id));
    }

    @PutMapping
    public ResponseEntity<SmartPhone> updateSmartPhone(@RequestBody SmartPhone smartPhone ){
        smartPhoneService.update(smartPhone);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
