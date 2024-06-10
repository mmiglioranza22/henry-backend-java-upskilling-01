package StudentRecord;

import java.util.HashMap;
import java.util.Map;

public class StudentRecord {

    public Map<String, Integer> record;

    public StudentRecord() {
        this.record = new HashMap<>();
    }

    public void addStudent(String name, Integer note) {
        this.record.put(name, note);
    }

    public void removeStudent(String name) {
        this.record.remove(name);
    }

    public void getGrade(String name) {
        System.out.println("La nota del alumno " + name + " es: " + this.record.get(name));
    }

    public void isStudentInRecord(String name) {
        String exists = this.record.containsKey(name) ? "Si" : "No";
        System.out.println("El alumno " + name + " existe en el registro de alumnos: " + exists);
    }

    public void example() {
        System.out.println("Existe la nota 6?: " + (this.record.containsValue(6) ? "Si" : "No"));
        System.out.println("Existe la nota 8?: " + (this.record.containsValue(6) ? "Si" : "No"));

        this.removeStudent("Juan");
        this.removeStudent("Jorge");

        System.out.println("Existe la nota 6?: " + (this.record.containsValue(6) ? "Si" : "No"));
        System.out.println("Existe la nota 8?: " + (this.record.containsValue(8) ? "Si" : "No"));

        System.out.println(this.record.keySet());
    }
}
