package com.smart.shop.admin.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop/admin")
public class AdminController {
	/**
	 * 个人管理首页
	 * @return
	 */
	@RequestMapping("/")
	public String admin(){
		return "admin/index";
	}
}
