package com.taobao.xiangai;

import org.junit.Test;
import com.sap.conn.jco.*;
//import jco3.utils.JCoUtils;

public class JCoTableDemo
{
    public JCoTable getCocdList() throws JCoException
    {
        /**
         * Get company code list in SAP system  using BAPI BAPI_COMPANYCODE_GETLIST. 
         * Since JCoTable is rather flexible, we simply use this interface as return value
         */
        
        JCoDestination dest = JCoDestinationManager.getDestination("ECC");
        JCoFunction fm = dest.getRepository().getFunction("BAPI_COMPANYCODE_GETLIST");      
        fm.execute(dest);
        
        JCoTable companies = fm.getTableParameterList().getTable("COMPANYCODE_LIST");
        
        return companies;       
    }
    
    @Test
    public void printCompanies() throws JCoException
    {
        JCoTable companies = this.getCocdList();
        JCoUtils.printJCoTable(companies);
    }
}