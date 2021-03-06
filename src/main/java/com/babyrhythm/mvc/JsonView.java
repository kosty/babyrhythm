package com.babyrhythm.mvc;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class JsonView implements View {
    
    private String jsonParam;
    private Gson gson = new Gson();
    
    public JsonView(Object obj){ 
    	jsonParam = gson.toJson(obj);
    }
    
    @Override
    public void view(HttpServletRequest request, HttpServletResponse response)
                    throws IOException {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(jsonParam);      
    }

}
