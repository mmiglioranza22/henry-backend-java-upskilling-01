import ClaseGenerica.ClaseGenerica;
import Utilidades.Utilidades;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        strings.add("Hola");
        strings.add("Mundo");
        integers.add(1);
        integers.add(2);

//Metodo genérico
        Utilidades.imprimirElementos(strings);
        Utilidades.imprimirElementos(integers);
        System.out.println(integers.getClass());

        List listaDestino = Utilidades.copiarElementos(integers);

        Utilidades.imprimirElementos(listaDestino);
        System.out.println(listaDestino.getClass());


        Utilidades<String> stringUtil = new Utilidades<String>();
        Utilidades<Integer> intUtil = new Utilidades<Integer>();

        stringUtil.add("Hola");
        stringUtil.add("Mundo");

        stringUtil.printList();
        intUtil.add(42);
        intUtil.add(69);

        intUtil.printList();
        String maxS = stringUtil.max(strings);
        Integer maxI = intUtil.max(integers);

        System.out.println(maxS);
        System.out.println(maxI);

    }
}