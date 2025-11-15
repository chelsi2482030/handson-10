package latihan2_ocp.good;

public class WhatsAppSender implements NotificationSender {
    @Override
    public void send(String recipient, String message) {
        System.out.println("[WhatsApp] Sending to: " + recipient + " | Content: " + message);
    }

    @Override
    public String getType() {
        return "WHATSAPP";
    }
}