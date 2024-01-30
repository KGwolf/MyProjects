package designpatten.responsiblechain.doallhandler;

/**
 * @ClassName: MyChainOld
 * @Description: 业务逻辑进行处理，非责任链模式
 * 责任链有2中：执行完1个之后就不继续执行后面的了。还有一种是都会执行。
 * 对下面这种流程做优化：
 * 1.先对4个步骤做抽象，提取一个抽象类（这里不好用接口，因为有属性）。
 * 2.要做到链式传递，需要再来一个上帝类，来组合链式。提供给客户端使用。
 * @Author: xiahaitao
 * @Date: 2024/1/30 9:33
 * @Version: V1.0
 */
public class MyChainOld {
    public void doScreen(String jsonStr){
        //1.对json做解密

        //2.对json做过滤

        //3.对json做重新处理赋值，补充信息串

        //4.对过期药品、作废  进行删除

    }
}
