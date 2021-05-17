package src.mes_server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Rules {
//    @TableId("")
//    private int id;
    @TableField("station_id")
    private int station_id;
    @TableField("process_id")
    private int process_id;
}
