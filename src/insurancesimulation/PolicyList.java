package insurancesimulation;
import java.util.ArrayList;

/**
 * A class to model a list of policy records for an insurance company.
 * @author Matty Williams
 * @version 2016
 */
public class PolicyList {
    
    private ArrayList<Policy> policyList;
        
    //The variables that store how many of a certain policy a client has.
    int bCount;
    int cCount;
    int vCount;
    int lCount;
    
    /**
     * Creates an empty policyList.
     */
    public PolicyList()
    {
        bCount = 0;
        cCount = 0;
        vCount = 0;
        lCount = 0;
        policyList = new ArrayList<Policy>();
    }

    /**
     * Store details of a new policy into this policyList.
     * @param newPolicy     The Policy to be stored.
     */
    public void addPolicy(Policy newPolicy) throws IllegalPolicyException
    {
        //increments the relevent variable for that policy
        if (newPolicy.getPolicyNo().charAt(0)=='B')
            bCount++;
        if (newPolicy.getPolicyNo().charAt(0)=='C')
            cCount++;
        if (newPolicy.getPolicyNo().charAt(0)=='V')
            vCount++;
        if (newPolicy.getPolicyNo().charAt(0)=='L')
            lCount++;
        
        //only adds the policy if they haven't already got a policy of that 
        //type.
        if (bCount>1 || cCount>1 || vCount>1 || lCount>1)
        {
            throw new IllegalPolicyException ("Can only have one of the same"
                    + " policy per client.");
        }
        else
            policyList.add(newPolicy);
    }
    
    
    /**
     * A method to determine the number of policies the company has records for.
     * @return          The number of policies' details currently held in 
     *                  the company's customer records.
     */
    public int numberOfPolicies()
    {
        return policyList.size();
    }    
    
    /**
     * Removes all the purchase order records from this list.
     * this purchaseOrderList will be empty after execution of this method.
     */
    public void clearPolicyList(){
        policyList.clear();
    }
    
    @Override
    public String toString()
    {        
        StringBuilder cList = new StringBuilder("\n");
        for (Policy cd : policyList){
            cList.append(cd.toString()).append("\n");
            cList.append("_______________________________________________\n\n");
        }  
        return cList.toString();
    }
}
