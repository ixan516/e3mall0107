package cn.e3.manager.service;

import cn.e3.manager.pojo.TbItem;
import cn.e3.utils.EasyUIPageBean;

public interface ItemService {
	
	/**
	 * 需求:根据itemId查询商品 
	 * 参数:Long itemId
	 * 返回值
	 */
	TbItem findItemById(Long itemId);
	
	/**
	 * item/list?page=1&rows=30
	 * 需求:查询商品数据进行分页展示
	 * 参数Integer page,Integer rows
	 * 返回值 EasyUIPageBean
	 */
	EasyUIPageBean findItemListByPage(Integer page,Integer rows);
	
}
