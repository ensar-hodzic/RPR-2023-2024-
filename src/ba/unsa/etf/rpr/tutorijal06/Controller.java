package ba.unsa.etf.rpr.tutorijal06;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    private Label output;
    private String trenutni;
    private Double rez;
    private char op;
    public Controller(){
        trenutni="0";
        op='0';
        rez=(double) 0;
        output= new Label();
        output.setText(trenutni);
    }

    private void akoJeBilaNula(){
        if(trenutni.equals("0")) {
            trenutni="";
            output.setText(trenutni);
        }
    }

    private void izvrsiOperaciju(char op){
        Double temp=Double.parseDouble(trenutni);
        if(op=='+') rez=rez+temp;
        if(op=='-') rez=rez-temp;
        if(op=='*') rez=rez*temp;
        if(op=='/') rez=rez/temp;
        if(op=='%') rez=rez*(temp/100);
        trenutni="0";
    }

    public void addMod(MouseEvent mouseEvent) {
        if(op=='0') {
            rez= Double.parseDouble(trenutni);
            trenutni="0";
            op='%';
        }
        else izvrsiOperaciju(op);
    }

    public void addDiv(MouseEvent mouseEvent) {
        if(op=='0') {
            rez= Double.parseDouble(trenutni);
            trenutni="0";
            op='/';
        }
        else izvrsiOperaciju(op);
    }

    public void addPlus(MouseEvent mouseEvent) {
        if(op=='0') {
            rez= Double.parseDouble(trenutni);
            trenutni="0";
            op='+';
        }
        else izvrsiOperaciju(op);
    }

    public void addMult(MouseEvent mouseEvent) {
        if(op=='0') {
            rez= Double.parseDouble(trenutni);
            trenutni="0";
            op='*';
        }
        else izvrsiOperaciju(op);
    }

    public void addMin(MouseEvent mouseEvent) {
        if(op=='0') {
            rez= Double.parseDouble(trenutni);
            trenutni="0";
            op='-';
        }
        else izvrsiOperaciju(op);
    }

    public void equals(MouseEvent mouseEvent) {
        if(!(op=='0')) {
            izvrsiOperaciju(op);
            output.setText(Double.toString(rez));
            op='0';
            rez=(double) 0;
        }
    }

    public void add1(MouseEvent mouseEvent) {
        akoJeBilaNula();
        trenutni+="1";
        output.setText(trenutni);
    }
    public void add2(MouseEvent mouseEvent) {
        akoJeBilaNula();
        trenutni+="2";
        output.setText(trenutni);
    }
    public void add3(MouseEvent mouseEvent) {
        akoJeBilaNula();
        trenutni+="3";
        output.setText(trenutni);
    }
    public void add4(MouseEvent mouseEvent) {
        akoJeBilaNula();
        trenutni+="4";
        output.setText(trenutni);
    }
    public void add5(MouseEvent mouseEvent) {
        akoJeBilaNula();
        trenutni+="5";
        output.setText(trenutni);
    }
    public void add6(MouseEvent mouseEvent) {
        akoJeBilaNula();
        trenutni+="6";
        output.setText(trenutni);
    }
    public void add7(MouseEvent mouseEvent) {
        akoJeBilaNula();
        trenutni+="7";
        output.setText(trenutni);
    }
    public void add8(MouseEvent mouseEvent) {
        akoJeBilaNula();
        trenutni+="8";
        output.setText(trenutni);
    }
    public void add9(MouseEvent mouseEvent) {
        akoJeBilaNula();
        trenutni+="9";
        output.setText(trenutni);
    }
    public void add0(MouseEvent mouseEvent) {
        akoJeBilaNula();
        trenutni+="0";
        output.setText(trenutni);
    }

    public void addDot(MouseEvent mouseEvent) {
        if(output.getText().equals("0")) {
            trenutni="0.";
            output.setText(trenutni);
        }
        else if(!(output.getText().contains("."))){
            trenutni+=".";
            output.setText(trenutni);
        }
    }

}
