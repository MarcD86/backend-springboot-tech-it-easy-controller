package com.example.backendspringboottechiteasycontroller.controllers;

import com.example.backendspringboottechiteasycontroller.exceptions.RecordNotFoundException;
import com.example.backendspringboottechiteasycontroller.service.Television;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@RestController
public class TelevisionController {

    private List<Television> televisions;

    public TelevisionController(){
        televisions = new ArrayList<>();
        Television tv = new Television();
        tv.setBrandName("test1");
        tv.setBrandName("test2");

    }

    @GetMapping("/televisions")
    public ResponseEntity<Object> getTelevisions() {
        return new ResponseEntity<>(televisions, HttpStatus.OK);
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<Television> getTelevisions(@PathVariable int id) {
        if (id < 10) {
            return new ResponseEntity<>(televisions.get(id), HttpStatus.OK);
        } else {
            throw new RecordNotFoundException("ID not valid");
        }
    }

    @PostMapping("/televisions")
    public ResponseEntity<Object> postTelevision(@RequestBody Television tv) {
            televisions.add(tv);
            return new ResponseEntity<>(tv, HttpStatus.CREATED);
        }

    @PutMapping("/televisions/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable int id, @RequestBody Television tv) {
              televisions.set(id, tv);
              if (id >= 0 && id < televisions.size()) {
                  return new ResponseEntity<>(tv, HttpStatus.OK);
              } else {
//                  throw new RecordNotFoundException("ID not exist");
                  return new ResponseEntity<>("invalid ID", HttpStatus.BAD_REQUEST);
              }
    }
}

//
//        GET-request voor alle televisies
//        een GET-request voor 1 televisie
//        een POST-request voor 1 televisie
//        een PUT-request voor 1 televisie
//        een DELETE-request voor 1 televisie
