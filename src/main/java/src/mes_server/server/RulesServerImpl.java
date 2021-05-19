package src.mes_server.server;

import org.springframework.stereotype.Service;
import src.mes_server.dao.RulesMapper;
import src.mes_server.pojo.Production;
import src.mes_server.pojo.Rules;
import src.mes_server.result.BaseResult;
import src.mes_server.result.ResultEnum;
import src.mes_server.utils.ResultUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class RulesServerImpl {
    @Resource
    private RulesMapper mapper;

    public ResultEnum add(Rules rules) {
        int insert = mapper.insert(rules);
        return ResultUtil.returnString(1, insert, BaseResult.DELETE.name());
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

    public ResultEnum updateById(Rules rules) {
        int i = mapper.updateById(rules);
        return ResultUtil.returnString(1, i, BaseResult.UPDATE.name());
    }

    public ResultEnum delete(int id) {
        return ResultUtil.returnString(1, mapper.deleteById(id), BaseResult.DELETE.name());
    }

    public ResultEnum delete(Map map) {
        return ResultUtil.returnString(mapper.deleteByMap(map), BaseResult.DELETE.name());
    }

}
