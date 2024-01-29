package designpatten.strategy;

/**
 * @ClassName: MySortOld
 * @Description: 第一版本的排序
 * 策略模式解耦的是：策略的定义、创建、使用。
 * 首先跟if else无关。
 * 第一，因为每个算法的代码量很大,分支里面的代码内容很多，很复杂。
 * 首先想到的就是提取单独的private方法。这样if else 里面东西就一行了。
 *      这样也有问题，首先，这个类会变得很长，其次，这些算法不能被复用。
 * 那么继续优化，每一个算法单独提取到1个类里面。然后再分支里面进行new 操作。这是解耦策略的定义
 * 前面说了，还要解耦创建和使用，所以继续优化，使用工厂来解耦策略的创建。
 *      这里使用工厂模式：
 *          满足无状态：可以使用静态工厂+hashmap的方式来消除if else。
 *          不满足，只能用if else来 new 对象
 *              这里怎么优化呢？通过反射来创建对象即可。
 * 如果使用类的判断if else 不多的话，这里就可以优化结束了。
 * 如果有洁癖，还可以用静态代码块+hashmap来进行去if else。
 * @Author: xiahaitao
 * @Date: 2024/1/29 15:42
 * @Version: V1.0
 */
public class MySortOld {
    public void mySortOld(int fileSize){
        IStrategy strategy = null;
        if (fileSize <= 10){
            //文件小于10M，快速排序
//            QuicklySortStrategy quicklySortStrategy = new QuicklySortStrategy();
//            quicklySortStrategy.sortStrategy();

            strategy = new QuicklySortStrategy();
        }else if(fileSize > 10 && fileSize <= 100){
            //文件大于10M，小于100M，外部排序
//            OutSortStrategy outSortStrategy = new OutSortStrategy();
//            outSortStrategy.sortStrategy();

            strategy = new OutSortStrategy();
        }else if(fileSize > 100 && fileSize <= 1000){
            //文件大于100M，小于1000M，并发排序
//            ConcurrentSortStrategy concurrentSortStrategy = new ConcurrentSortStrategy();
//            concurrentSortStrategy.sortStrategy();

            strategy = new ConcurrentSortStrategy();
        }else if(fileSize > 1000 && fileSize <= 10000){
            //文件大于1000M，小于10000M，MapReduce排序
//            MapReduceSortStrategy mapReduceSortStrategy = new MapReduceSortStrategy();
//            mapReduceSortStrategy.sortStrategy();

            strategy = new MapReduceSortStrategy();
        }

        strategy.sortStrategy();
    }

    public static void main(String[] args) {

    }
}
