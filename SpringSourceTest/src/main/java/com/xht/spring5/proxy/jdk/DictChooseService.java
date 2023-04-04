package com.xht.spring5.proxy.jdk;

import java.util.List;

/**
 * @ClassName: DictChooseService
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2023/4/3 9:15
 * @Version: V1.0
 */
public interface DictChooseService {
    List<String> findDepts(String funCode);
    List<String> findHosps(String funCode);
    List<String> findDoctors(String funCode);
    List<String> findPharmas(String funCode);
}
