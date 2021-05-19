package src.mes_server.controller;

import org.springframework.web.bind.annotation.*;
import src.mes_server.pojo.Process;
import src.mes_server.result.ResultEnum;
import src.mes_server.server.ProcessServerImpl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController("PC")
public class ProcessController {
    @Resource
    private ProcessServerImpl server;

    @PostMapping("/addPC")
    public ResultEnum addProcess(@RequestBody Process process) {
        return server.add(process);
    }

    @GetMapping("/selectPC")
    public Process select(@RequestParam int id) {
        System.out.println(id);
        Process select = server.select(id);
        System.out.println(select);
        return select;
    }

    @PostMapping("/selectPCL")
    public List<Process> selectList(@RequestBody List ids) {
        List<Process> select = server.select(ids);
        return select;
    }

    @PostMapping("/selectPCM")
    public List<Process> selectList(@RequestBody Map map) {
        List<Process> select = server.select(map);
        return select;
    }

    @PostMapping("/updatePC")
    public ResultEnum update(@RequestBody Process process) {
        return server.updateById(process);
    }

    @GetMapping("/deletePC")
    public ResultEnum delete(@RequestParam int id) {
        return server.delete(id);
    }

    @PostMapping("/deletePCM")
    public ResultEnum delete(@RequestBody Map map) {
        return server.delete(map);
    }
}
