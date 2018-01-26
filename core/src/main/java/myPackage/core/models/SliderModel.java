package myPackage.core.models;

import myPackage.core.AbstractComponent;

import java.util.List;

public class SliderModel extends AbstractComponent{

    public String[] getBilder(){
        return getList("bilder");
    }

    public List<SliderElement> arrayListToSliderList(){
        return null;
    }



    class SliderElement{
        String path;
        String alt;

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

        String headLine;
        String text;
    }

}
