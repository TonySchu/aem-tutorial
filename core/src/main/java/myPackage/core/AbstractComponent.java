package myPackage.core;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.wcm.api.components.ComponentContext;
import com.day.cq.wcm.commons.WCMUtils;
import org.apache.sling.commons.json.JSONArray;

public class AbstractComponent extends WCMUsePojo{

    ComponentContext context;

    @Override
    public void activate() {
        context = WCMUtils.getComponentContext(getRequest());
    }

    public String getText(String attr){
        return context.getResource().getValueMap().get(attr, java.lang.String.class);
    }

    // getNumber()

    public String[] getList(String attr){
        return context.getResource().getValueMap().get(attr, java.lang.String[].class);
    }

    public boolean isEditMode(){
        return getWcmMode().isEdit();
    }

    public JSONArray getJSONArray(String attr){
        String jsonArrayString = getText(attr);
        JSONArray jsonArray = 


    }








}
