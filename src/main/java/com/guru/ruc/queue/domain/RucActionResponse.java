// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ActionResponse.java

package com.guru.ruc.queue.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RucActionResponse {

    private String message;
    private int code;
}
