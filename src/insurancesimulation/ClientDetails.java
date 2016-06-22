package insurancesimulation;

/**
 * A class to model a clients personal information.
 * @author Matty Williams
 * @version 2016
 */
public class ClientDetails {
    
    private String clientID;
    private Name fullName;
    private Address fullAddress;
    private PolicyList listOfPolicy;
    
    /**
     * Creates a new instance of ClientDetails.
     * @param ID
     * @param clientFullName
     * @param clientAddress
     * @param policyList
     */
    public ClientDetails(String ID, Name clientFullName, Address clientAddress,
            PolicyList policyList){
        
        clientID = ID;
        fullName = clientFullName;
        fullAddress = clientAddress;
        listOfPolicy = policyList;
    }
    
    /**
     * @return the clients ID of this ClientDetails.
     */
    public String getID(){
        return clientID;
    }
    
    /**
     * @return the clients full name of this ClientDetails.
     */
    public Name getFullName(){
        return fullName;
    }
    
    /**
     * @return the clients address of this ClientDetails.
     */
    public Address getAddress(){
        return fullAddress;
    }
    
    /**
     * @return the list of the policies of this ClientDetails.
     */
    public PolicyList getListOfPolicy(){
        return listOfPolicy;
    }
    
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("\n\tID:\t");
        str.append(clientID).append("\n\tFull Name:\t");
        str.append(fullName).append("\n\tFull Address:\t");
        str.append(fullAddress).append("\n");
        str.append("_______________________________________________\n\n");
        str.append(listOfPolicy).append("\n");
        return str.toString();
    }
}