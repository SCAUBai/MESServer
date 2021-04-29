package src.mes_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("src.mes_server.dao")
public class MESServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MESServerApplication.class, args);
    }
}
