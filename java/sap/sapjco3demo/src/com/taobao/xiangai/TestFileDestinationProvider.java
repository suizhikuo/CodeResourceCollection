package com.taobao.xiangai;

import org.junit.Test;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;

public class TestFileDestinationProvider
{
    @Test
    public void pingSAPDestination() throws JCoException
    {
        JCoDestination dest = FileDestinationDataProvider.getDestination();
        dest.ping();
    }
}