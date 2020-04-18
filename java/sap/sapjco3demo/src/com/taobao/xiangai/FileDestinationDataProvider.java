package com.taobao.xiangai;

import java.io.File;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.ext.Environment;

public class FileDestinationDataProvider
{   
    public static JCoDestination getDestination() throws JCoException   
    {   
        File directory = new File("."); // current directory;
        String fileName = "SAP_AS";
        String suffix = "txt";
        
        FileDestinationDataProviderImp destDataProvider = new FileDestinationDataProviderImp();
        destDataProvider.setDestinationFile(directory, fileName, suffix);       
        Environment.registerDestinationDataProvider(destDataProvider);
        
        JCoDestination dest = JCoDestinationManager.getDestination(fileName);
        
        return dest;        
    }
}