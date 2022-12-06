# Online-examination-platform

### Description：

> An epic online examination platform for contemporary college students and teachers based on the principles of fairness, justice and openness in the post-epidemic era（一个面向当代大学生与教师打造的，后疫情时代下，基于公平公正公开原则的，史诗级在线考试平台）

## 技术栈

### 前端：

1. node.js + npm 包管理工具
2. vue + vuex + vue_router + vue-cli 框架
3. bootstrap 开源工具包
4. axios http请求工具

### 后端：

1. SpringBoot 框架
2. SpringSecurity + JWT 安全框架
3. SpringData
4. MySQL + MyBatis + MyBatis-Plus 数据库
5. Redis 缓存数据库
6. Kafka 消息队列

## 项目日志

### 2022.11.24

> Online-examination-platform 项目创建
>
> 创建项目前端部分 vue
>
> 创建项目后端部分 springboot

### 2022.11.25

> 修复springboot项目.loadUpdated问题并实现测试类
>
> 添加CorsConfig解决前后端跨域访问问题

### 2022.11.27

> 创建SecurityConfig配置类
>
> 创建MySQL用户表并创建对应的pojo层与mapper层
>
> > 用户表中包含的信息有：
> >
> > 1. 用户id（主键）
> > 2. 用户名
> > 3. 用户密码
> > 4. 用户手机号码
> > 5. 用户email
>
> 创建JwtUtil工具类

### 2022.11.28

> 实现UserDetails接口，创建LoginUser
>
> 更改并修复数据源
>
> 实现UserDetailsService，创建UserDetailsServiceImpl类
>
> 创建ResponseResult工具类

### 2022.12.5

> 配置Jwt认证过滤器
>
> 创建登录接口LoginController
>
> 配置Redis数据库
>
> 创建注册接口RegisterController
>
> 添加字段访问用户的Service

### 2022.12.6

> 创建邮件工具类
