package com.pispring.PISpring.controller;

import com.pispring.PISpring.dto.CategoriaDTO;
import com.pispring.PISpring.services.impl.CategoriasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//https://www.baeldung.com/spring-controller-vs-restcontroller
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriasServiceImpl service;

    public CategoriaController(CategoriasServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> crearCategoria(@RequestBody CategoriaDTO nuevaCategoria) {
        CategoriaDTO respuesta = this.service.crearEntidad(nuevaCategoria);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoriaDTO>> buscarCategorias() {
        return ResponseEntity.ok(this.service.buscarEntidades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> buscarCategoria(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.service.buscarEntidad(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> modificarCategoria(@PathVariable("id") Integer id, @RequestBody CategoriaDTO nuevaCategoria) {
        return new ResponseEntity<>(this.service.modificarEntidad(id, nuevaCategoria), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarCategoria(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(this.service.eliminarEntidad(id), HttpStatus.ACCEPTED);
    }

}