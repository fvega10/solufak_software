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
public class ClienteCredito extends ClienteContado{
    private String categoria_cliente; // A, B, C
    private String notas;
    private double monto_credito;
    private int fecha_gracia;

    public ClienteCredito(String codigo, 
            String nombre, 
            String apellido1, 
            String apellido2, 
            String telefono, 
            String correo_electrónico, 
            String direccion,
            String pCategoria, 
            String pNotas,
            double pMonto, 
            int pFecha_Gracia) {
        super(codigo, nombre, apellido1, apellido2, telefono, correo_electrónico, direccion);
        super.setTipo("Crédito");
        this.categoria_cliente = pCategoria;
        this.notas = pNotas;
        this.monto_credito = pMonto;
        this.fecha_gracia = pFecha_Gracia;
    }

    public String getCategoria_cliente() {
        return categoria_cliente;
    }

    public void setCategoria_cliente(String categoria_cliente) {
        this.categoria_cliente = categoria_cliente;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public double getMonto_credito() {
        return monto_credito;
    }

    public void setMonto_credito(double monto_credito) {
        this.monto_credito = monto_credito;
    }

    public int getFecha_gracia() {
        return fecha_gracia;
    }

    public void setFecha_gracia(int fecha_gracia) {
        this.fecha_gracia = fecha_gracia;
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
    
}
