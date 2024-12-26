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
- 现在很多系统都是前后端分离,开发进步不一样, 需要对接口提前或单独做测试
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
