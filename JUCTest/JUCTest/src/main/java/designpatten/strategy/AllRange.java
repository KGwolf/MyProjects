package designpatten.strategy;

/**
 * @ClassName: AllRange
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/29 17:01
 * @Version: V1.0
 */
public class AllRange {

    public int low;

    public int height;

    public IStrategy strategy;

    public AllRange(int low, int height, IStrategy strategy) {
        this.low = low;
        this.height = height;
        this.strategy = strategy;
    }
}
