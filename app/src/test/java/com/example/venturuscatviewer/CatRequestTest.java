package com.example.venturuscatviewer;

import com.example.venturuscatviewer.model.CatRequest;
import com.example.venturuscatviewer.model.ImageRequest;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CatRequestTest {

    @Test
    public void createEmptyCatRequestObject() {
        CatRequest emptyObject = new CatRequest();
        assertEquals(CatRequest.class, emptyObject.getClass());
    }

    @Test
    public void areAllAttributesFilled() {
        CatRequest catRequest = new CatRequest();
        catRequest.setId("1");
        catRequest.setLink("https://i.imgur.com/dFg4ZwL.jpg");
        catRequest.setTitle("Aero sitting very politely, what a good boy");
        catRequest.setImageRequestList(new ArrayList<ImageRequest>());

        assertEquals(true, !catRequest.getId().equals("") && !catRequest.getLink().equals("") && !catRequest.getTitle().equals("") && catRequest.getImageRequestList() != null);
    }
}
