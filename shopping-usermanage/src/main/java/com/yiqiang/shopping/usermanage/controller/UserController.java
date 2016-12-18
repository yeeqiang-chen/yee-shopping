package com.yiqiang.shopping.usermanage.controller;

import com.yiqiang.shopping.usermanage.bean.EasyUIResult;
import com.yiqiang.shopping.usermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Title:
 * Description:
 * Create Time: 2016/12/15 0015 1:48
 *
 * @author: YEEQiang
 * @version: 1.0
 */
@RequestMapping("user")
@Controller
public class UserController {

    // @Autowired
    // private UserService userService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public EasyUIResult queryUserList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                      @RequestParam(value = "rows", defaultValue = "5") Integer rows) {
        return this.userService.queryUserList(page, rows);
    }

}
