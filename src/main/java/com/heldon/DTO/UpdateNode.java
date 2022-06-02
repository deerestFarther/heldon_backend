package com.heldon.DTO;

import lombok.Data;

@Data
public class UpdateNode {
    private String nodeName;
    private String id;
    private String text;
    private String color;
    private String borderColor;
    private String fontColor;
    private String content;
    private int nodeId;
    private int x;
    private int y;
    private String url;
}
