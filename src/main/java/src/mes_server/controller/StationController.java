package src.mes_server.controller;

import org.springframework.web.bind.annotation.*;
import src.mes_server.pojo.Station;
import src.mes_server.result.ResultEnum;
import src.mes_server.server.StationServerImpl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController("/STA")
public class StationController {
    @Resource
    private StationServerImpl server;

    @PostMapping("/addSTA")
    public ResultEnum addStation(@RequestBody Station station) {
        return server.add(station);
    }

    @GetMapping("/selectSTA")
    public Station select(@RequestParam("id") int id) {
        System.out.println(id);
        Station select = server.select(id);
        System.out.println(select);
        return select;
    }

    @PostMapping("/selectSTAL")
    public List<Station> selectList(@RequestBody List ids) {
        List<Station> select = server.select(ids);
        return select;
    }

    @PostMapping("/selectSTAM")
    public List<Station> selectList(@RequestBody Map map) {
        List<Station> select = server.select(map);
        return select;
    }

    @PostMapping("/updateSTA")
    public ResultEnum update(@RequestBody Station station) {
        return server.updateById(station);
    }

    @GetMapping("/deleteSTA")
    public ResultEnum delete(@RequestParam("id") int id) {
        return server.delete(id);
    }

    @PostMapping("/deleteSTAM")
    public ResultEnum delete(@RequestBody Map map) {
        return server.delete(map);
    }
}
