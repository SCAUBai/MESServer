package src.mes_server.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import src.mes_server.pojo.Staff;
import src.mes_server.result.PasswdFailException;
import src.mes_server.result.UserNotFoundException;
import src.mes_server.security.TokenManager;
import src.mes_server.server.StaffServerImpl;

@RestController
//@CrossOrigin
public class UserController {
    @Autowired
    private StaffServerImpl server;
    @Autowired
    private TokenManager manager;

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestParam int id, @RequestParam String passwd){
        Staff s = server.select(id);
        if (s == null)
            throw new UserNotFoundException("用户名不存在");
        if (!s.getPasswd().equals(passwd))
            throw new PasswdFailException("账户或密码错误");
        String token = manager.createToken(id+"");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("token", token);
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }
}
