package subway.domain;

import java.util.Objects;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // 동일 객체인 경우
        if (o == null || getClass() != o.getClass()) return false; // 클래스가 다른 경우
        Station station = (Station) o;
        return Objects.equals(name, station.name); // 이름을 기준으로 비교
    }

    @Override
    public int hashCode() {
        return Objects.hash(name); // 이름의 해시값 생성
    }
}
