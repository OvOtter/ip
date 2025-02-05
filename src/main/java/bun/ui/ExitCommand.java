package bun.ui;

public class ExitCommand extends Command {
    public ExitCommand() {
        super(true);
    }
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showEndOfConversation();
    }
}
