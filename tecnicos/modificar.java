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

public class modificar {
    public static void main (String[] args){
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException ex){
            Logger.getLogger(modificar.class.getName()).log(Level.SEVERE, null, ex);    
        }
        
        try{
            cn = con.getConection();
            st = cn.createStatement();

            // ✅ MODIFICAR (ejemplo: cambiar especialidad del técnico con id_tecnico = 1)
            String sqlModificar = "UPDATE tecnicos SET especialidad = 'Soporte Avanzado' WHERE id_tecnico = 1";
            int filas = st.executeUpdate(sqlModificar);
            if (filas > 0) {
                System.out.println("✅ Técnico modificado correctamente.");
            } else {
                System.out.println("⚠️ No se encontró el registro para modificar.");
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
            Logger.getLogger(modificar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
