# 接口

## 什么是接口
接口是软件提供给外部的一种服务,用于数据传输
- 硬件 : USB, 投影仪(数据传输)
- 软件 : API
- 
## 接口的分类
- 内部接口 
- 外部接口
## 为什么需要接口
接口能够让内部的数据被外部进行修改

## 接口的测试 
- 现在很多系统都是前后端分离,开发进度不一样, 需要对接口提前或单独做测试
- 基于安全考虑, 前端有的验证很容易绕过, 直接请求接口
- 推崇测试左移, 测试尽早的介入

## 接口测试的本质
- 测试接口能否正常的交互数据, 测试权限控制以及异常场景

## 接口的数据返回
- Json
  ```
    {
        error_code : 0,
        msg : "success",
        data : []  
    }
    ```
- Html
    ```
  <html>
    <title></title>
    <body>
        <error_code>0</error_code>
        <msg>success</msg>
        <data></data>
    </body>
  </html>
  ```
- XML
    ```
    <?xml?version="1.0" encoding="utf-8">
        <error_code>0</error_code>
        <msg>success</msg>
        <data></data>
    </xml>
    ```

## 接口的协议
- webservice : http://xxx.xxx.xx.x?wsdl
  - http://xxx.xxx.xx.x:port/addUser
  - http://xxx.xxx.xx.x:port/updateUser
  - http://xxx.xxx.xx.x:port/searchUser
  - http://xxx.xxx.xx.x:port/deleteUser
  RestFul : 
  - get 获得数据
  - post 提交数据
  - put 修改数据
    - delete 删除数据
      http://xxx.xxx.xx.x:port/user
- dubbo L dubbo://
  - 少量数据传输,高并发
- http http://
  - https=http+SSL port :443
  - http port : 80

## 接口测试的流程和方案

### API 接口文档, 接口的业务, 接口的地址, 鉴权, 入参, 出参, 错误码
### 接口计划和方案
- 正例: 输入正常的入参, 查看接口是否返回成功
- 反例:
  - 鉴权反例: 鉴权为空, 鉴权码错误, 鉴权码已过期
  - 参数反例: 参数空, 参数类型异常, 参数长度异常, 错误码的覆盖
  - 其他场景: 分页异常
- 编写用例
- 执行测试用例
- 输出接口测试的报告

## 用Postman执行接口测试
### 请求页面
 - params : get 请求传参
 - authorization : 鉴权
 - headers : 请求头
 - Body : post请求传参
   - none 没有参数
   - form-data : 即可以传键值对参数也可以传文件
   - x-www-form-urlencoded: 只能够传键值对参数
   - raw : json, text, xml, html, javascript
   - binary : 把文件以二进制的方式传参
   - scripts
     - pre-request
     - post-response
   - Cookies

### 响应页面

- Body :接口返回的数据
  - pretty : 以Json,html,XML...不同格式查看返回的数据
  - Raw : 以文本的方式查看返回的数据
  - PreView : 以网页的方式查看返回的数据
- Cookies : 响应的cookie信息
- Headers : 响应头
- Test Results : 断言的结果
- 200 状态码
- ok 状态信息
- 681MS 响应时间
-  343MB 响应的字节数


## 环境变量和全局变量

- 环境变量 : 环境变量就是全局变量
- 全局变量 : 能够在任何接口里面访问的变量
获得环境变量和全局变量的值通过 : {{变量名}}

## 接口关联
1. 使用json提取器实现接口关联
2. 使用正则表达式的方式实现接口关联

## Postman内置动态参数以及自定义的动态参数
{{$timestamp}} 生产当前时间的时间戳
{{$randomint}} 生产0-1000之间的随机数
{{$guid}} 生成随机的guid
