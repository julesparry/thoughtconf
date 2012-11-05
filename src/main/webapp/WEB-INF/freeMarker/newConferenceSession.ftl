<html>
<head>
    <title>View Session</title>
    <link rel="stylesheet" href="../../css/viewsession.css" type="text/css"/>
    <link rel="stylesheet" href="../../css/jquery.mobile.custom.structure.css" type="text/css"/>
    <link rel="stylesheet" href="../../css/my_custom_css.css" type="text/css"/>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
    <!--<script type="text/javascript" src="http://code.jquery.com/mobile/1.0.1/jquery.mobile-1.0.1.min.js"></script> -->
    <script type="text/javascript" src="../../js/conferenceSession.js"></script>
    <script type="text/javascript" src="../../js/conferenceSessionBindings.js"></script>
</head>
<body>
<div class="main-page">
    <div class="header">
        <div>
            <div>New Conference Session</div>
            <div>
                <form name="conferenceCreationForm" action="${formAction}" method="POST">
                    Conference Name: <input type="text" id='conferenceSessionName' name='conferenceSessionName'/><br/>
                    <input type='submit'/>
                </form>
            </div>
        </div>
    </div>
</body>
</html>