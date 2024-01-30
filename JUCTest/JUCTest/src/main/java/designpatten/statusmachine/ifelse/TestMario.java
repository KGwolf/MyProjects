package designpatten.statusmachine.ifelse;

/**
 * @ClassName: TestMario
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/30 17:26
 * @Version: V1.0
 */
public class TestMario {
    public static void main(String[] args) {
        Mario mario = new Mario();
        mario.getMonster();

        System.out.println("分数："+mario.getPoints()+"状态："+mario.getMarioStatus().toString());
    }
}
