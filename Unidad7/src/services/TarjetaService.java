package services;


import dao.TarjetaDebitoDAO;
import dto.TarjetaDTO;
import impl.TarjetaCreditoDAOImpl;
import impl.TarjetaDebitoDAOImpl;

import java.sql.Connection;
import java.util.List;

public class TarjetaService {

    Connection connection;
    public TarjetaDebitoDAOImpl debito;
    public TarjetaCreditoDAOImpl credito;

    public TarjetaService(Connection connection) {
        this.debito = new TarjetaDebitoDAOImpl(connection);
        this.credito = new TarjetaCreditoDAOImpl(connection);
    }


    public List<TarjetaDTO> getTarjetasDebito() {
        return this.debito.getTarjetas();

    }

    public List<TarjetaDTO> getTarjetasCredito() {
        return this.credito.getTarjetas();

    }

    public TarjetaDTO getTarjetaCredito(Integer id) {
        return this.debito.getTarjeta(id);

    }

    public TarjetaDTO getTarjetaDebito(Integer id) {
        return this.credito.getTarjeta(id);

    }
}
