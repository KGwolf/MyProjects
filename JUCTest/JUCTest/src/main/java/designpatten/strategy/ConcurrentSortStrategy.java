package designpatten.strategy;

/**
 * @ClassName: ConcurrentSortStrategy
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/29 16:38
 * @Version: V1.0
 */
public class ConcurrentSortStrategy implements IStrategy{
    @Override
    public void sortStrategy() {
        System.out.println("并发排序。。。");
    }
}
