/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnicos;
import conexion.conexion;
import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class eliminar {
    public static void main (String[] args){
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException ex){
            Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE, null, ex);    
        }
        
        try{
            cn = con.getConection();
            st = cn.createStatement();

            // ✅ ELIMINAR (ejemplo: borra el técnico con id_tecnico = 1)
            String sqlEliminar = "DELETE FROM tecnicos WHERE id_tecnico = 1";
            int filas = st.executeUpdate(sqlEliminar);
            if (filas > 0) {
                System.out.println("✅ Técnico eliminado correctamente.");
            } else {
                System.out.println("⚠️ No se encontró el técnico para eliminar.");
            }

            rs = st.executeQuery("SELECT * FROM tecnicos");
            while (rs.next()){
                System.out.println(
                    rs.getInt("id_tecnico")+": "+
                    rs.getInt("id_usuario")+" - "+
                    rs.getString("especialidad")+" - "+
                    rs.getBoolean("disponible")
                );
            }

        }catch (SQLException ex){
            Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
