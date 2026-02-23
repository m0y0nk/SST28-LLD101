public abstract class NotificationSender {
    protected final AuditLog audit;
    protected NotificationSender(AuditLog audit) { this.audit = audit; }

    public Notification format(Notification n) { return n; }
    public void validate(Notification n) {}
    public abstract void send(Notification n);

    public void sendWithFormatAndValidation(Notification n) {
        Notification formatted = format(n);
        validate(n);
        send(formatted);
    }
}
