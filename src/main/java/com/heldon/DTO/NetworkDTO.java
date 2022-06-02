package com.heldon.DTO;

import com.heldon.entity.Network;
import com.heldon.entity.Node;
import com.heldon.entity.Relation;
import lombok.Data;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName NetworkVo.java
 * @Description TODO
 * @createTime 2022年06月01日 10:19:00
 */
@Data
public class NetworkDTO {
    private int rootNodeId;
    private String netName;
    private List<Node> nodeList;
    private List<Relation> relationList;



}
