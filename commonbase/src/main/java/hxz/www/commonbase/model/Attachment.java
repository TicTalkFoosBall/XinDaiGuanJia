package hxz.www.commonbase.model;

import hxz.www.commonbase.util.GsonUtil;

/**
 * @Author :rickBei
 * @Date :2019/10/26 18:39
 * @Descripe: From bug to bugs
 **/
public class Attachment {

        /**
         * id : 98384834488963730
         * remark : 文件上传
         * createdBy : root
         * createdTime : 1572008640000
         * lastUpdBy :
         * deletedBy :
         * groupId : 98384834488963729
         * categoryCode : Attachments
         * categoryName : 附件
         * formGroupCode : OANoticeManagement
         * fileName : 乌镇贷情况说明
         * fileSuffix : .pdf
         * url : http://container_nginx:81/upload/98384834488963729/20191025210359FKYFBi.pdf
         * realPath : /upload/98384834488963729/20191025210359FKYFBi.pdf
         */

        private long id;
        private String remark;
        private String createdBy;
        private long createdTime;
        private String lastUpdBy;
        private String deletedBy;
        private String groupId;
        private String categoryCode;
        private String categoryName;
        private String formGroupCode;
        private String fileName;
        private String fileSuffix;
        private String url;
        private String realPath;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public long getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(long createdTime) {
            this.createdTime = createdTime;
        }

        public String getLastUpdBy() {
            return lastUpdBy;
        }

        public void setLastUpdBy(String lastUpdBy) {
            this.lastUpdBy = lastUpdBy;
        }

        public String getDeletedBy() {
            return deletedBy;
        }

        public void setDeletedBy(String deletedBy) {
            this.deletedBy = deletedBy;
        }

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public String getCategoryCode() {
            return categoryCode;
        }

        public void setCategoryCode(String categoryCode) {
            this.categoryCode = categoryCode;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getFormGroupCode() {
            return formGroupCode;
        }

        public void setFormGroupCode(String formGroupCode) {
            this.formGroupCode = formGroupCode;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getFileSuffix() {
            return fileSuffix;
        }

        public void setFileSuffix(String fileSuffix) {
            this.fileSuffix = fileSuffix;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getRealPath() {
            return realPath;
        }

        public void setRealPath(String realPath) {
            this.realPath = realPath;
        }

    @Override
    public String toString() {
      return   GsonUtil.toJson(this);
    }
}

