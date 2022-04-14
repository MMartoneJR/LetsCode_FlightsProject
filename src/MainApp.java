import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp {
    public static void main(String[] args) throws IOException {

        // Leitura do arquivo CSV
        FlightsFileManager flightManager = new FlightsFileManager();
        List<String> flightsFile = flightManager.readFile("flights.csv");

        // Objeto FlightInfoManager, já ordenando os items da lista por tempo de vôo do menor ao maior
        List<FlightsInfoManager> flightList = flightsFile.stream()
                .skip(1)
                .map(line -> line.split(";"))
                .map(item -> new FlightsInfoManager(item[0], item[1], item[2], item[3], item[4], item[5]))
                .sorted(Comparator.comparing(FlightsInfoManager::getFlightTime)
                        .thenComparing(FlightsInfoManager::getPrice)
                        .thenComparing(FlightsInfoManager::getAirline))
                .collect(Collectors.toList());


        // Escrita do arquivo com tempo de vôo - Ordenando do menor ao maior
        List<String> flightTime = new ArrayList<>();
        flightTime.add("origin;destination;airline;departure;arrival;price;flight time");
        //flightTime.add(FlightsInfoManager.getFlightTimeLines(flightList));
        for (FlightsInfoManager flightInfo : new ArrayList<>(flightList)){
            flightTime.add(FlightsInfoManager.getFlightTimeLines(flightInfo));
        }
        flightManager.writeFile("flights_with_time_column.csv", flightTime);


    }
}