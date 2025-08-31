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
public class eliminar {
    public static void main(String[] args){
        conexion con = new conexion();
        Connection cn;
        Statement st;

        try {
            cn = con.getConection();
            st = cn.createStatement();
            String sql = "DELETE FROM notificaciones WHERE id_notificacion = 1";
            int filas = st.executeUpdate(sql);
            if (filas > 0) {
                System.out.println("✅ Notificación eliminada.");
            } else {
                System.out.println("⚠️ No se encontró la notificación.");
            }
        } catch (SQLException ex) {
        Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
