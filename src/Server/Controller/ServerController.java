package Server.Controller;

import java.util.ArrayList;
import java.util.List;
import Client.Controller.ClientController;
import Server.Log.Logger;
import Server.UI.ServerView;

public class ServerController {
    private boolean work;
    private ServerView serverView;
    private List<ClientController> clientControllerList;
    private Logger<String> logger;

    public ServerController(ServerView serverView, Logger<String> logger) {
        this.serverView = serverView;
        this.logger = logger;
        clientControllerList = new ArrayList<>();
        serverView.setServerController(this);
    }
    public String getLog() {
        return logger.readLog();
    }
    public void start(){
        if (work){
            showOnWindow("Сервер уже был запущен");
        } else {
            work = true;
            showOnWindow("Сервер запущен!");
        }
    }

    public void stop(){
        if (!work){
            showOnWindow("Сервер уже был остановлен");
        } else {
            work = false;
            while (!clientControllerList.isEmpty()){
                disconnectUser(clientControllerList.get(clientControllerList.size() - 1));
            }
            showOnWindow("Сервер остановлен!");
        }
    }

    public void disconnectUser(ClientController clientController){
        clientControllerList.remove(clientController);
        if (clientController != null){
            clientController.disconnectFromServer();
            showOnWindow(clientController.getName() + " отключился от беседы");
        }
    }

    public boolean connectUser(ClientController clientController){
        if (!work){
            return false;
        }
        clientControllerList.add(clientController);
        showOnWindow(clientController.getName() + " подключился к беседе");
        return true;
    }

    public void message(String text){
        if (!work){
            return;
        }
        showOnWindow(text);
        answerAll(text);
        saveInHistory(text);
    }

    private void answerAll(String text){
        for (ClientController clientController : clientControllerList){
            clientController.answerFromServer(text);
        }
    }
    private void showOnWindow(String text){
        serverView.showMessage(text + "\n");
    }

    private void saveInHistory(String text){
        logger.appendLog(text);
    }
}
