package src.mes_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import src.mes_server.pojo.Rules;
import src.mes_server.server.RulesServerImpl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class RulesController {
    @Resource
    private RulesServerImpl server;

    @GetMapping("/addRU")
    public void addRules() {
        Rules rules = new Rules();
        server.add(rules);
    }

    @GetMapping("/selectRU")
    public Rules select(@RequestParam int id) {
        System.out.println(id);
        Rules select = server.select(id);
        System.out.println(select);
        return select;
    }

    @GetMapping("/selectRUL")
    public List<Rules> selectList(@RequestParam List ids) {
        List<Rules> select = server.select(ids);
        return select;
    }

    @GetMapping("/selectRUM")
    public List<Rules> selectList(@RequestParam Map map) {
        List<Rules> select = server.select(map);
        return select;
    }

    @GetMapping("/updateRU")
    public String update(@RequestParam Rules rules) {
        return server.updateById(rules);
    }

    @GetMapping("/deleteRU")
    public String delete(@RequestParam int id) {
        return server.delete(id);
    }

    @GetMapping("/deleteRUM")
    public String delete(@RequestParam Map map) {
        return server.delete(map);
    }
}
