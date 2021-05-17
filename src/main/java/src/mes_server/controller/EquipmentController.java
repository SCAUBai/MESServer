package src.mes_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import src.mes_server.pojo.Equipment;
import src.mes_server.server.EquipmentServerImpl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class EquipmentController {
    @Resource
    private EquipmentServerImpl server;

    @GetMapping("/addEM")
    public void addEquipment() {
        Equipment equipment = new Equipment();
//        equipment.setEName("A02");
//        equipment.setEquipmentId(2);
//        equipment.setEType("A");
        System.out.println(equipment);
        server.add(equipment);
    }

    @GetMapping("/selectEM")
    public Equipment select(@RequestParam int id) {
        System.out.println(id);
        Equipment select = server.select(id);
        System.out.println(select);
        return select;
    }

    @GetMapping("/selectEML")
    public List<Equipment> selectList(@RequestParam List ids) {
        List<Equipment> select = server.select(ids);
        return select;
    }

    @GetMapping("/selectEMM")
    public List<Equipment> selectList(@RequestParam Map map) {
        List<Equipment> select = server.select(map);
        return select;
    }

    @GetMapping("/updateEM")
    public String update(@RequestParam Equipment equipment) {
        return server.updateById(equipment);
    }

    @GetMapping("/deleteEM")
    public String delete(@RequestParam int id) {
        return server.delete(id);
    }

    @GetMapping("/deleteEMM")
    public String delete(@RequestParam Map map) {
        return server.delete(map);
    }
}
