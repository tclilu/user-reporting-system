package com.sw.urs.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class ReturnJsonUtil {
    private static Logger logger = LoggerFactory.getLogger(ReturnJsonUtil.class);

    /**
     * 拦截器中向客户端写json
     * @param response
     * @param jsonString
     */
    public static void returnJson(HttpServletResponse response, String jsonString) {
        PrintWriter printWriter = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            printWriter = response.getWriter();
            printWriter.print(jsonString);
        } catch (Exception e) {
            logger.error("response error" + e.getMessage());
        } finally {
            if (printWriter != null) {
                printWriter.flush();
                printWriter.close();
            }
        }
    }
}
