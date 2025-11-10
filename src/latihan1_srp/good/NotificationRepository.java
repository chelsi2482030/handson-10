package latihan1_srp.good;

// TANGGUNG JAWAB 6: Simpan ke database
public class NotificationRepository {

    public void save(String type, String recipient, String message) {
        System.out.println("[Repository] DB: Saving notification record...");
        System.out.println("→ Type: " + type + ", To: " + recipient);
    }
}