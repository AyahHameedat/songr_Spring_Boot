package com.example.songr;

import com.example.songr.domain.Album;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Albums Constructor Test")
	public void albumConstructer()
	{
		Album album = new Album ("Insan","Hamza Namira",2,12,"./Hamza/Insan.png");

		assertEquals("Insan",album.getTitle());
		assertEquals("Hamza Namira",album.getArtist());
		assertEquals(2,album.getSongCount());
		assertEquals(12,album.getLength());
		assertEquals("./Hamza/Insan.png",album.getImageUrl());
	}

	@Test
	@DisplayName("Albums Setter Test")
	public void albumSetterAndGetter()
	{
//		"Insan","Hamza Namira",2,12,"./Hamza/Insan.png
		Album album = new Album ();

		album.setTitle("Insan");
		album.setArtist("Hamza Namira");
		album.setSongCount(2);
		album.setLength(12);
		album.setImageUrl("./Hamza/Insan.png");


		assertEquals("Insan",album.getTitle());
		assertEquals("Hamza Namira",album.getArtist());
		assertEquals(2,album.getSongCount());
		assertEquals(12,album.getLength());
		assertEquals("./Hamza/Insan.png",album.getImageUrl());

	}


}
