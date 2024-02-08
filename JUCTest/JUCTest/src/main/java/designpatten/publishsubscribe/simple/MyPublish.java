package designpatten.publishsubscribe.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MyPublish
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/2/8 14:27
 * @Version: V1.0
 */
public class MyPublish {
    private List<ISubscribe> subscribeList = new ArrayList<>();

    public void addSubscribe(ISubscribe subscribe){
        subscribeList.add(subscribe);
    }

    public void notifySubscribes(){
        for (ISubscribe iSubscribe : subscribeList) {
            iSubscribe.exec();
        }
    }
}
