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
public class agregar {
    public static void main(String[] args){
        conexion con = new conexion();
        Connection cn;
        Statement st;

        int id_usuario = 1; // debe existir
        String mensaje = "Tu ticket ha sido actualizado";
        boolean leido = false;

        int leidoInt = (leido) ? 1 : 0;

        String sql = "INSERT INTO notificaciones (id_usuario, mensaje, leido) " +
                     "VALUES ("+id_usuario+",'"+mensaje+"',"+leidoInt+")";

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql);
            System.out.println("✅ Notificación agregada.");
        } catch (SQLException ex) {
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
