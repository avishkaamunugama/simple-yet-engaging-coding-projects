package computerFirmApp;

public class customerList {

    private Integer ID;
    private String Name;
    private String Contact;


    public customerList(Integer ID, String name, String contact) {
        this.setID(ID);
        setName(name);
        setContact(contact);
    }


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }
}
