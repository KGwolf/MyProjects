package com.xht.passpharmreview.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @Author: xiahaitao
 * @CreateTime: 2025-03-30  11:53
 * @Description: TODO
 * @Version: 1.0
 **/
public class TimeUtils {
    private static final DateTimeFormatter DATETIME_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static long calculateSecondsDiff(String targetTimeStr) {
        LocalDateTime targetTime = LocalDateTime.parse(targetTimeStr, DATETIME_FORMATTER);
        return Math.abs(ChronoUnit.SECONDS.between(LocalDateTime.now(), targetTime));
    }
}
