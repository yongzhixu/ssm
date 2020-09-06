## SSM 脚手架



### URL层
- Swagger, yaml,     interfaces. Restful url. Controller 层。DDD domain drive design。spring/springmvc
- Unified response and request     body. 

### SERVICE层

- @Aspect 限流，日志，校验（token和操作用户是否匹配), @around (delegete.method) 
- lombok: data class, getter, setter, constructor. 
- @controlleradvice/@restcontrolleadvice, exception and error handle
- Log4j2: log. trouble shooting. MDC. 
- Javax     servelet filter filterchain。策略链，责任链 pseudo aop. . strategy management. 策略管理。进入业务逻辑之前的统一处理。如解析token。
  - class A implement fileter
  - @configuration， @bean method（）{new A（）}
- Converter. Bean A to B. 
-  Squirrel foundation. 状态机。解耦状态变化下的业务流转。
- 多线程 异步任务。线程池，降低资源消耗。
- Json web tokens. token protocol


### DAO层
- Mybatis.generator （@mapperscan）
- Flyway data migration. 



 

DEMO……脚手架SSM  业务只关注业务，其他由框架管理。