//Author: Matt Lorenzo
//Date: 5/18/2020
//Final Project

//this is the test class for Profit project
import java.util.Scanner;

public class TestProfit
{  
   //methods
   
   //this method adds places all Profits in order from most profit to least
   //selection sort
   public static void order(Profit[] profitList, int n)
   {
      while(n > 1)
      {
         int max = 0;
         for(int k = 1; k < n; k++)
         {
            if(profitList[k].getProfit() > profitList[max].getProfit())
            {
               max = k;
            }
         }
         Profit temp = profitList[max];
         profitList[max] = profitList[n-1];
         profitList[n-1] = temp;
         n--;
      }
   }
   
   //main test method
   public static void main (String[] args)
   {
      int n = 4;
      Profit[] profitList = new Profit[n];
      
      Scanner kb = new Scanner(System.in);
      System.out.println("How much did you buy the shoe for?");
      double buy = kb.nextDouble();
      System.out.println("How much do you want to sell the shoe for?");
      double sell = kb.nextDouble();
      
      Grailed grailed = new Grailed(buy, sell);
      OfferUp offerUp = new OfferUp(buy, sell);
      EBay ebay = new EBay(buy, sell);
      Facebook facebook = new Facebook(buy, sell);
      
      profitList[0] = grailed;
      profitList[1] = offerUp;
      profitList[2] = ebay;
      profitList[3] = facebook;
      
      order(profitList, n);
      
      for(int i = profitList.length-1; i >= 0; i--)
      {
         System.out.println(profitList[i]);
      }
      kb.close();
   }
}