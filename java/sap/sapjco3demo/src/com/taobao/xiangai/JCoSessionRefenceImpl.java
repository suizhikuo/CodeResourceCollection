package com.taobao.xiangai;

import java.util.concurrent.atomic.AtomicInteger;
import com.sap.conn.jco.ext.JCoSessionReference;

public class JCoSessionRefenceImpl implements JCoSessionReference
{
    private AtomicInteger atomInt = new AtomicInteger(0);
    private String id = "session"+String.valueOf(atomInt.addAndGet(1));
    
    @Override
    public void contextFinished()
    {       
    }

    @Override
    public void contextStarted()
    {   
    }

    @Override
    public String getID()
    {
        /**
         * We need to override getID() method
         */
        
        return id;
    }
}