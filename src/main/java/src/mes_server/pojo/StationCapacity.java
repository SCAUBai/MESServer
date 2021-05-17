package src.mes_server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class StationCapacity {
    @TableId("station_id")
    private int stationId;
    @TableField("staff_id")
    private int staffId;
    @TableField("equipment_id")
    private int equipmentId;
}
