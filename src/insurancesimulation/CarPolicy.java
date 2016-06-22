package insurancesimulation;
import static java.lang.Math.max;

/**
 * A sub class of Policy that models the policy for a car.
 * @author Matty Williams
 * @version 2016
 */
public class CarPolicy extends Policy {
    
    private double vehicleValue;
    private int driversAge;
    private int yearsNoClaimMade;
    private boolean isFullyComprehensive;
    final double BASIC_COVER = 100;
    final double FIXED_PERCENTAGE = 10;
    private double initialPremium = max(BASIC_COVER,FIXED_PERCENTAGE);
    
    /**
     * Creates a new instance of CarPolicy.
     * @param policyNumber has to start with a 'V'.
     * @param year
     * @param insuredVehicleValue
     * @param insuredDriverAge has to be between 17 and 99.
     * @param yearsWithNoClaim
     * @param fullyComp
     * @throws IllegalPolicyException
     */
    public CarPolicy(String policyNumber, int year, 
            double insuredVehicleValue, int insuredDriverAge, 
            int yearsWithNoClaim, boolean fullyComp)
            throws IllegalPolicyException {
       
       super(policyNumber, year);
       
       if( insuredDriverAge < 17 || insuredDriverAge > 99)
       {
            throw new IllegalPolicyException ("Can only insure people between "
                    + "the ages of 17 and 99 inclsuive.");
       }
       
       else if (policyNumber.charAt(0) != 'V')
       {
           throw new IllegalPolicyException ("Car Policy Number must "
                   + " start with  a V.");
       }
       
       else
       {
        vehicleValue = insuredVehicleValue;
        driversAge = insuredDriverAge;
        yearsNoClaimMade = yearsWithNoClaim;
        isFullyComprehensive = fullyComp;
       }
    }   
    
    /**
     * @return the value of this CarPolicy.
     */
    public double getVehicleValue(){
        return vehicleValue;
    }
    
    /**
     * @return the drivers age of this CarPolicy.
     */
    public int getDriversAge(){
        return driversAge;
    }

    /**
     * @return the years in which no claim has been made of this CarPolicy.
     */
    public int getYearsNoClaimMade(){
        return yearsNoClaimMade;
    }
    
    /**
     * @return whether this CarPolicy is fully comprehensive or not.
     */
    public boolean getIsFullyComprehensive(){
        return isFullyComprehensive;
    }    
    
    /**
     * @return the premium of this CarPolicy.
     * If its fully comprehensive the premium is doubled.
     * If the driver is between the ages of 16 and 26 the premium is doubled.
     * If the driver hasn't made a claim for a year or longer they receive an
     * appropriate discount.
     */
    @Override
    public double getPremium(){
        if(isFullyComprehensive = true)
        {
            initialPremium = initialPremium + ((initialPremium / 100) * 50);  
        }
        
        if(driversAge>16 && driversAge<26)
        {
            initialPremium = initialPremium + ((initialPremium / 100) * 50);
        }
        
        if (yearsNoClaimMade < 6)
        {
            initialPremium = initialPremium / (100-(7.5*yearsNoClaimMade));
        }
        else
        {
            initialPremium = initialPremium / (100-(7.5*6));
        }
        
        return initialPremium;
    }   
    
    @Override
    public String toString(){        
        StringBuilder str = new StringBuilder(super.toString());
        str.append("\n\tVehicle Value: \t");
        str.append(vehicleValue).append("\n\tDrivers Age: ");
        str.append(driversAge).append("\n\tYears no claim has been made: ");
        str.append(yearsNoClaimMade).append("\n\tIs the insurance fully "
                + "comprehensive?: ");
        str.append(isFullyComprehensive);
        return str.toString();
    }    
}