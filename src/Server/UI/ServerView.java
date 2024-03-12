package Server.UI;
import Server.Controller.ServerController;
public interface ServerView {
    void showMessage(String message);
    void setServerController(ServerController serverController);
}
