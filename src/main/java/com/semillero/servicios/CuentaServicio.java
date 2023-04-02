package com.semillero.servicios;

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

        Usuario usuario = new Usuario(idUsuario);

        Cuenta cuenta = new Cuenta(numero_cuenta, saldo, tipo_cuenta, usuario);
        repositorioCuenta.crear(cuenta);
    }

    @Override
    public List<?> listar() {
        return (List<Cuenta>) repositorioCuenta.listar();
    }

    @Override
    public void actualizar(Map datos) {
        String numero_cuenta = (String) datos.get("numero_cuenta");
        float saldo = (float) datos.get("saldo");
        String tipo_cuenta = (String) datos.get("tipo_cuenta");
        int idUsuario = (int) datos.get("idUsuario");

        // Usuario usuario = new Usuario(nombre, apellido, cedula);

        // repositorioUsuario.actualizar(usuario);
    }

    @Override
    public Object buscar(String identificador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

}
