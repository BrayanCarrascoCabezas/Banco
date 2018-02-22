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
import java.util.Date;
public class Prestamo {
   private int id_prestamo; 
   private int importe;
   private int abono;
   private Date fecha;
   private int valor;
   private Sucursal sucursal;

    public Prestamo() {
    }

    public Prestamo(int id_prestamo, int importe, int abono, Date fecha, int valor, Sucursal sucursal) {
        this.id_prestamo = id_prestamo;
        this.importe = importe;
        this.abono = abono;
        this.fecha = fecha;
        this.valor = valor;
        this.sucursal = sucursal;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public int getAbono() {
        return abono;
    }

    public void setAbono(int abono) {
        this.abono = abono;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return Integer.toString(id_prestamo);
    }

 
}