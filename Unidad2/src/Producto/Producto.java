package Producto;

public class Producto implements Comparable<Producto> {
    private String nombre;
    private double precio;
    private String codigo;

    public Producto(String nombre, double precio, String codigo) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
    }

    public int compareTo(Producto prod1) {
        return (int) (this.getPrecio() - prod1.getPrecio());
    }

    public boolean esVendible() {
        Filtrable vendible = producto1 -> producto1.getPrecio() > 0;
        return vendible.cumpleFiltro(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
