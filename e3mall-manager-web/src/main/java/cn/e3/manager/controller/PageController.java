package cn.e3.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	/**
	 * 需求:根据请求返回页面
	 * @param page
	 * @return
	 */
	@RequestMapping("{page}")
	public String showPagge(@PathVariable String page) {
		return page;
	}
}
