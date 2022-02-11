package moe.shuvi.service.impl;

import moe.shuvi.dao.DictionaryDao;
import moe.shuvi.model.Dictionary;
import moe.shuvi.service.DictionaryService;
import moe.shuvi.utils.JpaUtil;
import moe.shuvi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryDao dictionaryDao;


    /**
     * 带有多表查询
     * @param dictionary     搜索的参数
     * @param pageNow  分页的当前页
     * @param pageSize 分页的页数
     * @return 返回Result
     * @author qianjianyu
     */
    @Override
    public Result findByPage(Dictionary dictionary, int pageNow, int pageSize) throws Exception {
        Result result = new Result();
        PageRequest p = PageRequest.of(pageNow - 1, pageSize);
        //复杂查询的分装类
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues();
        Example<Dictionary> example = Example.of(dictionary, matcher);
        Page<Dictionary> all = dictionaryDao.findAll(example, p);
        if(all != null){
            result.setData(all);
            result.setMsg(Result.MSG_SUCCESS);
            result.setCode(Result.CODE_SUCCESS);
        }else {
            result.setMsg(Result.MSG_ERROR);
            result.setCode(Result.CODE_ERROR);
        }
        return result;
    }

    /**
     * 添加和修改公用一个方法,区别是有id则修改,无id则添加
     *
     * @param dictionary 添加或修改参数
     * @return 成功与否
     * @throws Exception
     * @author qianjianyu
     */
    @Transactional
    @Override
    public Result addOrUpdateDictionary(Dictionary dictionary) throws Exception {
        Result result = new Result();
        Dictionary save = null;
        if (dictionary.getId() != null){
            Optional<Dictionary> originalDictionary = dictionaryDao.findById(dictionary.getId());
            Dictionary newDictionary = originalDictionary.get();
            if(originalDictionary.isPresent()){
                JpaUtil.copyNotNullProperties(dictionary,newDictionary);
            }
            save = dictionaryDao.saveAndFlush(newDictionary);
        }else {
            save = dictionaryDao.saveAndFlush(dictionary);
        }

        //dictionaryDao.save
        if(save != null){
            result.setData(save);
            result.setCode(Result.CODE_SUCCESS);
            result.setMsg(Result.MSG_SUCCESS);
        } else {
            result.setMsg(Result.MSG_SUCCESS);
            result.setCode(Result.CODE_ERROR);
        }
        return result;
    }

    /**
     * @param id 删除参数,逻辑删除
     * @return 成功与否
     * @throws Exception
     * @author qianjianyu
     */
    @Transactional
    @Override
    public Result removeDictionaryById(int id) throws Exception {
        Result result = new Result();
        int i = dictionaryDao.deleteByDictionary(id);
        if (i > 0) {
            result.setData(i);
            result.setCode(Result.CODE_SUCCESS);
            result.setMsg(Result.MSG_SUCCESS);
        } else {
            result.setCode(Result.CODE_ERROR);
            result.setMsg(Result.MSG_ERROR);
        }
        return result;
    }
}
