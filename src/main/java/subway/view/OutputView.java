package subway.view;

import subway.constants.GeneralMessage;
import subway.domain.PathResult;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    public static final String INFO_LINE = "---";
    private static final String INFO_PREFIX = "[INFO] ";
    public static final String INFO_TOTAL_DISTANCE = "총 거리:  %dkm";
    public static final String INFO_TOTAL_TIME = "총 소요 시간:  %d분";

    public static void printMessage(GeneralMessage message, Object...args) {
        System.out.printf(message + "%n", args);
    }

    public static void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printResult(PathResult result) {
        System.out.println(INFO_PREFIX + INFO_LINE);
        System.out.println(INFO_PREFIX + String.format(INFO_TOTAL_DISTANCE, result.getTotalDistance()));
        System.out.println(INFO_PREFIX + String.format(INFO_TOTAL_TIME, result.getTotalTime()));
        System.out.println(INFO_PREFIX + INFO_LINE);
        result.getStations().forEach(station ->
                System.out.println(INFO_PREFIX + station.getName()));
        printNewLine();
    }
}
