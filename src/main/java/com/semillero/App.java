package com.semillero;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.Servlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;

import com.semillero.controladores.CuentaControlador;
import com.semillero.controladores.UsurioControlador;
import com.semillero.entidades.Cuenta;
import com.semillero.entidades.Usuario;
import com.semillero.repositorios.CuentaRepositorio;
import com.semillero.repositorios.RepositorioCRUD;
import com.semillero.repositorios.UsuarioRepositorio;

public class App {

    public static void main(String[] args) {

        // ----PRUEBAS DE LOS REPOSITORIOS -------------------------------------------

        // RepositorioCRUD repositorio = new UsuarioRepositorio();
        // RepositorioCRUD repositorio = new CuentaRepositorio();

        // Usuario usuario1 = new Usuario("Homero", "Simpson", "123456");
        // Usuario usuario2 = new Usuario("Leonel", "Messi", "10101010");

        // // ---Crear Usuario----
        // repositorio.crear(usuario1);

        // repositorio.crear(usuario2);

        // // ---Listar Usuarios ----
        // ArrayList<Usuario> usuarios = (ArrayList<Usuario>) repositorio.listar();

        // for (Usuario usuario : usuarios) {
        // System.out.println(usuario.getNombre());
        // }
        // -----------------------------------------------------------------------------------

        // Usuario usuario2 = new Usuario(1);
        // Cuenta cuetna1 = new Cuenta("111", 40000, "ahorro", usuario2);

        // repositorio.crear(cuetna1);

        // ---Listar Cuentas ----
        // ArrayList<Cuenta> cuentas = (ArrayList<Cuenta>) repositorio.listar();

        // for (Cuenta cuenta : cuentas) {
        // System.out.println(cuenta.getNumero_cuenta());
        // }
        // ----------------------------------------------------------------------------------

        Server server = new Server(8888);
        server.setHandler(new DefaultHandler());

        ServletContextHandler context = new ServletContextHandler();

        context.setContextPath("/");

        context.addServlet(UsurioControlador.class, "/usuario/*");
        context.addServlet(CuentaControlador.class, "/cuenta/*");

        server.setHandler(context);

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
