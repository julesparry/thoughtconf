<!DOCTYPE html>
<html>
<head>
    <title>Feedback</title>
    <link rel="stylesheet" href="${rc.getContextPath()}/css/default.css" type="text/css"/>
    <link rel="stylesheet" href="${rc.getContextPath()}/css/viewsession.css" type="text/css"/>
    <link rel="stylesheet" href="${rc.getContextPath()}/css/sessionslist.css" type="text/css"/>
    <link rel="stylesheet" href="${rc.getContextPath()}/css/feedback.css" type="text/css"/>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${rc.getContextPath()}/js/conferenceSession.js"> </script>
    <script type="text/javascript" src="${rc.getContextPath()}/js/feedback.js"> </script>
</head>
<body>
    <#include "/common/header.ftl">
    <div class="feedback-title">
        Feedback
    </div>

    <hr class="horizontal-rule"/>

    <div class="session-detail">
        <#include "/common/sessionDetail.ftl">
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
                <div>Overall Experience</div>
                <#include "/common/votePoint.ftl">
            </li>
        </ul>
    </div>

    <div class="submit-btn">SUBMIT FEEDBACK</div>
</body>