package latihan1_srp.good;

// TANGGUNG JAWAB 3: Mengirim email
public class EmailSender {

    public void send(String recipient, String message) {
        System.out.println("[EmailSender] Sending EMAIL to: " + recipient);
        System.out.println("[EmailSender] Content: " + message);
    }
}