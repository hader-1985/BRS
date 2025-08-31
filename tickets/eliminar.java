/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tickets;
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
            String sql = "DELETE FROM tickets WHERE id_ticket = 1";
            int filas = st.executeUpdate(sql);
            if (filas > 0) {
                System.out.println("✅ Ticket eliminado.");
            } else {
                System.out.println("⚠️ No se encontró el ticket.");
            }
        } catch (SQLException ex) {
        System.out.println("⚠️ Error al ejecutar la consulta: " + ex.getMessage());
        }
    }
}
