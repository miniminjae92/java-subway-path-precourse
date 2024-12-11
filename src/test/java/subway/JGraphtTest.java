package subway;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.junit.jupiter.api.Test;

import java.util.List;
import subway.domain.InitStation;
import subway.domain.PathFinder;
import subway.domain.Station;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JGraphtTest {
    @Test
    public void getDijkstraShortestPath() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        graph.addVertex("v1");
        graph.addVertex("v2");
        graph.addVertex("v3");
        graph.setEdgeWeight(graph.addEdge("v1", "v2"), 2);
        graph.setEdgeWeight(graph.addEdge("v2", "v3"), 2);
        graph.setEdgeWeight(graph.addEdge("v1", "v3"), 100);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath("v3", "v1").getVertexList();

        assertThat(shortestPath.size()).isEqualTo(3);
    }

    @Test
    public void
    testFindByName() {
        String inputName = "교대역";

        // findByName으로 InitStation 가져오기
        InitStation foundStation = InitStation.findByName(inputName);

        // 가져온 Station과 Enum 내부 Station 비교
        Station stationFromEnum = foundStation.getStation();
        Station expectedStation = InitStation.GYODAE.getStation();

        // 참조 비교
        assertSame(expectedStation, stationFromEnum, "Station 객체 참조가 동일해야 합니다.");

        // equals 비교
        assertEquals(expectedStation, stationFromEnum, "Station 객체는 동등해야 합니다.");

        // hashCode 비교
        assertEquals(expectedStation.hashCode(), stationFromEnum.hashCode(), "hashCode는 동일해야 합니다.");
    }

    @Test
    public void testFindShortestPath() {
        Station source = InitStation.GYODAE.getStation();
        Station target = InitStation.GANGNAM.getStation();

        PathFinder pathFinder = new PathFinder();
        List<Station> shortestPath = pathFinder.findShortestPath(source, target);

        assertNotNull(shortestPath);
        assertTrue(shortestPath.contains(source));
        assertTrue(shortestPath.contains(target));
    }

}
