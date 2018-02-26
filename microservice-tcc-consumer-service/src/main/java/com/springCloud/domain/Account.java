package com.springCloud.domain;

import lombok.Data;

@Data
public class Account {

    private String acctId;
    private String amount;
    private String frozen;
}
