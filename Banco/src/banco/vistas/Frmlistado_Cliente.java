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
import banco.rnegocio.dao.*;
import banco.rnegocio.entidades.*;
import banco.rnegocio.impl.*;
import banco.accesodatos.*;

public class Frmlistado_Cliente {
    private TableView<Cliente> tblCliente;
    private Label titulo;
    private TableColumn<Cliente, Integer> cmlCedula;
    private TableColumn<Cliente, String> cmlNombre;
    private TableColumn<Cliente, String> cmlApellido;
    private TableColumn<Cliente, String> cmlDireccion;
    private TableColumn<Cliente, String> cmlTelefono;
    private TableColumn<Cliente, String> cmleMail;
    private TableColumn<Cliente, String> cmlFechaNac;
    private VBox pnlFinal;

    public Frmlistado_Cliente() {
        titulo = new Label("LISTADO DE CLIENTES");
        titulo.setFont(Font.font("News701 BT", 20));
        tblCliente = new TableView();
        cmlCedula = new TableColumn<>("Codigo");
        cmlNombre = new TableColumn<>("Nombres");
        cmlApellido = new TableColumn<>("Apellidos");
        cmlDireccion = new TableColumn<>("Direccion");
        cmlDireccion.setMaxWidth(150);
        cmlDireccion.setMinWidth(150);
        cmlTelefono = new TableColumn<>("Telefono");
        cmleMail = new TableColumn<>("Email");
        cmleMail.setMaxWidth(150);
        cmleMail.setMinWidth(150);
        cmlFechaNac = new TableColumn<>("Fecha_Nacimiento");
        tblCliente.getColumns().addAll(cmlCedula, cmlNombre, cmlApellido, cmlDireccion, cmlTelefono, cmleMail, cmlFechaNac);
        cargarClientes();
        pnlFinal = new VBox();
        pnlFinal.getChildren().addAll(titulo, tblCliente);
        pnlFinal.setAlignment(Pos.CENTER);
    }

    public VBox getPnlFinal() {
        return pnlFinal;
    }

    public void cargarClientes() {
        List<Cliente> listCliente = new ArrayList<>();
        ICliente clientDao = new ClienteImpl();

        try {
            listCliente = clientDao.obtener();
            cmlCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
            cmlNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            cmlApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
            cmlDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
            cmlTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
            cmleMail.setCellValueFactory(new PropertyValueFactory<>("email"));
            cmlFechaNac.setCellValueFactory(new PropertyValueFactory<>("fechaNac"));
            tblCliente.getItems().addAll(listCliente);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}

