package PersonaManager;

import Persona.Persona;

import java.util.List;
import java.util.stream.Stream;

public class PersonaManager {
    public static boolean filtrarEdadYHobby(Persona persona) {
        return persona.getEdad() > 18 && persona.getHobby().contains("programar");
    }

    public static String mapearNombre(Persona persona) {
        return persona.getNombre();
    }
}
