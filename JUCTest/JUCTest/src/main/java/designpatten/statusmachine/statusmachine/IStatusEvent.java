package designpatten.statusmachine.statusmachine;

/**
 * @ClassName: IStatus
 * @Description: 抽象出来 触发的事件
 * @Author: xiahaitao
 * @Date: 2024/1/30 17:32
 * @Version: V1.0
 */
public interface IStatusEvent {
    MarioStatus getName();
    void getSuper();
    void getFire();
    void getCap();
    void getMonster();
}
