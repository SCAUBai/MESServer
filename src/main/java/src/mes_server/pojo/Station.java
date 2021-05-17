package src.mes_server.pojo;

import lombok.Data;

import lombok.ToString;

@Data
public class Station {
    private int id;
    private String name;
    private String status;
    private String type;
    private String place;

    public Station() {
    }

    public Station(int id, String name, String status, String type, String place) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.type = type;
        this.place = place;
    }
}
