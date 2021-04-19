import java.util.Scanner;
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
    private static Profit[] profitList;
    private static int n;
    private static TestProfit t;
    //private static Gui g;

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
                
            }
        }
        );
        sellPrice = new JTextField();
        sellPrice.setPreferredSize(new Dimension(75,30));
        sellPrice.setPreferredSize(new Dimension(75,30));
        sellPrice.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
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
            t.order(profitList, n);
            for(int i = profitList.length-1; i >= 0; i--)
            {
                System.out.println(profitList[i]);
            }
        }
    public static void main(String args[])
    {
        new Gui();
        t = new TestProfit();
        n = 4;
        profitList = new Profit[n];
        
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

        kb.close();
    }

		
}
