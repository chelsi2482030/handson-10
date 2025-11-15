package latihan2_ocp.good;

import java.util.List;

public class NotificationService {
    private List<NotificationSender> senders;

    public NotificationService(List<NotificationSender> senders) {
        this.senders = senders;
    }

    public void sendNotification(String message, String recipient) {
        for (NotificationSender sender : senders) {
            sender.send(recipient, message);
        }
    }
}