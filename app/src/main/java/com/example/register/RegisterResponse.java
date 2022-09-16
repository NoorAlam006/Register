
package com.example.register;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RegisterResponse {

    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("status")
    @Expose
    private Integer status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public class Data {

        @SerializedName("token")
        @Expose
        private String token;
        @SerializedName("name")
        @Expose
        private String name;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

}