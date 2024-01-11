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
import javafx.scene.layout.BackgroundFill;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.sql.SQLException;
import java.util.ArrayList;

import static ba.unsa.etf.rpr.demo.GeografijaDAO.removeInstance;

public class DrzavaContr {
    @FXML
    private ChoiceBox<String> choiceGrad;
    @FXML
    TextField textNaziv;
    private boolean finished;
    private GeografijaDAO geo;

    public DrzavaContr() throws SQLException, ClassNotFoundException {
        geo=GeografijaDAO.getInstance();
    }

    @FXML
    public void initialize() throws SQLException {
        ObservableList<String> list= FXCollections.observableArrayList();
        ArrayList<Grad> gradovi= geo.gradovi();
        for(Grad d: gradovi) list.add(d.getNaziv());
        choiceGrad.setItems(list);
    }

    public void cancel(ActionEvent mouseEvent) {
        Node n = (Node) mouseEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.hide();
        finished=false;
    }

    public Drzava return_value(){
        return new Drzava(textNaziv.getText(),choiceGrad.getValue());
    }

    public boolean getCompleted() {
        return this.finished;
    }

    public void accept(ActionEvent mouseEvent) {
        if(textNaziv.getText().equals("") || choiceGrad.getValue()==null){
            textNaziv.setStyle("-fx-background-color: #ffaca3;");
            choiceGrad.setStyle("-fx-background-color: #ffaca3;");
        }
        else {
            Node n = (Node) mouseEvent.getSource();
            Stage stage = (Stage) n.getScene().getWindow();
            stage.hide();
            finished = true;
        }
    }

    public void refresh(KeyEvent keyEvent) {
        textNaziv.setStyle("");
        choiceGrad.setStyle("");
    }
}
