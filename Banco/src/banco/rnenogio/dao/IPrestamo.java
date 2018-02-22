/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.rnenogio.dao;

import banco.rnegocio.entidades.Prestamo;
import java.util.ArrayList;

/**
 *
 * @author WILCXMAC
 */
public interface IPrestamo {
        public int insertar(Prestamo prestamos) throws Exception;

    public int modificar(Prestamo prestamos) throws Exception;

    public int eliminar(Prestamo prestamos) throws Exception;

    public Prestamo obtener(int codigo) throws Exception;

    public ArrayList<Prestamo> obtener() throws Exception;
}
