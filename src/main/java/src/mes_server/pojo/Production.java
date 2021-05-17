package src.mes_server.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Production {
    @TableId("production_id")
    private int id;
    private String allprocess;
    private String materials;
}
