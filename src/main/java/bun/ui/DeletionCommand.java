package bun.ui;

public class DeletionCommand extends Command {
    private final int index;

    /**
     * Constructs a new instance of `DeletionCommand` with the specified parameters.
     *
     * @param index Index of the task to be deleted.
     */
    public DeletionCommand(int index) {
        super(false);
        this.index = index;
    }

    /**
     * Execute the command by deleting its task from the taskList.
     *
     * @param taskList TaskList to be updated by the command.
     * @param ui       Ui to be updated by the command.
     * @param storage  Storage to be updated by the command (not used).
     * @throws InvalidIndexException If index of command is out of bound.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws InvalidIndexException {
        Task task = taskList.deleteTask(index);
        ui.printDeleteTaskMessage(task, taskList.getSize());
        storage.save(taskList);
    }
}
