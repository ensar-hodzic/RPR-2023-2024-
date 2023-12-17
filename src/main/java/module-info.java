module ba.unsa.etf.rpr.lv7.lv7 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires eu.hansolo.tilesfx;
    requires java.xml;

    opens ba.unsa.etf.rpr.lv7.lv7 to javafx.fxml;
    exports ba.unsa.etf.rpr.lv7.lv7;
}