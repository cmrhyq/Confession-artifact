package com.alan.show.love.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>页面控制层</p>
 *
 * @author Alan Huang
 * @version v1.0.0
 * @className PageController.java
 * @project showLove
 * @package com.alan.show.love.controller
 * @date 2021/8/28-0:03
 * @email cmrhyq@163.com
 */
@Controller
@RequestMapping("/")
public class PageController {

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("userInfoEdit")
    public String userInfoEdit(){
        return "userInfoEdit";
    }
}
