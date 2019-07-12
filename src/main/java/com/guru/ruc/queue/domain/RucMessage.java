package com.guru.ruc.queue.domain;

import java.util.HashMap;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RucMessage {
	Object body;
	HashMap attributes;
}
