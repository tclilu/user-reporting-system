package com.sw.urs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1",produces = "application/json;charset=UTF-8")
public class BaseController {

    /**
     * API版本
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Map<String,String> index() {
        Map<String,String> map = new HashMap<>();
        map.put("version","1.0.1");
        return map;
    }
}
