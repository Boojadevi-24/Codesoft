//TASK 4 QUIZ APPLICATION WITH TIMER
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Quiz extends JFrame implements ActionListener {
    JLabel label;
    JLabel timerLabel;
    JRadioButton r[] = new JRadioButton[4];
    JButton Next, Result;
    ButtonGroup bg;
    int c = 0, qn = 0;
    Timer timer;
    int timeRemaining = 60; 

    Quiz(String s) {
        super(s);
        label = new JLabel();
        add(label);
        timerLabel = new JLabel(); 
        add(timerLabel);
        bg = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            r[i] = new JRadioButton();
            add(r[i]);
            bg.add(r[i]);
        }
        Next = new JButton("NextQuestion");
        Result = new JButton("CheckResult");
        Result.setVisible(false);
        Next.addActionListener(this);
        Result.addActionListener(this);
        add(Next);
        add(Result);
        value();
        label.setBounds(30, 40, 450, 20);
        timerLabel.setBounds(500, 40, 100, 20); 
        r[0].setBounds(50, 80, 450, 20);
        r[1].setBounds(50, 110, 450, 20);
        r[2].setBounds(50, 140, 450, 20);
        r[3].setBounds(50, 170, 450, 20);
        Next.setBounds(100, 220, 170, 30);
        Result.setBounds(300, 220, 170, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 400);
        timer = new Timer(1000, this); 
        timer.start(); 
    }

    void value() {
        for (int i = 0; i < 4; i++) {
            r[i].setSelected(false);
        }
        bg.clearSelection();
        if (qn == 0) {
            label.setText("1.Who invented Java Programming?");
            r[0].setText("a) Guido van Rossum");
            r[1].setText("b) James Gosling");
            r[2].setText("c) Dennis Ritchie");
            r[3].setText("d) Bjarne Stroustrup");
        } else if (qn == 1) {
            label.setText("2.Which statement is true about Java?");
            r[0].setText("a) Java is a sequence-dependent programming language");
            r[1].setText("b) Java is a code dependent programming language");
            r[2].setText("c) Java is a platform-dependent programming language");
            r[3].setText("d) Java is a platform-independent programming language");
        } else if (qn == 2) {
            label.setText("3.Which component is used to compile, debug and execute the java programs?");
            r[0].setText("a) JRE");
            r[1].setText("b) JIT");
            r[2].setText("c) JDK");
            r[3].setText("d) JVM");
        } else if (qn == 3) {
            label.setText("4.Which one of the following is not a Java feature?");
            r[0].setText("a) Object-oriented");
            r[1].setText("b) Use of pointers");
            r[2].setText("c) Portable");
            r[3].setText("d) Dynamic and Extensible");
        } else if (qn == 4) {
            label.setText("5.Which of these cannot be used for a variable name in Java?");
            r[0].setText("a) identifier & keyword");
            r[1].setText("b) identifier");
            r[2].setText("c) keyword");
            r[3].setText("d) none of the mentioned");
        } else if (qn == 5) {
            label.setText("6.Which of the following option leads to the portability and security of Java?");
            r[0].setText("a) Bytecode is executed by JVM");
            r[1].setText("b) The applet makes the Java code secure and portable");
            r[2].setText("c) Use of exception handling");
            r[3].setText("d) Dynamic binding between objects");
        } else if (qn == 6) {
            label.setText("7.Which of the following is not a Java feature?");
            r[0].setText("a) Dynamic");
            r[1].setText("b) Architecture Neutral");
            r[2].setText("c) Use of pointers");
            r[3].setText("d) Object-oriented");
        } else if (qn == 7) {
            label.setText("8.What is used to find and fix bugs in the Java programs.");
            r[0].setText("a) JVM");
            r[1].setText("b) JRE");
            r[2].setText("c) JDK");
            r[3].setText("d) JDB");
        } else if (qn == 8) {
            label.setText("9.Which of the following is a valid declaration of a char?");
            r[0].setText("a) char ch = '\\utea';");
            r[1].setText("b) char ca = 'tea';");
            r[2].setText("c) char cr = \\u0223;");
            r[3].setText("d) char cc = '\\itea';");
        }
    }

    boolean check() {
        if (qn == 0) {
            return r[1].isSelected();
        } else if (qn == 1) {
            return r[3].isSelected();
        } else if (qn == 2) {
            return r[2].isSelected();
        } else if (qn == 3) {
            return r[1].isSelected();
        } else if (qn == 4) {
            return r[0].isSelected();
        } else if (qn == 5) {
            return r[0].isSelected();
        } else if (qn == 6) {
            return r[2].isSelected();
        } else if (qn == 7) {
            return r[3].isSelected();
        } else if (qn == 8) {
            return r[1].isSelected();
        }
        return false;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            timeRemaining--;
            timerLabel.setText("Time: " + timeRemaining + " seconds");
            if (timeRemaining == 0) {
                timer.stop();
                JOptionPane.showMessageDialog(this, "Time's up!");
                showResult();
            }
        } else if (e.getSource() == Next) {
            if (check()) {
                c++;
            }
            qn++;
            value();
            if (qn == 9) { 
                Next.setEnabled(false);
                Result.setVisible(true);
                Result.setText("Result");
            }
        } else if (e.getActionCommand().equals("Result")) {
            showResult();
        }
    }

    private void showResult() {
        if (check()) {
            c++;
        }
        JOptionPane.showMessageDialog(this, "Your score is: " + c);
        System.exit(0);
    }

    public static void main(String[] args) {
        new Quiz("Java Quiz Application");
    }
}
