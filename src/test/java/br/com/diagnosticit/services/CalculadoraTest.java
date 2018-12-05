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
        
        //cen�rio
        int a = 5;
        int b = 8;                
        
        //a��o
        int resultado = calc.somar(a, b);
        
        //verifica��o
        assertEquals(13, resultado);
    }
    
    @Test
    public void deve_subtrair_dois_valores(){
        //cen�rio
        int a = 5;
        int b = 3;        
        
        //ac�o
        int resultado = calc.subtrair(a, b);
        
        //verifica��o
        assertEquals(2, resultado);
        
    }
    
    @Test
    public void deve_dividir_dois_numeros() throws NaoPodeDividirPorZeroException{
        //cen�rio
        int a = 4;
        int b = 2;
        
        //a��o
        int resultado = calc.dividir(a, b);
        
        //verifica��o
        assertEquals(2, resultado);
        
    }
    
    @Test(expected = NaoPodeDividirPorZeroException.class)
    public void nao_pode_dividir_por_zero_exception() throws NaoPodeDividirPorZeroException{
        //cen�rio
        int a = 2;
        int b = 0;
        
        //a��o
        calc.dividir(a, b);
    }
}
