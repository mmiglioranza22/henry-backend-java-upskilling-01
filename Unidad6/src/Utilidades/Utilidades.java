package Utilidades;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Utilidades<T extends Comparable<T>> {

    List<T> lista;
    T obj;

    public Utilidades() {
        this.lista = new ArrayList<T>();
    }

    public void add(T input) {
        this.lista.add(input);
    }


    public void printList() {
        lista.forEach(System.out::println);
    }

    public T max(List<? extends T> lista) {
        T max = lista.get(0);
        for (T el : lista) {
            if (el.compareTo(max) > 0) {
                max = el;
            }
        }
        return max;
    }

//    public List<? super T> convertTo() {
//        List<? super T> r = this.lista;
//        return r;
//    }

    public static <T extends List> void imprimirElementos(T elementos) {
        elementos.forEach(System.out::println);
    }

    public static <T> List<? super T> copiarElementos(List<T> lista) {
        List<? super T> destino = lista;
        return destino;

    }

    public List<? super T> copiarElementosWild(List<? super T> lista) {
        List<? super T> destino = lista;
        return destino;

    }


}
