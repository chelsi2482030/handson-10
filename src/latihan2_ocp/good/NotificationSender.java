package latihan2_ocp.good;

public interface NotificationSender {
    void send(String recipient, String message);
    String getType();
}