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
        } catch (ArrayIndexOutOfBoundsException e) {
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

    public int getSize() {
        return this.taskList.size();
    }

    public boolean isEmpty() {
        return this.taskList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Task task : this.taskList) {
            sb.append("      ");
            sb.append(task.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String toStoredContent() {
        StringBuilder sb = new StringBuilder();
        for (Task task : this.taskList) {
            sb.append(task.getStoredString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
