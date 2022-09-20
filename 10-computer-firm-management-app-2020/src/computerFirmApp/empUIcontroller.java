package computerFirmApp;

import connectivity.DBconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class empUIcontroller {

    @FXML public TextField txtConName;
    @FXML public TextField txtConDesc;
    @FXML public TextField txtConType;
    @FXML public TextField txtCusName;
    @FXML public TextField txtCusContact;
    @FXML public TextField txtCheckSalID;
    @FXML public Label lblrole;
    @FXML public Label lblSalary;
    @FXML public Button btnCheckSal;
    @FXML public Button btnAddContract;
    @FXML public TableView<contractList> tblContract;
    @FXML public TableColumn<contractList,Integer> tcConID;
    @FXML public TableColumn<contractList,String> tcConName;
    @FXML public TableColumn<contractList,String> tcConDesc;
    @FXML public TableColumn<contractList, Date> tcConDate;
    @FXML public TableColumn<contractList,String> tcConType;
    @FXML public TableColumn<contractList,String> tcConLeader;
    @FXML public TableColumn<contractList,Integer> tcCustomerName;

    @FXML public TableView<customerList> tblCustomer;
    @FXML public TableColumn<customerList,Integer> tcCusID;
    @FXML public TableColumn<customerList,String> tcCusName;
    @FXML public TableColumn<customerList,String> tcCusContact;



    public ObservableList<customerList> custdata;
    public DBconnection cusdc;
    public ObservableList<contractList> contdata;
    public DBconnection condc;


    @FXML public void checkSalary(ActionEvent evt) throws SQLException {

        //creates a new object and establish a connection between the database
        DBconnection connectionClass = new DBconnection();
        Connection connection =connectionClass.getConnection();
        lblrole.setWrapText(true);

        //create and execute query
        String sql = "SELECT empRole From Employee WHERE empID = '"+txtCheckSalID.getText()+"'";
        ResultSet rs = connection.createStatement().executeQuery(sql);
        String arr = "Invalid Employee ID.";
        //replaces the text in label with the result of the query
        while (rs.next()){
            String em = rs.getString("empRole");
            arr =em.replace("\n",",");
            System.out.println(arr);
        }

        lblrole.setText(arr);

        //create and execute query
        String sql2 = "SELECT empSalary FROM Employee WHERE empID = '"+txtCheckSalID.getText()+"'";
        ResultSet rs2 = connection.createStatement().executeQuery(sql2);
        String arr2 = "Try again.";
        //replaces the text in label with the result of the query
        while (rs2.next()){
            String em = rs2.getString("empSalary");
            arr2 =em.replace("\n",",");
            System.out.println(arr2);
        }

        lblSalary.setText(String.valueOf(arr2));
    }


    @FXML public void addContract(ActionEvent evt) throws SQLException {
        //creates a new object and establish a connection between the database
        DBconnection connectionClass = new DBconnection();
        Connection connection =connectionClass.getConnection();

        //create and execute query
        String sql2 = "INSERT INTO Contract(conName,conDesc,conType,cusName) VALUES('"+txtConName.getText()+"','"+txtConDesc.getText()+"','"+txtConType.getText()+"','"+txtCusName.getText()+"')";
        Statement statement2 = connection.createStatement();
        statement2.executeUpdate(sql2);

        //create and execute query
        String sql = "INSERT INTO Customer(cusName,cusContact) VALUES('"+txtCusName.getText()+"','"+txtCusContact.getText()+"')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);


        //clears the fields filled by the user after execution
        txtConName.clear();
        txtConDesc.clear();
        txtConType.clear();
        txtCusName.clear();
        txtCusContact.clear();

    }

    @FXML public void refreshCustTable(ActionEvent evt){
        try {
            //creates a new object and establish a connection between the database
            DBconnection connectionClass = new DBconnection();
            Connection connection = connectionClass.getConnection();

            custdata = FXCollections.observableArrayList();
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM customer");  //create and execute query
            while (rs.next()){
                custdata.add(new customerList(rs.getInt(1),rs.getString(2),rs.getString(3)));  //sets the data from the database to the table
            }

        }catch (SQLException ex){
            System.err.println("Error"+ex);
        }


        tcCusID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        tcCusName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tcCusContact.setCellValueFactory(new PropertyValueFactory<>("Contact"));

        tblCustomer.setItems(null);
        tblCustomer.setItems(custdata);


        try{
            //creates a new object and establish a connection between the database
            DBconnection connectionClass = new DBconnection();
            Connection connection = connectionClass.getConnection();
            contdata = FXCollections.observableArrayList();
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM contract");  //create and execute query
            while (rs.next()){
                contdata.add(new contractList(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));  //sets the data from the database to the table
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




}
