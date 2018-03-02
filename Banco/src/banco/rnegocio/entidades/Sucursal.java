/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.rnegocio.entidades;

/**
 *
 * @author WILCXMAC
 */
import java.util.*;
import java.sql.*;
public class Sucursal {
    private int id_sucursal;
    private Empleado empleado;
    private Ciudad ciudad;

    public Sucursal() {
    }

    public Sucursal(int id_sucursal, Empleado empleado, Ciudad ciudad) {
        this.id_sucursal = id_sucursal;
        this.empleado = empleado;
        this.ciudad = ciudad;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "id_sucursal=" + id_sucursal + '}';
    }
    
}

