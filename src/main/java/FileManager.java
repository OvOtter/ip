import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class FileManager {
    public static void saveTask(ArrayList<Task> tasks) {
        StringBuilder content = new StringBuilder();
        for (Task task : tasks) {
            content.append(task).append("\n");
        }

        // 1. Define the relative path (from project root) to the data folder
        Path dataDir = Path.of("data");

        // 2. Resolve duke.txt inside ./data
        Path dukeFile = dataDir.resolve("bun.txt");

        try {
            // Ensure the data directory exists (create if missing)
            Files.createDirectories(dataDir);

            // Append the text to duke.txt
            // CREATE       -> creates the file if it doesn't exist
            // APPEND       -> appends to the end instead of overwriting
            Files.writeString(
                    dukeFile,
                    content + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );

        } catch (IOException e) {
            System.err.println("Failed to write to duke.txt: " + e.getMessage());
        }
    }
}
