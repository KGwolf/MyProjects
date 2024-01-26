package designpatten.birdge;

/**
 * @ClassName: NotifyDoctor2
 * @Description: 重构NotifyDoctor
 * @Author: xiahaitao
 * @Date: 2024/1/25 10:47
 * @Version: V1.0
 */
public class NotifyDoctor2 {
    private INotifyToDoctor notifyToDoctor;
    private IWarningType warningType;

    public NotifyDoctor2(INotifyToDoctor notifyToDoctor, IWarningType warningType) {
        this.notifyToDoctor = notifyToDoctor;
        this.warningType = warningType;
    }

    public void notifyTd() {//String notifyType,
        notifyToDoctor.notifyToDoctor(warningType);
    }

    public static void main(String[] args) {
        //即使这里还是有很多if else判断，但是if else里面的逻辑已经被抽离出去了。
        NotifyDoctor2 d = new NotifyDoctor2(new WeiXinNotify(), new HeiDengWarningType());
        d.notifyTd();
    }
}