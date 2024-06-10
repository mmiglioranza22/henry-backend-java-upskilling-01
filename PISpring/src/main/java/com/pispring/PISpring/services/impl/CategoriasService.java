package com.pispring.PISpring.services.impl;

import com.pispring.PISpring.dao.impl.CategoriaDAOImpl;
import com.pispring.PISpring.dto.CategoriaDTO;
import com.pispring.PISpring.entities.Categoria;
import com.pispring.PISpring.exceptions.DAOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriasService {
    @Autowired
    private CategoriaDAOImpl categoriaDAO;

    public CategoriasService(CategoriaDAOImpl categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    private Categoria mappeo(CategoriaDTO resultado) {
        return new Categoria(resultado.getId(), resultado.getCategoria());
    }

    public Categoria crearCategoria(CategoriaDTO nuevaCategoria) {
        Categoria categoriaCreada = null;

//        Primero tiene que buscar, luego crearla si no devuelve ningun resultado
        try {
            CategoriaDTO dto = this.categoriaDAO.insertar(nuevaCategoria);
            if (dto != null) {
                categoriaCreada = this.mappeo(dto);
                System.out.println(categoriaCreada.toString());
            } else {
                System.out.println("dto fue devuelto como null");
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return categoriaCreada;
    }

    public List<Categoria> buscarCategorias() {
        List<Categoria> lista = null;
        try {
            List<CategoriaDTO> categorias = this.categoriaDAO.buscarMuchos();
            if (categorias != null) {
                lista = categorias.stream().map(el -> this.mappeo(el)).toList();
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Categoria buscarCategoria(Integer id) {
        Categoria categoriaEncontrada = null;
        try {
            CategoriaDTO resultado = this.categoriaDAO.buscar(id);
            if (resultado != null) {
                categoriaEncontrada = this.mappeo(resultado);
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return categoriaEncontrada;
    }

    public Categoria modificarCategoria(CategoriaDTO nuevaCategoria) {
        Categoria categoriaModificada = null;
        try {
            CategoriaDTO resultado = this.categoriaDAO.modificar(nuevaCategoria);
            if (resultado != null) {
                categoriaModificada = this.mappeo(resultado);
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return categoriaModificada;
    }

    public String borrarCategoria(Integer id) {
        String respuesta = "";
        try {
            respuesta = categoriaDAO.eliminar(id);
        } catch (DAOException e) {
            e.printStackTrace();
            respuesta = "Error al eliminar gasto";
        }
        return respuesta;
    }
}
