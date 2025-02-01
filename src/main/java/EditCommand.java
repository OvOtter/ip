public class EditCommand extends Command {
    private final boolean isMarkOperation;
    private final int index;

    public EditCommand(boolean isMarkOperation, int index) {
        super(false);
        this.isMarkOperation = isMarkOperation;
        this.index = index;
    }

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
