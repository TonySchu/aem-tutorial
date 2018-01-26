package myPackage.core.models;

import myPackage.core.AbstractComponent;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SliderModel extends AbstractComponent{

    public String[] getBilder(){
        return getList("bilder");
    }

    public List<SliderElement> getSliderElements(){
        JSONArray jsonArray = getJSONArray("images");
        List <SliderElement> sliderList = new ArrayList<>();

        for(int i = 0; i < jsonArray.length(); i++){
            SliderElement sliderEl = new SliderElement();
            try {
                JSONObject json = jsonArray.getJSONObject(i);
                sliderEl.setPath(json.get("bildPfad").toString());
                sliderEl.setAlt(json.get("alt").toString());
                sliderEl.setText("<p>" + json.get("text").toString() + "</p>");
                sliderEl.setHeadLine("<h3>" + json.get("überschrift").toString() + "</h3>");
                if(i == 0){
                    sliderEl.setCssClass("active");
                }
                // check text content
                if(sliderEl.getText().isEmpty() && sliderEl.getHeadLine().isEmpty()){
                    sliderEl.setHasText(false);
                }else {
                    sliderEl.setHasText(true);
                }

                //add sliderEL to List
                sliderList.add(sliderEl);
            }catch (Exception e){

            }
        }
        return sliderList;
    }





    public class SliderElement{
        String path;
        String alt;
        String headLine;
        String text;

        public boolean isHasText() {
            return isHasText;
        }

        public void setHasText(boolean hasText) {
            isHasText = hasText;
        }

        boolean isHasText;

        public String getCssClass() {
            return cssClass;
        }

        public void setCssClass(String cssClass) {
            this.cssClass = cssClass;
        }

        String cssClass;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getHeadLine() {
            return headLine;
        }

        public void setHeadLine(String headLine) {
            this.headLine = headLine;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }


    }

}
