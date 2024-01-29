package designpatten.template;

/**
 * @ClassName: ScreenTask
 * @Description: 模版方法抽象类
 * @Author: xiahaitao
 * @Date: 2024/1/29 9:50
 * @Version: V1.0
 */
public abstract class ScreenTask {
    public void screenHisTask(String taskJson){
        //1.调用core审查
       String resCode =  doPassCoreScreen();
        //2.调用pr过滤
        doPrSettingFilter();
    }
    private String doPassCoreScreen(){
        return "审查结果";
    }
    public abstract void doPrSettingFilter();
}
