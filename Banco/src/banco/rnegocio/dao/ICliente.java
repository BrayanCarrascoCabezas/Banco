/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.rnegocio.dao;

import banco.rnegocio.entidades.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WILCXMAC
 */
public interface ICliente {
    
         public int insertar(Cliente cliente) throws Exception;

    public int modificar(Cliente cliente) throws Exception;

    public int eliminar(Cliente cliente) throws Exception;

    public Cliente obtener(int  codigoCliente) throws Exception;

    public List<Cliente> obtener() throws Exception;
}

