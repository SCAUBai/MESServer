package src.mes_server.pojo;

import lombok.Data;

@Data
public class Staff {
    private int id;
    private String name;
    private String passwd;
    private String works;
    private int permissions;
}
