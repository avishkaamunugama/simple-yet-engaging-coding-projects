package computerFirmApp;

public class employeeList {
    private Integer ID;
    private String name;
    private  String dob;
    private String contact;
    private String role;
    private Integer salary;

    public employeeList(Integer ID, String name, String dob, String contact, String role, Integer salary) {
        this.setID(ID);
        this.setName(name);
        this.setDob(dob);
        this.setContact(contact);
        this.setRole(role);
        this.setSalary(salary);
    }


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
