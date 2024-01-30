package designpatten.statusmachine.ifelse;

/**
 * @ClassName: Mario
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/30 17:15
 * @Version: V1.0
 */
public class Mario {
    private int points = 0;

    private MarioStatus marioStatus = MarioStatus.SmallMario;

    public int getPoints() {
        return points;
    }

    public MarioStatus getMarioStatus() {
        return marioStatus;
    }

    public void getSuper() {
        points += 100;
        marioStatus = MarioStatus.SuperMario;
    }

    public void getFire() {
        points += 200;
        marioStatus = MarioStatus.FireMario;
    }

    public void getCap() {
        points += 300;
        marioStatus = MarioStatus.CapMario;
    }

    public void getMonster() {
        if (marioStatus == MarioStatus.SmallMario){
//            points -= 100;
            marioStatus = MarioStatus.DeadMario;
        }else if (marioStatus == MarioStatus.SuperMario){
            points -= 100;
            marioStatus = MarioStatus.SmallMario;
        }else if (marioStatus == MarioStatus.FireMario){
            points -= 200;
            marioStatus = MarioStatus.SuperMario;
        }else if (marioStatus == MarioStatus.CapMario){
            points -= 300;
            marioStatus = MarioStatus.FireMario;
        }
    }
}
