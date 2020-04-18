package com.taobao.xiangai;

import com.sap.conn.jco.JCoContext;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
//import jco3.session.DestinationProvider;

public class TestSAPSessionMultiThread
{   
    public static void main(String[] args) throws JCoException, InterruptedException
    {
        /**
         * Run ZINCREMENT_COUNTER & ZGET_COUNTER functions in
         * different threads in a stateful way.
         * 
         * The SAP will keep a session id which was created in
         * JCoSessionReferenceImpl class 
         * and used in SessionReferenceProviderImpl class.
         * 
         * Before using, SessionReferenceProviderImpl class should be
         * registered using Environment.registerSessionReferenceProvider() method.
         */
        
        // get JCoDestination object instance
        JCoDestination destination = DestinationProvider.getDestination();
        
        // make sure the two functions will be executed in the same session
        JCoContext.begin(destination);
        
        // Before increment
        System.out.println("Before execution of ZINCREMENT_COUNTER:");
        System.out.println("Counter:" + RfcFunctions.runGetCounter(destination));
        
        // start a new Thread in which function ZINCREMENT_COUNTER
        // will be executed for five times
        WorkingThread workingThread = new WorkingThread(destination, false);
        workingThread.start();
        
        // wait and switch thread
        Thread.sleep(1000);
        
        // After increment
        if (workingThread.hasDone() == true){
            System.out.println("After execution of ZINCREMENT_COUNTER:");
            System.out.println("Counter:" + RfcFunctions.runGetCounter(destination));   
        }
        
        // release the connection 
        JCoContext.end(destination);
    }
}