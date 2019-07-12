// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ConsumeConfirmResponse.java

package com.guru.ruc.queue.domain;

import lombok.Data;

@Data
public class RucConsumeConfirmResponse {
	private Integer success;
	private Integer fail;
}
