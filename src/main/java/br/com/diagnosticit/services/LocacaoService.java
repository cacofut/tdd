/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.services;

import static br.com.diagnosticit.util.DataUtils.adicionarDias;
import static br.com.diagnosticit.util.DataUtils.isMesmaData;
import static br.com.diagnosticit.util.DataUtils.obterDataComDiferencaDias;

import br.com.diagnosticit.models.Filme;
import br.com.diagnosticit.models.Locacao;
import br.com.diagnosticit.models.Usuario;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author cristiano
 */
public class LocacaoService {
    
    public Locacao alugarFilme(Usuario usuario, Filme filme) throws Exception{
        if( filme.getEstoque() == 0 ){
            throw new Exception("Sem estoque");
        }
        Locacao locacao = new Locacao();
        locacao.setFilme(filme);
        locacao.setUsuario(usuario);
        locacao.setDataLocacao(new Date());
        locacao.setValor(filme.getPrecoLocacao());
        
        Date dataEntrega = new Date();
        dataEntrega = adicionarDias(dataEntrega, 1);
        locacao.setDataRetorno(dataEntrega);
        return locacao;
    }
    
  
}
