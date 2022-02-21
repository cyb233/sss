package moe.shuvi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import moe.shuvi.log.LogAnnotation;
import moe.shuvi.model.Dictionary;
import moe.shuvi.service.DictionaryService;
import moe.shuvi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "DictionaryController",description = "数据字典管理汇总",tags = "DictionaryController")
@RestController
@RequestMapping("/dict")
//跨域允许
@CrossOrigin(origins = {"http://localhost:9528/","https://web.shuvi.moe"}, allowCredentials = "true")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNow", value = "当前页", required = true ,dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "当页容量", required = true ,dataType = "int")
    })
    @LogAnnotation(title = "数据字典模块",action = "数据字典查询")
    @RequestMapping("/page")
    public Result findAll(@RequestBody Dictionary dictionary) throws Exception{
        Result result = dictionaryService.findByPage(dictionary, dictionary.getPageNow(), dictionary.getPageSize());
        return result;
    }

    @LogAnnotation(title = "数据字典模块",action = "添加数据字典")
    @RequestMapping("/addDict")
    public Result add(@RequestBody Dictionary dictionary)throws Exception{
        Result result = dictionaryService.addOrUpdateDictionary(dictionary);
        return result;
    }

    @LogAnnotation(title = "数据字典模块",action = "数据字典删除")
    @RequestMapping("/remove")
    public Result removeById(@RequestParam int id)throws Exception{
        Result result = dictionaryService.removeDictionaryById(id);
        return result;
    }

    @LogAnnotation(title = "数据字典模块",action = "数据字典修改")
    @RequestMapping("/update")
    public Result modify(@RequestBody Dictionary dictionary)throws Exception{
        Result result = dictionaryService.addOrUpdateDictionary(dictionary);
        return result;
    }
}
