package bun.ui;

public class DeleteCommand extends Command {
    private final int index;

    public DeleteCommand(int index) {
        super(false);
        this.index = index;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws InvalidIndexException {
        Task task = taskList.deleteTask(index);
        ui.printDeleteTaskMessage(task, taskList.getSize());
    }
}
