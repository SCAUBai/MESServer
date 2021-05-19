package src.mes_server.server;

import org.springframework.stereotype.Service;
import src.mes_server.dao.StationCapacityMapper;
import src.mes_server.dao.StationMapper;
import src.mes_server.pojo.Station;
import src.mes_server.pojo.StationCapacity;
import src.mes_server.result.BaseResult;
import src.mes_server.result.ResultEnum;
import src.mes_server.utils.ResultUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class StationServerImpl {
    @Resource
    private StationMapper mapper;

    public ResultEnum add(Station station) {
        int insert = mapper.insert(station);
        return ResultUtil.returnString(1, insert, BaseResult.INSERT.name());
    }

    public Station select(int id) {
        Station station = mapper.selectById(id);
        return station;
    }

    public List<Station> select(List<Integer> ids) {
        List list = mapper.selectBatchIds(ids);
        return list;
    }

    public List<Station> select(Map map) {
        return mapper.selectByMap(map);
    }

    public ResultEnum updateById(Station station) {
        int i = mapper.updateById(station);
        return ResultUtil.returnString(1, i, BaseResult.UPDATE.name());
    }

    public ResultEnum delete(int id) {
        return ResultUtil.returnString(1, mapper.deleteById(id), BaseResult.DELETE.name());
    }

    public ResultEnum delete(Map map) {
        return ResultUtil.returnString(mapper.deleteByMap(map), BaseResult.DELETE.name());
    }

}
