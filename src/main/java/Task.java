import java.util.Random;

public class Task {
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

    protected String description;
    protected boolean isDone;

    public Task(String description) {
        //randomly add one kaomoji at the end of the task!
        String randomKaomoji = kaomoji[new Random().nextInt(kaomoji.length)];
        this.description = description + randomKaomoji;
        this.isDone = false;
    }

    protected String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void markAsNotDone() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", getStatusIcon(), this.description);
    }
}
