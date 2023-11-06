package com.qinruim.ai.zsxq.model.req;

public class ReqData {
    private String text;

    public String[] image_ids = new String[]{};

    public String silenced;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getImage_ids() {
        return image_ids;
    }

    public void setImage_ids(String[] image_ids) {
        this.image_ids = image_ids;
    }

    public String getSilenced() {
        return silenced;
    }

    public void setSilenced(String silenced) {
        this.silenced = silenced;
    }
}
