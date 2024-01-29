package designpatten.template.callback;

/**
 * @ClassName: BClass
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/29 11:14
 * @Version: V1.0
 */
public class BClass {
    private ICallBack callBack1;
    /***
     * @param callBack
     * @return void
     * @Description 这里的方法参数，也可以放到一个private变量里面吧？
     * @Author xiahaitao
     * @Date 2024/1/29 11:16
     */
    public void callbackA(ICallBack callBack) {
        callBack1 = callBack;
        //做一些其它的事。。。。

        //调用A类里面设置过来的回调,这里的调用也可以在其它的地方调用
        callBack.callbackMethod();
    }
}
