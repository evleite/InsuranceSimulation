package insurancesimulation;

/**
 * A sub class of Policy that models a policy for items.
 * @author Matty Williams
 * @version 2016
 */
public class ContentsPolicy extends Policy {
    
    private double contentsValue;
    private double risk;
    final double CONTENTS_FACTOR = 0.01;
    
    /**
     * Creates a new instance of ContentsPolicy.
     * @param policyNumber has to start with a 'C'.
     * @param year
     * @param contentsInsuredValue
     * @param contentsInsuranceRisk
     * @throws IllegalPolicyException
     */
    public ContentsPolicy(String policyNumber, int year, 
            double contentsInsuredValue, double contentsInsuranceRisk) 
            throws IllegalPolicyException {
       
       super(policyNumber, year);
       
       if ( contentsInsuranceRisk < 0 || contentsInsuranceRisk > 1)
       {
           throw new IllegalPolicyException ("Risk must be between 0 and 1.");
       }
       
       else if (policyNumber.charAt(0) != 'C')
       {
           throw new IllegalPolicyException ("Contents Policy Number must "
                   + " start with a C.");
       }
       
       else
       {
        contentsValue = contentsInsuredValue;
        risk = contentsInsuranceRisk;
       }   
    }   
    
    /**
     * @return the value of this ContentsPolicy.
     */
    public double getContentsValue(){
        return contentsValue;
    }
    
    /**
     * @return the risk of this ContentsPolicy.
     */
    public double getRisk(){
        return risk;
    }
    
    /**
     * @return the premium of this ContentsPolicy using contentsValue, 
     * CONTENTS_FACTOR and risk.
     */
    @Override
    public double getPremium(){
        return contentsValue * CONTENTS_FACTOR * (1 + risk);
    }
    
    @Override
    public String toString(){        
        StringBuilder str = new StringBuilder(super.toString());
        str.append("\n\tContents Value: \t");
        str.append(contentsValue).append("\n\tRisk: ");
        str.append(risk);
        return str.toString();
    }
}