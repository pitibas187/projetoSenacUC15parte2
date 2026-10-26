/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uc15parte4.Usuario;

/**
 *
 * @author PC 2
 */
public class UsuarioConexao {
  
 public ResultSet rs;   
    
 public  Usuario verificar (Usuario u){
  Conexao co = new Conexao();
   Usuario u2 = new Usuario();
     try{    
 
 PreparedStatement ps;
 String sql = ("select * from usuario where login = ? and senha = ?");
  co.conectar();
 ps = co.conn.prepareStatement(sql);
 ps.setString(1, u.getLogin());
 ps.setString(2, u.getSenha());
 rs = ps.executeQuery();
  while(rs.next()){
  u.setId(rs.getInt("id"));
  u.setLogin(rs.getString("login"));
  u.setSenha(rs.getString("senha"));
  
  
  }
 } catch (SQLException ex) {
             System.out.println("driver não está disponível para acesso ou não existe");
        } 
 co.desconectar();
 return u;
 }   
    
    
    
}
