package com.pispring.PISpring.controller;

import com.pispring.PISpring.dto.CategoriaDTO;
import com.pispring.PISpring.dto.GastoDTO;
import com.pispring.PISpring.services.impl.GastosServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GastosController test suite")
@ExtendWith(MockitoExtension.class)
class GastosControllerTest {
    @Mock
    private GastosServiceImpl service;

    @InjectMocks
    private GastosController controller;

    private GastoDTO mock;
    private GastoDTO respuestaEsperada;

    @BeforeEach
    public void setup() {
        Date today = new Date();
        mock = new GastoDTO();
        mock.setMonto(200.0);
        mock.setFecha(today);
        mock.setEsRecurrente(true);
        mock.setCategoriaId(1);
        mock.setCategoria("padel");

        respuestaEsperada = new GastoDTO();
        respuestaEsperada.setMonto(200.0);
        respuestaEsperada.setFecha(today);
        respuestaEsperada.setEsRecurrente(true);
        respuestaEsperada.setCategoriaId(1);
        respuestaEsperada.setCategoria("padel");
    }

    @DisplayName("Crea gasto exitosamente")
    @Test
    void testCrearGastoExitosamente() {
        // GIVEN

        // WHEN
        Mockito.when(service.crearEntidad(mock)).thenReturn(mock);
        ResponseEntity<GastoDTO> respuesta = controller.crearGasto(mock);

        // THEN
        Assertions.assertEquals(HttpStatus.OK, respuesta.getStatusCode());
        Assertions.assertEquals(respuestaEsperada.getCategoria(), respuesta.getBody().getCategoria());
        Assertions.assertEquals(respuestaEsperada.getMonto(), respuesta.getBody().getMonto());
    }

    @DisplayName("Busca el gasto exitosamente por id")
    @Test
    void testBuscarGastosDevuelveMockEsperado() {
        // GIVEN
        mock.setId(1);

        // WHEN
        Mockito.when(service.buscarEntidad(1)).thenReturn(mock);
        ResponseEntity<GastoDTO> respuesta = controller.buscarGasto(1);

        // THEN
        Assertions.assertEquals(HttpStatus.OK, respuesta.getStatusCode());
        Assertions.assertEquals(respuestaEsperada.getCategoria(), respuesta.getBody().getCategoria());
    }

    @DisplayName("No retorna nada si no existen gastos preexistentes")
    @Test
    void testBuscarGastosNoDevuelveSiNoExisten() {
        // GIVEN

        // WHEN
        Mockito.when(service.buscarEntidades()).thenReturn(null);
        ResponseEntity<List<GastoDTO>> respuesta = controller.buscarGastos();

        // THEN
        Assertions.assertEquals(HttpStatus.OK, respuesta.getStatusCode());
        Assertions.assertEquals(null, respuesta.getBody());
    }

    @DisplayName("Retorna gastos existentes correctamente")
    @Test
    void testBuscarGastosDevuelveGastosExistentes() { // GIVEN
        GastoDTO mock1 = new GastoDTO();
        mock1.setMonto(100.0);
        GastoDTO mock2 = new GastoDTO();
        GastoDTO mock3 = new GastoDTO();
        List<GastoDTO> mockList = new ArrayList<>();
        mockList.add(mock1);
        mockList.add(mock2);
        mockList.add(mock3);

        // WHEN
        Mockito.when(service.buscarEntidades()).thenReturn(mockList);
        ResponseEntity<List<GastoDTO>> respuesta = controller.buscarGastos();

        // THEN
        Assertions.assertEquals(HttpStatus.OK, respuesta.getStatusCode());
        Assertions.assertEquals(mockList.size(), respuesta.getBody().size());
        Assertions.assertEquals(mockList.get(1).getMonto(), respuesta.getBody().get(1).getMonto());

    }

    @DisplayName("Borra gasto exitosamente por id")
    @Test
    void testBorrarGastoDevuelveRespuestaCorrecta() {
        // GIVEN
        GastoDTO mock1 = new GastoDTO();
        mock1.setId(1);

        // WHEN
        Mockito.when(service.eliminarEntidad(1)).thenReturn("Gasto con id: " + mock1.getId() + " borrado con éxito");

        ResponseEntity<String> respuesta = controller.borrarGasto(1);

        // THEN
        Assertions.assertEquals(HttpStatus.ACCEPTED, respuesta.getStatusCode());
        Assertions.assertEquals("Gasto con id: " + mock1.getId() + " borrado con éxito", respuesta.getBody());

    }
}