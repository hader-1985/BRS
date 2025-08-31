/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;
import conexion.conexion;
import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SBR
 */
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

            // ✅ MODIFICAR (ejemplo: del id_usuario = 2)
            String sqlModificar = "UPDATE usuarios SET apellido = 'Lopez' WHERE id = 1";
            int filas = st.executeUpdate(sqlModificar);
            if (filas > 0) {
                System.out.println("✅ Registro modificado correctamente.");
            } else {
                System.out.println("⚠️ No se encontró el registro para modificar.");
            }

            // ✅ MOSTRAR los registros después de la modificación
            rs = st.executeQuery("SELECT * FROM usuarios");
            while (rs.next()){
                System.out.println(
                    rs.getInt("id")+": "+
                    rs.getString("nombre")+" - "+
                    rs.getString("apellido")+" - "+
                    rs.getString("email")+" - "+
                    rs.getString("direccion")
                );
            }

        }catch (SQLException ex){
            Logger.getLogger(modificar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}