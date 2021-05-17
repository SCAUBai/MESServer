package src.mes_server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Process {
    @TableId("process_id")
    private int id;
    @TableField("p_name")
    private String name;
}
