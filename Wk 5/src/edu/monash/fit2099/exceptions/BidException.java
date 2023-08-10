/**
 *
 * Author Julian Lim Kah Chun
 *
 * Version 1.0
 *
 */
package edu.monash.fit2099.exceptions;

public class BidException extends Exception {
    /**
     *
     * The method prints the message in the run terminal
     * telling what's the error for one of the methods after
     * input has been given
     *
     * @param message The message input to put through the super function
     */
    public BidException(String message) {
        super(message);
    }
}