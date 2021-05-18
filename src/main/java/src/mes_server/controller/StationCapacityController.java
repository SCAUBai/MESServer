package src.mes_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import src.mes_server.pojo.StationCapacity;
import src.mes_server.server.StationCapacityServerImpl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class StationCapacityController {
    @Resource
    private StationCapacityServerImpl server;

    @GetMapping("/addSC")
    public void addStationCapacity() {
        StationCapacity station = new StationCapacity();
        server.add(station);
    }

    @GetMapping("/selectSC")
    public StationCapacity select(@RequestParam int id) {
        System.out.println(id);
        StationCapacity select = server.select(id);
        System.out.println(select);
        return select;
    }

    @GetMapping("/selectSCL")
    public List<StationCapacity> selectList(@RequestParam List ids) {
        List<StationCapacity> select = server.select(ids);
        return select;
    }

    @GetMapping("/selectSCM")
    public List<StationCapacity> selectList(@RequestParam Map map) {
        List<StationCapacity> select = server.select(map);
        return select;
    }

    @GetMapping("/updateSC")
    public String update(@RequestParam StationCapacity station) {
        return server.updateById(station);
    }

    @GetMapping("/deleteSC")
    public String delete(@RequestParam int id) {
        return server.delete(id);
    }

    @GetMapping("/deleteSCM")
    public String delete(@RequestParam Map map) {
        return server.delete(map);
    }
}
