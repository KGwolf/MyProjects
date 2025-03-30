package com.xht.passpharmreview.model.screen.cachemodel;

import lombok.Data;

/**
 * @ClassName: TaskCacheModel
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/28 15:50
 * @Version: V1.0
 */
@Data
public class TaskListCacheModel {

    private Long taskId;

    private int mHisCode;

    private int userId;

    private String startTime;

    private String checkDataTime;

    private int slcode;

    private int status;

    private String prescno;

    private String patientName;

    private int doctorId;

    /**
     * 倒计时剩下多少秒
     **/
    private int remainTime;
}
