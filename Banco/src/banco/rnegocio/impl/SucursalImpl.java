/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.rnegocio.impl;

import banco.rnegocio.dao.IEmpleado;
import banco.rnegocio.dao.ISucursal;
import banco.rnegocio.dao.ICiudad;
import banco.accesodatos.*;
import banco.rnegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WILCXMAC
 */
public class SucursalImpl implements ISucursal{
    
     @Override
     
    public int insertar(Sucursal sucursal) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into sucursales  values "
                + "(?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, sucursal.getId_sucursal()));
        lstPar.add(new Parametro(2, sucursal.getEmpleado().getId_empleado()));
        lstPar.add(new Parametro(3, sucursal.getCiudad().getId_ciudad()));


        Conexion con = null;
        try {
            con = new Conexion();
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
    public int modificar(Sucursal sucursal) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE sucursales"
                + "   SET idEmpleado=?, idCiudad=? where idSucursal=?";
        List<Parametro> lstPar = new ArrayList<>();
     lstPar.add(new Parametro(3, sucursal.getId_sucursal()));
        lstPar.add(new Parametro(1, sucursal.getEmpleado().getId_empleado()));
        lstPar.add(new Parametro(2, sucursal.getCiudad().getId_ciudad()));
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
    public int eliminar(Sucursal sucursal) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM sucursales  where idSucursal=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, sucursal.getId_sucursal()));       
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
    public Sucursal obtener(int codigo) throws Exception {
        Sucursal sucursal = null;
        String sql = "SELECT *   FROM sucursales where idSucursal=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                sucursal = new Sucursal();
                sucursal.setId_sucursal(rst.getInt(1));
                IEmpleado empleadodao= new EmpleadoImpl();
                Empleado empleado=empleadodao.obtener(rst.getInt(2));
                sucursal.setEmpleado(empleado);
                
                ICiudad ciudaddao=new CiudadImpl();
                Ciudad ciudad=ciudaddao.obtener(rst.getInt(3));
                sucursal.setCiudad(ciudad);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return sucursal;
    }

    @Override
    public List<Sucursal> obtener() throws Exception {
        List<Sucursal> lista = new ArrayList<>();
         String sql = "SELECT *   FROM sucursales ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Sucursal sucursal=null;
            while (rst.next()) {
                sucursal = new Sucursal();
                sucursal.setId_sucursal(rst.getInt(1));
                
                IEmpleado empleadodao= new EmpleadoImpl();
                Empleado empleado=empleadodao.obtener(rst.getInt(2));
                sucursal.setEmpleado(empleado);
                
                ICiudad ciudaddao=new CiudadImpl();
                Ciudad ciudad=ciudaddao.obtener(rst.getInt(3));
                sucursal.setCiudad(ciudad);
                lista.add(sucursal);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return lista;
    }  
}
