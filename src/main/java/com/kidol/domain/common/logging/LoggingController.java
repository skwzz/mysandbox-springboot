package com.kidol.domain.common.logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 테스트용임
@Slf4j
@RestController
public class LoggingController {

    @GetMapping("/logging")
    public String logging(){
        log.error("ERROR");
        log.warn("WARN");
        log.info("INFO");
        log.debug("DEBUG");
        log.trace("TRACE");
        return "로그레벨 테스트중...";
    }
}
