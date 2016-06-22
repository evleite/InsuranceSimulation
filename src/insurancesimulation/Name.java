package insurancesimulation;

/**
 * A class to model a person's name.
 * @author Matty Williams
 * @version 2016
 */
public class Name {
    
    private String title;
    private String initials;
    private String surname;
    
    /**
     * Creates a new instance of Name.
     * @param title e.g Mr
     * @param initials e.g MJ 
     * @param surname e.g Williams
     */
    public Name(String title, String initials, String surname) {
    this.title = title;
    this.initials = initials;
    this.surname = surname;
    }
    
    /**
     * @return the title (e.g Mr) of this name.
     */
    public String getTitle(){
        return title;
    }
    
    /**
     * @return the initials (e.g MJ) of this name.
     */
    public String getInitials(){
        return initials;
    }
    
    /**
     * @return the surname of this name.
     */
    public String getSurname(){
    return surname;
    }
    
   
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("\n\t");
        str.append(title).append(". ").append(initials);
        str.append(" ").append(surname);
        return str.toString();
    }
}