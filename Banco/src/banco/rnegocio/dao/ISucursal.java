/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.rnegocio.dao;

import banco.rnegocio.entidades.Sucursal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WILCXMAC
 */
public interface ISucursal {
   public int insertar(Sucursal sucursal) throws Exception;

    public int modificar(Sucursal sucursal) throws Exception;

    public int eliminar(Sucursal sucursal) throws Exception;

    public Sucursal obtener(int codigo) throws Exception;

    public List<Sucursal> obtener() throws Exception;  
}
