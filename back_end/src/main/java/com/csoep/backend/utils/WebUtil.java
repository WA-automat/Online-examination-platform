package com.csoep.backend.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebUtil {
	public static void renderString(HttpServletResponse response, String string) {
		response.setStatus(200);
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().println(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
