package com.moon.infrastructure.base.resp;

public class BaseResp implements RespCode
{
	String code;
	String desc;
	private BaseResp(String code, String desc)
	{
		this.code = code;
		this.desc = desc;
	}

	public final static BaseResp SUCCESS = new BaseResp("000000", "操作成功");
	public final static BaseResp PARAM_ILLEGAL = new BaseResp("990001", "参数异常");
	public final static BaseResp PARAM_OBJECT_IS_NULL = new BaseResp("990002", "参数对象为空");
	public final static BaseResp PARAM_IS_NULL = new BaseResp("990003", "参数为空");
	public final static BaseResp OPERATION_ILLEGAL = new BaseResp("990004", "网络繁忙, 请稍后再试");
	public final static BaseResp DUBBO_ABNORMAL = new BaseResp("990005", "接口处理异常, 请稍后再试");
	public final static BaseResp SYSTEM_ERROR = new BaseResp("990006", "系统异常, 请稍后再试");
	public final static BaseResp STATE_ILLEGAL = new BaseResp("990007", "状态异常, 请稍后再试");
	public final static BaseResp BUSINESS_EXCEPTION = new BaseResp("990008", "业务处理异常, 请稍后再试");
	public final static BaseResp NET_CONNECTION_EXCEPTION = new BaseResp("990009", "业务处理异常, 请稍后再试");
	public final static BaseResp PARAM_TYPE_NOT_SUPPORT = new BaseResp("990010", "参数类型不支持");
	public final static BaseResp REDIS_OPERATION_ERROR = new BaseResp("990011", "redis操作异常");


	public String getSpecialDesc(String specialMsg)
	{
		return this.getDesc() + "[" + specialMsg + "]";
	}

	/** 获取返回码 */
	@Override
	public String getCode()
	{
		return code;
	}

	/** 获取描述信息 */
	@Override
	public String getDesc()
	{
		return desc;
	}
}
