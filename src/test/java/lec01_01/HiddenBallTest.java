package lec01_01;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class HiddenBallTest {

	@Test
	public void testCreateWithInvalidStringVolume() {
		String volume = "2l.4e2";
		assertNotNull("new(" + volume + ")", new Ball(volume, Color.WHITE).getVolume());
	}

}
