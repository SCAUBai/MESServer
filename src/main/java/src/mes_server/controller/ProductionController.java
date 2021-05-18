package src.mes_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import src.mes_server.pojo.Production;
import src.mes_server.server.ProductionServerImpl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class ProductionController {
    @Resource
    private ProductionServerImpl server;

    @GetMapping("/addPD")
    public void addProduction() {
        Production production = new Production();
        server.add(production);
    }

    @GetMapping("/selectPD")
    public Production select(@RequestParam int id) {
        System.out.println(id);
        Production select = server.select(id);
        System.out.println(select);
        return select;
    }

    @GetMapping("/selectPDL")
    public List<Production> selectList(@RequestParam List ids) {
        List<Production> select = server.select(ids);
        return select;
    }

    @GetMapping("/selectPDM")
    public List<Production> selectList(@RequestParam Map map) {
        List<Production> select = server.select(map);
        return select;
    }

    @GetMapping("/updatePD")
    public String update(@RequestParam Production production) {
        return server.updateById(production);
    }

    @GetMapping("/deletePD")
    public String delete(@RequestParam int id) {
        return server.delete(id);
    }

    @GetMapping("/deletePDM")
    public String delete(@RequestParam Map map) {
        return server.delete(map);
    }
}
