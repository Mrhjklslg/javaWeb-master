<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>

    <script>
        function deleteUser(id){
            //用户安全提示
            if(confirm("您确定要删除吗？")){
                //访问路径
                location.href="${pageContext.request.contextPath}/delUserServlet?id="+id;
            }
        }

        window.onload = function(){
            //给删除选中按钮添加单击事件
            document.getElementById("delSelected").onclick = function(){
                if(confirm("您确定要删除选中条目吗？")){

                   var flag = false;
                    //判断是否有选中条目
                    var cbs = document.getElementsByName("uid");
                    for (var i = 0; i < cbs.length; i++) {
                        if(cbs[i].checked){
                            //有一个条目选中了
                            flag = true;
                            break;
                        }
                    }

                    if(flag){//有条目被选中
                        //表单提交
                        document.getElementById("form").submit();
                    }

                }

            }
            //1.获取第一个cb
            document.getElementById("firstCb").onclick = function(){
                //2.获取下边列表中所有的cb
                var cbs = document.getElementsByName("uid");
                //3.遍历
                for (var i = 0; i < cbs.length; i++) {
                    //4.设置这些cbs[i]的checked状态 = firstCb.checked
                    cbs[i].checked = this.checked;

                }

            }

            document.getElementById("btn").onclick = function () {
                location.href ="${pageContext.request.contextPath}/findUserByPageServlet";
            }


        }


    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>

    <div style="float: left;">

        <form class="form-inline clearfix" style="float: left" action="${pageContext.request.contextPath}/findUserByPageServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" name="name" value="${condition.name[0]}" class="form-control" id="exampleInputName2" >
            </div>
            <div class="form-group">
                <div class="form-group">
                    <label for="address">籍贯：</label>
                    <select name="address" class="form-control" id="address">
                        <option value ="">请选择省份</option>
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
                <label for="exampleInputEmail2">邮箱</label>
                <input type="text" name="email" value="${condition.email[0]}" class="form-control" id="exampleInputEmail2"  >
            </div>
            <button type="submit" class="btn btn-primary">查询</button>

        </form>
        <button type="submit" id="btn" style="margin-left: 5px" class="btn btn-primary">显示全部</button>


    </div>

    <div style="float: right;margin: 5px;">

        <a class="btn  btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/FindUserRecycleServlet">回收站</a>

    </div>
    <form id="form" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="firstCb"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${pb.list}" var="user" varStatus="s">
            <tr>
                <td><input type="checkbox" name="uid" value="${user.id}"></td>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td><a class="btn btn btn-primary btn-sm" href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>&nbsp;
                    <a class="btn btn-danger btn-sm" href="javascript:deleteUser(${user.id});">删除</a></td>
            </tr>

        </c:forEach>


    </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pb.currentPage == 1}">
                    <li class="disabled">
                </c:if>

                <c:if test="${pb.currentPage != 1}">
                    <li>
                </c:if>


                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage - 1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>


                <c:forEach begin="1" end="${pb.totalPage}" var="i" >


                    <c:if test="${pb.currentPage == i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
                    </c:if>
                    <c:if test="${pb.currentPage != i}">
                        <li><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
                    </c:if>

                </c:forEach>


                <li>
                    <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage + 1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 5px;">
                    共${pb.totalCount}条记录，共${pb.totalPage}页
                </span>

            </ul>
        </nav>


    </div>


</div>


</body>
</html>
