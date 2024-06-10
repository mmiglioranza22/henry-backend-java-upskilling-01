package com.pispring.PISpring.controller;

import com.pispring.PISpring.dto.CategoriaDTO;
import com.pispring.PISpring.entities.Categoria;
import com.pispring.PISpring.services.impl.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//https://www.baeldung.com/spring-controller-vs-restcontroller
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriasService service;

    public CategoriaController(CategoriasService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Categoria> crearCategoria(@RequestBody CategoriaDTO nuevaCategoria) {
        Categoria respuesta = this.service.crearCategoria(nuevaCategoria);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Categoria>> buscarCategorias() {
        return ResponseEntity.ok(this.service.buscarCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarCategoria(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.service.buscarCategoria(id));
    }

    //    el id es enviado dentro del body, es buena práctica?
    @PutMapping
    public ResponseEntity<Categoria> modificarCategoria(@RequestBody CategoriaDTO nuevaCategoria) {
        return new ResponseEntity<>(this.service.modificarCategoria(nuevaCategoria), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarCategoria(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(this.service.borrarCategoria(id), HttpStatus.ACCEPTED);
    }

}