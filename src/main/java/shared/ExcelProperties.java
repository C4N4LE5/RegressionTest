package shared;

import helpers.ExcelUtils;
import testdata.Constant;

import java.util.HashMap;

public class ExcelProperties {


    public HashMap<String, String> getGoogleData() throws Exception {
            ExcelUtils.setExcelFile(
                    Constant.Path_TestData + Constant.File_TestData,
                    "Google");
            HashMap<String, String> properties = new HashMap<>();
            properties.put("OutputFolder", ExcelUtils.getCellData(2,0));
            properties.put("ScreenShotsPath", ExcelUtils.getCellData(4,0));
            properties.put("ScreenShotsFolder", ExcelUtils.getCellData(6,0));
            properties.put("fileName", ExcelUtils.getCellData(8,0));
            properties.put("reportName", ExcelUtils.getCellData(10,0));
            properties.put("homePageValidation", ExcelUtils.getCellData(12,0));
            return properties;
    }




}
