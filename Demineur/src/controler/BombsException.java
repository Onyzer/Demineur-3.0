/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author onyze
 */
public class BombsException extends Exception {

    /**
     * Creates a new instance of <code>BombsException</code> without detail
     * message.
     */
    public BombsException() {
        System.out.println("Veuillez entrer un pourcentage ompris dans l'intervalle ]0;85]");
    }

    /**
     * Constructs an instance of <code>BombsException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public BombsException(String msg) {
        super(msg);
    }
}
