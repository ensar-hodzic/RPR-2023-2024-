package ba.unsa.etf.rpr.tutorijal06;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ApplicationExtension.class)
class MainTest {

    private Label output;

    @Start
    public void start (Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(getClass().getResource("/fxml/digitron.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @Test
    public void startWithZero (FxRobot robot) {
        output = robot.lookup("#output").queryAs(Label.class);
        assertEquals("0", output.getText());
    }

    @Test
    public void numberOne (FxRobot robot) {
        output = robot.lookup("#output").queryAs(Label.class);
        robot.clickOn("#btn1");
        assertEquals("1", output.getText());
    }

    @Test
    public void number123 (FxRobot robot) {
        output = robot.lookup("#output").queryAs(Label.class);
        robot.clickOn("#btn1");
        robot.clickOn("#btn2");
        robot.clickOn("#btn3");
        assertEquals("123", output.getText());
    }

    @Test
    public void number123Plus456 (FxRobot robot) {
        output = robot.lookup("#output").queryAs(Label.class);
        robot.clickOn("#btn1");
        robot.clickOn("#btn2");
        robot.clickOn("#btn3");
        robot.clickOn("#plusBtn");
        robot.clickOn("#btn4");
        robot.clickOn("#btn5");
        robot.clickOn("#btn6");
        assertEquals("456", output.getText());
    }

    @Test
    public void number123Plus456Equals (FxRobot robot) {
        output = robot.lookup("#output").queryAs(Label.class);
        robot.clickOn("#btn1");
        robot.clickOn("#btn2");
        robot.clickOn("#btn3");
        robot.clickOn("#plusBtn");
        robot.clickOn("#btn4");
        robot.clickOn("#btn5");
        robot.clickOn("#btn6");
        robot.clickOn("#equalsBtn");
        assertEquals("579.0", output.getText());
    }

    @Test
    public void dotBtn (FxRobot robot) {
        output = robot.lookup("#output").queryAs(Label.class);
        robot.clickOn("#btn8");
        robot.clickOn("#btn8");
        robot.clickOn("#dotBtn");
        robot.clickOn("#btn8");
        robot.clickOn("#btn8");
        robot.clickOn("#plusBtn");
        robot.clickOn("#btn1");
        robot.clickOn("#equalsBtn");
        assertEquals("89.88", output.getText());
    }

    @Test
    public void zeroBtn (FxRobot robot) {
        output = robot.lookup("#output").queryAs(Label.class);
        robot.clickOn("#btn0");
        robot.clickOn("#btn0");
        assertEquals("0", output.getText());
    }

    @Test
    public void zeroBtn2 (FxRobot robot) {
        output = robot.lookup("#output").queryAs(Label.class);
        robot.clickOn("#btn0");
        robot.clickOn("#btn0");
        robot.clickOn("#btn1");
        robot.clickOn("#btn0");
        assertEquals("10", output.getText());
    }
}