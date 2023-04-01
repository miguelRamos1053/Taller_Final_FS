package com.semillero.repositorios;

import java.util.List;

public interface RepositorioCRUD {
    public void crear(Object objeto);

    public void eliminar(String identificador);

    public void actualizar(Object objeto);

    public Object buscar(String identificador);

    public List<?> listar();
}
