package code.landgrey.controller;

import code.landgrey.bean.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class JackSonController {
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(path="/jackson", method = RequestMethod.POST)
    public String testJackSon(@RequestBody String json) throws Throwable {
        objectMapper.enableDefaultTyping();
        Object o = objectMapper.readValue(json, Object.class);
        return o.toString();
    }
}
