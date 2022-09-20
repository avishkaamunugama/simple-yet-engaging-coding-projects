package computerFirmApp;

import connectivity.DBconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;


public class adminUIcontroller {
    public TextField txtName;
    @FXML public TextField txtDOB;
    @FXML public TextField txtContact;
    @FXML public TextField txtRole;
    @FXML public TextField txtRmID;
    @FXML public TextField txtSalary;
    @FXML public TextField txtProLeadID;
    @FXML public TextField txtcontractID;
    @FXML public Button btnAddEmp;
    @FXML public Button btnRefresh;
    @FXML public Button btnRemoveEmp;
    @FXML public Button btnSalChange;
    @FXML public Button btnSetLead;
    @FXML public Button btnViewConCus;
    @FXML public TextField txtNewSal;
    @FXML public TextField txtNewSalID;
    @FXML public TableView<employeeList> empTable;
    @FXML public TableColumn<employeeList,Integer> tcID;
    @FXML public TableColumn<employeeList,String> tcName;
    @FXML public TableColumn<employeeList,String> tcDOB;
    @FXML public TableColumn<employeeList,String> tcCont;
    @FXML public TableColumn<employeeList,String> tcRole;
    @FXML public TableColumn<employeeList,Integer> tcSalary;
    @FXML public TableView<contractList> tblContract;
    @FXML public TableColumn<contractList,Integer> tcConID;
    @FXML public TableColumn<contractList,String> tcConName;
    @FXML public TableColumn<contractList,String> tcConDesc;
    @FXML public TableColumn<contractList, Date> tcConDate;
    @FXML public TableColumn<contractList,String> tcConType;
    @FXML public TableColumn<contractList,String> tcConLeader;
    @FXML public TableColumn<contractList,Integer> tcCustomerName;

    public ObservableList<employeeList>data;
    public DBconnection dc;
    public ObservableList<contractList> contdata;
    public DBconnection condc;


    @FXML public void addEmp(ActionEvent evt) throws SQLException {

        DBconnection connectionClass = new DBconnection();  //creates a new object and establish a connection between the database
        Connection connection =connectionClass.getConnection();

        //payment calculation

        int techPay = 0;
        int proPay = 0;
        int insPay = 0;
        if ((txtRole.getText()).toLowerCase().contains("technician")){
            techPay = 20;
        }
        if ((txtRole.getText()).toLowerCase().contains("programmer")){
             proPay = 30;
        }
        if ((txtRole.getText()).toLowerCase().contains("installer")){
            insPay = 10;
        }

        //it's assumed a employee works 160 hours per month.


        //the string in the sql variable is executed as a mysql query
        String sql = "INSERT INTO Employee(empName,empDOB,empContact,empRole,empSalary) VALUES('"+txtName.getText()+"','"+txtDOB.getText()+"','"+txtContact.getText()+"','"+txtRole.getText()+"','"+((techPay*160)+(proPay*160)+(insPay*160))+"')";
        Statement statement= connection.createStatement();  //create a sql statement
        statement.executeUpdate(sql);  //execute the query



        //clears the fields filled by the user after execution
        txtName.clear();
        txtDOB.clear();
        txtRole.clear();
        txtContact.clear();


    }

    @FXML public void removeEmp(ActionEvent evt) throws SQLException {
        //creates a new object and establish a connection between the database
        DBconnection connectionClass = new DBconnection();
        Connection connection =connectionClass.getConnection();

        //the string in the sql variable is executed as a mysql query
        String sql = "DELETE FROM Employee WHERE empID = '"+txtRmID.getText()+"'";
        Statement statement = connection.createStatement();  //create a sql statement
        statement.executeUpdate(sql);  //execute the query


        //clears the fields filled by the user after execution
        txtRmID.clear();
    }

    @FXML public void setLeader(ActionEvent evt) throws SQLException {
        //creates a new object and establish a connection between the database
        DBconnection connectionClass = new DBconnection();
        Connection connection =connectionClass.getConnection();

        //the string in the sql variable is executed as a mysql query
        String sql = "UPDATE Contract SET conLeaderID = '"+txtProLeadID.getText()+"' WHERE conID = '"+txtcontractID.getText()+"'";
        Statement statement = connection.createStatement();  //create a sql statement
        statement.executeUpdate(sql);  //execute the query


        //clears the fields filled by the user after execution
        txtProLeadID.clear();
        txtcontractID.clear();
    }

    @FXML public void changeSalary(ActionEvent evt) throws SQLException {
        //creates a new object and establish a connection between the database
        DBconnection connectionClass = new DBconnection();
        Connection connection =connectionClass.getConnection();

        //the string in the sql variable is executed as a mysql query
        String sql = "UPDATE Employee SET empSalary = '"+txtNewSal.getText()+"' WHERE empID = '"+txtNewSalID.getText()+"'";
        Statement statement = connection.createStatement();   //create a sql statement
        statement.executeUpdate(sql);  //execute the query


        //clears the fields filled by the user after execution
        txtNewSalID.clear();
        txtNewSal.clear();
    }



    @FXML
    public void loadDatabase(ActionEvent evt){

    try {
        //creates a new object and establish a connection between the database
        DBconnection connectionClass = new DBconnection();
        Connection connection =connectionClass.getConnection();

        data = FXCollections.observableArrayList();
        ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM Employee"); //create and execute query
        while (rs.next()){
            data.add(new employeeList(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6))); //sets the data from the database to the table
        }

    }catch (SQLException ex){
        System.err.println("Error"+ex);
    }

    //The cellValueFactory tells the column what value to display in its cells;
    tcID.setCellValueFactory(new PropertyValueFactory<>("ID"));
    tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
    tcDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
    tcCont.setCellValueFactory(new PropertyValueFactory<>("contact"));
    tcRole.setCellValueFactory(new PropertyValueFactory<>("role"));
    tcSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

    empTable.setItems(null);
    empTable.setItems(data);









        try{
            //creates a new object and establish a connection between the database
            DBconnection connectionClass = new DBconnection();
            Connection connection = connectionClass.getConnection();
            contdata = FXCollections.observableArrayList();
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM contract");  //create and execute query
            while (rs.next()){
                contdata.add(new contractList(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));   //sets the data from the database to the table
            }

        }catch (SQLException ex){
            System.err.println("Error"+ex);
        }

        //The cellValueFactory tells the column what value to display in its cells;
        tcConID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        tcConName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tcConDesc.setCellValueFactory(new PropertyValueFactory<>("Description"));
        tcConDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        tcConType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        tcConLeader.setCellValueFactory(new PropertyValueFactory<>("LeaderID"));
        tcCustomerName.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));

        tblContract.setItems(null);
        tblContract.setItems(contdata);
    }



    //redirects to the employee page once executed
    @FXML public void toEmpUI(ActionEvent evt){
        try {

            Parent rootNode = FXMLLoader.load(getClass().getResource("empUI.fxml"));
            Scene sceneEmpUI = new Scene(rootNode,1003,563);
            Stage stageEmpUI = new Stage();
            stageEmpUI.setTitle("Employee Details");
            stageEmpUI.setScene(sceneEmpUI);
            stageEmpUI.show();
        } catch (IOException e) {
            e.printStackTrace();  //tells you what the error was and where in the code this happened
        }


    }



}





