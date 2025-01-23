import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bun {
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
    public static void main(String[] args)
            throws IOException{
        String logo = """
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
        System.out.println("    Hello from\n" + logo);
        String name = "Bun";
        System.out.println("    Hello! I'm " + name + ".\n" +
                "    What can I do for you?");

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = r.readLine();
            if (s.equals("bye")) {
                System.out.println("    Bye. Hope to see you again soon!");
                break;
            } else {
                //randomly add one kaomoji at the end of the echo!
                String randomKaomoji = kaomoji[new Random().nextInt(kaomoji.length)];
                System.out.println("    " + s + " " + randomKaomoji);
            }
        }
    }
}
