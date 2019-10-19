/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author Fabricio
 */
public class Facturacion {
    private int cantidad;
    private double subtotal;
    private double descuento;
    private double impuesto_ventas;
    private double total;
    private ArrayList oArticulos;
    private String mnjError;
    private boolean error;
    
    public Facturacion(){
        this.oArticulos = new ArrayList();
        this.mnjError   = "";
        this.error      = false;
    }
    
    public Facturacion(double subtotal, double descuento, int cantidad, double impuesto_ventas, double pTotal) {
        this.subtotal  = subtotal;
        this.descuento = descuento;
        this.cantidad  = cantidad;
        this.impuesto_ventas = impuesto_ventas;
        this.total      = pTotal;
        this.oArticulos = new ArrayList();
        this.mnjError   = "";
        this.error      = false;
    }
    
    public boolean isErro(){
        return this.error;
    }
    
    public void limpiarError(){
        this.mnjError = "";
        this.error = false;
    }
    
    public void agregarArticulo(Articulo pArticulo){
        this.limpiarError();
        try{
            oArticulos.add(pArticulo);
        }catch(Exception e){
            this.error = true;
            this.mnjError = e + "";
        }
    }
    
    public void restarDatos(String codigo, int pPosicionArreglo){
        this.limpiarError();
        Articulo aux = (Articulo)this.oArticulos.get(pPosicionArreglo);
        try{
//            this.subtotal = this.subtotal - aux.getSubtotalFactura();
//            this.descuento = this.descuento - aux.getDescuentoFactura();
//            this.impuesto_ventas = this.impuesto_ventas - aux.getImpuestoFactura();
//            this.total = this.total - aux.getTotalFactura();
            this.oArticulos.remove(pPosicionArreglo);
            this.calcularTotal();
               
        }catch(Exception e1){
            this.error = true;
            this.mnjError = e1 + "";
        }
    }
    
    public double calcularSubtotal(){
        this.limpiarError();
        double resultado = 0.0;
        try{
            for(int i =0; i<this.oArticulos.size(); i++){
                Articulo aux = (Articulo)oArticulos.get(i);
//                resultado += aux.getSubtotalFactura();
            }
            this.subtotal = resultado;
        }catch(Exception e1){
            this.error = true;
            this.mnjError = e1 + "";
        }
        
        return this.subtotal;
    }
    
    public double calcularDescuento(){
        this.limpiarError();
        double resultado = 0.0;
        try{
            for(int i =0; i<this.oArticulos.size(); i++){
                Articulo aux = (Articulo)oArticulos.get(i);
//                resultado += aux.getDescuentoFactura();
            }
            this.descuento = resultado;
        }catch(Exception e2){
            this.error = true;
            this.mnjError = e2 + "";
        }
        
        return this.descuento;
    }
    
    public double calculoImpuestoVentas(){
        this.limpiarError();
        double resultado = 0.0;
        try{
            for(int i =0; i<this.oArticulos.size(); i++){
                Articulo aux = (Articulo)oArticulos.get(i);
//                resultado += aux.getImpuestoFactura();
            }
            this.impuesto_ventas = resultado;
        }catch(Exception e3){
            this.error = true;
            this.mnjError = e3 + "";
        }
        
        
        return this.impuesto_ventas;
    }
    
    public double calcularTotal(){
        
        return ((this.subtotal - this.descuento) + this.impuesto_ventas);
    }

    public ArrayList getoArticulos() {
        return oArticulos;
    }

    public void setoArticulos(ArrayList oArticulos) {
        this.oArticulos = oArticulos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getImpuesto_ventas() {
        return impuesto_ventas;
    }

    public void setImpuesto_ventas(double impuesto_ventas) {
        this.impuesto_ventas = impuesto_ventas;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getMnjError() {
        return mnjError;
    }

    public void setMnjError(String mnjError) {
        this.mnjError = mnjError;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
    
    
}
