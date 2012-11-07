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
                <form name="sessionCreationForm" action="${formAction}" method="POST">
                    Session Name: <input type="text" id='sessionName' name='name'/><br/>
                    Location: <input type="text" id='sessionLocation' name='location'/><br/>
                    Date: <input type="text" id='sessionDate' name='date'/><br/>
                    Time: <input type="text" id="sessionTime" name="time" /><br/>
                    Abstract: <input type="text" id='abstract' name='abstract' /><br/>
                    Presenter name: <input type="text" id='presenterName' name='presenterName' /><br/>
                    About presenter: <input type="text" id='aboutPresenter' name='aboutPresenter' /><br/>
                    <button type='submit' name="Publish">Publish</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>