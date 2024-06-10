import PartyGuestList.PartyGuestList;
import StudentRecord.StudentRecord;
import TaskManager.TaskManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        1. Ejercicio de gestión de tareas:
//        TaskManager taskManager = new TaskManager();
//
//        taskManager.addTask("Boca");
//        taskManager.addTask("River");
//        taskManager.addTask("Deportivo parlantes");
//        taskManager.printTaskList();
//
//        taskManager.markTaskAsCompleted(1);
//        taskManager.printTaskList();
//
//        taskManager.removeTask(0);
//        taskManager.printTaskList();

//         2. Ejercicio de gestión de invitados a una fiesta:

//        PartyGuestList guestList = new PartyGuestList();
//
//        guestList.addGuest("Boca");
//        guestList.addGuest("River");
//        guestList.addGuest("Deportivo parlantes");
//        guestList.getTotalGuests();
//
//        guestList.printGuestsList();
//
//        guestList.isGuestInList("Boca");
//        guestList.removeGuest("Boca");
//        guestList.printGuestsList();
//
//        guestList.isGuestInList("Boca");
//        guestList.getTotalGuests();

//        3. Ejercicio de registro de alumnos y calificaciones:

        StudentRecord record = new StudentRecord();

        record.addStudent("Manu", 10);
        record.addStudent("Juan", 8);
        record.addStudent("Jorge", 6);
        record.addStudent("Cacho", 8);

        record.isStudentInRecord("Manu");
        record.getGrade("Juan");

        record.example();

    }
}