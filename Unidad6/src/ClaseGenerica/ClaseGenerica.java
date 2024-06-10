package ClaseGenerica;

import java.util.List;

public class ClaseGenerica<T extends List> {

    public T lista;
    
    public void imprimirElementos() {
        lista.forEach(System.out::println);
    }

}


