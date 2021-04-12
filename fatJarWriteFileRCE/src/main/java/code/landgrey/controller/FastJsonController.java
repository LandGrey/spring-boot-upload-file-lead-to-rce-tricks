package code.landgrey.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class FastJsonController {
    @RequestMapping(path="/fastjson", method = RequestMethod.POST, produces = "application/json")
    public String testFastJson(@RequestBody String json){
        Object o = JSON.parse(json);
        return o.toString();
    }
}