<html>
<head>
    <title>View Session</title>
    <link rel="stylesheet" href="../css/default.css" type="text/css" /></head>
    <link rel="stylesheet" href="../css/sessionslist.css" type="text/css" /></head>
<body>

  <div class="header">
    <img src="../images/logo-500-115.png" />
  </div>


<div class="main-page">
  <h1>Upcoming Sessions</h1>

  <hr class="horizontal-rule"/>

  <div>

  </div>
  <ol>
  <#list sessions as session>
    <li>
    <a  class="session-item" href="" >
        <h1 class="session-name">${session.name}</h1>

        <h2 class="conference-title">ThoughtWorks Away Day</h2>

    <div class="date-time-location">
        <div class="location">
            <div><img id="location-img" src="../images/home-16x15.png" alt="Home Icon" width="16px" height="15px" /></div>
            <div id="location-detail">${session.location}</div>
        </div>

        <div class="date-time">
            <div class="date">
                <img src="../images/calendar-16x16.png" alt="Calendar Icon" width="16px" height="16px"/>
                <span>${session.date}</span>
            </div>

            <div class="time">
                <img id="clock" src="../images/clock-16x15.png" alt="Clock Icon" width="16px" height="15px"/>
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
