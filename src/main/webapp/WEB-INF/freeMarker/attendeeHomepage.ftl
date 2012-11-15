<html>
<head>
    <title>Attendee Home Page</title>
    <link rel="stylesheet" href="../css/default.css" type="text/css"/>
    <link rel="stylesheet" href="../css/viewsession.css" type="text/css"/>
    <link rel="stylesheet" href="../css/sessionslist.css" type="text/css"/>
</head>
<body>
<#include "/common/header.ftl">
<div class="main-page">
    <div class="session-list-title">Upcoming Sessions</div>
    <hr class="horizontal-rule"/>

    <ol>
    <#list sessions as session>
        <li class="session-item">
            <a href="session/${session.sessionId}">
                <#include "/common/sessionDetail.ftl">
            </a>
        </li>
    </#list>
    </ol>

</div>

</body>
</html>
