/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;


/**
 *
 * @author Administrator
 */
public class ConexionSQL {
    
    
    Connection conectar = null;
    
    public Connection conexion(){
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");
            
            
            
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Coneion fallida" + e.getMessage());
        }
        
        return conectar;
    }
    
    
}
