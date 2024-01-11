package ba.unsa.etf.rpr.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;


public class GlavnaContr {
    @FXML
    public TableColumn colNaziv;
    @FXML
    public TableColumn colBrojStanovnika;
    @FXML
    public TableColumn colDrzava;
    @FXML
    private TableView<Grad> tableViewGradovi;
    private GeografijaDAO geo;
    ObservableList<Grad> tableData= FXCollections.observableArrayList();;

    private void listRefresh() throws SQLException {
        tableData.clear();
        ArrayList<Grad> gradovi=geo.gradovi();
        tableData.addAll(gradovi);
    }

    public GlavnaContr() throws SQLException, ClassNotFoundException {
        geo = GeografijaDAO.getInstance();
    }

    @FXML
    public void initialize() throws SQLException {
        listRefresh();
        colNaziv.setCellValueFactory(new PropertyValueFactory<Grad, String>("naziv"));
        colBrojStanovnika.setCellValueFactory(new PropertyValueFactory<Grad, Integer>("populacija"));
        colDrzava.setCellValueFactory(new PropertyValueFactory<Grad, String>("drzava"));
        tableViewGradovi.setItems(tableData);

    }

    private Object noviProzor(String tip) throws IOException, SQLException, ClassNotFoundException {
        Stage novi = new Stage();
        FXMLLoader loader = new FXMLLoader();
        String path = null;
        String title = null;
        int height = 0;
        if (tip.equals("grad")) {
            path = "grad.fxml";
            height = 167;
            title = "Grad";
        }
        if (tip.equals("drzava")) {
            path = "drzava.fxml";
            height = 130;
            title = "Drzava";
        }
        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();
        novi.setTitle(title);
        novi.setResizable(false);
        novi.setScene(new Scene(root, 300, height));
        novi.showAndWait();
        Object rez=null;
        if(tip.equals("drzava")){
            DrzavaContr controller = loader.getController();
            if (controller.getCompleted()) {
                rez = controller.return_value();
            }
        }
        else {
            GradContr controller = loader.getController();
            if (controller.getCompleted()) {
                rez = controller.return_value();
            }
        }
        novi.close();
        return rez;
    }

    public void dodajGrad(MouseEvent mouseEvent) throws IOException, SQLException, ClassNotFoundException {
        Grad grad= (Grad) noviProzor("grad");
        try{
        geo.dodajGrad(grad);
        listRefresh();
        }
        catch (NullPointerException e){
        }
    }

    public void dodajDrzavu(MouseEvent mouseEvent) throws IOException, SQLException, ClassNotFoundException {
        Drzava drzava= (Drzava) noviProzor("drzava");
        try {
            geo.dodajDrzavu(drzava);
            listRefresh();
        }
        catch (NullPointerException e){
        }
    }

    public void izmijeniGrad(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        Grad grad= (Grad) noviProzor("grad");
        try{
            geo.izmijeniGrad(grad);
            listRefresh();
        }
        catch (NullPointerException e){
        }
        catch(SQLException e){
            Stage novi = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("error.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 200, 75);
            novi.setResizable(false);
            novi.setTitle("Error");
            novi.setScene(scene);
            novi.show();
        }
    }

    public void obrisiGrad(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        if(tableViewGradovi.getSelectionModel().selectedItemProperty().get()!=null){
            geo.obrisiGrad(tableViewGradovi.getSelectionModel().selectedItemProperty().get().getNaziv());
            listRefresh();
        }
    }
}