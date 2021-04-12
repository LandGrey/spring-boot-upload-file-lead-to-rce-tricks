package code.landgrey.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.DriverManager;

@RestController
public class JdbcController {
    @GetMapping("/jdbc")
    public String JdbcTest(String url){
        try{
            DriverManager.setLoginTimeout(10);
            Class.forName("com.mysql.jdbc.Driver");
            DriverManager.getConnection(url);
        }catch (Throwable t){
            t.printStackTrace();
            return "jdbc connection failed!";
        }

        return "jdbc connection success!";
    }
}