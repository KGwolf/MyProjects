package com.xht.passpharmreview.model.screen.cachemodel;

import com.xht.passpharmreview.model.screen.inputmodel.JsonDataModel;
import com.xht.passpharmreview.model.screen.outputmodel.ScreenResultOutput;
import lombok.Data;

/**
 * @Author: xiahaitao
 * @CreateTime: 2025-03-29  08:41
 * @Description: TODO
 * @Version: 1.0
 **/
@Data
public class TaskAllCacheModel {

    private Long taskId;

    private String verCaseId;

    private TaskListCacheModel taskListCacheModel;

    private JsonDataModel jsonDataModel;

    private ScreenResultOutput screenResultOutputModel;
//    private
}
