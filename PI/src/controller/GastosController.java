package controller;

import dao.dto.GastoDTO;
import entities.Gasto;
import services.GastosService;

import java.util.List;

// https://stackoverflow.com/questions/45490749/service-and-dao-vs-mvc
public class GastosController {
    private GastosService service;

    public GastosController(GastosService service) {
        this.service = service;
    }

    public Gasto buscarGasto(int id) {
        return this.service.buscarGasto(id);
    }

    public List<Gasto> buscarGastos() {
        return this.service.buscarGastos();
    }

    public Gasto crearGasto(GastoDTO nuevoGasto) {
        return this.service.crearGasto(nuevoGasto);
    }

    public Gasto modificarGasto(GastoDTO nuevoGasto) {
        return this.service.modificarGasto(nuevoGasto);
    }

    public String borrarGasto(int id) {
        return this.service.borrarGasto(id);
    }
}
