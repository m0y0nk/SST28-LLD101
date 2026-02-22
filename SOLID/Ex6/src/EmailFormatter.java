public class EmailFormatter {
    public Notification format(Notification n) {
        if (n.body.length() > 40) return new Notification(n.subject, n.body.substring(0, 40), n.email, n.phone);
        return n;
    } 
}
