import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: OOPClass
 * @Description: 这就是我们平时用的类定义，其实就是面向过程的风格，跟定义成public其实没区别了，这里面存在一些问题：
 * 1.totalAccount的值可能跟accountName的实际数量不一致。
 * 2.totalMoney应该是私有的数据，根据面向对象的封装特性，应该额外提供方法来给外界调用（increaseTotalMoney(),decreaseTotalMoney()），
 * 在方法里面还可以做一些额外的逻辑判断，比如权限等等。
 * 3.accountName这个集合值，首先不应该提供setter方法，其次，提供getter方法之后，外界拿到了之后可能对其进行修改，或者clear()，很危险。
 * 那这时可以改成Collections.unmodifiableList()，改了之后，还有个问题，外界拿到集合之后，如果元素是对象，修改对象的某个属性怎么办？
 * @Author: xiahaitao
 * @Date: 2024/1/16 11:01
 * @Version: V1.0
 */
@Data
public class OOPClass {
    private String name;
    private int age;
    private List<String> accountName;
//    private List<String> getAccountName(){
//        return Collections.unmodifiableList(accountName);
//    }
    private int totalAccount;
    private int totalMoney;
}
