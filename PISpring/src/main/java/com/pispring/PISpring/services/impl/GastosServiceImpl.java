package com.pispring.PISpring.services.impl;

import com.pispring.PISpring.repository.impl.CategoriaRepositoryImpl;
import com.pispring.PISpring.repository.impl.GastoRepositoryImpl;
import com.pispring.PISpring.dto.CategoriaDTO;
import com.pispring.PISpring.dto.GastoDTO;
import com.pispring.PISpring.exceptions.DAOException;
import com.pispring.PISpring.services.GastosService;
import org.springframework.stereotype.Service;

import java.util.List;

//throws custom exception
//ver video sobre bdII
@Service
public class GastosServiceImpl implements GastosService {
    private GastoRepositoryImpl gastoRepository;

    private CategoriaRepositoryImpl categoriaRepository;

    public GastosServiceImpl(GastoRepositoryImpl gastoRepository, CategoriaRepositoryImpl categoriaRepository) {
        this.gastoRepository = gastoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public GastoDTO crearEntidad(GastoDTO nuevoGasto) {
        GastoDTO respuestaDTO = null;
        //  La categoria es un string, es necesario buscar o crear la categoria primero para encontrarlo
        try {
            CategoriaDTO catDto = this.categoriaRepository.insertar(new CategoriaDTO(nuevoGasto.getCategoria()));
            if (catDto != null) {
                nuevoGasto.setCategoriaId(catDto.getId());
                respuestaDTO = this.gastoRepository.insertar(nuevoGasto);
            }
        } catch (DAOException e) {
            System.out.println("Error al insertar nueva gasto en base de datos");
            e.printStackTrace();
            return null;
        }
        return respuestaDTO;
    }

    @Override
    public List<GastoDTO> buscarEntidades() {
        List<GastoDTO> respuestaDTO = null;
        try {
            respuestaDTO = this.gastoRepository.buscarMuchos();
        } catch (DAOException e) {
            System.out.println("Error al buscar gasto en base de datos");
            e.printStackTrace();
        }
        return respuestaDTO;
    }

    @Override
    public GastoDTO buscarEntidad(Integer id) {
        GastoDTO respuestaDTO = null;

        try {
            respuestaDTO = this.gastoRepository.buscar(id);
        } catch (DAOException e) {
            System.out.println("Error al buscar gasto en base de datos");
            e.printStackTrace();
        }
        return respuestaDTO;
    }

    @Override
    public GastoDTO modificarEntidad(Integer id, GastoDTO gastoCambiado) {
        GastoDTO respuestaDTO = null;
        try {
            respuestaDTO = this.gastoRepository.modificar(id, gastoCambiado);
        } catch (DAOException e) {
            System.out.println("Error al insertar nueva gasto en base de datos");
            e.printStackTrace();
            return null;
        }
        return respuestaDTO;
    }

    @Override
    public String eliminarEntidad(Integer id) {
        String response = "";
        try {
            response = gastoRepository.eliminar(id);
        } catch (DAOException e) {
            e.printStackTrace();
            response = "Error al eliminar gasto";
        }
        return response;
    }
}