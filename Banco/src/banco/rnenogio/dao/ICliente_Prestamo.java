/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.rnenogio.dao;

import banco.rnegocio.entidades.Cliente_Prestamo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WILCXMAC
 */
public interface ICliente_Prestamo {
    
       public int insertar(Cliente_Prestamo prestamo_cliente) throws Exception;

    public int modificar(Cliente_Prestamo prestamo_cliente) throws Exception;

    public int eliminar(Cliente_Prestamo prestamo_cliente) throws Exception;

    public Cliente_Prestamo  obtener(int codigo) throws Exception;

    public List<Cliente_Prestamo> obtener() throws Exception; 
}
