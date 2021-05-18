package src.mes_server.controller;

import org.springframework.web.bind.annotation.*;
import src.mes_server.pojo.Production;
import src.mes_server.server.ProductionServerImpl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController("PD")
public class ProductionController {
    @Resource
    private ProductionServerImpl server;

    @PostMapping("/addPD")
    public void addProduction(@RequestBody Production production) {
        server.add(production);
    }

    @GetMapping("/selectPD")
    public Production select(@RequestParam("id") int id) {
        System.out.println(id);
        Production select = server.select(id);
        System.out.println(select);
        return select;
    }

    @PostMapping("/selectPDL")
    public List<Production> selectList(@RequestBody List ids) {
        List<Production> select = server.select(ids);
        return select;
    }

    @PostMapping("/selectPDM")
    public List<Production> selectList(@RequestBody Map map) {
        List<Production> select = server.select(map);
        return select;
    }

    @PostMapping("/updatePD")
    public String update(@RequestBody Production production) {
        return server.updateById(production);
    }

    @GetMapping("/deletePD")
    public String delete(@RequestParam("id") int id) {
        return server.delete(id);
    }

    @PostMapping("/deletePDM")
    public String delete(@RequestBody Map map) {
        return server.delete(map);
    }
}
