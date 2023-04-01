package com.semillero.servicios;

import java.util.List;
import java.util.Map;

import com.semillero.entidades.Usuario;
import com.semillero.repositorios.RepositorioCRUD;
import com.semillero.repositorios.UsuarioRepositorio;

public class UsuarioServicio implements ServicioCRUD {
    private RepositorioCRUD repositorioUsuario;

    public UsuarioServicio() {
        repositorioUsuario = new UsuarioRepositorio();
    }

    @Override
    public void crear(Map datos) {
        String nombre = (String) datos.get("nombre");
        String apellido = (String) datos.get("apellido");
        String cedula = (String) datos.get("cedula");

        Usuario usuario = new Usuario(nombre, apellido, cedula);
        repositorioUsuario.crear(usuario);
    }

    @Override
    public List<Usuario> listar() {
        return (List<Usuario>) repositorioUsuario.listar();
    }

    @Override
    public void actualizar(Map datos) {
        String nombre = (String) datos.get("nombre");
        String apellido = (String) datos.get("apellido");
        String cedula = (String) datos.get("cedula");

        Usuario usuario = new Usuario(nombre, apellido, cedula);
        repositorioUsuario.actualizar(usuario);
    }

    @Override
    public Object buscar(String identificador) {
        Object usuario = repositorioUsuario.buscar(identificador);
        if (usuario == null) {
            try {
                throw new Exception("No se encontro la persona");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (Usuario) usuario;
    }

}
