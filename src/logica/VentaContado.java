/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;

/**
 *
 * @author Fabricio
 */
public class VentaContado {
    private ClienteContado cliente;
    private Articulo articulo;
    private Date fecha_venta;
    private String codigo_venta;
    private String notas;

    public VentaContado(ClienteContado cliente, Articulo articulo, Date fecha_venta, String codigo_venta, String notas) {
        this.cliente = cliente;
        this.articulo = articulo;
        this.fecha_venta = fecha_venta;
        this.codigo_venta = codigo_venta;
        this.notas = notas;
    }
    
    public ClienteContado getCliente() {
        return cliente;
    }

    public void setCliente(ClienteContado cliente) {
        this.cliente = cliente;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String getCodigo_venta() {
        return codigo_venta;
    }

    public void setCodigo_venta(String codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
    
    
}
