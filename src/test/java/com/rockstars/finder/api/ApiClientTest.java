package com.rockstars.finder.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ApiClientTest {

  @InjectMocks
  ApiClient client;

  @Spy
  ObjectMapper mapper;

  @Test
  public void testSongRetrieval() throws IOException {
    Assert.assertEquals(client.retrieveSongs()[0].getYear(), 1975);
  }

  @Test
  public void testArtistRetrieval() throws IOException {
    Assert.assertEquals(client.retrieveArtists()[0].getName(), "\"Weird Al\" Yankovic");
  }
}
