package moe.shuvi.config;

import moe.shuvi.utils.JwtConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class WebmvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sy.controller"))//扫描相关controller接口
                .paths(PathSelectors.any())
                .build().globalOperationParameters(getList());
    }

    //在页面上显示token,并向服务器提交头信息
    private List<Parameter> getList(){
        ParameterBuilder builder = new ParameterBuilder();

        builder.name(JwtConstant.ACCESS_TOKEN).description("token").modelRef(new ModelRef("string")).parameterType("header").required(false);
        Parameter build = builder.build();
        List<Parameter> parameters = Arrays.asList(build);
        return parameters;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springData项目 RESTful APIs")//文档标题
                .description("springData项目后台api接口文档")//文档描述
                .version("1.0")//文档版本
                .build();
    }

}
