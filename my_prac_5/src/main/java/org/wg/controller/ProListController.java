package org.wg.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wg.domain.FwqbxStatus;
import org.wg.mapper.ProStatusMapper;

import java.util.List;

@RestController
@Api("进行中的报修工单列表")
@RequestMapping("/fwqbx")
public class ProListController {
    @Autowired
    ProStatusMapper proStatusMapper;
    @ApiOperation("未完成的报修单")
    @GetMapping("/prolist")
    public List<FwqbxStatus> getProList() {
        return proStatusMapper.getFwqbxList();
    }
}
