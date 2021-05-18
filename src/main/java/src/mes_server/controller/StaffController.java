package src.mes_server.controller;

import org.springframework.web.bind.annotation.*;
import src.mes_server.pojo.Staff;
import src.mes_server.server.StaffServerImpl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController("ST")
public class StaffController {
    @Resource
    private StaffServerImpl server;

    @PostMapping("/addST")
    public String addStaff(@RequestBody Staff staff) {
        return server.add(staff);
    }

    @GetMapping("/selectST")
    public Staff select(@RequestParam("id") int id) {
        System.out.println(id);
        Staff select = server.select(id);
        System.out.println(select);
        return select;
    }

    @PostMapping("/selectSTL")
    public List<Staff> selectList(@RequestBody List ids) {
        List<Staff> select = server.select(ids);
        return select;
    }

    @PostMapping("/selectSTM")
    public List<Staff> selectList(@RequestBody Map map) {
        List<Staff> select = server.select(map);
        return select;
    }

    @PostMapping("/updateST")
    public String update(@RequestBody Staff staff) {
        return server.updateById(staff);
    }

    @GetMapping("/deleteST")
    public String delete(@RequestParam("id") int id) {
        return server.delete(id);
    }

    @PostMapping("/deleteSTM")
    public String delete(@RequestParam Map map) {
        return server.delete(map);
    }
}
