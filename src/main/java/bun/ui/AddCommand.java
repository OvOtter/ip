package bun.ui;

public class AddCommand extends Command {
    private final Task task;

    public AddCommand(Task task) {
        super(false);
        this.task = task;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.addTask(this.task);
        ui.printAddTaskMessage(this.task, taskList.getSize());
        storage.save(taskList);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof AddCommand cmd) {
            return this.task.equals(cmd.task);
        }
        return false;
    }
}
