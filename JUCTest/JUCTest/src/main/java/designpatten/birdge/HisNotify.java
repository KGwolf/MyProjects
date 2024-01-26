package designpatten.birdge;

/**
 * @ClassName: HisNotify
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/25 10:46
 * @Version: V1.0
 */
public class HisNotify implements INotifyToDoctor{
    @Override
    public void notifyToDoctor(IWarningType warningType) {
        System.out.println("His通知医生");
    }
}
