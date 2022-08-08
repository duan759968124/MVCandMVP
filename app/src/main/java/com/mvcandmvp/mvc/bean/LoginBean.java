package com.mvcandmvp.mvc.bean;
//bean类
public class LoginBean {

    private int code;
    private String message;
    private DateBean data;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public DateBean getData() {
        return data;
    }

    class DateBean {

        private int task;
        private int software;
        private String inputContent;

        public int getTask() {
            return task;
        }

        public int getSoftware() {
            return software;
        }

        public String getInputContent() {
            return inputContent;
        }
    }


}
