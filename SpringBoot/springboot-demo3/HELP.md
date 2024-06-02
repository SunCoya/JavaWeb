# 员工部门管理案例知识点

## Restful开发规范
**restful**：使用url定位资源，通常使用复数表此类资源  
对单个资源操作，路径就设置为/users/1  
新增、修改用户，路径就设置为/users  
对不同操作通过HTTP动词描述操作区分

| 操作 | 请求方式 | 请求路径 |
|----|------|------|
| 查询用户 | GET  | /users/1 |
| 删除用户 | DELETE | /users/1 |
| 新增用户 | POST | /users |
| 修改用户 | PUT  | /users |

*现在有更好的GraphQL开发规范（听说）*


## 特殊名词
**SDK**：SoftWare Development Kit  
软件开发工具包，使用OSS服务记得去找

**JWT**：JSON Web Token  
用于通信双方以JSON数据格式安全传送信息(存在数字签名)

**Base64**  
基于64个字符的（a-Z，0-9，/）来表示二进制数据的编码方式

**JWT格式**：xxx.xxx.xxx

**JWT组成**  
前面两部分基于base64，后一部分由签名算法计算
1. **Header**：记录令牌类型与算法：如{"alg":"HS256","type":"JWT"}
2. **Payload**：记录自定义信息：如{"id":"1","username":"zhangsan"}
3. **Signature**：签名，将前两部分与密钥加入，通过算法而来

**SpringFramework**内容：
1. IOC
2. DI
3. AOP
4. 事务管理

**SpringMVC**内容：
1. 接收请求
2. 响应数据
3. 拦截器
4. 全局异常处理

**SpringBoot**整合了**SSM**（上面两个+Mybatis）

## 父级pom文件
- 指定父工程为springboot-parent
- 指定版本时，后面的单词含义
- 指定打包方式
- 所用特殊依赖
  - 分页工具
  - 使用OSS所需工具
  - *写配置文件自动提示工具（自己在程序中指定了配置）*
  - jwt工具
  - fastJSON工具
  - aop编程所需工具
- 统一管理依赖与灵活设置版本
- 打包父文件自动打包子文件配置

## 子级pom文件
- 父级工程的路径设置
- 公司名的传递
- 打包插件

## 测试类
- 生成、解析JWT

## 资源包
### 静态文件下的html文件
- 网页传文件时，表单的提交方式
- 网页传文件时，表单属性的指定，以及不指定的后果

### application.yml
- 该文件可用后缀名
- 三种配置文件的优先级
- 与properties格式上的对比
- 用java命令设置端口与其优先级
- 配置post请求大小限制与上传单个文件大小
- 打开spring的事务管理的开关
- 如需要注入属性，对对象/Map/数组/List的配置

## java包
### 启动类
- 使用在SpringBoot工程中使用WebFilter的办法

### 工具包
#### ALiYunDemo
- 从阿里导入的SDK
#### JwtUtils
- 使用jwt生成与转换静态工具类
#### ALiOSSUtils
- 使这个对象被IOC管理
- 从外部配置中注入单个属性
#### AliOSSProperties
- 从外部配置中注入整个类中的属性

### 持久层mapper包
#### EmpMapper
- 分页+条件查询所需SQL（使用PageHelper）
- 注解写插入SQL，#{}中使用属性（对应pojo参数）
- 插入数据对于自动增长与default数据的完整性要求

### 控制层controller包
#### DeptController
- 不创建对象写日志
- 简化方法上的请求路径书写
  - 在类上设置资源
  - 在方法上使用不同注解声明路径
- json中只有一条数据

#### EmpController
- 设置请求的数据默认值/请求的数据非必须
- 请求数据为数组的发送与接收方案

#### LoginController
- jwt数据在浏览器端的请求存放位置，后续发送请求的新增部分
- cookie的使用方式以及缺陷

#### UploadController
- 接收图片数据使用的参数类型与参数名
- 获取文件的信息


### 服务层service包
#### DeptServiceImpl
- 事务的使用情况以及方式
- 异常的类型对回滚的影响，以及解决方案
- 事务的传递

#### DeptLogServiceImpl
- 相同类中的两个事务方法相互调用的缺陷
- 避免事务的传递

#### EmpServiceImpl
- PageHelper的使用

### 拦截层interceptor包
#### LoginCheckInterceptor
- 拦截器与过滤器的范围比较
- 拦截器的使用

#### WebConfig
- 声明添加拦截器的配置类
- 指定拦截器的拦截范围与不拦截的范围
- 拦截路径的设置

### 错误处理exception包
- 声明全局异常处理器
- 指定需要捕获所有异常

### 面向切面编程aop包
#### MyAspect
- 记录所有增删改操作(使用Log标注)
- 通过jwt获取用户信息

#### Log
- 注解，用于标记需要记录日志的方法