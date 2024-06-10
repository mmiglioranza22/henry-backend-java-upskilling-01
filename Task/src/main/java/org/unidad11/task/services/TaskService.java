package org.unidad11.task.services;

import org.unidad11.task.entities.Task;

public interface TaskService {
    public void addTask(Task task);
    public void listTasks();
    public Task getTask(int id);
}