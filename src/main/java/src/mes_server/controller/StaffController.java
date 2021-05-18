package src.mes_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import src.mes_server.pojo.Staff;
import src.mes_server.server.StaffServerImpl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class StaffController {
    @Resource
    private StaffServerImpl server;

    @GetMapping("/addST")
    public void addStaff() {
        Staff staff = new Staff();
        server.add(staff);
    }

    @GetMapping("/selectST")
    public Staff select(@RequestParam int id) {
        System.out.println(id);
        Staff select = server.select(id);
        System.out.println(select);
        return select;
    }

    @GetMapping("/selectSTL")
    public List<Staff> selectList(@RequestParam List ids) {
        List<Staff> select = server.select(ids);
        return select;
    }

    @GetMapping("/selectSTM")
    public List<Staff> selectList(@RequestParam Map map) {
        List<Staff> select = server.select(map);
        return select;
    }

    @GetMapping("/updateST")
    public String update(@RequestParam Staff staff) {
        return server.updateById(staff);
    }

    @GetMapping("/deleteST")
    public String delete(@RequestParam int id) {
        return server.delete(id);
    }

    @GetMapping("/deleteSTM")
    public String delete(@RequestParam Map map) {
        return server.delete(map);
    }
}
