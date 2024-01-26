package designpatten.birdge;

/**
 * @ClassName: NotifyDoctor2
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/25 10:38
 * @Version: V1.0
 */
public class WeiXinNotify implements INotifyToDoctor{
    @Override
    public void notifyToDoctor(IWarningType warningType) {
        warningType.applyWarningType();
        System.out.println("微信通知医生");
    }
}
