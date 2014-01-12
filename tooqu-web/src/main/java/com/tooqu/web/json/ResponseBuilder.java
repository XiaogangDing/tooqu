package com.tooqu.web.json;


import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

public class ResponseBuilder {


	private static final String DEFAULT_CHARSET = "utf-8";

	/**
         * 
         * @param response
         * @param o
         * @throws Exception 
         */
	public void writeJsonResponse(HttpServletResponse response,
			Object o) throws Exception {
		Gson gson = new Gson();
		String strJson = gson.toJson(o);
		writeJsonResponse(response, strJson);
	}

	/**
         * 
         * @param response
         * @param content
         * @throws Exception 
         */
	public void writeJsonResponse(HttpServletResponse response, String content)
			throws Exception {
		response.addHeader("Content-Type", "application/json;charset="
				+ DEFAULT_CHARSET);
		PrintWriter writer = response.getWriter();
		writer.write(content);
	}
	
	/**
	 * 
	 * @param response
	 * @param ajjbxxVOs
	 * @throws Exception
	 */
	public void writeJsonResponseObjectList(HttpServletResponse response,
			List<Object> objects) throws Exception {
		Gson gson = new Gson();
		String strJson = gson.toJson(objects);
		writeJsonResponse(response, strJson);
	}

//	public void writeJsonResponseRyVOList(HttpServletResponse response,
//			List<RyVO> ryVOs) throws Exception {
//		Gson gson = new Gson();
//		String strJson = gson.toJson(ryVOs);
//		writeJsonResponse(response, strJson);
//	}

//	public void writeJsonResponseYhVOList(HttpServletResponse response,
//			List<YhVO> yhVOs) throws Exception {
//		Gson gson = new Gson();
//		String strJson = gson.toJson(yhVOs);
//		writeJsonResponse(response, strJson);		
//	}

}