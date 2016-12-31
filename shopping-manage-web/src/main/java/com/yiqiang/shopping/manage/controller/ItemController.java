package com.yiqiang.shopping.manage.controller;

import com.yiqiang.shopping.common.bean.EasyUIResult;
import com.yiqiang.shopping.manage.pojo.Item;
import com.yiqiang.shopping.manage.service.ItemParamItemService;
import com.yiqiang.shopping.manage.service.ItemService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Title:
 * Description:
 * Create Time: 24/12/2016 0024 22:48
 *
 * @author: YEEChan
 * @version: 1.0
 */
@RequestMapping("item")
@Controller
public class ItemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemParamItemService itemParamItemService;

    /**
     * new item
     *
     * @param item
     * @param desc
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveItem(Item item, @RequestParam("desc") String desc,
                                         @RequestParam("itemParams") String itemParams) {
        try {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("add item,item = {}, desc = {}", item, desc);
            }
            if (StringUtils.isEmpty(item.getTitle())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            // 保存商品
            Boolean bool = this.itemService.saveItem(item, desc, itemParams);
            if (!bool) {
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("add item failed, item = {}, desc = {}", item, desc);
                }
                // 保存失败
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("add item successfully.itemId = {}", item.getId());
            }
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
//            e.printStackTrace();
            LOGGER.error("add item occur error. item = " + item, e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * query item
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<EasyUIResult> queryItemList(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows) {
        try {
            return ResponseEntity.ok(this.itemService.queryItemList(page, rows));
        } catch (Exception e) {
            LOGGER.error("query item occur error! page = " + page, ", rows = " + rows, e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 更新商品
     *
     * @param item
     * @param desc
     * @param itemParams
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateItem(Item item, @RequestParam("desc") String desc,
                                           @RequestParam("itemParams") String itemParams) {
        try {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("add item,item = {}, desc = {}", item, desc);
            }
            if (StringUtils.isEmpty(item.getTitle())) {
                // 参数有误,400
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            // 编辑商品
            Boolean bool = this.itemService.updateItem(item, desc, itemParams);
            if (!bool) {
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("update item failed, item = {}, desc = {}", item, desc);
                }
                // 保存失败,500
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("update item successfully.itemId = {}", item.getId());
            }
            // 205
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
//            e.printStackTrace();
            LOGGER.error("update item occur error. item = " + item, e);
        }
        // 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
