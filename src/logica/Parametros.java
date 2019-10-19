/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.swing.Icon;

/**
 *
 * @author Fabricio
 */
public class Parametros {
    private double interes;
    private String nombreEmpresa;
    private Icon iconoEmpresa;
    
    public Parametros(){
    }
    public Parametros(double pImpuestoVentas, String pNombreEmpresa, Icon pIcono){
        this.interes = pImpuestoVentas;
        this.nombreEmpresa = pNombreEmpresa;
        this.iconoEmpresa = pIcono;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public Icon getIconoEmpresa() {
        return iconoEmpresa;
    }

    public void setIconoEmpresa(Icon iconoEmpresa) {
        this.iconoEmpresa = iconoEmpresa;
    }

    
}
