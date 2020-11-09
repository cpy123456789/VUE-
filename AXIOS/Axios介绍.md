# Axios
------
### 1.Axios引言
Axios是一种**异步请求**技术，其原理是基于XMLHttpequest对象向后台发送请求进行数据交互。
异步请求的特点： 请求发送后页面不发生改变，当请求响应以后再更新页面数据，一个页面可以有多个请求并且互不影响。
<br/>
### 2.Axios简介
2.1 使用npm的方式引入
```
$ npm install axios
```
2.2 使用CDN的方式引入
```
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
```
2.3 下载到本地引入
```
下载地址：https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js
```
<br/>
###3.Axios的使用方式
3.1 GET方式请求

```
axios("http://localhost:8888/axios/get");
or
axios.get("http://localhost:8888/axios/get");
```

3.2 POST方式请求

```
axios.post("http://localhost:8888/axios/post");
```

3.3 then()函数
then()函数为接收到请求后进行响应的**回调函数**，我们可以在接收到返回数据以后在then()函数中进行一业务操作。
```
axios("http://localhost:8888/axios/list")
.then(function (res){
    console.log(res);
});
```

3.4 catch()函数
catch()函数为请求发生错误时进行响应的**回调函数**，catch()函数能够接收异常信息
```
axios("http://localhost:8888/axios/list")
.catch(function (err){
    console.log(err);
});
```

3.5 参数传递
> 3.5.1 GET请求传参
在url的末尾添加?后跟参数，参数与参数间用&分隔。get方式请求时，请求头为application/www-x-form-urlencoded
```
axios("http://localhost:8888/axios/list?username=dabai&password=123")
or
axios.get("http://localhost:8888/axios/list?username=dabai&password=123")
```

> 3.5.2 POST请求传参
axios在发送post请求时如果参数为对象类型，则axios会将其自动转换为json格式的字符串，使用applicaiton/json的请求头向后台服务接口传递参数。因此，我们可以使用字符串的方式来传递参数；或者采用对象的方式传递数据，后台接收需要解析JSON字符串。

```
axios.post("http://localhost:8888/axios/postStr",
"username=大白&age=23");
or
axios.post("http://localhost:8888/axios/post",{
username : "大白",
age : 21});
```

3.6 并发请求
`并发请求`：在同一时刻发送多个不同的请求到达后台，最后统一处理不同请求的响应结果。调用axios.all()函数，参数为函数数组，axios会将数组内的函数按顺序进行调用。
`顺序执行`：axios.spread()函数可以对请求的响应结果进行统一处理，参数为数组内函数依次对应的返回结果。由于是异步调用，返回的顺序并不确定，但是spread()函数会等待所有结果都响应以后再执行回调。
```
function conGet(){
    return axios.get("http://localhost:8888/axios/get?username=大白&age=123");
}
function conPost(){
    return axios.post("http://localhost:8888/axios/post",{
        username : "大白",
        age : 21
    });
}
function getConcurrence(){
    axios.all([conGet(),conPost()]).then(
        axios.spread(function (res1,res2){
            console.log(res1);
            console.log(res2);
        })
    );
}
```

3.7 请求配置
axios提供多种多样的请求配置，这些请求配置中只有url是必须的，其他的配置都是可选项。此外，当没有明确method配置时，默认采用GET方式发送请求。以下列举几个常用配置。
```
{
  url: '/user',
  
  method: 'get', // 默认为 get
  
  // `headers`用于自定义请求头
  headers: {'X-Requested-With': 'XMLHttpRequest'},
  
  // `params`参数会被链接至url中，主要用在get方法
  params: {
    ID: 12345
  },
  
  // `data` 是作为请求主体被发送的数据，主要用于post方法
  data: {
    firstName: 'Fred'
  },

  // `timeout` 指定请求超时的毫秒数(0 表示无超时时间)
  timeout: 1000,

  // `responseType` 表示服务器响应的数据类型，默认为`json`
  responseType: 'json',

  // `maxRedirects` 定义最大重定向数目，默认为5
  maxRedirects: 5,
}  
```

<br/>
### 4.Axios的Restful风格API
```
axios.get(url[, config])//用于获取数据
axios.post(url[, data[, config]])//用于提交新增数据
axios.put(url[, data[, config]])//用于更新数据
axios.patch(url[, data[, config]])//用于修改数据，局部更新
axios.delete(url[, config])//用于删除数据
```

<br/>
### 5.YApi接口管理平台
一个可以本地部署的可视化开源API管理平台，可以同时管理前端和后台的API。YApi是由去哪网的工程师完成的项目。平台本身基于Node.js和MongoDB，Github上有项目源代码。

```
Yapi地址：https://hellosean1025.github.io/yapi/
```

