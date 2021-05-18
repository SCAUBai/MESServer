package src.mes_server.controller;

import org.springframework.web.bind.annotation.*;
import src.mes_server.pojo.Material;
import src.mes_server.server.MaterialServerImpl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class MaterialController {
    @Resource
    private MaterialServerImpl server;

    @PostMapping("/addMT")
    public void addMaterial(@RequestBody Material material) {
        server.add(material);
    }

    @GetMapping("/selectMT")
    public Material select(@RequestParam int id) {
        System.out.println(id);
        Material select = server.select(id);
        System.out.println(select);
        return select;
    }

    @PostMapping("/selectMTL")
    public List<Material> selectList(@RequestBody List ids) {
        List<Material> select = server.select(ids);
        return select;
    }

    @PostMapping("/selectMTM")
    public List<Material> selectList(@RequestBody Map map) {
        List<Material> select = server.select(map);
        return select;
    }

    @PostMapping("/updateMT")
    public String update(@RequestBody Material material) {
        return server.updateById(material);
    }

    @GetMapping("/deleteMT")
    public String delete(@RequestParam int id) {
        return server.delete(id);
    }

    @PostMapping("/deleteMTM")
    public String delete(@RequestBody Map map) {
        return server.delete(map);
    }
}
