package designpatten.statusmachine.statusmachine;

/**
 * @ClassName: SuperMario
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/31 9:45
 * @Version: V1.0
 */
public class SuperMario implements IStatusEvent {

    private Mario mario;

    public SuperMario(Mario mario) {
        this.mario = mario;
    }

    @Override
    public MarioStatus getName() {
        return MarioStatus.SuperMario;
    }

    @Override
    public void getSuper() {
        //需要分数字段，需要名称，怎么操作？继承？组合？
        mario.setPoints(mario.getPoints()+100);
//        mario.setMarioStatus();
    }

    @Override
    public void getFire() {
        mario.setPoints(mario.getPoints()+200);
    }

    @Override
    public void getCap() {
        mario.setPoints(mario.getPoints()+300);
    }

    @Override
    public void getMonster() {
        mario.setPoints(mario.getPoints()-100);
    }
}
