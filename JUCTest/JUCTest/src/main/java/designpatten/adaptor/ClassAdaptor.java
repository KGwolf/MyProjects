package designpatten.adaptor;

/**
 * @ClassName: ClassAdaptor
 * @Description: 供我们自己系统内部使用的接口实现类
 * @Author: xiahaitao
 * @Date: 2024/1/26 14:41
 * @Version: V1.0
 */
public class ClassAdaptor implements IAdaptor {
    private OldMyClass oldMyClass;

    /***
     * @param oldMyClass
     * @return
     * @Description 构造方法
     * 因为OldMyClass的方法这个案例被定义成了静态方法，所以没有用到这个私有变量
     * @Author xiahaitao
     * @Date 2024/1/26 15:43
     */
    public ClassAdaptor(OldMyClass oldMyClass) {
        this.oldMyClass = oldMyClass;
    }

    /***
     * @param
     * @return java.lang.String
     * @Description 这里调用方法：方法名字可以不一样，返回值可以不一样。
     * @Author xiahaitao
     * @Date 2024/1/26 15:43
     */
    @Override
    public String read() {
        String s = OldMyClass.readFromOld();
        //这里可以做参数转换，xml转json等
        return "";
    }

    @Override
    public String write() {
        String s = OldMyClass.readFromOld();
        //这里可以做参数转换，xml转json等
        return "";
    }
}
