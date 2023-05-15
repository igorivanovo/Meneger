package ru.netology.javacore;

import java.util.*;

public class Todos {
    private Deque<String> stack = new ArrayDeque<>();
    private List<String> task = new ArrayList<>();
    public static final int MAX_TASKS = 7;

    public Deque<String> getStack() {
        return stack;
    }

    public List<String> getTask() {
        return task;
    }

    public void addTask(String task) {
        if (this.task.size() < MAX_TASKS) {
            this.task.add(task);
            this.stack.offer("ADD " + task);
        }
    }

    public void removeTask(String task) {
        this.task.remove(task);
        this.stack.offer("REMOVE " + task);
    }

    public void restoreTask() {
        String restore = stack.pollLast();
        String[] rest = restore.split(" ");
        String task = rest[1];
        String type = rest[0];
        if (type.equals("ADD")) {
            this.task.remove(task);
        } else if (type.equals("REMOVE")) {
            this.task.add(task);
        }
    }

    public String getAllTasks() {
        StringBuilder stringBuilder = new StringBuilder();
        String[] allTasks = task.toArray(new String[0]);
        Arrays.sort(allTasks);
        for (String task : allTasks) {
            stringBuilder.append(" " + task);
        }
        String allTask = stringBuilder.toString();
        return allTask;
    }
}
