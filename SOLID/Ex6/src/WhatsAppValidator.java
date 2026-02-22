public class WhatsAppValidator {
    public void validate(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.startsWith("+")) {
            throw new IllegalArgumentException("phone must start with + and country code");
        }
    }
    
}
