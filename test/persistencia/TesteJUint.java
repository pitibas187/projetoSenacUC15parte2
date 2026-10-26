/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package persistencia;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uc15parte4.Despesas;

/**
 *
 * @author PC 2
 */
public class TesteJUint {
    
Despesas despesa; 
ArrayList<Despesas> lista;
    
public Despesas TesteCadastro(){
 

    despesa.setCategoria("reparo");
    despesa.setValor(1000);
    despesa.setDetalhes("O pneu furou");

     return despesa;        

}
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    despesa = new Despesas();   
    lista = new ArrayList();    
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void criarDespesa(){
        
    Despesas d = TesteCadastro();
    assertNotNull(d.getValor());
    assertNotNull(d.getCategoria());    
    assertNotNull(d.getDetalhes());              
    }
    @Test 
    public void pesquisarDespesa(){
    Despesas d = TesteCadastro() ;
    lista.add(d);
    assertNotNull(lista);
        
        
    }
    
    
}
