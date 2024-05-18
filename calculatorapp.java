import java.awt.*;
import java.awt.event.*;

public class calculatorapp {
    private String operator = "";
    private double firstNumber = 0;

    calculatorapp() {
        Frame f = new Frame();
        f.setTitle("Calculator");
        f.setSize(400, 600);
        f.setLayout(null);
        f.setVisible(true);

        // Main Area (TextField at the top)
        TextField t = new TextField(20);
        t.setBounds(20, 30, 350, 150);
        f.add(t);

        // Button %
        Button b1 = new Button("%percent");
        b1.setBounds(40, 190, 70, 50);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(t.getText());
                operator = "%percent";
                t.setText("");
            }
        });

        f.add(b1);

        // Button CE
        Button b2 = new Button("CE");
        b2.setBounds(120, 190, 70, 50);
        f.add(b2);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setText("");
                firstNumber = 0;
                operator = "";
            }
        });

        // Button C
        Button b3 = new Button("C");
        b3.setBounds(200, 190, 70, 50);
        f.add(b3);
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setText("");
            }
        });

        // Button =
        Button b4 = new Button("=");
        b4.setBounds(280, 190, 70, 50);
        f.add(b4);
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!operator.isEmpty()) {
                    double secondNumber = Double.parseDouble(t.getText());
                    double result = 0;
                    switch (operator) {
                        case "+":
                            result = firstNumber + secondNumber;
                            break;
                        case "-":
                            result = firstNumber - secondNumber;
                            break;
                        case "*":
                            result = firstNumber * secondNumber;
                            break;
                        case "/":
                            result = firstNumber / secondNumber;
                            break;
                        case "%":
                            result = firstNumber % secondNumber;
                            break;
                        case "^":
                            result = Math.pow(firstNumber, secondNumber);
                            break;
                        case "%percent":
                            result = firstNumber / 100 * secondNumber;
                            break;
                    }
                    t.setText(Double.toString(result));
                    operator = "";
                }
            }
        });

        // Button 1
        Button b5 = new Button("1");
        b5.setBounds(40, 250, 70, 50);
        f.add(b5);
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setText(t.getText() + "1");
            }
        });

        // Button 2
        Button b6 = new Button("2");
        b6.setBounds(120, 250, 70, 50);
        f.add(b6);
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setText(t.getText() + "2");
            }
        });

        // Button 3
        Button b7 = new Button("3");
        b7.setBounds(200, 250, 70, 50);
        f.add(b7);
        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setText(t.getText() + "3");
            }
        });

        // Button +
        Button b8 = new Button("+");
        b8.setBounds(280, 250, 70, 50);
        f.add(b8);
        b8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(t.getText());
                operator = "+";
                t.setText("");
            }
        });

        // Button 4
        Button b9 = new Button("4");
        b9.setBounds(40, 310, 70, 50);
        f.add(b9);
        b9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setText(t.getText() + "4");
            }
        });

        // Button 5
        Button b10 = new Button("5");
        b10.setBounds(120, 310, 70, 50);
        f.add(b10);
        b10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setText(t.getText() + "5");
            }
        });

        // Button 6
        Button b11 = new Button("6");
        b11.setBounds(200, 310, 70, 50);
        f.add(b11);
        b11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setText(t.getText() + "6");
            }
        });

        // Button -
        Button b12 = new Button("-");
        b12.setBounds(280, 310, 70, 50);
        f.add(b12);
        b12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(t.getText());
                operator = "-";
                t.setText("");
            }
        });

        // Button 7
        Button b13 = new Button("7");
        b13.setBounds(40, 370, 70, 50);
        f.add(b13);
        b13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setText(t.getText() + "7");
            }
        });

        // Button 8
        Button b14 = new Button("8");
        b14.setBounds(120, 370, 70, 50);
        f.add(b14);
        b14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setText(t.getText() + "8");
            }
        });

        // Button 9
        Button b15 = new Button("9");
        b15.setBounds(200, 370, 70, 50);
        f.add(b15);
        b15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setText(t.getText() + "9");
            }
        });

        // Button *
        Button b16 = new Button("*");
        b16.setBounds(280, 370, 70, 50);
        f.add(b16);
        b16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(t.getText());
                operator = "*";
                t.setText("");
            }
        });

        // Button 0
        Button b17 = new Button("0");
        b17.setBounds(40, 430, 70, 50);
        f.add(b17);
        b17.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t.setText(t.getText() + "0");
            }
        });

        // Button /
        Button b18 = new Button("/");
        b18.setBounds(120, 430, 70, 50);
        f.add(b18);
        b18.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(t.getText());
                operator = "/";
                t.setText("");
            }
        });

        // Button √x
        Button b19 = new Button("√x");
        b19.setBounds(200, 430, 70, 50);
        f.add(b19);
        b19.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(t.getText());
                double result = Math.sqrt(num);
                t.setText(Double.toString(result));
            }
        });

        // Button ^
        Button b20 = new Button("^");
        b20.setBounds(280, 430, 70, 50);
        f.add(b20);
        b20.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(t.getText());
                operator = "^";
                t.setText("");
            }
        });

        // Button |x|
        Button b21 = new Button("|x|");
        b21.setBounds(40, 490, 70, 50);
        f.add(b21);
        b21.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(t.getText());
                double result = Math.abs(num);
                t.setText(Double.toString(result));
            }
        });

        // Button Mod
        Button b22 = new Button("Mod");
        b22.setBounds(120, 490, 70, 50);
        f.add(b22);
        b22.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(t.getText());
                operator = "%";
                t.setText("");
            }
        });

        // Button n!
        Button b23 = new Button("n!");
        b23.setBounds(200, 490, 70, 50);
        f.add(b23);
        b23.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(t.getText());
                int result = 1;
                for (int i = 1; i <= num; i++) {
                    result *= i;
                }
                t.setText(Integer.toString(result));
            }
        });

        // Button log
        Button b24 = new Button("log");
        b24.setBounds(280, 490, 70, 50);
        f.add(b24);
        b24.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(t.getText());
                double result = Math.log10(num);
                t.setText(Double.toString(result));
            }
        });

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new calculatorapp();
    }
}
