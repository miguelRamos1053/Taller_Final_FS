package com.semillero.servicios;

import java.util.List;
import java.util.Map;

public interface ServicioCRUD {
    public void crear(Map datos);

    public List<?> listar();
}
