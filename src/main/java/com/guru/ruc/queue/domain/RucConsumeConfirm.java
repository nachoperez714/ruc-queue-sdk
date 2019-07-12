// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConsumeConfirm.java

package com.guru.ruc.queue.domain;

import com.huawei.openstack4j.openstack.message.queue.constant.ConsumeStatus;

import lombok.Data;
@Data
public class RucConsumeConfirm
{
    private String handler;
    private ConsumeStatus status;
}
