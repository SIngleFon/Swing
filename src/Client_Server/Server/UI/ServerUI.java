package Client_Server.Server.UI;

import javax.swing.*;
import Client_Server.Server.Controller.ServerController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ServerUI extends JFrame implements ServerView {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 400;
    private ServerController serverController;
    JButton btnStart, btnStop;
    JTextArea log;
    public ServerUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);
        createPanel();
        setVisible(true);
    }
    @Override
    public void showMessage(String message) {
        log.append(message);
    }

    @Override
    public void setServerController(ServerController serverController) {
        this.serverController = serverController;
    }

    private void createPanel() {
        log = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(log);

        add(scrollPane);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverController.start();
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverController.stop();
            }
        });
        panel.add(btnStart);
        panel.add(btnStop);
        add(panel, BorderLayout.SOUTH);
    }
}


