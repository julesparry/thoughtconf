<!DOCTYPE HTML>
<html lang="en-US">
<head>
    <link rel="stylesheet" href="css/createConference.css" type="text/css"/>
    <script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/conferenceSessionBindings.js"> </script>
    <title>Organiser Home Page</title>
</head>
<body>

<div class="div-heading">
    <h2>ThoughtConf</h2>
</div>
<hr/>
<div class="div-create-conference-button">
    <a id="create_session" href="organiser/new" class="button" onclick="window.location.reload()">Create New Session</a>
</div>
<div class="publish-session">
    <h3>Published Sessions</h3>
    <b>
    <div  class="one-line clear">
        <div class="date">Date </div>
        <div class="conference-name">     Conference Name</div>
        <div class="session-name">    Session Name </div>
    </div></b>
    <hr>
<#list sessions as session>
    <div class="one-line clear">
        <div class="date">${session.date} </div>
        <div class="conference-name"><i> ${session.conferenceName?default("Away Day 2012")}</i></div>
        <div class="session-name">    ${session.name}</div>
        <button name="deleteButton" data-sessionid="${session.id}">Delete</button>
        <hr>
    </div>
</#list>
</div>
</body>
</html>
