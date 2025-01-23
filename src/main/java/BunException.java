public class BunException extends Exception {
    public BunException(String message) {
        super("    " + message);
    }
}
