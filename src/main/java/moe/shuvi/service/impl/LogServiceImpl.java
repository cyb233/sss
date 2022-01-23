package moe.shuvi.service.impl;

import moe.shuvi.dao.LogDao;
import moe.shuvi.model.Log;
import moe.shuvi.service.LogService;
import moe.shuvi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional(readOnly = true)
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao LogDao;
    @Transactional
    @Override
    public Result addLog(Log log) throws Exception {
        Log save = LogDao.saveAndFlush(log);
        Result result = new Result();
        if(save.getId() != null){
            result.setCode(Result.CODE_SUCCESS);
            result.setMsg(Result.MSG_SUCCESS);
        }else{
            result.setCode(Result.CODE_ERROR);
            result.setMsg(Result.MSG_ERROR);
        }
        return result;
    }

    @Override
    public Result findPage(int pageNow, int pageSize) throws Exception {
        PageRequest p = PageRequest.of((pageNow - 1)*pageSize, pageSize);
        Page<Log> all = LogDao.findAll(p);
        Result result = new Result();
        result.setCode(Result.CODE_SUCCESS);
        result.setMsg(Result.MSG_SUCCESS);
        result.setData(all.getContent());
        return result;
    }
}
