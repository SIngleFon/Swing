package Client_Server.Server.UI;
import Client_Server.Server.Controller.ServerController;
public interface ServerView {
    void showMessage(String message);
    void setServerController(ServerController serverController);
}
