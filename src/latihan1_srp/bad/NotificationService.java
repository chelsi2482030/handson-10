package latihan1_srp.bad;

/**
 * Class ini MELANGGAR Single Responsibility Principle (SRP)
 * karena memiliki terlalu banyak tanggung jawab:
 * 1. Validasi pesan
 * 2. Format pesan
 * 3. Pengiriman (Email dan SMS)
 * 4. Logging
 * 5. Penyimpanan ke database
 */
public class NotificationService {

    public void sendNotification(String message, String type, String recipient) {
        // === 1. VALIDASI PESAN ===
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty or null!");
        }

        // === 2. FORMAT PESAN ===
        String formattedMessage = formatMessage(message);

        // === 3. KIRIM PESAN BERDASARKAN TYPE ===
        sendMessage(type, recipient, formattedMessage);

        // === 4. LOGGING ===
        logNotification(type);

        // === 5. SIMPAN KE DATABASE ===
        saveToDatabase();
    }

    private String formatMessage(String message) {
        String formatted = message.toUpperCase() + " [SENT AT: " + System.currentTimeMillis() + "]";
        return formatted;
    }

    private void sendMessage(String type, String recipient, String content) {
        if ("EMAIL".equalsIgnoreCase(type)) {
            System.out.println("Sending EMAIL to: " + recipient);
            System.out.println("Content: " + content);
        } else if ("SMS".equalsIgnoreCase(type)) {
            System.out.println("Sending SMS to: " + recipient);
            System.out.println("Content: " + content);
        } else {
            System.out.println("Unknown notification type: " + type);
        }
    }

    private void logNotification(String type) {
        System.out.println("LOG: Notification sent - Type: " + type);
    }

    private void saveToDatabase() {
        System.out.println("DB: Saving notification record...");
    }
}