/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.rnegocio.entidades;
import java.util.*;
import java.sql.*;
import java.util.Date;

public class Empleado {
private int id_empleado;
private String nombres;
private String apellidos;
private Date fecha_ingreso;
private Date antiguedad;

    public Empleado() {
    }

    public Empleado(int id_empleado, String nombres, String apellidos, Date fecha_ingreso, Date antiguedad) {
        this.id_empleado = id_empleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecha_ingreso = fecha_ingreso;
        this.antiguedad = antiguedad;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Date antiguedad) {
        this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
        return nombres;
    }

}

