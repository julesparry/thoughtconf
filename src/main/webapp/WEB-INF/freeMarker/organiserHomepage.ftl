<!DOCTYPE HTML>
<html lang="en-US">
<head>
    <link rel="stylesheet" href="css/createConference.css" type="text/css"/>
    <title>Organiser Home Page</title>
</head>
<body>

<div class="div-heading">
    <h2>ThoughtConf</h2>
</div>
<hr/>
<div class="div-create-conference-button">
    <a id="create_session" href="organiser/new" class="button">Create New Session</a>
</div>
<div class="publish-session">
    <h3>Published Sessions</h3>
<#list sessions as session>
    <div  class="one-line clear">
    <div class="date">${session.date} </div>
    <div class="conference-name">    <i> ${session.conferenceName?default("Away Day 2012")}</i></div>
    <div class="session-name">    <b>${session.name}</b></div>
    </div>
</#list>
</div>
</body>
</html>
