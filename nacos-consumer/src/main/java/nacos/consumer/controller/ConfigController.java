package nacos.consumer.controller;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
@RefreshScope
public class ConfigController {

    @GetMapping("/nacos/config")
    public String getNacosInfo() throws NacosException {
        String serverAddr = "127.0.0.1:8848";
        String dataId = "test";
        String group = "DEFAULT_GROUP";

        Properties properties = new Properties();
        properties.put(PropertyKeyConst.NAMESPACE, "1fd67381-244f-4707-8dc8-ed629d47a439");
        properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);

        ConfigService configService = NacosFactory.createConfigService(properties);
        String content = configService.getConfig(dataId, group, 5000);
        System.out.println("nacos config info:");
        System.out.println(content);
        return content;
    }

//    功能同RefreshScope
//    @Autowired
//    ConfigurableApplicationContext applicationContext;

    @Value("${name}")
    private String name;

    @Value("${age}")
    private String age;

    @GetMapping("/config")
    public String getNacosConfig() throws NacosException {
        // 实时返回nacos配置值
//        String name = applicationContext.getEnvironment().getProperty("name");
//        String age = applicationContext.getEnvironment().getProperty("age");

        return name + age;
    }
}
