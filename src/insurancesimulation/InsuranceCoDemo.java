package insurancesimulation;

import java.io.File;
import java.io.IOException;

/**
 * The driver class that reads data in from a file and 
 * uses the methods from the classes to perform operations on this data.
 * @author Matty Williams
 * @version 2016
 */
public class InsuranceCoDemo {

    /**
     * @param args the command line arguments
     * @throws insurancesimulation.IllegalPolicyException
     * @throws java.io.IOException
     */
    
    public static void main(String[] args) throws IllegalPolicyException, 
            IOException {
      
        File clientDataFile = null;
        
        try{
            
            // Input cleint data from cleint details data file
            clientDataFile = new File("ClientDetailsInput.txt");
                                    // The  data for the cleint detauks objects 
                                    // are held in file clientDataFile.
            
            ClientDetailsList clientList = InputData.readFile(clientDataFile);
                       
            
            
            //The following statements are tests to ensure specific classes
            //and methods perform their tasks correctly.
            
            //Creates a new name object.
            Name nameCheck = new Name("Mr","MJ","Williams");
            
            //Creates a new address object.
            Address addressCheck = new Address("16 Alicante Way","Norwich",
                    "NR5 8BX");
            
            //Creates a new building policy object.
            BuildingPolicy policyCheck = new BuildingPolicy("B27100037",2008,
                    150000,0.3);
            
            //Creates a new policy list.
            PolicyList policyListCheck = new PolicyList();
            
            //Adds the above policy to the policy list.
            policyListCheck.addPolicy(policyCheck);
            
            //Uses the above objects to create a new instance of clients 
            //details.
            ClientDetails clientCheck = new ClientDetails("IC-x00030Z",
                    nameCheck,addressCheck,policyListCheck);
            
            //Prints out every clients details in the client list.
            System.out.print(clientList.toString());
            
            //Prints out the client details of a specific client.
            System.out.print(clientList.getClientDetails("IC-x00030U"));
            
            //Prints out the number of clients stored in the clients file.
            System.out.println("Number of clients: " + 
                    clientList.numberOfClients());
            
            //Prints out the ID of the client with the corresponding details.
            System.out.println("Corresponding ClientID: " + 
                    clientList.findClient("Bethea", "BO5 1DQ"));
            
            //Prints out a number that indicates whether the given client
            //has the same address as another client.
            System.out.println("Same address check (Null - false, "
                    + "any other value - true): " + 
                    clientList.sameAddressCheck(clientCheck));
            
            //Prints the premium of the policy depending on the values given.
            System.out.println("Premium: " + policyCheck.getPremium());
            
            }
        
        catch(Exception e){ 
            System.out.println(e);
        }
    }
}