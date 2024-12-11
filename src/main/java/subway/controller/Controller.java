package subway.controller;

import static subway.constants.GeneralMessage.*;

import java.util.List;
import java.util.stream.IntStream;
import subway.constants.GeneralMessage;
import subway.domain.InitPath;
import subway.domain.InitStation;
import subway.domain.PathFinder;
import subway.domain.PathResult;
import subway.domain.Station;
import subway.util.Repeat;
import subway.view.InputView;
import subway.view.OutputView;

public class Controller {

    public void runMain() {
        while (true) {
            String mainCommand = Repeat.repeat(this::askMainMenu);

            if (mainCommand.equals("1")) {
                Repeat.repeat(this::runPath);
            }
            if (mainCommand.equals("Q")) {
                break;
            }
        }
    }

    private void runPath() {
        String pathCommand = Repeat.repeat(this::askPathMenu);
//  validatePathMenu 메소드에서 1, 2, B 만 반환하도록 하는 장치때문에 루프를 빠져나갈 수 있음
//        if(pathCommand.equals("B")) {
//            return;
//        }
        if (pathCommand.equals("1") || pathCommand.equals("2")) {
            shortestResult();
        }
    }

    private String askMainMenu() {
        OutputView.printMessage(GeneralMessage.REQUEST_MAIN_MENU);
        return validateMainMenu(InputView.readInput());
    }

    private String askPathMenu() {
        OutputView.printMessage(REQUEST_PATH_MENU);
        return validatePathMenu(InputView.readInput());
    }

    private String validateMainMenu(String userInput) {
        if (userInput == null || userInput.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (!userInput.equals("Q") && !userInput.equals("1")) {
            throw new IllegalArgumentException();
        }

        return userInput;
    }

    private String validatePathMenu(String userInput) {
        if (userInput == null || userInput.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("B")) {
            throw new IllegalArgumentException();
        }

        return userInput;
    }

    private void shortestResult() {
        InitStation departure = InitStation.findByName(InputView.readInputWithMessage(REQUEST_DEPARTURE_STATION));
        InitStation destination = InitStation.findByName(InputView.readInputWithMessage(REQUEST_DESTINATION_STATION));
        if (departure.getName().equals(destination.getName())) {
            throw new IllegalArgumentException("출발역과 도착역이 동일합니다.");
        }
        PathFinder pathFinder = new PathFinder();
        List<Station> shortestPath = pathFinder.findShortestPath(departure.getStation(), destination.getStation());
        int[] result = sumDistanceAndTime(shortestPath);

        PathResult pathResult = new PathResult(result[0], result[1], shortestPath);

        OutputView.printResult(pathResult);
    }

    private int[] sumDistanceAndTime(List<Station> stations) {
        int[] result = new int[2];

        IntStream.range(0, stations.size() - 1)
                .mapToObj(i -> InitPath.findPath(stations.get(i).getName(), stations.get(i + 1).getName()))
                .forEach(path -> {
                    result[0] += path.getDistance();
                    result[1] += path.getMinutes();
                });

        return result;
    }
 }

