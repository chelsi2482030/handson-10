package latihan3_lsp.bad;

public class NotificationSender {
    public boolean send(String recipient, String message) {
        // Default: dianggap berhasil
        System.out.println("Sending generic notification to " + recipient);
        return true;
    }
}