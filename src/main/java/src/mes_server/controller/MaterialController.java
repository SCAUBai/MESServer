package src.mes_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import src.mes_server.pojo.Material;
import src.mes_server.server.MaterialServerImpl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class MaterialController {
    @Resource
    private MaterialServerImpl server;

    @GetMapping("/addMT")
    public void addMaterial() {
        Material material = new Material();
        server.add(material);
    }

    @GetMapping("/selectMT")
    public Material select(@RequestParam int id) {
        System.out.println(id);
        Material select = server.select(id);
        System.out.println(select);
        return select;
    }

    @GetMapping("/selectMTL")
    public List<Material> selectList(@RequestParam List ids) {
        List<Material> select = server.select(ids);
        return select;
    }

    @GetMapping("/selectMTM")
    public List<Material> selectList(@RequestParam Map map) {
        List<Material> select = server.select(map);
        return select;
    }

    @GetMapping("/updateMT")
    public String update(@RequestParam Material material) {
        return server.updateById(material);
    }

    @GetMapping("/deleteMT")
    public String delete(@RequestParam int id) {
        return server.delete(id);
    }

    @GetMapping("/deleteMTM")
    public String delete(@RequestParam Map map) {
        return server.delete(map);
    }
}
