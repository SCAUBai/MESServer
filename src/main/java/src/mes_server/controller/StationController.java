package src.mes_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import src.mes_server.pojo.Station;
import src.mes_server.server.StationServerImpl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class StationController {
    @Resource
    private StationServerImpl server;

    @GetMapping("/addSTA")
    public void addStation() {
        Station station = new Station();
        server.add(station);
    }

    @GetMapping("/selectSTA")
    public Station select(@RequestParam int id) {
        System.out.println(id);
        Station select = server.select(id);
        System.out.println(select);
        return select;
    }

    @GetMapping("/selectSTAL")
    public List<Station> selectList(@RequestParam List ids) {
        List<Station> select = server.select(ids);
        return select;
    }

    @GetMapping("/selectSTAM")
    public List<Station> selectList(@RequestParam Map map) {
        List<Station> select = server.select(map);
        return select;
    }

    @GetMapping("/updateSTA")
    public String update(@RequestParam Station station) {
        return server.updateById(station);
    }

    @GetMapping("/deleteSTA")
    public String delete(@RequestParam int id) {
        return server.delete(id);
    }

    @GetMapping("/deleteSTAM")
    public String delete(@RequestParam Map map) {
        return server.delete(map);
    }
}
