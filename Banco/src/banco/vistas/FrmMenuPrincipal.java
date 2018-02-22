/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//import org.jvnet.substance.SubstanceLookAndFeel;
//import org.jvnet.substance.watermark.SubstanceImageWatermark;
 
public class FrmMenuPrincipal extends JFrame {

    JMenuBar mnbPrincipal;
    JMenu mnInicio;
    JMenuItem mniLogin;
    JMenuItem mniSalir;
    JDesktopPane dkpEscritorio;
    /*Ciudad */
    JMenu mnCiudad;
    JMenuItem mniNuevoCiudad;
    JMenuItem mniModificaCiudad;
    JMenuItem mniEliminaCiudad;
    JMenuItem mniBuscaCiudad;
    JMenuItem mniListaCiudad;
    /*Cliente_Prestamo */
    JMenu mnCliente_Prestamo;
    JMenuItem mniNuevoCliente_Prestamo;
    JMenuItem mniModificaCliente_Prestamo;
    JMenuItem mniEliminaCliente_Prestamo;
    JMenuItem mniBuscaCliente_Prestamo;
    JMenuItem mniListaCliente_Prestamo;
    /*CLIENTE */
    JMenu mnCliente;
    JMenuItem mniNuevoCliente;
    JMenuItem mniModificaCliente;
    JMenuItem mniEliminaCliente;
    JMenuItem mniBuscaCliente;
    JMenuItem mniListaCliente;
    /*Cuenta */
    JMenu mnCuenta;
    JMenuItem mniNuevoCuenta;
    JMenuItem mniModificaCuenta;
    JMenuItem mniEliminaCuenta;
    JMenuItem mniBuscaCuenta;
    JMenuItem mniListaCuenta;
    /*Cuenta_Ahorros */
    JMenu mnCuenta_Ahorros;
    JMenuItem mniNuevoCuenta_Ahorros;
    JMenuItem mniModificaCuenta_Ahorros;
    JMenuItem mniEliminaCuenta_Ahorros;
    JMenuItem mniBuscaCuenta_Ahorros;
    JMenuItem mniListaCuenta_Ahorros;
    /*Cuenta_Credito */
    JMenu mnCuenta_Credito;
    JMenuItem mniNuevoCuenta_Credito;
    JMenuItem mniModificaCuenta_Credito;
    JMenuItem mniEliminaCuenta_Credito;
    JMenuItem mniBuscaCuenta_Credito;
    JMenuItem mniListaCuenta_Credito;
    /*Empleado */
    JMenu mnEmpleado;
    JMenuItem mniNuevoEmpleado;
    JMenuItem mniModificaEmpleado;
    JMenuItem mniEliminaEmpleado;
    JMenuItem mniBuscaEmpleado;
    JMenuItem mniListaEmpleado;
    /*Inspector */
    JMenu mnInspector;
    JMenuItem mniNuevoInspector;
    JMenuItem mniModificaInspector;
    JMenuItem mniEliminaInspector;
    JMenuItem mniBuscaInspector;
    JMenuItem mniListaInspector;
    /*Pago */
    JMenu mnPago;
    JMenuItem mniNuevoPago;
    JMenuItem mniModificaPago;
    JMenuItem mniEliminaPago;
    JMenuItem mniBuscaPago;
    JMenuItem mniListaPago;
    /*Prestamo */
    JMenu mnPrestamo;
    JMenuItem mniNuevoPrestamo;
    JMenuItem mniModificaPrestamo;
    JMenuItem mniEliminaPrestamo;
    JMenuItem mniBuscaPrestamo;
    JMenuItem mniListaPrestamo;
    
    /*Sucursal */
    JMenu mnSucursal;
    JMenuItem mniNuevoSucursal;
    JMenuItem mniModificaSucursal;
    JMenuItem mniEliminaSucursal;
    JMenuItem mniBuscaSucursal;
    JMenuItem mniListaSucursal;

    public FrmMenuPrincipal() {
        dkpEscritorio = new JDesktopPane();

        mnbPrincipal = new JMenuBar();
        mnbPrincipal.setBackground(Color.getHSBColor(100, 102, 250).brighter());

        mnInicio = new JMenu("INICIO");
        mnInicio.setForeground(Color.WHITE);
        mniLogin = new JMenuItem("INICIAR SESION");
        mniSalir = new JMenuItem("SALIR");
        mniSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        /*CATEGORIA*/
        mnCiudad = new JMenu("Ciudad");
        mnCiudad.setForeground(Color.WHITE);
        mniNuevoCiudad = new JMenuItem("NUEVO");

        mniNuevoCiudad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoCiudadActionPerformed(e);
            }
        });

        mniModificaCiudad = new JMenuItem("MODIFICAR");
        mniEliminaCiudad = new JMenuItem("ELIMINAR");
        
        mniEliminaCiudad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniEliminaCiudadActionPerformed(e);
            }
        });
        
        mniBuscaCiudad = new JMenuItem("BUSCAR");
        mniListaCiudad = new JMenuItem("LISTAR");
        mniListaCiudad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniCiudadListaActionPerformed(e);
            }
        });

        mnCiudad.add(mniNuevoCiudad);
        mnCiudad.addSeparator();
        mnCiudad.add(mniModificaCiudad);
        mnCiudad.addSeparator();
        mnCiudad.add(mniEliminaCiudad);
        mnCiudad.addSeparator();
        mnCiudad.add(mniBuscaCiudad);
        mnCiudad.addSeparator();
        mnCiudad.add(mniListaCiudad);
        /*ARTICULO*/
        mnCliente_Prestamo = new JMenu("Cliente_Prestamo");
        mnCliente_Prestamo.setForeground(Color.WHITE);
        mniNuevoCliente_Prestamo = new JMenuItem("NUEVO");

        mniNuevoCliente_Prestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoCliente_PrestamoActionPerformed(e);
            }
        });

        mniModificaCliente_Prestamo = new JMenuItem("MODIFICAR");
        mniEliminaCliente_Prestamo = new JMenuItem("ELIMINAR");
        
        mniEliminaCliente_Prestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniEliminaCliente_PrestamoActionPerformed(e);
            }
        });
        
        mniBuscaCliente_Prestamo = new JMenuItem("BUSCAR");
        mniListaCliente_Prestamo = new JMenuItem("LISTAR");
        mniListaCliente_Prestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniCliente_PrestamoListaActionPerformed(e);
            }
        });

        mnCliente_Prestamo.add(mniNuevoCliente_Prestamo);
        mnCliente_Prestamo.addSeparator();
        mnCliente_Prestamo.add(mniModificaCliente_Prestamo);
        mnCliente_Prestamo.addSeparator();
        mnCliente_Prestamo.add(mniEliminaCliente_Prestamo);
        mnCliente_Prestamo.addSeparator();
        mnCliente_Prestamo.add(mniBuscaCliente_Prestamo);
        mnCliente_Prestamo.addSeparator();
        mnCliente_Prestamo.add(mniListaCliente_Prestamo);
        /*CLIENTE*/
        mnCliente = new JMenu("Cliente");
        mnCliente.setForeground(Color.WHITE);
        mniNuevoCliente = new JMenuItem("NUEVO");

        mniNuevoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoClienteActionPerformed(e);
            }
        });

        mniModificaCliente = new JMenuItem("MODIFICAR");
        mniEliminaCliente = new JMenuItem("ELIMINAR");
        
        mniEliminaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniEliminaClienteActionPerformed(e);
            }
        });
        
        mniBuscaCliente = new JMenuItem("BUSCAR");
        mniListaCliente = new JMenuItem("LISTAR");
        
        mniListaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniClienteListaActionPerformed(e);
            }
        });

        mnCliente.add(mniNuevoCliente);
        mnCliente.addSeparator();
        mnCliente.add(mniModificaCliente);
        mnCliente.addSeparator();
        mnCliente.add(mniEliminaCliente);
        mnCliente.addSeparator();
        mnCliente.add(mniBuscaCliente);
        mnCliente.addSeparator();
        mnCliente.add(mniListaCliente);

        /*DETALLE INGRESO*/
        mnCuenta = new JMenu("Cuenta");
        mnCuenta.setForeground(Color.WHITE);

        mniNuevoCuenta = new JMenuItem("NUEVO");

        mniNuevoCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoCuentaActionPerformed(e);
            }
        });

        mniModificaCuenta = new JMenuItem("MODIFICAR");
        mniEliminaCuenta = new JMenuItem("ELIMINAR");
        mniBuscaCuenta = new JMenuItem("BUSCAR");
        mniListaCuenta = new JMenuItem("LISTAR");
        
        mniListaCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniCuentaListaActionPerformed(e);
            }
        });

        mnCuenta.add(mniNuevoCuenta);
        mnCuenta.addSeparator();
        mnCuenta.add(mniModificaCuenta);
        mnCuenta.addSeparator();
        mnCuenta.add(mniEliminaCuenta);
        mnCuenta.addSeparator();
        mnCuenta.add(mniBuscaCuenta);
        mnCuenta.addSeparator();
        mnCuenta.add(mniListaCuenta);
        /*DETALLE VENTA*/
        mnCuenta_Ahorros = new JMenu("Cuenta_Ahorros");
        mnCuenta_Ahorros.setForeground(Color.WHITE);

        mniNuevoCuenta_Ahorros = new JMenuItem("NUEVO");

        mniNuevoCuenta_Ahorros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoCuenta_AhorrosActionPerformed(e);
            }
        });

        mniModificaCuenta_Ahorros = new JMenuItem("MODIFICAR");
        mniEliminaCuenta_Ahorros = new JMenuItem("ELIMINAR");
        mniEliminaCuenta_Ahorros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniEliminaDetalle_PrestamoActionPerformed(e);
            }
        });
        mniBuscaCuenta_Ahorros = new JMenuItem("BUSCAR");
        mniListaCuenta_Ahorros = new JMenuItem("LISTAR");

        mniListaCuenta_Ahorros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniDetalle_PrestamoListaActionPerformed(e);
            }
        });
        
        mnCuenta_Ahorros.add(mniNuevoCuenta_Ahorros);
        mnCuenta_Ahorros.addSeparator();
        mnCuenta_Ahorros.add(mniModificaCuenta_Ahorros);
        mnCuenta_Ahorros.addSeparator();
        mnCuenta_Ahorros.add(mniEliminaCuenta_Ahorros);
        mnCuenta_Ahorros.addSeparator();
        mnCuenta_Ahorros.add(mniBuscaCuenta_Ahorros);
        mnCuenta_Ahorros.addSeparator();
        mnCuenta_Ahorros.add(mniListaCuenta_Ahorros);
        /*INGRESO*/
        mnCuenta_Credito = new JMenu("Cuenta_credito");
        mnCuenta_Credito.setForeground(Color.WHITE);

        mniNuevoCuenta_Credito = new JMenuItem("NUEVO");

        mniNuevoCuenta_Credito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoCuenta_CreditoActionPerformed(e);
            }
        });

        mniModificaCuenta_Credito = new JMenuItem("MODIFICAR");
        mniEliminaCuenta_Credito = new JMenuItem("ELIMINAR");
        
        mniEliminaCuenta_Credito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniEliminaCuenta_CreditoActionPerformed(e);
            }
        });
        
        mniBuscaCuenta_Credito = new JMenuItem("BUSCAR");
        mniListaCuenta_Credito = new JMenuItem("LISTAR");

        mniListaCuenta_Credito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniCuenta_CreditoListaActionPerformed(e);
            }
        });
        
        mnCuenta_Credito.add(mniNuevoCuenta_Credito);
        mnCuenta_Credito.addSeparator();
        mnCuenta_Credito.add(mniModificaCuenta_Credito);
        mnCuenta_Credito.addSeparator();
        mnCuenta_Credito.add(mniEliminaCuenta_Credito);
        mnCuenta_Credito.addSeparator();
        mnCuenta_Credito.add(mniBuscaCuenta_Credito);
        mnCuenta_Credito.addSeparator();
        mnCuenta_Credito.add(mniListaCuenta_Credito);
        /*Empleado*/
        mnEmpleado = new JMenu("Empleado");
        mnEmpleado.setForeground(Color.WHITE);

        mniNuevoEmpleado = new JMenuItem("NUEVO");

        mniNuevoEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoEmpleadoActionPerformed(e);
            }
        });

        mniModificaEmpleado = new JMenuItem("MODIFICAR");
        mniEliminaEmpleado = new JMenuItem("ELIMINAR");
        mniBuscaEmpleado = new JMenuItem("BUSCAR");
        mniListaEmpleado = new JMenuItem("LISTAR");

        mnEmpleado.add(mniNuevoEmpleado);
        mnEmpleado.addSeparator();
        mnEmpleado.add(mniModificaEmpleado);
        mnEmpleado.addSeparator();
        mnEmpleado.add(mniEliminaEmpleado);
        mnEmpleado.addSeparator();
        mnEmpleado.add(mniBuscaEmpleado);
        mnEmpleado.addSeparator();
        mnEmpleado.add(mniListaEmpleado);
        /*PROVEEDOR*/
        mnInspector = new JMenu("Inspector");
        mnInspector.setForeground(Color.WHITE);

        mniNuevoInspector = new JMenuItem("NUEVO");

        mniNuevoInspector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoInspectorActionPerformed(e);
            }
        });

        mniModificaInspector = new JMenuItem("MODIFICAR");
        mniEliminaInspector = new JMenuItem("ELIMINAR");
        mniEliminaInspector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniEliminaInspectorActionPerformed(e);
            }
        });
        mniBuscaInspector = new JMenuItem("BUSCAR");
        mniListaInspector = new JMenuItem("LISTAR");

        mniListaInspector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniInspectorListaActionPerformed(e);
            }
        });
        
        mnInspector.add(mniNuevoInspector);
        mnInspector.addSeparator();
        mnInspector.add(mniModificaInspector);
        mnInspector.addSeparator();
        mnInspector.add(mniEliminaInspector);
        mnInspector.addSeparator();
        mnInspector.add(mniBuscaInspector);
        mnInspector.addSeparator();
        mnInspector.add(mniListaInspector);
        /*VENDEDOR*/
        mnPago = new JMenu("Pago");
        mnPago.setForeground(Color.WHITE);

        mniNuevoPago = new JMenuItem("NUEVO");

        mniNuevoPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoPagoActionPerformed(e);
            }
        });

        mniModificaPago = new JMenuItem("MODIFICAR");
        mniEliminaPago = new JMenuItem("ELIMINAR");
        mniEliminaPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniEliminaPagoActionPerformed(e);
            }
        });
        mniBuscaPago = new JMenuItem("BUSCAR");
        mniListaPago = new JMenuItem("LISTAR");

        mniListaPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniPagoListaActionPerformed(e);
            }
        });
        
        mnPago.add(mniNuevoPago);
        mnPago.addSeparator();
        mnPago.add(mniModificaPago);
        mnPago.addSeparator();
        mnPago.add(mniEliminaPago);
        mnPago.addSeparator();
        mnPago.add(mniBuscaPago);
        mnPago.addSeparator();
        mnPago.add(mniListaPago);
        /*VENTA*/
        mnPrestamo = new JMenu("Prestamo");
        mnPrestamo.setForeground(Color.WHITE);

        mniNuevoPrestamo = new JMenuItem("NUEVO");

        mniNuevoPrestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoPrestamoActionPerformed(e);
            }
        });

        mniModificaPrestamo = new JMenuItem("MODIFICAR");
        mniEliminaPrestamo = new JMenuItem("ELIMINAR");
        mniEliminaPrestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniEliminaPrestamoActionPerformed(e);
            }
        });
        mniBuscaPrestamo = new JMenuItem("BUSCAR");
        mniListaPrestamo = new JMenuItem("LISTAR");

        mniListaPrestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniPrestamoListaActionPerformed(e);
            }
        });
        
        mnPrestamo.add(mniNuevoPrestamo);
        mnPrestamo.addSeparator();
        mnPrestamo.add(mniModificaPrestamo);
        mnPrestamo.addSeparator();
        mnPrestamo.add(mniEliminaPrestamo);
        mnPrestamo.addSeparator();
        mnPrestamo.add(mniBuscaPrestamo);
        mnPrestamo.addSeparator();
        mnPrestamo.add(mniListaPrestamo);
        
        mnSucursal = new JMenu("Sucursal");
        mnSucursal.setForeground(Color.WHITE);

        mniNuevoSucursal = new JMenuItem("NUEVO");

        mniNuevoSucursal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoPrestamoActionPerformed(e);
            }
        });

        mniModificaSucursal = new JMenuItem("MODIFICAR");
        mniEliminaSucursal = new JMenuItem("ELIMINAR");
        mniEliminaSucursal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //mniEliminaSucursalActionPerformed(e);
            }
        });
        mniBuscaSucursal = new JMenuItem("BUSCAR");
        mniListaSucursal = new JMenuItem("LISTAR");

        mniListaSucursal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //mniSucursalListaActionPerformed(e);
            }
        });
        
        mnSucursal.add(mniNuevoSucursal);
        mnSucursal.addSeparator();
        mnSucursal.add(mniModificaSucursal);
        mnSucursal.addSeparator();
        mnSucursal.add(mniEliminaSucursal);
        mnSucursal.addSeparator();
        mnSucursal.add(mniBuscaSucursal);
        mnSucursal.addSeparator();
        mnSucursal.add(mniListaSucursal);
        

        mnbPrincipal.add(mnInicio);
        mnbPrincipal.add(mnCiudad);
        mnbPrincipal.add(mnCliente);
        mnbPrincipal.add(mnCliente_Prestamo);
        mnbPrincipal.add(mnCuenta);
        mnbPrincipal.add(mnCuenta_Ahorros);
        mnbPrincipal.add(mnCuenta_Credito);
        mnbPrincipal.add(mnEmpleado);
        mnbPrincipal.add(mnInspector);
        mnbPrincipal.add(mnPago);       
        mnbPrincipal.add(mnPrestamo);
        mnbPrincipal.add(mnEmpleado);
        mnbPrincipal.add(mnSucursal);
        mnbPrincipal.setBackground(Color.lightGray);
        mnInicio.add(mniLogin);
        mnInicio.add(mniSalir);
        this.setLayout(new BorderLayout());
        this.add(mnbPrincipal, BorderLayout.NORTH);
        this.add(dkpEscritorio, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH); //Para maximizar
        //this.setDefaultLookAndFeelDecorated(true);
        this.setBounds(0, 0, 900, 750);
        //SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlueSteelSkin");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Para terminar el programa

    }

    public void mniEliminaCliente_PrestamoActionPerformed(ActionEvent e) {
//        FrmCliente_PrestamoEliminar frm = new FrmCliente_PrestamoEliminar();
//        dkpEscritorio.add(frm, BorderLayout.WEST);
//        frm.setVisible(true);
    }
    
    public void mniEliminaClienteActionPerformed(ActionEvent e) {
//        FrmClienteEliminar frm = new FrmClienteEliminar();
//        dkpEscritorio.add(frm, BorderLayout.WEST);
//        frm.setVisible(true);
    }
    
    public void mniEliminaCiudadActionPerformed(ActionEvent e) {
//        FrmCiudadEliminar frm = new FrmCiudadEliminar();
//        dkpEscritorio.add(frm, BorderLayout.WEST);
//        frm.setVisible(true);
    }
    
    public void mniEliminaInspectorActionPerformed(ActionEvent e) {
//        FrmInspectorEliminar frm = new FrmInspectorEliminar();
//        dkpEscritorio.add(frm, BorderLayout.WEST);
//        frm.setVisible(true);
    }
    
    public void mniEliminaPagoActionPerformed(ActionEvent e) {
//        FrmPagoEliminar frm = new FrmPagoEliminar();
//        dkpEscritorio.add(frm, BorderLayout.WEST);
//        frm.setVisible(true);
    }
    
    public void mniEliminaPrestamoActionPerformed(ActionEvent e) {
//        FrmPrestamoEliminar frm = new FrmPrestamoEliminar();
//        dkpEscritorio.add(frm, BorderLayout.WEST);
//        frm.setVisible(true);
    }
    
    public void mniEliminaDetalle_PrestamoActionPerformed(ActionEvent e) {
//        FrmDetalle_PrestamoEliminar frm = new FrmDetalle_PrestamoEliminar();
//        dkpEscritorio.add(frm, BorderLayout.WEST);
//        frm.setVisible(true);
    }
    
    public void mniEliminaCuenta_CreditoActionPerformed(ActionEvent e) {
//        FrmCuenta_CreditoEliminar frm = new FrmCuenta_CreditoEliminar();
//        dkpEscritorio.add(frm, BorderLayout.WEST);
//        frm.setVisible(true);
    }
    
    public void mniNuevoCiudadActionPerformed(ActionEvent e) {
        FrmCiudadNueva frm = new FrmCiudadNueva();
        dkpEscritorio.add(frm, BorderLayout.WEST);
        frm.setVisible(true);
    }

    public void mniNuevoCliente_PrestamoActionPerformed(ActionEvent e) {
//        FrmCliente_PrestamoNuevo frm = new FrmCliente_PrestamoNuevo();
//
//        dkpEscritorio.add(frm, BorderLayout.WEST);
//
//        frm.setVisible(true);
    }

    public void mniNuevoClienteActionPerformed(ActionEvent e) {
        FrmClienteNuevo frm = new FrmClienteNuevo();
        dkpEscritorio.add(frm, BorderLayout.WEST);
        frm.setVisible(true);
    }

    public void mniNuevoCuentaActionPerformed(ActionEvent e) {
//        FrmCuentaNuevo frm = new FrmCuentaNuevo();
//
//        dkpEscritorio.add(frm, BorderLayout.WEST);
//
//        frm.setVisible(true);
    }

    public void mniNuevoCuenta_AhorrosActionPerformed(ActionEvent e) {
//        FrmDetalle_PrestamoNueva frm = new FrmDetalle_PrestamoNueva();
//
//        dkpEscritorio.add(frm, BorderLayout.WEST);
//
//        frm.setVisible(true);
    }

    public void mniNuevoCuenta_CreditoActionPerformed(ActionEvent e) {
//        FrmCuenta_CreditoNuevo frm = new FrmCuenta_CreditoNuevo();
//
//        dkpEscritorio.add(frm, BorderLayout.WEST);
//
//        frm.setVisible(true);
    }
    public void mniNuevoEmpleadoActionPerformed(ActionEvent e) {
//        FrmEmpleadoNuevo frm = new FrmEmpleadoNuevo();
//
//        dkpEscritorio.add(frm, BorderLayout.WEST);
//
//        frm.setVisible(true);
    }
    public void mniNuevoInspectorActionPerformed(ActionEvent e) {
        FrmInspectorNuevo frm = new FrmInspectorNuevo();
        dkpEscritorio.add(frm, BorderLayout.WEST);
        frm.setVisible(true);
    }
    public void mniNuevoPagoActionPerformed(ActionEvent e) {
//        FrmPagoNuevo frm = new FrmPagoNuevo();
//
//        dkpEscritorio.add(frm, BorderLayout.WEST);
//
//        frm.setVisible(true);
    }
    public void mniNuevoPrestamoActionPerformed(ActionEvent e) {
//        FrmPrestamoNueva frm = new FrmPrestamoNueva();
//
//        dkpEscritorio.add(frm, BorderLayout.WEST);
//
//        frm.setVisible(true);
    }

    public void mniCiudadListaActionPerformed(ActionEvent e) {
//        FrmCiudadLista frm = new FrmCiudadLista();
//        dkpEscritorio.add(frm);
//        frm.setVisible(true);
    }
    
    public void mniCuenta_CreditoListaActionPerformed(ActionEvent e) {
//        FrmCuenta_CreditoLista frm = new FrmCuenta_CreditoLista();
//        dkpEscritorio.add(frm);
//        frm.setVisible(true);
    }
    
    public void mniCuentaListaActionPerformed(ActionEvent e) {
//        FrmCuentaLista frm = new FrmCuentaLista();
//        dkpEscritorio.add(frm);
//        frm.setVisible(true);
    }
    
    public void mniDetalle_PrestamoListaActionPerformed(ActionEvent e) {
//        FrmDetalle_PrestamoLista frm = new FrmDetalle_PrestamoLista();
//        dkpEscritorio.add(frm);
//        frm.setVisible(true);
    }
    
    
    
    public void mniClienteListaActionPerformed(ActionEvent e) {
//        FrmClienteLista frm = new FrmClienteLista();
//        dkpEscritorio.add(frm);
//        frm.setVisible(true);
    }
    
    public void mniCliente_PrestamoListaActionPerformed(ActionEvent e) {
//        FrmCliente_PrestamoLista frm = new FrmCliente_PrestamoLista();
//        dkpEscritorio.add(frm);
//        frm.setVisible(true);
    }
    
    public void mniInspectorListaActionPerformed(ActionEvent e) {
//        FrmInspectorLista frm = new FrmInspectorLista();
//        dkpEscritorio.add(frm);
//        frm.setVisible(true);
    }
    
    public void mniPagoListaActionPerformed(ActionEvent e) {
//        FrmPagoLista frm = new FrmPagoLista();
//        dkpEscritorio.add(frm);
//        frm.setVisible(true);
    }
    
    public void mniPrestamoListaActionPerformed(ActionEvent e) {
//        FrmPrestamoLista frm = new FrmPrestamoLista();
//        dkpEscritorio.add(frm);
//        frm.setVisible(true);
    }

    public static void main(String[] args) {
        FrmMenuPrincipal frm = new FrmMenuPrincipal();
        frm.setVisible(true);

    }
}
