package subway.domain;

import java.util.Arrays;
import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class PathFinder {
    private final WeightedMultigraph<Station, DefaultWeightedEdge> graph;

    public PathFinder() {
        this.graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
    }

    public List<Station> findShortestPath(Station source, Station target) {
        addGraphToStation();
        addEdgeAndWeight();
        return calculateShortestPath(source, target);
    }

    private void addGraphToStation() {
//        StationRepository.stations().forEach(graph::addVertex);
        Arrays.stream(InitStation.values()).forEach(station -> graph.addVertex(station.getStation()));
    }

    private void addEdgeAndWeight() {
        for (InitPath path : InitPath.values()) {
            DefaultWeightedEdge edge = graph.addEdge(path.getDeparture(), path.getDestination());
            graph.setEdgeWeight(edge, path.getDistance());
        }
    }

    private List<Station> calculateShortestPath(Station source, Station target) {
        DijkstraShortestPath<Station, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(graph);
        return dijkstra.getPath(source, target).getVertexList();
    }
}
