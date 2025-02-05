package bun.ui;

public class EditCommand extends Command {
    private final boolean isMarkOperation;
    private final int index;

    /**
     * Constructs a new instance of `EditCommand` with the specified parameters.
     *
     * @param task Task to be marked/unmarked.
     */
    public EditCommand(boolean isMarkOperation, int index) {
        super(false);
        this.isMarkOperation = isMarkOperation;
        this.index = index;
    }

    /**
     * Execute the command by marking or unmarking the task in the taskList.
     *
     * @param taskList TaskList to be updated by the command.
     * @param ui Ui to be updated by the command.
     * @param storage Storage to be updated by the command.
     * @throws InvalidIndexException If index is out of bound.
     */
    public void execute(TaskList taskList, Ui ui, Storage storage) throws InvalidIndexException {
        if (this.isMarkOperation) {
            Task task = taskList.markTask(this.index);
            ui.printMarkTaskMessage(task);
        }
        else {
            Task task = taskList.unmarkTask(this.index);
            ui.printUnmarkTaskMessage(task, taskList.getSize());
        }
        storage.save(taskList);
    }
}
