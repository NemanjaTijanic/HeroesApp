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
public class NedovoljanUnosException extends Exception{
    public NedovoljanUnosException(String poruka){
        super(poruka);
    }
    
}
