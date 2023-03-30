package com.semillero.entidades;

public class Persona {

    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String identificacion;
    private String celular;

    public Persona(String nombre, String apellido, int edad, String identificacion, String celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.identificacion = identificacion;
        this.celular = celular;
    }

    public Persona(int id, String nombre, String apellido, int edad, String identificacion, String celular) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.identificacion = identificacion;
        this.celular = celular;
    }




    // Getters and Setters
    public int getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
