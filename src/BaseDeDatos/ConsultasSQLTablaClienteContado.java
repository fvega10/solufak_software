/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;



import java.sql.ResultSet;
import java.util.ArrayList;
import logica.ClienteContado;

/**
 *
 * @author Fabricio
 */
public class ConsultasSQLTablaClienteContado {

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

    public ConsultasSQLTablaClienteContado(baseDatos.ConexionBaseDatos pConexion) {
        this.conexion = pConexion;
    }

    public ArrayList obtenerClienteContado() {
        
        this.limpiarError();
        ArrayList articulos = new ArrayList();

        try {
            ResultSet rs = this.conexion.ejecutarConsultaSQL("SELECT * FROM clientecontado");
            if (!this.conexion.isError()) {
                while (rs.next()) {
                    ClienteContado oA = new ClienteContado(rs.getString("cod_cliente"), rs.getString("nombre"), 
                                                rs.getString("apellido1"), rs.getString("apellido2"), 
                                                rs.getString("telefono"), rs.getString("correo_electronico"), 
                                                rs.getString("direccion"));
                    

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
    
    public void agregarClienteContado(ClienteContado oCliente){
        this.limpiarError();
        String sql = "INSERT INTO clientecontado(\n" +
"            cod_cliente, nombre, apellido1, apellido2, telefono, correo_electronico, \n" +
"            direccion, tipo)\n" +
"    VALUES (?, ?, ?, ?, ?, ?, \n" +
"            ?, ?);";
        
        baseDatos.Parametro[] oP = new baseDatos.Parametro[8];
        oP[0] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oCliente.getCodigo());
        oP[1] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oCliente.getNombre());
        oP[2] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oCliente.getApellido1());
        oP[3] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oCliente.getApellido2());
        oP[4] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oCliente.getTelefono());
        oP[5] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oCliente.getCorreo_electrónico());
        oP[6] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oCliente.getDireccion());
        oP[7] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oCliente.getTipo());
        
       
        
        this.conexion.ejecutarSQL(sql, oP);
        
       
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }
    public void actualizarClienteContado(ClienteContado oCliente, String pCodEditar){
        this.limpiarError();
        String sql = "UPDATE clientecontado\n" +
"   SET cod_cliente=?, nombre=?, apellido1=?, apellido2=?, telefono=?, \n" +
"       correo_electronico=?, direccion=?, tipo=?\n" +
" WHERE cod_cliente=?;";
        
        baseDatos.Parametro[] oP = new baseDatos.Parametro[9];
        oP[0] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oCliente.getCodigo());
        oP[1] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oCliente.getNombre());
        oP[2] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oCliente.getApellido1());
        oP[3] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oCliente.getApellido2());
        oP[4] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oCliente.getTelefono());
        oP[5] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oCliente.getCorreo_electrónico());
        oP[6] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oCliente.getDireccion());
        oP[7] = new baseDatos.Parametro(baseDatos.Parametro.STRING, oCliente.getTipo());
        oP[8] = new baseDatos.Parametro(baseDatos.Parametro.STRING, pCodEditar);
        
        this.conexion.ejecutarSQL(sql, oP);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }
    public void borrarDatos(String pArticuloBorrar){
        this.limpiarError();
        String sql = "DELETE FROM clientecontado\n" +
" WHERE cod_cliente=?;";
        baseDatos.Parametro[] oP = new baseDatos.Parametro[1];
        oP[0] = new baseDatos.Parametro(baseDatos.Parametro.STRING, pArticuloBorrar);
        this.conexion.ejecutarSQL(sql, oP);
        if (this.conexion.isError()) {
            this.error = true;
            this.errorMsg = this.conexion.getErrorMsg();
        }
    }
}
