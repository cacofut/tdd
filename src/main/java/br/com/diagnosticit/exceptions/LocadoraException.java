/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diagnosticit.exceptions;

/**
 *
 * @author cristianoca
 */
public class LocadoraException extends Exception{
    
    private static final long serialVersionUID = 1L;

    public LocadoraException(String message) {
        super(message);
    }
        
}
