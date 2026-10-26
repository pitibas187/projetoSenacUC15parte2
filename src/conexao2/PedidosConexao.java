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
import uc15parte4.Pedidos;

/**
 *
 * @author PC 2
 */
public class PedidosConexao {

    public ResultSet rs;
    public ArrayList<Pedidos> lista3 = new ArrayList();

    public static void criar(Pedidos p) {

        Conexao co = new Conexao();
        PreparedStatement ps;
        String sql = "insert into pedidos (cliente,idEntregador,cidade,peso) values (?,?,?,?)";
        System.out.println("Dados inseridos.");
        try {
            co.conectar();
            ps = co.conn.prepareStatement(sql);

            ps.setString(1, p.getCliente());
            ps.setInt(2, p.getIdEntregador());
            ps.setString(3, p.getCidade());
            ps.setInt(4, p.getPeso());

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
                sql = "update pedidos set cliente = ? where id = ?";
            }
            if (alternativa == 2) {
                sql = "update pedidos set cidade = ? where id = ?";
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

    public void atualizarInt(int dados, int id, int alternativa) {
        Conexao co = new Conexao();
        PreparedStatement ps;
        String sql = null;
        if (alternativa == 1) {
            sql = "update pedidos set idEntregador = ? where id = ?";
        }
        if (alternativa == 2) {
            sql = "update pedidos set peso = ? where id = ?";
        }

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
 
 PreparedStatement ps;
 String sql = ("select * from pedidos");
  co.conectar();
 ps = co.conn.prepareStatement(sql);
 rs = ps.executeQuery();
 lista3.clear();
  while(rs.next()){
  Pedidos p = new Pedidos();
  p.setId(rs.getInt("id"));
  p.setCliente(rs.getString("cliente"));
  p.setCidade(rs.getString("cidade"));
  p.setPeso(rs.getInt("peso"));
  p.setIdEntregador(rs.getInt("idEntregador"));
  
  lista3.add(p);
  }
 } catch (SQLException ex) {
             System.out.println("driver não está disponível para acesso ou não existe");
        }  
co.desconectar(); 
 return lista3;

 } 
  
 public List pesquisarId (int id){
  Conexao co = new Conexao();
     try{    

 PreparedStatement ps;
 String sql = ("select * from pedidos where id = ?");
  co.conectar();
 ps = co.conn.prepareStatement(sql);
  ps.setInt(1, id);
 rs = ps.executeQuery();
 lista3.clear();
  while(rs.next()){
  Pedidos p = new Pedidos();
  p.setId(rs.getInt("id"));
  p.setCliente(rs.getString("cliente"));
  p.setCidade(rs.getString("cidade"));
  p.setPeso(rs.getInt("peso"));
  p.setIdEntregador(rs.getInt("idEntregador"));
  
  lista3.add(p);
  }
 } catch (SQLException ex) {
             System.out.println("driver não está disponível para acesso ou não existe");
        } 
 co.desconectar();
 return lista3;
 }
    public void deletarPedidos(int id){
        Conexao con = new Conexao();
        String comando = "delete from pedidos where id=? ";
        con.deletar(id, comando);
    }

}
