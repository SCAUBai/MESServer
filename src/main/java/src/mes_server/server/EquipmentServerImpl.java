package src.mes_server.server;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import src.mes_server.dao.EquipmentMapper;
import src.mes_server.pojo.Equipment;
import src.mes_server.utils.ResultUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class EquipmentServerImpl {
    @Resource
    private EquipmentMapper equipmentMapper;

    public String add(Equipment equipment) {
        int insert = equipmentMapper.insert(equipment);
        return ResultUtil.returnString(1, insert);
    }

    public Equipment select(int id) {
        Equipment equipment = equipmentMapper.selectById(id);
//        System.out.println("Server:"+equipment);
        return equipment;
    }

    public List<Equipment> select(List ids) {
        List list = equipmentMapper.selectBatchIds(ids);
        return list;
    }

    public List<Equipment> select(Map map) {
        return equipmentMapper.selectByMap(map);
    }

    public String updateById(Equipment equipment) {
        int i = equipmentMapper.updateById(equipment);
        return ResultUtil.returnString(1, i);
    }

    public String delete(int id) {
        return ResultUtil.returnString(1, equipmentMapper.deleteById(id));
    }

    public String delete(Map map) {
        return ResultUtil.returnString(equipmentMapper.deleteByMap(map));
    }

}
