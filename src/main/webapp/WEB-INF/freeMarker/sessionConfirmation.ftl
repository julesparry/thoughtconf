<!DOCTYPE HTML>
<html lang="en-US" xmlns="http://www.w3.org/1999/html">
<head>
    <link rel="stylesheet" href="../../css/sessionConfirmation.css" type="text/css" />
    <title>Session published</title>
</head>
<body>

<div>
    <h2>
       <i style="font-size: 40px;"> ${session.name}</i> was successfully published!
    </h2>
</div>
<div>

    <p><b>Conference Name:</b> ${session.conferenceName}</p>
    <p><b>Location:</b> ${session.location}</p>
    <p><b>Date:</b> ${session.date}<p/>
    <p><b>Time:</b> ${session.time}</p>
    <p><b>Abstract:</b> ${session.abstract}</p>
    <p><b>Speaker:</b> ${session.speaker}</p>
    <p><b>About Speaker:</b> ${session.speakerIntro}</p><br/>
</div>
<div>
    <a id="return_homepage" href="/thoughtconf/organiser" class="return_button">Return to Homepage test</a>
</div>
</body>
</html>
