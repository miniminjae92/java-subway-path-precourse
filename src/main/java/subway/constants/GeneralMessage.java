package subway.constants;

public enum GeneralMessage {
    REQUEST_MAIN_MENU("## 메인 화면%n"
            + "1. 경로 조회%n"
            + "Q. 종료%n"
            + "%n"
            + "## 원하는 기능을 선택하세요."),
    REQUEST_PATH_MENU("## 경로 기준%n"
            + "1. 최단 거리%n"
            + "2. 최소 시간 %n"
            + "B. 돌아가기%n"
            + "%n"
            + "## 원하는 기능을 선택하세요."),
    REQUEST_DEPARTURE_STATION("## 출발역을 입력하세요."),
    REQUEST_DESTINATION_STATION("## 도착역을 입력하세요."),
    PATH_CHECK("1"),
    QUIT("Q"),
    ;

    private final String message;

    GeneralMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
