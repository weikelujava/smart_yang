# smart_yang
The name of the repository comes from a boy named Yang
    
## **Canal**
    - 支持Canal监听MySql Binlog日志并同步数据到Elasticsearch
    - Remark:
        - 搭建zookeerper (version:Windows 8.1)
        - 搭建Canal (version:)
        - 搭建Elasticsearch (version:7.6.2)
     
    - Question with create:
        - elasticsearch this is not a http port
           elastic search默认tcp端口9300，http端口9200,看下Es配置的端口
        - defined in @EnableElasticsearchRepositories declared on ElasticsearchRepositoriesRegistrar
           1.使用 spring-boot-starter-data-elasticsearch pom依赖
           2.在启动类添加注解@EnableElasticsearchRepositories(basePackages = “xxx.xxx.xxx”)
        - Springboot整合Elasticsearch中配置 spring-data-elasticsearch cluster-nodes和cluster-name配置过时Deprecated？
           1.使用 spring-boot-starter-data-elasticsearch pom依赖
           2.使用 官方建议的 High Level REST Client实现
