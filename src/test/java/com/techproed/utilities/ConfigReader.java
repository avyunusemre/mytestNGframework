package com.techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    //Bu class'in amaci, configuration.properties dosyasindaki verileri(test data) okumaktir.
    ///create Properties instance

    private static Properties properties;
    //FileInputStream kullanarak bir dosya aciyoruz
    //Properties'i bu dosyaya yukluyoruz
    //Daha sonra properties dosyasini okuyacagiz.

    //baslatmak icin static block olusturduk.
    static {
        String path = "configuration.properties";

        try {
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
        } catch (Exception e) {
            System.out.println("file path bulunamadi"); //olmasa da olur
            e.printStackTrace();
        }
    }
    //Okumak iicn static bir metod olusturalim
    public static String getProperty(String key) {

        return properties.getProperty(key);
    }


}
