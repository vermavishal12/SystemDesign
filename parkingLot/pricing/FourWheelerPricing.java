package parkingLot.pricing;

public class FourWheelerPricing implements SimplePricing {

    @Override
    public double calculateFees(long elapsedTime) {
        if(elapsedTime < 1000) {
            return 3.5;
        }else if(elapsedTime < 2000) {
            return 6;
        }else if(elapsedTime < 4000) {
            return 7.5;
        } 
        
        double amount = (double)(elapsedTime)/ 6000;
        return amount*8;
    }
    
}
