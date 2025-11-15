package latihan3_lsp.bad;

public class EmailSender extends NotificationSender {
    @Override
    public boolean send(String recipient, String message) {
        System.out.println("✓ Notification sent via EMAIL to " + recipient);
        return true;
    }
}