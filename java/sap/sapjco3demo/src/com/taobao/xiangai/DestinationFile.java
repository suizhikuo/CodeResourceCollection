package com.taobao.xiangai;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;
import com.sap.conn.jco.ext.DestinationDataProvider;

public class DestinationFile {
    private Properties setProperties() {
        // logon parameters and other properties
        Properties connProps = new Properties();
        connProps.setProperty(DestinationDataProvider.JCO_ASHOST, "10.122.1.146");
        connProps.setProperty(DestinationDataProvider.JCO_SYSNR, "00");
        connProps.setProperty(DestinationDataProvider.JCO_USER, "internet5");
        connProps.setProperty(DestinationDataProvider.JCO_PASSWD, "lmspass1");
        connProps.setProperty(DestinationDataProvider.JCO_CLIENT, "301");
        connProps.setProperty(DestinationDataProvider.JCO_LANG, "EN");

        return connProps;
    }

    private void doCreateFile(String fName, String suffix, Properties props) throws IOException {
        /**
         * Write contents of properties into a text file
         * which was named [fName+suffix.jcodestination]
         */

        File cfg = new File(fName + "." + suffix);
        if (!cfg.exists()) { // file not exists
            // Create file output stream, not using append mode
            FileOutputStream fOutputStream = new FileOutputStream(cfg, false);

            // store the properties in file output stream
            // and also add comments
            props.store(fOutputStream, "SAP logon parameters:");

            fOutputStream.close();
        } else {
            throw new RuntimeException("File alreay exists.");
        }
    }

    @Test
    public void createConfigFile() throws IOException {
        Properties props = this.setProperties();
        String fileName = "SAP_AS"; // sap application server

        // jcodestination suffix is required by JCoDestinationManager
        this.doCreateFile(fileName, "jcodestination", props);
    }
}