package org.unidad11.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.unidad11.task.entities.Task;
import org.unidad11.task.services.ITaskService;

import java.util.Date;

@SpringBootApplication
public class TaskApplication implements CommandLineRunner {

    @Autowired
    private ITaskService taskService;

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Task tarea = new Task(1, "first task", "desc", new Date());
        Task tarea2 = new Task(2, "second task", "desc", new Date());

        taskService.addTask(tarea);
        taskService.addTask(tarea2);

        taskService.listTasks();

        Task tareaBuscada = taskService.getTask(1);
        System.out.println("Tarea encontrada!");
        System.out.println(tareaBuscada.toString());

    }
}
