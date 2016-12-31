package com.yiqiang.shopping.manage.service;

import com.fasterxml.jackson.databind.deser.Deserializers;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yiqiang.shopping.common.bean.EasyUIResult;
import com.yiqiang.shopping.manage.mapper.ItemMapper;
import com.yiqiang.shopping.manage.pojo.Item;
import com.yiqiang.shopping.manage.pojo.ItemDesc;
import com.yiqiang.shopping.manage.pojo.ItemParamItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title:
 * Description:
 * Create Time: 24/12/2016 0024 22:51
 *
 * @author: YEEChan
 * @version: 1.0
 */
@Service
public class ItemService extends BaseService<Item> {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ItemDescService itemDescService;

    @Autowired
    private ItemParamItemService itemParamItemService;

    public Boolean saveItem(Item item, String desc,String itemParams) {
        /** init item value*/
        item.setStatus(1);
        item.setId(null); // 出于安全考虑,强制设置id为null,通过数据库自增长
        Integer count1 = super.save(item);

        // 保存商品描述数据
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(item.getId());
        itemDesc.setItemDesc(desc);
        Integer count2 = this.itemDescService.save(itemDesc);

        // 保存规格参数数据
        ItemParamItem itemParamItem = new ItemParamItem();
        itemParamItem.setItemId(item.getId());
        itemParamItem.setParamData(itemParams);
        Integer count3 = this.itemParamItemService.save(itemParamItem);

        return count1.intValue() ==1 && count2.intValue() == 1 && count3.intValue() == 1;
    }

    public EasyUIResult queryItemList(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        Example example = new Example(Item.class);
//        example.setOrderByClause("created DESC");
//        List<Item> items = this.itemMapper.selectByExample(example);
        List<Item> items = this.itemMapper.selectByExampleCustomer(example);
        PageInfo<Item> pageInfo = new PageInfo<Item>(items);
        return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
    }

    public Boolean updateItem(Item item, String desc, String itemParams) {
        // 强制设置不能更新的字段为null
        item.setCreated(null);
        item.setStatus(null);

        Integer count1 = super.updateSelective(item);

        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(item.getId());
        itemDesc.setItemDesc(desc);
        Integer count2 = this.itemDescService.updateSelective(itemDesc);

        // 更新规格参数数据
        Integer count3 = this.itemParamItemService.updateItemParamItem(item.getId(), itemParams);
        return count1.intValue() == 1 && count2.intValue() == 1 && count3.intValue() == 1;
    }
}
