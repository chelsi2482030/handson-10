package latihan1_srp.good;

// Class ini hanya bertugas mengoordinasikan semua komponen
public class NotificationService {

    private MessageValidator validator;
    private MessageFormatter formatter;
    private EmailSender emailSender;
    private SmsSender smsSender;
    private NotificationLogger logger;
    private NotificationRepository repository;

    public NotificationService(MessageValidator validator, MessageFormatter formatter,
                               EmailSender emailSender, SmsSender smsSender,
                               NotificationLogger logger, NotificationRepository repository) {
        this.validator = validator;
        this.formatter = formatter;
        this.emailSender = emailSender;
        this.smsSender = smsSender;
        this.logger = logger;
        this.repository = repository;
    }

    public void sendNotification(String message, String type, String recipient) {
        // Jalankan langkah-langkah dengan class terpisah
        validator.validate(message);
        String formatted = formatter.format(message);

        if ("EMAIL".equalsIgnoreCase(type)) {
            emailSender.send(recipient, formatted);
        } else if ("SMS".equalsIgnoreCase(type)) {
            smsSender.send(recipient, formatted);
        } else {
            System.out.println("[NotificationService] Unknown type: " + type);
            return;
        }

        logger.log(type, recipient);
        repository.save(type, recipient, formatted);
    }
}