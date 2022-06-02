package com.heldon.DTO;

import com.heldon.entity.Node;
import lombok.Data;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName NodeVo.java
 * @Description TODO
 * @createTime 2022年06月01日 09:19:00
 */
@Data
public class NodeDTO {

    private int netId;
    private String nodeName;
    private String id;
    private String text;
    private String color;
    private String borderColor;
    private String fontColor;
    private String content;
    private int x;
    private int y;
    private String url;
}
