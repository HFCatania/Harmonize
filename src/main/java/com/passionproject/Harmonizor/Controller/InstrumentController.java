package com.passionproject.Harmonizor.Controller;

import com.passionproject.Harmonizor.Model.Instrument;
import com.passionproject.Harmonizor.Service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://localhost:4200")
public class InstrumentController {

    @Autowired
    private InstrumentService instrumentService;

    @PostMapping(path = "/instruments")
    public ResponseEntity<Instrument> create(@RequestBody Instrument instrument){
        try {
            return new ResponseEntity<>(instrumentService.create(instrument), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/instruments")
    public ResponseEntity<Iterable<Instrument>> findAll(){
        try {
            return new ResponseEntity<>(instrumentService.findAll(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
