package ba.unsa.etf.rpr.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;


public class GradContr {
    @FXML
    ChoiceBox<String> choiceDrzava;
    @FXML
    TextField textBrojStanovnika;
    @FXML
    TextField textNaziv;
    private boolean finished;

    private GeografijaDAO geo;

    public GradContr() throws SQLException, ClassNotFoundException {
        geo=GeografijaDAO.getInstance();
    }
    @FXML
    public void initialize() throws SQLException {
        ObservableList<String> list= FXCollections.observableArrayList();
        ArrayList<Drzava> drzave= geo.drzave();
        for(Drzava d: drzave) list.add(d.getNaziv());
        choiceDrzava.setItems(list);
    }

    public void cancel(ActionEvent mouseEvent) {
        Node n = (Node) mouseEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.hide();
        finished=false;
    }

    public Grad return_value(){
        return new Grad(textNaziv.getText(),Integer.parseInt(textBrojStanovnika.getText()),choiceDrzava.getValue());
    }

    public boolean getCompleted() {
        return this.finished;
    }

    public void accept(ActionEvent actionEvent) {
        try {
            if (textNaziv.getText().equals("") || textBrojStanovnika.getText().equals("") || choiceDrzava.getValue() == null) {
                textNaziv.setStyle("-fx-background-color: #ffaca3;");
                textBrojStanovnika.setStyle("-fx-background-color: #ffaca3;");
                choiceDrzava.setStyle("-fx-background-color: #ffaca3;");
            } else if (Integer.parseInt(textBrojStanovnika.getText()) < 0) {
                textNaziv.setStyle("-fx-background-color: #ffaca3;");
                textBrojStanovnika.setStyle("-fx-background-color: #ffaca3;");
                choiceDrzava.setStyle("-fx-background-color: #ffaca3;");
            } else {
                Node n = (Node) actionEvent.getSource();
                Stage stage = (Stage) n.getScene().getWindow();
                stage.hide();
                finished = true;
            }
        }
        catch (NumberFormatException e){
            textNaziv.setStyle("-fx-background-color: #ffaca3;");
            textBrojStanovnika.setStyle("-fx-background-color: #ffaca3;");
            choiceDrzava.setStyle("-fx-background-color: #ffaca3;");
        }
    }

    public void refresh(KeyEvent keyEvent) {
        textNaziv.setStyle("");
        textBrojStanovnika.setStyle("");
        choiceDrzava.setStyle("");
    }
}
