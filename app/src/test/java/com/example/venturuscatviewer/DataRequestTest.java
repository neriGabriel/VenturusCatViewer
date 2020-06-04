package com.example.venturuscatviewer;

import com.example.venturuscatviewer.model.CatRequest;
import com.example.venturuscatviewer.model.DataRequest;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DataRequestTest {

    @Test
    public void createEmptyDataRequestObject() {
        DataRequest emptyObject = new DataRequest();
        assertEquals( DataRequest.class, emptyObject.getClass());
    }

    @Test
    public void isDataResquestSuccess() {
        DataRequest dataRequest = new DataRequest();
        dataRequest.setSuccess(true);
        assertEquals(true,dataRequest.isSuccess());
    }

    @Test
    public void isDataRequestFailed() {
        DataRequest dataRequest = new DataRequest();
        dataRequest.setSuccess(false);
        assertEquals(false, dataRequest.isSuccess());
    }

    @Test
    public void areAllAttributesFilled() {
        DataRequest dataRequest = new DataRequest();
        dataRequest.setSuccess(true);
        dataRequest.setStatus(200);
        dataRequest.setCatRequestList(new ArrayList<CatRequest>());

        assertEquals(true, dataRequest.getStatus() != null && dataRequest.isSuccess() && dataRequest.getCatRequestList() != null);
    }
}
