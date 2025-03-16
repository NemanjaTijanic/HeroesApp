/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Korisnik
 */
public class NeispravanUnosException extends Exception{
    public NeispravanUnosException(String poruka){
        super(poruka);
    }
}
