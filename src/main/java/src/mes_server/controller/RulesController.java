package src.mes_server.controller;

import org.springframework.web.bind.annotation.*;
import src.mes_server.pojo.Rules;
import src.mes_server.result.ResultEnum;
import src.mes_server.server.RulesServerImpl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController("RU")
public class RulesController {
    @Resource
    private RulesServerImpl server;

    @PostMapping("/addRU")
    public ResultEnum addRules(@RequestBody Rules rules) {
        return server.add(rules);
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
    public ResultEnum update(@RequestBody Rules rules) {
        return server.updateById(rules);
    }

    @GetMapping("/deleteRU")
    public ResultEnum delete(@RequestParam int id) {
        return server.delete(id);
    }

    @PostMapping("/deleteRUM")
    public ResultEnum delete(@RequestBody Map map) {
        return server.delete(map);
    }
}
