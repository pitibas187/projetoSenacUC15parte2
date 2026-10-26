/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author PC 2
 */
public class Conexao {
   
     public Connection conn;
     
        public boolean conectar () throws SQLException{
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/uc15distribuidora","root","miguel187187@");
            return true;    
        }catch (ClassNotFoundException| SQLException ex) {
            System.out.println("driver não está disponível para acesso ou não existe");
            return false;        
    }   
 }
            public void desconectar() {
        try {
            conn.close();
            System.out.println("conecção encerrada");
        } catch (SQLException ex) {
            
        }
}
        public void deletar(int id,String sql){
      Conexao co = new Conexao();   
      PreparedStatement ps;
      
        try {
            co.conectar();
            ps = co.conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            
        } catch (SQLException ex) {
             System.out.println("driver não está disponível para acesso ou não existe");
        }
        co.desconectar();
    }
    
    
}
