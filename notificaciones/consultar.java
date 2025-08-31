/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package notificaciones;
import conexion.conexion;
import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ASUS
 */
public class consultar {
    public static void main(String[] args){
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        try {
            cn = con.getConection();
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM notificaciones");
            while (rs.next()){
                System.out.println(
                    rs.getInt("id_notificacion") + " : " +
                    rs.getInt("id_usuario") + " - " +
                    rs.getString("mensaje") + " - " +
                    rs.getBoolean("leido") + " - " +
                    rs.getTimestamp("fecha")
                );
            }
        } catch (SQLException ex) {
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
