//Author: Matt Lorenzo
//Date: 5/18/2020
//Final Project

//this class extends Profit.java and is the class that
//calculates profit for the app grailed

public class Grailed extends Profit
{
   //fields
   private final double GRAILED_PERCENTAGE = 0.06;
   //unsure about this...
   //private final int US_SHIPPING = 8;
   
   //constructors
   public Grailed(double buy, double sell)
   {
      super(buy, sell);
   }
   
   //methods
   
   //returns the retailer "Grailed"
   public String getRetailer()
   {
      return "Grailed";
   }
   
   //this method calculates the total amount of fees that will be taken out
   //of the sale price on grailed
   @Override
   public double getFees()
   {
      return (getSell() * GRAILED_PERCENTAGE) + (getSell() * getPaypalPercentage()) + getPaypalFee();
   }
   
   //this method calculates the total profit from selling on grailed
   @Override
   public double getProfit()
   {
      return getSell() - this.getFees() - getBuy();
   }
}