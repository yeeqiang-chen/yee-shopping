package com.yiqiang.shopping.manage.service;


import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yiqiang.shopping.common.bean.EasyUIResult;
import com.yiqiang.shopping.manage.mapper.ItemParamMapper;
import com.yiqiang.shopping.manage.pojo.Item;
import com.yiqiang.shopping.manage.pojo.ItemParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title:
 * Description:
 * Create Time: 2016/12/29 0029 1:42
 *
 * @author: YEEQiang
 * @version: 1.0
 */
@Service
public class ItemParamService extends BaseService<ItemParam> {

    @Autowired
    private ItemParamMapper itemParamMapper;

    public EasyUIResult queryItemParamList(Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        Example example = new Example(Item.class);
        example.setOrderByClause("created DESC");
//        List<ItemParam> itemParams = this.itemParamMapper.selectByExample(example);
        List<ItemParam> itemParams = this.itemParamMapper.selectByExampleCustomer(example);
        PageInfo<ItemParam> pageInfo = new PageInfo<ItemParam>(itemParams);
        return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
    }
}
