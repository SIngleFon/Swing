package Client.UI;
import Client.Controller.ClientController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientUI extends JFrame implements ClientView {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;

    private ClientController controller;

    JTextArea log;
    JTextField tfLogin, tfMessage;
    JPasswordField password;
    JButton btnLogin, btnSend;
    JPanel headerPanel;

    public ClientUI(){
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat client");
        createPanel();
        setVisible(true);
        }
    public void appendLog(String text){
        log.append(text + "\n");
    }
    @Override
    public void disconnectedFromServer() {
        headerPanel.setVisible(true);
    }
    public void disconnectFromServer(){
        controller.disconnectFromServer();
    }
    private void createPanel() {
            headerPanel = new JPanel(new GridLayout(1, 1));
            tfLogin = new JTextField("Login");
            password = new JPasswordField("Password");
            btnLogin = new JButton("login");
            btnLogin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (controller.connectToServer(tfLogin.getText())) {
                        if (tfLogin.getText().equals("Login"))
                            setTitle("Chat Client");
                        else{
                            setTitle(tfLogin.getText());
                        }
                        headerPanel.setVisible(false);
                    }
                }
            });
            headerPanel.add(tfLogin);
            headerPanel.add(password);
            headerPanel.add(btnLogin);

            add(headerPanel, BorderLayout.NORTH);


            log = new JTextArea();
            log.setEditable(false);
            JScrollPane scrollPane =new JScrollPane(log);

            add(scrollPane);


            JPanel panel = new JPanel(new BorderLayout());
            tfMessage = new JTextField();
            tfMessage.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if (e.getKeyChar() == '\n'){
                        message();
                    }
                }
            });
            btnSend = new JButton("send");
            btnSend.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    message();
                }
            });
            panel.add(tfMessage);
            panel.add(btnSend, BorderLayout.EAST);

            add(panel, BorderLayout.SOUTH);
        }
        private void message(){
            controller.message(tfMessage.getText());
            tfMessage.setText("");
        }
        public void showMessage(String msg) {
            log.append(msg);
        }
        public void setClientController(ClientController clientController) {
                this.controller = clientController;
            }
        @Override
        protected void processWindowEvent(WindowEvent e) {
            super.processWindowEvent(e);
            if (e.getID() == WindowEvent.WINDOW_CLOSING){
                disconnectFromServer();
                }
            }
        }
