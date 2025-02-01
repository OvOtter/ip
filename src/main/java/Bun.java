import java.util.Scanner;

public class Bun {

    private final TaskList taskList;
    private final Storage storage;
    private final Ui ui;

    public Bun(String filePath) {
        TaskList taskList1;
        this.ui = new Ui();
        this.storage = new Storage(filePath);
        try {
            taskList1 = new TaskList(this.storage.load());
        } catch (BunException e) {
            ui.showLoadingError();
            taskList1 = new TaskList();
        }
        this.taskList = taskList1;
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                Scanner scanner = new Scanner(System.in);
                String[] fullCommand = ui.readCommand(scanner);
                Command c = Parser.parse(fullCommand);
                c.execute(taskList, ui, storage);
                isExit = c.isExit();
            } catch (BunException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Bun("data/tasks.txt").run();
    }
}
