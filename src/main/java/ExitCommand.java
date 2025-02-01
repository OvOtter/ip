public class ExitCommand extends Command {
    public ExitCommand() {
        super(true);
    }
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showEndOfConversation();
    }
}
