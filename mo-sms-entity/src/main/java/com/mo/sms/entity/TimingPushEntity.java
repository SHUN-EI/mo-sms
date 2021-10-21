package com.mo.sms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mo.sms.entity.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by mo on 2021/10/21
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@TableName("timing_push")
@ApiModel(value = "定时发送", description = "定时发送")
public class TimingPushEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("模板")
    private String template;
    @ApiModelProperty("签名")
    private String signature;
    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("参数json")
    private String request;
    @ApiModelProperty("状态 0:未处理 1:已处理")
    private Integer status;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("发送时间")
    private String timing;
}
