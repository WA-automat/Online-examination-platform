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
6. RocketMQ 消息队列

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
>
> 创建邮箱服务
>
> 实现验证码收发功能

### 2022.12.7

> 使用Jedis替代RedisCache解决Redis连接问题

### 2022.12.8

> 创建注销登录接口
>
> 完成授权模块
>
> 完成多个数据库表，实现权限、角色、用户角色关联表
>
> 完成全局异常处理配置
>
> 更新注册接口，添加自动配置学生权限的功能

### 2022.12.9

> 添加赋权接口
>
> 添加删除权限接口
>
> 配置RocketMQ，实现RocketMQTemplate注入SpringBoot容器

### 2022.12.10

> 编写测试类
>
> 配置相关RocketMQTemplate
>
> 进行重构与注释文档的编写

### 2022.12.12

>完成登录、注册页面
>
>实现登录页面跳转到注册页面
>
>创建重置密码接口
>
>完成重置密码页面

### 2022.12.28

> 配置并放行swagger页面
>
> 配置bootstrap-ui便于查看后端接口

### 2022.12.29

> 创建考试类
>
> 创建考试类映射文件
