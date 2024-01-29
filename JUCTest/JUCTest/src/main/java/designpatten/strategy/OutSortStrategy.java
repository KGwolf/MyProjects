package designpatten.strategy;

/**
 * @ClassName: OutSortStrategy
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/29 16:37
 * @Version: V1.0
 */
public class OutSortStrategy implements IStrategy{
    @Override
    public void sortStrategy() {
        System.out.println("外部排序。。。");
    }
}
