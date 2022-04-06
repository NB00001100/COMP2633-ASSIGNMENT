package main;

// This method holds all the info a fee can have
public class Fees {

    private String feeName;
    private int feeAmount;



    public Fees(String feeName, int feeAmount) {
        this.feeName = feeName;
        this.feeAmount = feeAmount;
    }

    public String getFeeName() {
        return feeName;
    }
    public void setFeeName(String feeName) {
        this.feeName = feeName;
    }
    public int getFeeAmount() {
        return feeAmount;
    }
    public void setFeeAmount(int feeAmount) {
        this.feeAmount = feeAmount;
    }



}
