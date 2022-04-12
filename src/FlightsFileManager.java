import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FlightsFileManager implements IFlightsManager {

    @Override
    public List<String>readFile(String filePath){
        Path path = Path.of(filePath);

        try{
            return Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("IOException");
            return null;
        }
    }

    @Override
    public void writeFile(String filePath, List<String> fileContent) {
        Path path = Paths.get(String.valueOf(filePath));

        try{
            Files.write(path, fileContent);
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
