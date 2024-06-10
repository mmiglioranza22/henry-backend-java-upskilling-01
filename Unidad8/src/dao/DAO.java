package dao;

import dao.dto.EmpleadoDTO;
import entities.Empleado;

public interface DAO {
    public Empleado getEmpleado(int id);

    public Empleado insertar(EmpleadoDTO empleado);

    public Empleado modificar(EmpleadoDTO empleado);

    public void borrar(int id);
}
