package src.mes_server.server;

import org.springframework.stereotype.Service;
import src.mes_server.dao.RulesMapper;
import src.mes_server.pojo.Production;
import src.mes_server.pojo.Rules;
import src.mes_server.utils.ResultUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class RulesServerImpl {
    @Resource
    private RulesMapper mapper;

    public String add(Rules rules) {
        int insert = mapper.insert(rules);
        return ResultUtil.returnString(1, insert);
    }

    public Rules select(int id) {
        Rules rules = mapper.selectById(id);
        return rules;
    }

    public List<Rules> select(List<Integer> ids) {
        List list = mapper.selectBatchIds(ids);
        return list;
    }

    public List<Rules> select(Map map) {
        return mapper.selectByMap(map);
    }

    public String updateById(Rules rules) {
        int i = mapper.updateById(rules);
        return ResultUtil.returnString(1, i);
    }

    public String delete(int id) {
        return ResultUtil.returnString(1, mapper.deleteById(id));
    }

    public String delete(Map map) {
        return ResultUtil.returnString(mapper.deleteByMap(map));
    }

}
