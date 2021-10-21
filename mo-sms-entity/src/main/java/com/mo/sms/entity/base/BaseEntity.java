package com.mo.sms.entity.base;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by mo on 2021/10/21
 */
@Data
public abstract class BaseEntity implements Serializable {

    @TableId
    @ApiModelProperty(value = "主键")
    private String id;
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;
    @ApiModelProperty(value = "创建人")
    private String createUser = "0";
    @ApiModelProperty(value = "修改人")
    private String updateUser;
    @ApiModelProperty(value = "逻辑删除：0-删除")
    private Integer isDelete;
}
