package com.heldon.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel
public class UserChange {
    private String nickname;
    private String avatar;
    private String ext3;
    @ApiModelProperty(required = true)
    private Long userId;
}
