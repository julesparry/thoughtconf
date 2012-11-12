package com.twu.thoughtconf.dao;

import com.twu.thoughtconf.domain.SessionAnnouncements;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:mapper-context.xml"})
public class SessionAnnouncementsMapperTest {

    @Autowired
    private SessionAnnouncementsMapper sessionAnnouncementsMapper;

    @Before
    @After
    public void removeAllTestEntriesBefore(){
        sessionAnnouncementsMapper.cleanTable();
    }

    @Test
    public void should_insert_new_announcement_into_the_session_announcements_table(){
        SessionAnnouncements insertedSessionAnnouncement = new SessionAnnouncements(1, "New Announcement.");

        sessionAnnouncementsMapper.save(insertedSessionAnnouncement.getSessionId(), insertedSessionAnnouncement.getAnnouncements());
        SessionAnnouncements expectedAnnouncements = sessionAnnouncementsMapper.getAnnouncementByAnnouncementAndSessionId(insertedSessionAnnouncement.getSessionId(), insertedSessionAnnouncement.getAnnouncements());

        assertThat(insertedSessionAnnouncement.getAnnouncements(), is(expectedAnnouncements.getAnnouncements()));
    }
}
