package Client_Server.Client.Controller;

import Client_Server.Client.UI.ClientUI;
import Client_Server.Server.Controller.ServerController;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientController {
    private final ClientUI view;
    private  ServerController server;
    private boolean connected;
    private String name;
    private static final DateFormat formatter = new SimpleDateFormat("hh:mm:ss");

    public ClientController(ClientUI clientUI, ServerController server){
        this.server = server;
        this.view = clientUI;
        view.setClientController(this);
    }
    
    public String getName(){
        return name;
    }
    public boolean connectToServer(String name) {
        this.name = name;
        if (server.connectUser(this)){
            view.appendLog("Успешное подключение к серверу!\n");
            connected = true;
            String log = server.getLog();
            if (log != null){
                view.appendLog(log);
            }
            return true;
        } else {
            view.appendLog("Нет подключения к серверу");
            return false;
        }
    }
    private void showOnWindow(String text) {
        view.showMessage(text + "\n");
    }
    public void disconnectFromServer() {
        if (connected) {
            connected = false;
            view.disconnectedFromServer();
            view.appendLog("Вы были отключены от сервера!");
        }
    }

    public void message(String text){
        if (connected){

            if (!text.isEmpty()){
                server.message(formatter.format(new Date()) + " " + name + ": " + text);
            }
        } else {
            view.appendLog("Нет ответа от сервера");
        }

    }
    public void answerFromServer(String text) {
        showOnWindow(text);
    }
}
