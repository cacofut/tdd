package br.com.diagnosticit.services;


import br.com.diagnosticit.exceptions.FilmeSemEstoqueException;
import br.com.diagnosticit.exceptions.LocadoraException;
import br.com.diagnosticit.models.Filme;
import br.com.diagnosticit.models.Locacao;
import br.com.diagnosticit.models.Usuario;
import static br.com.diagnosticit.util.DataUtils.isMesmaData;
import static br.com.diagnosticit.util.DataUtils.obterDataComDiferencaDias;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
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
    
    private LocacaoService locacaoService ;
    
    @Rule
    public ErrorCollector error = new ErrorCollector();
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Before
    public void setup(){        
        locacaoService = new LocacaoService();        
    }
        
    @Test
    public void teste() throws Exception {
        // cenario    
        Usuario usuario = new Usuario("usuario 1");
        Filme filme = new Filme("filme 1", 2, 5.0);        
        List filmes = Arrays.asList( filme );
                      
        //acao
        Locacao locacao = locacaoService.alugarFilme(usuario, filmes);        
        
        //verificaÃ§Ã£o
        //assertEquals(5.0, locacao.getValor(), 0.01);
        
        /*verifique que o valor da alocaÃ§Ã£o Ã© igual Ã¡ */
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
    
    @Test(expected = FilmeSemEstoqueException.class)    
    public void testeLocacao_filmeSemEstoque_1() throws Exception{        
        // cenario                 
        Usuario usuario = new Usuario("usuario 1");
        Filme filme = new Filme("filme 1", 0, 5.0);
        
        List filmes = Arrays.asList( filme );
        
        //acao
        Locacao locacao = locacaoService.alugarFilme(usuario, filmes);  
                
    }
        
    @Test
    public void testLocacao_usuarioVazio() throws FilmeSemEstoqueException{
        //cenário               
        Filme filme = new Filme("Filme 2", 1, 4.0);
        Usuario usuario = null;
        
        List filmes = Arrays.asList( filme );
        
        //ação
        try {            
            locacaoService.alugarFilme(usuario, filmes);
            fail();
        } 
        catch (LocadoraException ex) {
            assertThat(ex.getMessage(), is("Usuário vazio"));
        }
                                    
    }
    
    @Test
    public void testLocacao_filmeVazio() throws FilmeSemEstoqueException, LocadoraException{
        //cenário                  
        Filme filme = null;        
        Usuario usuario = new Usuario("usuario 1");
        
        List filmes = Arrays.asList( filme );
        
        exception.expect(LocadoraException.class);
        exception.expectMessage("Filme vazio");
        
        //ação
        locacaoService.alugarFilme(usuario, filmes);
                
    }
    
    
}
