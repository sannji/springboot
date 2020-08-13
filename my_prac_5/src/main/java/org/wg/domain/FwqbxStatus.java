package org.wg.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("报修工单信息")
public class FwqbxStatus {
    @ApiModelProperty("工单号")
    private String sn;
    @ApiModelProperty("机器SN")
    private String machineSn;
    @ApiModelProperty("工单标题")
    private String title;
    @ApiModelProperty("创建日期")
    private Date createdAt;
    @ApiModelProperty("更新日期")
    private Date updatedAt;
    @ApiModelProperty("下一环节处理人")
    private String nextUser;
    @ApiModelProperty("工单状态")
    private String statusName;
    @ApiModelProperty("新服务")
    private String service;
}
