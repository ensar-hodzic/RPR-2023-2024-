package ba.unsa.etf.rpr.lv7.lv7;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.w3c.dom.events.MouseEvent;

import java.util.ArrayList;

public class Controller {
    @FXML
    private ListView<Korisnik> list;
    @FXML
    private TextField ime;
    @FXML
    private TextField prezime;
    @FXML
    private TextField email;
    @FXML
    private TextField user;
    @FXML
    private TextField pass;

    private KorisniciModel model;

    private ArrayList<Korisnik> arejlista;

    public void setArejlista()
    {
        arejlista=new ArrayList<>();
        String tIme="huso", tPrezime="hamzic", tEmail="hhamzic1", tKorisnickoIme="who.so", tSifra="blabla";
        for (int l = 0; l < 4; l++) {
            arejlista.add(new Korisnik(tIme + Integer.toString(l), tPrezime+Integer.toString(l),
                    tEmail+Integer.toString(l), tKorisnickoIme+Integer.toString(l), tSifra+Integer.toString(l)));
        }

    }

    ChangeListener<String> zaIme = new ChangeListener<String>(){
        @Override
        public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
            model.setTrenutni(model.getTrenutni().get());
            if(!t1.equals(model.getTrenutni().get().imeProperty().get()))
            {
                model.getTrenutni().get().setIme(t1);
            }
            list.refresh();
        }

    };
    ChangeListener<String> zaPrezime = new ChangeListener<String>(){
        @Override
        public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
            model.setTrenutni(model.getTrenutni().get());
            if(!t1.equals(model.getTrenutni().get().prezimeProperty().get()))
            {
                model.getTrenutni().get().setPrezime(t1);
            }
            list.refresh();
        }

    };
    ChangeListener<String> zaEmail = new ChangeListener<String>(){
        @Override
        public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
            model.setTrenutni(model.getTrenutni().get());
            if(!t1.equals(model.getTrenutni().get().emailProperty().get()))
            {
                model.getTrenutni().get().setEmail(t1);
            }
            list.refresh();
        }

    };

    ChangeListener<String> zaKorisnickoIme = new ChangeListener<String>(){
        @Override
        public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
            model.setTrenutni(model.getTrenutni().get());
            if(!t1.equals(model.getTrenutni().get().usernameProperty().get()))
            {
                model.getTrenutni().get().setUsername(t1);
            }
            list.refresh();
        }
    };
    ChangeListener<String> zaSifru;

    {
        zaSifru = new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                model.setTrenutni(model.getTrenutni().get());
                if(!t1.equals(model.getTrenutni().get().passProperty().get()))
                {
                    model.getTrenutni().get().setPass(t1);
                }
                list.refresh();
            }
        };
    }


    @FXML
    public void initialize() {
        if(model==null) {
            model = new KorisniciModel();
            list = new ListView<>();
            this.setArejlista();
            model.napuni(arejlista);
            list.setItems(model.getKorisnici());
        }
        ime.textProperty().bindBidirectional(model.getTrenutni().get().imeProperty());
        prezime.textProperty().bindBidirectional(model.getTrenutni().get().prezimeProperty());
        email.textProperty().bindBidirectional(model.getTrenutni().get().emailProperty());
        user.textProperty().bindBidirectional(model.getTrenutni().get().usernameProperty());
        pass.textProperty().bindBidirectional(model.getTrenutni().get().passProperty());

        /*ime.textProperty().addListener(zaIme);
        prezime.textProperty().addListener(zaPrezime);
        email.textProperty().addListener(zaEmail);
        user.textProperty().addListener(zaKorisnickoIme);
        pass.textProperty().addListener(zaSifru);
        list.refresh();
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Korisnik>() {
            @Override
            public void changed(ObservableValue<? extends Korisnik> observableValue, Korisnik korisnik, Korisnik t1) {
                model.setTrenutni(t1);
                if(t1.imeProperty()!=null) ime.textProperty().setValue(model.getTrenutni().get().imeProperty().getValue());
                else if(t1.imeProperty()==null) ime.setText("");
                if(t1.prezimeProperty()!=null) prezime.textProperty().setValue(model.getTrenutni().get().prezimeProperty().getValue());
                else if(t1.prezimeProperty()==null) prezime.setText("");
                if(t1.emailProperty()!=null) email.textProperty().setValue(model.getTrenutni().get().emailProperty().getValue());
                else if(t1.emailProperty()==null) email.setText("");
                if(t1.usernameProperty()!=null) user.textProperty().setValue(model.getTrenutni().get().usernameProperty().getValue());
                else if(t1.usernameProperty()==null) user.setText("");
                if(t1.passProperty()!=null) pass.textProperty().setValue(model.getTrenutni().get().passProperty().getValue());
                else if(t1.passProperty()==null) pass.setText("");
            }
        });*/
    }

    public void dodaj(javafx.scene.input.MouseEvent mouseEvent){
        Korisnik k = new Korisnik("","","","","");
        model.dodajNovogKorisnika(k);
        ime.setText("");
        prezime.setText("");
        email.setText("");
        user.setText("");
        pass.setText("");
        list.refresh();
    }

    public void bjazi(javafx.scene.input.MouseEvent mouseEvent) {
        System.exit(0);
    }
}