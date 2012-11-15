<!DOCTYPE html>
<html>
<head>
    <title>Feedback</title>
    <link rel="stylesheet" href="${rc.getContextPath()}/css/default.css" type="text/css"/>
    <link rel="stylesheet" href="${rc.getContextPath()}/css/viewsession.css" type="text/css"/>
    <#--<link rel="stylesheet" href="${rc.getContextPath()}/css/sessionslist.css" type="text/css"/>-->
    <link rel="stylesheet" href="${rc.getContextPath()}/css/feedback.css" type="text/css"/>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${rc.getContextPath()}/js/conferenceSession.js"> </script>
    <script type="text/javascript" src="${rc.getContextPath()}/js/feedback.js"> </script>
</head>
<body>
    <#include "/common/header.ftl">
    <div class="conf-info">
        <div class="conf">
            <div class="component-type">conference</div>
            <div class="component-title">${session.conferenceName?default("ThoughtWorks Away Day")}</div>
        </div>
    </div>

    <hr class="horizontal-rule"/>

    <div class="feedback-title">Feedback for</div>

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

    <div class="feedback-vote">
        <span>Rate the following :</span>
        <ul class="vote-list">
            <li class="vote-item presenter clear">
                <div>Presenter</div>
                <#include "/common/votePoint.ftl">
            </li>
            <hr class="horizontal-rule"/>
            <li class="vote-item content clear">
                <div>Content</div>
                <#include "/common/votePoint.ftl">
            </li>
            <hr class="horizontal-rule"/>
            <li class="vote-item  overall clear">
                <div>Experience</div>
                <#include "/common/votePoint.ftl">
            </li>
        </ul>
    </div>

    <div class="submit-btn">SUBMIT FEEDBACK</div>
</body>