import Client.UI.ClientUI;
import Server.Log.FileLogger;
import Server.UI.ServerUI;
import Server.Controller.ServerController;
import Client.Controller.ClientController;

public class Main {
    public static void main(String[] args) {
        ServerController serverController = new ServerController(new ServerUI(), new FileLogger());
        new ClientController(new ClientUI(), serverController);
        new ClientController(new ClientUI(), serverController);
    }
}