package subway;

import subway.controller.Controller;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();

//        initRepository();

        controller.runMain();
    }

//    private static void initRepository() {
//        for (InitStation initStation : InitStation.values()) {
//            StationRepository.addStation(new Station(initStation.getName()));
//        }
//
//        for (InitLine initLine : InitLine.values()) {
//            LineRepository.addLine(new Line(initLine.getName()));
//        }
//    }
}


