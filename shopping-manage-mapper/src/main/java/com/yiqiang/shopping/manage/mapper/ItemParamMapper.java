package com.yiqiang.shopping.manage.mapper;

import com.github.abel533.mapper.Mapper;
import com.yiqiang.shopping.manage.pojo.Item;
import com.yiqiang.shopping.manage.pojo.ItemParam;

import java.util.List;

/**
 * Title:
 * Description:
 * Create Time: 2016/12/29 0029 1:40
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public interface ItemParamMapper extends Mapper<ItemParam> {

    List<ItemParam> selectByExampleCustomer(Object example);
}
