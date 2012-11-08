<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>create session</title>
    <link rel="stylesheet" href="../../css/newConferenceSession.css" type="text/css" />
</head>
<body>
<div class="main-page">
    <div class="header">
        <div id="create-new-session">
            <div>New Conference Session</div>
            <div>
                <form name="sessionCreationForm" action="${formAction}" method="POST">
                    <p>
                        <label> Session Name:</label><br/>
                        <input type="text" id='sessionName' name='name'/><br/>
                    </p>
                    <p>
                        <label>Location:</label><br/>
                        <input type="text" id='sessionLocation' name='location'/><br/>
                    </p>
                    <p>
                        <label>Date:</label><br/>
                        <input type="text" id='sessionDate' name='date'/><br/>
                    </p>
                    <p>
                        <label>Time:</label><br/>
                        <input type="text" id="sessionTime" name="time" /><br/>
                    </p>
                    <p>
                        <label>Abstract:</label><br/>
                        <input type="text" id='abstract' name='abstract' /><br/>
                    </p>
                    <p>
                        <label>Presenter name:</label><br/>
                        <input type="text" id='presenterName' name='presenterName' /><br/>
                    </p>
                    <p>
                        <label>About presenter:</label><br/>
                        <input type="text" id='aboutPresenter' name='aboutPresenter' /><br/>
                    </p>
                    <button type='submit' name="Publish">Publish</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>