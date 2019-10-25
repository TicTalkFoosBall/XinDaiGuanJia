/**
  * Copyright 2019 bejson.com 
  */
package hxz.www.commonbase.model.todo;

import java.io.Serializable;

public class Result implements Serializable {

    private String code;
    private String desc;
    private String isEnd;
    private String jumpEnabled;
    private String enabled;
    private String nextNodes;
    public void setCode(String code) {
         this.code = code;
     }
     public String getCode() {
         return code;
     }

    public void setDesc(String desc) {
         this.desc = desc;
     }
     public String getDesc() {
         return desc;
     }

    public void setIsEnd(String isEnd) {
         this.isEnd = isEnd;
     }
     public String getIsEnd() {
         return isEnd;
     }

    public void setJumpEnabled(String jumpEnabled) {
         this.jumpEnabled = jumpEnabled;
     }
     public String getJumpEnabled() {
         return jumpEnabled;
     }

    public void setEnabled(String enabled) {
         this.enabled = enabled;
     }
     public String getEnabled() {
         return enabled;
     }

    public void setNextNodes(String nextNodes) {
         this.nextNodes = nextNodes;
     }
     public String getNextNodes() {
         return nextNodes;
     }

}