/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.rnegocio.dao;

import banco.rnegocio.entidades.Empleado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WILCXMAC
 */
public interface IEmpleado {
        public int insertar(Empleado empleado) throws Exception;

    public int modificar(Empleado empleado) throws Exception;

    public int eliminar(Empleado empleado) throws Exception;

    public Empleado obtener(int codigo) throws Exception;

    public List<Empleado> obtener() throws Exception;
}
