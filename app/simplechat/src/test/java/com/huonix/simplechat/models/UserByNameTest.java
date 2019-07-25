package com.huonix.simplechat.models;

import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.datastax.driver.core.utils.UUIDs;
import com.huonix.simplechat.configs.CassandraTestExecutionListener;
import com.huonix.simplechat.configs.EmbeddedCassandraConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
		EmbeddedCassandraConfig.class
}, initializers = ConfigFileApplicationContextInitializer.class)
@SpringBootTest
@TestExecutionListeners({ 
	CassandraTestExecutionListener.class,
	DependencyInjectionTestExecutionListener.class 
})
public class UserByNameTest {

	@Test
    public void testUserByNameIsEqual() {
		UUID id = UUIDs.timeBased();
		UserByName u1 = new UserByName("John Doe", id);
		UserByName u2 = new UserByName("John Doe", id);
		assertTrue("The users by name provided must be equal", u1.equals(u2));
    }
	
}
