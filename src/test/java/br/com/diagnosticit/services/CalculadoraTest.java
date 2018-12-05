/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.services;

import br.com.diagnosticit.exceptions.NaoPodeDividirPorZeroException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author cristianoca
 */
public class CalculadoraTest {
    
    private Calculadora calc;
    
    @Before
    public void setup(){
        calc = new Calculadora();
    }

    @Test
    public void deve_somar_dois_valores(){
        
        //cenário
        int a = 5;
        int b = 8;                
        
        //ação
        int resultado = calc.somar(a, b);
        
        //verificação
        assertEquals(13, resultado);
    }
    
    @Test
    public void deve_subtrair_dois_valores(){
        //cenário
        int a = 5;
        int b = 3;        
        
        //acão
        int resultado = calc.subtrair(a, b);
        
        //verificação
        assertEquals(2, resultado);
        
    }
    
    @Test
    public void deve_dividir_dois_numeros() throws NaoPodeDividirPorZeroException{
        //cenário
        int a = 4;
        int b = 2;
        
        //ação
        int resultado = calc.dividir(a, b);
        
        //verificação
        assertEquals(2, resultado);
        
    }
    
    @Test(expected = NaoPodeDividirPorZeroException.class)
    public void nao_pode_dividir_por_zero_exception() throws NaoPodeDividirPorZeroException{
        //cenário
        int a = 2;
        int b = 0;
        
        //ação
        calc.dividir(a, b);
    }
}
