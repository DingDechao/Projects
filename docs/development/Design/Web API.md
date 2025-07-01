# Web API

## Web API 设计思路
 - 罗列所有功能
 - 整理|分类这些功能


## URL :
 - 短小便于输入
   -  X - http://api.example.com/service/api/serch  service/api 是多余的
   -  V - http://api.example.com/search
 - 人可以读懂
   - 不要有奇怪的缩写
     - products -》 prod
     - week -》 wk
 - 没有大小写混用
   - 全部使用小写字母,不要用驼峰
 - 修改方便
   - V - http://api.example.com/v1/items/12345
     - http://api.example.com/v1/items/123456
     - http://api.example.com/v1/items/123457
     - http://api.example.com/v1/items/123458
   - X - http://api.example.com/v1/a/12345
     - http://api.example.com/v1/a/123456
     - http://api.example.com/v1/b/123457
     - http://api.example.com/v1/c/123458
 - 不会暴露服务器架构
   - http://api.example.com/cgi-bin/get_user.php?user=1234
 - 统一规则
   - X -
     - http://api.example.com/friend?id=100
     - http://api.example.com/friend/100/message
   - V -
     - http://apo.example.com/friends/100
     - http://apo.example.com/friends/100/message

## Http的方法
| 方法名    |说明|
|:-------|:--------|
| GET    |获取资源|
| POST   |新增资源|
| PUT    |更新已有资源|
| DELETE |删除资源|
| PATCH  |更新部分资源|
| HEAD   |获取资源的元信息|

## 端点设计举例
### 用户登录场景
| 目的        | 端点                                  | 方法        |
|:----------|:------------------------------------|:----------|
| 获取用户信息列表  | http://api.example.com/v1/users     | GET       |
| 新用户注册     | http://api.example.com/v1/users     | POST      |
| 获取特定用户的信息 | http://api.example.com/v1/users/:id | GET       |
| 更新用户信息    | http://api.example.com/v1/users/:id | PUT/PATCH |
| 删除用户信息    | http://api.example.com/v1/users/:id | DELETE    |


### 维护好友关系场景
| 目的          | 端点                                              | 方法        |
|:------------|:------------------------------------------------|:----------|
| 获取当前用户的好友列表 | http://api.example.com/v1/users/:id/friends     | GET       |
| 添加好友        | http://api.example.com/v1/users/:id/friends     | POST      |
| 删除好友        | http://api.example.com/v1/users/:id/friends/:id | DELETE    |


### 维护好友动态场景
| 目的          | 端点                                                  | 方法     |
|:------------|:----------------------------------------------------|:-------|
| 编辑动态信息      | http://api.example.com/v1/update/:id                | PUT    |
| 删除动态信息      | http://api.example.com/v1/update/:id                | DELETE |
| 发表动态信息      | http://api.example.com/v1/Update                    | POST   |
| 获取特定用户的动态信息 | http://api.example.com/v1/users/:id/updates         | GET    |
| 获取好友的动态列表   | http://api.example.com/v1/users/:id/friends/updates | GET    |

### 端点设计的注意事项
- 使用名词的复数形式
  - 复数表示集合的意思
  - 虽然有的公司也用单数形式,但是依然推荐使用复数形式
  - 注意有的英文单词的复数不是单纯的加S media X medias V medium
  - 英文单词有单复数同形的情况
  - URI里面要极力避免使用动词, X get_user
- 要用合适的单词
  - 多参考其他公开的api,不能仅仅参考一个
    - v search 场所 X find 东西
    - v photo X picture
- 避免使用空格和编码的字符
  - 碰到特殊字符的时候需要用到百分号编码
  - X - http://api.example.com/v1/%E3%E3%E3%E3%E3%E3%E3%E3%E3%E3%E3/123 ???
  - ASCII % & + 都需要进行百分号编码
  - URI里面的空格符会转化为字符 + ,所以应该避免使用空格
- 如何使用连接符
  - http://api.example.com/v1/users/12345/profile-image 连接符- Spinal case or Chain Case
  - http://api.example.com/v1/users/12345/profile_image 下划线_ Snake Case
  - http://api.example.com/v1/users/12345/profileImage 驼峰法 Camel case
- 
### 搜索和查询参数的设计
 - Pagination
   - per_page=50&page=3
     - page一般从1开始(1-based)
   - limit=5&offset=100
     - offset 从0开始(0-based)
     - 性能不好:因为要从头开始计算
     - 数据更新频率高,数据就会不准确
 - Filter
 - http://api.example.com/v1/people-search?first-name=Clair
 - http://api.example.com/v1/people-search?last-name=Standish
 - http://api.example.com/v1/people-search?school-name=Shermer%20High%20School - 百分号编码 20%是空格的意思
 - 只有1个搜索项目的术后,会用查询参数q
   - http://api.example.com/v1/people-search?q=jack - q=query 一般用于模糊匹配,只需要包含jack即可
   - http://api.example.com/v1/perple-sarch?name=ken - name必须和ken一样

### 何时使用路径查询参数
 - 是否是表示唯一资源所需的信息
   - 用户ID,可以放到路径中
   - access token和认证有关和资源无关所以应该放到查询参数里面
 - 是否可以省略
   - offset, limit, page省略之后都会有默认值,所以放到查询参数里面更合适

## OAuth2.0
 - OAuth1.0
 - OAuth2.0 - 2012年10月 RFC 6749完成了标准化,但不兼容1.0
   - | Grant Type                          | 作用                                 | 
     |:------------------------------------|:-----------------------------------|
     | Authorization Code                  | 适用于在服务器进行大量处理的Web应用                |
     | Implicit                            | 适用于智能手机应用及使用JavaScript客户端进行大量处理的应用 |
     | Resource Owner Password Credentials | 适用于不使用服务器端的应用                      |
     | Client Credentials                  | 适用于不已用户为单位来进行认证的应用                 |
   - 示例
     - /token
     - /oauth2/token - 比较好的方案
     - /oauth2/authorize
     - /oauth/access_token
     - /o/oauth2/token
     - /login/oauth/access_tokem
     - /oauth/authorize/
     - /oauth/access_token
     
    - Resource Owner Password Credentials
      - content/type : application/x-www-form-urlencoded
        - | Key        | Content                                              |
          |:-----------|:-----------------------------------------------------|
          | grant_type | 字符串password,表示使用了Resource Owner Password Credentials |
          | username   | 登录的用户名                                               |
          | password   | 登录的密码                                                |
          | scope      | 指定允许访问的权限范围(可以省略)                                    |
        - 示例1
        - Request
         ```
          POST /v1/oauth2/token HTTP/1.1
          HOST: api.example.com
          Authorization: Basic XXXXXXXXXXXXXXXXXXXXXX
          Content-Type: application/x-www-form-urlencoded
          grant_type=password&username=tttttt&password=abcde&scope=api
          ```
        - Response
         ```
          HTTP/1.1 200 OK
          Content-Type: application/json
          Cache-Control : no-store
          pragma: no-cache
         {
            "access_token": "xxxxxxxxxxxxx",
            "token_type": "bearer",
            "expires_in":22222222,
            "refresh_token":"xxxxxxxxxxxxxxxxx",   
         }
          ```

        - 示例2
          - Request 示例2.1 - 把token信息添加到request header里面, 需要用到Authorization
          ```
          GET /v1/users HTTP/1.1
          HOST: api.example.com
          Authorization: Bearer XXXXXXXXXXXXXXXXXXXXXX
          ```
        - Request 示例2.2 - 把token信息添加到request body,需要用 Content-Type: application/x-www-form-urlencoded,并用access_token来命名request body里面的参数名, 并且附上token信息
          ```
          POST /v1/users HTTP/1.1
          HOST: api.example.com
          Authorization: Bearer XXXXXXXXXXXXXXXXXXXXXX
          Content-Type: application/x-www-form-urlencoded
          
          access_token=xxxxxxxxxxxxxxxxxxxxxx
          ```
        - Request 示例2.3 - 以查询参数的方式添加token
          ```
          GET /v1/users?access_token=xxxxxxxxxxxxx HTTP/1.1
          HOST: api.example.com
          ```
      - token有效期
        ```
        http/1.1 401 Unauthorized
        Content-Type: application/json
        Cache-Control: no-store
        Pragma: no-cache
        
        {
            "error" : "invalid_token"
        }
        ```
     - token过期之后需要用refresh_token再次请求新的token
    ```
   POST /v1/oauth2/token HTTP/1.1
   Host: api.example.com
   Authorization: Basic xxxxxxxxxxxxxxxx
   Content-Type: application/x-www-form-urlencoded
   
   grant_type=refresh_token&refresh_token=xxxxxxxxxxxxxxxxxx
   ```
          