
/**
 * Write a description of Parsing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class Parsing {
    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        // test of countryInfo
        //String ctyinfo = countryInfo(parser, "Nauru");
        //System.out.println(ctyinfo);
        // test of listExportersTwoProducts
        //parser = fr.getCSVParser();
        //listExportersTwoProducts(parser, "cotton", "flowers");
        //test of numberOfExporters
        //parser = fr.getCSVParser();
        int num = numberOfExporters(parser, "cocoa");
        System.out.println(num);
        // test of bigExporters
        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
    }
    
    public String countryInfo(CSVParser parser, String country) {
        String ctyInfo = "";
        for (CSVRecord record: parser) {
            String cty = record.get("Country");
            if (cty.equals(country)) {
                ctyInfo = record.get("Country") + ":" + record.get("Exports") + ":" + record.get("Value (dollars)");
                break;
            } 
        }
        if (ctyInfo == "") {
            ctyInfo = "NOT FOUND";
        }
        return ctyInfo;
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(exportItem1) && export.contains(exportItem2)) {
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem) {
        int num = 0;
        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(exportItem)) {
                num++;
            }
        }
        return num;
    }
    
    public void bigExporters(CSVParser parser, String amount) {
        int lengthOfAmount = amount.length();
        for (CSVRecord record : parser) {
            String value = record.get("Value (dollars)");
            int lengthOfValue = value.length();
            if (lengthOfValue > lengthOfAmount) {
                System.out.println(record.get("Country" ) + value);
            }
        }
    }
    
    
}
