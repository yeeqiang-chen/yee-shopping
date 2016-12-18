package com.yiqiang.shopping.usermanage.controller;

import com.yiqiang.shopping.usermanage.bean.EasyUIResult;
import com.yiqiang.shopping.usermanage.pojo.User;
import com.yiqiang.shopping.usermanage.service.RestFulUserService;
import com.yiqiang.shopping.usermanage.view.UserExcelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Title:
 * Description:
 * Create Time: 2016/12/18 0018 16:11
 *
 * @author: YEEQiang
 * @version: 1.0
 */

@RequestMapping("new/user")
@Controller
public class RestFulUserController {

    @Autowired
    private RestFulUserService restFulUserService;

    /**
     * 根据用户id查询用户信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> queryUserById(@PathVariable("id") Long id) {
        try {
            User user = this.restFulUserService.queryUserById(id);
            if (null == user) {
                // 资源不存在，响应404
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            // 资源存在，响应200
            // return ResponseEntity.status(HttpStatus.OK).body(user);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveUser(User user) {
        try {
            Boolean bool = this.restFulUserService.saveUser(user);
            if (bool) {
                // 新增成功，响应201
                return ResponseEntity.status(HttpStatus.CREATED).build();   // .body(null) == .build()
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 新增失败，响应500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUser(User user) {
        try {
            Boolean bool = this.restFulUserService.updateUser(user);
            if (bool) {
                // 更新成功，响应204
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 新增失败，响应500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 删除用户
     *  _method = DELETE
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@RequestParam(value = "id", defaultValue = "0") Long id) {
        try {
            if (id.longValue() == 0) {
                // 没有传递参数，响应状态码400
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            Boolean bool = this.restFulUserService.deleteUser(id);
            if (bool) {
                // 删除成功，响应204
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 删除失败，响应500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * export user user info into excel
     * @param model
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "export/excel")
    public ModelAndView exportUserInfo(ModelMap model,
                                       @RequestParam(value = "page", defaultValue = "1") Integer page,
                                       @RequestParam(value = "rows", defaultValue = "5") Integer rows) {
        EasyUIResult easyUIResult = this.restFulUserService.queryUserList(page, rows);
        model.put("userList", easyUIResult.getRows());
        UserExcelView viewExcel = new UserExcelView();
        return new ModelAndView(viewExcel, model);
    }
}
