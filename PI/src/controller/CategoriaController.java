package controller;

import dao.dto.CategoriaDTO;
import entities.Categoria;
import services.CategoriasService;

import java.util.List;

public class CategoriaController {
    private CategoriasService service;

    public CategoriaController(CategoriasService service) {
        this.service = service;
    }

    public Categoria buscarCategoria(String categoria) {
        return this.service.buscarCategoria(categoria);
    }

    public List<Categoria> buscarCategorias() {
        return this.service.buscarCategorias();
    }

    public Categoria crearCategoria(CategoriaDTO nuevaCategoria) {
        return this.service.crearCategoria(nuevaCategoria);
    }

    public Categoria crearCategoria(String nuevaCategoria) {
        return this.service.crearCategoria(new CategoriaDTO(nuevaCategoria));
    }

    public Categoria modificarCategoria(CategoriaDTO nuevaCategoria) {
        return this.service.modificarCategoria(nuevaCategoria);
    }

    public String borrarCategoria(String categoria) {
        return this.service.borrarCategoria(categoria);
    }

    public String borrarCategoria(int id) {
        return this.service.borrarCategoria(id);
    }

}
