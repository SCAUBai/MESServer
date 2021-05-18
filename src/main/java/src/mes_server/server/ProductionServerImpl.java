package src.mes_server.server;

import org.springframework.stereotype.Service;
import src.mes_server.dao.ProductionMapper;
import src.mes_server.pojo.Production;
import src.mes_server.utils.ResultUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ProductionServerImpl {
    @Resource
    private ProductionMapper mapper;

    public String add(Production production) {
        int insert = mapper.insert(production);
        return ResultUtil.returnString(1, insert);
    }

    public Production select(int id) {
        Production production = mapper.selectById(id);
        return production;
    }

    public List select(List<Integer> ids) {
        List list = mapper.selectBatchIds(ids);
        return list;
    }

    public List<Production> select(Map map) {
        return mapper.selectByMap(map);
    }

    public String updateById(Production production) {
        int i = mapper.updateById(production);
        return ResultUtil.returnString(1, i);
    }

    public String delete(int id) {
        return ResultUtil.returnString(1, mapper.deleteById(id));
    }

    public String delete(Map map) {
        return ResultUtil.returnString(mapper.deleteByMap(map));
    }

}
