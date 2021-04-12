package code.landgrey.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class ClassLoaderController {
    @RequestMapping("/classLoader")
    public String classForName(String name) throws Exception {
        if(name == null){
            name = "code.landgrey.bean.User";
        }
        Class clazz = Thread.currentThread().getContextClassLoader().loadClass(name);
        return "you got a " + name + " : =[" + clazz.newInstance().toString() + "]=";
    }
}