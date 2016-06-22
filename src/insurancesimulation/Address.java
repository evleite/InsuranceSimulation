package insurancesimulation;

/**
 * A class to model a person's address.
 * @author Matty Williams
 * @version 2016
 */
public class Address implements Comparable<Address> {
    
    private String street;
    private String town;
    private String postcode;
    
    /**
     * Creates a new instance of Address.
     * @param street
     * @param town
     * @param postcode
     */
    public Address(String street, String town, String postcode) {
    this.street = street;
    this.town = town;
    this.postcode = postcode;
    }
    
    /**
     * @return the street name of this address.
     */
    public String getStreet(){
        return street;
    }
    
    /**
     * @return the town name of this address.
     */
    public String getTown(){
        return town;
    }
    
    /**
     * @return the postcode of this address.
     */
    public String getPostcode(){
        return postcode;
    }    
    
    /**
     * Compares two addresses to see if they are the same.
     * @param other the address that the original postcode is being compared to.
     * @return 0 if the addresses are the same, a positive/negative integer
     * otherwise.
     */
    @Override
    public int compareTo(Address other)
    {
        int result;
        
        int postcodeCheck = postcode.compareTo(other.postcode);
        
        if (postcodeCheck == 0)
            result = street.compareTo(other.street);
        
        else
            result = postcodeCheck;
        
        return result;
    }    

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("\n\t");
        str.append(street).append("\n\t");
        str.append(town).append("\n\t");
        str.append(postcode).append("\n");
        return str.toString();
    }       
}