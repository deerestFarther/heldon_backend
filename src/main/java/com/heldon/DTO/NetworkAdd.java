package com.heldon.DTO;

import lombok.Data;


@Data
public class NetworkAdd {
    private long userId;
    private int tagId;
    private String netName;
    private String url;
}
