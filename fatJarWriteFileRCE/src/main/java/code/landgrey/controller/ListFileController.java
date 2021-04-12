package code.landgrey.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListFileController {
    @GetMapping("/listFile")
    public String listFile() throws Throwable{
        String rs = "/tmp 目录文件列表: </br>===============================</br>";
        String line;
        java.lang.Process proc = java.lang.Runtime.getRuntime().exec("ls -lt /tmp/");
        java.io.InputStream in = proc.getInputStream();
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(in, "UTF-8"));
        while( (line = br.readLine()) != null){
            rs += line + "</br>";
        }
        return rs;
    }
}