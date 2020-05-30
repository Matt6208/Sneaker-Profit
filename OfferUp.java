//Author: Matt Lorenzo
//Date: 5/18/2020
//Final Project

//this class extends Profit.java and is the class that
//calculates the profit for the app OfferUp

public class OfferUp extends Profit
{
   //fields
   private final double OFFERUP_PERCENTAGE = 0.129;
   
   //constructors
   public OfferUp(double buy, double sell)
   {
      super(buy,sell);
   }
   
   //methods
   
   //returns the retailer OfferUp
   public String getRetailer()
   {
      return "OfferUp";
   }
   
   //this method calculates the total amount of fees that will be taken out
   //of the sale price on grailed
   @Override
   public double getFees()
   {
      return (getSell() * OFFERUP_PERCENTAGE);
   }
   
   //this method calculates the total profit from selling on offerup
   @Override
   public double getProfit()
   {
      return getSell() - this.getFees() - getBuy();
   }
}