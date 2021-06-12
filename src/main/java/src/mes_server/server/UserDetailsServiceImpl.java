package src.mes_server.server;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import src.mes_server.dto.SecurityUser;
import src.mes_server.pojo.Staff;
import src.mes_server.result.PasswdFailException;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private StaffServerImpl server;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询数据
        Staff staff = server.select(Integer.parseInt(username));
        //判断
        if(staff == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        //用户权限列表为空
        List<String> permissionValueList = new ArrayList<>();
        SecurityUser securityUser = new SecurityUser();
        securityUser.setStaff(staff);
        securityUser.setPermissionValueList(permissionValueList);
        return securityUser;
    }

}
