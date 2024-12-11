package subway.domain;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum InitPath {
    PATH_1("교대역", "강남역", 2, 3),
    PATH_2("교대역", "남부터미널역", 3, 2),
    PATH_3("강남역", "역삼역", 2, 3),
    PATH_4("남부터미널역", "양재역", 6, 5),
    PATH_5("양재역", "매봉역", 1, 1),
    PATH_6("강남역", "양재역", 2, 8),
    PATH_7("양재역", "양재시민의숲역", 10, 3);

    private final String departure;
    private final String destination;
    private final int distance;
    private final int minutes;

    InitPath(String departure, String destination, int distance, int minutes) {
        this.departure = departure;
        this.destination = destination;
        this.distance = distance;
        this.minutes = minutes;
    }

    public Station getDeparture() {
        return new Station(departure);
    }

    public Station getDestination() {
        return new Station(destination);
    }

    public int getDistance() {
        return distance;
    }

    public int getMinutes() {
        return minutes;
    }

    public List<InitPath> getInitPaths() {
        return Arrays.stream(values()).collect(Collectors.toList());
    }

    public static InitPath findPath(String departure, String destination) {
        for (InitPath initPath : values()) {
            if (initPath.getDeparture().getName().equals(departure) && initPath.getDestination().getName().equals(destination)) {
                return initPath;
            }
        }
        throw new IllegalArgumentException("해당 경로를 찾을 수 없습니다.");
    }
}
