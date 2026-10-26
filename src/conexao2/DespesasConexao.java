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
import uc15parte4.Despesas;

/**
 *
 * @author PC 2
 */
public class DespesasConexao {

    public ResultSet rs;
    ArrayList<Despesas> lista = new ArrayList();

    public static void criar(Despesas d) {

        Conexao co = new Conexao();

        PreparedStatement ps;
        String sql = "insert into despesas (categoria,valor,detalhes) values (?,?,?)";
        System.out.println("Dados inseridos.");
        try {
            co.conectar();
            ps = co.conn.prepareStatement(sql);

            ps.setString(1, d.getCategoria());
            ps.setInt(2, d.getValor());
            ps.setString(3, d.getDetalhes());

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("driver não está disponível para acesso ou não existe");
        }
        co.desconectar();
    }

    public void atualizarString(String dados, int id, int alternativa) {

        Conexao co = new Conexao();
        PreparedStatement ps;
        String sql = null;
        try {

            if (alternativa == 1) {
                sql = "update despesas set categoria = ? where id = ?";
            }
            if (alternativa == 2) {
                sql = "update despesas set detalhes = ? where id = ?";
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

    public void atualizarInt(int dados, int id) {
        Conexao co = new Conexao();
        PreparedStatement ps;
        String sql = "update despesas set valor = ? where id = ?";
        try {
            co.conectar();
            ps = co.conn.prepareStatement(sql);
            ps.setInt(1, dados);
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
 co.conectar();
 PreparedStatement ps;
 String sql = ("select * from despesas");
 ps = co.conn.prepareStatement(sql);
 rs = ps.executeQuery();
 lista.clear();
  while(rs.next()){
  Despesas d = new Despesas();
  d.setId(rs.getInt("id"));
  d.setCategoria(rs.getString("categoria"));
  d.setValor(rs.getInt("valor"));
  d.setDetalhes(rs.getString("detalhes"));
  
  lista.add(d);
  }
 } catch (SQLException ex) {
             System.out.println("driver não está disponível para acesso ou não existe");
        } 
 co.desconectar();
 return lista;

 }
 
 public List pesquisarId (int id){
 Conexao co = new Conexao();
 try{    
 
 co.conectar();
 PreparedStatement ps;
 String sql = ("select * from despesas where id = ?");
 ps = co.conn.prepareStatement(sql);
 ps.setInt(1, id);
 rs = ps.executeQuery();
 lista.clear();
  while(rs.next()){
  Despesas d = new Despesas();
  d.setId(rs.getInt("id"));
  d.setCategoria(rs.getString("categoria"));
  d.setValor(rs.getInt("valor"));
  d.setDetalhes(rs.getString("detalhes"));
  
  lista.add(d);
  }
 } catch (SQLException ex) {
             System.out.println("driver não está disponível para acesso ou não existe");
        }
 co.desconectar();
 return lista;
 } 
 
    public void DeletarDespesa(int id){
    Conexao con = new Conexao();
    String comando = "delete from despesas where id=? ";
    con.deletar(id, comando);
}

}
