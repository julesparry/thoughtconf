<html>
<head>
    <title>Attendee Home Page</title>
    <link rel="stylesheet" href="../css/default.css" type="text/css"/>
</head>
<link rel="stylesheet" href="../css/sessionslist.css" type="text/css"/>
</head>
<body>

<div class="header">
    <img src="../images/logo-500-115.png"/>
</div>


<div class="main-page">
    <div class="session-list-title">Upcoming Sessions</div>
    <hr class="horizontal-rule"/>

    <ol>
    <#list sessions as session>
        <li class="session-item">
            <a href="session/${session.sessionId}">
                <div class="session-name">${session.name}</div>

                <div class="conference-title">ThoughtWorks Away Day</div>

                <div class="date-time-location">
                    <div class="location clear">
                        <div><img id="location-img" src="../images/home-16x15.png" alt="Home Icon" width="16px"
                                  height="15px"/></div>
                        <div id="location-detail">${session.location}</div>
                    </div>

                    <div class="date-time clear">
                        <div class="date">
                            <img src="../images/calendar-16x16.png" alt="Calendar Icon" width="16px" height="16px"/>
                            <span>${session.date}</span>
                        </div>

                        <div class="time">
                            <img id="clock" src="../images/clock-16x15.png" alt="Clock Icon" width="16px"
                                 height="15px"/>
                            <span>${session.time}</span>
                        </div>
                    </div>
                </div>

                <div class="presenter">
                    <span>Presenter: </span>
                    <span class="speaker-name">${session.speaker}</span>
                </div>
            </a>
        </li>
    </#list>
    </ol>
</div>
</body>
</html>
