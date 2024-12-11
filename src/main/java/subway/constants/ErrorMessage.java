package subway.constants;

public enum ErrorMessage {
    INVALID_INPUT_STATION("출발역과 도착역이 동일합니다."),
    INVALID_INPUT_SELECTION("잘못된 선택입니다.")
    ;


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
