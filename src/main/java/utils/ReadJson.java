package utils;

import java.io.FileReader;
import java.io.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.google.gson.Gson;

public class ReadJson {

    private static final Logger logger = LogManager.getLogger(ReadJson.class);

    public static <T> T getJsonAsPoJo(String fileName, Class<T> cls) throws Exception {
        Gson g = new Gson();
        Reader in = null;
        T res = null;
        try {
            in = new FileReader(fileName);
            res = g.fromJson(in, cls);
            logger.debug("Deserialized JSON to object: " + res);
            in.close();
        } catch (Exception e) {
            logger.fatal("Failed to read: file " + fileName, e);
            throw e;
        }
        return res;
    }
}
