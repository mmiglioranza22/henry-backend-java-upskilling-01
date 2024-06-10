package entities;

import java.util.HashMap;
import java.util.Map;

//modificar para instanciar
public class Categoria {
    private int id;
    private String nombre;
    public static Map<String, Integer> registroCategorias = new HashMap<>();

    public Categoria() {
    }

    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public static void agregarNuevaCategoria(String categoria) {
        registroCategorias.put(categoria, registroCategorias.getOrDefault(categoria, 0) + 1);
    }

    public static void listarCategorias() {
        System.out.println("Las categorías ingresadas son las siguientes:");
        for (String key : registroCategorias.keySet()) {
            System.out.println(key + " : " + registroCategorias.get(key));
        }
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
