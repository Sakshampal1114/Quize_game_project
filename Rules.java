
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Rules extends JFrame implements ActionListener {

    String name;
    JButton start, back;

    //Constructor 
    Rules(String name) {
        this.name = name;
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Welcome" + " " + name);
        heading.setBounds(50, 20, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(Color.blue);
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
                "<html>"
                + "1. This is a mind game that requires focus. Read everything carefully." + "<br><br>"
                + "2. Your goal is to answer each question correctly." + "<br><br>"
                + "3. Read the instructions and rules before starting the game." + "<br><br>"
                + "4. Select the correct answer to each question by clicking the corresponding option." + "<br><br>"
                + "5. You can start the game only after reviewing the rules. Click the 'Start' button when you're ready." + "<br><br>"
                + "6. If you decide not to play or want to return, click the 'Back' button." + "<br><br>"
                + "</html>"
        );
        add(rules);

        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(Color.blue);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(Color.blue);
        start.setForeground(Color.white);
        start.addActionListener(this);
        add(start);

        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quize(name);
        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {

        new Rules("User"); //object
    }
}
