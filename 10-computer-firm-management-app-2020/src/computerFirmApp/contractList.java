package computerFirmApp;

public class contractList {

    private Integer ID;
    private String Name;
    private String Description;
    private String Date;
    private String Type;
    private String LeaderID;
    private String CustomerName;


    public contractList(Integer ID, String name, String description, String date, String type, String leaderID, String customerName) {
        this.ID = ID;
        Name = name;
        Description = description;
        Date = date;
        Type = type;
        LeaderID = leaderID;
        setCustomerName(customerName);
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getLeaderID() {
        return LeaderID;
    }

    public void setLeaderID(String leaderID) {
        LeaderID = leaderID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }
}
