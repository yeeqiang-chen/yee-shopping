package com.yiqiang.shopping.manage.service;

import com.github.abel533.entity.Example;
import com.yiqiang.shopping.manage.mapper.ItemParamItemMapper;
import com.yiqiang.shopping.manage.pojo.ItemParamItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Title:
 * Description:
 * Create Time: 2016/12/29 0029 1:47
 *
 * @author: YEEQiang
 * @version: 1.0
 */
@Service
public class ItemParamItemService extends BaseService<ItemParamItem> {

    @Autowired
    private ItemParamItemMapper itemParamItemMapper;

    public Integer updateItemParamItem(Long itemId, String itemParams) {
        // 更新的数据
        ItemParamItem itemParamItem = new ItemParamItem();
        itemParamItem.setParamData(itemParams);
        itemParamItem.setUpdated(new Date());

        // 更新的条件
        Example example = new Example(ItemParamItem.class);
        example.createCriteria().andEqualTo("itemId", itemId);
        return this.itemParamItemMapper.updateByExampleSelective(itemParamItem, example);
    }
}
