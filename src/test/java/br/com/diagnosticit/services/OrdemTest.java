/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.services;

import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author cristianoca
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrdemTest {
    
    public static int contador = 0;
    
    @Test
    public void iniciar(){
        contador = 1;
    }
    
    @Test
    public void verifica(){
        assertEquals(1, contador);
    }
}
