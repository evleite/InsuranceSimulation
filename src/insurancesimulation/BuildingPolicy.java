package insurancesimulation;

/**
 * A sub class of Policy that models a policy for a building.
 * @author Matty Williams
 * @version 2016
 */
public class BuildingPolicy extends Policy {
    
    private double estimatedCost;
    private double risk;
    final double REBUILD_FACTOR = 0.001;
    
    /**
     * Creates a new instance of BuildingPolicy.
     * @param policyNumber first character has to be 'B'.
     * @param year
     * @param buildingEstimatedCost
     * @param buildingInsuranceRisk has to be between 0 and 1. 
     * @throws IllegalPolicyException
     */
    public BuildingPolicy(String policyNumber, int year, 
            double buildingEstimatedCost, double buildingInsuranceRisk) 
            throws IllegalPolicyException {
       
       super(policyNumber, year);
       
       if ( buildingInsuranceRisk < 0 || buildingInsuranceRisk > 1)
       {
            throw new IllegalPolicyException ("Risk must be between 0 and 1.");
       }
       
       else if (policyNumber.charAt(0) != 'B')
       {
           throw new IllegalPolicyException ("Building Policy Number must "
                   + " start with a B.");
       }
       
       else
       {
        estimatedCost = buildingEstimatedCost;
        risk = buildingInsuranceRisk;
       }   
    }   
    
    /**
     * @return the estimated cost of this BuildingPolicy.
     */
    public double getEstimatedCost(){
        return estimatedCost;
    }
    
    /**
     * @return the risk of this BuildingPolicy.
     */
    public double getRisk(){
        return risk;
    }
    
    /**
     * @return the premium of this BuildingPolicy by using the estimatedCost,
     * REBUILD_FACTOR and risk.
     */
    @Override
    public double getPremium(){
        return estimatedCost * REBUILD_FACTOR * (1 + risk);
    }

    @Override
    public String toString(){        
        StringBuilder str = new StringBuilder(super.toString());
        str.append("\n\tBuilding Estimated Cost: \t");
        str.append(estimatedCost).append("\n\tRisk: ");
        str.append(risk);
        return str.toString();
    }
}