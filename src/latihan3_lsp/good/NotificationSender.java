package latihan3_lsp.good;

public abstract class NotificationSender {
    /**
     * Kontrak:
     * - Tidak boleh throw exception.
     * - Return true jika sukses, false jika gagal.
     * - recipient & message tidak boleh null.
     */
    public abstract boolean send(String recipient, String message);
}