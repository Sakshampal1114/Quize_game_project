
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {
        setBounds(50, 70, 1200, 650);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 300, 300);
        add(image);

        JLabel heading = new JLabel("Thankyou " + name + " For playing simple minds. ");
        heading.setBounds(400, 30, 900, 30);
        heading.setFont(new Font("tahoma", Font.PLAIN, 17));
        add(heading);

        JLabel lblscore = new JLabel("Your Score is " + score);
        lblscore.setBounds(400, 100, 900, 30);
        lblscore.setFont(new Font("tahoma", Font.PLAIN, 17));
        add(lblscore);

        JButton submit = new JButton("Play again");
        submit.setBounds(400, 150, 250, 30);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}
