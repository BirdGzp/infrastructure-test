package com.moon.user.center.controller;

import com.moon.infrastructure.base.dto.BaseResponse;
import com.moon.user.center.po.UserDetail;
import com.moon.user.center.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: zhipeng gong
 * @Date: 2018/12/12 10:12
 * @Description:
 */
@RestController
@RequestMapping("/user/detail")
public class UserDetailController {
    @Autowired
    UserDetailService userDetailService;

    @ResponseBody
    @PostMapping("/get/full/{userId}")
    public BaseResponse getUserFullDetailByUserId(
            @PathVariable(name = "userId", required = false) Integer userId){
        return null;
    }

    @ResponseBody
    @PostMapping("/get/{userId}")
    public BaseResponse getUserDetailByUserId(
            @PathVariable(name = "userId", required = false) Integer userId){
        return null;
    }

    @ResponseBody
    @PostMapping("/update/batch/{listUserDetail}")
    public BaseResponse updateBatchUserDetail(
            @PathVariable(name = "listUserDetail", required = false) String listUserDetail){
        return null;
    }

    @ResponseBody
    @PostMapping("/update/{userDetail}")
    public BaseResponse updateUserDetail(@RequestBody UserDetail userDetail){
        return null;
    }

    @ResponseBody
    @PostMapping("/insert/{userDetail}")
    public BaseResponse insertUserDetail(@RequestBody UserDetail userDetail){
        return null;
    }

}
