package org.wg.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.wg.domain.FwqbxStatus;

import java.util.List;
@Mapper
public interface ProStatusMapper {
    public List<FwqbxStatus> getFwqbxList();
}
