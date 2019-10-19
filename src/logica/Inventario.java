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
public class Inventario {
    private Articulo articulo;
    private String cod_inventario;
    private int ingresos;
    private int salidas;
    private String tipo_movimiento;
    private int cantidad_final;

    public Inventario(Articulo pArticulo, String pCod_Inventario, String pTipo, int pIngresos, int pSalidas, int pCantidadFinal) {
        this.articulo = pArticulo;
        this.cod_inventario = pCod_Inventario;
        this.tipo_movimiento = pTipo;
        this.ingresos = pIngresos;
        this.salidas = pSalidas;
        this.cantidad_final = pCantidadFinal;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public String getCod_inventario() {
        return cod_inventario;
    }

    public void setCod_inventario(String cod_inventario) {
        this.cod_inventario = cod_inventario;
    }

    public int getIngresos() {
        return ingresos;
    }

    public void setIngresos(int ingresos) {
        this.ingresos = ingresos;
    }

    public int getSalidas() {
        return salidas;
    }

    public void setSalidas(int salidas) {
        this.salidas = salidas;
    }

    public String getTipo_movimiento() {
        return tipo_movimiento;
    }

    public void setTipo_movimiento(String tipo_movimiento) {
        this.tipo_movimiento = tipo_movimiento;
    }

    public int getCantidad_final() {
        return cantidad_final;
    }

    public void setCantidad_final(int cantidad_final) {
        this.cantidad_final = cantidad_final;
    }

    
    
}
