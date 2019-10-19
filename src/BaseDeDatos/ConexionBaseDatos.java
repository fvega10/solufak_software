/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Fabricio
 */
public class ConexionBaseDatos {
    private boolean error;
    private String errorMsg;
    private Connection conexion;
    private String usuario;
    private String password;
    private String baseDatos;
    private String servidor;
    private String puerto;
    private String driver;
    private String esquema;

    public ConexionBaseDatos(String[] datos) {
        this.servidor  = datos[0];
        this.puerto    = datos[1];
        this.baseDatos = datos[2];
        this.usuario   = datos[3];
        this.password  = datos[4];
        this.driver    = datos[5];
        this.esquema   = datos[6];
    }

    private void limpiarError() {
        this.error = false;
        this.errorMsg = "";
    }

    public void conectar() {
        this.limpiarError();

        String cnxStr = "jdbc:postgresql://"
                + this.servidor + ":"
                + this.puerto + "/"
                + this.baseDatos;
        try {
            Class.forName(this.driver);
        } catch (ClassNotFoundException cnfe) {
            this.error = true;
            this.errorMsg = cnfe.getMessage();
            return;
        }

        try {
            this.conexion = DriverManager.getConnection(cnxStr, this.usuario, this.password);
        } catch (SQLException sqle) {
            this.error = true;
            this.errorMsg = sqle.getMessage();
            return;
        }
    }

    public void ejecutarSQL(String pSql) {
        this.limpiarError();
        Statement stmt;
        try {
            stmt = this.conexion.createStatement();
            stmt.executeUpdate(pSql);
        } catch (SQLException e) {
            this.error = true;
            this.errorMsg = e.getMessage();
            return;
        }
    }

    public void ejecutarSQL(String pSql, Parametro[] pParametros) {
        this.limpiarError();
        PreparedStatement stmt;
        try {
            stmt = this.conexion.prepareStatement(pSql);
            for (int i = 0; i < pParametros.length; i++) {
                switch (pParametros[i].getTipo()) {
                    case Parametro.INT:
                        stmt.setInt((i + 1), pParametros[i].getValorInt());
                        break;
                    case Parametro.DOUBLE:
                        stmt.setDouble((i + 1), pParametros[i].getValorDouble());
                        break;
                    case Parametro.STRING:
                        stmt.setString((i + 1), pParametros[i].getValorString());
                        break;
                    case Parametro.DATETIME:
                        stmt.setDate((i + 1), pParametros[i].getValorDate());
                        break;
                }
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            this.error = true;
            this.errorMsg = e.getMessage();
            return;
        }
    }

    public ResultSet ejecutarConsultaSQL(String pSql, Parametro[] pParametros) {
        this.limpiarError();
        ResultSet rs = null;
        PreparedStatement stmt;
        try {
            stmt = this.conexion.prepareStatement(pSql);
            for (int i = 0; i < pParametros.length; i++) {
                switch (pParametros[i].getTipo()) {
                    case Parametro.INT:
                        stmt.setInt((i + 1), pParametros[i].getValorInt());
                        break;
                    case Parametro.DOUBLE:
                        stmt.setDouble((i + 1), pParametros[i].getValorDouble());
                        break;
                    case Parametro.STRING:
                        stmt.setString((i + 1), pParametros[i].getValorString());
                        break;
                    case Parametro.DATETIME:
                        stmt.setDate((i + 1), pParametros[i].getValorDate());
                        break;
                }
            }
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            this.error = true;
            this.errorMsg = e.getMessage();
        }
        return rs;
    }

    public ResultSet ejecutarConsultaSQL(String pSql) {
        this.limpiarError();
        ResultSet rs = null;
        Statement stmt;
        try {
            stmt = this.conexion.createStatement();
            rs = stmt.executeQuery(pSql);
        } catch (SQLException e) {
            this.error = true;
            this.errorMsg = e.getMessage();
        }
        return rs;
    }

    public void desconectar() {
        this.limpiarError();
        try {
            this.conexion.close();
        } catch (SQLException sqle) {
            this.error = true;
            this.errorMsg = sqle.getMessage();
            return;
        }
    }

    /**
     * @return the error
     */
    public boolean isError() {
        return error;
    }

    /**
     * @return the errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @return the baseDatos
     */
    public String getBaseDatos() {
        return baseDatos;
    }

    /**
     * @return the servidor
     */
    public String getServidor() {
        return servidor;
    }

    /**
     * @return the puerto
     */
    public String getPuerto() {
        return puerto;
    }

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @return the esquema
     */
    public String getEsquema() {
        return esquema;
    }
}
