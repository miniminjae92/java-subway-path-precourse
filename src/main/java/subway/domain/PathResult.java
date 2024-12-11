package subway.domain;

import java.util.List;

public class PathResult {
    private final int totalDistance;
    private final int totalTime;
    private final List<Station> stations;

    public PathResult(int totalDistance, int totalTime, List<Station> stations) {
        this.totalDistance = totalDistance;
        this.totalTime = totalTime;
        this.stations = stations;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public List<Station> getStations() {
        return stations;
    }
}
