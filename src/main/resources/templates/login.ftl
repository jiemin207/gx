<html>
<title>登录</title>
<head>
<script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="js/user.js"></script>
</head>
<body>
<h1>登录页面
    <h1>
        <br>
        <form action="valid" method="post">
            <table>
                <tr>
                    <td>用户名：</td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr><td colspan="2" align="center"><input type="submit"></td></tr>
            </table>
        </form>
        
   <div id="myDiv"><#if ajax??>
        ajax测试
  <#else>
   <h2>无内容显示</h2>
          </#if></div>
        <button id="testAjax" type="button">Ajax改变内容</button>
        
</body>
</html>