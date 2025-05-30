package com.xht.distributeuqid.leaf.leafcore;


import com.xht.distributeuqid.leaf.leafcore.common.Result;

public interface IDGen {
    Result get(String key);
    boolean init();
}
