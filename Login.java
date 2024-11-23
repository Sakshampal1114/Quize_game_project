import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;  // Import for ActionEvent
import java.awt.event.ActionListener;  // Import for ActionListener
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

    JButton rules, back;
    JTextField tfname;

    Login() {
        // Set background color
        getContentPane().setBackground(Color.white);
        setLayout(null);

        // Add background image (if it exists in your project resources)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 600, 500);
        add(image);

        // Add heading label
        JLabel heading = new JLabel("Simple Minds");
        heading.setBounds(750, 60, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 30));
        heading.setForeground(Color.BLUE);
        add(heading);

        // Add label for "Enter your name:"
        JLabel name = new JLabel("Enter your name:");
        name.setBounds(790, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(Color.blue);
        add(name);

        // Add down arrow below the text field (symbol is placed relative to JTextField)
        JLabel symbol = new JLabel("↓");
        symbol.setBounds(850, 170, 250, 25); // Adjust y-position if necessary
        symbol.setFont(new Font("Arial", Font.PLAIN, 25)); // Increase font size for better visibility
        symbol.setForeground(Color.blue);
        add(symbol);

        // Add JTextField for user input
        tfname = new JTextField();
        tfname.setBounds(735, 200, 300, 25); // Adjust x and y positioning for better alignment
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add(tfname);

        // Create and add "Rules" button
        rules = new JButton("Rules");
        rules.setBounds(735, 270, 120, 25);
        rules.setBackground(Color.BLUE);
        rules.setForeground(Color.white);
        rules.addActionListener(this);
        add(rules);

        // Create and add "Back" button
        back = new JButton("Back");
        back.setBounds(915, 270, 120, 25);
        back.setBackground(Color.blue);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        // Set window size and position
        setSize(1200, 500);
        setLocation(50, 90);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Ensure window closes correctly
    }

    public void actionPerformed(ActionEvent ae) {
        // Check if rules button is pressed
        if (ae.getSource() == rules) {
            String name = tfname.getText();
            // Show a message dialog with the game rules
            System.out.println("The 'Rules' button was clicked.");
            setVisible(false);
            new Rules(name);
            // Here you can implement a dialog box or any action related to the rules button
        } 
        // Check if back button is pressed
        else if (ae.getSource() == back) {
            // Close the login window
            setVisible(false);
            dispose();  // Dispose the frame
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
