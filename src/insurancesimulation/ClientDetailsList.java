package insurancesimulation;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A class to model a list of client records for an insurance company.
 * @author Matty Williams
 * @version 2016
 */
public class ClientDetailsList {
    
    private ArrayList<ClientDetails> clientDetailsList;

    /**
     * Creates an empty clientDetailsList.
     */
    public ClientDetailsList()
    {
        clientDetailsList = new ArrayList<ClientDetails>();
    }

    /**
     * Store details of a new Client into this clientDetailsList.
     * @param newClient     The Policy to be stored.
     */
    public void addClient(ClientDetails newClient)
    {
        clientDetailsList.add(newClient);
    }
    
    /**
     * A method to determine the number of clients the company has records for.
     * @return          The number of Clients details currently held in 
     *                  the company's client records.
     */
    public int numberOfClients()
    {
        return clientDetailsList.size();
    }    
    

    /** * A method to determine whether or not a given person, identified by a 
     * surname and a postcode is a client of the Insurance company. 
     * If so, the client’s ID should be returned. 
     * @param surname the surname of the person to be searched for. 
     * @param code the postcode of the address of the person to be 
     * searched for. 
     * @return the Client ID if the person has at least one policy 
     * with the company, null otherwise. 
     */ 
    public String findClient(String surname, String code){ 
        
        Iterator<ClientDetails> it = clientDetailsList.iterator();
        while ( it.hasNext()){
            ClientDetails  cDetails = it.next();
            
            String name = cDetails.getFullName().getSurname();           
            String postcode = cDetails.getAddress().getPostcode();
                    
            String ID = cDetails.getID();
            
            if ( name.equals(surname) && postcode.equals(code) )
                return ID;
        }
        return null;
    }
    
    
    /** 
     * A method to get the client details corresponding to a given client ID
     *
     * @param givenID the client ID whose details are required. 
     * 
     * @return the required ClientDetails if found, 
     * null otherwise.
    */ 
    public ClientDetails getClientDetails(String givenID){ 
        
        Iterator<ClientDetails> it = clientDetailsList.iterator();
        while ( it.hasNext()){
            ClientDetails  cDetails = it.next();
            String ClientID = cDetails.getID();           
            
            if ( ClientID.equals(givenID) )
                return cDetails;
        }
        return null;
    }
    
    
    /** * A method to determine another client who has the same address as 
     * the client whose details are given. 
     * 
     * @param cDetails the client details whose address is to be 
     * searched for. 
     * @return the ClientDetails of a client with the same 
     * address if there is one, null otherwise. 
     */ 
    public ClientDetails sameAddressCheck(ClientDetails cDetails){ 
        
        Iterator<ClientDetails> it = clientDetailsList.iterator();
        while ( it.hasNext()){
            ClientDetails  clientDetails = it.next();
            Address clientAddress = clientDetails.getAddress();           
            
            if ( clientAddress.equals(cDetails) )
                return clientDetails;
        }   

        return null;
    }
    
    @Override
    public String toString()
    {        
        StringBuilder cList = new StringBuilder("\n");
        for (ClientDetails cd : clientDetailsList){
            cList.append(cd.toString()).append("\n");
            cList.append("_______________________________________________\n\n");
        }  
        return cList.toString();
    }
}