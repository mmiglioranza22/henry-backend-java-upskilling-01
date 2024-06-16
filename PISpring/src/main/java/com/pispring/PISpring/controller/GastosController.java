package com.pispring.PISpring.controller;


import com.pispring.PISpring.dto.GastoDTO;
import com.pispring.PISpring.services.impl.GastosServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// https://stackoverflow.com/questions/45490749/service-and-dao-vs-mvc
@RestController
@RequestMapping("/gasto")
public class GastosController {

    private GastosServiceImpl service;

    public GastosController(GastosServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<GastoDTO> crearGasto(@RequestBody GastoDTO nuevoGasto) {
        GastoDTO respuesta = this.service.crearEntidad(nuevoGasto);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GastoDTO>> buscarGastos() {
        return ResponseEntity.ok(this.service.buscarEntidades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GastoDTO> buscarGasto(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.service.buscarEntidad(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GastoDTO> modificarGasto(@PathVariable("id") Integer id, @RequestBody GastoDTO nuevoGasto) {
        return new ResponseEntity<>(this.service.modificarEntidad(id, nuevoGasto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarGasto(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(this.service.eliminarEntidad(id), HttpStatus.ACCEPTED);
    }
}