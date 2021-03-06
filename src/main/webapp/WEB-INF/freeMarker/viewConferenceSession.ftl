<!DOCTYPE html>
<html>
<head>
    <title>View Session</title>
    <link rel="stylesheet" href="../../css/default.css" type="text/css" />
    <link rel="stylesheet" href="../../css/viewsession.css" type="text/css" />
    <link rel="stylesheet" href="../../css/jquery.mobile.custom.structure.css" type="text/css" />
    <link rel="stylesheet" href="../../css/my_custom_css.css" type="text/css" />
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="../../js/conferenceSession.js"> </script>
    <script type="text/javascript" src="../../js/conferenceSessionBindings.js"> </script>
</head>
<body>

  <#include "/common/header.ftl"> 

  <div class="main-page">
      <div class="conf-info">
          <div class="conf">
              <div class="component-type">conference</div>
              <div class="component-title">${session.conferenceName?default("ThoughtWorks Away Day")}</div>
          </div>
      </div>

      <hr class="horizontal-rule"/>

      <div class="session-title">
          <h1>${session.name}</h1>
      </div>

      <hr class="horizontal-rule"/>

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
      </div>

      <hr class="horizontal-rule"/>

      <div class="btn-container">
          <a href="#" data-role="button" data-sessionid="${session.id}" class="going-btn <#if going == true>active</#if>" id="goingButton">
              <span class="text">I'm going!</span>
          </a>
      </div>

      <hr class="horizontal-rule"/>

      <div class="abstract">
          <h2 class="icon abstract">Abstract</h2>
          <p>
             ${session.abstract}
          </p>
      </div>

      <hr class="horizontal-rule"/>

      <div class="speaker">
          <h2>About the presenter</h2>
          <p id="speaker-name">${session.speaker}</p>
          <p id="speaker-details">
              ${session.speakerIntro}
          </p>
      </div>

      <hr class="horizontal-rule"/>

      <div class="feedback-container clear">
          <div class="feedback-reminder">
              <h2>Session over?</h2>

              <#--<p>Don't forget to give feedback!</p>-->
          </div>
          <div class="btn-container">
              <a href="${session.id}/feedback" data-role="button" data-sessionid="${session.id}" class="feedback-btn">
                  <span class="text">give feedback!</span>
              </a>
          </div>
      </div>
  </div>
</body>
</html>
