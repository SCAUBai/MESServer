package src.mes_server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipment {
    @TableId("equipment_id")
    private int equipmentId;
    @TableField("e_name")
    private String eName;
    @TableField("e_type")
    private String eType;
}

