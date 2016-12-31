package com.yiqiang.shopping.manage.mapper;

import com.github.abel533.mapper.Mapper;
import com.yiqiang.shopping.manage.pojo.Item;

import java.util.List;

/**
 * Title:
 * Description:
 * Create Time: 2016/12/24 0024 17:45
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public interface ItemMapper extends Mapper<Item> {
    List<Item> selectByExampleCustomer(Object example);
}
