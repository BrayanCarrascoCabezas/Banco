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
import banco.rnegocio.dao.ICuenta;

public class Frmlistado_Cuenta {
    
    private TableView<Cuenta> tblCuenta;
    private Label titulo;
    private TableColumn<Cuenta, Integer> cmlCodCuenta;
    private TableColumn<Cuenta, Cliente> cmlcod_cliente;
    private VBox pnlFinal;
    
    public Frmlistado_Cuenta() {

        titulo = new Label("LISTADO DE CUENTA");
        titulo.setFont(Font.font("News701 BT", 20));
        tblCuenta = new TableView();
        cmlCodCuenta = new TableColumn<>("Codigo Cuenta");
        cmlcod_cliente = new TableColumn<>("Codigo Cliente");
       
        tblCuenta.getColumns().addAll(cmlCodCuenta, cmlcod_cliente);
        cargarCuenta();
        pnlFinal = new VBox();
        Image fondoFinal = new Image("file:src\\kardex\\multimedia\\images\\fondo.jpg");
        BackgroundImage fondo = new BackgroundImage(fondoFinal, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pnlFinal.setBackground(new Background(fondo));
        pnlFinal.setStyle("-fx-padding: 10; -fx-border-color: orange ; -fx-border-width: 2px");
        pnlFinal.getChildren().addAll(titulo, tblCuenta);
        pnlFinal.setAlignment(Pos.CENTER);
    }

    public VBox getPnlFinal() {
        return pnlFinal;
    }

    public void cargarCuenta() {
        List<Cuenta> listCuenta = new ArrayList<>();
        ICuenta cuDao = new CuentaImpl();

        try {
            listCuenta = cuDao.obtener();
            cmlCodCuenta.setCellValueFactory(new PropertyValueFactory<>("codigo cuenta"));
            cmlcod_cliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
            tblCuenta.getItems().addAll(listCuenta);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}

