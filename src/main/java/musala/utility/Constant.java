package musala.utility;

import java.nio.file.Paths;

public class Constant {

	  public static final String BrowserType = "Chrome";
      public static final String URL = "http://www.musala.com/";
      
      public static final String Path_TestData = Paths.get("").toAbsolutePath().toString() + "\\src\\testData\\";
      public static final String File_TestData = "TestData.xlsx";
      
      public static final String Path_Configurations = Paths.get("").toAbsolutePath().toString() + "\\";
      public static final String File_Configurations = "Configurations.xlsx";
   }