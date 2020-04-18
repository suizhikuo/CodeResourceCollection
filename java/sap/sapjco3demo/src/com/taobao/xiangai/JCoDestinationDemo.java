package com.taobao.xiangai;

import java.util.Properties;
import org.junit.Test;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;

public class JCoDestinationDemo
{
    public JCoDestination getDestination() throws JCoException
    {
        /**
         * Get instance of JCoDestination from file named ECC.jcodestination
         * which should be located in the installation folder of java project
         */
         
        JCoDestination dest = JCoDestinationManager.getDestination("ECC");
        return dest;
    }
    
    @Test
    public void pingDestination() throws JCoException
    {    
        JCoDestination dest = this.getDestination();
        dest.ping();
    }   
}