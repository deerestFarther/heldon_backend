package com.heldon.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel()
@Data
@Accessors(chain = true)
public class TagAdd {
    private int targetId;
    private int tagType;
    private int tagId;
}
