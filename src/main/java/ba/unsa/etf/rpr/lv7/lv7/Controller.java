package ba.unsa.etf.rpr.lv7.lv7;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    public ListView<Korisnik> list;
    @FXML
    public TextField ime;
    @FXML
    public TextField prezime;
    @FXML
    public TextField email;
    @FXML
    public TextField user;
    @FXML
    public TextField pass;


    private KorisniciModel model= new KorisniciModel();

    public Controller() {
        model.napuni();
    }

    @FXML
    public void initialize() {
        list.setItems(model.getKorisnici());
        model.trenutniProperty().addListener((obs,oldKorisnik,newKorisnik)->{
            if(oldKorisnik!=null){
                ime.textProperty().unbindBidirectional(oldKorisnik.imeProperty());
                prezime.textProperty().unbindBidirectional(oldKorisnik.prezimeProperty());
                user.textProperty().unbindBidirectional(oldKorisnik.usernameProperty());
                email.textProperty().unbindBidirectional(oldKorisnik.emailProperty());
                pass.textProperty().unbindBidirectional(oldKorisnik.passProperty());
            }
            if(newKorisnik==null){
                ime.setText("");
            }
            else{
                ime.textProperty().bindBidirectional(newKorisnik.imeProperty());
                prezime.textProperty().bindBidirectional(newKorisnik.prezimeProperty());
                user.textProperty().bindBidirectional(newKorisnik.usernameProperty());
                email.textProperty().bindBidirectional(newKorisnik.emailProperty());
                pass.textProperty().bindBidirectional(newKorisnik.passProperty());
            }
        });
        Korisnik novi=new Korisnik("","","","","");
        model.getKorisnici().add(novi);
        model.setTrenutni(novi);
    }

    public void dodaj(MouseEvent actionEvent) {
        Korisnik novi=new Korisnik("","","","","");
        model.getKorisnici().add(novi);
        model.setTrenutni(novi);
        list.refresh();
    }

    public void bjazi(javafx.scene.input.MouseEvent mouseEvent) {
        System.exit(0);
    }

    public void promjenaKorisnika(javafx.scene.input.MouseEvent mouseEvent) {
        Korisnik selektovani=list.getSelectionModel().getSelectedItem();
        model.setTrenutni(selektovani);
    }
}