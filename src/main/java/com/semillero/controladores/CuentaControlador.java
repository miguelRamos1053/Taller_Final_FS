package com.semillero.controladores;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.semillero.entidades.Cuenta;
import com.semillero.servicios.CuentaServicio;
import com.semillero.servicios.ServicioCRUD;

public class CuentaControlador extends HttpServlet {
    private ServicioCRUD servicioCuenta;
    private ObjectMapper mapper;

    public CuentaControlador() {
        servicioCuenta = new CuentaServicio();
        mapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getPathInfo();
        if (path == null) {
            List<Cuenta> usuarios = (List<Cuenta>) servicioCuenta.listar();
            String json = mapper.writeValueAsString(usuarios);
            response.setContentType("application/json");
            response.getWriter().println(json);
        } else {
            // switch (path) {
            // case "/buscar":
            // String identificador = request.getParameter("identificador");
            // try {
            // Cuenta cuenta = (Cuenta) servicioCuenta.buscar(identificador);
            // String json = mapper.writeValueAsString(cuenta);
            // response.setContentType("application/json");
            // response.getWriter().println(json);
            // } catch (Exception e) {
            // response.setStatus(404);
            // Map<String, String> error = new HashMap<>();
            // error.put("error", e.getMessage());
            // String json = mapper.writeValueAsString(error);
            // response.setContentType("application/json");
            // response.getWriter().println(json);
            // }
            // break;
            // default:
            // response.setStatus(404);
            // Map<String, String> error = new HashMap<>();
            // error.put("error", "No se encontro el recurso");
            // String json = mapper.writeValueAsString(error);
            // response.setContentType("application/json");
            // response.getWriter().println(json);
            // break;
            // }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String content = request.getContentType();

        if (content != null && content.equals("application/json")) {
            Map<String, Object> usuarioMap = mapper.readValue(request.getInputStream(), HashMap.class);
            try {
                servicioCuenta.crear(usuarioMap);
                response.setStatus(HttpServletResponse.SC_CREATED);
                Map<String, String> respuesta = new HashMap<>();
                respuesta.put("mensaje", "Cuenta guardada con exito");
                String json = mapper.writeValueAsString(respuesta);
                response.setContentType("application/json");
                response.getWriter().println(json);

            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_CONFLICT);
                Map<String, String> error = new HashMap<>();
                error.put("error", e.getMessage());
                String json = mapper.writeValueAsString(error);
                response.setContentType("application/json");
                response.getWriter().println(json);
            }

        } else {
            response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            Map<String, String> error = new HashMap<>();
            error.put("error", "El contenido debe ser JSON");
            String json = mapper.writeValueAsString(error);
            response.setContentType("application/json");
            response.getWriter().println(json);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String content = request.getContentType();
        if (content == "application/json") {
            Map<String, Object> usuarioMap = mapper.readValue(request.getInputStream(), HashMap.class);

            try {
                servicioCuenta.actualizar(usuarioMap);
                response.setStatus(HttpServletResponse.SC_OK);
                Map<String, String> respuesta = new HashMap<>();
                respuesta.put("mensaje", "Cuenta actualizada con exito");
                String json = mapper.writeValueAsString(respuesta);
                response.setContentType("application/json");
                response.getWriter().println(json);

            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_CONFLICT);
                Map<String, String> error = new HashMap<>();
                error.put("error", e.getMessage());
                String json = mapper.writeValueAsString(error);
                response.setContentType("application/json");
                response.getWriter().println(json);
            }

        } else {
            response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            Map<String, String> error = new HashMap<>();
            error.put("error", "El contenido debe ser JSON");
            String json = mapper.writeValueAsString(error);
            response.setContentType("application/json");
            response.getWriter().println(json);
        }
    }

}
