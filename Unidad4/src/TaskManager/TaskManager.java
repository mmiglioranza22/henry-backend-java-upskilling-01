package TaskManager;

import java.util.ArrayList;

import java.util.List;

public class TaskManager {
    public List<String> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<String>();
    }

    public void addTask(String task) {
        this.tasks.add(task);
    }

    public void markTaskAsCompleted(int index) {
        String task = this.tasks.get(index).concat(" [COMPLETED]");
        this.removeTask(index);
        this.tasks.add(index, task);
    }

    public void removeTask(int index) {
        this.tasks.remove(index);

    }

    public void printTaskList() {
        this.tasks.forEach(System.out::println);

        for (String task : this.tasks) {
            System.out.println(task);
        }

        for (int i = 0; i < this.tasks.size(); i++) {
            System.out.println(this.tasks.get(i));
        }
    }

}
