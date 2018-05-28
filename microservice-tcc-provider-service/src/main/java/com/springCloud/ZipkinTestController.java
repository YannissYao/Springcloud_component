package com.springCloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Joeysin on 2018/3/2.
 */
@RestController
@Slf4j
public class ZipkinTestController {
    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public int get() {
        log.info("recive routing ...........");
        return 1;
    }
}
