import config.JDBCConfiguration;
import controller.CategoriaController;
import controller.GastosController;
import dao.dto.CategoriaDTO;
import dao.dto.GastoDTO;
import dao.impl.CategoriaDAOImpl;
import dao.impl.GastoDAOImpl;
import services.CategoriasService;
import services.GastosService;
import utils.UtilidadOperacion;
import entities.Categoria;
import entities.Gasto;
import entities.Usuario;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Connection connection = testDB();

//       La creacion de un gasto nuevo implica: buscar si la categoria exista, y si no, crearla
//       esto es logica de negocio, por lo que debe encargarse el servicio de categoria.
//       https://stackoverflow.com/questions/35776848/dtos-dao-or-service-layer

        CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl(connection);
        CategoriasService categoriasService = new CategoriasService(categoriaDAO);
        CategoriaController categoriaController = new CategoriaController(categoriasService);

        GastoDAOImpl gastoDAO = new GastoDAOImpl(connection);
        GastosService gastosService = new GastosService(gastoDAO);
        GastosController gastosController = new GastosController(gastosService);

//        CREATE
        categoriaController.crearCategoria("comida");
        categoriaController.crearCategoria("música");

//        READ
        String nombreCategoria = "deporte";
        Categoria categoria = categoriaController.buscarCategoria(nombreCategoria);

        if (categoria == null) {
            System.out.println("Categoria no existente");
            CategoriaDTO nuevaCategoria = new CategoriaDTO(nombreCategoria);
            categoria = categoriaController.crearCategoria(nuevaCategoria);
            if (categoria != null) {
                System.out.println("Buscando id de categoría");
                categoria = categoriaController.buscarCategoria(nombreCategoria);
            }
        }

//        DELETE
//        categoriaController.borrarCategoria("música");
//        categoriaController.borrarCategoria(1);
        
//        ====================

//        CREATE

        GastoDTO nuevoGasto = new GastoDTO(categoria.getNombre(), categoria.getId(), 100.0, new Date(), false);
        Gasto gasto = gastosController.crearGasto(nuevoGasto);
        GastoDTO nuevoGasto2 = new GastoDTO(categoria.getNombre(), categoria.getId(), 200, new Date(), true);
        Gasto gasto2 = gastosController.crearGasto(nuevoGasto2);

//        Read all
//        List<Categoria> list = categoriaController.buscarCategorias();
//        if (list.size() > 0) {
//            list.forEach(el -> System.out.println(el.toString()));
//        }


//        READ
//        Gasto gastoBuscado = gastosController.buscarGasto(2);
//
//        if (gastoBuscado != null) {
//            System.out.println("gasto buscado");
//            System.out.println(gastoBuscado.toString());
//        }
//        List<Gasto> listaGastos = gastosController.buscarGastos();
//
//        if (listaGastos.size() > 0) {
//            listaGastos.forEach(el -> System.out.println(el.toString()));
//        }

//        Update
//        GastoDTO input = new GastoDTO();
//        input.setId(gastoBuscado.getId());
//        input.setMonto(250.0);
//
//        Gasto gastoModificado = gastosController.modificarGasto(input);
//        if (gastoModificado != null) {
//            System.out.println(gastoModificado.toString());
//        }

//        Delete
//        System.out.println(gastosController.borrarGasto(1));

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection testDB() {
        Connection connection = JDBCConfiguration.getDBConnection();
        if (connection != null) {
            JDBCConfiguration.init(connection);
        }
        return connection;
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        UtilidadOperacion listaGastos = new UtilidadOperacion<Gasto>();

        Usuario usuario;
        boolean continuar = true;
        System.out.println("Bienvenido. Por favor identifíquese:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        usuario = new Usuario(nombre);
        System.out.println("Hola " + usuario.getNombre() + ".\nDesea ingresar un gasto? (SI / NO)");

        continuar = scanner.next().toUpperCase().trim().equals("SI");
        while (continuar) {
            try {
                scanner.nextLine();
                System.out.println("Ingrese la categoría del gasto:");
                String categoria = scanner.nextLine();
                System.out.println("Ingrese el monto del gasto:");
                double monto = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Ingrese la fecha del gasto (dd/mm/yyyy):");
                String dateStr = scanner.next();
                scanner.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date date = sdf.parse(dateStr);
                System.out.println("El gasto es recurrente? (SI / NO):");
                boolean esRecurrente = scanner.nextLine().toUpperCase().trim().equals("SI");
                listaGastos.registrarOperacion(new Gasto(categoria, monto, date, esRecurrente, new Usuario()));
                System.out.println("Gasto ingresado con éxito.");

                System.out.println("Desea ingresar otro gasto? (SI / NO)");
                continuar = scanner.next().toUpperCase().trim().equals("SI");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        if (Categoria.registroCategorias.isEmpty()) {
            System.out.println();
            System.out.println("Adios");
        } else {
            System.out.println("Usted ingresó estos gastos");
            listaGastos.imprimirOperaciones();
            Categoria.listarCategorias();
            System.out.println();
            System.out.println("Adios");
            scanner.close();
            return;
        }
    }
}