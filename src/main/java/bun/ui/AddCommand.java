package bun.ui;

public class AddCommand extends Command {
    private final Task task;

    /**
     * Constructs a new instance of `AddCommand` with the specified parameters.
     *
     * @param task Task to be added.
     */
    public AddCommand(Task task) {
        super(false);
        this.task = task;
    }

    /**
     * Execute the command by adding its task to the taskList.
     *
     * @param taskList TaskList to be updated by the command.
     * @param ui Ui to be updated by the command.
     * @param storage Storage to be updated by the command (not used).
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.addTask(this.task);
        ui.printAddTaskMessage(this.task, taskList.getSize());
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof AddCommand cmd) {
            return this.task.equals(cmd.task);
        }
        return false;
    }
}
