package com.taobao.xiangai;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;

public class RfcFunctions
{
    public static int runGetCounter(JCoDestination dest) throws JCoException
    {
        JCoFunction counterFM = dest.getRepository().getFunction("ZGET_COUNTER");
        counterFM.execute(dest);
        int counter = (int) counterFM.getExportParameterList().getValue("GET_VALUE");
        
        return counter;     
    }
    
    public static void runIncrement(JCoDestination dest) throws JCoException
    {
        JCoFunction increment = dest.getRepository().getFunction("ZINCREMENT_COUNTER");
        increment.execute(dest);        
    }
}