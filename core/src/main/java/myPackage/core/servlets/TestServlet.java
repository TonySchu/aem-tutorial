package myPackage.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;


@Component(service = Servlet.class, property = {
        Constants.SERVICE_DESCRIPTION + "=Ausgabe von JSON für AEM Komponente",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths="+ "/bin/test",
        "sling.servlet.extensions=" + ""
})
public class TestServlet extends SlingAllMethodsServlet{

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(getSampleData());
    }

    private String getSampleData(){
        JSONArray jsonArray = new JSONArray();

        for(int i = 0; i <= 10; i++){
            JSONObject json = new JSONObject();
            try{
                json.put("text", "Sample Data " + i);
                json.put("value", "Sample Value " + i);
            }catch (Exception e){

            }
            jsonArray.put(json);
        }
        return jsonArray.toString();
    }
}
