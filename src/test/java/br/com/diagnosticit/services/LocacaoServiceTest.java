package br.com.diagnosticit.services;


import br.com.diagnosticit.models.Filme;
import br.com.diagnosticit.models.Locacao;
import br.com.diagnosticit.models.Usuario;
import static br.com.diagnosticit.util.DataUtils.isMesmaData;
import static br.com.diagnosticit.util.DataUtils.obterDataComDiferencaDias;
import java.util.Date;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cristiano
 */
public class LocacaoServiceTest {
    
    @Rule
    public ErrorCollector error = new ErrorCollector();
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Test
    public void teste() throws Exception {
        // cenario
        LocacaoService locacaoService = new LocacaoService();
        Usuario usuario = new Usuario("usuario 1");
        Filme filme = new Filme("filme 1", 2, 5.0);
        
        //acao
        Locacao locacao = locacaoService.alugarFilme(usuario, filme);        
        
        //verificação
        //assertEquals(5.0, locacao.getValor(), 0.01);
        
        /*verifique que o valor da alocação é igual á */
        //assertThat(locacao.getValor(), is(equalTo(5.0)));
        //assertThat(locacao.getValor(), is(not(6.0)));
        
        //assertTrue(isMesmaData(locacao.getDataLocacao(), new Date()));
        //assertThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
        
        //assertThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
        //assertTrue(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)) );
        
        error.checkThat(locacao.getValor(), is(equalTo(5.0)));
        error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
        error.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
        
        
    }
    
    @Test(expected = Exception.class)    
    public void testeLocacao_filmeSemEstoque_1() throws Exception{
        
        // cenario
        LocacaoService locacaoService = new LocacaoService();
        Usuario usuario = new Usuario("usuario 1");
        Filme filme = new Filme("filme 1", 0, 5.0);
        
        //acao
        Locacao locacao = locacaoService.alugarFilme(usuario, filme);  
                
    }
    
    @Test   
    public void testeLocacao_filmeSemEstoque_2(){
        
        // cenario
        LocacaoService locacaoService = new LocacaoService();
        Usuario usuario = new Usuario("usuario 1");
        Filme filme = new Filme("filme 1", 0, 5.0);
        
        try {
            //acao
            Locacao locacao = locacaoService.alugarFilme(usuario, filme);
            fail("Deveria ter lançado uma exceção");
        } catch (Exception ex) {
            assertThat(ex.getMessage(), is("Sem estoque"));
        }
        
                
    }
    
    @Test
    public void testeLocacao_filmeSemEstoque_3() throws Exception{
        
        // cenario
        LocacaoService locacaoService = new LocacaoService();
        Usuario usuario = new Usuario("usuario 1");
        Filme filme = new Filme("filme 1", 0, 5.0);
        
        exception.expect(Exception.class);
        exception.expectMessage("Sem estoque");
        
        //acao
        Locacao locacao = locacaoService.alugarFilme(usuario, filme);  
                
    }
    
    
}
