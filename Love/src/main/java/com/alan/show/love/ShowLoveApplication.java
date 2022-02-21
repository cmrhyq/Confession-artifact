package com.alan.show.love;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

/**
 * <p>启动类</p>
 *
 * @author Alan Huang
 * @version v1.0.0
 * @className ShowLoveApplication.java
 * @project showLove
 * @package com.alan.show.love
 * @date 2021/8/27-19:12
 * @email cmrhyq@163.com
 */
@Slf4j
@SpringBootApplication
public class ShowLoveApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
        SpringApplication.run(ShowLoveApplication.class, args);
        long endTime = System.currentTimeMillis();
        log.info("程序启动耗时：" + (endTime - beginTime) + "ms");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
        return applicationBuilder.sources(ShowLoveApplication.class);
    }
}
