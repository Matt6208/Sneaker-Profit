//Author: Matt Lorenzo
//Date: 5/20/2020
//Final Project

//this class extends Profit.java and is the class that
//calculates the profit for the website eBay

//this class is not fully complete as full taxes and things of that nature are unsure *******

public class EBay extends Profit
{  
   //fields
   private final double EBAY_PERCENTAGE = 0.10;
   
   //constructors
   public EBay(double buy, double sell)
   {
      super(buy, sell);
   }
   
   //methods
   
   //returns the retailer eBay
   public String getRetailer()
   {
      return "eBay";
   }
   
   //this method calculates the total amount of fees that will be taken out
   //of the sale price on eBay
   @Override
   public double getFees()
   {
      //if sell price is less than 100, 10% eBay fee is applied
      if(this.getSell() < 100.0)
         return (getSell() * EBAY_PERCENTAGE) + (getSell() * getPaypalPercentage()) + getPaypalFee();
      
      //if sell price is over 100, no fee is applied
      return (getSell() * getPaypalPercentage()) + getPaypalFee();
   }
   
   //this method calculates the total profit from selling on eBay
   @Override
   public double getProfit()
   {
      return getSell() - this.getFees() - getBuy();
   }  
}