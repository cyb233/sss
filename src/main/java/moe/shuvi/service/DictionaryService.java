package moe.shuvi.service;

import moe.shuvi.model.Dictionary;
import moe.shuvi.utils.Result;

public interface DictionaryService {

    Result findByPage(Dictionary dictionary, int pageNow, int pageSize) throws Exception;

    Result addOrUpdateDictionary(Dictionary dictionary) throws Exception;

    Result removeDictionaryById(int id) throws Exception;

}
