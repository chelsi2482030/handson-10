package latihan2_ocp;

import latihan2_ocp.bad.NotificationService;
import latihan2_ocp.good.*;
import java.util.*;

public class OCPPractice {
    public static void main(String[] args) {
        /*
         * LATIHAN 2: OPEN/CLOSED PRINCIPLE (OCP)
         *
         * Definisi:
         * "Software entities should be open for extension, but closed for modification."
         *
         * Tujuan Latihan:
         * 1. Memahami masalah if-else chains
         * 2. Menggunakan interface untuk extensibility
         * 3. Menambah fitur baru tanpa modify existing code
         * 4. Menerapkan dependency injection pattern
         */

        // ===== PART 1: BAD PRACTICE - Melanggar OCP =====
        System.out.println("=== BAD PRACTICE: Melanggar OCP ===\n");

        NotificationService badService = new NotificationService();
        badService.sendNotification("Hello", "EMAIL", "user@example.com");
        badService.sendNotification("Hello", "SMS", "081234567890");

        System.out.println("\n--- Analisis Masalah ---");
        System.out.println("Bagaimana kalau kita ingin menambah channel baru (WhatsApp)?");
        System.out.println("❌ Harus modify method sendNotification()");
        System.out.println("❌ Harus tambah else if baru");
        System.out.println("❌ Risk merusak existing functionality");
        System.out.println("❌ Setiap channel baru = modify existing code");
        System.out.println("\nIni MELANGGAR OCP: tidak bisa extend tanpa modify!");

        System.out.println("\n" + "=".repeat(70));

        // ===== PART 2: GOOD PRACTICE - Mengikuti OCP =====
        System.out.println("\n=== GOOD PRACTICE: Mengikuti OCP ===\n");

        // Setup senders (implementasi OCP)
        List<NotificationSender> senders = new ArrayList<>();
        senders.add(new EmailSender());
        senders.add(new SmsSender());
        senders.add(new WhatsAppSender()); // NEW channel! Zero modification needed


        System.out.println("\n--- Keuntungan Setelah Refactoring ---");
        System.out.println("✓ Extensible - Mudah tambah channel baru");
        System.out.println("✓ Stable - Code existing tidak dimodifikasi");
        System.out.println("✓ Safe - Risiko bug di fitur existing sangat kecil");
        System.out.println("✓ Scalable - Bisa unlimited channels");
        System.out.println("\nMenambah WhatsAppSender:");
        System.out.println("  → Buat class baru WhatsAppSender");
        System.out.println("  → Add ke list senders");
        System.out.println("  → ZERO modification ke NotificationService");
    }
}