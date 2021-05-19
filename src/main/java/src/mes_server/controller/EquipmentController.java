package src.mes_server.controller;

import org.springframework.web.bind.annotation.*;
import src.mes_server.pojo.Equipment;
import src.mes_server.result.ResultEnum;
import src.mes_server.server.EquipmentServerImpl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController("/EM")
public class EquipmentController {
    @Resource
    private EquipmentServerImpl server;

    @PostMapping("/addEM")
    public ResultEnum addEquipment(@RequestBody Equipment equipment) {
        return server.add(equipment);
    }

    @GetMapping("/selectEM")
    public Equipment select(@RequestParam("id") int id) {
        System.out.println(id);
        Equipment select = server.select(id);
        System.out.println(select);
        return select;
    }

    @PostMapping("/selectEML")
    public List<Equipment> selectList(@RequestBody List ids) {
        List<Equipment> select = server.select(ids);
        return select;
    }

    @PostMapping("/selectEMM")
    public List<Equipment> selectList(@RequestBody Map map) {
        List<Equipment> select = server.select(map);
        return select;
    }

    @PostMapping("/updateEM")
    public ResultEnum update(@RequestBody Equipment equipment) {
        return server.updateById(equipment);
    }

    @GetMapping("/deleteEM")
    public ResultEnum delete(@RequestParam("id") int id) {
        return server.delete(id);
    }

    @PostMapping("/deleteEMM")
    public ResultEnum delete(@RequestBody Map map) {
        return server.delete(map);
    }
}
