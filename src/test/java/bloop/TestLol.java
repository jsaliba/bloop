package bloop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.tck.junit4.FunctionalTestCase;

public class TestLol extends FunctionalTestCase {

	@Override
	protected String getConfigFile() {
		return "bloop.xml";
	}
	
	@Test
	public void testLol() throws IOException, Exception {
		assertTrue(true);
//		runFlowAndExpect("bloopFlow", IOUtils.toString(getClass().getResourceAsStream("lol.html")));
	}
	
	@Test
	public void testContentType() throws Exception {
		MuleEvent event = runFlow("bloopFlow");
		String payload = (String) event.getMessage().getPayload();
		assertEquals(IOUtils.toString(getClass().getClassLoader().getResourceAsStream("lol.html")), payload);
		
		assertEquals("text/html", event.getMessage().getOutboundProperty("Content-Type"));
	}
	
}
