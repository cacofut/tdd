/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.services;

import br.com.diagnosticit.exceptions.FilmeSemEstoqueException;
import br.com.diagnosticit.exceptions.LocadoraException;
import static br.com.diagnosticit.util.DataUtils.adicionarDias;
import static br.com.diagnosticit.util.DataUtils.isMesmaData;
import static br.com.diagnosticit.util.DataUtils.obterDataComDiferencaDias;

import br.com.diagnosticit.models.Filme;
import br.com.diagnosticit.models.Locacao;
import br.com.diagnosticit.models.Usuario;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author cristiano
 */
public class LocacaoService {
    
    public Locacao alugarFilme(Usuario usuario, List<Filme> filmes) throws LocadoraException, FilmeSemEstoqueException{
        
        if( usuario == null ){
            throw new LocadoraException("Usuário vazio");
        }
        
        if( filmes == null || filmes.isEmpty() ){
            throw new LocadoraException("Filmes vazios");
        }
        
        for( Filme filme : filmes ){
            if(filme.getEstoque() == 0){
                throw new FilmeSemEstoqueException();
            }
        }
                 
        Locacao locacao = new Locacao();
        locacao.setFilmes(filmes);          
        locacao.setUsuario(usuario);
        
        locacao.setDataLocacao(new Date());
        locacao.setValor(
            filmes.stream()
                .mapToDouble( f -> f.getPrecoLocacao() ).sum());
        
        Date dataEntrega = new Date();
        dataEntrega = adicionarDias(dataEntrega, 1);
        locacao.setDataRetorno(dataEntrega);
        return locacao;
    }
    
  
}
