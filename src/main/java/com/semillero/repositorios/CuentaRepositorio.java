package com.semillero.repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.semillero.entidades.Cuenta;
import com.semillero.entidades.Usuario;

public class CuentaRepositorio implements RepositorioCRUD {
    private String cadenaConexion;

    public CuentaRepositorio() {
        try {
            DriverManager.registerDriver(new org.sqlite.JDBC());
            cadenaConexion = "jdbc:sqlite:banco.db";
        } catch (SQLException e) {
            System.err.println("Error de conexión con la base de datos: " + e);
        }

    }

    @Override
    public void crear(Object objeto) {
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            Cuenta cuenta = (Cuenta) objeto;
            String sentenciaSql = "INSERT INTO CUENTAS (NUMERO_CUENTA , SALDO , TIPO_CUENTA , ID_USUARIO) " +
                    " VALUES('" + cuenta.getNumero_cuenta() + "', '" + cuenta.getSaldo()
                    + "', '" + cuenta.getTipo_cuenta() + "', '" + cuenta.getUsuario().getId() + "');";
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
        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            Cuenta cuenta = (Cuenta) objeto;

            String senteciaSql = "UPDATE CUENTAS SET SALDO =?, TIPO_CUENTA =?, ID_USUARIO =? WHERE NUMERO_CUENTA =?;";

            PreparedStatement sentencia = conexion.prepareStatement(senteciaSql);

            sentencia.setInt(1, (int) cuenta.getSaldo());
            sentencia.setString(2, cuenta.getTipo_cuenta());
            sentencia.setInt(3, cuenta.getUsuario().getId());
            sentencia.setString(4, cuenta.getNumero_cuenta());

            sentencia.execute();

        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    @Override
    public Object buscar(String identificador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    @Override
    public List<?> listar() {
        List<Cuenta> cuentas = new ArrayList<Cuenta>();

        try (Connection conexion = DriverManager.getConnection(cadenaConexion)) {
            String sentenciaSql = "SELECT * FROM CUENTAS";
            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSql);
            ResultSet resultadoConsulta = sentencia.executeQuery();

            if (resultadoConsulta != null) {
                while (resultadoConsulta.next()) {
                    Cuenta cuenta = null;
                    int id = resultadoConsulta.getInt("ID");
                    String numero_cuenta = resultadoConsulta.getString("numero_cuenta");
                    int saldo = resultadoConsulta.getInt("saldo");
                    String tipo_cuenta = resultadoConsulta.getString("tipo_cuenta");
                    int ID_USUARIO = resultadoConsulta.getInt("ID_USUARIO");

                    Usuario usuario = new Usuario(ID_USUARIO);

                    cuenta = new Cuenta(id, numero_cuenta, saldo, tipo_cuenta, usuario);
                    cuentas.add(cuenta);
                }
                return cuentas;
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e);
        }
        return null;
    }
}
