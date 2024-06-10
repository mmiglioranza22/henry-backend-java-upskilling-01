import Persona.Persona;
import PersonaManager.PersonaManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Persona> lista = new ArrayList<Persona>();

        lista.add(new Persona("Juan", 22, "Padel"));
        lista.add(new Persona("Jorge", 21, "Tenis"));
        lista.add(new Persona("Maria", 18, "programar"));
        lista.add(new Persona("Cacho", 15, "Ajedrez, programar"));
        lista.add(new Persona("Manuel", 31, "Padel, programar"));
        lista.add(new Persona("Sofia", 31, "programar"));
        lista.add(new Persona("Manuel", 28, "Padel, programar"));
        lista.add(new Persona("Agustin", 21, "Padel, programar"));
        lista.add(new Persona("Santiago", 32, "Padel, programar"));
        lista.add(new Persona("Tomas", 31, "Padel, programar"));

        List<String> listaManipulada = lista.stream()
                .filter(persona -> persona.getEdad() > 18 && persona.getHobby().contains("programar"))
                .map(persona -> persona.getNombre())
                .limit(5)
                .collect(Collectors.toList());

        listaManipulada.forEach(System.out::println);

        System.out.println("======================");

        List<String> listaManipulada2 = lista.stream()
                .filter(PersonaManager::filtrarEdadYHobby)
                .map(PersonaManager::mapearNombre)
                .limit(5)
                .toList();

        listaManipulada2.forEach(System.out::println);


    }
}