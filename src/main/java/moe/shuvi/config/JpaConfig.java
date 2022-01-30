package moe.shuvi.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @ClassName JpaConfig
 * @Description TODO
 * @Author Administrator
 * @Date: 2022/1/6 11:07
 * @Version 1.0
 */
@Configuration
@EnableJpaRepositories(basePackages = "moe.shuvi.dao")
@EntityScan(basePackages = "moe.shuvi.model")
public class JpaConfig {

    /*
        Spring异常统一处理:
        这种方式和使用HibernateTemplate有的不同是它们对异常的处理。
        HibernateTemplate会将异常统一翻译成Spring的数据访问异常体系中的某个异常，
        而我们使用Hibernate上下文的Session时，抛出的就不是Spring的异常，
        而是HibernateException，如果我们还想看到Spring的异常体系，
        就需要做点设置，当然这也很简单。在DAO实现类上加@Respository注解，
        并且注册一个PersistenceExceptionTranslationPostProcessor实例即可
        */
    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
        return new PersistenceExceptionTranslationPostProcessor();
    }



}
