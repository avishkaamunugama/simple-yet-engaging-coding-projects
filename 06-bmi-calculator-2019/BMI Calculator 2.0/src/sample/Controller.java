package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.util.Calendar;

public class Controller {

    @FXML
    AnchorPane body;

    @FXML
    Button calcBtn;

    @FXML
    Button resetBtn;

    @FXML
    TextField heightTf;

    @FXML
    TextField weightTf;

    @FXML
    TextField monthTf;

    @FXML
    TextField yearTf;

    @FXML
    RadioButton maleRbtn;

    @FXML
    RadioButton femaleRbtn;


    @FXML
    Label bmiLbl;

    @FXML
    Label condLbl;

    @FXML
    Label dateLbl;

    @FXML
    Button del1;

    @FXML
    Button del2;

    @FXML
    Button del3;

    @FXML
    Button del4;

    @FXML
    Label ageLbl;

    @FXML
    Label ageHlbl;



    @FXML
    private void calc(ActionEvent ae){
        double height = Double.parseDouble(heightTf.getText());
        double weight = Double.parseDouble(weightTf.getText());

        double bmi = weight/((height/100)*(height/100));

        bmiLbl.setText(String.format("%.2f",bmi));

        try {
            int month = Integer.parseInt(monthTf.getText());
            int year = Integer.parseInt(yearTf.getText());
            analyser(bmi, month, year);

        }catch (Exception ex){}
    }


    @FXML
    private void reset(ActionEvent ae){
        heightTf.clear();
        weightTf.clear();
        maleRbtn.setSelected(false);
        femaleRbtn.setSelected(false);
        monthTf.clear();
        yearTf.clear();
//        heightLbl.setText("Height: ");
//        weightLbl.setText("Weight: ");
        bmiLbl.setText("");
        condLbl.setText("");
        body.setStyle("-fx-background-color:#f4f4f4");
        bmiLbl.setStyle("-fx-border-fill:transparent");
        ageLbl.setText("");
        ageHlbl.setText("");



    }

    @FXML
    private void erase1(ActionEvent ae){
        heightTf.clear();
    }

    @FXML
    private void erase2(ActionEvent ae){
        weightTf.clear();
    }

    @FXML
    private void erase3(ActionEvent ae){
        monthTf.clear();
    }

    @FXML
    private void erase4(ActionEvent ae){
        yearTf.clear();
    }

@FXML
    private  void radioMale(ActionEvent ae){
        femaleRbtn.setSelected(false);
    }
@FXML
    private  void radioFemale(ActionEvent ae){
        maleRbtn.setSelected(false);
    }


    public void initialize(){
        int day = Calendar.getInstance().get(Calendar.DATE);
        int month = Calendar.getInstance().get(Calendar.MONTH) +1 ;
        int year = Calendar.getInstance().get(Calendar.YEAR);

        dateLbl.setText(day+" / "+ month +" / "+year);



    }


    private void analyser(double bmi, int month, int year) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = 1 + Calendar.getInstance().get(Calendar.MONTH);

        int monthDef;
        int yearDef;
        if (currentMonth >= month) {
            monthDef = currentMonth - month;
            yearDef = currentYear - year;
        } else {
            monthDef = 12 + (currentMonth - month);
            yearDef = (currentYear - year) - 1;
        }

        System.out.println(monthDef);
        System.out.println(yearDef);

        ageLbl.setText(+ yearDef +" years : "+monthDef+" months");

        ageHlbl.setStyle("-fx-text-fill:black");

        String condition = "";



        // male calc area

        if (maleRbtn.isSelected()) {

            if (monthDef < 4 && monthDef >= 0) {  //from 1-3 month difference
                if (yearDef == 5) {
                    if (bmi <= 13) {
                        condition = "Under-weight";
                    } else if (bmi <= 16.6) {
                        condition = "Normal";
                    } else if (bmi <= 18.2) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }
                } else if (yearDef == 6) {
                    if (bmi <= 13) {
                        condition = "Under-weight";
                    } else if (bmi <= 16.7) {
                        condition = "Normal";
                    } else if (bmi <= 18.5) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 7) {
                    if (bmi <= 13.1) {
                        condition = "Under-weight";
                    } else if (bmi <= 17.1) {
                        condition = "Normal";
                    } else if (bmi <= 19) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 8) {
                    if (bmi <= 13.4) {
                        condition = "Under-weight";
                    } else if (bmi <= 17.5) {
                        condition = "Normal";
                    } else if (bmi <= 19.6) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 9) {
                    if (bmi <= 13.5) {
                        condition = "Under-weight";
                    } else if (bmi <= 18) {
                        condition = "Normal";
                    } else if (bmi <= 20.5) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 10) {
                    if (bmi <= 13.6) {
                        condition = "Under-weight";
                    } else if (bmi <= 18.5) {
                        condition = "Normal";
                    } else if (bmi <= 21.5) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 11) {
                    if (bmi <= 14) {
                        condition = "Under-weight";
                    } else if (bmi <= 19.1) {
                        condition = "Normal";
                    } else if (bmi <= 22.5) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 12) {
                    if (bmi <= 14.5) {
                        condition = "Under-weight";
                    } else if (bmi <= 20) {
                        condition = "Normal";
                    } else if (bmi <= 23.5) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 13) {
                    if (bmi <= 15) {
                        condition = "Under-weight";
                    } else if (bmi <= 21) {
                        condition = "Normal";
                    } else if (bmi <= 24.7) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 14) {
                    if (bmi <= 15.5) {
                        condition = "Under-weight";
                    } else if (bmi <= 21.7) {
                        condition = "Normal";
                    } else if (bmi <= 26) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 15) {
                    if (bmi <= 16) {
                        condition = "Under-weight";
                    } else if (bmi <= 22.6) {
                        condition = "Normal";
                    } else if (bmi <= 27) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 16) {
                    if (bmi <= 16.5) {
                        condition = "Under-weight";
                    } else if (bmi <= 23.5) {
                        condition = "Normal";
                    } else if (bmi <= 27.9) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 17) {
                    if (bmi <= 17) {
                        condition = "Under-weight";
                    } else if (bmi <= 24.3) {
                        condition = "Normal";
                    } else if (bmi <= 28.6) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 18) {
                    if (bmi <= 17.3) {
                        condition = "Under-weight";
                    } else if (bmi <= 25) {
                        condition = "Normal";
                    } else if (bmi <= 29.2) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 19) {
                    if (bmi <= 17.5) {
                        condition = "Under-weight";
                    } else if (bmi <= 25.5) {
                        condition = "Normal";
                    } else if (bmi <= 29.6) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                }
            } else if (monthDef < 7 && monthDef >= 4) {  //from 3-6 month difference
                if (yearDef == 5) {
                    if (bmi <= 13) {
                        condition = "Under-weight";
                    } else if (bmi <= 16.6) {
                        condition = "Normal";
                    } else if (bmi <= 18.3) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }
                } else if (yearDef == 6) {
                    if (bmi <= 13) {
                        condition = "Under-weight";
                    } else if (bmi <= 16.9) {
                        condition = "Normal";
                    } else if (bmi <= 18.6) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 7) {
                    if (bmi <= 13.2) {
                        condition = "Under-weight";
                    } else if (bmi <= 17.1) {
                        condition = "Normal";
                    } else if (bmi <= 19.2) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 8) {
                    if (bmi <= 13.4) {
                        condition = "Under-weight";
                    } else if (bmi <= 17.5) {
                        condition = "Normal";
                    } else if (bmi <= 19.9) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 9) {
                    if (bmi <= 13.5) {
                        condition = "Under-weight";
                    } else if (bmi <= 18) {
                        condition = "Normal";
                    } else if (bmi <= 20.7) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 10) {
                    if (bmi <= 13.8) {
                        condition = "Under-weight";
                    } else if (bmi <= 18.6) {
                        condition = "Normal";
                    } else if (bmi <= 21.7) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 11) {
                    if (bmi <= 14.1) {
                        condition = "Under-weight";
                    } else if (bmi <= 19.4) {
                        condition = "Normal";
                    } else if (bmi <= 22.8) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 12) {
                    if (bmi <= 14.6) {
                        condition = "Under-weight";
                    } else if (bmi <= 20.2) {
                        condition = "Normal";
                    } else if (bmi <= 23.9) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 13) {
                    if (bmi <= 15.1) {
                        condition = "Under-weight";
                    } else if (bmi <= 21.1) {
                        condition = "Normal";
                    } else if (bmi <= 25) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 14) {
                    if (bmi <= 15.6) {
                        condition = "Under-weight";
                    } else if (bmi <= 22) {
                        condition = "Normal";
                    } else if (bmi <= 26.2) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 15) {
                    if (bmi <= 16.2) {
                        condition = "Under-weight";
                    } else if (bmi <= 22.9) {
                        condition = "Normal";
                    } else if (bmi <= 27.2) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 16) {
                    if (bmi <= 16.6) {
                        condition = "Under-weight";
                    } else if (bmi <= 23.8) {
                        condition = "Normal";
                    } else if (bmi <= 28.1) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 17) {
                    if (bmi <= 17) {
                        condition = "Under-weight";
                    } else if (bmi <= 24.5) {
                        condition = "Normal";
                    } else if (bmi <= 28.8) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 18) {
                    if (bmi <= 17.4) {
                        condition = "Under-weight";
                    } else if (bmi <= 25.1) {
                        condition = "Normal";
                    } else if (bmi <= 29.4) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                }
            } else if (monthDef < 10 && monthDef >= 7) {   //from 6-9 month difference
                if (yearDef == 5) {
                    if (bmi <= 13) {
                        condition = "Under-weight";
                    } else if (bmi <= 16.7) {
                        condition = "Normal";
                    } else if (bmi <= 18.4) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }
                } else if (yearDef == 6) {
                    if (bmi <= 13.1) {
                        condition = "Under-weight";
                    } else if (bmi <= 16.9) {
                        condition = "Normal";
                    } else if (bmi <= 18.8) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 7) {
                    if (bmi <= 13.3) {
                        condition = "Under-weight";
                    } else if (bmi <= 17.3) {
                        condition = "Normal";
                    } else if (bmi <= 19.4) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 8) {
                    if (bmi <= 13.4) {
                        condition = "Under-weight";
                    } else if (bmi <= 17.7) {
                        condition = "Normal";
                    } else if (bmi <= 20) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 9) {
                    if (bmi <= 13.6) {
                        condition = "Under-weight";
                    } else if (bmi <= 18.2) {
                        condition = "Normal";
                    } else if (bmi <= 21) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 10) {
                    if (bmi <= 13.9) {
                        condition = "Under-weight";
                    } else if (bmi <= 18.8) {
                        condition = "Normal";
                    } else if (bmi <= 22) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 11) {
                    if (bmi <= 14.3) {
                        condition = "Under-weight";
                    } else if (bmi <= 19.5) {
                        condition = "Normal";
                    } else if (bmi <= 23) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 12) {
                    if (bmi <= 14.7) {
                        condition = "Under-weight";
                    } else if (bmi <= 20.4) {
                        condition = "Normal";
                    } else if (bmi <= 24.2) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 13) {
                    if (bmi <= 15.3) {
                        condition = "Under-weight";
                    } else if (bmi <= 21.4) {
                        condition = "Normal";
                    } else if (bmi <= 25.4) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 14) {
                    if (bmi <= 15.8) {
                        condition = "Under-weight";
                    } else if (bmi <= 22.2) {
                        condition = "Normal";
                    } else if (bmi <= 26.5) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 15) {
                    if (bmi <= 16.3) {
                        condition = "Under-weight";
                    } else if (bmi <= 23.1) {
                        condition = "Normal";
                    } else if (bmi <= 27.5) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 16) {
                    if (bmi <= 16.7) {
                        condition = "Under-weight";
                    } else if (bmi <= 24) {
                        condition = "Normal";
                    } else if (bmi <= 28.4) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 17) {
                    if (bmi <= 17.1) {
                        condition = "Under-weight";
                    } else if (bmi <= 24.6) {
                        condition = "Normal";
                    } else if (bmi <= 29) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 18) {
                    if (bmi <= 17.4) {
                        condition = "Under-weight";
                    } else if (bmi <= 25.3) {
                        condition = "Normal";
                    } else if (bmi <= 29.5) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                }
            } else if (monthDef < 13 && monthDef >= 10) {   //from 9-12 month difference
                if (yearDef == 5) {
                    if (bmi <= 13) {
                        condition = "Under-weight";
                    } else if (bmi <= 16.7) {
                        condition = "Normal";
                    } else if (bmi <= 18.5) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }
                } else if (yearDef == 6) {
                    if (bmi <= 13.1) {
                        condition = "Under-weight";
                    } else if (bmi <= 17) {
                        condition = "Normal";
                    } else if (bmi <= 18.9) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 7) {
                    if (bmi <= 13.3) {
                        condition = "Under-weight";
                    } else if (bmi <= 17.4) {
                        condition = "Normal";
                    } else if (bmi <= 19.5) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 8) {
                    if (bmi <= 13.5) {
                        condition = "Under-weight";
                    } else if (bmi <= 17.8) {
                        condition = "Normal";
                    } else if (bmi <= 20.3) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 9) {
                    if (bmi <= 13.6) {
                        condition = "Under-weight";
                    } else if (bmi <= 18.3) {
                        condition = "Normal";
                    } else if (bmi <= 21.1) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 10) {
                    if (bmi <= 14) {
                        condition = "Under-weight";
                    } else if (bmi <= 19) {
                        condition = "Normal";
                    } else if (bmi <= 22.1) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 11) {
                    if (bmi <= 14.4) {
                        condition = "Under-weight";
                    } else if (bmi <= 19.8) {
                        condition = "Normal";
                    } else if (bmi <= 23.3) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 12) {
                    if (bmi <= 14.8) {
                        condition = "Under-weight";
                    } else if (bmi <= 20.5) {
                        condition = "Normal";
                    } else if (bmi <= 24.5) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 13) {
                    if (bmi <= 15.4) {
                        condition = "Under-weight";
                    } else if (bmi <= 21.5) {
                        condition = "Normal";
                    } else if (bmi <= 25.5) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 14) {
                    if (bmi <= 15.9) {
                        condition = "Under-weight";
                    } else if (bmi <= 22.5) {
                        condition = "Normal";
                    } else if (bmi <= 26.7) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 15) {
                    if (bmi <= 16.4) {
                        condition = "Under-weight";
                    } else if (bmi <= 23.3) {
                        condition = "Normal";
                    } else if (bmi <= 27.6) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 16) {
                    if (bmi <= 16.8) {
                        condition = "Under-weight";
                    } else if (bmi <= 24) {
                        condition = "Normal";
                    } else if (bmi <= 28.5) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 17) {
                    if (bmi <= 17.1) {
                        condition = "Under-weight";
                    } else if (bmi <= 24.7) {
                        condition = "Normal";
                    } else if (bmi <= 29) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                } else if (yearDef == 18) {
                    if (bmi <= 17.5) {
                        condition = "Under-weight";
                    } else if (bmi <= 25.4) {
                        condition = "Normal";
                    } else if (bmi <= 29.6) {
                        condition = "Over-weight";
                    } else {
                        condition = "Obese";
                    }

                }
            }
        }






            //female calc area




            else if (femaleRbtn.isSelected()) {

                if (monthDef < 4 && monthDef >= 0) {  //from 1-3 month difference
                    if (yearDef == 5) {
                        if (bmi <= 12.8) {
                            condition = "Under-weight";
                        } else if (bmi <= 16.8) {
                            condition = "Normal";
                        } else if (bmi <= 18.8) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }
                    } else if (yearDef == 6) {
                        if (bmi <= 12.7) {
                            condition = "Under-weight";
                        } else if (bmi <= 17) {
                            condition = "Normal";
                        } else if (bmi <= 19.3) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 7) {
                        if (bmi <= 12.7) {
                            condition = "Under-weight";
                        } else if (bmi <= 17.3) {
                            condition = "Normal";
                        } else if (bmi <= 19.9) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 8) {
                        if (bmi <= 12.9) {
                            condition = "Under-weight";
                        } else if (bmi <= 17.8) {
                            condition = "Normal";
                        } else if (bmi <= 20.5) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 9) {
                        if (bmi <= 13.1) {
                            condition = "Under-weight";
                        } else if (bmi <= 18.4) {
                            condition = "Normal";
                        } else if (bmi <= 21.5) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 10) {
                        if (bmi <= 13.5) {
                            condition = "Under-weight";
                        } else if (bmi <= 19) {
                            condition = "Normal";
                        } else if (bmi <= 22.5) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 11) {
                        if (bmi <= 13.9) {
                            condition = "Under-weight";
                        } else if (bmi <= 19.9) {
                            condition = "Normal";
                        } else if (bmi <= 23.8) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 12) {
                        if (bmi <= 14.4) {
                            condition = "Under-weight";
                        } else if (bmi <= 20.9) {
                            condition = "Normal";
                        } else if (bmi <= 25) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 13) {
                        if (bmi <= 15) {
                            condition = "Under-weight";
                        } else if (bmi <= 21.9) {
                            condition = "Normal";
                        } else if (bmi <= 26.3) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 14) {
                        if (bmi <= 15.5) {
                            condition = "Under-weight";
                        } else if (bmi <= 22.8) {
                            condition = "Normal";
                        } else if (bmi <= 27.4) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 15) {
                        if (bmi <= 15.9) {
                            condition = "Under-weight";
                        } else if (bmi <= 23.5) {
                            condition = "Normal";
                        } else if (bmi <= 28.2) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 16) {
                        if (bmi <= 16.2) {
                            condition = "Under-weight";
                        } else if (bmi <= 24.1) {
                            condition = "Normal";
                        } else if (bmi <= 28.9) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 17) {
                        if (bmi <= 16.4) {
                            condition = "Under-weight";
                        } else if (bmi <= 24.5) {
                            condition = "Normal";
                        } else if (bmi <= 29.4) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 18) {
                        if (bmi <= 16.5) {
                            condition = "Under-weight";
                        } else if (bmi <= 24.8) {
                            condition = "Normal";
                        } else if (bmi <= 29.5) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 19) {
                        if (bmi <= 16.5) {
                            condition = "Under-weight";
                        } else if (bmi <= 25) {
                            condition = "Normal";
                        } else if (bmi <= 29.7) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    }
                } else if (monthDef < 7 && monthDef >= 4) {  //from 3-6 month difference
                    if (yearDef == 5) {
                        if (bmi <= 12.7) {
                            condition = "Under-weight";
                        } else if (bmi <= 16.8) {
                            condition = "Normal";
                        } else if (bmi <= 18.9) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }
                    } else if (yearDef == 6) {
                        if (bmi <= 12.7) {
                            condition = "Under-weight";
                        } else if (bmi <= 17.1) {
                            condition = "Normal";
                        } else if (bmi <= 19.4) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 7) {
                        if (bmi <= 12.7) {
                            condition = "Under-weight";
                        } else if (bmi <= 17.4) {
                            condition = "Normal";
                        } else if (bmi <= 20) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 8) {
                        if (bmi <= 12.9) {
                            condition = "Under-weight";
                        } else if (bmi <= 17.9) {
                            condition = "Normal";
                        } else if (bmi <= 20.9) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 9) {
                        if (bmi <= 13.2) {
                            condition = "Under-weight";
                        } else if (bmi <= 18.5) {
                            condition = "Normal";
                        } else if (bmi <= 21.8) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 10) {
                        if (bmi <= 13.6) {
                            condition = "Under-weight";
                        } else if (bmi <= 19.2) {
                            condition = "Normal";
                        } else if (bmi <= 22.8) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 11) {
                        if (bmi <= 14.0) {
                            condition = "Under-weight";
                        } else if (bmi <= 20.1) {
                            condition = "Normal";
                        } else if (bmi <= 23.8) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 12) {
                        if (bmi <= 14.5) {
                            condition = "Under-weight";
                        } else if (bmi <= 21) {
                            condition = "Normal";
                        } else if (bmi <= 25.3) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 13) {
                        if (bmi <= 15.1) {
                            condition = "Under-weight";
                        } else if (bmi <= 22) {
                            condition = "Normal";
                        } else if (bmi <= 26.5) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 14) {
                        if (bmi <= 15.5) {
                            condition = "Under-weight";
                        } else if (bmi <= 23) {
                            condition = "Normal";
                        } else if (bmi <= 27.6) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 15) {
                        if (bmi <= 16) {
                            condition = "Under-weight";
                        } else if (bmi <= 23.7) {
                            condition = "Normal";
                        } else if (bmi <= 28.4) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 16) {
                        if (bmi <= 16.3) {
                            condition = "Under-weight";
                        } else if (bmi <= 24.4) {
                            condition = "Normal";
                        } else if (bmi <= 29) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 17) {
                        if (bmi <= 16.4) {
                            condition = "Under-weight";
                        } else if (bmi <= 24.6) {
                            condition = "Normal";
                        } else if (bmi <= 29.4) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 18) {
                        if (bmi <= 16.5) {
                            condition = "Under-weight";
                        } else if (bmi <= 24.8) {
                            condition = "Normal";
                        } else if (bmi <= 29.6) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    }
                } else if (monthDef < 10 && monthDef >= 7) {   //from 6-9 month difference
                    if (yearDef == 5) {
                        if (bmi <= 12.7) {
                            condition = "Under-weight";
                        } else if (bmi <= 16.9) {
                            condition = "Normal";
                        } else if (bmi <= 19) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }
                    } else if (yearDef == 6) {
                        if (bmi <= 12.6) {
                            condition = "Under-weight";
                        } else if (bmi <= 17.1) {
                            condition = "Normal";
                        } else if (bmi <= 19.5) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 7) {
                        if (bmi <= 12.8) {
                            condition = "Under-weight";
                        } else if (bmi <= 17.6) {
                            condition = "Normal";
                        } else if (bmi <= 20.4) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 8) {
                        if (bmi <= 13) {
                            condition = "Under-weight";
                        } else if (bmi <= 18) {
                            condition = "Normal";
                        } else if (bmi <= 21) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 9) {
                        if (bmi <= 13.3) {
                            condition = "Under-weight";
                        } else if (bmi <= 18.7) {
                            condition = "Normal";
                        } else if (bmi <= 22) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 10) {
                        if (bmi <= 13.6) {
                            condition = "Under-weight";
                        } else if (bmi <= 19.5) {
                            condition = "Normal";
                        } else if (bmi <= 23.1) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 11) {
                        if (bmi <= 14.1) {
                            condition = "Under-weight";
                        } else if (bmi <= 20.4) {
                            condition = "Normal";
                        } else if (bmi <= 24.4) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 12) {
                        if (bmi <= 14.6) {
                            condition = "Under-weight";
                        } else if (bmi <= 21.4) {
                            condition = "Normal";
                        } else if (bmi <= 25.6) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 13) {
                        if (bmi <= 15.3) {
                            condition = "Under-weight";
                        } else if (bmi <= 22.3) {
                            condition = "Normal";
                        } else if (bmi <= 26.8) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 14) {
                        if (bmi <= 15.7) {
                            condition = "Under-weight";
                        } else if (bmi <= 23.2) {
                            condition = "Normal";
                        } else if (bmi <= 27.8) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 15) {
                        if (bmi <= 16) {
                            condition = "Under-weight";
                        } else if (bmi <= 23.8) {
                            condition = "Normal";
                        } else if (bmi <= 28.6) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 16) {
                        if (bmi <= 16.3) {
                            condition = "Under-weight";
                        } else if (bmi <= 24.4) {
                            condition = "Normal";
                        } else if (bmi <= 29.1) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 17) {
                        if (bmi <= 16.4) {
                            condition = "Under-weight";
                        } else if (bmi <= 24.6) {
                            condition = "Normal";
                        } else if (bmi <= 29.4) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 18) {
                        if (bmi <= 16.5) {
                            condition = "Under-weight";
                        } else if (bmi <= 24.8) {
                            condition = "Normal";
                        } else if (bmi <= 29.6) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    }
                } else if (monthDef < 13 && monthDef >= 10) {   //from 9-12 month difference
                    if (yearDef == 5) {
                        if (bmi <= 12.6) {
                            condition = "Under-weight";
                        } else if (bmi <= 17) {
                            condition = "Normal";
                        } else if (bmi <= 19.2) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }
                    } else if (yearDef == 6) {
                        if (bmi <= 12.6) {
                            condition = "Under-weight";
                        } else if (bmi <= 17.3) {
                            condition = "Normal";
                        } else if (bmi <= 19.7) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 7) {
                        if (bmi <= 12.8) {
                            condition = "Under-weight";
                        } else if (bmi <= 17.6) {
                            condition = "Normal";
                        } else if (bmi <= 20.4) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 8) {
                        if (bmi <= 13.1) {
                            condition = "Under-weight";
                        } else if (bmi <= 18.2) {
                            condition = "Normal";
                        } else if (bmi <= 21.3) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 9) {
                        if (bmi <= 13.4) {
                            condition = "Under-weight";
                        } else if (bmi <= 18.9) {
                            condition = "Normal";
                        } else if (bmi <= 22.4) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 10) {
                        if (bmi <= 13.8) {
                            condition = "Under-weight";
                        } else if (bmi <= 19.7) {
                            condition = "Normal";
                        } else if (bmi <= 23.5) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 11) {
                        if (bmi <= 14.3) {
                            condition = "Under-weight";
                        } else if (bmi <= 20.5) {
                            condition = "Normal";
                        } else if (bmi <= 24.7) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 12) {
                        if (bmi <= 14.8) {
                            condition = "Under-weight";
                        } else if (bmi <= 21.5) {
                            condition = "Normal";
                        } else if (bmi <= 26) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 13) {
                        if (bmi <= 15.4) {
                            condition = "Under-weight";
                        } else if (bmi <= 22.5) {
                            condition = "Normal";
                        } else if (bmi <= 27) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 14) {
                        if (bmi <= 15.8) {
                            condition = "Under-weight";
                        } else if (bmi <= 23.4) {
                            condition = "Normal";
                        } else if (bmi <= 28) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 15) {
                        if (bmi <= 16.1) {
                            condition = "Under-weight";
                        } else if (bmi <= 24) {
                            condition = "Normal";
                        } else if (bmi <= 28) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 16) {
                        if (bmi <= 16.3) {
                            condition = "Under-weight";
                        } else if (bmi <= 24.4) {
                            condition = "Normal";
                        } else if (bmi <= 29.3) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 17) {
                        if (bmi <= 16.5) {
                            condition = "Under-weight";
                        } else if (bmi <= 24.7) {
                            condition = "Normal";
                        } else if (bmi <= 29.5) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    } else if (yearDef == 18) {
                        if (bmi <= 16.5) {
                            condition = "Under-weight";
                        } else if (bmi <= 25) {
                            condition = "Normal";
                        } else if (bmi <= 29.6) {
                            condition = "Over-weight";
                        } else {
                            condition = "Obese";
                        }

                    }
                }


        }

        condLbl.setText(condition);
        System.out.println(condition);

        if(condition.equals("Normal")){
            body.setStyle("-fx-background-color: #e6ffe6");
            condLbl.setStyle("-fx-text-fill: green; -fx-font-size:20; -fx-font-weight:bold");
            bmiLbl.setStyle("-fx-border-color:green; -fx-font-size:25; -fx-border-width:5; -fx-border-radius:10");

        }else if(condition.equals("Under-weight")){
            body.setStyle("-fx-background-color:#ffe6e6");
            condLbl.setStyle("-fx-text-fill: red; -fx-font-size:20; -fx-font-weight:bold");
            bmiLbl.setStyle("-fx-border-color:red; -fx-font-size:25; -fx-border-width:5; -fx-border-radius:10");

        }else if(condition.equals("Over-weight")){
            body.setStyle("-fx-background-color:#ffffcc");
            condLbl.setStyle("-fx-text-fill: orange; -fx-font-size:20; -fx-font-weight:bold");
            bmiLbl.setStyle("-fx-border-color:orange; -fx-font-size:25; -fx-border-width:5; -fx-border-radius:10");

        }else if(condition.equals("Obese")){
            body.setStyle("-fx-background-color:#ffffb3");
            condLbl.setStyle("-fx-text-fill: brown; -fx-font-size:20; -fx-font-weight:bold");
            bmiLbl.setStyle("-fx-border-color:brown; -fx-font-size:25; -fx-border-width:5; -fx-border-radius:10");


        }
    }
}
