<!DOCTYPE html>
<html>
<head>
    <title>View Session</title>
    <link rel="stylesheet" href="../../css/default.css" type="text/css" />
    <link rel="stylesheet" href="../../css/viewsession.css" type="text/css" />
    <link rel="stylesheet" href="../../css/jquery.mobile.custom.structure.css" type="text/css" />
    <link rel="stylesheet" href="../../css/my_custom_css.css" type="text/css" />
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
    <!--<script type="text/javascript" src="http://code.jquery.com/mobile/1.0.1/jquery.mobile-1.0.1.min.js"></script> -->
    <script type="text/javascript" src="../../js/conferenceSession.js"> </script>
    <script type="text/javascript" src="../../js/conferenceSessionBindings.js"> </script>
</head>
<body>

  <#include "/common/header.ftl"> 

  <div class="main-page">
      <div class="confInfo">
          <div class="conf">
              <div class="component-type">conference</div>
              <div class="component-title">Away Day Bangalore 2012</div>
          </div>
          <div class="track">
              <div class="component-type">track</div>
              <div class="component-title">Javascript</div>
          </div>
      </div>

      <hr class="horizontal-rule"/>

      <div class="session-title">
          <h1>${session.name}</h1>
      </div>

      <hr class="horizontal-rule"/>

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

      <hr class="horizontal-rule"/>

      <div class="buttonContainer">
          <a href="#" data-role="button" class="goingButton" id="goingButton">
              <span>happy face</span>
          </a>
          <span class="text">I'm going!</span>
      </div>

      <hr class="horizontal-rule"/>

      <div class="abstract">
          <img src="../../images/abstract-16x15.png" alt="Abstract Icon" width="16px" height="15px"/>
          <h2>Abstract</h2>
          <p>
             ${session.abstract}
          </p>
      </div>

      <hr class="horizontal-rule"/>

      <div class="speaker">
          <img src="../../images/mic-16x16.png" alt="Mic Icon" width="16px" height="16px"/>
          <h2>About the presenter</h2>
          <p id="speaker-name">${session.speaker}</p>
          <p id="speaker-details">
              ${session.speakerIntro}
          </p>
      </div>
  </div>
</body>
</html>
