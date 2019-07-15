package com.guru.ruc.queue.domain;

import com.huawei.openstack4j.openstack.message.queue.constant.ConsumeStatus;

import lombok.Data;
@Data
public class RucConsumeConfirm
{
    private String handler;
    private ConsumeStatus  status;
}
