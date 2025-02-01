import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Deadline extends Task{
    protected LocalDate date;

    public Deadline(String description, String date) throws DateFormatException {
        super(description);
        try {
            this.date = LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            throw new DateFormatException();
        }
    }

    @Override
    public String toString() {
      return String.format("[D]%s (by: %s)", super.toString(), this.date);
    }

    public String getStoredString(){
        return String.format("D | %s | %s", super.getStoredString(), this.date);
    }
}
