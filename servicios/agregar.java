/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;
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

        String nombre = "Instalación de Redes";
        String descripcion = "Revisión e instalación";
        double precio = 190000.00;

        String sql = "INSERT INTO servicios (nombre_servicio, descripcion, precio) " +
                     "VALUES ('"+nombre+"','"+descripcion+"',"+precio+")";

        try {
            cn = con.getConection();
            st = cn.createStatement();
            st.executeUpdate(sql);
            System.out.println("✅ Servicio agregado correctamente.");
        } catch (SQLException ex) {
    System.out.println("⚠️ Error al ejecutar la accion: " + ex.getMessage());
}
    }
}
