package src.mes_server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Material {
    @TableId("material_id")
    private int id;
    @TableField("material_name")
    private String name;
    private String describe;
    private double price;
}
