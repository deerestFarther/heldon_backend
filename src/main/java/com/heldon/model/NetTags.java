package com.heldon.model;

import com.heldon.entity.UserTag;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel(value = "返回关系网tag相关信息")
@Data
@Accessors(chain = true)
public class NetTags  {
    @ApiModelProperty(value = "关系网id")
    private int targetId;
    @ApiModelProperty(value = "标签id")
    private int tagId;
    private String tagName;
    @ApiModelProperty(value = "中间表主键id")
    private int taggingId;
}
