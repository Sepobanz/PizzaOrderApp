import java.awt.*;
import javax.swing.*;
import java.text.NumberFormat;

public class PizzaOrderFrame extends JFrame {

    private JCheckBox anchoviesCheckBox;
    private JRadioButton largeRadioButton;
    private JRadioButton mediumRadioButton;
    private JRadioButton smallRadioButton;
    private JCheckBox mushroomsCheckBox;
    private JCheckBox olivesCheckBox;
    private JCheckBox pepperoniCheckBox;
    private JCheckBox salamiCheckBox;
    private JCheckBox sausageCheckBox;
    private JTextField priceTextField;
    private JButton calculate;
    private JButton exit;

    public PizzaOrderFrame() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
        initComponents();
    }

    private void initComponents() {
        setTitle("Pizza Calculator");
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        
        smallRadioButton = new JRadioButton("Small");
        mediumRadioButton = new JRadioButton("Medium");
        largeRadioButton = new JRadioButton("Large");
        
        ButtonGroup size = new ButtonGroup();
        size.add(smallRadioButton);
        size.add(mediumRadioButton);
        size.add(largeRadioButton);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Size"));
        buttonPanel.add(smallRadioButton);
        buttonPanel.add(mediumRadioButton);
        buttonPanel.add(largeRadioButton);
        
        sausageCheckBox = new JCheckBox("Sausage");
        olivesCheckBox = new JCheckBox("Olives");
        pepperoniCheckBox = new JCheckBox("Pepperoni");
        mushroomsCheckBox = new JCheckBox("Mushrooms");
        salamiCheckBox = new JCheckBox("Salami");
        anchoviesCheckBox = new JCheckBox("Anchovies");
        JPanel toppings = new JPanel();
        toppings.setLayout(new GridBagLayout());
        toppings.setBorder(BorderFactory.createTitledBorder("Toppings"));
        toppings.add(sausageCheckBox, getConstraints(0,0));
        toppings.add(olivesCheckBox, getConstraints(1,0));
        toppings.add(pepperoniCheckBox, getConstraints(0,1));
        toppings.add(mushroomsCheckBox, getConstraints(1,1));
        toppings.add(salamiCheckBox, getConstraints(0,2));
        toppings.add(anchoviesCheckBox, getConstraints(1,2));
        //---------------------------------------------------
        JLabel pLabel = new JLabel("Price: ");
        
        Dimension dim = new Dimension(100,20);
        priceTextField = new JTextField();
        priceTextField.setEditable(false);
        priceTextField.setMinimumSize(dim);
        priceTextField.setPreferredSize(dim);
        
        JPanel pricePanel = new JPanel();
        pricePanel.setLayout(new GridBagLayout());
        pricePanel.add(pLabel, getConstraints(0,0));
        pricePanel.add(priceTextField, getConstraints(1,0));
        //---------------------------------------------------
        calculate = new JButton("Calculate");
        exit = new JButton("Exit");
        JPanel buttons2 = new JPanel();
        buttons2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttons2.add(calculate);
        buttons2.add(exit);
        calculate.addActionListener(e -> calculateButtonClicked());
        exit.addActionListener(e -> {
            System.exit(0);
        });
                
                
        panel.setLayout(new GridBagLayout());
        panel.add(buttonPanel, getConstraints(0,0));
        panel.add(toppings, getConstraints(0,1));
        panel.add(pricePanel, getConstraints(0,2));
        add(panel, BorderLayout.CENTER);
        add(buttons2, BorderLayout.SOUTH);
        
        setSize(270, 280);
    }

     // helper method for getting a GridBagConstraints object
    private GridBagConstraints getConstraints(int x, int y) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(5, 5, 0, 5);
        c.gridx = x;
        c.gridy = y;
        return c;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            PizzaOrderFrame frame = new PizzaOrderFrame();
            frame.setVisible(true);
        });
    }

    private void calculateButtonClicked() {
        double price = 0.0;
        if(smallRadioButton.isSelected()) {
            price = 6.99; 
        } else if(mediumRadioButton.isSelected()) {
            price = 8.99;  
        } else if (largeRadioButton.isSelected()) {
            price = 10.99;
        }
        if (sausageCheckBox.isSelected()) {
            price = price + 1.49;
        }
        if (olivesCheckBox.isSelected()) {
            price = price + .99;
        }
        if (pepperoniCheckBox.isSelected()) {
            price = price + 1.49;
        }
        if (mushroomsCheckBox.isSelected()) {
            price = price + .99;
        }
        if (salamiCheckBox.isSelected()) {
            price = price + 1.49;
        }
        if (anchoviesCheckBox.isSelected()) {
            price = price + .99;
        }
        NumberFormat c = NumberFormat.getCurrencyInstance();
        priceTextField.setText(c.format(price));
    }
}