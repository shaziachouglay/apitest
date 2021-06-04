package testresources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {
    public RequestSpecification requestSpecification() throws IOException {
        PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
        RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
                .addQueryParam("key","qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON).build();
        return reqSpec;

    }

    public static String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/testresources/global.properties");
        prop.load(fis);
        return prop.getProperty(key);

    }
}
