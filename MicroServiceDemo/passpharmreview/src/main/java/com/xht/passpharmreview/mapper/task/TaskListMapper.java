package com.xht.passpharmreview.mapper.task;

import com.xht.passpharmreview.model.screen.cachemodel.TaskListCacheModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @Author: xiahaitao
 * @CreateTime: 2025-03-29  18:54
 * @Description: TODO
 * @Version: 1.0
 **/
@Mapper
public interface TaskListMapper {
    @Select("SELECT * FROM clinic_task_info WHERE taskid = #{taskId}")
    TaskListCacheModel getTaskList(Long taskId);

    @Insert("INSERT INTO clinic_task_info(taskid, mhiscode, userid, starttime, checkdatetime, slcode, " +
            "status, prescno, patientname, doctorid) " +
            "VALUES(#{taskId}, #{mHisCode}, #{userId}, #{startTime}, #{checkDataTime}, #{slcode}, #{status}," +
            " #{prescno}, #{patientName}, #{doctorId})")
    void addTaskList(TaskListCacheModel taskListModel);

    @Update("UPDATE clinic_task_info SET status=#{status},userid=#{userId},starttime=#{startTime},remaintime=#{remainTime} WHERE taskid=#{taskId}")
    void updateTaskList(TaskListCacheModel taskListModel);

}
