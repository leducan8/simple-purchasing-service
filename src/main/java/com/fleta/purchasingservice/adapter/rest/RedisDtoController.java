package com.fleta.purchasingservice.adapter.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Redis Controller - for DTO
 */
public abstract class RedisDtoController {

    protected Logger log;

    protected void setLoggerClass(Class<?> clazz) {
        log = LoggerFactory.getLogger(clazz);
    }
}
