package designpatten.birdge;

/**
 * @ClassName: HeiDengWarningType
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/25 11:25
 * @Version: V1.0
 */
public class HeiDengWarningType  implements IWarningType{
    @Override
    public void applyWarningType() {
        System.out.println("黑灯");
    }
}
