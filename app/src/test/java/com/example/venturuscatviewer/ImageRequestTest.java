package com.example.venturuscatviewer;

import com.example.venturuscatviewer.model.ImageRequest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ImageRequestTest {
    @Test
    public void createEmptyCatRequestObject() {
        ImageRequest emptyObject = new ImageRequest();
        assertEquals(ImageRequest.class, emptyObject.getClass());
    }

    @Test
    public void areAllAttributesFilled() {
        ImageRequest imageRequest = new ImageRequest();
        imageRequest.setId("1");
        imageRequest.setLink("https://i.imgur.com/dFg4ZwL.jpg");
        imageRequest.setType("image/jpeg");

        assertEquals(true, !imageRequest.getId().equals("") && !imageRequest.getLink().equals("") && !imageRequest.getType().equals(""));
    }
}
