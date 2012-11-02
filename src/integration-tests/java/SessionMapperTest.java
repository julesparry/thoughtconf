import com.twu.thoughtconf.dao.SessionMapper;
import com.twu.thoughtconf.domain.ConferenceSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"/mapper-context.xml"})
public class SessionMapperTest {

    @Autowired
    SessionMapper sessionMapper;

    @Test
    public void should_get_session_detail_by_given_Session_Id() {
        ConferenceSession conferenceSession = sessionMapper.findSessionByID("1");

        assertThat(conferenceSession.getSessionId(), is(1));
        assertThat(conferenceSession.getSessionName(), is("dev bootcamp"));
        assertThat(conferenceSession.getLocation(), is("Ajanta"));
        assertThat(conferenceSession.getType(), is("Hands on"));
        assertThat(conferenceSession.getAbstract(), is("Attendees should bring laptops so that they can code, code and code"));
        assertThat(conferenceSession.getSpeaker(), is("Meng Wang"));
        assertThat(conferenceSession.getSpeakerIntro(), is("Guru in java and many other languages"));
        assertThat(conferenceSession.getTrackId(), is(1));
        assertThat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(conferenceSession.getStartTime()),is("2012-12-11 09:30:00"));
        assertThat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(conferenceSession.getEndTime()),is("2012-12-11 10:30:00"));
        assertThat(new SimpleDateFormat("hh:mm:ss").format(conferenceSession.getStartTime().getTime()),is("09:30:00"));
        assertThat(new SimpleDateFormat("hh:mm:ss").format(conferenceSession.getEndTime().getTime()),is("10:30:00"));
    }


}
