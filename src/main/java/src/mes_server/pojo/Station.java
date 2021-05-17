package src.mes_server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import lombok.ToString;

@Data
public class Station {
    @TableId("station_id")
    private int id;
    @TableField("station_name")
    private String name;
    private String status;
    @TableField("station_type")
    private String type;
    private String place;
}
