package com.moon.infrastructure.base.dto;

import lombok.Data;

@Data
public class BaseObjectResponse extends BaseResponse{
    private Object object;

    public BaseObjectResponse() {
        success = true;
    }
}
