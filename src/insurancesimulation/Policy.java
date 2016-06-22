package insurancesimulation;

/**
 * An abstract class to model an insurance policy.
 * @author Matty Williams
 * @version 2016
 */
public abstract class Policy {
    
    /**
     * Format 9 characters - B/C/L/V followed by 8 digits
     */
    protected String policyNo;

    /**
     * Has to be between 1990-2013.
     */
    protected int yearOfIssue;
    
    /**
     * Creates a new instance of Policy.
     * @param policyNumber
     * @param year
     * @throws IllegalPolicyException if yearOfIssue is out of range.
     */
    public Policy(String policyNumber, int year)
        throws IllegalPolicyException
    {
        if(year < 1990 || year > 2013) {
            throw new IllegalPolicyException(
                "Year Of Issue " + yearOfIssue + " out of range. "
                        + "Must be in the range 1990 - 2013.");
        }
        
        else if(policyNumber.length()!=9)
        {
            throw new IllegalPolicyException(
                "Policy Number must be 9 characters long with the first "
                        + "character being specific to the policy type.");
        }
        else
        {
        policyNo = policyNumber;
        yearOfIssue = year;
        }
    }
    
    /**
     * @return the policy number of this policy (e.g B07354892)
     */
    public String getPolicyNo(){
        return policyNo;
    }
    
    /**
     * @return the year the policy was issued of this policy.
     */
    public int getYearOfIssue(){
        return yearOfIssue;
    }
    
    /**
     * @return the annual cost of the policy
     */
    public abstract double getPremium();
    

    @Override
    public String toString() {
        StringBuilder buildStr = new StringBuilder("\n\tPolicy Number:\t");
        buildStr.append(policyNo).append("\n\n");
        buildStr.append("\tyearOfIssue:\t");
        buildStr.append(yearOfIssue).append("\n");
        return buildStr.toString();
    }
}