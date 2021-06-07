//Author: Matt Lorenzo
//Date: 5/18/2020
//Final Project

// this program is meant to list out in order from greatest to least
// the profit that could be made on specific websites/apps on a sneaker

public abstract class Profit
{
   //fields
   private String retailer;
   private double buy;
   private double sell;
   private final double PAYPAL_PERCENTAGE = 0.029;
   private final double PAYPAL_FEE = 0.3;
   
   //contructors
   public Profit(double buy, double sell)
   {
      this.buy = buy;
      this.sell = sell;
   }
   
   //getters
   public double getBuy()
   {
      return buy;
   }
   
   public void setBuy(double i){
      buy = i;
   }

   public double getSell()
   {
      return sell;
   }  
   
   public void setSell(double i){
      sell = i;
   }

   public String getRetailer()
   {
      return retailer;
   } 
   
   public double getPaypalPercentage()
   {
      return PAYPAL_PERCENTAGE;
   }
   
   public double getPaypalFee()
   {
      return PAYPAL_FEE;
   }
   
   //abstract methods
   abstract double getFees();
   abstract double getProfit();
   
   //toString method
   public String toString()
   {
      return getRetailer() + ": " + (int)(Math.round(getProfit()*100))/100.0;
   }
}  