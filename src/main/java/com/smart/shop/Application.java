package com.smart.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 微服务应用入口
 * @author lijinfeng
 * @time 2016-02-25 16:32
 * @remark 应用访问入口
 * 1. @RestController 
 * 2. @Controller 模板下使用
 */
@Controller
@EnableAutoConfiguration
public class Application {
	/**
	 * 首页
	 * @return
	 */
    @RequestMapping("/")
    String index() {
        return "index";
    }
    
    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "Hello World!";
    }
    
    /**
     * 退出页面
     * @return
     */
    @RequestMapping("/logout")
    public String logout() {
        return "Hello World!";
    }
    
    /**
     * 主函数
     * @param args
     * @throws Exception
     */
    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
        //SpringApplication.run(Application.class, args);
        SpringApplication app = new SpringApplication(Application.class);
        app.setShowBanner(false);
        app.run(args);
    }

}