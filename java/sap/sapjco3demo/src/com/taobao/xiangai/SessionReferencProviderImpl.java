package com.taobao.xiangai;

import com.sap.conn.jco.ext.JCoSessionReference;
import com.sap.conn.jco.ext.SessionException;
import com.sap.conn.jco.ext.SessionReferenceProvider;

public class SessionReferencProviderImpl implements SessionReferenceProvider
{

    @Override
    public JCoSessionReference getCurrentSessionReference(String scopeType)
    {
        /**
         *  We need to override getCurrentSessionReference() method
         */
        
        JCoSessionRefenceImpl sessionRef = new JCoSessionRefenceImpl();
        return sessionRef;
    }

    @Override
    public boolean isSessionAlive(String sessionID)
    {
        return false;
    }

    @Override
    public void jcoServerSessionContinued(String sessionID) throws SessionException
    {       
    }

    @Override
    public void jcoServerSessionFinished(String sessionID)
    {       
    }

    @Override
    public void jcoServerSessionPassivated(String sessionID) throws SessionException
    {       
    }

    @Override
    public JCoSessionReference jcoServerSessionStarted() throws SessionException
    {
        return null;
    }
}