/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import baseDatos.ConexionBaseDatos;
import baseDatos.Parametro;
import java.sql.ResultSet;
import java.util.ArrayList;
import logica.Articulo;
import logica.Categoria;

/**
 *
 * @author Fabricio
 */
public class ConsultasSQLTablaArticulo {
    private ConexionBaseDatos conexion;
    private boolean error;
    private String errorMsg;

    public boolean isError() {
        return error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    private void limpiarError() {
        this.error = false;
        this.errorMsg = "";
    }

    public ConsultasSQLTablaArticulo(ConexionBaseDatos pConexion) {
        this.conexion = pConexion;
    }

    public ArrayList obtenerArticulo() {
        
        this.limpiarError();
        ArrayList articulos = new ArrayList();

        try {
            ResultSet rs = this.conexion.ejecutarConsultaSQL("SELECT a.cod_articulo, a.descripcion, a.cod_categoria, c.descripcion as descripcion_categoria " + 
                                                            "FROM articulo a, categoria c " + 
                                                            "WHERE a.cod_categoria = c.categoria");
            if (!this.conexion.isError()) {
                while (rs.next()) {
                    Categoria oC = new Categoria(rs.getString("cod_categoria"), rs.getString("descripcion_categoria"));
                    Articulo oA = new Articulo(rs.getString("cod_articulo"), rs.getString("descripcion"), oC);

                    articulos.add(oA);
                }
                
                rs.close();
                
            } else {
                this.error = true;
                this.errorMsg = this.conexion.getErrorMsg();
            }
        } catch (Exception e) {
            this.error = true;
            this.errorMsg = e.getMessage();
        }

        return articulos;
    }
    
    public void agregarArticulo(Articulo oArticulo){
        this.limpiarError();
        String sql = "INSERT INTO articulo(\n" +
"            cod_articulo, descripcion, cod_categoria)\n" +
"    VALUES (?, ?, ?);";
        
        Parametro[] oP = new Parametro[3];
        oP[0] = new Parametro(Parametro.STRING, oArticulo.getCodigo_articulo());
        oP[1] = new Parametro(Parametro.STRING, oArticulo.getDescripcion());
        oP[2] = new Parametro(Parametro.STRING, oArticulo.getoCategoria().getCodigo_categoria());
       
        
        this.conexion.ejecutarSQL(sql, oP);
        
       
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }
    public void actualizarArticulo(Articulo oArticulo, String pCodEditar){
        this.limpiarError();
        String sql = "UPDATE articulo\n" +
"   SET cod_articulo=?, descripcion=?, cod_categoria=?" +
" WHERE cod_articulo=?;";
        
        Parametro[] oP = new Parametro[3];
        oP[0] = new Parametro(Parametro.STRING, oArticulo.getCodigo_articulo());
        oP[1] = new Parametro(Parametro.STRING, oArticulo.getDescripcion());
        oP[2] = new Parametro(Parametro.STRING, oArticulo.getoCategoria().getCodigo_categoria());
        oP[3] = new Parametro(Parametro.STRING, pCodEditar);
        
        this.conexion.ejecutarSQL(sql, oP);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }
    public void borrarDatos(String pArticuloBorrar){
        this.limpiarError();
        String sql = "DELETE FROM articulo\n" +
" WHERE cod_articulo=?;";
        Parametro[] oP = new Parametro[1];
        oP[0] = new Parametro(Parametro.STRING, pArticuloBorrar);
        this.conexion.ejecutarSQL(sql, oP);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }
    
}
