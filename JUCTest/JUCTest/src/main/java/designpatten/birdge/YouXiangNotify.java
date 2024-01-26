package designpatten.birdge;

/**
 * @ClassName: YouXiangNotify
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/25 10:45
 * @Version: V1.0
 */
public class YouXiangNotify implements INotifyToDoctor{
    @Override
    public void notifyToDoctor(IWarningType warningType) {
        warningType.applyWarningType();
        System.out.println("邮箱通知医生");
    }
}
