package com.pispring.PISpring.services.impl;

import com.pispring.PISpring.dao.impl.CategoriaDAOImpl;
import com.pispring.PISpring.dao.impl.GastoDAOImpl;
import com.pispring.PISpring.dto.CategoriaDTO;
import com.pispring.PISpring.dto.GastoDTO;
import com.pispring.PISpring.entities.Gasto;
import com.pispring.PISpring.exceptions.DAOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//throws custom exception
//ver video sobre bdII
@Service
public class GastosService {
    private GastoDAOImpl gastosDAO;

    private CategoriaDAOImpl categoriaDAO;

    public GastosService(GastoDAOImpl gastosDAO, CategoriaDAOImpl categoriaDAO) {
        this.gastosDAO = gastosDAO;
        this.categoriaDAO = categoriaDAO;
    }

    private Gasto mappeo(GastoDTO resultado) {
        Gasto gasto = new Gasto();
        System.out.println(resultado.getId());
        gasto.setId(resultado.getId());
        gasto.setMonto(resultado.getMonto());
        gasto.setFecha(resultado.getFecha());
        gasto.setCategoriaId(resultado.getCategoriaId());
        gasto.setEsRecurrente(resultado.isEsRecurrente());
        gasto.setCategoria(resultado.getCategoria());
        return gasto;
    }

    public Gasto crearGastoTest(GastoDTO nuevoGasto) {
        Gasto gastoCreado = null;
        try {
            CategoriaDTO catDto = this.categoriaDAO.insertar(new CategoriaDTO(nuevoGasto.getCategoria()));
            if (catDto != null) {
                nuevoGasto.setCategoriaId(catDto.getId());
            }
            GastoDTO dto = this.gastosDAO.insertar(nuevoGasto);
            if (dto != null) {
                gastoCreado = this.mappeo(dto);
                System.out.println(gastoCreado.toString());
            }
        } catch (DAOException e) {
            System.out.println("Error al insertar nueva gasto en base de datos");
            e.printStackTrace();
        }
        return gastoCreado;
    }

    public Gasto crearGasto(GastoDTO nuevoGasto) {
        Gasto gastoCreado = null;
        try {
//            Es necesario buscar o crear la categoria primero para encontrar el id
            CategoriaDTO catDto = this.categoriaDAO.insertar(new CategoriaDTO(nuevoGasto.getCategoria()));
            if (catDto != null) {
                nuevoGasto.setCategoriaId(catDto.getId());
            }
            GastoDTO dto = this.gastosDAO.insertar(nuevoGasto);
            if (dto != null) {
                gastoCreado = this.mappeo(dto);
                System.out.println(gastoCreado.toString());
            }
        } catch (DAOException e) {
            System.out.println("Error al insertar nueva gasto en base de datos");
            e.printStackTrace();
        }
        return gastoCreado;
    }

    public List<Gasto> buscarGastos() {
        List<Gasto> lista = null;
        try {
            List<GastoDTO> resultado = this.gastosDAO.buscarMuchos();
            if (resultado != null) {
                lista = resultado.stream().map(gasto -> this.mappeo(gasto)).toList();
            }
        } catch (DAOException e) {
            System.out.println("Error al buscar gasto en base de datos");
            e.printStackTrace();
        }
        return lista;
    }

    public Gasto buscarGasto(int id) {
        Gasto gasto = null;
        try {
            GastoDTO resultado = this.gastosDAO.buscar(id);
            if (resultado != null) {
                gasto = this.mappeo(resultado);
            }
        } catch (DAOException e) {
            System.out.println("Error al buscar gasto en base de datos");
            e.printStackTrace();
        }
        return gasto;
    }

    public Gasto modificarGasto(GastoDTO gastoCambiado) {
        Gasto gastoModificado = null;
        try {
            GastoDTO resultado = this.gastosDAO.modificar(gastoCambiado);
            if (resultado != null) {
                gastoModificado = this.mappeo(resultado);
            }
        } catch (DAOException e) {
            System.out.println("Error al insertar nueva gasto en base de datos");
            e.printStackTrace();
        }
        return gastoModificado;
    }

    public String borrarGasto(int id) {
        try {
            gastosDAO.eliminar(id);
        } catch (DAOException e) {
            System.out.println("Error al borrar  gasto en base de datos");
            e.printStackTrace();
            return "Error al eliminar gasto";
        }
        return "Gasto eliminado exitosamente";
    }
}