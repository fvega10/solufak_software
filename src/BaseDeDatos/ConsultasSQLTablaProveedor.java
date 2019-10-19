/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import java.sql.ResultSet;
import java.util.ArrayList;
import logica.Proveedor;

/**
 *
 * @author Fabricio
 */
public class ConsultasSQLTablaProveedor {
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

    public ConsultasSQLTablaProveedor(baseDatos.ConexionBaseDatos pConexion) {
        this.conexion = pConexion;
    }

    public ArrayList obtenerProveedor() {
        
        this.limpiarError();
        ArrayList articulos = new ArrayList();

        try {
            ResultSet rs = this.conexion.ejecutarConsultaSQL("SELECT * FROM proveedor");
            if (!this.conexion.isError()) {
                while (rs.next()) {
                    Proveedor oA = new Proveedor(rs.getString("cedula"), 
                            rs.getString("razon_social"), 
                            rs.getString("telefono1"), 
                            rs.getString("telefono2"), 
                            rs.getString("email"), 
                            rs.getString("direccion"), 
                            rs.getString("plazo_credito"));

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
    
    public void agregarProveedor(Proveedor oArticulo){
        this.limpiarError();
        String sql = "INSERT INTO proveedor(\n" +
"            cedula, razon_social, telefono1, telefono2, email, direccion, plazo_credito)\n" +
"    VALUES (?, ?, ?, ?, ?, ?, ?);";
        
        baseDatos.Parametro[] oP = new baseDatos.Parametro[7];
        oP[0] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oArticulo.getCedula());
        oP[1] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oArticulo.getRazon_social());
        oP[2] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oArticulo.getTelefono1());
        oP[3] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oArticulo.getTelefono2());
        oP[4] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oArticulo.getCorreo());
        oP[5] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oArticulo.getDireccion());
        oP[6] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oArticulo.getDias_credito());
       
        
        this.conexion.ejecutarSQL(sql, oP);
        
       
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }
    public void actualizarProveedor(Proveedor oArticulo, String pCodEditar){
        this.limpiarError();
        String sql = "UPDATE proveedor\n" +
"   SET cedula=?, razon_social=?, telefono1=?, telefono2=?, email=?, direccion=?, plazo_credito=?" +
" WHERE cedula=?;";
        
        baseDatos.Parametro[] oP = new baseDatos.Parametro[8];
        oP[0] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oArticulo.getCedula());
        oP[1] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oArticulo.getRazon_social());
        oP[2] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oArticulo.getTelefono1());
        oP[3] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oArticulo.getTelefono2());
        oP[4] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oArticulo.getCorreo());
        oP[5] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oArticulo.getDireccion());
        oP[6] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oArticulo.getDias_credito());
        oP[7] = new baseDatos.Parametro(baseDatos.Parametro.STRING, pCodEditar);
        
        this.conexion.ejecutarSQL(sql, oP);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }
    public void borrarDatos(String pArticuloBorrar){
        this.limpiarError();
        String sql = "DELETE FROM proveedor\n" +
" WHERE cedula=?;";
        baseDatos.Parametro[] oP = new baseDatos.Parametro[1];
        oP[0] = new baseDatos.Parametro(baseDatos.Parametro.STRING, pArticuloBorrar);
        this.conexion.ejecutarSQL(sql, oP);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }
}
