package src.mes_server.server;

import org.springframework.stereotype.Service;
import src.mes_server.dao.RulesMapper;
import src.mes_server.dao.StaffMapper;
import src.mes_server.pojo.Rules;
import src.mes_server.pojo.Staff;
import src.mes_server.utils.ResultUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class StaffServerImpl {
    @Resource
    private StaffMapper mapper;

    public String add(Staff staff) {
        int insert = mapper.insert(staff);
        return ResultUtil.returnString(1, insert);
    }

    public Staff select(int id) {
        Staff staff = mapper.selectById(id);
        return staff;
    }

    public List<Staff> select(List<Integer> ids) {
        List list = mapper.selectBatchIds(ids);
        return list;
    }

    public List<Staff> select(Map map) {
        return mapper.selectByMap(map);
    }

    public String updateById(Staff staff) {
        int i = mapper.updateById(staff);
        return ResultUtil.returnString(1, i);
    }

    public String delete(int id) {
        return ResultUtil.returnString(1, mapper.deleteById(id));
    }

    public String delete(Map map) {
        return ResultUtil.returnString(mapper.deleteByMap(map));
    }

}
