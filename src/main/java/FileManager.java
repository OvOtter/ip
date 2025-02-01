import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static void saveTask(ArrayList<Task> tasks) {
        StringBuilder content = new StringBuilder();
        for (Task task : tasks) {
            content.append(task.getStoredString()).append("\n");
        }

        Path dataDir = Path.of("data");

        Path bunFile = dataDir.resolve("bun.txt");

        try {
            Files.createDirectories(dataDir);

            Files.writeString(
                    bunFile,
                    content + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );

        } catch (IOException e) {
            System.err.println("Failed to write to duke.txt: " + e.getMessage());
        }
    }
    public static void loadTask(ArrayList<Task> tasks) {
        Path filePath = Path.of("data/bun.txt");
        try {
            // Return empty array if file does not exist
            if (!Files.exists(filePath)) {
                return;
            }

            List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            for (String line : lines) {
                Task task = Task.stringToTask(line);
                if (task != null) {
                    tasks.add(task);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
