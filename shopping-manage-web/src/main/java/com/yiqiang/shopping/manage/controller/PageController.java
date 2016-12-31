package com.yiqiang.shopping.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Title:
 * Description: 通用的页面跳转Controller
 * Create Time: 2016/12/15 0015 1:21
 *
 * @author: YEEQiang
 * @version: 1.0
 */
@RequestMapping("page")
@Controller
public class PageController {

    /**
     * 具体的跳转页面逻辑
     * @param pageName
     * @return 视图名
     */
    @RequestMapping(value = "{pageName}", method = RequestMethod.GET)
    public String toPage(@PathVariable("pageName") String pageName) {
        return pageName;
    }

}
