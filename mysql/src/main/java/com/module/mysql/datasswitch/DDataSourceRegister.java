package com.module.mysql.datasswitch;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName;
import org.springframework.boot.context.properties.source.ConfigurationPropertyNameAliases;
import org.springframework.boot.context.properties.source.ConfigurationPropertySource;
import org.springframework.boot.context.properties.source.MapConfigurationPropertySource;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据源注册类
 * 借由@Import(DynamicDataSourceRegister.class)启动Bean的注册流程
 */
public class DDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    private Environment evn;
    private Binder binder;
    private Map<String, DataSource> dataSources = new HashMap<>();

    private final static ConfigurationPropertyNameAliases aliases = new ConfigurationPropertyNameAliases();
    /**
     * 由于部分数据源配置不同，所以在此处添加别名，避免切换数据源出现某些参数无法注入的情况
     */
    static {
        aliases.addAliases("url", new String[]{"jdbc-url"});
        aliases.addAliases("username", new String[]{"user"});
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.evn = environment;
        binder = Binder.get(evn);
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        Map dsProperties1 = binder.bind("spring.datasource.pp-dai", Map.class).get();
        Class<? extends DataSource> clazz1 = getDataSourceType(evn.getProperty("spring.datasource.pp-dai.type"));
        DataSource dataSource1 = bind(clazz1, dsProperties1);
        String key1 = dsProperties1.get("key").toString();
        DDataSourceContextHolder.addDataSourceId(key1);
        dataSources.put(key1, dataSource1);
        System.out.println("PPDaiDB数据源注册成功");

        Map dsProperties2 = binder.bind("spring.datasource.movie", Map.class).get();
        Class<? extends DataSource> clazz2 = getDataSourceType(evn.getProperty("spring.datasource.movie.type"));
        DataSource dataSource2 = bind(clazz2, dsProperties2);
        String key2 = dsProperties2.get("key").toString();
        DDataSourceContextHolder.addDataSourceId(key2);
        dataSources.put(key2, dataSource2);
        System.out.println("MovieDB数据源注册成功");

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DynamicDataSource.class);
        MutablePropertyValues mpv = beanDefinition.getPropertyValues();
        mpv.add("targetDataSources", dataSources);
        registry.registerBeanDefinition("datasource", beanDefinition);
        System.out.println("注册数据源成功，一共注册数据源：" + dataSources.keySet().size() + "个");

        DDataSourceContextHolder.setDataSourceType("PPDaiDB");
    }

    private <T extends DataSource> T bind(Class<T> clazz, Map properties){
        ConfigurationPropertySource source = new MapConfigurationPropertySource(properties);
        Binder binder = new Binder(new ConfigurationPropertySource[]{source.withAliases(aliases)});
        return binder.bind(ConfigurationPropertyName.EMPTY, Bindable.of(clazz)).get();
    }

    private Class<? extends DataSource> getDataSourceType(String typeStr){
        Class<? extends DataSource> type;
        try{
            if (StringUtils.hasLength(typeStr))
                type = (Class<? extends DataSource>) Class.forName(typeStr);
            else
                type = DruidDataSource.class;
        } catch (Exception e){
            //无法通过反射获取class对象的情况则抛出异常，该情况一般是写错了，所以此次抛出一个runtimeException
            throw new IllegalArgumentException("can not resolve class with type: " + typeStr);
        }
        return type;
    }

}
