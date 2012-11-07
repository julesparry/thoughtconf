<html>
<head>
    <title>View Session</title>
    <link rel="stylesheet" href="../../css/viewsession.css" type="text/css" />
    <link rel="stylesheet" href="../../css/jquery.mobile.custom.structure.css" type="text/css" />
    <link rel="stylesheet" href="../../css/my_custom_css.css" type="text/css" />
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
    <!--<script type="text/javascript" src="http://code.jquery.com/mobile/1.0.1/jquery.mobile-1.0.1.min.js"></script> -->
    <script type="text/javascript" src="../../js/conferenceSession.js"> </script>
    <script type="text/javascript" src="../../js/conferenceSessionBindings.js"> </script>
</head>
<body>
<div class="main-page">
  <ol>
  <#list sessions as session>
    <li>
    <a href="" >
        <h1 class="session-name">${session.name}</h1>

        <h2 class="conference-title">ThoughtWorks Away Day</h2>

    <div class="date-time-location">
        <div class="location">
            <div><img id="location-img" src="../../images/home-16x15.png" alt="Home Icon" width="16px" height="15px" /></div>
            <div id="location-detail">${session.location}</div>
        </div>

        <div class="date-time">
            <div class="date">
                <img src="../../images/calendar-16x16.png" alt="Calendar Icon" width="16px" height="16px"/>
                <span>${session.date}</span>
            </div>

            <hr id="vertical-rule"/>

            <div class="time">
                <img id="clock" src="../../images/clock-16x15.png" alt="Clock Icon" width="16px" height="15px"/>
                <span>${session.time}</span>
            </div>
        </div>
    </div>
    </a>
    </li>
  </#list>
  </ol>
</div>
</body>
</html>
