package com.heldon.DTO;

import lombok.Data;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName newRelationDTO.java
 * @Description TODO
 * @createTime 2022年06月03日 22:54:00
 */
@Data
public class NewRelationDTO {
    private Integer from;
    private Integer to;
    private String fontColor;
    private String lineShape;
    private String text;
    private Double lineWidth;
    private String color;
    private String edgeName;
    private String content;
    private int x;
    private int y;
}
