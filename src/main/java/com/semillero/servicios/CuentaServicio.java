package com.semillero.servicios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.semillero.entidades.Cuenta;
import com.semillero.entidades.Usuario;
import com.semillero.repositorios.CuentaRepositorio;
import com.semillero.repositorios.RepositorioCRUD;

public class CuentaServicio implements ServicioCRUD {

    private RepositorioCRUD repositorioCuenta;

    public CuentaServicio() {
        repositorioCuenta = new CuentaRepositorio();
    }

    @Override
    public void crear(Map datos) {
        String numero_cuenta = (String) datos.get("numero_cuenta");
        Integer saldo = (Integer) datos.get("saldo");
        String tipo_cuenta = (String) datos.get("tipo_cuenta");
        int idUsuario = (int) datos.get("id_usuario");

        ServicioCRUD servicioUsuairo = new UsuarioServicio();

        // verifica si el usuario existe
        if (servicioUsuairo.buscar(String.valueOf(idUsuario)) == null) {
            System.out.println("El usuario no existe, por lo tanto no se puede crear la cuenta");
        } else {
            Usuario usuario = new Usuario(idUsuario);
            Cuenta cuenta = new Cuenta(numero_cuenta, saldo, tipo_cuenta, usuario);
            repositorioCuenta.crear(cuenta);
        }

    }

    @Override
    public List<?> listar() {
        return (List<Cuenta>) repositorioCuenta.listar();
    }

    @Override
    public void actualizar(Map datos) {
        String numero_cuenta = (String) datos.get("numero_cuenta");
        int saldo = (int) datos.get("saldo");
        String tipo_cuenta = (String) datos.get("tipo_cuenta");
        int idUsuario = (int) datos.get("idUsuario");

        Usuario usuario = new Usuario(idUsuario);

        Cuenta cuenta = new Cuenta(numero_cuenta, saldo, tipo_cuenta, usuario);
        repositorioCuenta.actualizar(cuenta);
    }

    @Override
    public Object buscar(String identificador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

}
