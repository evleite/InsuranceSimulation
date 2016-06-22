package insurancesimulation;

/**
 * A sub class of Policy that models the policy for a persons life.
 * @author Matty Williams
 * @version 2016
 */
public class LifePolicy extends Policy {
    
    private int age;
    private int amount;
    private double healthRisk;
    
    /**
     * Creates a new instance of LifePolicy.
     * @param policyNumber has to begin with a 'L'.
     * @param year
     * @param customersAge
     * @param insuredAmount
     * @param customersHealthRisk has to be between 0 and 5.
     * @throws IllegalPolicyException
     */
    public LifePolicy(String policyNumber, int year, 
            int customersAge, int insuredAmount, double customersHealthRisk) 
            throws IllegalPolicyException {
       
       super(policyNumber, year);
       
       if(healthRisk < 0 || healthRisk > 5)
       {
           throw new IllegalPolicyException ("Health Risk must be between 0 "
                   + "and 5.");
       }
       
       else if (policyNumber.charAt(0) != 'L')
       {
           throw new IllegalPolicyException ("Life Policy Number must "
                   + " start with a L.");
       }
       
       else
       {
        age = customersAge;
        amount = insuredAmount;  
        healthRisk = customersHealthRisk;
       }
    }   
    
    /**
     * @return the persons age of this LifePolicy.
     */
    public double getAge(){
        return age;
    }
    
    /**
     * @return the amount of the cover of this LifePolicy.
     */
    public double getAmount(){
        return amount;
    }
    
    /**
     * @return the health risk of this LifePolicy
     */
    public double getHealthRisk(){
        return healthRisk;
    }
  
    /**
     * @return
     */
    @Override
    public double getPremium(){
        double premium = 0;
        double charge = (amount / 1000) + 1;
        
        premium = (1 + healthRisk) * charge;
        
        return premium;
    }
    
    
    @Override
    public String toString(){        
        StringBuilder str = new StringBuilder(super.toString());
        str.append("\n\tAge: \t");
        str.append(age).append("\n\tAmount: ");
        str.append(amount).append("\n\tHealth Risk: ");
        str.append(healthRisk);
        return str.toString();
    }    
}