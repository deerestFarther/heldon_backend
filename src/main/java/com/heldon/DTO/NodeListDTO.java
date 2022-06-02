package com.heldon.DTO;

import com.heldon.entity.Node;
import lombok.Data;

import javax.swing.*;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName NodeListVo.java
 * @Description TODO
 * @createTime 2022年06月01日 09:58:00
 */
@Data
public class NodeListDTO {

    private int NetId;
    private List<UpdateNode> nodeDTOList;
}

