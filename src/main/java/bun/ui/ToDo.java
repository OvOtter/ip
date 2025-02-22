package bun.ui;

public class ToDo extends Task {
    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    public String getStoredString() {
        return String.format("T | %s", super.getStoredString());
    }
}
