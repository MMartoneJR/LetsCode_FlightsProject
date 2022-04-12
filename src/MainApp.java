import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class MainApp {
    public static void main(String[] args) throws IOException {

        // Leitura do arquivo CSV
        FlightsFileManager flightManager = new FlightsFileManager();
        List<String> flightsFile = flightManager.readFile("flights.csv");

        // Remoção do cabeçalho original do arquivo
        List<String[]>flightsListHeaderless = flightsFile.stream()
                .skip(1)
                .map(line -> line.split(";"))
                .collect(Collectors.toList());


        // Objeto FlightInfoManager
        List<FlightsInfoManager> flightList = new ArrayList<>();
        for (String[] flightInfo : flightsListHeaderless){
            flightList.add(new FlightsInfoManager(
                    flightInfo[0],
                    flightInfo[1],
                    flightInfo[2],
                    flightInfo[3],
                    flightInfo[4],
                    flightInfo[5])
            );
        }

        // Escrita do arquivo com tempo de vôo - Do menor ao maior
        List<String> flightTime = new ArrayList<>();
        flightTime.add("origin;destination;airline;departure;arrival;price;flight time");
        for (FlightsInfoManager flightInfo : flightList.stream()
                .sorted(Comparator.comparing(FlightsInfoManager :: getFlightTime)
                                .thenComparing(FlightsInfoManager::getPrice)
                                .thenComparing(FlightsInfoManager::getAirline)
                        )
                .collect(Collectors.toList())){
            flightTime.add(FlightsInfoManager.getFlightTimeLines(flightInfo));
        }
        flightManager.writeFile("flights_with_time_column.csv", flightTime);


//        Teste de leitura do Objeto FlightInfoManager
        flightList.stream()
                .forEach(System.out :: println);


    }
}