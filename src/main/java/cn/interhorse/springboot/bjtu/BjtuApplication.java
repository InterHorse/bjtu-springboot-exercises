package cn.interhorse.springboot.bjtu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Yuzhe Ma
 * @date 2020/7/30
 */
@SpringBootApplication
@MapperScan("cn.interhorse.springboot.bjtu.dao.mapper")
public class BjtuApplication {

    public static void main(String[] args) {
        SpringApplication.run(BjtuApplication.class, args);
    }

}
