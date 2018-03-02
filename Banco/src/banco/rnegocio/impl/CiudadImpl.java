/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.rnegocio.impl;

import banco.accesodatos.*;
import banco.rnegocio.entidades.*;
import banco.rnegocio.dao.ICiudad;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WILCXMAC
 */
public class CiudadImpl implements ICiudad{
    
   @Override
    public int insertar(Ciudad ciudad) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into ciudad  values (?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, ciudad.getId_ciudad()));
        lstPar.add(new Parametro(2, ciudad.getNombre()));
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
    public int modificar(Ciudad ciudad) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "update  ciudad set idCiudad=?,nombre=? where idCiudad=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, ciudad.getId_ciudad()));
        lstPar.add(new Parametro(2, ciudad.getNombre()));
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
    public int eliminar(Ciudad ciudad) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE * FROM ciudad  where idCiudad=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, ciudad.getId_ciudad()));       
        lstPar.add(new Parametro(1, ciudad.getNombre()));       
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
    public Ciudad obtener(int codigo) throws Exception {
        Ciudad ciudad = null;
         String sql = "select * from ciudad where idCiudad=?"; 
          List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);            
            while(rst.next()){
                ciudad= new Ciudad();
                ciudad.setId_ciudad(rst.getInt(1));
                ciudad.setNombre(rst.getString(2));            
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return ciudad;
    }

    @Override
    public List<Ciudad> obtener() throws Exception {
        List<Ciudad> lista = new ArrayList<>();
         String sql = "select * from ciudad";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Ciudad ciudad= null;
            while(rst.next()){
                ciudad= new Ciudad();
                ciudad.setId_ciudad(rst.getInt(1));
                ciudad.setNombre(rst.getString(2));
                lista.add(ciudad);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
          return lista ;
    }  
}
