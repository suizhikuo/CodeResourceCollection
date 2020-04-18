package com.taobao.xiangai;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.ext.Environment;
import com.sap.conn.jco.ext.SessionReferenceProvider;

public class DestinationProvider2
{
    public static JCoDestination getDestination() throws JCoException
    {
        // create an instance of SessionReferenceProvider
        // and register in environment
        SessionReferenceProvider provider = new SessionReferencProviderImpl();
        Environment.registerSessionReferenceProvider(provider);
        
        JCoDestination destination = JCoDestinationManager.getDestination("ECC");
        
        return destination;
    }
}