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
@TableName("signature")
@ApiModel(value = "签名表", description = "签名表")
public class SignatureEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "签名名称")
    private String name;
    @ApiModelProperty(value = "签名编码")
    private String code;
    @ApiModelProperty(value = "签名内容")
    private String content;
    @ApiModelProperty(value = "备注")
    private String remark;
}
