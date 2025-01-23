import java.util.Scanner;
import java.util.ArrayList;

public class Bun {
    private final static String name = "Bun";
    private final static String logo = """
                .-. .-')                    .-') _ \s
                \\  ( OO )                  ( OO ) )\s
                 ;-----.\\  ,--. ,--.   ,--./ ,--,' \s
                 | .-.  |  |  | |  |   |   \\ |  |\\ \s
                 | '-' /_) |  | | .-') |    \\|  | )\s
                 | .-. `.  |  |_|( OO )|  .     |/ \s
                 | |  \\  | |  | | `-' /|  |\\    |  \s
                 | '--'  /('  '-'(_.-' |  | \\   |  \s
                 `------'   `-----'    `--'  `--'  \s
        """;

    private final ArrayList<Task> taskList;

    public Bun() {
        this.taskList = new ArrayList<>();
    }

    private static void intro() {
        System.out.println("    Hello from\n" + logo);
        System.out.println("    Hello! I'm " + name + ".\n" +
                "    What can I do for you?");
    }

    private static void printAddTaskMessage(Task task, int taskCount) {
        System.out.println("     Got it. I've added this task:\n" +
                "       " + task + "\n" +
                "     Now you have " + taskCount + " tasks in the list.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bun bun = new Bun();

        intro();

        label:
        while (true) {
            String instruction = scanner.next();
            switch (instruction) {
                case "bye":
                    System.out.println("    Bye. Hope to see you again soon!");
                    break label;
                case "list":
                    System.out.println("    (ง'̀-'́)ง Here are the tasks in your list:");
                    for (int i = 0; i < bun.taskList.size(); i++) {
                        System.out.println("    " + (i + 1) + ". " + bun.taskList.get(i));
                    }
                    scanner.nextLine();
                    break;
                case "mark": {
                    int index = Integer.parseInt(scanner.nextLine().trim()) - 1;
                    Task curTask = bun.taskList.get(index);
                    curTask.markAsDone();
                    System.out.println("    Nice (*>ω<) I've marked this task as done:\n      " + curTask);
                    break;
                }
                case "unmark": {
                    int index = Integer.parseInt(scanner.nextLine().trim()) - 1;
                    Task curTask = bun.taskList.get(index);
                    curTask.markAsNotDone();
                    System.out.println("    OK (`･ω･´) I've marked this task as not done yet:\n      " + curTask);
                    break;
                }
                case "todo": {
                    String description = scanner.nextLine().trim();
                    ToDo toDo = new ToDo(description);
                    bun.taskList.add(toDo);
                    printAddTaskMessage(toDo, bun.taskList.size());
                    break;
                }
                case "deadline": {
                    String[] content = scanner.nextLine().trim().split(" /by ");
                    String description = content[0].trim();
                    String date = content[1].trim();
                    Deadline deadline = new Deadline(description, date);
                    bun.taskList.add(deadline);
                    printAddTaskMessage(deadline, bun.taskList.size());
                    break;
                }
                case "event": {
                    String[] content = scanner.nextLine().trim().split(" /from | /to ");
                    String description = content[0].trim();
                    String start = content[1].trim();
                    String end = content[2].trim();
                    Event event = new Event(description, start, end);
                    bun.taskList.add(event);
                    printAddTaskMessage(event, bun.taskList.size());
                    break;
                }

            }
        }
    }
}
