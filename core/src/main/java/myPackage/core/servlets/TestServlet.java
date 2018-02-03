package myPackage.core.servlets;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import javax.management.Query;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component(service = Servlet.class,
        property = {
                Constants.SERVICE_DESCRIPTION + "=Test",
                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                "sling.servlet.paths=" + "/bin/test",
                "sling.servlet.extensions=" + ""
        })
public class TestServlet extends SlingAllMethodsServlet {


    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(getSampleData().toString());
    }

    private JSONArray getSampleData(){
        JSONArray jsonArray = new JSONArray();
        for(int i = 0; i <= 10; i++){
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("value", "sample value " + i);
                jsonObject.put("text", "sample name " + i);
                jsonArray.put(jsonObject);
            }catch (Exception e){

            }
        }
        return jsonArray;
    }




}



