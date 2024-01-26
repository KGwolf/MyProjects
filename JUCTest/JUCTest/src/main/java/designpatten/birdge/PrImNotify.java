package designpatten.birdge;

/**
 * @ClassName: PrImNotify
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/25 10:46
 * @Version: V1.0
 */
public class PrImNotify implements INotifyToDoctor{
    @Override
    public void notifyToDoctor(IWarningType warningType) {
        System.out.println("Pr的IM通知医生");
    }
}
