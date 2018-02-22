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
import banco.rnegocio.dao.ISucursal;

public class Frmlistado_Sucursal {
    private TableView<Sucursal> tblSucursal;
    private Label titulo;
    private TableColumn<Sucursal, Integer> cmlCodsucursal;
    private TableColumn<Sucursal, Empleado> cmlid_empleado;
    private TableColumn<Sucursal, Ciudad> cmlCodCiudad;

    private VBox pnlFinal;
    
      public Frmlistado_Sucursal() {

        titulo = new Label("LISTADO DE SUCURSAL");
        titulo.setFont(Font.font("News701 BT", 20));
        tblSucursal = new TableView();
        cmlCodsucursal = new TableColumn<>("Codigo Sucursal");
        cmlid_empleado = new TableColumn<>("Empleado");
        cmlCodCiudad = new TableColumn<>("Ciudad");
       
        tblSucursal.getColumns().addAll(cmlCodsucursal, cmlid_empleado, cmlCodCiudad);
        cargarSucursal();
        pnlFinal = new VBox();
        Image fondoFinal = new Image("file:src\\kardex\\multimedia\\images\\fondo.jpg");
        BackgroundImage fondo = new BackgroundImage(fondoFinal, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pnlFinal.setBackground(new Background(fondo));
        pnlFinal.setStyle("-fx-padding: 10; -fx-border-color: orange ; -fx-border-width: 2px");
        pnlFinal.getChildren().addAll(titulo, tblSucursal);
        pnlFinal.setAlignment(Pos.CENTER);
    }

    public VBox getPnlFinal() {
        return pnlFinal;
    }

    public void cargarSucursal() {
        List<Sucursal> listSucursal = new ArrayList<>();
        ISucursal suDao = new SucursalImpl();

        try {
            listSucursal = suDao.obtener();
            cmlCodsucursal.setCellValueFactory(new PropertyValueFactory<>("codigoSucursal"));
            cmlid_empleado.setCellValueFactory(new PropertyValueFactory<>("empleado"));
            cmlCodCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
            tblSucursal.getItems().addAll(listSucursal);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}




