/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.services;

import br.com.diagnosticit.models.Usuario;
import org.junit.Assert;
import org.junit.Test;



/**
 *
 * @author cristiano
 */
public class AssertTest {
    
    @Test
    public void test(){
        Assert.assertTrue(true);
        Assert.assertFalse(false);
        
        Assert.assertEquals("Erro de comparação", 1, 1);
        Assert.assertEquals(0.51234, 0.5123, 0.0001);
        Assert.assertEquals(Math.PI, 3.14, 0.01);
        
        int i = 5;
        Integer i2 = 5;
        Assert.assertEquals(Integer.valueOf(i), i2);
        Assert.assertEquals(i, i2.intValue());
        
        Assert.assertEquals("bola", "bola");
        Assert.assertNotEquals("bola", "casa");
        Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
        Assert.assertTrue("bola".equals("bola"));
        Assert.assertTrue("bola".startsWith("b"));
        
        Usuario u1 = new Usuario("Usuario 1");
        Usuario u2 = new Usuario("Usuario 1");
        Usuario u3 = u2;
                
        Assert.assertEquals(u1, u2);
        Assert.assertSame(u3, u2);
        Assert.assertNotSame(u1, u2);
        
        u3 = null;
        Assert.assertNull(u3);
        Assert.assertNotNull(u2);
    }
}
