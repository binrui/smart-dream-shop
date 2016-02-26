package com.smart.shop.view;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.shop.order.TestService;

/**
 * 微服务应用入口
 * @author lijinfeng
 * @time 2016-02-25 16:32
 * @remark 应用访问入口
 * 1. @RestController microservice 
 * 2. @Controller html模板下使用
 * 3. @ComponentScan 扫描所有的注解组件
 * @SpringBootApplication same as @Configuration @EnableAutoConfiguration @ComponentScan
 */
@Controller
@ComponentScan(basePackages = "com.smart.shop.view,com.smart.shop.order")
@EnableAutoConfiguration
public class Application {
	@Autowired
	TestService testService;
	
	private Logger logger = Logger.getLogger(Application.class);
	/**
	 * 首页
	 * @return
	 */
    @RequestMapping("/")
    public String index(ModelMap map) {
    	logger.debug("...index page start...");
    	String hello = testService.sayHello("lijinfeng");
    	map.put("name", hello);
    	logger.info("...index page end...");
    	logger.warn("...index page warn...");
        return "index";
    }
    
    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "views/index";
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