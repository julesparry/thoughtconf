<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Create Session</title>
    <link rel="stylesheet" href="../css/newConferenceSession.css" type="text/css" />
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" />
    <script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
    <script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
    <script type="text/javascript" src="../js/customDatepicker.js"></script>
</head>
<body>
<div class="main-page">
    <div class="header">
        <div id="create-new-session">
            <div><h2>New Conference Session</h2></div>
            <div>
                <form name="sessionCreationForm" action="${formAction}" method="POST">
                    <p>
                        <label> Conference Name</label>
                        <input type="text" id='conferenceName' name='conferenceName' class="session_text_box" placeholder="Enter Conference Name"/>
                    </p>
                    <p>
                        <label> Session Name</label>
                        <input type="text" id='sessionName' name='name' class="session_text_box" placeholder="Enter Session Name"/>
                    </p>
                    <p>
                        <label>Location</label>
                        <input type="text" id='sessionLocation' name='location' placeholder="Enter Location"/>
                    </p>

                    <div class="clear">
                        <p class="date_and_time">
                            <label>Date (yyyy-mm-dd)</label>

                            <input type="text" id="sessionDate" name='date'  placeholder="Ex: 2012-12-31" />
                            <!--input type="text" id='sessionDate' name='date'  placeholder="Ex: 2012-12-31"/ -->
                        </p>

                        <p class="date_and_time">
                            <label>Time (hh:mm-hh:mm)</label>
                            <input type="text" id="sessionTime" name="time"  placeholder="Ex: 00:00-23:59"/>
                        </p>
                    </div>
                    <p>
                        <label>Abstract</label>
                        <textarea type="text" id='abstract' name='abstract' class="session_text_box box_height"  placeholder="Enter Abstract"></textarea>
                    </p>
                    <p>
                        <label>Presenter Name</label>
                        <input type="text" id='presenterName' name='presenterName' class="session_text_box"  placeholder="Enter Presenter Name"/>
                    </p>
                    <p>
                        <label>About Presenter</label>
                        <textarea type="text" id='aboutPresenter' name='aboutPresenter' class="session_text_box box_height"  placeholder="Enter About Presenter"></textarea><br/>
                    </p>
                    <button type='submit' name="Publish">Publish</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>