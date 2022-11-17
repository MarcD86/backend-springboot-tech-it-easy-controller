package com.example.backendspringboottechiteasycontroller.controllers;

import com.example.backendspringboottechiteasycontroller.exceptions.RecordNotFoundException;
import com.example.backendspringboottechiteasycontroller.service.Television;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@RestController
public class TelevisionController {

    private List<Television> televisions;

    public TelevisionController(){
        televisions = new ArrayList<>();

    }

    @GetMapping("/televisions")
    public ResponseEntity<Object> getTelevisions() {
        return new ResponseEntity<>(televisions, HttpStatus.OK);
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<Television> getTelevisions(@PathVariable int id) {
        if (id >= 0 && id < televisions.size()) {
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
//                  return new ResponseEntity<>(tv, HttpStatus.OK);
                  return ResponseEntity.ok(tv);
              } else {
//                  throw new RecordNotFoundException("ID not exist");
                  return new ResponseEntity<>("invalid ID", HttpStatus.BAD_REQUEST);
              }
    }

    @DeleteMapping("/televisions")
    public ResponseEntity<Object> deleteTelevision(@RequestBody String tv) {
        for (int i = 0; i < televisions.size(); i++) {
            if (televisions.get(i).getBrandName().equals(tv)) {
                televisions.remove(i);
                return new ResponseEntity<>("Item removed", HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>("No television found", HttpStatus.BAD_REQUEST);
    }
}
