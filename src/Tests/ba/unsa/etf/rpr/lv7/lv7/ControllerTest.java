package ba.unsa.etf.rpr.lv7.lv7;

import static org.junit.jupiter.api.Assertions.*;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.ListViewMatchers;

@ExtendWith(ApplicationExtension.class)
class ControllerTest {
    private ListView<Korisnik> lista;
    @Start
    public void start (Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(getClass().getResource("/ba/unsa/etf/rpr/lv7/lv7/korisnici.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }
    @Test
    public void pocetniTest(FxRobot robot){
        lista=robot.lookup("#list").queryAs(ListView.class);
        assertEquals("Ensar",lista.getItems().get(0).getIme());
        assertEquals("",lista.getItems().get(2).getIme());
    }
    @Test
    public void dodajTest(FxRobot robot){
        robot.lookup("#ime").queryAs(TextField.class).setText("Edin");
        robot.lookup("#prezime").queryAs(TextField.class).setText("Dadan");
        robot.lookup("#email").queryAs(TextField.class).setText("edindadan@mail.com");
        robot.lookup("#user").queryAs(TextField.class).setText("edomedo");
        robot.lookup("#pass").queryAs(TextField.class).setText("everiday");
        robot.clickOn("#dodaj");
        lista=robot.lookup("#list").queryAs(ListView.class);
        assertEquals("Edin",lista.getItems().get(2).getIme());
    }
}