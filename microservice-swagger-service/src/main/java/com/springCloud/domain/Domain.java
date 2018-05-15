package com.springCloud.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Joeysin on 2018/5/14.
 */
@Data
@ApiModel(description = "Object Domain")
public class Domain {

    @ApiModelProperty(value = "主键", required = true, example = "1")
    private Long id;

    @ApiModelProperty(value = "描述", required = true, example = "默认值")
    private String desc;
}
