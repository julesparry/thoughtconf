<div class="session-name">${session.name}</div>
<div class="conference-title">${session.conferenceName?default("ThoughtWorks Away Day")}</div>

<div class="date-time-location">

    <div class="location">
        <div id="location-detail"> ${session.location}</div>
    </div>

    <div class="date-time">
        <div class="date">
            <span>${session.date}</span>
        </div>
        <hr id="vertical-rule"/>
        <div class="time">
            <span>${session.time}</span>
        </div>
    </div>

    <div class="presenter">
        <span>Presenter: </span>
        <span class="speaker-name">${session.speaker}</span>
    </div>
</div>