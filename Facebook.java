//Author: Matt Lorenzo
//Date: 5/20/20
//Final Project


//this class extends Profit.java and is the class that
//calculates the profit for the website Facebook

//this class is not fully complete as full taxes and things of that nature are unsure *******

public class Facebook extends Profit
{
   //fields
   //unsure about shipping 
   private final double FACEBOOK_SHIPPING = 7.60;
   
   //constructors
   public Facebook(double buy, double sell)
   {
      super(buy, sell);
   }
   
   //methods
   
   //returns the retailer Facebook
   public String getRetailer()
   {
      return "Facebook";
   }
   
   //this method calculates the total amount of fees that will be taken out
   //of the sale price on Facebook
   @Override
   public double getFees()
   {
      return (getSell() * getPaypalPercentage()) + getPaypalFee() + FACEBOOK_SHIPPING;
   }
   
   //this method calculates the total profit from selling on Facebook
   @Override
   public double getProfit()
   {
      return getSell() - this.getFees() - getBuy();
   }
}