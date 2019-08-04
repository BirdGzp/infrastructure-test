package com.moon.user.center.controller;

import com.moon.infrastructure.base.dto.BaseObjectResponse;
import com.moon.infrastructure.base.dto.BaseResponse;
import com.moon.user.center.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: zhipeng gong
 * @Date: 2018/12/12 10:16
 * @Description:
 */
@RestController
@RequestMapping("/relation")
public class RelationController {
    @Autowired
    RelationService relationService;

    @ResponseBody
    @PostMapping("/list/user/{userId}/{pageNum}/{pageSize}")
    public BaseResponse listRelationByUserId(
            @PathVariable(name = "userId", required = false) Integer userId,
            @PathVariable(name = "pageNum", required = false) Integer pageNum,
            @PathVariable(name = "pageSize", required = false) Integer pageSize){
        BaseObjectResponse baseObjectResponse = new BaseObjectResponse();


       return baseObjectResponse;
    }

    @ResponseBody
    @PostMapping("/list/follow/{followId}/{pageNum}/{pageSize}")
    public BaseResponse listRelationByFollowId(
            @PathVariable(name = "followId", required = false) Integer followId,
            @PathVariable(name = "pageNum", required = false) Integer pageNum,
            @PathVariable(name = "pageSize", required = false) Integer pageSize){
        return null;
    }

    @ResponseBody
    @PostMapping("/update/batch/{relationList}")
    public BaseResponse updateBatchRelationDeleteState(
            @PathVariable(name = "relationList", required = false) String relationList){
        return null;
    }

    @ResponseBody
    @PostMapping("/update/{relation}")
    public BaseResponse updateRelationDeleteState(
            @PathVariable(name = "relation", required = false) String relation){
        return null;
    }

    @ResponseBody
    @PostMapping("/insert/batch/{relationList}")
    public BaseResponse insertBatchRelation(
            @PathVariable(name = "relationList", required = false) String relationList){
        return null;
     }

    @ResponseBody
    @PostMapping("/insert/{relation}")
    public BaseResponse insertRelation(
            @PathVariable(name = "relation", required = false) String relation){
        return null;
    }
}
