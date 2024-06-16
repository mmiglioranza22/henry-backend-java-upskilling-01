package com.pispring.PISpring.controller;

import com.pispring.PISpring.dto.CategoriaDTO;
import com.pispring.PISpring.services.CategoriaService;
import com.pispring.PISpring.services.impl.CategoriasServiceImpl;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CategoriaController test suite")
@ExtendWith(MockitoExtension.class)
class CategoriaControllerTest {

    @Mock
    private CategoriasServiceImpl service;  //= Mockito.mock(CategoriasServiceImpl.class);
    @InjectMocks
    private CategoriaController controller; // = new CategoriaController(service);


    @DisplayName("Crea categoria exitosamente")
    @Test
    void testCreaCategoriaExitosamente() {
        // GIVEN
        CategoriaDTO mock = new CategoriaDTO("nueva categoria");
        CategoriaDTO respuestaEsperada = new CategoriaDTO("nueva categoria");

        // WHEN
        Mockito.when(service.crearEntidad(mock)).thenReturn(mock);
        ResponseEntity<CategoriaDTO> respuesta = controller.crearCategoria(mock);

        // THEN
        Assertions.assertEquals(HttpStatus.OK, respuesta.getStatusCode());
        Assertions.assertEquals(respuestaEsperada.getCategoria(), respuesta.getBody().getCategoria());
    }

    @DisplayName("Busca la categoria exitosamente por id")
    @Test
    void testBuscarCategoriaDevuelveMockEsperado() {
        // GIVEN
        CategoriaDTO mock = new CategoriaDTO("mock categoria");
        CategoriaDTO respuestaEsperada = new CategoriaDTO("mock categoria");
        mock.setId(1);

        // WHEN
        Mockito.when(service.buscarEntidad(1)).thenReturn(mock);
        ResponseEntity<CategoriaDTO> respuesta = controller.buscarCategoria(1);

        // THEN
        Assertions.assertEquals(HttpStatus.OK, respuesta.getStatusCode());
        Assertions.assertEquals(respuestaEsperada.getCategoria(), respuesta.getBody().getCategoria());
    }

    @DisplayName("No retorna nada si no existen categorias preexistentes")
    @Test
    void testBuscarCategoriasNoDevuelveSiNoExisten() {
        // GIVEN

        // WHEN
        Mockito.when(service.buscarEntidades()).thenReturn(null);
        ResponseEntity<List<CategoriaDTO>> respuesta = controller.buscarCategorias();

        // THEN
        Assertions.assertEquals(HttpStatus.OK, respuesta.getStatusCode());
        Assertions.assertEquals(null, respuesta.getBody());
    }

    @DisplayName("Retorna categorias existentes correctamente")
    @Test
    void testBuscarCategoriasDevuelveCategoriasExistentes() {
        // GIVEN
        CategoriaDTO mock1 = new CategoriaDTO("mock 1");
        CategoriaDTO mock2 = new CategoriaDTO("mock 2");
        CategoriaDTO mock3 = new CategoriaDTO("mock 3");
        List<CategoriaDTO> mockList = new ArrayList<>();
        mockList.add(mock1);
        mockList.add(mock2);
        mockList.add(mock3);

        // WHEN
        Mockito.when(service.buscarEntidades()).thenReturn(mockList);
        ResponseEntity<List<CategoriaDTO>> respuesta = controller.buscarCategorias();

        // THEN
        Assertions.assertEquals(HttpStatus.OK, respuesta.getStatusCode());
        Assertions.assertEquals(mockList.size(), respuesta.getBody().size());
        Assertions.assertEquals(mockList.get(1).getCategoria(), respuesta.getBody().get(1).getCategoria());
    }

//    @Test
//    void testModificarCategoriaRealizaCambioCorrectamente() {
//        // GIVEN
//        CategoriaDTO mock = new CategoriaDTO("mock categoria modificada");
//        mock.setId(1);
//        CategoriaDTO input = new CategoriaDTO("mock categoria modificada");
//        CategoriaDTO respuestaEsperada = new CategoriaDTO("mock categoria modificada");
//
//        // WHEN
//        Mockito.when(service.modificarEntidad(1, mock)).thenReturn(mock);
//        ResponseEntity<CategoriaDTO> respuesta = controller.modificarCategoria(1, input);
//
//        // THEN
//        Assertions.assertEquals(HttpStatus.OK, respuesta.getStatusCode());
//        Assertions.assertEquals(respuestaEsperada.getCategoria(), respuesta.getBody().getCategoria());
//
//    }

    @DisplayName("Borra categoria exitosamente por id")
    @Test
    void testBorrarCategoriaDevuelveRespuestaCorrecta() {
        // GIVEN
        CategoriaDTO mock1 = new CategoriaDTO("mock 1");
        mock1.setId(1);

        // WHEN
        Mockito.when(service.eliminarEntidad(1)).thenReturn("Categoria con id: " + mock1.getId() + " borrada con éxito");

        ResponseEntity<String> respuesta = controller.borrarCategoria(1);

        // THEN
        Assertions.assertEquals(HttpStatus.ACCEPTED, respuesta.getStatusCode());
        Assertions.assertEquals("Categoria con id: " + mock1.getId() + " borrada con éxito", respuesta.getBody());
    }
}