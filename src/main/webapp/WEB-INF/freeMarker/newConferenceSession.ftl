<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>create session</title>
    <link rel="stylesheet" href="../css/newConferenceSession.css" type="text/css" />
</head>
<body>
<div class="main-page">
    <div class="header">
        <div id="create-new-session">
            <div><h2>New Conference Session</h2></div>
            <div>
                <form name="sessionCreationForm" action="${formAction}" method="POST">
                    <p>
                        <label> Session Name</label>
                        <input type="text" id='sessionName' name='name' class="session_text_box"/>
                    </p>
                    <p>
                        <label>Location</label>
                        <input type="text" id='sessionLocation' name='location'/>
                    </p>

                    <div class="clear">
                        <p class="date_and_time">
                            <label>Date</label>
                            <input type="text" id='sessionDate' name='date'/>
                        </p>

                        <p class="date_and_time">
                            <label>Time (Start-End)</label>
                            <input type="text" id="sessionTime" name="time"/>
                        </p>
                    </div>
                    <p>
                        <label>Abstract</label>
                        <textarea type="text" id='abstract' name='abstract' class="session_text_box box_height"></textarea>
                    </p>
                    <p>
                        <label>Presenter name</label>
                        <input type="text" id='presenterName' name='presenterName' class="session_text_box"/>
                    </p>
                    <p>
                        <label>About presenter</label>
                        <textarea type="text" id='aboutPresenter' name='aboutPresenter' class="session_text_box box_height"></textarea><br/>
                    </p>
                    <button type='submit' name="Publish">Publish</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>