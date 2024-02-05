package designpatten.statusmachine.statusmachine;

/**
 * @ClassName: Mario
 * @Description: 提供给外部的状态机类。
 * @Author: xiahaitao
 * @Date: 2024/1/30 17:15
 * @Version: V1.0
 */
public class Mario {
    private  IStatusEvent statusEvent;

    public Mario(IStatusEvent statusEvent){
        this.statusEvent = statusEvent;
    }
    private int points = 0;

    public int getPoints() {
        return points;
    }

    public MarioStatus getMarioStatus() {
        return statusEvent.getName();
    }
    public void setMarioStatus(IStatusEvent statusEvent) {
        this.statusEvent = statusEvent;
    }
    public void setPoints(int points) {
        this.points = points;
    }

    public void getSuper() {
        statusEvent.getSuper();
    }

    public void getFire() {
        statusEvent.getFire();
    }

    public void getCap() {
        statusEvent.getCap();
    }

    public void getMonster() {
        statusEvent.getMonster();
    }
}
