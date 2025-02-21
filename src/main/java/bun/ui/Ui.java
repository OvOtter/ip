package bun.ui;

import java.util.Scanner;

public class Ui {
    private static final String name = "Bun";
    private static final String logo = """
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

    /**
     * Prints the opening message.
     */
    public void showWelcome() {
        System.out.println("    Hello from\n" + logo);
        System.out.println("    Hello! I'm " + name + ".\n"
                + "    What can I do for you?");
    }

    /**
     * Prints the farewell message when the conversation is ended by the user.
     */
    public void showEndOfConversation() {
        System.out.println("    Bye. Hope to see you again soon!");
    }

    /**
     * Prints the error message if the bot fails to load.
     */
    public void showLoadingError() {
        System.out.println("    Sorry, bun couldn't be loaded.");
    }

    /**
     * Reads the commands from user input.
     *
     * @param scanner Scanner to read the user input.
     * @return Array of String which stores the command word and following details (if any) separately
     */
    public String[] readCommand(Scanner scanner) {
        String line = scanner.nextLine().trim(); // Read full line
        String[] parts = line.split("\\s+", 2);
        if (parts.length == 1) {
            return new String[]{parts[0]}; // No arguments
        } else {
            return new String[]{parts[0], parts[1]}; // Command + Arguments
        }
    }

    /**
     * Prints the notification message after a task is successfully added.
     *
     * @param task Task added.
     */
    public void printAddTaskMessage(Task task, int taskCount) {
        System.out.println("    Got it. I've added this task:\n"
                + "      " + task + "\n"
                + "    Now you have " + taskCount + " task(s) in the list.");
    }

    /**
     * Prints the notification message after a task is successfully removed.
     *
     * @param task Task removed.
     */
    public void printDeleteTaskMessage(Task task, int taskCount) {
        System.out.println("     Noted. I've removed this task:\n"
                + "       " + task + "\n"
                + "     Now you have " + taskCount + " task(s) in the list.");
    }

    /**
     * Prints the notification message after a task is successfully marked as done.
     *
     * @param task Task marked.
     */
    public void printMarkTaskMessage(Task task) {
        System.out.println("    OK :D I've marked this task as done:\n      " + task);
    }

    /**
     * Prints the notification message after a task is successfully unmarked as not done.
     *
     * @param task Task unmarked.
     */
    public void printUnmarkTaskMessage(Task task) {
        System.out.println("    OK D: I've marked this task as not done yet:\n      " + task);
    }

    /**
     * Prints the notification message after a task is successfully added.
     *
     * @param error Error message.
     */
    public void showError(String error) {
        System.out.println("    Bun is facing some error: \n" + error);
    }

    /**
     * Prints current list of tasks.
     *
     * @param taskList taskList List of active tasks.
     */
    public void printList(TaskList taskList) {
        if (taskList.isEmpty()) {
            System.out.println("    No tasks yet.");
        } else {
            System.out.println("    Here are the tasks in your list:");
            System.out.print(taskList);
        }
    }

    /**
     * Prints list of tasks in response to FIND command.
     *
     * @param taskList List of tasks found.
     */
    public void printFound(TaskList taskList) {
        if (taskList.isEmpty()) {
            System.out.println("    No matching task is found.");
        } else {
            System.out.println("    Here are the matching tasks in your list:");
            System.out.print(taskList);
        }
    }
}
