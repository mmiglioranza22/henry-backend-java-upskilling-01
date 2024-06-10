package services;

import dao.dto.GastoDTO;
import dao.impl.GastoDAOImpl;
import entities.Categoria;
import entities.Gasto;
import exceptions.DAOException;

import java.sql.PreparedStatement;
import java.util.List;

//throws custom exception
//ver video sobre bdII
public class GastosService {
    private GastoDAOImpl gastosDAO;

    public GastosService(GastoDAOImpl gastosDAO) {
        this.gastosDAO = gastosDAO;
    }

    public Gasto buscarGasto(int id) {
        Gasto gasto = null;
        try {
            GastoDTO resultado = this.gastosDAO.buscarOperacion(id);
            if (resultado != null) {
                gasto = this.mappeo(resultado);
            }
        } catch (DAOException e) {
            System.out.println("Error al buscar gasto en base de datos");
            e.printStackTrace();
        }
        return gasto;
    }


    public List<Gasto> buscarGastos() {
        List<Gasto> lista = null;
        try {
            List<GastoDTO> resultado = this.gastosDAO.buscarOperaciones();
            if (resultado != null) {
                lista = resultado.stream().map(gasto -> this.mappeo(gasto)).toList();
            }
        } catch (DAOException e) {
            System.out.println("Error al buscar gasto en base de datos");
            e.printStackTrace();
        }
        return lista;
    }

    private Gasto mappeo(GastoDTO resultado) {
        Gasto gasto = new Gasto(resultado.getCategoriaId(), resultado.getCategoria(), resultado.getMonto(), resultado.getFecha(), resultado.isEsRecurrente());
        gasto.setId(resultado.getId());
        return gasto;
    }

    public Gasto crearGasto(GastoDTO nuevoGasto) {
        Gasto gastoCreado = null;
        try {
            gastosDAO.insertarOperacion(nuevoGasto);
            gastoCreado = new Gasto(nuevoGasto.getCategoriaId(), nuevoGasto.getCategoria(), nuevoGasto.getMonto(), nuevoGasto.getFecha(), nuevoGasto.isEsRecurrente());
        } catch (DAOException e) {
            System.out.println("Error al insertar nueva gasto en base de datos");
            e.printStackTrace();
        }
        return gastoCreado;
    }

    public Gasto modificarGasto(GastoDTO gastoCambiado) {
        Gasto gasto = null;
        try {
            gastosDAO.modificarOperacion(gastoCambiado);
            gasto = new Gasto(gastoCambiado.getCategoriaId(), gastoCambiado.getCategoria(), gastoCambiado.getMonto(), gastoCambiado.getFecha(), gastoCambiado.isEsRecurrente());
            gasto.setId(gastoCambiado.getId());
        } catch (DAOException e) {
            System.out.println("Error al insertar nueva gasto en base de datos");
            e.printStackTrace();
        }
        return gasto;
    }

    public String borrarGasto(int id) {
        try {
            gastosDAO.eliminarOperacion(id);
        } catch (DAOException e) {
            System.out.println("Error al borrar  gasto en base de datos");
            e.printStackTrace();
            return "Error al eliminar gasto";
        }
        return "Gasto eliminado exitosamente";
    }
}
