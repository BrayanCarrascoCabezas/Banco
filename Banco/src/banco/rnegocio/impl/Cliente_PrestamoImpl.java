/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.rnegocio.impl;

import banco.accesodatos.*;
import banco.rnegocio.entidades.*;
import banco.rnenogio.dao.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WILCXMAC
 */
public class Cliente_PrestamoImpl implements ICliente_Prestamo{
    
     @Override
     
    public int insertar(Cliente_Prestamo cliente_prestamo) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into cliente_prestamo  values "
                + "(?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente_prestamo.getIdcliente_prestamo()));
        lstPar.add(new Parametro(2, cliente_prestamo.getCliente().getCodigo_cliente()));
        lstPar.add(new Parametro(3, cliente_prestamo.getPrestamo().getId_prestamo()));


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
    public int modificar(Cliente_Prestamo cliente_prestamo) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE cliente_prestamo"
                + "   SET id_cliente_prestamo=?, id_cliente=?, id_prestamo=? where idcliente_prestamo=?";
        List<Parametro> lstPar = new ArrayList<>();
         lstPar.add(new Parametro(1, cliente_prestamo.getIdcliente_prestamo()));
        lstPar.add(new Parametro(2, cliente_prestamo.getCliente().getCodigo_cliente()));
        lstPar.add(new Parametro(3, cliente_prestamo.getPrestamo().getId_prestamo()));
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
    public int eliminar(Cliente_Prestamo cliente_prestamo) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM cliente_prestamo  where idcliente_prestamo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente_prestamo.getIdcliente_prestamo()));       
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
    public Cliente_Prestamo obtener(int codigo) throws Exception {
        Cliente_Prestamo cliente_prestamo = null;
        String sql = "SELECT *   FROM cliente_prestamo where idcliente_prestamo=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                cliente_prestamo = new Cliente_Prestamo();
                cliente_prestamo.setIdcliente_prestamo(rst.getInt(1));
                
                ICliente clientedao= new ClienteImpl();
                Cliente cliente=clientedao.obtener(rst.getInt(2));
                cliente_prestamo.setCliente(cliente);
                
                IPrestamo prestamodao=new PrestamoImpl();
                Prestamo prestamo=prestamodao.obtener(rst.getInt(3));
                cliente_prestamo.setPrestamo(prestamo);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return cliente_prestamo;
    }

    @Override
    public List<Cliente_Prestamo> obtener() throws Exception {
        List<Cliente_Prestamo> lista = new ArrayList<>();
         String sql = "SELECT *   FROM cliente_prestamo ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Cliente_Prestamo cliente_prestamo=null;
            while (rst.next()) {
        
                cliente_prestamo = new Cliente_Prestamo();
                cliente_prestamo.setIdcliente_prestamo(rst.getInt(1));
                
                ICliente clientedao= new ClienteImpl();
                Cliente cliente=clientedao.obtener(rst.getInt(2));
                cliente_prestamo.setCliente(cliente);
                
                IPrestamo prestamodao=new PrestamoImpl();
                Prestamo prestamo=prestamodao.obtener(rst.getInt(3));
                cliente_prestamo.setPrestamo(prestamo);
                lista.add(cliente_prestamo);
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
