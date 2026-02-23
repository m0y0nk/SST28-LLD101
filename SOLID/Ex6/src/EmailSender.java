public class EmailSender extends NotificationSender {
    public EmailSender(AuditLog audit) { super(audit); }

    @Override
    public void send(Notification n) {
        System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + n.body);
        audit.add("email sent");
    }

    public Notification format(Notification n) {
        String body = n.body;
        if (body.length() > 40) body = body.substring(0, 40);
        return new Notification(n.subject, body, n.email, n.phone);
    }
}