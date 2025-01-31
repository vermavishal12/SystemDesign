package parkingLot.pricing;

import parkingLot.enums.VehcileType;

public class PricingStrategyFactory {
    
    public static SimplePricing getSimplePricing(VehcileType vehcileType) {
        switch (vehcileType) {
            case TWO_WHEELER:
                return new TwoWheelerPricing();
                
            case THREE_WHEELER:
                return new ThreeWheelerPricing();
            case FOUR_WHEELER:
                return new FourWheelerPricing();
            default:
                throw new IllegalArgumentException("Invalid Vehcile Type as an argument");
        }
    }

}
