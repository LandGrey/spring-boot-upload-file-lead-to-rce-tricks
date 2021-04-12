package code.landgrey.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class ClassForNameController {
    @RequestMapping("/classForName")
    public String classForName(String name) throws Exception {
        if(name == null){
            name = "code.landgrey.bean.Car";
        }
        Class clazz = Class.forName(name);
        return "you got a " + name + " : =[" + clazz.newInstance().toString() + "]=";
    }
}