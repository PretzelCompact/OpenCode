import java.io.BufferedReader;
import java.io.IOException;

public interface ITask {
    void execute(BufferedReader br) throws IOException;
}
