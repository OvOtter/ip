public class Task {

    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public static Task stringToTask(String storedTask) {
        String[] content = storedTask.split("\\s\\|\\s");
        if (content.length == 0) {
            return null;
        }

        Task taskToReturn = null;
        try {
            if (storedTask.charAt(0) == 'T') {
                taskToReturn = new ToDo(content[2]);
                if (content[1].equals("1")) {
                    taskToReturn.markAsDone();
                }
            } else if (storedTask.charAt(0) == 'D') {
                taskToReturn = new Deadline(content[2], content[3]);
                if (content[1].equals("1")) {
                    taskToReturn.markAsDone();
                }
            } else {
                assert(storedTask.charAt(0) == 'E');
                taskToReturn = new Event(content[2], content[3], content[4]);
                if (content[1].equals("1")) {
                    taskToReturn.markAsDone();
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid task: " + storedTask);
        }
        return taskToReturn;
    }

    protected String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void markAsNotDone() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", getStatusIcon(), this.description);
    }

    public String getStoredString() {
        if (isDone) {return "1 | " + description;}
        else {return "0 | " + description;}
    }
}
