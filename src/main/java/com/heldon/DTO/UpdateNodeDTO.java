package com.heldon.DTO;

import lombok.Data;

@Data
public class UpdateNodeDTO {
    private int nodeId;
    private String nodeName;
    private String id;
    private String text;
    private String color;
    private String borderColor;
    private String fontColor;
    private String content;
    private String url;
}
