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
                <div class="session-name">${session.name}</div>
                <div class="conference-title">${session.conferenceName?default("ThoughtWorks Away Day")}</div>

                <div class="date-time-location">

                    <div class="location">
                        <div id="location-detail"> ${session.location}</div>
                    </div>

                    <div class="date-time">
                        <div class="date">
                            <span>${session.date}</span>
                        </div>
                        <hr id="vertical-rule"/>
                        <div class="time">
                            <span>${session.time}</span>
                        </div>
                    </div>

                    <div class="presenter">
                        <span>Presenter: </span>
                        <span class="speaker-name">${session.speaker}</span>
                    </div>
                </div>
            </a>
        </li>
    </#list>
    </ol>

</div>

</body>
</html>
