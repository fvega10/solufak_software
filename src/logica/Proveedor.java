/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Fabricio
 */
public class Proveedor {
    private String cedula;
    private String razon_social;
    private String telefono1;
    private String telefono2;
    private String correo;
    private String direccion;
    private String dias_credito;
    private double monto_credito;
    
    public Proveedor(String pCedula, String pRazon_social, String pTelefono1, String pTelefono2, String pCorreo, String pDireccion, String pDias_credito, double pMontoCredito) {
        this.cedula = pCedula;
        this.razon_social = pRazon_social;
        this.telefono1 = pTelefono1;
        this.telefono2 = pTelefono2;
        this.correo = pCorreo;
        this.direccion = pDireccion;
        this.dias_credito = pDias_credito;
        this.monto_credito = pMontoCredito;
    }

    public double getMonto_credito() {
        return monto_credito;
    }

    public void setMonto_credito(double monto_credito) {
        this.monto_credito = monto_credito;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDias_credito() {
        return dias_credito;
    }

    public void setDias_credito(String dias_credito) {
        this.dias_credito = dias_credito;
    }

    @Override
    public String toString() {
        return "Proveedor: " + razon_social;
    }
    
    
}
