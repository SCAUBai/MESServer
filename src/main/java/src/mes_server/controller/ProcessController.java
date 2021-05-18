package src.mes_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import src.mes_server.pojo.Process;
import src.mes_server.server.ProcessServerImpl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class ProcessController {
    @Resource
    private ProcessServerImpl server;

    @GetMapping("/addPC")
    public void addProcess() {
        Process process = new Process();
        server.add(process);
    }

    @GetMapping("/selectPC")
    public Process select(@RequestParam int id) {
        System.out.println(id);
        Process select = server.select(id);
        System.out.println(select);
        return select;
    }

    @GetMapping("/selectPCL")
    public List<Process> selectList(@RequestParam List ids) {
        List<Process> select = server.select(ids);
        return select;
    }

    @GetMapping("/selectPCM")
    public List<Process> selectList(@RequestParam Map map) {
        List<Process> select = server.select(map);
        return select;
    }

    @GetMapping("/updatePC")
    public String update(@RequestParam Process process) {
        return server.updateById(process);
    }

    @GetMapping("/deletePC")
    public String delete(@RequestParam int id) {
        return server.delete(id);
    }

    @GetMapping("/deletePCM")
    public String delete(@RequestParam Map map) {
        return server.delete(map);
    }
}
