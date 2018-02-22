
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
import banco.rnegocio.dao.ICiudad;
public class FrmListado_Ciudad {
    private TableView<Ciudad> tblCiudad;
    private Label titulo;
    private TableColumn<Ciudad, Integer> cmlCodCiudad;
    private TableColumn<Ciudad, String> cmlNombreCiudad;
    
    private VBox pnlFinal;

    
    public FrmListado_Ciudad() {

        titulo = new Label("LISTADO DE CIUDAD");
        titulo.setFont(Font.font("News701 BT", 20));
        tblCiudad = new TableView();
        cmlCodCiudad = new TableColumn<>("Codigo");
        cmlNombreCiudad = new TableColumn<>("Nombre");
     
        tblCiudad.getColumns().addAll(cmlCodCiudad, cmlNombreCiudad);
        cargarCiudad();
        pnlFinal = new VBox();
       
     
     
       
        pnlFinal.getChildren().addAll(titulo, tblCiudad);
        pnlFinal.setAlignment(Pos.CENTER);
    }

    public VBox getPnlFinal() {
        return pnlFinal;
    }

    public void cargarCiudad() {
        List<Ciudad> listCiudad = new ArrayList<>();
        ICiudad ciDao = new CiudadImpl();

        try {
            listCiudad = ciDao.obtener();
            cmlCodCiudad.setCellValueFactory(new PropertyValueFactory<>("codigoCiudad"));
            cmlNombreCiudad.setCellValueFactory(new PropertyValueFactory<>("nombre"));
           
            tblCiudad.getItems().addAll(listCiudad);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            Group ptnError = new Group();
            ptnError.getChildren().add(new Label("Error: " + e.getMessage()));
            Scene error = new Scene(ptnError, 0, 0);
        }
    }
}

