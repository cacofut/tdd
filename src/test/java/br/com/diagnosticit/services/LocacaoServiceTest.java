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
    public void deve_alugar_filme() throws Exception {
        // cenario    
        Usuario usuario = new Usuario("usuario 1");
        Filme filme = new Filme("filme 1", 2, 5.0);        
        List filmes = Arrays.asList( filme );
                      
        //acao
        Locacao locacao = locacaoService.alugarFilme(usuario, filmes);        
        
        //verificação
        //assertEquals(5.0, locacao.getValor(), 0.01);
                
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
    public void nao_deve_alugar_filme_sem_estoque() throws Exception{        
        // cenario                 
        Usuario usuario = new Usuario("usuario 1");
        Filme filme = new Filme("filme 1", 0, 5.0);
        
        List filmes = Arrays.asList( filme );
        
        //acao
        Locacao locacao = locacaoService.alugarFilme(usuario, filmes);  
                
    }
                
        
    @Test
    public void nao_deve_alugar_filme_sem_usuario() throws FilmeSemEstoqueException{
        //cenário               
        Filme filme = new Filme("Filme 2", 1, 4.0);
        Usuario usuario = null;
        //Usuario usuario = new Usuario("usuario 1");
        
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
    public void nao_deve_alugar_filme_sem_filme() throws FilmeSemEstoqueException, LocadoraException{
        //cenário                  
        Filme filme = null;        
        Usuario usuario = new Usuario("usuario 1");
        
        List filmes = null;
        
        exception.expect(LocadoraException.class);
        exception.expectMessage("Filmes vazios");
        
        //ação
        locacaoService.alugarFilme(usuario, filmes);
                
    }
    
    @Test
    public void deve_pagar_75_porcento_no_terceiro_filme(){
        //cenário
        Filme filme1 = new Filme("", 3, 6.5);
        Filme filme2 = new Filme("", 3, 6.5);
        Filme filme3 = new Filme("", 3, 6.5);
        
        List<Filme> filmes = Arrays.asList( filme1, filme2, filme3 );
        
        //ação
        
    }
    
}
