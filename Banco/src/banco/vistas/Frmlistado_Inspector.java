/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.vistas;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import java.util.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import java.lang.reflect.*;
import java.text.*;
import javafx.beans.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.stage.*;
import javafx.scene.image.*;
import banco.rnegocio.entidades.*;
import banco.rnegocio.impl.*;
import banco.accesodatos.*;
import banco.rnegocio.dao.IInspector;


public class Frmlistado_Inspector {
    
    private TableView<Inspector> tblInspector;
    private Label titulo;
    private TableColumn<Inspector, Integer> cmlCodinspector;
    private TableColumn<Inspector, String> cmlNombre;
    private TableColumn<Inspector, String> cmlDireccion;
    private TableColumn<Inspector, String> cmlTitulo;

    private TableColumn<Inspector, Prestamo> cmlcod_prestamo;
  

    private VBox pnlFinal;
    
      public Frmlistado_Inspector() {

        titulo = new Label("LISTADO DE INSPECTOR");
        titulo.setFont(Font.font("News701 BT", 20));
        tblInspector = new TableView();
        cmlCodinspector = new TableColumn<>("Codigo Inspector");
        cmlNombre = new TableColumn<>("Nombre");
        cmlDireccion = new TableColumn<>("Direccion");
        cmlTitulo = new TableColumn<>("Titulo");
        cmlcod_prestamo = new TableColumn<>("Prestamo");
  
        tblInspector.getColumns().addAll(cmlCodinspector ,cmlNombre, cmlDireccion, cmlTitulo, cmlcod_prestamo);
        cargarInspector();
        pnlFinal = new VBox();
        Image fondoFinal = new Image("file:src\\kardex\\multimedia\\images\\fondo.jpg");
        BackgroundImage fondo = new BackgroundImage(fondoFinal, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pnlFinal.setBackground(new Background(fondo));
        pnlFinal.setStyle("-fx-padding: 10; -fx-border-color: orange ; -fx-border-width: 2px");
        pnlFinal.getChildren().addAll(titulo, tblInspector);
        pnlFinal.setAlignment(Pos.CENTER);
    }

    public VBox getPnlFinal() {
        return pnlFinal;
    }

    public void cargarInspector() {
        List<Inspector> listInspector = new ArrayList<>();
        IInspector inDao = new InspectorImpl();

        try {
            listInspector = inDao.obtener();
            cmlCodinspector.setCellValueFactory(new PropertyValueFactory<>("codigoInspector"));
            cmlNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
            cmlDireccion.setCellValueFactory(new PropertyValueFactory<>("Direcion"));
            cmlTitulo.setCellValueFactory(new PropertyValueFactory<>("Titulo"));
            cmlcod_prestamo.setCellValueFactory(new PropertyValueFactory<>("Prestamo"));
            tblInspector.getItems().addAll(listInspector);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}
