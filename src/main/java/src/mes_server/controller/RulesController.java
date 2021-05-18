package src.mes_server.controller;

import org.springframework.web.bind.annotation.*;
import src.mes_server.pojo.Rules;
import src.mes_server.server.RulesServerImpl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class RulesController {
    @Resource
    private RulesServerImpl server;

    @PostMapping("/addRU")
    public void addRules(@RequestBody Rules rules) {
        server.add(rules);
    }

    @GetMapping("/selectRU")
    public Rules select(@RequestParam int id) {
        System.out.println(id);
        Rules select = server.select(id);
        System.out.println(select);
        return select;
    }

    @PostMapping("/selectRUL")
    public List<Rules> selectList(@RequestBody List ids) {
        List<Rules> select = server.select(ids);
        return select;
    }

    @PostMapping("/selectRUM")
    public List<Rules> selectList(@RequestBody Map map) {
        List<Rules> select = server.select(map);
        return select;
    }

    @PostMapping("/updateRU")
    public String update(@RequestBody Rules rules) {
        return server.updateById(rules);
    }

    @GetMapping("/deleteRU")
    public String delete(@RequestParam int id) {
        return server.delete(id);
    }

    @PostMapping("/deleteRUM")
    public String delete(@RequestBody Map map) {
        return server.delete(map);
    }
}
