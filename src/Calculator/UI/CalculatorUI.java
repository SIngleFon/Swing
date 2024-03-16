//package Calculator.UI;
//
//import Calculator.Conroller.Controller;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class CalculatorUI extends JFrame implements ActionListener{
//    public static final int WIDTH = 400;
//    public static final int HEIGHT = 300;
//
//    private Controller controller;
//
//    JTextArea log;
//
//    JButton btnPlus = new JButton("+");
//    JButton btnMinus = new JButton("-");
//    JButton btnDivision = new JButton("/");
//    JButton btnMultiplication = new JButton("*");
//    JButton btnEqual = new JButton("=");
//    JButton btnComma = new JButton(",");
//
//    JButton btnClear = new JButton("Clear");
//    JButton btnplusMinus = new JButton("+/-");
//    JButton btnPerc = new JButton("%");
//    JButton btnNull = new JButton("0");
//
//
//    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
//
//    JPanel headerNumber;
//    JPanel headerSign;
//
//    public CalculatorUI(){
//        setSize(WIDTH, HEIGHT);
//        setResizable(false);
//        setTitle("Calculator");
//        createPanel();
//        setVisible(true);
//    }
//    public void appendLog(String text){
//        log.append(text + "\n");
//    }
//private void createPanel(){
//    headerNumber = new JPanel(new GridLayout(5, 4));
//        JButton[] but = new JButton[10];
//        for (int i = 9; i >= 0; i--) {
//            but[i] = new JButton(String.valueOf(i));
//            if(i == 9){
//                headerNumber.add(btnClear);
//                btnClear.addActionListener(this);
//                headerNumber.add(btnplusMinus);
//                btnplusMinus.addActionListener(this);
//                headerNumber.add(btnPerc);
//                btnPerc.addActionListener(this);
//                headerNumber.add(btnDivision);
//                btnDivision.addActionListener(this);
//            }
//            if(i != 0) {
//                headerNumber.add(but[i]);
//                but[i].addActionListener(this);
//
//            }
//            if(i == 0){
//                headerNumber.add(btnNull);
//                btnNull.addActionListener(this);
//                headerNumber.add(btnComma);
//                btnComma.addActionListener(this);
//                headerNumber.add(btnEqual);
//                btnEqual.addActionListener(this);
//            }
//            if(i == 7){
//                headerNumber.add(btnMinus);
//                btnMinus.addActionListener(this);
//            }
//            if(i == 4){
//                headerNumber.add(btnPlus);
//                btnPlus.addActionListener(this);
//            }
//            if(i == 1){
//                headerNumber.add(btnMultiplication);
//                btnMultiplication.addActionListener(this);
//            }
////            but[i].addActionListener((ActionListener) this);
//        }
//        log = new JTextArea();
//        log.setEditable(false);
//        add(log);
//
//        add(headerNumber, BorderLayout.SOUTH);
//
//}
//
//
//    public static void main(String[] args) {
//        new CalculatorUI();
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        JButton pb=(JButton)e.getSource();
//        if(pb == btnClear){
//            log.setText("");
//        }else {
//            if(pb == btnEqual){
////                controller = new Controller(getLog());
//            }else{
//                boolean flag = false;
//                if(pb == btnPlus){
//                    String text = log.getText();
//                    log.setText(text + "+");
//                }if(pb == btnMinus){
//                    String text = log.getText();
//                    log.setText(text + "-");
//                }
//            }
//        }
//    }
//}