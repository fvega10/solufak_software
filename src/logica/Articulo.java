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
public class Articulo {
    private String codigo_articulo;
    private String descripcion;
    private Categoria oCategoria;
    
    
    
    public Articulo(String pCodigo_articulo, String pDescripcion, 
                    Categoria pCategoria){
        this.codigo_articulo = pCodigo_articulo;
        this.descripcion = pDescripcion;
        oCategoria = pCategoria;
    }
    
    public String getCodigo_articulo() {
        return codigo_articulo;
    }

    public void setCodigo_articulo(String codigo_articulo) {
        this.codigo_articulo = codigo_articulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getoCategoria() {
        return oCategoria;
    }

    public void setoCategoria(Categoria oCategoria) {
        this.oCategoria = oCategoria;
    }

    
}
