package src.mes_server.server;

import org.springframework.stereotype.Service;
import src.mes_server.dao.MaterialMapper;
import src.mes_server.pojo.Material;
import src.mes_server.result.BaseResult;
import src.mes_server.result.ResultEnum;
import src.mes_server.utils.ResultUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class MaterialServerImpl {
    @Resource
    private MaterialMapper mapper;

    public ResultEnum add(Material material) {
        int insert = mapper.insert(material);
        return ResultUtil.returnString(1, insert, BaseResult.INSERT.name());
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

    public ResultEnum updateById(Material equipment) {
        int i = mapper.updateById(equipment);
        return ResultUtil.returnString(1, i, BaseResult.UPDATE.name());
    }

    public ResultEnum delete(int id) {
        return ResultUtil.returnString(1, mapper.deleteById(id), BaseResult.DELETE.name());
    }

    public ResultEnum delete(Map map) {
        return ResultUtil.returnString(mapper.deleteByMap(map), BaseResult.DELETE.name());
    }

}
