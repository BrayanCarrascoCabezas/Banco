/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.rnegocio.impl;

import banco.accesodatos.*;
import banco.rnegocio.entidades.*;
import banco.rnegocio.dao.IEmpleado;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WILCXMAC
 */
public class EmpleadoImpl implements IEmpleado{
    

     @Override
     
    public int insertar(Empleado empleado) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into Empleado  values (?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, empleado.getId_empleado()));
        lstPar.add(new Parametro(2, empleado.getNombres()));
        lstPar.add(new Parametro(3, empleado.getApellidos()));
        lstPar.add(new Parametro(4, empleado.getFecha_ingreso()));
        lstPar.add(new Parametro(5, empleado.getAntiguedad()));
        Conexion con=null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Empleado empleado) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "update  Empleado set idEmpleado=?,nombres=?,apellidos=?"
                + ",fecha_ingreso=?,antiguedad=? where idEmpleado=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, empleado.getId_empleado()));
        lstPar.add(new Parametro(2, empleado.getNombres()));
        lstPar.add(new Parametro(3, empleado.getApellidos()));
        lstPar.add(new Parametro(4, empleado.getFecha_ingreso()));
        lstPar.add(new Parametro(5, empleado.getAntiguedad()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(Empleado empleado) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE * FROM empleado  where idEmpleado=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, empleado.getId_empleado()));
        lstPar.add(new Parametro(2, empleado.getNombres()));
        lstPar.add(new Parametro(3, empleado.getApellidos()));
        lstPar.add(new Parametro(4, empleado.getFecha_ingreso()));
        lstPar.add(new Parametro(5, empleado.getAntiguedad()));   
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public Empleado obtener(int codigo) throws Exception {
        Empleado empleado = null;
         String sql = "select * from empleado where idEmpleado=?"; 
          List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);            
            while(rst.next()){
                empleado= new Empleado();
                empleado.setId_empleado(rst.getInt(1));
                empleado.setNombres(rst.getString(2));            
                empleado.setApellidos(rst.getString(3));            
                empleado.setFecha_ingreso(rst.getDate(4));            
                empleado.setAntiguedad(rst.getDate(5));            
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return empleado;
    }

    @Override
    public List<Empleado> obtener() throws Exception {
        List<Empleado> lista = new ArrayList<>();
         String sql = "select *  from Empleado";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Empleado empleado= null;
            while(rst.next()){
                empleado= new Empleado();
                empleado.setId_empleado(rst.getInt(1));
                empleado.setNombres(rst.getString(2));            
                empleado.setApellidos(rst.getString(3));            
                empleado.setFecha_ingreso(rst.getDate(4));            
                empleado.setAntiguedad(rst.getDate(5));   
                lista.add(empleado);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
          return lista ;
}
}
