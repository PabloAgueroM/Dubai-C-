/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author alulab14
 */
public class Pedido {
    private int id;
    private DetallePedido detalle;
    private Persona cliente;
    private Date fechaOrden;
    private Date fechaEntrega;
    private double aCuenta;
    private double Total;
    private double saldoPendiente;
    private double igvTotal;
    private Estado estado;
    private int Activo;
    
    public Pedido(){
        Activo=1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DetallePedido getDetalle() {
        return detalle;
    }

    public void setDetalle(DetallePedido detalle) {
        this.detalle = detalle;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public double getaCuenta() {
        return aCuenta;
    }

    public void setaCuenta(double aCuenta) {
        this.aCuenta = aCuenta;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public double getSaldoPendiente() {
        return saldoPendiente;
    }

    public void setSaldoPendiente(double saldoPendiente) {
        this.saldoPendiente = saldoPendiente;
    }

    public double getIgvTotal() {
        return igvTotal;
    }

    public void setIgvTotal(double igvTotal) {
        this.igvTotal = igvTotal;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int isActivo() {
        return Activo;
    }

    public void setActivo(int Activo) {
        this.Activo = Activo;
    }
}
