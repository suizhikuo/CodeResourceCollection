package com.taobao.xiangai;

import org.junit.Test;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;

public class TestDestionProvider
{
    @Test
    public void pingSAPDestination() throws JCoException
    {
        JCoDestination dest = DestinationProvider.getDestination();
        dest.ping();
    }
}