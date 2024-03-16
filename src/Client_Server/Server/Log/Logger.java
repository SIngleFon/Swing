package Client_Server.Server.Log;

public interface Logger<T> {
    void appendLog(T text);
    T readLog();
}
