/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.rnenogio.dao;

/**
 *
 * @author WILCXMAC
 */
  import banco.rnegocio.entidades.*;
import java.util.*;
public interface ICuenta {

    public int insertar(Cuenta cuenta) throws Exception;

    public int modificar(Cuenta cuenta) throws Exception;

    public int eliminar(Cuenta cuenta) throws Exception;

    public Cuenta obtener(int codigo) throws Exception;

    public List<Cuenta> obtener() throws Exception;  
}
