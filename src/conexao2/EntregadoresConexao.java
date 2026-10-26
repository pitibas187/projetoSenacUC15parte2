/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uc15parte4.Entregadores;

/**
 *
 * @author PC 2
 */
public class EntregadoresConexao {

    ArrayList<Entregadores> lista2 = new ArrayList();
    public ResultSet rs;

    public static void criar(Entregadores e) {

        Conexao co = new Conexao();
        PreparedStatement ps;
        String sql = "insert into entregadores (CPF,telefone,nome,email) values (?,?,?,?)";
        System.out.println("Dados inseridos.");
        try {
            co.conectar();
            ps = co.conn.prepareStatement(sql);

            ps.setString(1, e.getCPF());
            ps.setString(2, e.getTelefone());
            ps.setString(3, e.getNome());
            ps.setString(4, e.getEmail());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("driver não está disponível para acesso ou não existe");
        }
        co.desconectar();
    }

    public void atualizar(String dados, int id, int alternativa) {

        Conexao co = new Conexao();
        PreparedStatement ps;
        String sql = null;
        try {
            if (alternativa == 1) {
                sql = "update entregadores set CPF = ? where id = ?";
            }
            if (alternativa == 2) {
                sql = "update entregadores set telefone = ? where id = ?";
            }
            if (alternativa == 3) {
                sql = "update entregadores set nome = ? where id = ?";
            }
            if (alternativa == 4) {
                sql = "update entregadores set email = ? where id = ?";
            }
            co.conectar();
            ps = co.conn.prepareStatement(sql);
            ps.setString(1, dados);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("Erro no acesso ao Bando de Dados : " + sqle.getMessage());
        }
        co.desconectar();
    }

         public List pesquisarTudo (){
 Conexao co = new Conexao();
 try{    
 PreparedStatement ps;
 String sql = ("select * from entregadores");
 co.conectar();
 ps = co.conn.prepareStatement(sql);
 rs = ps.executeQuery();
 lista2.clear();
  while(rs.next()){
  Entregadores e = new Entregadores();
  e.setId(rs.getInt("id"));
  e.setNome(rs.getString("nome"));
  e.setCPF(rs.getString("CPF"));
  e.setTelefone(rs.getString("telefone"));
  e.setEmail(rs.getString("email"));
  
  lista2.add(e);
  }
 } catch (SQLException ex) {
             System.out.println("driver não está disponível para acesso ou não existe");
        }  
 co.desconectar(); 
 return lista2;
 }

     
   public List pesquisarId(int id){
 Conexao co = new Conexao();
 try{
 PreparedStatement ps;
 String sql = ("select * from entregadores where id = ?");
 co.conectar();
 ps = co.conn.prepareStatement(sql);
 ps.setInt(1, id);
 rs = ps.executeQuery();
 lista2.clear();
  while(rs.next()){
  Entregadores e = new Entregadores();
  e.setId(rs.getInt("id"));
  e.setNome(rs.getString("nome"));
  e.setCPF(rs.getString("CPF"));
  e.setTelefone(rs.getString("telefone"));
  e.setEmail(rs.getString("email"));
  
  lista2.add(e);
  }
 } catch (SQLException ex) {
             System.out.println("driver não está disponível para acesso ou não existe");
        }   
 co.desconectar();
 return lista2;
 }  
    
    
    public void deletarEntregador(int id){
        Conexao con = new Conexao();
        String comando = "delete from entregadores where id=? ";
        con.deletar(id, comando);
    }

}
