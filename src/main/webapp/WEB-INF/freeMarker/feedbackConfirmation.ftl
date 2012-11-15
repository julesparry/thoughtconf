<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${rc.getContextPath()}/css/default.css" type="text/css"/>
    <link rel="stylesheet" href="${rc.getContextPath()}/css/feedback.css" type="text/css"/>
</head>
<body>
<div class="feedback-confirmation">
    <span>${session.name}</span>
    <p>Your feedback was successfully sent.</p>
    <ul>
        <li>Presenter Rating : ${feedback.presenterRating}</li>
        <li>Content Rating : ${feedback.contentRating}</li>
        <li>Experience Rating : ${feedback.overallRating}</li>
    </ul>
    <p>Thank You!</p>
</div>
<a class="back-to-sessions" href="${rc.getContextPath()}/attendee/sessions">
    <div>BACK TO SESSIONS</div>
</a>
</body>