package bun.ui;

import java.util.Scanner;

public class Ui {
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

    public void showWelcome() {
        System.out.println("    Hello from\n" + logo);
        System.out.println("    Hello! I'm " + name + ".\n" +
                "    What can I do for you?");
    }

    public void showEndOfConversation() {
        System.out.println("    Bye. Hope to see you again soon!");
    }

    public void showLoadingError() {
        System.out.println("    Sorry, bun couldn't be loaded.");
    }

    public String[] readCommand(Scanner scanner) throws InvalidCommandException {
        String line = scanner.nextLine().trim(); // Read full line
        String[] parts = line.split("\\s+", 2);
        if (parts.length == 1) {
            return new String[]{parts[0]}; // No arguments
        } else {
            return new String[]{parts[0], parts[1]}; // Command + Arguments
        }
    }

    public void printAddTaskMessage(Task task, int taskCount) {
        System.out.println("    Got it. I've added this task:\n" +
                "      " + task + "\n" +
                "    Now you have " + taskCount + " task(s) in the list.");
    }

    public void printDeleteTaskMessage(Task task, int taskCount) {
        System.out.println("     Noted. I've removed this task:\n" +
                "       " + task + "\n" +
                "     Now you have " + taskCount + " task(s) in the list.");
    }

    public void printMarkTaskMessage(Task task) {
        System.out.println("    OK D: I've marked this task as not done yet:\n      " + task);
    }

    public void printUnmarkTaskMessage(Task task, int taskCount) {
        System.out.println("     Noted. I've removed this task:\n" +
                "       " + task + "\n" +
                "     Now you have " + taskCount + " task(s) in the list.");
    }

    public void showError(String error) {
        System.out.println("    Bun is facing some error: \n" + error);
    }

    public void printList(TaskList taskList) {
        if (taskList.isEmpty()) {
            System.out.println("    No tasks are stored.");
        } else {
            System.out.println("    Here are the tasks in your list:");
            System.out.print(taskList);
        }
    }
}
