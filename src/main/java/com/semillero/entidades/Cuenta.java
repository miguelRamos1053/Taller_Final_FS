package com.semillero.entidades;

public class Cuenta {
    int id;
    String numero_cuenta;
    Integer saldo;
    String tipo_cuenta;
    Usuario usuario;

    public Cuenta(int id, String numero_cuenta, Integer saldo, String tipo_cuenta, Usuario usuario) {
        this.id = id;
        this.numero_cuenta = numero_cuenta;
        this.saldo = saldo;
        this.tipo_cuenta = tipo_cuenta;
        this.usuario = usuario;
    }

    public Cuenta(String numero_cuenta, Integer saldo, String tipo_cuenta, Usuario usuario) {
        this.numero_cuenta = numero_cuenta;
        this.saldo = saldo;
        this.tipo_cuenta = tipo_cuenta;
        this.usuario = usuario;
    }

    public String getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
