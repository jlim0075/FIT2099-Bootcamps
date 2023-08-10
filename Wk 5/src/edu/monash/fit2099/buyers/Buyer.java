/**
 *
 * Author Julian Lim Kah Chun
 * Version 1.0
 *
 */


package edu.monash.fit2099.buyers;

public class Buyer {
    private int buyerId;
    private String givenName;
    private String familyName;

    /**
     *
     *
     * This method makes a new buyer and then assigns values to the givenName
     * and familyName.If it is successful,it returns the buyer,else it returns null
     * meaning it was not successful
     *
     * @param newGivenName The input used to assign to GivenName
     * @param newFamilyName The input used to assign to FamilyName
     * @return Returns either Null if not successful or the buyer
     */
    public static Buyer getInstance(String newGivenName, String newFamilyName){
        Buyer buyer = new Buyer();
        if (buyer.setGivenName(newGivenName) && buyer.setFamilyName(newFamilyName)){
            return buyer;
        }
        else {
            return  null;
        }

    }

    /**
     *
     * This method makes a new buyer object
     */
    private Buyer(){

    }

    /**
     * Makes a new buyer object by assigning buyer id input to buyer id
     *
     * @param newBuyerId Represents the buyer id input value
     */
    private Buyer(int newBuyerId){
        buyerId = newBuyerId;
    }

    /**
     *
     * A method that is a constructor where it assigns given inputs to the
     * designated attributes for buyer
     *
     * @param newBuyerId Represents the input for buyer id
     * @param newGivenName Represents the input for given name
     * @param newFamilyName Represents the input for family name
     */
    private Buyer(int newBuyerId,String newGivenName,String newFamilyName){
        buyerId = newBuyerId;
        givenName = newGivenName;
        familyName = newFamilyName;

    }

    /**
     *
     * This method assigns the input value to given name.If it meets the
     * requirements,will assign the value and return true else it will
     * return false
     *
     * @param newGivenName Represents the input value to be assigned to givename
     * @return boolean Returns a boolean telling whether the input was assigned
     * or not
     */
    public boolean setGivenName(String newGivenName) {
        boolean isValid = false;
        if (newGivenName.length() >= 2 && newGivenName.length() <= 15){
            isValid = true;
            givenName = newGivenName;
        }
        return isValid;
    }

    /**
     *
     * The method assigns the input value to family name.If it meets the
     * requirements,will assign the value and return true else it will
     * return false
     *
     * @param newFamilyName Represents the input value to be assigned to familyname
     * @return boolean Returns a boolean telling whether the input was assigned
     * or not
     */
    public boolean setFamilyName(String newFamilyName){
        boolean isValid = false;
        if (newFamilyName.length() >= 2 && newFamilyName.length() <= 15){
            isValid = true;
            familyName = newFamilyName;
        }
        return isValid;
    }

    /**
     *The method assigns the input value to buyer id.If it meets the
     *requirements,will assign the value and return true else it will
     *return false
     *
     * @param newId Represents the input value to be assigned to buyerId
     */
    public void setBuyerId(int newId) {
        buyerId = newId;
    }


    /**
     *The method displays the buyer attributes in a given order
     *
     *
     * @return String Returns a string of the buyer details
     */
    public String description(){
        return  buyerId + "|" + givenName + "|" + familyName;

    }


}
