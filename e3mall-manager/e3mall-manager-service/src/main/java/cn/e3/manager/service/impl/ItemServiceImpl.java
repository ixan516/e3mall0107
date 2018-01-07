package cn.e3.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3.manager.mapper.TbItemMapper;
import cn.e3.manager.pojo.TbItem;
import cn.e3.manager.pojo.TbItemExample;
import cn.e3.manager.service.ItemService;
import cn.e3.utils.EasyUIPageBean;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper tbItemMapper;
	/**
	 * 需求:根据itemId查询商品 
	 * 参数:Long itemId
	 * 返回值
	 */
	@Override
	public TbItem findItemById(Long itemId) {
		return tbItemMapper.selectByPrimaryKey(itemId);
	}
	
	/**
	 * item/list?page=1&rows=30
	 * 需求:查询商品数据进行分页展示
	 * 参数Integer page,Integer rows
	 * 返回值 EasyUIPageBean
	 */
	@Override
	public EasyUIPageBean findItemListByPage(Integer page, Integer rows) {
		TbItemExample example = new TbItemExample();
		// 在查询之前进行分页设置
		PageHelper.startPage(page, rows);
		// 设置分页查询之后，距离分页最近的一条sql语句会被拦截，执行分页查询
		List<TbItem> list = tbItemMapper.selectByExample(example);
		
		// 创建PageInfo对象，封装分页数据
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		// 创建EasyUIPageBean对象
		EasyUIPageBean result = new EasyUIPageBean();
		result.setRows(pageInfo.getList());
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	

}
