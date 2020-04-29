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
   9. 写两个方法，测试全局的好不好用[doing]