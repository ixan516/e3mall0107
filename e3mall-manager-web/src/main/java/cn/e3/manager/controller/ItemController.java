package cn.e3.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.manager.pojo.TbItem;
import cn.e3.manager.service.ItemService;
import cn.e3.utils.EasyUIPageBean;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	/**
	 * 需求:根据itemId查询商品 
	 * 参数:Long itemId
	 * 返回值
	 */
	@ResponseBody
	@RequestMapping("/item/{itemId}")
	public TbItem findItemById(@PathVariable Long itemId) {
		return itemService.findItemById(itemId);
	}
	
	/**
	 * item/list?page=1&rows=30
	 * 需求:查询商品数据进行分页展示
	 * 参数Integer page,Integer rows
	 * 返回值 EasyUIPageBean
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIPageBean findItemListByPage(@RequestParam(defaultValue="1") Integer page,
			@RequestParam(defaultValue="30") Integer rows){
		EasyUIPageBean listByPage = itemService.findItemListByPage(page, rows);
		return listByPage;
	}
}
