import java.util.List;
public interface IFlightsManager {

    List<String> readFile(String filePath);
    void writeFile(String filePath, List<String> fileContent);

}
