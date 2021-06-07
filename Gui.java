import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Gui implements ActionListener{ 

    private JFrame frame;
    private JLabel l1;
    private JLabel l2;
    private JButton button;
    private JTextField buyPrice;
    private JTextField sellPrice;
    private Profit[] profitList;
    private int n = 4;
    private double buy;
    private double sell;
    Grailed grailed = new Grailed(buy, sell);
    OfferUp offerUp = new OfferUp(buy, sell);
    EBay ebay = new EBay(buy, sell);
    Facebook facebook = new Facebook(buy, sell);

    public Gui(){
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        frame = new JFrame();
        frame.setSize(400,200);
        frame.setLayout(gb);
        frame.setTitle("Sneaker Profit");

        buyPrice = new JTextField();
        buyPrice.setPreferredSize(new Dimension(75,30));
        buyPrice.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    double b = Double.parseDouble(buyPrice.getText());
                    grailed.setBuy(b);
                    offerUp.setBuy(b);
                    ebay.setBuy(b);
                    facebook.setBuy(b);
                }
                catch(NumberFormatException ex){
                    ex.printStackTrace();
                }
            }
        }
        );

        sellPrice = new JTextField();
        sellPrice.setPreferredSize(new Dimension(75,30));
        sellPrice.setPreferredSize(new Dimension(75,30));
        sellPrice.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    Double s = Double.parseDouble(sellPrice.getText());
                    grailed.setSell(s);
                    offerUp.setSell(s);
                    ebay.setSell(s);
                    facebook.setSell(s);
                }
                catch(NumberFormatException ex){
                    ex.printStackTrace();
                }
            }
        }
        );

        l1 = new JLabel("Buy Price");
        l2 = new JLabel("Sell Price");

        button = new JButton("Calculate");

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(buyPrice, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(sellPrice, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 1;

        frame.add(l1, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        frame.add(l2,gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;

        button.addActionListener(this);
        frame.add(button, gbc);
        button.setSize(300,150);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("Calculated");
            this.order(profitList, n);
            for(int i = profitList.length-1; i >= 0; i--){
                System.out.println(profitList[i]);
            }
        }

        public void fillProfitsArray(){
            profitList = new Profit[n];
            profitList[0] = grailed;
            profitList[1] = offerUp;
            profitList[2] = ebay;
            profitList[3] = facebook;
        }

        public void order(Profit[] profitList, int n){
        while(n > 1){
            int max = 0;
            for(int k = 1; k < n; k++){
                if(profitList[k].getProfit() > profitList[max].getProfit()){
                max = k;
            }
         }
         Profit temp = profitList[max];
         profitList[max] = profitList[n-1];
         profitList[n-1] = temp;
         n--;
      }
   }
    public static void main(String args[])
    {
        Gui g = new Gui();
        g.fillProfitsArray();
    }

		
}
