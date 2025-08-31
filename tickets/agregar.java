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

public class agregar {
    public static void main(String[] args){
        conexion con = new conexion();
        Connection cn;
        Statement st;

        int id_usuario = 7;   // debe existir
        int id_servicio = 2;  // debe existir
        int id_tecnico = 1;   // debe existir
        String descripcion = "Quisiera cotizar instalación de redes";
        String estado = "en_proceso";

        String sql = "INSERT INTO tickets (id_usuario, id_servicio, id_tecnico, descripcion, estado) " +
                     "VALUES ("+id_usuario+","+id_servicio+","+id_tecnico+",'"+descripcion+"','"+estado+"')";

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql);
            System.out.println("✅ Ticket agregado.");
        } catch (SQLException ex) {
         System.out.println("⚠️ Error al ejecutar la consulta: " + ex.getMessage());
        }
    }
}
