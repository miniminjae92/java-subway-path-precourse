package subway.domain;

public enum InitLine {
    LINE_SECOND("2호선"),
    LINE_THIRD("3호선"),
    LINE_SINBOONDANG("신분당선");

    private final String name;

    InitLine(String line) {
        this.name = line;
    }

    public String getName() {
        return name;
    }

}
