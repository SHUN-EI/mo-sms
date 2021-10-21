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
@TableName("black_list")
@ApiModel(value = "黑名单", description = "黑名单")
public class BlackListEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("类型：1短信、2邮件、3微信")
    private String type;
    @ApiModelProperty("内容：手机号")
    private String content;
    @ApiModelProperty("备注")
    private String remark;
}
