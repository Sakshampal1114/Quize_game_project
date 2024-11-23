
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Quize extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];

    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoption;
    JButton next, submit, lifeline;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;

    String name;

    // Constructor.....
    Quize(String name) {
        this.name = name;
        setBounds(50, 10, 1200, 650);  // Set the window size and position
        getContentPane().setBackground(Color.white);  // Correct way to set the background color
        setLayout(null);  // Set layout to null for absolute positioning

        //image problem dee raha .......
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1200, 300);
        add(image);

        qno = new JLabel();
        qno.setBounds(80, 330, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(qno);

        question = new JLabel();
        question.setBounds(100, 330, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(question);

        questions[0][0] = " What is a correct syntax to output  'hello world ' in java?";
        questions[0][1] = "System.out.println(\"hello world\");";
        questions[0][2] = "Console.WriteLine(\"hello world\");";
        questions[0][3] = "echo(\"hello world\");";
        questions[0][4] = "print(\"hello world\");";

        questions[1][0] = "Java is short for 'JavaScript'";
        questions[1][1] = "True";
        questions[1][2] = "False";

        questions[2][0] = "How do you insert COMMENT in java code";
        questions[2][1] = "# this is a comment";
        questions[2][2] = "/* this is a comment";
        questions[2][3] = "// this is a comment";
        questions[2][4] = "* this is a comment";

        questions[3][0] = "Which data type is used to create a variable that should store text";
        questions[3][1] = "myString";
        questions[3][2] = "string";
        questions[3][3] = "String";
        questions[3][4] = "Txt";

        questions[4][0] = "How do you create a variable with the numeric value 5";
        questions[4][1] = "x = 5";
        questions[4][2] = "num x =5";
        questions[4][3] = "int x = 5";
        questions[4][4] = "float x=5";

        questions[5][0] = "How do you create a variable with the floating number 2.8?";
        questions[5][1] = "byte x = 2.8f";
        questions[5][2] = "x = 2.8f;";
        questions[5][3] = "int x = 2.8f;";
        questions[5][4] = "float x = 2.8f;";

        questions[6][0] = "Which method can be used to find the length of a string? ";
        questions[6][1] = "length()";
        questions[6][2] = "getLength()";
        questions[6][3] = "getSize()";
        questions[6][4] = "len()";

        questions[7][0] = "Which operator is used to add together two value?";
        questions[7][1] = "The + sign";
        questions[7][2] = "The * sign";
        questions[7][3] = "The & sign";
        questions[7][4] = "The / sign";

        questions[8][0] = "The value of a string variable can be surrounded by single quotes";
        questions[8][1] = "False";
        questions[8][2] = "True";

        questions[9][0] = "Which method can be used to return a string in upper case latters?";
        questions[9][1] = "upperCase()";
        questions[9][2] = "touppercase()";
        questions[9][3] = "tuc()";
        questions[9][4] = "toUpperCase()";

        answers[0][1] = "System.out.println(\"hello world\");";
        answers[1][1] = "False";
        answers[2][1] = "// this is a comment";
        answers[3][1] = "String";
        answers[4][1] = "int x=5";
        answers[5][1] = "float x = 2.8f;";
        answers[6][1] = "length()";
        answers[7][1] = "The + sign";
        answers[8][1] = "False";
        answers[9][1] = "toUpperCase()";

        opt1 = new JRadioButton();
        opt1.setBounds(100, 380, 700, 30);
        opt1.setBackground(Color.white);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 15));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(100, 410, 700, 30);
        opt2.setBackground(Color.white);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 15));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(100, 440, 700, 30);
        opt3.setBackground(Color.white);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 15));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(100, 470, 700, 30);
        opt4.setBackground(Color.white);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 15));
        add(opt4);

        groupoption = new ButtonGroup();
        groupoption.add(opt1);
        groupoption.add(opt2);
        groupoption.add(opt3);
        groupoption.add(opt4);

        next = new JButton("Next");
        next.setBounds(900, 400, 100, 30);
        next.setFont(new Font("Tahoma", Font.PLAIN, 15));
        next.setBackground(Color.blue);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(900, 450, 100, 30);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lifeline.setBackground(Color.blue);
        lifeline.setForeground(Color.white);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(900, 500, 100, 30);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setVisible(true);  // Make the window visible
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (groupoption.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoption.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoption.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoption.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }

    }

    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time left - " + timer + " seconds";//15
        g.setColor(Color.red);
        g.setFont(new Font("Tahoma", Font.BOLD, 15));

        if (timer > 0) {
            g.drawString(time, 880, 400);
        } else {
            g.drawString("Times up!!", 880, 400);
        }

        timer--; //14

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) {  // submit button
                if (groupoption.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoption.getSelection().getActionCommand();
                }

                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button

                if (groupoption.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoption.getSelection().getActionCommand();
                }
                count++; //0
                start(count);
            }
        }
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoption.clearSelection();
    }

    public static void main(String[] args) {
        new Quize("User");  // Create a new instance of Quize
    }
}
