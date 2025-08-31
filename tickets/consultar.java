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

public class consultar {
    public static void main(String[] args){
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        try {
            cn = con.getConection();
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM tickets");
            while (rs.next()){
                System.out.println(
                    rs.getInt("id_ticket") + " : " +
                    rs.getInt("id_usuario") + " - " +
                    rs.getInt("id_servicio") + " - " +
                    rs.getInt("id_tecnico") + " - " +
                    rs.getString("descripcion") + " - " +
                    rs.getString("estado") + " - " +
                    rs.getTimestamp("fecha_creacion")
                );
            }
        } catch (SQLException ex) {
        System.out.println("⚠️ Error al ejecutar la consulta: " + ex.getMessage());
        }
    }
}
