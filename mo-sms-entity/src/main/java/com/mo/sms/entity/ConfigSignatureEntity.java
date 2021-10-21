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
@TableName("config_signature")
@ApiModel(value = "配置—签名表", description = "配置—签名表")
public class ConfigSignatureEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "配置主键")
    private String configId;
    @ApiModelProperty(value = "签名主键")
    private String signatureId;
    @ApiModelProperty(value = "通道签名")
    private String configSignatureCode;
    @ApiModelProperty(value = "备注")
    private String remark;
}
