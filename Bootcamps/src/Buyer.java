public class Buyer {
    private String buyerId;
    private String givenName;
    private String familyName;

    public Buyer(String newBuyerId){
        buyerId = newBuyerId;
    }

    public Buyer(String newBuyerId,String newGivenName,String newFamilyName){
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
}
