package parkingLot.pricing;

public class TwoWheelerPricing implements SimplePricing {

    @Override
    public double calculateFees(long elapsedTime) {
        if(elapsedTime < 1000) {
            return 2.5;
        }else if(elapsedTime < 2000) {
            return 4.5;
        }else if(elapsedTime < 4000) {
            return 6;
        } 
        
        double amount = (double)(elapsedTime)/ 6000;
        return amount*7;
    }
    
}
