package src.mes_server.server;

import org.springframework.stereotype.Service;
import src.mes_server.dao.MaterialMapper;
import src.mes_server.pojo.Material;
import src.mes_server.utils.ResultUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class MaterialServerImpl {
    @Resource
    private MaterialMapper mapper;

    public String add(Material material) {
        int insert = mapper.insert(material);
        return ResultUtil.returnString(1, insert);
    }

    public Material select(int id) {
        Material equipment = mapper.selectById(id);
        return equipment;
    }

    public List<Material> select(List ids) {
        List list = mapper.selectBatchIds(ids);
        return list;
    }

    public List select(Map map) {
        return mapper.selectByMap(map);
    }

    public String updateById(Material equipment) {
        int i = mapper.updateById(equipment);
        return ResultUtil.returnString(1, i);
    }

    public String delete(int id) {
        return ResultUtil.returnString(1, mapper.deleteById(id));
    }

    public String delete(Map map) {
        return ResultUtil.returnString(mapper.deleteByMap(map));
    }

}
