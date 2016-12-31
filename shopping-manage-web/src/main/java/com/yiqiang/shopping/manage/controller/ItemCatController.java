package com.yiqiang.shopping.manage.controller;

import com.yiqiang.shopping.manage.pojo.ItemCat;
import com.yiqiang.shopping.manage.service.ItemCatService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Title:
 * Description:
 * Create Time: 2016/12/21 0021 2:36
 *
 * @author: YEEQiang
 * @version: 1.0
 */
@Controller
@RequestMapping("item/cat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;
    @RequestMapping(method = RequestMethod.GET)

    /**
     * 查询商品类目列表
     */
    public ResponseEntity<List<ItemCat>> queryItemCatListByParentId(
            @RequestParam(value = "id",defaultValue = "0")Long pid) {
        try {
//            List<ItemCat> itemCatList = this.itemCatService.querItemCatListByParentId(pid);
            ItemCat record = new ItemCat();
            record.setParentId(pid);
            List<ItemCat> itemCatList = this.itemCatService.queryListByWhere(record);
            if (CollectionUtils.isEmpty(itemCatList)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(itemCatList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
