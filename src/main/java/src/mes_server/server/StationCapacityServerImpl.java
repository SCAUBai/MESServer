package src.mes_server.server;

import org.springframework.stereotype.Service;
import src.mes_server.dao.StaffMapper;
import src.mes_server.dao.StationCapacityMapper;
import src.mes_server.pojo.Staff;
import src.mes_server.pojo.StationCapacity;
import src.mes_server.result.BaseResult;
import src.mes_server.result.ResultEnum;
import src.mes_server.utils.ResultUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class StationCapacityServerImpl {
    @Resource
    private StationCapacityMapper mapper;

    public ResultEnum add(StationCapacity stationCapacity) {
        int insert = mapper.insert(stationCapacity);
        return ResultUtil.returnString(1, insert, BaseResult.INSERT.name());
    }

    public StationCapacity select(int id) {
        StationCapacity stationCapacity = mapper.selectById(id);
        return stationCapacity;
    }

    public List<StationCapacity> select(List<Integer> ids) {
        List list = mapper.selectBatchIds(ids);
        return list;
    }

    public List<StationCapacity> select(Map map) {
        return mapper.selectByMap(map);
    }

    public ResultEnum updateById(StationCapacity stationCapacity) {
        int i = mapper.updateById(stationCapacity);
        return ResultUtil.returnString(1, i, BaseResult.UPDATE.name());
    }

    public ResultEnum delete(int id) {
        return ResultUtil.returnString(1, mapper.deleteById(id), BaseResult.DELETE.name());
    }

    public ResultEnum delete(Map map) {
        return ResultUtil.returnString(mapper.deleteByMap(map), BaseResult.DELETE.name());
    }

}
