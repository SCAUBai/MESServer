package src.mes_server.controller;

import org.springframework.web.bind.annotation.*;
import src.mes_server.pojo.StationCapacity;
import src.mes_server.server.StationCapacityServerImpl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController("SC")
public class StationCapacityController {
    @Resource
    private StationCapacityServerImpl server;

    @PostMapping("/addSC")
    public void addStationCapacity(@RequestBody StationCapacity station) {
        server.add(station);
    }

    @GetMapping("/selectSC")
    public StationCapacity select(@RequestParam("id") int id) {
        System.out.println(id);
        StationCapacity select = server.select(id);
        System.out.println(select);
        return select;
    }

    @PostMapping("/selectSCL")
    public List<StationCapacity> selectList(@RequestBody List ids) {
        List<StationCapacity> select = server.select(ids);
        return select;
    }

    @PostMapping("/selectSCM")
    public List<StationCapacity> selectList(@RequestParam Map map) {
        List<StationCapacity> select = server.select(map);
        return select;
    }

    @PostMapping("/updateSC")
    public String update(@RequestParam StationCapacity station) {
        return server.updateById(station);
    }

    @GetMapping("/deleteSC")
    public String delete(@RequestParam int id) {
        return server.delete(id);
    }

    @PostMapping("/deleteSCM")
    public String delete(@RequestParam Map map) {
        return server.delete(map);
    }
}
