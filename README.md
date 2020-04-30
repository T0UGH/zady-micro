# zady-micro
基于SpringCloudAlibaba的敏捷项目协作平台

1. 注册中心-nacos[ok]

2. 配置中心-nacos[ok]

3. 接口openFeign[ok]

4. 熔断器-sentinel[ok]

5. 路由网关-gateway[ok]

   1. 匹配多个路径：详见`gateway`中的

      ```yml
      predicates:
      - Path=/user/**,/role/**
      ```

6. 分布式事务-seata[doing]

   1. <https://github.com/seata/seata-samples/tree/master/springcloud-nacos-seata>
   2. <https://juejin.im/post/5bf201f7f265da610f63528a>
   3. http://seata.io/zh-cn/docs/user/quickstart.html
   4. xa模式需要一个新的SeataServer来管理[ok]
   5. 数据库分库[ok]
   6. pom导包[ok]
   7. 创建一个新的表格叫做`undo_log`[ok]
   8. 修改spring数据源，配置解码器[ok]
   9. 写两个方法，测试全局的好不好用[ok]
   
1. 公共代码怎么处理

   1. 建立一个springboot公共模块，存放公共的注解、拦截器、配置
      1. 首先要构建一个新的`pom.xml`
      2. 后端的common
      3. #### 删除`CommonApplication.java`、`test`目录和`resources`下的`application.properties`
      4. 放入公共代码
      5. 打包
      6. 在需要引入的工程中加上
         ```java
         @SpringBootApplication(scanBasePackages="com.edu.neu")
         ```

      7. 再将zady-micro-report也改造成引用公共模块的样子
      8. 扩展公共模块中的关于微服务的新功能
      9. 出现bug，不停的请求读取配置

2. 全部搞定

   1. 完成存储密钥和携带密钥功能[ok]
   2. `decoder`优化，支持`Boolean`类型、`Integer`类型和`String`类型[ok]
   3. 再建`zady-micro-story`模块，仿照前面几个模块即可
      1. spring启动器建工程[ok]
      2. nacos建配置文件[ok]
      3. seata设置分组[ok]
      4. gateway注册它[这个再说]
   4. 迁移`service`、`mapper`和`controller`，其中涉及到接口的改值等操作
      1. storyservice差两个feign没配置