package src.mes_server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Staff {
    @TableId("staff_id")
    private int id;
    @TableField("staff_name")
    private String name;
    private String passwd;
    private String works;
    private int permissions;
}
