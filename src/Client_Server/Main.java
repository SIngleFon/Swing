package Client_Server;

import Client_Server.Client.UI.ClientUI;
import Client_Server.Server.Log.FileLogger;
import Client_Server.Server.UI.ServerUI;
import Client_Server.Server.Controller.ServerController;
import Client_Server.Client.Controller.ClientController;

public class Main {
    public static void main(String[] args) {
        ServerController serverController = new ServerController(new ServerUI(), new FileLogger());
        new ClientController(new ClientUI(), serverController);
        new ClientController(new ClientUI(), serverController);
    }
}