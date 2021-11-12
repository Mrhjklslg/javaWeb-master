<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改用户</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改联系人</h3>
        <form action="${pageContext.request.contextPath}/updateUserServlet" method="post">
            <!--  隐藏域 提交id-->
            <input type="hidden" name="id" value="${user.id}">

          <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name"  value="${user.name}" readonly="readonly" placeholder="请输入姓名" />
          </div>

          <div class="form-group">
            <label>性别：</label>
              <c:if test="${user.gender == '男'}">
                  <input type="radio" name="gender" value="男" checked />男
                  <input type="radio" name="gender" value="女"  />女
              </c:if>

              <c:if test="${user.gender == '女'}">
                  <input type="radio" name="gender" value="男"  />男
                  <input type="radio" name="gender" value="女" checked  />女
              </c:if>


          </div>

          <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" value="${user.age}" id="age"  name="age" placeholder="请输入年龄" />
          </div>

          <div class="form-group">
              <div class="form-group">
                  <label for="address">籍贯：</label>
                  <select name="address" class="form-control" id="address">
                      <option value ="请选择市区">请选择省份</option>
                      <option value ="北京市">北京市</option>
                      <option value ="天津市">天津市</option>
                      <option value ="上海市">上海市</option>
                      <option value ="重庆市">重庆市</option>
                      <option value ="河北省">河北省</option>
                      <option value ="山西省">山西省</option>
                      <option value ="辽宁省">辽宁省</option>
                      <option value ="吉林省">吉林省</option>
                      <option value ="黑龙江省">黑龙江省</option>
                      <option value ="江苏省">江苏省</option>
                      <option value ="浙江省">浙江省</option>
                      <option value ="安徽省">安徽省</option>
                      <option value ="福建省">福建省</option>
                      <option value ="江西省">江西省</option>
                      <option value ="山东省">山东省</option>
                      <option value ="河南省">河南省</option>
                      <option value ="湖北省">湖北省</option>
                      <option value ="湖南省">湖南省</option>
                      <option value ="广东省">广东省</option>
                      <option value ="海南省">海南省</option>
                      <option value ="四川省">四川省</option>
                      <option value ="贵州省">贵州省</option>
                      <option value ="云南省">云南省</option>
                      <option value ="陕西省">陕西省</option>
                      <option value ="甘肃省">甘肃省</option>
                      <option value ="青海省">青海省</option>
                      <option value ="台湾省">台湾省</option>
                      <option value ="广西壮族自治区">广西壮族自治区</option>
                      <option value ="内蒙古自治区">内蒙古自治区</option>
                      <option value ="西藏自治区">西藏自治区</option>
                      <option value ="宁夏回族自治区">宁夏回族自治区 </option>
                      <option value ="新疆维吾尔自治区">新疆维吾尔自治区</option>
                      <option value ="香港特别行政区">香港特别行政区</option>
                      <option value ="澳门特别行政区">澳门特别行政区</option>
                  </select>
              </div>
          </div>

          <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" id="qq" class="form-control" value="${user.qq}" name="qq" placeholder="请输入QQ号码"/>
          </div>

          <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" class="form-control" value="${user.email}" name="email" placeholder="请输入邮箱地址"/>
          </div>

             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交" />
                <input class="btn btn-default" type="reset" value="重置" />
                <input class="btn btn-default" type="button" onClick="javascript :history.go(-1)" value="返回"/>
             </div>
        </form>
        </div>
    </body>
</html>