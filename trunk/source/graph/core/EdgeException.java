/*
 * EdgeException.java
 *
 * Created on 01 November 2005, 18:52
 */

package graph.core;

/**
 *
 * @author Linus Norton <linusnorton@gmail.com>
 */
public class EdgeException extends java.lang.Exception {

    /**
     * Creates a new instance of <code>EdgeException</code> without detail message.
     */
    public EdgeException() {
    }


    /**
     * Constructs an instance of <code>EdgeException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public EdgeException(String msg) {
        super(msg);
    }
}