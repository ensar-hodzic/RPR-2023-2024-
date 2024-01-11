module ba.unsa.etf.rpr.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens ba.unsa.etf.rpr.demo to javafx.fxml;
    exports ba.unsa.etf.rpr.demo;
}