package latihan2_ocp.bad;

public class NotificationService {

    public void sendNotification(String message, String channel, String recipient) {
        if (channel.equalsIgnoreCase("EMAIL")) {
            System.out.println("Sending EMAIL to: " + recipient);
            System.out.println("Content: " + message);
        } else if (channel.equalsIgnoreCase("SMS")) {
            System.out.println("Sending SMS to: " + recipient);
            System.out.println("Content: " + message);
        } else {
            System.out.println("Unknown channel: " + channel);
        }
    }
}