package bun.ui;

public class ListCommand extends Command {
    /**
     * Constructs a new instance of `ListCommand`.
     */
    public ListCommand() {
        super(false);
    }

    /**
     * Execute the command by printing out the current taskList.
     *
     * @param taskList TaskList to be printed by the command.
     * @param ui       Ui to be updated by the command.
     * @param storage  Storage to be updated by the command (not used).
     */
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.printList(taskList);
    }
}
