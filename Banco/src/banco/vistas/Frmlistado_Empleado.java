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

public class Frmlistado_Empleado {
    
    private TableView<Empleado> tblEmpleado;
    private Label titulo;
    private TableColumn<Empleado, Integer> cmlid_empleado;
    private TableColumn<Empleado, String> cmlNombres;
    private TableColumn<Empleado, String> cmlApellidos;
     private TableColumn<Empleado, String> cmlfechaingreso;
    private TableColumn<Empleado, String> cmlantiguedad;
    private VBox pnlFinal;
    
     public Frmlistado_Empleado(){

        titulo = new Label("LISTADO DE EEMPLEADOS");
        titulo.setFont(Font.font("News701 BT", 20));
        tblEmpleado = new TableView();
        cmlid_empleado = new TableColumn<>("id_empleado");
        cmlNombres = new TableColumn<>("Nombres");
        cmlApellidos = new TableColumn<>("Apellidos");
        cmlApellidos.setMaxWidth(250);
        cmlApellidos.setMinWidth(250);
        cmlfechaingreso = new TableColumn<>("Fecha ingreso");
        cmlantiguedad = new TableColumn<>("Antiguedad");
       
        tblEmpleado.getColumns().addAll(cmlid_empleado, cmlNombres, cmlApellidos, cmlfechaingreso, cmlantiguedad);
        cargarEmpleado();
        pnlFinal = new VBox();
       
        pnlFinal.getChildren().addAll(titulo, tblEmpleado);
        pnlFinal.setAlignment(Pos.CENTER);
    }

    public void cargarEmpleado() {
        List<Empleado> listEmpleado = new ArrayList<>();
        IEmpleado empDao = new EmpleadoImpl();

        try {
            listEmpleado = empDao.obtener();
            cmlid_empleado.setCellValueFactory(new PropertyValueFactory<>("id_empleado"));
            cmlNombres.setCellValueFactory(new PropertyValueFactory<>("nombres"));
            cmlApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
            cmlfechaingreso.setCellValueFactory(new PropertyValueFactory<>("fecha ingreso"));
            cmlantiguedad.setCellValueFactory(new PropertyValueFactory<>("antiguedad"));
            tblEmpleado.getItems().addAll(listEmpleado);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }

    public VBox getPnlFinal() {
        return pnlFinal;
    }
}

