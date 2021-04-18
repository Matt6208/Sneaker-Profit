
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Gui implements ActionListener{ 

    private int count = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;

    public Gui(){
        frame = new JFrame();

        JButton button = new JButton("Click Me");
        button.addActionListener(this);
        panel = new JPanel();
        label = new JLabel("Number of Clicks");
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);
        panel.add(label);

        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Our GUI");
        frame.pack();
        frame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e){
            count++;
            label.setText("Number of Clicks: " + count);
        }
    public static void main(String args[])
    {
        new Gui();
    }

		
}
