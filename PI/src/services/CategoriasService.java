package services;

import dao.dto.CategoriaDTO;
import dao.dto.GastoDTO;
import dao.impl.CategoriaDAOImpl;
import entities.Categoria;
import entities.Gasto;
import exceptions.DAOException;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CategoriasService {
    private CategoriaDAOImpl categoriaDAO;

    public CategoriasService(CategoriaDAOImpl categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    public Categoria buscarCategoria(String categoria) {
        Categoria nuevaCategoria = null;
        try {
            System.out.println("Buscando categoria preexistente...");
            CategoriaDTO encontrada = this.categoriaDAO.buscarOperacion(categoria);
            if (encontrada != null) {
                nuevaCategoria = new Categoria(encontrada.getId(), encontrada.getCategoria());
                System.out.println("Categoria encontrada!");
            }
        } catch (DAOException e) {
            System.out.println("Error al buscar nueva categoria en base de datos");
            e.printStackTrace();
        }
        return nuevaCategoria;

    }

    public List<Categoria> buscarCategorias() {
        List<Categoria> lista = null;
        try {
            List<CategoriaDTO> resultado = this.categoriaDAO.buscarOperaciones();
            if (resultado != null) {
                lista = resultado.stream().map(cat -> this.mappeo(cat)).toList();
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    private Categoria mappeo(CategoriaDTO resultado) {
        return new Categoria(resultado.getId(), resultado.getCategoria());
    }

    public Categoria crearCategoria(CategoriaDTO nuevaCategoria) {
        Categoria categoriaCreada = null;
        try {
            System.out.println("Creando categoria...");
            categoriaDAO.insertarOperacion(nuevaCategoria);
            categoriaCreada = new Categoria();
            categoriaCreada.setNombre(nuevaCategoria.getCategoria());
        } catch (DAOException e) {
            System.out.println("Error al insertar nueva categoria en base de datos");
            e.printStackTrace();
        }
        return categoriaCreada;
    }

    public Categoria modificarCategoria(CategoriaDTO nuevaCategoria) {
        return null;
    }

    public String borrarCategoria(String categoria) {
        try {
            categoriaDAO.eliminarOperacion(categoria);
        } catch (DAOException e) {
            System.out.println("Error al borrar categoria en base de datos");
            e.printStackTrace();
            return "Error al eliminar categoria";
        }
        return "Categoria eliminada exitosamente";
    }

    public String borrarCategoria(int id) {
        try {
            categoriaDAO.eliminarOperacion(id);
        } catch (DAOException e) {
            System.out.println("Error al borrar categoria en base de datos");
            e.printStackTrace();
            return "Error al eliminar gasto";
        }
        return "Gasto eliminado exitosamente";
    }
}
