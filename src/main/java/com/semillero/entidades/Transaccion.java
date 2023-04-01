package com.semillero.entidades;

public class Transaccion {
    int id;
    String fecha;
    String hora;
    String tipo_transaccion;
    float monto;
    String tipo_cuenta_destino;
    Cuenta cuenta;

    public Transaccion(String fecha, String hora, String tipo_transaccion, float monto, String tipo_cuenta_destino,
            Cuenta cuenta) {
        this.fecha = fecha;
        this.hora = hora;
        this.tipo_transaccion = tipo_transaccion;
        this.monto = monto;
        this.tipo_cuenta_destino = tipo_cuenta_destino;
        this.cuenta = cuenta;
    }

    public Transaccion(int id, String fecha, String hora, String tipo_transaccion, float monto,
            String tipo_cuenta_destino,
            Cuenta cuenta) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.tipo_transaccion = tipo_transaccion;
        this.monto = monto;
        this.tipo_cuenta_destino = tipo_cuenta_destino;
        this.cuenta = cuenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTipo_transaccion() {
        return tipo_transaccion;
    }

    public void setTipo_transaccion(String tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getTipo_cuenta_destino() {
        return tipo_cuenta_destino;
    }

    public void setTipo_cuenta_destino(String tipo_cuenta_destino) {
        this.tipo_cuenta_destino = tipo_cuenta_destino;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
