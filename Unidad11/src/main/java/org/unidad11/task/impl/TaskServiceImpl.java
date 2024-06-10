package org.unidad11.task.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unidad11.task.entities.Task;
import org.unidad11.task.services.ITaskService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements ITaskService {
    private List<Task> tasks;

    public TaskServiceImpl() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public void addTask(Task task) {
        System.out.println("Se agregó un task:");
        System.out.println(task.toString());
        tasks.add(task);
    }

    @Override
    public void listTasks() {
        System.out.println("Tareas ingresadas:");
        tasks.forEach(el -> System.out.println(el.toString()));
    }

    @Override
    public Task getTask(int index) {
        System.out.println("Buscando tarea...");
        Task task = tasks.get(index);
        return task;
    }
}
