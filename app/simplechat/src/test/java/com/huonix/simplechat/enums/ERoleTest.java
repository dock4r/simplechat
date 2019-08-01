package com.huonix.simplechat.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ERoleTest {

	@Test
    public void testGetRoleOk() {
		assertEquals("admin", ERole.ADMIN.role());
	}
	
}
