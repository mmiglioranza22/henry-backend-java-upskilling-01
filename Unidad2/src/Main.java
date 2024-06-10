import Circulo.Circulo;
import Producto.Producto;

import java.util.*;

public class Main {
    public static void main(String[] args) {

//  Ejercicio del círculo
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Ingrese un número entero:");
//        int r = scanner.nextInt();
//        double area = Circulo.calcularArea(r);
//        System.out.println("El area del círculo con radio " + r + " es: " + area);
//        scanner.close();

// Ejercicio de manipulación de Strings
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Ingrese una frase");
//        String input = scanner.nextLine();
//
//        Frase frase = new Frase(input);
//        int len = frase.caracteres();
//        System.out.println("Cantidad de characteres: " + len);
//        String contieneHola = frase.contieneHola();
//        System.out.println("Contiene la frase \"Hola\": " + contieneHola);
//        String min = frase.getFrase().toLowerCase();
//        System.out.println("Minúscula: " + min);
//        String cap = frase.getFrase().toUpperCase();
//        System.out.println("Mayúscula: " + cap);
//        String primerFrase = frase.primerFrase();
//        System.out.println("Primer frase: " + primerFrase);
//        String daleBoca = frase.getFrase().concat(" Dale boca");
//        System.out.println("Dale boca: " + daleBoca);


//        Ejercicio con interfaces


        Producto p1 = new Producto("taza", 4.0, "123456");
        Producto p2 = new Producto("vaso", 3.0, "123455");
        Producto p3 = new Producto("cuchara", 1.5, "123454");
        Producto p4 = new Producto("aire", 0, "123458");

        Producto[] productos = {p1, p2, p3, p4};
        List<Producto> lista = Arrays.asList(productos);

        System.out.println("Lista inicial:");
        lista.forEach(p -> System.out.println("Producto: " + p.getNombre() + ", precio: " + p.getPrecio() + ", código: " + p.getCodigo()));

        System.out.println();
        Collections.sort(lista);

        System.out.println("Lista ordenada:");
        lista.forEach(p -> System.out.println("Producto: " + p.getNombre() + ", precio: " + p.getPrecio() + ", código: " + p.getCodigo()));
        System.out.println();


        System.out.println("Lista productos vendibles:");

        lista.stream().filter(p -> p.esVendible()).forEach(p -> System.out.println("Producto: " + p.getNombre() + ", precio: " + p.getPrecio() + ", código: " + p.getCodigo()));


    }
}