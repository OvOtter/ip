package bun.ui;

public class Parser {git cg
    /**
     * Returns the Command interpreted from the input instruction word and details (if any)
     *
     * @param fullCommand String array with at most 2 elements,
     *                    where the first element is the command/instruction word,
     *                    and the second element is the detail of the instruction (if any).
     * @return Command requested in the input.
     * @throws InvalidCommandException If the command word is missing or not one of the listed CommandWord.
     * @throws MissingFieldException   If any field for details is missing.
     * @throws DateFormatException     If the input date is not in YYYY-MM-DD format.
     */
    public static Command parse(String[] fullCommand) throws InvalidCommandException, MissingFieldException, DateFormatException {
        if (fullCommand == null || fullCommand.length == 0) {
            throw new InvalidCommandException("");
        }
        String instruction = fullCommand[0];
        CommandWord command;
        try {
            command = CommandWord.valueOf(instruction.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidCommandException(instruction);
        }
        switch (command) {
        case BYE:
            return new ExitCommand();
        case LIST: {
            return new ListCommand();
        }
        case MARK: {
            int index = Integer.parseInt(fullCommand[1]) - 1;
            return new EditCommand(true, index);
        }
        case UNMARK: {
            int index = Integer.parseInt(fullCommand[1]) - 1;
            return new EditCommand(false, index);
        }
        case REMOVE: {
            int index = Integer.parseInt(fullCommand[1]) - 1;
            return new DeletionCommand(index);
        }
        case TODO: {
            String description = fullCommand[1];
            if (description.isEmpty()) {
                throw new MissingFieldException("description");
            }
            return new AddCommand(new ToDo(description));
        }
        case DEADLINE: {
            String[] content = fullCommand[1].split(" /by ");
            if (content.length == 0 || content[0].trim().isEmpty()) {
                throw new MissingFieldException("description");
            } else if (content.length == 1) {
                throw new MissingFieldException("due date");
            }
            String description = content[0].trim();
            String date = content[1].trim();
            return new AddCommand(new Deadline(description, date));
        }
        case EVENT: {
            String[] content = fullCommand[1].split(" /from | /to ");
            if (content.length == 0 || content[0].trim().isEmpty()) {
                throw new MissingFieldException("description");
            } else if (content.length == 1 || content[1].trim().isEmpty()) {
                throw new MissingFieldException("start date");
            } else if (content.length == 2) {
                throw new MissingFieldException("end date");
            }
            String description = content[0].trim();
            String start = content[1].trim();
            String end = content[2].trim();

            return new AddCommand(new Event(description, start, end));
        }
        case FIND: {
            if (fullCommand.length < 2 || fullCommand[1].trim().isEmpty()) {
                throw new MissingFieldException("keyword");
            }
            return new FindCommand(fullCommand[1].trim());
        }
        default: {
            throw new InvalidCommandException(instruction);
        }
        }
    }

    public enum CommandWord {
        BYE, LIST, MARK, UNMARK, REMOVE, TODO, DEADLINE, EVENT, FIND
    }
}
