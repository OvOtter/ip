import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Event extends Task{
    protected LocalDate start;
    protected LocalDate end;

    public Event(String description, String start, String end) throws DateFormatException {
        super(description);
        try {
            this.start = LocalDate.parse(start);
            this.end = LocalDate.parse(end);
        } catch (DateTimeParseException e) {
            throw new DateFormatException();
        }
    }

    @Override
    public String toString(){
        return String.format("[E]%s (from: %s to: %s)", super.toString(), start, end);
    }

    @Override
    public String getStoredString(){
        return String.format("E | %s | %s | %s", super.getStoredString(), this.start, this.end);
    }
}
