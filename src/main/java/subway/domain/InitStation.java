package subway.domain;

public enum InitStation {
    GYODAE("교대역"),
    GANGNAM("강남역"),
    YEOKSAM("역삼역"),
    SOUTH_TERMINAL("남부터미널역"),
    YANGJAE("양재역"),
    YANGJAE_FOREST("양재시민의숲역"),
    MAEBONG("매봉역");

    private static final String STATION_NAME_ERROR = "등록되지 않은 역입니다. 다시 입력해 주세요.";

    private final String name;
    private final Station station;

    InitStation(String name) {
        this.name = name;
        this.station = new Station(name);
    }

    public String getName() {
        return name;
    }

    public Station getStation() {
        return station;
    }

    public static InitStation findByName(String name) {
        for (InitStation station : InitStation.values()) {
            if (station.getName().equals(name)) {
                return station;
            }
        }
        throw new IllegalArgumentException(STATION_NAME_ERROR);
    }
}
