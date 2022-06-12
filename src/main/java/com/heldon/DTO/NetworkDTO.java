package com.heldon.DTO;

import com.heldon.entity.Network;
import com.heldon.entity.Node;
import com.heldon.entity.Relation;
import lombok.Data;

import java.util.List;


@Data
public class NetworkDTO {
    private int rootNodeId;
    private String netName;
    private List<Node> nodeList;
    private List<Relation> relationList;
}
