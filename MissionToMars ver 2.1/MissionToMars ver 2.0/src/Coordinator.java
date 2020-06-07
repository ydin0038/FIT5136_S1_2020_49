/**
 * Class of the user (Coordinator) in the Mission to Mars System
 */

public class Coordinator extends Users {
    private String coorName;
    private String coorContact;

    public Coordinator() {
    }

    public Coordinator(String coorName, String coorContact) {
        this.coorName = coorName;
        this.coorContact = coorContact;
    }

    public String getCoorName() {
        return coorName;
    }

    public void setCoorName(String coorName) {
        this.coorName = coorName;
    }

    public String getCoorContact() {
        return coorContact;
    }

    public void setCoorContact(String coorContact) {
        this.coorContact = coorContact;
    }
}
