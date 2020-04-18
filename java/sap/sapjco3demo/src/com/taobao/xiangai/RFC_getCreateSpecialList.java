package com.taobao.xiangai;

import com.sap.conn.jco.*;
import org.junit.Test;

public class RFC_getCreateSpecialList {
    /**
     * CustomerString售达方编号,01编码
     * EnddateString结束日期,如:20200407
     * I_CcaString信控区编码,如4100
     * StartdateString起始日期:如:20200407
     *
     * @param
     * @throws JCoException
     */
    public void getCreateSpecialList(String Customer, String Enddate, String I_Cca, String Startdate) throws JCoException {
        // JCoDestination instance represents the backend SAP system
        JCoDestination dest = JCoDestinationManager.getDestination("ECC");

        // JCoFunction instance is the FM in SAP we will use
        JCoRepository repository = dest.getRepository();
        JCoFunction fm = repository.getFunction("Z_WWW_CREDIT_SPECIAL_LIST");
        if (fm == null) {
            throw new RuntimeException("Function does not exists in SAP system.");
        }

        // set import parameter(s)
        fm.getImportParameterList().setValue("CUSTOMER", Customer);
        fm.getImportParameterList().setValue("ENDDATE", Enddate);
        fm.getImportParameterList().setValue("I_CCA", I_Cca);
        fm.getImportParameterList().setValue("STARTDATE", Startdate);
        //fm.getImportParameterList().setValue("SPECIALLIST", cocd);


        // call function
        fm.execute(dest);

        // get company code detail from exporting parameter 'COMPANYCODE_DETAIL'
        JCoStructure cocdDetail = fm.getExportParameterList().getStructure("COMPANYCODE_DETAIL");

        this.printStructure(cocdDetail);
    }

    private void printStructure(JCoStructure jcoStru) {
        for (JCoField field : jcoStru) {
            System.out.println(String.format("%s\\t%s", field.getName(), field.getString()));
        }
    }

    @Test
    public void test() throws JCoException {
        this.getCreateSpecialList("0100026508", "20201007", "4100", "20200407");
    }
}