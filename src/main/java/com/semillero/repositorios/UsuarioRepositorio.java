package com.semillero.repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.semillero.entidades.Usuario;

public class UsuarioRepositorio implements RepositorioCRUD {
    private String cadenaConexion;

    public UsuarioRepositorio() {
        try {
            DriverManager.registerDriver(new org.sqlite.JDBC());
            cadenaConexion = "jdbc:sqlite:banco.db";
        } catch (SQLException e) {
            System.err.println("Error de conexión con la base de datos: " + e);
        }

    }

    public void Hola() {

    }

    @Override
    public void crear(Object objeto) {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            Usuario usuario = (Usuario) objeto;
            String sentenciaSql = "INSERT INTO USUARIOS (NOMBRE , APELLIDO , CEDULA) "
                    + " VALUES('" + usuario.getNombre() + "','" + usuario.getApellido() + "','"
                    + usuario.getCedula() + "');";
            Statement sentencia = conexion.createStatement();
            sentencia.execute(sentenciaSql);
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    @Override
    public void eliminar(String identificador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public void actualizar(Object objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public Object buscar(String identificador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    @Override
    public List<?> listar() {
        List<Usuario> usuarios = new ArrayList<Usuario>();

        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sentenciaSql = "SELECT * FROM USUARIOS";
            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSql);
            ResultSet resultadoConsulta = sentencia.executeQuery();

            if (resultadoConsulta != null) {
                while (resultadoConsulta.next()) {
                    Usuario usuario = null;

                    String nombre = resultadoConsulta.getString("NOMBRE");
                    String apellido = resultadoConsulta.getString("APELLIDO");
                    String cedula = resultadoConsulta.getString("CEDULA");

                    usuario = new Usuario(nombre, apellido, cedula);
                    usuarios.add(usuario);
                }
                return usuarios;
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        }
        return null;
    }
}
