package latihan3_lsp;

import latihan3_lsp.bad.NotificationSender;
import latihan3_lsp.bad.EmailSender;
import latihan3_lsp.bad.ReadOnlySender;


public class LSPPractice {
    public static void main(String[] args) {
        /*
         * LATIHAN 3: LISKOV SUBSTITUTION PRINCIPLE (LSP)
         */

        // ===== PART 1: BAD PRACTICE - Melanggar LSP =====
        System.out.println("=== BAD PRACTICE: Melanggar LSP ===\n");

        // Polymorphic code - menggunakan parent class reference
        NotificationSender sender1 = new EmailSender();
        NotificationSender sender2 = new ReadOnlySender(); // PROBLEM!

        // Test sender1 (EmailSender)
        System.out.println("Testing EmailSender:");
        processNotification(sender1, "user@example.com", "Hello");

        // Test sender2 (ReadOnlySender)
        System.out.println("\nTesting ReadOnlySender:");
        try {
            processNotification(sender2, "user@example.com", "Hello");
        } catch (Exception e) {
            System.out.println("❌ Exception thrown: " + e.getClass().getSimpleName() +
                    ": " + e.getMessage());
            System.out.println("❌ Program crashed!");
        }

        System.out.println("\n--- Analisis Masalah ---");
        System.out.println("ReadOnlySender melanggar LSP karena:");
        System.out.println("1. Parent NotificationSender promise: bisa send notification");
        System.out.println("2. ReadOnlySender: throw exception instead");
        System.out.println("3. Cannot substitute parent class safely");
        System.out.println("4. Breaks polymorphic code");
        System.out.println("\nIni MELANGGAR LSP: subclass tidak bisa replace parent!");

        System.out.println("\n" + "=".repeat(70));

        // ===== PART 2: GOOD PRACTICE - Mengikuti LSP =====
        System.out.println("\n=== GOOD PRACTICE: Mengikuti LSP ===\n");

        System.out.println("Testing dengan semua implementation:");

        latihan3_lsp.good.NotificationSender goodSender1 = new latihan3_lsp.good.EmailSender();
        latihan3_lsp.good.NotificationSender goodSender2 = new latihan3_lsp.good.SmsSender();

        // Semua sender bisa digunakan secara polymorphic dengan aman
        testSender(goodSender1, "user@example.com", "Hello");
        testSender(goodSender2, "081234567890", "Hello");

        System.out.println("\n--- Keuntungan Setelah Refactoring ---");
        System.out.println("✓ Predictable - Semua child class berperilaku sesuai ekspektasi");
        System.out.println("✓ Reliable - Tidak ada surprise behavior");
        System.out.println("✓ Interchangeable - Bisa ganti child class dengan aman");
        System.out.println("✓ Safe - Polymorphic code bekerja tanpa masalah");
    }

    // Helper untuk bagian BAD PRACTICE
    private static void processNotification(NotificationSender sender, String recipient, String message) {
        boolean success = sender.send(recipient, message);
        if (success) {
            System.out.println("✓ Notification sent via EMAIL to " + recipient);
        } else {
            System.out.println("✗ Failed to send notification");
        }
    }

    // Helper untuk bagian GOOD PRACTICE
    private static void testSender(latihan3_lsp.good.NotificationSender sender, String recipient, String message) {
        boolean success = sender.send(recipient, message);
        if (success) {
            System.out.println("[" + sender.getClass().getSimpleName() + "] ✓ Notification sent to: " + recipient);
        }
    }
}