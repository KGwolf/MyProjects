package designpatten.command;

/**
 * @ClassName: Caculate
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/2/2 14:54
 * @Version: V1.0
 */
public class Caculate implements ICommand{
    @Override
    public void excute() {
        System.out.println("计算值");
    }
}
