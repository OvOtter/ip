import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    private final static String[] kaomoji = {
            "(´･ω･`)",         // Basic happy face
            "(･ω･｡)",           // Smiling face with blush
            "(･∀･)",           // Happy face
            "(`･ω･´)",         // Determined face
            "(￣ー￣)",         // Smirking face
            "(Ｔ▽Ｔ)",         // Crying face
            "(´・ω・`)",       // Sad face
            "(ง'̀-'́)ง",         // Fighting pose
            "┬─┬ ノ( ゜-゜ノ)", // Put the table back
            "ヽ(｀Д´)ﾉ",         // Angry
            "(¬_¬)",           // Suspicious
            "(｡♥‿♥｡)",         // Love
            "(ﾟｰﾟ)",           // Neutral
            "（￣へ￣）",         // Annoyed
            "(*^_^*)",         // Shy smile
            "(>_<)",           // Frustrated
            "(*>ω<)",           // Excited
            "（＾ｖ＾）",         // Cheerful
            "(=^･ω･^=)",         // Cat face
            "(⌒ω⌒)",           // Happy face
            "(｀･ω･´)",         // Another determined face
            "(≧◡≦)",           // Very happy
            "(¬‿¬)",           // Wink
            "(*¬∀¬)",           // Playful
            "(✿◠‿◠)",           // Flower smile
            "(°ロ°)☝",           // Surprise
            "(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧",     // Excited
            "(◕‿◕)",           // Friendly
            "(づ｡◕‿‿◕｡)づ"       // Hug
    };

    private final ArrayList<Task> toDoList;

    public Bun() {
        this.toDoList = new ArrayList<>();
    }

    private static void intro() {
        System.out.println("    Hello from\n" + logo);
        System.out.println("    Hello! I'm " + name + ".\n" +
                "    What can I do for you?");
    }

    public static void main(String[] args)
            throws IOException{
        Bun bun = new Bun();

        intro();

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = r.readLine();
            if (s.equals("bye")) {
                System.out.println("    Bye. Hope to see you again soon!");
                break;
            } else if (s.equals("list")) {
                System.out.println("    (ง'̀-'́)ง Here are the tasks in your list:");
                for (int i = 0; i < bun.toDoList.size(); i++) {
                    System.out.println("    " + (i + 1) + ". " + bun.toDoList.get(i));
                }
            } else if (s.startsWith("mark ")) {
                int index = Integer.parseInt(s.split("\\s+")[1]) - 1;
                Task curTask = bun.toDoList.get(index);
                curTask.markAsDone();
                System.out.println("    Nice (*>ω<) I've marked this task as done:\n      " + curTask);
            } else if (s.startsWith("unmark ")) {
                int index = Integer.parseInt(s.split("\\s+")[1]) - 1;
                Task curTask = bun.toDoList.get(index);
                curTask.markAsNotDone();
                System.out.println("    OK (`･ω･´) I've marked this task as not done yet:\n      " + curTask);
            } else{
                //randomly add one kaomoji at the end of the echo!
                String randomKaomoji = kaomoji[new Random().nextInt(kaomoji.length)];
                s += " " + randomKaomoji;
                bun.toDoList.add(new Task(s));
                System.out.println("    added: " + s);
            }
        }
    }
}
