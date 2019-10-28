package hxz.www.commonbase.model.todo.buinese;

import java.util.List;

/**
 * @Author :rickBei
 * @Date :2019/10/28 20:13
 * @Descripe: From bug to bugs
 **/
public class BusineseTab {

    /**
     * code : 000000
     * msg : null
     * result : {"defaultList":[{"code":"BusinessSharingMechanism","icon":"/upload/20191015/20191015175152fbHhRw.jpg","name":"业务分成机制","style":"diamond"},{"code":"JR_REPAY_PLAN_SOON","icon":"/upload/20191016/20191016092727iYmrdr.png","name":"【金融中心】即将到期","style":"list"},{"code":"FinancialMaturityBusinessStatistics","icon":"","name":"【金融中心】到期业务统计","style":"list"},{"code":"BatchGuaranteeBusinessStatistics","icon":"","name":"【担保业务】批量业务受理统计","style":"diamond"},{"code":"GBusinessCompletionStatistics","icon":"/upload/20191016/20191016092727iYmrdr.png","name":"【担保业务】业务完成统计","style":"list"},{"code":"SmallLoanMaturityBusinessStatistics","icon":"","name":"【小贷业务】到期业务统计APP","style":"list"},{"code":"GPaulStatistics","icon":"/upload/20191016/20191016092727iYmrdr.png","name":"【担保业务】在保业务统计APP","style":"list"},{"code":"AllGDBusiness","icon":"","name":"【汇总统计】担保小贷","style":"list"}],"otherList":[{"code":"SettleDbFeeStatistics","icon":"","name":"【担保业务】担保费结算","style":"list"}],"homeList":[{"code":"ExtensionRecordStatistics","icon":"/upload/20191016/20191016092727iYmrdr.png","name":"【小贷业务】展期记录统计","style":"list"},{"code":"LoaningRecordStatistics","icon":"/upload/20191016/20191016092727iYmrdr.png","name":"【小贷业务】在贷记录统计APP","style":"list"},{"code":"LoanRecordStatistics","icon":"/upload/20191016/20191016092727iYmrdr.png","name":"【小贷业务】承贷记录统计","style":"list"}]}
     */

        private List<DefaultListBean> defaultList;
        private List<OtherListBean> otherList;
        private List<HomeListBean> homeList;

        public List<DefaultListBean> getDefaultList() {
            return defaultList;
        }

        public void setDefaultList(List<DefaultListBean> defaultList) {
            this.defaultList = defaultList;
        }

        public List<OtherListBean> getOtherList() {
            return otherList;
        }

        public void setOtherList(List<OtherListBean> otherList) {
            this.otherList = otherList;
        }

        public List<HomeListBean> getHomeList() {
            return homeList;
        }

        public void setHomeList(List<HomeListBean> homeList) {
            this.homeList = homeList;
        }



        public static class OtherListBean {
            /**
             * code : SettleDbFeeStatistics
             * icon :
             * name : 【担保业务】担保费结算
             * style : list
             */

            private String code;
            private String icon;
            private String name;
            private String style;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getStyle() {
                return style;
            }

            public void setStyle(String style) {
                this.style = style;
            }
        }

        public static class HomeListBean {
            /**
             * code : ExtensionRecordStatistics
             * icon : /upload/20191016/20191016092727iYmrdr.png
             * name : 【小贷业务】展期记录统计
             * style : list
             */

            private String code;
            private String icon;
            private String name;
            private String style;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getStyle() {
                return style;
            }

            public void setStyle(String style) {
                this.style = style;
            }
        }
    }
