package src.mes_server.server;

import org.springframework.stereotype.Service;
import src.mes_server.dao.ProcessMapper;
import src.mes_server.pojo.Process;
import src.mes_server.utils.ResultUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ProcessServerImpl {
    @Resource
    private ProcessMapper mapper;

    public String add(Process process) {
        int insert = mapper.insert(process);
        return ResultUtil.returnString(1, insert);
    }

    public Process select(int id) {
        Process process = mapper.selectById(id);
        return process;
    }

    public List<Process> select(List ids) {
        List list = mapper.selectBatchIds(ids);
        return list;
    }

    public List select(Map map) {
        return mapper.selectByMap(map);
    }

    public String updateById(Process process) {
        int i = mapper.updateById(process);
        return ResultUtil.returnString(1, i);
    }

    public String delete(int id) {
        return ResultUtil.returnString(1, mapper.deleteById(id));
    }

    public String delete(Map map) {
        return ResultUtil.returnString(mapper.deleteByMap(map));
    }

}
