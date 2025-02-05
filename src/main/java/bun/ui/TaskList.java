package bun.ui;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> taskList;

    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public void addTask(Task task) {
        this.taskList.add(task);
    }

    public Task deleteTask(int index) throws InvalidIndexException {
        Task taskToDelete;
        try {
            taskToDelete = this.taskList.get(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidIndexException(index + 1, this.taskList.size());
        }
        this.taskList.remove(index);
        return taskToDelete;
    }

    public Task markTask(int index) throws InvalidIndexException {
        Task curTask;
        try {
            curTask = this.taskList.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidIndexException(index + 1, this.taskList.size());
        }
        curTask.markAsDone();
        return curTask;
    }

    public Task unmarkTask(int index) throws InvalidIndexException {
        Task curTask;
        try {
            curTask = this.taskList.get(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidIndexException(index + 1, this.taskList.size());
        }
        curTask.markAsNotDone();
        return curTask;
    }

    public TaskList filterByWord(String word) {
        ArrayList<Task> filteredTaskList = new ArrayList<>();
        for (Task task : this.taskList) {
            if (task.containsKeyword(word)) {
                filteredTaskList.add(task);
            }
        }
        return new TaskList(filteredTaskList);
    }

    public int getSize() {
        return this.taskList.size();
    }

    public boolean isEmpty() {
        return this.taskList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder taskListDisplay = new StringBuilder();
        int index = 1;
        for (Task task : this.taskList) {
            taskListDisplay.append("      ").append(index).append(". ").append(task.toString()).append("\n");
            index++;
        }
        return taskListDisplay.toString();
    }

    public String toStoredContent() {
        StringBuilder taskListstored = new StringBuilder();
        for (Task task : this.taskList) {
            taskListstored.append(task.getStoredString());
            taskListstored.append("\n");
        }
        return taskListstored.toString();
    }
}
