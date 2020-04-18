package com.taobao.xiangai;

import org.junit.Test;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoField;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.JCoStructure;

public class RFC
{   
    public void getCompanyCodeDetail(String cocd) throws JCoException
    {
        // JCoDestination instance represents the backend SAP system
        JCoDestination dest = JCoDestinationManager.getDestination("ECC");
        
        // JCoFunction instance is the FM in SAP we will use
        JCoRepository repository = dest.getRepository();        
        JCoFunction fm = repository.getFunction("BAPI_COMPANYCODE_GETDETAIL");
        if (fm == null){
            throw new RuntimeException("Function does not exists in SAP system.");          
        }   
        
        // set import parameter(s)
        fm.getImportParameterList().setValue("COMPANYCODEID", cocd);
        
        // call function
        fm.execute(dest);
        
        // get company code detail from exporting parameter 'COMPANYCODE_DETAIL'
        JCoStructure cocdDetail = fm.getExportParameterList()
                                    .getStructure("COMPANYCODE_DETAIL");
        
        this.printStructure(cocdDetail);        
    }   

    private void printStructure(JCoStructure jcoStru)
    {       
        for(JCoField field : jcoStru){
            System.out.println(String.format("%s\\t%s", 
                    field.getName(), 
                    field.getString()));
        }
    }
    
    @Test
    public void test() throws JCoException
    {
        this.getCompanyCodeDetail("Z900");
    }
}