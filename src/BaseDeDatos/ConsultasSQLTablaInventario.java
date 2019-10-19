/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import java.sql.ResultSet;
import java.util.ArrayList;
import logica.Articulo;
import logica.Inventario;

/**
 *
 * @author estudiante
 */
public class ConsultasSQLTablaInventario {
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

    public ConsultasSQLTablaInventario(baseDatos.ConexionBaseDatos pConexion) {
        this.conexion = pConexion;
    }

    public ArrayList obtenerInventario() {
        
        this.limpiarError();
        ArrayList articulos = new ArrayList();

        try {
            ResultSet rs = this.conexion.ejecutarConsultaSQL("SELECT * FROM inventario");
            if (!this.conexion.isError()) {
                while (rs.next()) {
                    
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
    
    public void agregarArticulo(Inventario oInventario){
        this.limpiarError();
        String sql = "INSERT INTO inventario(\n" +
"            cod_inventario, cod_articulo, tipo_movimiento, ingresos, salidas, \n" +
"            cantidad_final)\n" +
"    VALUES (?, ?, ?, ?, ?, \n" +
"            ?);";
        
        baseDatos.Parametro[] oP = new baseDatos.Parametro[6];
        oP[0] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oInventario.getCod_inventario());
        oP[1] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oInventario.getArticulo().getCodigo_articulo());
        oP[2] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oInventario.getTipo_movimiento());
        oP[3] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oInventario.getIngresos());
        oP[4] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oInventario.getSalidas());
        oP[5] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oInventario.getCantidad_final());
       
        
        this.conexion.ejecutarSQL(sql, oP);
        
       
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }
    public void actualizarArticulo(Inventario oInventario, String pCodEditar){
        this.limpiarError();
        String sql = "UPDATE inventario\n" +
"   SET cod_inventario=?, cod_articulo=?, tipo_movimiento=?, ingresos=?, \n" +
"       salidas=?, cantidad_final=?\n" +
" WHERE cod_inventario=?;";
        
        baseDatos.Parametro[] oP = new baseDatos.Parametro[7];
        oP[0] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oInventario.getCod_inventario());
        oP[1] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oInventario.getArticulo().getCodigo_articulo());
        oP[2] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oInventario.getTipo_movimiento());
        oP[3] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oInventario.getIngresos());
        oP[4] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oInventario.getSalidas());
        oP[5] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oInventario.getCantidad_final());
        oP[6] = new baseDatos.Parametro(baseDatos.Parametro.STRING, pCodEditar);
        
        this.conexion.ejecutarSQL(sql, oP);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }
    public void borrarDatos(String pInventarioBorrar){
        this.limpiarError();
        String sql = "DELETE FROM inventario\n" +
" WHERE cod_inventario=?;";
        baseDatos.Parametro[] oP = new baseDatos.Parametro[1];
        oP[0] = new baseDatos.Parametro(baseDatos.Parametro.STRING, pInventarioBorrar);
        this.conexion.ejecutarSQL(sql, oP);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }
}
