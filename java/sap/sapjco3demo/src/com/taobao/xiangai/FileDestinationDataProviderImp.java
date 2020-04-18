package com.taobao.xiangai;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.sap.conn.jco.ext.DestinationDataEventListener;
import com.sap.conn.jco.ext.DestinationDataProvider;

public class FileDestinationDataProviderImp implements DestinationDataProvider
{   
    private File dir;
    private String destName; // destination name
    private String suffix;
    
    public void setDestinationFile(File dir, String destName, String suffix)
    {
        this.dir = dir;
        this.destName = destName;
        this.suffix = suffix;
    }
    
    private Properties loadProperties(File dir, String destName, String suffix) throws IOException
    {
        Properties props = null;
        
        // create a file with name: fullName in destDirectory
        File destFile = new File(dir, destName+"."+suffix);
        
        if (destFile.exists()){
            FileInputStream fInputStream = new FileInputStream(destFile);
            props = new Properties();
            props.load(fInputStream);
            fInputStream.close();           
        }else{
            throw new RuntimeException("Destination file does not exist.");
        }   
        
        return props;
    }

    @Override
    public Properties getDestinationProperties(String destName)
    {       
        Properties props = null;
        
        try {
            props = this.loadProperties(this.dir, this.destName, this.suffix);
        } catch (IOException e) {           
            e.printStackTrace();
        }       

        return props;
    }

    @Override
    public void setDestinationDataEventListener(DestinationDataEventListener listener)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean supportsEvents()
    {       
        return false;
    }
}