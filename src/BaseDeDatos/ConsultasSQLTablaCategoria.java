/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import java.sql.ResultSet;
import java.util.ArrayList;
import logica.Articulo;
import logica.Categoria;

/**
 *
 * @author Fabricio
 */
public class ConsultasSQLTablaCategoria {
    private baseDatos.ConexionBaseDatos conexion;
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

    public ConsultasSQLTablaCategoria(baseDatos.ConexionBaseDatos pConexion) {
        this.conexion = pConexion;
    }

    public ArrayList obtenerCategoria() {
        
        this.limpiarError();
        ArrayList articulos = new ArrayList();

        try {
            ResultSet rs = this.conexion.ejecutarConsultaSQL("SELECT * FROM categoria");
            if (!this.conexion.isError()) {
                while (rs.next()) {
                    Categoria oC = new Categoria(rs.getString("cod_categoria"), rs.getString("descripcion"));
                    
                    articulos.add(oC);
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
    
    public void agregarCategoria(Categoria oCategoria){
        this.limpiarError();
        String sql = "INSERT INTO categoria(\n" +
"            cod_categoria, descripcion)\n" +
"    VALUES (?, ?);";
        
        baseDatos.Parametro[] oP = new baseDatos.Parametro[2];
        oP[0] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oCategoria.getCodigo_categoria());
        oP[1] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oCategoria.getDescripcion());
       
        
        this.conexion.ejecutarSQL(sql, oP);
        
       
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }
    public void actualizarCategoria(Categoria oCategoria, String pCodEditar){
        this.limpiarError();
        String sql = "UPDATE categoria\n" +
"   SET cod_categoria=?, descripcion=?" +
" WHERE cod_categoria=?;";
        
        baseDatos.Parametro[] oP = new baseDatos.Parametro[3];
         oP[0] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oCategoria.getCodigo_categoria());
        oP[1] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oCategoria.getDescripcion());
        oP[3] = new baseDatos.Parametro(baseDatos.Parametro.STRING, pCodEditar);
        
        this.conexion.ejecutarSQL(sql, oP);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }
    public void borrarDatos(String pArticuloBorrar){
        this.limpiarError();
        String sql = "DELETE FROM categoria\n" +
" WHERE cod_categoria=?;";
        baseDatos.Parametro[] oP = new baseDatos.Parametro[1];
        oP[0] = new baseDatos.Parametro(baseDatos.Parametro.STRING, pArticuloBorrar);
        this.conexion.ejecutarSQL(sql, oP);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }
}
