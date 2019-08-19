<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" >
<head>
    <meta content="text/html;charset=UTF-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="static/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"/>
</head>
<body>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">访问model</h3>
    </div>
    <div class="panel-body">
        <span>${singlePerson.name}</span>
    </div>
</div>
<div>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">列表</h3>
        </div>
        <div class="panel-body">
            <ul class="list-group">
                <#list people as p>
                    <li class="list-group-item">
                        <span >${p.name}</span>
                        <span >${p.age}</span>
                        <button class="btn" onclick="getName('${p.name}');">获得名字</button>
                    </li>
                </#list>
            </ul>
        </div>
    </div>
</div>
<script src="static/jquery/jquery-3.4.1.min.js"></script>
<script src="static/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
    var single = '${singlePerson}';
    console.log(single.name+"/"+single.age);
    function getName(name) {
        console.log(name);
    }
</script>
</head>
</body>
</html>