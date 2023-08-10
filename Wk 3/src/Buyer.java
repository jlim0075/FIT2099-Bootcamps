public class Buyer {
    private int buyerId;
    private String givenName;
    private String familyName;

    public Buyer(int newBuyerId){
        buyerId = newBuyerId;
    }

    public Buyer(int newBuyerId,String newGivenName,String newFamilyName){
        buyerId = newBuyerId;
        givenName = newGivenName;
        familyName = newFamilyName;

    }

    public void setGivenName(String newGivenName) {
        givenName = newGivenName;
    }

    public void setFamilyName(String newFamilyName){
        familyName = newFamilyName;
    }

    public String description(){
        return "Buyer Id: " + buyerId + ", Given Name: " + givenName + ", Family Name: " + familyName;

    }


}
