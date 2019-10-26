package hxz.www.commonbase.model.todo.detail;

import java.util.List;

import hxz.www.commonbase.util.GsonUtil;

public class ApprovalResultListBean {
    /**
     * default : false
     * code : OK
     * nextNodes : [{"nodeKey":""}]
     * isEnd : false
     * desc : 同意
     * validate : true
     */


    private String defaultX;
    private String code;
    private String isEnd;
    private String desc;
    private String validate;
    private List<NextNodesBean> nextNodes;

    public String getDefaultX() {
        return defaultX;
    }

    public void setDefaultX(String defaultX) {
        this.defaultX = defaultX;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(String isEnd) {
        this.isEnd = isEnd;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

    public List<NextNodesBean> getNextNodes() {
        return nextNodes;
    }

    public void setNextNodes(List<NextNodesBean> nextNodes) {
        this.nextNodes = nextNodes;
    }

    public static class NextNodesBean {
        /**
         * nodeKey :
         */

        private String nodeKey;

        public String getNodeKey() {
            return nodeKey;
        }

        public void setNodeKey(String nodeKey) {
            this.nodeKey = nodeKey;
        }
    }

    public String toString() {
        return GsonUtil.toJson(this);
    }
}

