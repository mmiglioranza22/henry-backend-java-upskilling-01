package com.pispring.PISpring.services.impl;

import com.pispring.PISpring.repository.impl.CategoriaRepositoryImpl;
import com.pispring.PISpring.dto.CategoriaDTO;
import com.pispring.PISpring.exceptions.DAOException;
import com.pispring.PISpring.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriasServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepositoryImpl categoriaRepository;

    public CategoriasServiceImpl(CategoriaRepositoryImpl categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public CategoriaDTO crearEntidad(CategoriaDTO nuevaCategoria) {
        CategoriaDTO respuestaDTO = null;
        try {
            System.out.println(nuevaCategoria.toString());
            respuestaDTO = this.categoriaRepository.insertar(nuevaCategoria);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return respuestaDTO;
    }

    @Override
    public List<CategoriaDTO> buscarEntidades() {
        List<CategoriaDTO> lista = null;
        try {
            lista = this.categoriaRepository.buscarMuchos();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public CategoriaDTO buscarEntidad(Integer id) {
        CategoriaDTO respuestaDTO = null;
        try {
            respuestaDTO = this.categoriaRepository.buscar(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return respuestaDTO;
    }

    @Override
    public CategoriaDTO modificarEntidad(Integer id, CategoriaDTO nuevaCategoria) {
        CategoriaDTO respuestaDTO = null;
        try {
            respuestaDTO = this.categoriaRepository.modificar(id, nuevaCategoria);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return respuestaDTO;
    }

    @Override
    public String eliminarEntidad(Integer id) {
        String respuesta;
        try {
            respuesta = this.categoriaRepository.eliminar(id);
        } catch (DAOException e) {
            e.printStackTrace();
            respuesta = "Error al eliminar gasto";
        }
        return respuesta;
    }
}
