package Guide.UI;

import Guide.Controller.GuideEmployee;

import javax.swing.*;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class UI extends JFrame implements InterfaceUI {
    JTextArea log;

    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    private GuideEmployee guideEmployee;
    JButton btnAddEmployee = new JButton("Add Employee");
    JButton btnAdd = new JButton("Add");
    JButton btnRefresh = new JButton("REFRESH");
    JTextField tfFindId = new JTextField("ID");
    JTextField tfFindName = new JTextField("Name");
    JTextField tfName = new JTextField("Name");
    JTextField tfNumber = new JTextField("NumberPhone");
    JTextField tfFindExperience = new JTextField("Experience");
    JTextField tfExperience = new JTextField("Experience");
    JButton btnFind = new JButton("Find");
    JPanel headerPanel;
    public UI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat client");
        createPanel();
        setVisible(true);
    }

    @Override
    public void appendLog(String text) {
        log.append(text + "\n");
    }
    public void clearLog(){
        log.setText("");
    }
    private void createPanel() {
        headerPanel = new JPanel(new GridLayout(1, 5));
        headerPanel.add(btnAddEmployee);
        btnAddEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });
        Prompt(tfFindId, "ID");
        Prompt(tfFindName, "Name");
        Prompt(tfFindExperience, "Experience");
        headerPanel.add(tfFindId);
        headerPanel.add(tfFindName);
        headerPanel.add(tfFindExperience);
        headerPanel.add(btnFind);
        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tfFindName.getText().isEmpty() | !tfFindName.getText().equals("Name")){
                    guideEmployee.findNumberByNameForUI(tfFindName.getText());
                    formatterText(tfFindName, "Name");
                }
                if (!tfFindId.getText().isEmpty() | !tfFindId.getText().equals("ID")){
                    try {
                        guideEmployee.findEmployeeByID(Integer.parseInt(tfFindId.getText()));
                    }
                    catch (NumberFormatException ignored) {
                    }
                    formatterText(tfFindId, "ID");
                }
                if (!tfFindExperience.getText().isEmpty() | !tfFindExperience.getText().equals("Experience")){
                    try {
                        guideEmployee.findEmployeeByExperience(Integer.parseInt(tfFindExperience.getText()));
                    }
                    catch (NumberFormatException ignored) {
                    }
                    formatterText(tfFindExperience, "Experience");
                }
            }
        });
        add(headerPanel, BorderLayout.SOUTH);
        add(btnRefresh, BorderLayout.NORTH);
        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guideEmployee.getList();
            }
        });
        log = new JTextArea();
        log.setFont(new Font("Arial", Font.ITALIC, 16));
        log.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(log);
        add(scrollPane);

    }

    private void Prompt(JTextField textField, String text){
        textField.setForeground(Color.GRAY);
        textField.setFont(new Font("Arial", Font.ITALIC, 12));
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(text)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                    textField.setFont(new Font("Arial", Font.PLAIN, 12));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(text);
                    textField.setForeground(Color.GRAY);
                    textField.setFont(new Font("Arial", Font.ITALIC, 12));
                }
            }
        });
    }

    private void addEmployee(){
        JFrame frame = new JFrame();
        frame.setSize(400, 80);
        JPanel panel = new JPanel(new GridLayout(1, 4));
        Prompt(tfName, "Name");
        Prompt(tfExperience, "Experience");
        Prompt(tfNumber, "NumberPhone");
        panel.add(tfName);
        panel.add(tfNumber);
        panel.add(tfExperience);
        panel.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    guideEmployee.addEmployee(tfName.getText(), Integer.parseInt(tfNumber.getText())
                            , Integer.parseInt(tfExperience.getText()));
                }
                catch (NumberFormatException ignored) {
                }
                if( (!tfName.getText().equals("Name") & !tfName.getText().isEmpty())
                & (!tfNumber.getText().isEmpty() & !tfNumber.getText().equals("NumberPhone"))
                & (!tfExperience.getText().isEmpty() & !tfExperience.getText().equals("Experience"))){
                    frame.dispose();
                }
                formatterText(tfName, "Name");
                formatterText(tfExperience, "Experience");
                formatterText(tfNumber, "NumberPhone");

            }
        });
        frame.add(panel);
        frame.setTitle("Add employee");
        frame.setResizable(false);
        frame.setVisible(true);
    }
    public void formatterText(JTextField jTextField, String text){
        jTextField.setText(text);
        jTextField.setForeground(Color.GRAY);
        jTextField.setFont(new Font("Arial", Font.ITALIC, 12));
    }
    public void setGuideEmployee(GuideEmployee guideEmployee) {
        this.guideEmployee = guideEmployee;
    }
}
