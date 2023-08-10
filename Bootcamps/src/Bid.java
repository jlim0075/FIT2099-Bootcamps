public class Bid {

    private String bidId;
    private int bidPrice;
    private String bidDate;



    public Bid(String newBidId, int newBidPrice, String newBidDate){
        bidId = newBidId;
        bidPrice = newBidPrice;
        bidDate = newBidDate;

    }

    public void setBidId(String newBidId) {
        bidId = newBidId;
    }

    public void setBidPrice(int newBidPrice) {
        bidPrice = newBidPrice;
    }

    public void setBidDate(String newBidDate) {
        bidDate = newBidDate;
    }


    public String getBidId() {
        return bidId;
    }

    public int getBidPrice() {
        return bidPrice;
    }

    public String getBidDate() {
        return bidDate;
    }


}
