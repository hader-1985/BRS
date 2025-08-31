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

public class agregar {
    public static void main (String[] args){
        conexion con = new conexion();
        Connection cn;
        Statement st;
        ResultSet rs;

        int id_usuario = 8;  // ⚠️ Debe existir en la tabla usuarios
        String especialidad = "Mantenimiento Software";
        boolean disponible = true;

        String sql = "INSERT INTO tecnicos (id_usuario, especialidad, disponible) " +
                     "VALUES ('"+id_usuario+"','"+especialidad+"',"+disponible+")";

        try{
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql);

            rs = st.executeQuery("SELECT * FROM tecnicos");
            while (rs.next()){
                System.out.println(
                    rs.getInt("id_tecnico") + " : " +
                    rs.getInt("id_usuario") + " - " +
                    rs.getString("especialidad") + " - " +
                    rs.getBoolean("disponible")
                );
            }
        }catch (SQLException ex){
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
