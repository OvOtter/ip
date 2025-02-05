package bun.ui;

public abstract class Command {
    private final boolean isExit;

    public Command(boolean isExit) {
        this.isExit = isExit;
    }

    public boolean isExit() {
        return isExit;
    }

    abstract void execute(TaskList taskList, Ui ui, Storage storage) throws InvalidIndexException;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Command command) {
            return isExit == command.isExit;
        } else return false;
    }
}