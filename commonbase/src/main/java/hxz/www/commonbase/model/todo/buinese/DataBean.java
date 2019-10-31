package hxz.www.commonbase.model.todo.buinese;

import java.io.Serializable;

import hxz.www.commonbase.util.GsonUtil;

public  class DataBean implements Serializable {

        private String Status;
        private String CREATED_TIME;
        private String BusinessNo;
        private String PMB;
        private String PMA;
        private String ProductCode;
        private String ShouxinAmount;
        private String Rate;
        private String Amount;
        private String KehuName;
        private String ZhuhetongNo;
        private String EndDate;
        private String Backway;
        private String QiShu;
        private String BeginDate;
        private String ID;
        private String RM;

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public String getStatus() {
            return Status;
        }

        public void setCREATED_TIME(String CREATED_TIME) {
            this.CREATED_TIME = CREATED_TIME;
        }

        public String getCREATED_TIME() {
            return CREATED_TIME;
        }

        public void setBusinessNo(String BusinessNo) {
            this.BusinessNo = BusinessNo;
        }

        public String getBusinessNo() {
            return BusinessNo;
        }

        public void setPMB(String PMB) {
            this.PMB = PMB;
        }

        public String getPMB() {
            return PMB;
        }

        public void setPMA(String PMA) {
            this.PMA = PMA;
        }

        public String getPMA() {
            return PMA;
        }

        public void setProductCode(String ProductCode) {
            this.ProductCode = ProductCode;
        }

        public String getProductCode() {
            return ProductCode;
        }

        public void setShouxinAmount(String ShouxinAmount) {
            this.ShouxinAmount = ShouxinAmount;
        }

        public String getShouxinAmount() {
            return ShouxinAmount;
        }

        public void setRate(String Rate) {
            this.Rate = Rate;
        }

        public String getRate() {
            return Rate;
        }

        public void setAmount(String Amount) {
            this.Amount = Amount;
        }

        public String getAmount() {
            return Amount;
        }

        public void setKehuName(String KehuName) {
            this.KehuName = KehuName;
        }

        public String getKehuName() {
            return KehuName;
        }

        public void setZhuhetongNo(String ZhuhetongNo) {
            this.ZhuhetongNo = ZhuhetongNo;
        }

        public String getZhuhetongNo() {
            return ZhuhetongNo;
        }

        public void setEndDate(String EndDate) {
            this.EndDate = EndDate;
        }

        public String getEndDate() {
            return EndDate;
        }

        public void setBackway(String Backway) {
            this.Backway = Backway;
        }

        public String getBackway() {
            return Backway;
        }

        public void setQiShu(String QiShu) {
            this.QiShu = QiShu;
        }

        public String getQiShu() {
            return QiShu;
        }

        public void setBeginDate(String BeginDate) {
            this.BeginDate = BeginDate;
        }

        public String getBeginDate() {
            return BeginDate;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getID() {
            return ID;
        }

        public void setRM(String RM) {
            this.RM = RM;
        }

        public String getRM() {
            return RM;
        }

        @Override
        public String toString() {
            return GsonUtil.toJson(this);
        }
}