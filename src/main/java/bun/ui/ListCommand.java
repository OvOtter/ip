package bun.ui;

public class ListCommand extends Command {
    public ListCommand() {
        super(false);
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.printList(taskList);
    }
}
