/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.*;

/**
 *
 * @author Ulisesgtz
 */
 
public class Dao {
    public Connection conexion = null; 
    public Statement state = null;
    
    
    //Conectar a la Base de datos
    public Connection conectar() throws SQLException,ClassNotFoundException{
         Class.forName("com.mysql.jdbc.Driver");
         conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/votaciones","root", "12345");
         return conexion;
    }
    //Desconectar a la Base de datos
    public Connection desconectar() throws SQLException, ClassNotFoundException{
        conexion.close();
        return conexion;
    }
    
    //Metodo para consultar si un email y contraseñan pertenecen a una cuenta registrada
    public boolean isAcountExists(String correo, String contrasena) throws SQLException{
        String sql = "SELECT * FROM usuarios WHERE correo='"+correo+"' AND contrasena='"+contrasena+"'";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        return rs.next();
    }
    
    //Metodo para consultar si el email recibido ya esta registrado
    public boolean isEmailRegistered(String correo) throws SQLException{
        //String sql = "SELECT * FROM usuarios WHERE correo='"+correo+"'";
        //PreparedStatement ps = conexion.prepareStatement(sql);
        state = conexion.createStatement();
        ResultSet rs = state.executeQuery("SELECT * FROM usuarios WHERE correo='"+correo+"'");
        
        //ResultSet rs = ps.executeQuery();
 
        return rs.next();
    }
    
    //Metodo para registrar una cuenta
    public Statement registerUser(String nombre, String apellido, String correo, String contrasena, String domicilio, String colonia, String codigoPostal, String municipio, String telefono, String tipoUsuario) throws SQLException{
        //String sql = "INSERT INTO usuarios (nombre, apellido, correo, contrasena, domicilio, colonia, codigoPostal, municipio, telefono, redSocial, tipoUsuario, privilegios) VALUES ('"+nombre+"','"+apellido+"','"+correo+"','"+contrasena+"','"+domicilio+"','"+colonia+"','"+codigoPostal+"','"+municipio+"','"+telefono+"','"+redSocial+"','"+tipoUsuario+"')";
        //PreparedStatement ps = conexion.prepareStatement(sql);
        state = conexion.createStatement(); 
        state.executeUpdate("INSERT INTO usuarios (nombre, apellido, correo, contrasena, domicilio, colonia, codigoPostal, municipio, telefono, tipoUsuario, aceptado) VALUES ('"+nombre+"','"+apellido+"','"+correo+"','"+contrasena+"','"+domicilio+"','"+colonia+"','"+codigoPostal+"','"+municipio+"','"+telefono+"','"+tipoUsuario+"', 'no')");
        //ps.executeUpdate(sql);
        return state;
    }
    
    public boolean isAccountAceptada(String correo) throws SQLException{
        //String sql = "SELECT * FROM usuarios WHERE correo='"+correo+"'";
        //PreparedStatement ps = conexion.prepareStatement(sql);
        state = conexion.createStatement();
        ResultSet rs = state.executeQuery("SELECT * FROM usuarios WHERE correo='"+correo+"' AND aceptado='si'");
        
        //ResultSet rs = ps.executeQuery();
 
        return rs.next();
    }
    
    public Statement isAccountAceptada2(String correo) throws SQLException{
        //String sql = "SELECT * FROM usuarios WHERE correo='"+correo+"'";
        //PreparedStatement ps = conexion.prepareStatement(sql);
        state = conexion.createStatement(); 
        state.executeUpdate("UPDATE usuarios SET aceptado = 'si' WHERE correo='"+correo+"'");
        //ps.executeUpdate(sql);
        return state; 
        //ResultSet rs = ps.executeQuery();
    }
    
    public boolean isAccountRechazada(String correo) throws SQLException{
        //String sql = "SELECT * FROM usuarios WHERE correo='"+correo+"'";
        //PreparedStatement ps = conexion.prepareStatement(sql);
        state = conexion.createStatement(); 
        state.executeUpdate("Delete from usuarios WHERE correo='"+correo+"'");
        //ps.executeUpdate(sql);
        return false; 
        //ResultSet rs = ps.executeQuery();
    }
    
    public ResultSet aceptarCuenta() throws SQLException{
        //String sql = "INSERT INTO usuarios (nombre, apellido, correo, contrasena, domicilio, colonia, codigoPostal, municipio, telefono, redSocial, tipoUsuario, privilegios) VALUES ('"+nombre+"','"+apellido+"','"+correo+"','"+contrasena+"','"+domicilio+"','"+colonia+"','"+codigoPostal+"','"+municipio+"','"+telefono+"','"+redSocial+"','"+tipoUsuario+"')";
        //PreparedStatement ps = conexion.prepareStatement(sql);
        state = conexion.createStatement(); 
        
        //ps.executeUpdate(sql);
        return state.executeQuery("SELECT * FROM usuarios WHERE aceptado!='1'");
    }
    
    /*public Statement usuariosNoAceptadosAun() throws SQLException{
        state = conexion.createStatement();
        state.executeQuery("SELECT * FROM usuarios WHERE aceptado=null");
        return state;
    }*/
}