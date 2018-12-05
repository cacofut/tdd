/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.services;

import br.com.diagnosticit.exceptions.NaoPodeDividirPorZeroException;

/**
 *
 * @author cristianoca
 */
class Calculadora {

    public int somar(int a, int b) {
        return a + b;
    }

    int subtrair(int a, int b) {
        return a - b;
    }

    int dividir(int a, int b) throws NaoPodeDividirPorZeroException {
        if( b == 0 ){
            throw new NaoPodeDividirPorZeroException();
        }
        return a / b;
    }


    
}
