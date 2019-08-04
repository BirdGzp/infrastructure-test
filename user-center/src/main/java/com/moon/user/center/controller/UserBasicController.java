package com.moon.user.center.controller;

import com.moon.infrastructure.base.dto.BaseObjectResponse;
import com.moon.infrastructure.base.dto.BaseResponse;
import com.moon.infrastructure.util.FastJsonUtil;
import com.moon.user.center.po.UserBasic;
import com.moon.user.center.service.UserBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/basic")
public class UserBasicController {

    @Value("${server.port}")
    private int port;

    @Autowired
    UserBasicService userBasicService;

    @ResponseBody
    @PostMapping("/list/full/{pageNum}/{pageSize}")
    public BaseResponse listFullUserBasic(
            @PathVariable(name = "pageNum", required = false) Integer pageNum,
            @PathVariable(name = "pageSize", required = false) Integer pageSize){
       return null;
    }

    @ResponseBody
    @PostMapping("/get/full/{userId}")
    public BaseResponse getUserFullBasicByUserId(
            @PathVariable(name = "userId", required = false) Integer userId){
        return null;
    }


    @ResponseBody
    @PostMapping("/get/brief/id/{userId}")
    public BaseResponse getUserBriefBasicByUserId(
            @PathVariable(name = "userId", required = false) Integer userId){
        BaseObjectResponse baseObjectResponse = new BaseObjectResponse();
        UserBasic userBasic =userBasicService.getUserBriefBasicByUserId(userId);
        System.out.println(userBasic);
        baseObjectResponse.setObject(userBasic);
        return baseObjectResponse;
    }

    @ResponseBody
    @PostMapping("/get/brief/telephone/{telephone}")
    public BaseResponse getUserBriefBasicByTelephone(
            @PathVariable(name = "telephone", required = false) String telephone){
        return null;
    }

    @ResponseBody
    @PostMapping("/get/check-info/telephone/{telephone}")
    public BaseResponse getCheckInfoByTelephone(
            @PathVariable(name = "telephone", required = false) String telephone){
        return null;
    }

    @ResponseBody
    @PostMapping("/get/check-info/email/{email}")
    public BaseResponse getCheckInfoByEmail(
            @PathVariable(name = "email", required = false) String email){
        return null;
    }


    @ResponseBody
    @PostMapping("/update")
    public BaseResponse updateUserBasic(@RequestBody UserBasic userBasic){
        return null;
    }


    @ResponseBody
    @PostMapping("/insert")
    public BaseResponse insertUserBasic(@RequestBody UserBasic userBasic){
        return null;
    }

    @PostMapping("/get/check-result/{accountId}/{ip}")
    public BaseResponse getPasswordCheckResult(@PathVariable(name = "accountId")String accountId, @RequestBody String password, @PathVariable(name = "ip") String ip){
        return null;
    }


}