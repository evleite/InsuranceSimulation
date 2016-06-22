package insurancesimulation;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * A class containing a static method to read insurance data 
 * from a file
 * @author Matty Williams
 * @version 2016
 */
public class InputData {
    
    /**
     * @param inputFile
     * @return list including all the client details 
     * @throws IOException
     * @throws IllegalPolicyException
     */
    public static ClientDetailsList readFile( File inputFile ) 
            throws IOException, IllegalPolicyException
    {
        //variables used to read from the file
        final String DELIMITER = "/";
        Scanner fileScan = null;
        Scanner lineScan = null;
        
        //variables for a client
        String nxtLine = null;
        String clientID = null;
        String title = null;
        String initials = null;
        String surname = null;
        String roadName = null;
        String townName = null;
        String postCode = null;
        int year = 0;
        Policy newPolicy = null;
        String policyNo = null;
        
        //variables for a building policy
        double buildingCost = 0;
        String buildingRiskString;
        double buildingRisk = 0;
        
        //variables for a contents policy
        double contentsValue = 0;
        String contentsRiskString;
        double contentsRisk = 0;
        
        //variables for a car policy
        double vehicleValue = 0;
        int driverAge = 0;
        int yearsNoClaimMade = 0;
        String fullyCompString;
        int fullyComp = 0;
        boolean boolFullyComp = false;
        
        //variables for a life policy 
        int custAge = 0;
        int insuredAmount = 0;
        String healthRiskString;
        double healthRisk = 0;
        
        // Creates a new ClientDetailsList to store their details in.
        ClientDetailsList newClientDetailsList = new ClientDetailsList();
        
        // construct a scanner to read data from the file 
        try{ 
            fileScan = new Scanner( inputFile ); 
        
            
        for (int j = 0; j < 14; j++ ){ 
            //Creates a new policy list to store that clients policies in.
            PolicyList newPolicyList = new PolicyList();
            
            // Input the line containing details 
            // for next client as a String
            nxtLine = fileScan.nextLine(); 
            
            // Create a Scanner to process this line of data 
            lineScan = new Scanner( nxtLine ); 
            lineScan.useDelimiter(DELIMITER);
           
            //Takes the indivual details, part by part.
            clientID = lineScan.next(); 
            title = lineScan.next();
            initials = lineScan.next();
            surname = lineScan.next();  
            roadName = lineScan.next();
            townName = lineScan.next();
            postCode = lineScan.next();
           
            //tests to see if the end of the line has been reached. If a person
            //has multiple policies it will continue to read those in.
            while(lineScan.hasNext())
            {
                year = lineScan.nextInt();
                policyNo = lineScan.next();
                char policyType = policyNo.charAt(0);
                
                //determines what type of policy it is based on the first 
                //character.
                switch(policyType){
                    case 'B':
                       buildingCost = lineScan.nextDouble();
                       buildingRiskString = lineScan.next();
                      
                        //if there's a '#' at the end of the string it removes 
                        //it and converts the string to an integer.
                       if(buildingRiskString.charAt(
                               buildingRiskString.length()-1) == '#')
                       {
                            String[] Bparts = buildingRiskString.split("#"); 
                            buildingRisk = Double.parseDouble(Bparts[0]);
                       }
                       else
                       {
                           buildingRisk = 
                                   Double.parseDouble(buildingRiskString);
                       }
                       
                       newPolicy = new BuildingPolicy(policyNo,year,
                               buildingCost,buildingRisk);
                       break;

                    case 'C':
                        contentsValue = lineScan.nextDouble();
                        contentsRiskString = lineScan.next();
                        
                        if(contentsRiskString.charAt(
                                contentsRiskString.length()-1) == '#')
                        {
                            String[] Cparts = contentsRiskString.split("#"); 
                            contentsRisk = Double.parseDouble(Cparts[0]);
                        }
                        else
                        {
                            contentsRisk = 
                                    Double.parseDouble(contentsRiskString);
                        }
                        
                        newPolicy = new ContentsPolicy(policyNo,year,
                                contentsValue,contentsRisk);
                        break;

                    case 'V':
                        vehicleValue = lineScan.nextDouble();
                        driverAge = lineScan.nextInt();
                        yearsNoClaimMade = lineScan.nextInt();
                        fullyCompString = lineScan.next();
                        
                        if(fullyCompString.charAt(
                                fullyCompString.length()-1) == '#')
                        {
                            String[] Vparts = fullyCompString.split("#"); 
                            fullyComp = Integer.parseInt(Vparts[0]);
                        }
                        else
                        {
                            fullyComp = Integer.parseInt(fullyCompString);
                        }
                        
                        if (fullyComp == 0)
                            boolFullyComp = false;
                        else
                            boolFullyComp = true;
                        
                        newPolicy = new CarPolicy(policyNo,year,vehicleValue,
                                driverAge,yearsNoClaimMade,boolFullyComp);
                        break;

                    case 'L':
                        custAge = lineScan.nextInt();
                        insuredAmount = lineScan.nextInt();
                        healthRiskString = lineScan.next();
                        
                        if(healthRiskString.charAt(
                                healthRiskString.length()-1) =='#')
                        {
                            String[] Lparts = healthRiskString.split("#"); 
                            healthRisk = Double.parseDouble(Lparts[0]);
                        }
                        else
                        {
                            healthRisk = Double.parseDouble(healthRiskString);
                        }
                        newPolicy = new LifePolicy(policyNo,year,custAge,
                                insuredAmount,healthRisk);
                        break;

                    default:
                        throw new IllegalPolicyException("PolicyNo must "
                            + "begin with B,C,V or L");
                }

                //adds the policy to that specific clients policy list
                newPolicyList.addPolicy(newPolicy);

            }
            
            Name newName = new Name(title,initials,surname);
            Address newAddress = new Address(roadName,townName,postCode);
            ClientDetails newClient = new ClientDetails(clientID,newName,
                    newAddress,newPolicyList);
            
            newClientDetailsList.addClient(newClient);
        } 
        }
        
        catch(Exception e){ 
            System.out.println(e);
        }

        return newClientDetailsList; 
    }       
}