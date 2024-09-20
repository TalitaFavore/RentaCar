package br.com.talitafavore.rentacar.controller;

import br.com.talitafavore.rentacar.model.CityModel;
import br.com.talitafavore.rentacar.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService service;

    @PostMapping //método POST
    public ResponseEntity<CityModel> create(@RequestBody CityModel cityModel) {
        CityModel model = service.create(cityModel);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

    @GetMapping("/{id}") //método GET
    public ResponseEntity<CityModel> findById(@PathVariable(name = "id") long id) {
        CityModel model = service.findByID(id);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PutMapping //método PUT
    public ResponseEntity<CityModel> update(@RequestBody CityModel cityModel) {
        CityModel model = service.update(cityModel);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @DeleteMapping("/{id}") //método DELETE
    public ResponseEntity delete(@PathVariable(name = "id") long id) {
        service.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<CityModel>>findAll() {
        var list = service.findAll();
        return new ResponseEntity<List<CityModel>>(list, HttpStatus.OK);
    }

}
