package moe.shuvi.service;


import moe.shuvi.model.Log;
import moe.shuvi.utils.Result;

public interface LogService {
    Result addLog(Log log) throws Exception;

    Result findPage(int pageNow,int pageSize) throws Exception;

}
