package com.pispring.PISpring.controller;


import com.pispring.PISpring.dto.GastoDTO;
import com.pispring.PISpring.entities.Gasto;
import com.pispring.PISpring.services.impl.GastosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

// https://stackoverflow.com/questions/45490749/service-and-dao-vs-mvc
@RestController
@RequestMapping("/gasto")
public class GastosController {

    private GastosService service;

    public GastosController(GastosService service) {
        this.service = service;
    }

    @PostMapping("/test")
    public ResponseEntity<Gasto> crearGastoTest(@RequestBody GastoDTO nuevoGasto) {
        GastoDTO convertido = new GastoDTO();
        convertido.setCategoria("boca boca");
        convertido.setMonto(Double.valueOf(100));
        convertido.setFecha(new Date());
        convertido.setEsRecurrente(true);

        Gasto respuesta = this.service.crearGastoTest(convertido);
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping
    public ResponseEntity<Gasto> crearGasto(@RequestBody GastoDTO nuevoGasto) {
        Gasto respuesta = this.service.crearGasto(nuevoGasto);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Gasto>> buscarGastos() {
        return ResponseEntity.ok(this.service.buscarGastos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gasto> buscarGasto(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.service.buscarGasto(id));
    }

    //    el id es enviado dentro del body, es buena práctica?
    @PutMapping
    public ResponseEntity<Gasto> modificarGasto(@RequestBody GastoDTO nuevoGasto) {
        return new ResponseEntity<>(this.service.modificarGasto(nuevoGasto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarGasto(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(this.service.borrarGasto(id), HttpStatus.ACCEPTED);
    }
}