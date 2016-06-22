package insurancesimulation;

/**
 * This exception is thrown if the policy given is incorrect or illegal.
 * @author Matty Williams
 * @version 2016
 */
public class IllegalPolicyException extends Exception {

    /** Creates an IllegalPolicyException with a given message
     * @param message */ 
    public IllegalPolicyException(String message) { 
        super(message); 
    }  
}