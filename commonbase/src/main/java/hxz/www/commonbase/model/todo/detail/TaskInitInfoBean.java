package hxz.www.commonbase.model.todo.detail;


import java.util.List;

public   class TaskInitInfoBean {

            private DataBean data;
            private Object totalCount;
            private Object resultMap;

            public DataBean getData() {
                return data;
            }

            public void setData(DataBean data) {
                this.data = data;
            }

            public Object getTotalCount() {
                return totalCount;
            }

            public void setTotalCount(Object totalCount) {
                this.totalCount = totalCount;
            }

            public Object getResultMap() {
                return resultMap;
            }

            public void setResultMap(Object resultMap) {
                this.resultMap = resultMap;
            }

            public static class DataBean {

                private Object procDesc;
                private NextApprovalUserMapBean nextApprovalUserMap;
                private ExtendInfoBean extendInfo;
                private List<?> nextNodeList;
                private List<ExperiencedListBean> experiencedList;
                private List<AllNodeListBean> allNodeList;
                private List<?> nextBrancheList;

                public Object getProcDesc() {
                    return procDesc;
                }

                public void setProcDesc(Object procDesc) {
                    this.procDesc = procDesc;
                }

                public NextApprovalUserMapBean getNextApprovalUserMap() {
                    return nextApprovalUserMap;
                }

                public void setNextApprovalUserMap(NextApprovalUserMapBean nextApprovalUserMap) {
                    this.nextApprovalUserMap = nextApprovalUserMap;
                }

                public ExtendInfoBean getExtendInfo() {
                    return extendInfo;
                }

                public void setExtendInfo(ExtendInfoBean extendInfo) {
                    this.extendInfo = extendInfo;
                }

                public List<?> getNextNodeList() {
                    return nextNodeList;
                }

                public void setNextNodeList(List<?> nextNodeList) {
                    this.nextNodeList = nextNodeList;
                }

                public List<ExperiencedListBean> getExperiencedList() {
                    return experiencedList;
                }

                public void setExperiencedList(List<ExperiencedListBean> experiencedList) {
                    this.experiencedList = experiencedList;
                }

                public List<AllNodeListBean> getAllNodeList() {
                    return allNodeList;
                }

                public void setAllNodeList(List<AllNodeListBean> allNodeList) {
                    this.allNodeList = allNodeList;
                }

                public List<?> getNextBrancheList() {
                    return nextBrancheList;
                }

                public void setNextBrancheList(List<?> nextBrancheList) {
                    this.nextBrancheList = nextBrancheList;
                }

                public static class NextApprovalUserMapBean {
                    private List<ApplyBean> Apply;
                    private List<ApproveBean> approve;
                    private List<SettleBean> settle;

                    public List<ApplyBean> getApply() {
                        return Apply;
                    }

                    public void setApply(List<ApplyBean> Apply) {
                        this.Apply = Apply;
                    }

                    public List<ApproveBean> getApprove() {
                        return approve;
                    }

                    public void setApprove(List<ApproveBean> approve) {
                        this.approve = approve;
                    }

                    public List<SettleBean> getSettle() {
                        return settle;
                    }

                    public void setSettle(List<SettleBean> settle) {
                        this.settle = settle;
                    }

                    public static class ApplyBean {
                        /**
                         * id : 98092356963664117
                         * pId : null
                         * name : null
                         * nodeType : null
                         * isParent : null
                         * checked : false
                         * open : null
                         * isSelected : null
                         * fullPath : null
                         * title : null
                         * username : 13310789268
                         * password : null
                         * fullname : 蒋莉
                         * mobile : null
                         * idNo : null
                         * roles : null
                         * department : null
                         * sex : null
                         * nativePlace : null
                         * telephone : null
                         * email : null
                         * politicalStatus : null
                         * job : null
                         * graduationDate : null
                         * entryDate : null
                         * demissionDate : null
                         * converseDate : null
                         * trasferDate : null
                         * socialSecurityDate : null
                         * servingAge : null
                         * onDutyAge : null
                         * workingAge : null
                         * birthday : null
                         * age : null
                         * education : null
                         * school : null
                         * professtionalTitle : null
                         * professional : null
                         * econtactorName : null
                         * econtactorRelation : null
                         * econtactorTel : null
                         * homeAddress : null
                         * censusRegister : null
                         * entryBatch : null
                         * fstContractBeginDate : null
                         * fstContractEndDate : null
                         * scdContractBeginDate : null
                         * scdContractEndDate : null
                         * thdContractBeginDate : null
                         * thdContractEndDate : null
                         * annualLeaveDays : null
                         * lieuLeaveDays : null
                         * surplusAnnualLeaveDays : null
                         * surplusLieuLeaveDays : null
                         * annualSalary : null
                         * socialSecurityBase : null
                         * telSubsidy : null
                         * otherSalary : null
                         * isOnJob : null
                         * isBlock : null
                         * blockReason : null
                         * blockDate : null
                         * isErasable : null
                         * failAttempts : null
                         * lastLoginDate : null
                         * resetPwdDate : null
                         * createdBy : null
                         * createdTime : null
                         * lastUpdBy : null
                         * lastUpdTime : null
                         * deletedBy : null
                         * deletedTime : null
                         * reserveddecimal1 : null
                         * reserveddecimal2 : null
                         * reserveddecimal3 : null
                         * reserveddecimal4 : null
                         * reserveddecimal5 : null
                         * extendInfo : null
                         * actAssigneeFlag : null
                         * actAssigneeId : null
                         * actProcessKeyList : null
                         * resume : null
                         * remark : null
                         * reservedstring1 : null
                         * reservedstring2 : null
                         * reservedstring3 : null
                         * reservedstring4 : null
                         * reservedstring5 : null
                         * accessibleDeptCodes : null
                         * accessibleRoleCodes : null
                         * accessibleDeptCodesStr : null
                         * accessibleRoleCodesStr : null
                         * instIdPathList : null
                         * instList : [{"id":"98092356963663982","pId":null,"name":"鼎元小额贷款公司","nodeType":null,"isParent":null,"checked":false,"open":null,"isSelected":null,"fullPath":null,"title":null,"code":null,"sortNo":null,"remark":null,"version":null,"children":null,"userList":null,"extendInfo":null,"parent":null}]
                         * roleList : [{"id":"98092356963849233","pId":null,"name":"小贷放款经理","nodeType":null,"isParent":null,"checked":false,"open":null,"isSelected":null,"fullPath":null,"title":null,"code":null,"description":"[13310789268]蒋莉","category":null,"userList":null,"extendInfo":null,"parent":null},{"id":"98092356963665437","pId":null,"name":"小贷预审会委员","nodeType":null,"isParent":null,"checked":false,"open":null,"isSelected":null,"fullPath":null,"title":null,"code":null,"description":"[13310789268]蒋莉","category":null,"userList":null,"extendInfo":null,"parent":null},{"id":"98092356963663983","pId":null,"name":"【部门】鼎元小额贷款公司","nodeType":null,"isParent":null,"checked":false,"open":null,"isSelected":null,"fullPath":null,"title":null,"code":null,"description":"[13310789268]蒋莉","category":null,"userList":null,"extendInfo":null,"parent":null},{"id":"98092356963667811","pId":null,"name":"公司员工","nodeType":null,"isParent":null,"checked":false,"open":null,"isSelected":null,"fullPath":null,"title":null,"code":null,"description":"[13310789268]蒋莉","category":null,"userList":null,"extendInfo":null,"parent":null},{"id":"98092356963665445","pId":null,"name":"客户经理","nodeType":null,"isParent":null,"checked":false,"open":null,"isSelected":null,"fullPath":null,"title":null,"code":null,"description":"[13310789268]蒋莉","category":null,"userList":null,"extendInfo":null,"parent":null},{"id":"98092356963703367","pId":null,"name":"鼎元小贷客户经理","nodeType":null,"isParent":null,"checked":false,"open":null,"isSelected":null,"fullPath":null,"title":null,"code":null,"description":"[13310789268]蒋莉","category":null,"userList":null,"extendInfo":null,"parent":null},{"id":"98092356963668299","pId":null,"name":"小贷部门经理","nodeType":null,"isParent":null,"checked":false,"open":null,"isSelected":null,"fullPath":null,"title":null,"code":null,"description":"[13310789268]蒋莉","category":null,"userList":null,"extendInfo":null,"parent":null}]
                         * roleIds : null
                         * roleIdList : null
                         * roleCodes : null
                         * roleCodeList : null
                         * roleNames : null
                         * roleNameList : null
                         * description : [13310789268]蒋莉
                         * groupId : null
                         * groupCode : null
                         * groupName : null
                         * companyId : null
                         * companyCode : null
                         * companyName : null
                         * departmentName : null
                         * departmentCode : null
                         * departmentId : null
                         * departmentIds : null
                         * departmentIdList : null
                         * departmentCodes : null
                         * departmentCodeList : null
                         * departmentNames : null
                         * departmentNameList : null
                         * departmentExtendInfo : null
                         * profileAttachmentId : null
                         * profileHttpUrl : null
                         * parent : null
                         */

                        private String id;
                        private Object pId;
                        private Object name;
                        private Object nodeType;
                        private Object isParent;
                        private boolean checked;
                        private Object open;
                        private Object isSelected;
                        private Object fullPath;
                        private Object title;
                        private String username;
                        private Object password;
                        private String fullname;
                        private Object mobile;
                        private Object idNo;
                        private Object roles;
                        private Object department;
                        private Object sex;
                        private Object nativePlace;
                        private Object telephone;
                        private Object email;
                        private Object politicalStatus;
                        private Object job;
                        private Object graduationDate;
                        private Object entryDate;
                        private Object demissionDate;
                        private Object converseDate;
                        private Object trasferDate;
                        private Object socialSecurityDate;
                        private Object servingAge;
                        private Object onDutyAge;
                        private Object workingAge;
                        private Object birthday;
                        private Object age;
                        private Object education;
                        private Object school;
                        private Object professtionalTitle;
                        private Object professional;
                        private Object econtactorName;
                        private Object econtactorRelation;
                        private Object econtactorTel;
                        private Object homeAddress;
                        private Object censusRegister;
                        private Object entryBatch;
                        private Object fstContractBeginDate;
                        private Object fstContractEndDate;
                        private Object scdContractBeginDate;
                        private Object scdContractEndDate;
                        private Object thdContractBeginDate;
                        private Object thdContractEndDate;
                        private Object annualLeaveDays;
                        private Object lieuLeaveDays;
                        private Object surplusAnnualLeaveDays;
                        private Object surplusLieuLeaveDays;
                        private Object annualSalary;
                        private Object socialSecurityBase;
                        private Object telSubsidy;
                        private Object otherSalary;
                        private Object isOnJob;
                        private Object isBlock;
                        private Object blockReason;
                        private Object blockDate;
                        private Object isErasable;
                        private Object failAttempts;
                        private Object lastLoginDate;
                        private Object resetPwdDate;
                        private Object createdBy;
                        private Object createdTime;
                        private Object lastUpdBy;
                        private Object lastUpdTime;
                        private Object deletedBy;
                        private Object deletedTime;
                        private Object reserveddecimal1;
                        private Object reserveddecimal2;
                        private Object reserveddecimal3;
                        private Object reserveddecimal4;
                        private Object reserveddecimal5;
                        private Object extendInfo;
                        private Object actAssigneeFlag;
                        private Object actAssigneeId;
                        private Object actProcessKeyList;
                        private Object resume;
                        private Object remark;
                        private Object reservedstring1;
                        private Object reservedstring2;
                        private Object reservedstring3;
                        private Object reservedstring4;
                        private Object reservedstring5;
                        private Object accessibleDeptCodes;
                        private Object accessibleRoleCodes;
                        private Object accessibleDeptCodesStr;
                        private Object accessibleRoleCodesStr;
                        private Object instIdPathList;
                        private Object roleIds;
                        private Object roleIdList;
                        private Object roleCodes;
                        private Object roleCodeList;
                        private Object roleNames;
                        private Object roleNameList;
                        private String description;
                        private Object groupId;
                        private Object groupCode;
                        private Object groupName;
                        private Object companyId;
                        private Object companyCode;
                        private Object companyName;
                        private Object departmentName;
                        private Object departmentCode;
                        private Object departmentId;
                        private Object departmentIds;
                        private Object departmentIdList;
                        private Object departmentCodes;
                        private Object departmentCodeList;
                        private Object departmentNames;
                        private Object departmentNameList;
                        private Object departmentExtendInfo;
                        private Object profileAttachmentId;
                        private Object profileHttpUrl;
                        private Object parent;
                        private List<InstListBean> instList;
                        private List<RoleListBean> roleList;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public Object getPId() {
                            return pId;
                        }

                        public void setPId(Object pId) {
                            this.pId = pId;
                        }

                        public Object getName() {
                            return name;
                        }

                        public void setName(Object name) {
                            this.name = name;
                        }

                        public Object getNodeType() {
                            return nodeType;
                        }

                        public void setNodeType(Object nodeType) {
                            this.nodeType = nodeType;
                        }

                        public Object getIsParent() {
                            return isParent;
                        }

                        public void setIsParent(Object isParent) {
                            this.isParent = isParent;
                        }

                        public boolean isChecked() {
                            return checked;
                        }

                        public void setChecked(boolean checked) {
                            this.checked = checked;
                        }

                        public Object getOpen() {
                            return open;
                        }

                        public void setOpen(Object open) {
                            this.open = open;
                        }

                        public Object getIsSelected() {
                            return isSelected;
                        }

                        public void setIsSelected(Object isSelected) {
                            this.isSelected = isSelected;
                        }

                        public Object getFullPath() {
                            return fullPath;
                        }

                        public void setFullPath(Object fullPath) {
                            this.fullPath = fullPath;
                        }

                        public Object getTitle() {
                            return title;
                        }

                        public void setTitle(Object title) {
                            this.title = title;
                        }

                        public String getUsername() {
                            return username;
                        }

                        public void setUsername(String username) {
                            this.username = username;
                        }

                        public Object getPassword() {
                            return password;
                        }

                        public void setPassword(Object password) {
                            this.password = password;
                        }

                        public String getFullname() {
                            return fullname;
                        }

                        public void setFullname(String fullname) {
                            this.fullname = fullname;
                        }

                        public Object getMobile() {
                            return mobile;
                        }

                        public void setMobile(Object mobile) {
                            this.mobile = mobile;
                        }

                        public Object getIdNo() {
                            return idNo;
                        }

                        public void setIdNo(Object idNo) {
                            this.idNo = idNo;
                        }

                        public Object getRoles() {
                            return roles;
                        }

                        public void setRoles(Object roles) {
                            this.roles = roles;
                        }

                        public Object getDepartment() {
                            return department;
                        }

                        public void setDepartment(Object department) {
                            this.department = department;
                        }

                        public Object getSex() {
                            return sex;
                        }

                        public void setSex(Object sex) {
                            this.sex = sex;
                        }

                        public Object getNativePlace() {
                            return nativePlace;
                        }

                        public void setNativePlace(Object nativePlace) {
                            this.nativePlace = nativePlace;
                        }

                        public Object getTelephone() {
                            return telephone;
                        }

                        public void setTelephone(Object telephone) {
                            this.telephone = telephone;
                        }

                        public Object getEmail() {
                            return email;
                        }

                        public void setEmail(Object email) {
                            this.email = email;
                        }

                        public Object getPoliticalStatus() {
                            return politicalStatus;
                        }

                        public void setPoliticalStatus(Object politicalStatus) {
                            this.politicalStatus = politicalStatus;
                        }

                        public Object getJob() {
                            return job;
                        }

                        public void setJob(Object job) {
                            this.job = job;
                        }

                        public Object getGraduationDate() {
                            return graduationDate;
                        }

                        public void setGraduationDate(Object graduationDate) {
                            this.graduationDate = graduationDate;
                        }

                        public Object getEntryDate() {
                            return entryDate;
                        }

                        public void setEntryDate(Object entryDate) {
                            this.entryDate = entryDate;
                        }

                        public Object getDemissionDate() {
                            return demissionDate;
                        }

                        public void setDemissionDate(Object demissionDate) {
                            this.demissionDate = demissionDate;
                        }

                        public Object getConverseDate() {
                            return converseDate;
                        }

                        public void setConverseDate(Object converseDate) {
                            this.converseDate = converseDate;
                        }

                        public Object getTrasferDate() {
                            return trasferDate;
                        }

                        public void setTrasferDate(Object trasferDate) {
                            this.trasferDate = trasferDate;
                        }

                        public Object getSocialSecurityDate() {
                            return socialSecurityDate;
                        }

                        public void setSocialSecurityDate(Object socialSecurityDate) {
                            this.socialSecurityDate = socialSecurityDate;
                        }

                        public Object getServingAge() {
                            return servingAge;
                        }

                        public void setServingAge(Object servingAge) {
                            this.servingAge = servingAge;
                        }

                        public Object getOnDutyAge() {
                            return onDutyAge;
                        }

                        public void setOnDutyAge(Object onDutyAge) {
                            this.onDutyAge = onDutyAge;
                        }

                        public Object getWorkingAge() {
                            return workingAge;
                        }

                        public void setWorkingAge(Object workingAge) {
                            this.workingAge = workingAge;
                        }

                        public Object getBirthday() {
                            return birthday;
                        }

                        public void setBirthday(Object birthday) {
                            this.birthday = birthday;
                        }

                        public Object getAge() {
                            return age;
                        }

                        public void setAge(Object age) {
                            this.age = age;
                        }

                        public Object getEducation() {
                            return education;
                        }

                        public void setEducation(Object education) {
                            this.education = education;
                        }

                        public Object getSchool() {
                            return school;
                        }

                        public void setSchool(Object school) {
                            this.school = school;
                        }

                        public Object getProfesstionalTitle() {
                            return professtionalTitle;
                        }

                        public void setProfesstionalTitle(Object professtionalTitle) {
                            this.professtionalTitle = professtionalTitle;
                        }

                        public Object getProfessional() {
                            return professional;
                        }

                        public void setProfessional(Object professional) {
                            this.professional = professional;
                        }

                        public Object getEcontactorName() {
                            return econtactorName;
                        }

                        public void setEcontactorName(Object econtactorName) {
                            this.econtactorName = econtactorName;
                        }

                        public Object getEcontactorRelation() {
                            return econtactorRelation;
                        }

                        public void setEcontactorRelation(Object econtactorRelation) {
                            this.econtactorRelation = econtactorRelation;
                        }

                        public Object getEcontactorTel() {
                            return econtactorTel;
                        }

                        public void setEcontactorTel(Object econtactorTel) {
                            this.econtactorTel = econtactorTel;
                        }

                        public Object getHomeAddress() {
                            return homeAddress;
                        }

                        public void setHomeAddress(Object homeAddress) {
                            this.homeAddress = homeAddress;
                        }

                        public Object getCensusRegister() {
                            return censusRegister;
                        }

                        public void setCensusRegister(Object censusRegister) {
                            this.censusRegister = censusRegister;
                        }

                        public Object getEntryBatch() {
                            return entryBatch;
                        }

                        public void setEntryBatch(Object entryBatch) {
                            this.entryBatch = entryBatch;
                        }

                        public Object getFstContractBeginDate() {
                            return fstContractBeginDate;
                        }

                        public void setFstContractBeginDate(Object fstContractBeginDate) {
                            this.fstContractBeginDate = fstContractBeginDate;
                        }

                        public Object getFstContractEndDate() {
                            return fstContractEndDate;
                        }

                        public void setFstContractEndDate(Object fstContractEndDate) {
                            this.fstContractEndDate = fstContractEndDate;
                        }

                        public Object getScdContractBeginDate() {
                            return scdContractBeginDate;
                        }

                        public void setScdContractBeginDate(Object scdContractBeginDate) {
                            this.scdContractBeginDate = scdContractBeginDate;
                        }

                        public Object getScdContractEndDate() {
                            return scdContractEndDate;
                        }

                        public void setScdContractEndDate(Object scdContractEndDate) {
                            this.scdContractEndDate = scdContractEndDate;
                        }

                        public Object getThdContractBeginDate() {
                            return thdContractBeginDate;
                        }

                        public void setThdContractBeginDate(Object thdContractBeginDate) {
                            this.thdContractBeginDate = thdContractBeginDate;
                        }

                        public Object getThdContractEndDate() {
                            return thdContractEndDate;
                        }

                        public void setThdContractEndDate(Object thdContractEndDate) {
                            this.thdContractEndDate = thdContractEndDate;
                        }

                        public Object getAnnualLeaveDays() {
                            return annualLeaveDays;
                        }

                        public void setAnnualLeaveDays(Object annualLeaveDays) {
                            this.annualLeaveDays = annualLeaveDays;
                        }

                        public Object getLieuLeaveDays() {
                            return lieuLeaveDays;
                        }

                        public void setLieuLeaveDays(Object lieuLeaveDays) {
                            this.lieuLeaveDays = lieuLeaveDays;
                        }

                        public Object getSurplusAnnualLeaveDays() {
                            return surplusAnnualLeaveDays;
                        }

                        public void setSurplusAnnualLeaveDays(Object surplusAnnualLeaveDays) {
                            this.surplusAnnualLeaveDays = surplusAnnualLeaveDays;
                        }

                        public Object getSurplusLieuLeaveDays() {
                            return surplusLieuLeaveDays;
                        }

                        public void setSurplusLieuLeaveDays(Object surplusLieuLeaveDays) {
                            this.surplusLieuLeaveDays = surplusLieuLeaveDays;
                        }

                        public Object getAnnualSalary() {
                            return annualSalary;
                        }

                        public void setAnnualSalary(Object annualSalary) {
                            this.annualSalary = annualSalary;
                        }

                        public Object getSocialSecurityBase() {
                            return socialSecurityBase;
                        }

                        public void setSocialSecurityBase(Object socialSecurityBase) {
                            this.socialSecurityBase = socialSecurityBase;
                        }

                        public Object getTelSubsidy() {
                            return telSubsidy;
                        }

                        public void setTelSubsidy(Object telSubsidy) {
                            this.telSubsidy = telSubsidy;
                        }

                        public Object getOtherSalary() {
                            return otherSalary;
                        }

                        public void setOtherSalary(Object otherSalary) {
                            this.otherSalary = otherSalary;
                        }

                        public Object getIsOnJob() {
                            return isOnJob;
                        }

                        public void setIsOnJob(Object isOnJob) {
                            this.isOnJob = isOnJob;
                        }

                        public Object getIsBlock() {
                            return isBlock;
                        }

                        public void setIsBlock(Object isBlock) {
                            this.isBlock = isBlock;
                        }

                        public Object getBlockReason() {
                            return blockReason;
                        }

                        public void setBlockReason(Object blockReason) {
                            this.blockReason = blockReason;
                        }

                        public Object getBlockDate() {
                            return blockDate;
                        }

                        public void setBlockDate(Object blockDate) {
                            this.blockDate = blockDate;
                        }

                        public Object getIsErasable() {
                            return isErasable;
                        }

                        public void setIsErasable(Object isErasable) {
                            this.isErasable = isErasable;
                        }

                        public Object getFailAttempts() {
                            return failAttempts;
                        }

                        public void setFailAttempts(Object failAttempts) {
                            this.failAttempts = failAttempts;
                        }

                        public Object getLastLoginDate() {
                            return lastLoginDate;
                        }

                        public void setLastLoginDate(Object lastLoginDate) {
                            this.lastLoginDate = lastLoginDate;
                        }

                        public Object getResetPwdDate() {
                            return resetPwdDate;
                        }

                        public void setResetPwdDate(Object resetPwdDate) {
                            this.resetPwdDate = resetPwdDate;
                        }

                        public Object getCreatedBy() {
                            return createdBy;
                        }

                        public void setCreatedBy(Object createdBy) {
                            this.createdBy = createdBy;
                        }

                        public Object getCreatedTime() {
                            return createdTime;
                        }

                        public void setCreatedTime(Object createdTime) {
                            this.createdTime = createdTime;
                        }

                        public Object getLastUpdBy() {
                            return lastUpdBy;
                        }

                        public void setLastUpdBy(Object lastUpdBy) {
                            this.lastUpdBy = lastUpdBy;
                        }

                        public Object getLastUpdTime() {
                            return lastUpdTime;
                        }

                        public void setLastUpdTime(Object lastUpdTime) {
                            this.lastUpdTime = lastUpdTime;
                        }

                        public Object getDeletedBy() {
                            return deletedBy;
                        }

                        public void setDeletedBy(Object deletedBy) {
                            this.deletedBy = deletedBy;
                        }

                        public Object getDeletedTime() {
                            return deletedTime;
                        }

                        public void setDeletedTime(Object deletedTime) {
                            this.deletedTime = deletedTime;
                        }

                        public Object getReserveddecimal1() {
                            return reserveddecimal1;
                        }

                        public void setReserveddecimal1(Object reserveddecimal1) {
                            this.reserveddecimal1 = reserveddecimal1;
                        }

                        public Object getReserveddecimal2() {
                            return reserveddecimal2;
                        }

                        public void setReserveddecimal2(Object reserveddecimal2) {
                            this.reserveddecimal2 = reserveddecimal2;
                        }

                        public Object getReserveddecimal3() {
                            return reserveddecimal3;
                        }

                        public void setReserveddecimal3(Object reserveddecimal3) {
                            this.reserveddecimal3 = reserveddecimal3;
                        }

                        public Object getReserveddecimal4() {
                            return reserveddecimal4;
                        }

                        public void setReserveddecimal4(Object reserveddecimal4) {
                            this.reserveddecimal4 = reserveddecimal4;
                        }

                        public Object getReserveddecimal5() {
                            return reserveddecimal5;
                        }

                        public void setReserveddecimal5(Object reserveddecimal5) {
                            this.reserveddecimal5 = reserveddecimal5;
                        }

                        public Object getExtendInfo() {
                            return extendInfo;
                        }

                        public void setExtendInfo(Object extendInfo) {
                            this.extendInfo = extendInfo;
                        }

                        public Object getActAssigneeFlag() {
                            return actAssigneeFlag;
                        }

                        public void setActAssigneeFlag(Object actAssigneeFlag) {
                            this.actAssigneeFlag = actAssigneeFlag;
                        }

                        public Object getActAssigneeId() {
                            return actAssigneeId;
                        }

                        public void setActAssigneeId(Object actAssigneeId) {
                            this.actAssigneeId = actAssigneeId;
                        }

                        public Object getActProcessKeyList() {
                            return actProcessKeyList;
                        }

                        public void setActProcessKeyList(Object actProcessKeyList) {
                            this.actProcessKeyList = actProcessKeyList;
                        }

                        public Object getResume() {
                            return resume;
                        }

                        public void setResume(Object resume) {
                            this.resume = resume;
                        }

                        public Object getRemark() {
                            return remark;
                        }

                        public void setRemark(Object remark) {
                            this.remark = remark;
                        }

                        public Object getReservedstring1() {
                            return reservedstring1;
                        }

                        public void setReservedstring1(Object reservedstring1) {
                            this.reservedstring1 = reservedstring1;
                        }

                        public Object getReservedstring2() {
                            return reservedstring2;
                        }

                        public void setReservedstring2(Object reservedstring2) {
                            this.reservedstring2 = reservedstring2;
                        }

                        public Object getReservedstring3() {
                            return reservedstring3;
                        }

                        public void setReservedstring3(Object reservedstring3) {
                            this.reservedstring3 = reservedstring3;
                        }

                        public Object getReservedstring4() {
                            return reservedstring4;
                        }

                        public void setReservedstring4(Object reservedstring4) {
                            this.reservedstring4 = reservedstring4;
                        }

                        public Object getReservedstring5() {
                            return reservedstring5;
                        }

                        public void setReservedstring5(Object reservedstring5) {
                            this.reservedstring5 = reservedstring5;
                        }

                        public Object getAccessibleDeptCodes() {
                            return accessibleDeptCodes;
                        }

                        public void setAccessibleDeptCodes(Object accessibleDeptCodes) {
                            this.accessibleDeptCodes = accessibleDeptCodes;
                        }

                        public Object getAccessibleRoleCodes() {
                            return accessibleRoleCodes;
                        }

                        public void setAccessibleRoleCodes(Object accessibleRoleCodes) {
                            this.accessibleRoleCodes = accessibleRoleCodes;
                        }

                        public Object getAccessibleDeptCodesStr() {
                            return accessibleDeptCodesStr;
                        }

                        public void setAccessibleDeptCodesStr(Object accessibleDeptCodesStr) {
                            this.accessibleDeptCodesStr = accessibleDeptCodesStr;
                        }

                        public Object getAccessibleRoleCodesStr() {
                            return accessibleRoleCodesStr;
                        }

                        public void setAccessibleRoleCodesStr(Object accessibleRoleCodesStr) {
                            this.accessibleRoleCodesStr = accessibleRoleCodesStr;
                        }

                        public Object getInstIdPathList() {
                            return instIdPathList;
                        }

                        public void setInstIdPathList(Object instIdPathList) {
                            this.instIdPathList = instIdPathList;
                        }

                        public Object getRoleIds() {
                            return roleIds;
                        }

                        public void setRoleIds(Object roleIds) {
                            this.roleIds = roleIds;
                        }

                        public Object getRoleIdList() {
                            return roleIdList;
                        }

                        public void setRoleIdList(Object roleIdList) {
                            this.roleIdList = roleIdList;
                        }

                        public Object getRoleCodes() {
                            return roleCodes;
                        }

                        public void setRoleCodes(Object roleCodes) {
                            this.roleCodes = roleCodes;
                        }

                        public Object getRoleCodeList() {
                            return roleCodeList;
                        }

                        public void setRoleCodeList(Object roleCodeList) {
                            this.roleCodeList = roleCodeList;
                        }

                        public Object getRoleNames() {
                            return roleNames;
                        }

                        public void setRoleNames(Object roleNames) {
                            this.roleNames = roleNames;
                        }

                        public Object getRoleNameList() {
                            return roleNameList;
                        }

                        public void setRoleNameList(Object roleNameList) {
                            this.roleNameList = roleNameList;
                        }

                        public String getDescription() {
                            return description;
                        }

                        public void setDescription(String description) {
                            this.description = description;
                        }

                        public Object getGroupId() {
                            return groupId;
                        }

                        public void setGroupId(Object groupId) {
                            this.groupId = groupId;
                        }

                        public Object getGroupCode() {
                            return groupCode;
                        }

                        public void setGroupCode(Object groupCode) {
                            this.groupCode = groupCode;
                        }

                        public Object getGroupName() {
                            return groupName;
                        }

                        public void setGroupName(Object groupName) {
                            this.groupName = groupName;
                        }

                        public Object getCompanyId() {
                            return companyId;
                        }

                        public void setCompanyId(Object companyId) {
                            this.companyId = companyId;
                        }

                        public Object getCompanyCode() {
                            return companyCode;
                        }

                        public void setCompanyCode(Object companyCode) {
                            this.companyCode = companyCode;
                        }

                        public Object getCompanyName() {
                            return companyName;
                        }

                        public void setCompanyName(Object companyName) {
                            this.companyName = companyName;
                        }

                        public Object getDepartmentName() {
                            return departmentName;
                        }

                        public void setDepartmentName(Object departmentName) {
                            this.departmentName = departmentName;
                        }

                        public Object getDepartmentCode() {
                            return departmentCode;
                        }

                        public void setDepartmentCode(Object departmentCode) {
                            this.departmentCode = departmentCode;
                        }

                        public Object getDepartmentId() {
                            return departmentId;
                        }

                        public void setDepartmentId(Object departmentId) {
                            this.departmentId = departmentId;
                        }

                        public Object getDepartmentIds() {
                            return departmentIds;
                        }

                        public void setDepartmentIds(Object departmentIds) {
                            this.departmentIds = departmentIds;
                        }

                        public Object getDepartmentIdList() {
                            return departmentIdList;
                        }

                        public void setDepartmentIdList(Object departmentIdList) {
                            this.departmentIdList = departmentIdList;
                        }

                        public Object getDepartmentCodes() {
                            return departmentCodes;
                        }

                        public void setDepartmentCodes(Object departmentCodes) {
                            this.departmentCodes = departmentCodes;
                        }

                        public Object getDepartmentCodeList() {
                            return departmentCodeList;
                        }

                        public void setDepartmentCodeList(Object departmentCodeList) {
                            this.departmentCodeList = departmentCodeList;
                        }

                        public Object getDepartmentNames() {
                            return departmentNames;
                        }

                        public void setDepartmentNames(Object departmentNames) {
                            this.departmentNames = departmentNames;
                        }

                        public Object getDepartmentNameList() {
                            return departmentNameList;
                        }

                        public void setDepartmentNameList(Object departmentNameList) {
                            this.departmentNameList = departmentNameList;
                        }

                        public Object getDepartmentExtendInfo() {
                            return departmentExtendInfo;
                        }

                        public void setDepartmentExtendInfo(Object departmentExtendInfo) {
                            this.departmentExtendInfo = departmentExtendInfo;
                        }

                        public Object getProfileAttachmentId() {
                            return profileAttachmentId;
                        }

                        public void setProfileAttachmentId(Object profileAttachmentId) {
                            this.profileAttachmentId = profileAttachmentId;
                        }

                        public Object getProfileHttpUrl() {
                            return profileHttpUrl;
                        }

                        public void setProfileHttpUrl(Object profileHttpUrl) {
                            this.profileHttpUrl = profileHttpUrl;
                        }

                        public Object getParent() {
                            return parent;
                        }

                        public void setParent(Object parent) {
                            this.parent = parent;
                        }

                        public List<InstListBean> getInstList() {
                            return instList;
                        }

                        public void setInstList(List<InstListBean> instList) {
                            this.instList = instList;
                        }

                        public List<RoleListBean> getRoleList() {
                            return roleList;
                        }

                        public void setRoleList(List<RoleListBean> roleList) {
                            this.roleList = roleList;
                        }

                        public static class InstListBean {
                            /**
                             * id : 98092356963663982
                             * pId : null
                             * name : 鼎元小额贷款公司
                             * nodeType : null
                             * isParent : null
                             * checked : false
                             * open : null
                             * isSelected : null
                             * fullPath : null
                             * title : null
                             * code : null
                             * sortNo : null
                             * remark : null
                             * version : null
                             * children : null
                             * userList : null
                             * extendInfo : null
                             * parent : null
                             */

                            private String id;
                            private Object pId;
                            private String name;
                            private Object nodeType;
                            private Object isParent;
                            private boolean checked;
                            private Object open;
                            private Object isSelected;
                            private Object fullPath;
                            private Object title;
                            private Object code;
                            private Object sortNo;
                            private Object remark;
                            private Object version;
                            private Object children;
                            private Object userList;
                            private Object extendInfo;
                            private Object parent;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }

                            public Object getPId() {
                                return pId;
                            }

                            public void setPId(Object pId) {
                                this.pId = pId;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public Object getNodeType() {
                                return nodeType;
                            }

                            public void setNodeType(Object nodeType) {
                                this.nodeType = nodeType;
                            }

                            public Object getIsParent() {
                                return isParent;
                            }

                            public void setIsParent(Object isParent) {
                                this.isParent = isParent;
                            }

                            public boolean isChecked() {
                                return checked;
                            }

                            public void setChecked(boolean checked) {
                                this.checked = checked;
                            }

                            public Object getOpen() {
                                return open;
                            }

                            public void setOpen(Object open) {
                                this.open = open;
                            }

                            public Object getIsSelected() {
                                return isSelected;
                            }

                            public void setIsSelected(Object isSelected) {
                                this.isSelected = isSelected;
                            }

                            public Object getFullPath() {
                                return fullPath;
                            }

                            public void setFullPath(Object fullPath) {
                                this.fullPath = fullPath;
                            }

                            public Object getTitle() {
                                return title;
                            }

                            public void setTitle(Object title) {
                                this.title = title;
                            }

                            public Object getCode() {
                                return code;
                            }

                            public void setCode(Object code) {
                                this.code = code;
                            }

                            public Object getSortNo() {
                                return sortNo;
                            }

                            public void setSortNo(Object sortNo) {
                                this.sortNo = sortNo;
                            }

                            public Object getRemark() {
                                return remark;
                            }

                            public void setRemark(Object remark) {
                                this.remark = remark;
                            }

                            public Object getVersion() {
                                return version;
                            }

                            public void setVersion(Object version) {
                                this.version = version;
                            }

                            public Object getChildren() {
                                return children;
                            }

                            public void setChildren(Object children) {
                                this.children = children;
                            }

                            public Object getUserList() {
                                return userList;
                            }

                            public void setUserList(Object userList) {
                                this.userList = userList;
                            }

                            public Object getExtendInfo() {
                                return extendInfo;
                            }

                            public void setExtendInfo(Object extendInfo) {
                                this.extendInfo = extendInfo;
                            }

                            public Object getParent() {
                                return parent;
                            }

                            public void setParent(Object parent) {
                                this.parent = parent;
                            }
                        }

                        public static class RoleListBean {
                            /**
                             * id : 98092356963849233
                             * pId : null
                             * name : 小贷放款经理
                             * nodeType : null
                             * isParent : null
                             * checked : false
                             * open : null
                             * isSelected : null
                             * fullPath : null
                             * title : null
                             * code : null
                             * description : [13310789268]蒋莉
                             * category : null
                             * userList : null
                             * extendInfo : null
                             * parent : null
                             */

                            private String id;
                            private Object pId;
                            private String name;
                            private Object nodeType;
                            private Object isParent;
                            private boolean checked;
                            private Object open;
                            private Object isSelected;
                            private Object fullPath;
                            private Object title;
                            private Object code;
                            private String description;
                            private Object category;
                            private Object userList;
                            private Object extendInfo;
                            private Object parent;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }

                            public Object getPId() {
                                return pId;
                            }

                            public void setPId(Object pId) {
                                this.pId = pId;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public Object getNodeType() {
                                return nodeType;
                            }

                            public void setNodeType(Object nodeType) {
                                this.nodeType = nodeType;
                            }

                            public Object getIsParent() {
                                return isParent;
                            }

                            public void setIsParent(Object isParent) {
                                this.isParent = isParent;
                            }

                            public boolean isChecked() {
                                return checked;
                            }

                            public void setChecked(boolean checked) {
                                this.checked = checked;
                            }

                            public Object getOpen() {
                                return open;
                            }

                            public void setOpen(Object open) {
                                this.open = open;
                            }

                            public Object getIsSelected() {
                                return isSelected;
                            }

                            public void setIsSelected(Object isSelected) {
                                this.isSelected = isSelected;
                            }

                            public Object getFullPath() {
                                return fullPath;
                            }

                            public void setFullPath(Object fullPath) {
                                this.fullPath = fullPath;
                            }

                            public Object getTitle() {
                                return title;
                            }

                            public void setTitle(Object title) {
                                this.title = title;
                            }

                            public Object getCode() {
                                return code;
                            }

                            public void setCode(Object code) {
                                this.code = code;
                            }

                            public String getDescription() {
                                return description;
                            }

                            public void setDescription(String description) {
                                this.description = description;
                            }

                            public Object getCategory() {
                                return category;
                            }

                            public void setCategory(Object category) {
                                this.category = category;
                            }

                            public Object getUserList() {
                                return userList;
                            }

                            public void setUserList(Object userList) {
                                this.userList = userList;
                            }

                            public Object getExtendInfo() {
                                return extendInfo;
                            }

                            public void setExtendInfo(Object extendInfo) {
                                this.extendInfo = extendInfo;
                            }

                            public Object getParent() {
                                return parent;
                            }

                            public void setParent(Object parent) {
                                this.parent = parent;
                            }
                        }
                    }

                    public static class ApproveBean {
                        /**
                         * id : 98092356963664048
                         * pId : null
                         * name : null
                         * nodeType : null
                         * isParent : null
                         * checked : false
                         * open : null
                         * isSelected : null
                         * fullPath : null
                         * title : null
                         * username : 15519884477
                         * password : null
                         * fullname : 刘金盘
                         * mobile : null
                         * idNo : null
                         * roles : null
                         * department : null
                         * sex : null
                         * nativePlace : null
                         * telephone : null
                         * email : null
                         * politicalStatus : null
                         * job : null
                         * graduationDate : null
                         * entryDate : null
                         * demissionDate : null
                         * converseDate : null
                         * trasferDate : null
                         * socialSecurityDate : null
                         * servingAge : null
                         * onDutyAge : null
                         * workingAge : null
                         * birthday : null
                         * age : null
                         * education : null
                         * school : null
                         * professtionalTitle : null
                         * professional : null
                         * econtactorName : null
                         * econtactorRelation : null
                         * econtactorTel : null
                         * homeAddress : null
                         * censusRegister : null
                         * entryBatch : null
                         * fstContractBeginDate : null
                         * fstContractEndDate : null
                         * scdContractBeginDate : null
                         * scdContractEndDate : null
                         * thdContractBeginDate : null
                         * thdContractEndDate : null
                         * annualLeaveDays : null
                         * lieuLeaveDays : null
                         * surplusAnnualLeaveDays : null
                         * surplusLieuLeaveDays : null
                         * annualSalary : null
                         * socialSecurityBase : null
                         * telSubsidy : null
                         * otherSalary : null
                         * isOnJob : null
                         * isBlock : null
                         * blockReason : null
                         * blockDate : null
                         * isErasable : null
                         * failAttempts : null
                         * lastLoginDate : null
                         * resetPwdDate : null
                         * createdBy : null
                         * createdTime : null
                         * lastUpdBy : null
                         * lastUpdTime : null
                         * deletedBy : null
                         * deletedTime : null
                         * reserveddecimal1 : null
                         * reserveddecimal2 : null
                         * reserveddecimal3 : null
                         * reserveddecimal4 : null
                         * reserveddecimal5 : null
                         * extendInfo : null
                         * actAssigneeFlag : null
                         * actAssigneeId : null
                         * actProcessKeyList : null
                         * resume : null
                         * remark : null
                         * reservedstring1 : null
                         * reservedstring2 : null
                         * reservedstring3 : null
                         * reservedstring4 : null
                         * reservedstring5 : null
                         * accessibleDeptCodes : null
                         * accessibleRoleCodes : null
                         * accessibleDeptCodesStr : null
                         * accessibleRoleCodesStr : null
                         * instIdPathList : null
                         * instList : [{"id":"98092356963663994","pId":null,"name":"风险合规部","nodeType":null,"isParent":null,"checked":false,"open":null,"isSelected":null,"fullPath":null,"title":null,"code":null,"sortNo":null,"remark":null,"version":null,"children":null,"userList":null,"extendInfo":null,"parent":null}]
                         * roleList : [{"id":"98092356963665434","pId":null,"name":"风控部经理","nodeType":null,"isParent":null,"checked":false,"open":null,"isSelected":null,"fullPath":null,"title":null,"code":null,"description":"[15519884477]刘金盘","category":null,"userList":null,"extendInfo":null,"parent":null}]
                         * roleIds : null
                         * roleIdList : null
                         * roleCodes : null
                         * roleCodeList : null
                         * roleNames : null
                         * roleNameList : null
                         * description : [15519884477]刘金盘
                         * groupId : null
                         * groupCode : null
                         * groupName : null
                         * companyId : null
                         * companyCode : null
                         * companyName : null
                         * departmentName : null
                         * departmentCode : null
                         * departmentId : null
                         * departmentIds : null
                         * departmentIdList : null
                         * departmentCodes : null
                         * departmentCodeList : null
                         * departmentNames : null
                         * departmentNameList : null
                         * departmentExtendInfo : null
                         * profileAttachmentId : null
                         * profileHttpUrl : null
                         * parent : null
                         */

                        private String id;
                        private Object pId;
                        private Object name;
                        private Object nodeType;
                        private Object isParent;
                        private boolean checked;
                        private Object open;
                        private Object isSelected;
                        private Object fullPath;
                        private Object title;
                        private String username;
                        private Object password;
                        private String fullname;
                        private Object mobile;
                        private Object idNo;
                        private Object roles;
                        private Object department;
                        private Object sex;
                        private Object nativePlace;
                        private Object telephone;
                        private Object email;
                        private Object politicalStatus;
                        private Object job;
                        private Object graduationDate;
                        private Object entryDate;
                        private Object demissionDate;
                        private Object converseDate;
                        private Object trasferDate;
                        private Object socialSecurityDate;
                        private Object servingAge;
                        private Object onDutyAge;
                        private Object workingAge;
                        private Object birthday;
                        private Object age;
                        private Object education;
                        private Object school;
                        private Object professtionalTitle;
                        private Object professional;
                        private Object econtactorName;
                        private Object econtactorRelation;
                        private Object econtactorTel;
                        private Object homeAddress;
                        private Object censusRegister;
                        private Object entryBatch;
                        private Object fstContractBeginDate;
                        private Object fstContractEndDate;
                        private Object scdContractBeginDate;
                        private Object scdContractEndDate;
                        private Object thdContractBeginDate;
                        private Object thdContractEndDate;
                        private Object annualLeaveDays;
                        private Object lieuLeaveDays;
                        private Object surplusAnnualLeaveDays;
                        private Object surplusLieuLeaveDays;
                        private Object annualSalary;
                        private Object socialSecurityBase;
                        private Object telSubsidy;
                        private Object otherSalary;
                        private Object isOnJob;
                        private Object isBlock;
                        private Object blockReason;
                        private Object blockDate;
                        private Object isErasable;
                        private Object failAttempts;
                        private Object lastLoginDate;
                        private Object resetPwdDate;
                        private Object createdBy;
                        private Object createdTime;
                        private Object lastUpdBy;
                        private Object lastUpdTime;
                        private Object deletedBy;
                        private Object deletedTime;
                        private Object reserveddecimal1;
                        private Object reserveddecimal2;
                        private Object reserveddecimal3;
                        private Object reserveddecimal4;
                        private Object reserveddecimal5;
                        private Object extendInfo;
                        private Object actAssigneeFlag;
                        private Object actAssigneeId;
                        private Object actProcessKeyList;
                        private Object resume;
                        private Object remark;
                        private Object reservedstring1;
                        private Object reservedstring2;
                        private Object reservedstring3;
                        private Object reservedstring4;
                        private Object reservedstring5;
                        private Object accessibleDeptCodes;
                        private Object accessibleRoleCodes;
                        private Object accessibleDeptCodesStr;
                        private Object accessibleRoleCodesStr;
                        private Object instIdPathList;
                        private Object roleIds;
                        private Object roleIdList;
                        private Object roleCodes;
                        private Object roleCodeList;
                        private Object roleNames;
                        private Object roleNameList;
                        private String description;
                        private Object groupId;
                        private Object groupCode;
                        private Object groupName;
                        private Object companyId;
                        private Object companyCode;
                        private Object companyName;
                        private Object departmentName;
                        private Object departmentCode;
                        private Object departmentId;
                        private Object departmentIds;
                        private Object departmentIdList;
                        private Object departmentCodes;
                        private Object departmentCodeList;
                        private Object departmentNames;
                        private Object departmentNameList;
                        private Object departmentExtendInfo;
                        private Object profileAttachmentId;
                        private Object profileHttpUrl;
                        private Object parent;
                        private List<InstListBeanX> instList;
                        private List<RoleListBeanX> roleList;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public Object getPId() {
                            return pId;
                        }

                        public void setPId(Object pId) {
                            this.pId = pId;
                        }

                        public Object getName() {
                            return name;
                        }

                        public void setName(Object name) {
                            this.name = name;
                        }

                        public Object getNodeType() {
                            return nodeType;
                        }

                        public void setNodeType(Object nodeType) {
                            this.nodeType = nodeType;
                        }

                        public Object getIsParent() {
                            return isParent;
                        }

                        public void setIsParent(Object isParent) {
                            this.isParent = isParent;
                        }

                        public boolean isChecked() {
                            return checked;
                        }

                        public void setChecked(boolean checked) {
                            this.checked = checked;
                        }

                        public Object getOpen() {
                            return open;
                        }

                        public void setOpen(Object open) {
                            this.open = open;
                        }

                        public Object getIsSelected() {
                            return isSelected;
                        }

                        public void setIsSelected(Object isSelected) {
                            this.isSelected = isSelected;
                        }

                        public Object getFullPath() {
                            return fullPath;
                        }

                        public void setFullPath(Object fullPath) {
                            this.fullPath = fullPath;
                        }

                        public Object getTitle() {
                            return title;
                        }

                        public void setTitle(Object title) {
                            this.title = title;
                        }

                        public String getUsername() {
                            return username;
                        }

                        public void setUsername(String username) {
                            this.username = username;
                        }

                        public Object getPassword() {
                            return password;
                        }

                        public void setPassword(Object password) {
                            this.password = password;
                        }

                        public String getFullname() {
                            return fullname;
                        }

                        public void setFullname(String fullname) {
                            this.fullname = fullname;
                        }

                        public Object getMobile() {
                            return mobile;
                        }

                        public void setMobile(Object mobile) {
                            this.mobile = mobile;
                        }

                        public Object getIdNo() {
                            return idNo;
                        }

                        public void setIdNo(Object idNo) {
                            this.idNo = idNo;
                        }

                        public Object getRoles() {
                            return roles;
                        }

                        public void setRoles(Object roles) {
                            this.roles = roles;
                        }

                        public Object getDepartment() {
                            return department;
                        }

                        public void setDepartment(Object department) {
                            this.department = department;
                        }

                        public Object getSex() {
                            return sex;
                        }

                        public void setSex(Object sex) {
                            this.sex = sex;
                        }

                        public Object getNativePlace() {
                            return nativePlace;
                        }

                        public void setNativePlace(Object nativePlace) {
                            this.nativePlace = nativePlace;
                        }

                        public Object getTelephone() {
                            return telephone;
                        }

                        public void setTelephone(Object telephone) {
                            this.telephone = telephone;
                        }

                        public Object getEmail() {
                            return email;
                        }

                        public void setEmail(Object email) {
                            this.email = email;
                        }

                        public Object getPoliticalStatus() {
                            return politicalStatus;
                        }

                        public void setPoliticalStatus(Object politicalStatus) {
                            this.politicalStatus = politicalStatus;
                        }

                        public Object getJob() {
                            return job;
                        }

                        public void setJob(Object job) {
                            this.job = job;
                        }

                        public Object getGraduationDate() {
                            return graduationDate;
                        }

                        public void setGraduationDate(Object graduationDate) {
                            this.graduationDate = graduationDate;
                        }

                        public Object getEntryDate() {
                            return entryDate;
                        }

                        public void setEntryDate(Object entryDate) {
                            this.entryDate = entryDate;
                        }

                        public Object getDemissionDate() {
                            return demissionDate;
                        }

                        public void setDemissionDate(Object demissionDate) {
                            this.demissionDate = demissionDate;
                        }

                        public Object getConverseDate() {
                            return converseDate;
                        }

                        public void setConverseDate(Object converseDate) {
                            this.converseDate = converseDate;
                        }

                        public Object getTrasferDate() {
                            return trasferDate;
                        }

                        public void setTrasferDate(Object trasferDate) {
                            this.trasferDate = trasferDate;
                        }

                        public Object getSocialSecurityDate() {
                            return socialSecurityDate;
                        }

                        public void setSocialSecurityDate(Object socialSecurityDate) {
                            this.socialSecurityDate = socialSecurityDate;
                        }

                        public Object getServingAge() {
                            return servingAge;
                        }

                        public void setServingAge(Object servingAge) {
                            this.servingAge = servingAge;
                        }

                        public Object getOnDutyAge() {
                            return onDutyAge;
                        }

                        public void setOnDutyAge(Object onDutyAge) {
                            this.onDutyAge = onDutyAge;
                        }

                        public Object getWorkingAge() {
                            return workingAge;
                        }

                        public void setWorkingAge(Object workingAge) {
                            this.workingAge = workingAge;
                        }

                        public Object getBirthday() {
                            return birthday;
                        }

                        public void setBirthday(Object birthday) {
                            this.birthday = birthday;
                        }

                        public Object getAge() {
                            return age;
                        }

                        public void setAge(Object age) {
                            this.age = age;
                        }

                        public Object getEducation() {
                            return education;
                        }

                        public void setEducation(Object education) {
                            this.education = education;
                        }

                        public Object getSchool() {
                            return school;
                        }

                        public void setSchool(Object school) {
                            this.school = school;
                        }

                        public Object getProfesstionalTitle() {
                            return professtionalTitle;
                        }

                        public void setProfesstionalTitle(Object professtionalTitle) {
                            this.professtionalTitle = professtionalTitle;
                        }

                        public Object getProfessional() {
                            return professional;
                        }

                        public void setProfessional(Object professional) {
                            this.professional = professional;
                        }

                        public Object getEcontactorName() {
                            return econtactorName;
                        }

                        public void setEcontactorName(Object econtactorName) {
                            this.econtactorName = econtactorName;
                        }

                        public Object getEcontactorRelation() {
                            return econtactorRelation;
                        }

                        public void setEcontactorRelation(Object econtactorRelation) {
                            this.econtactorRelation = econtactorRelation;
                        }

                        public Object getEcontactorTel() {
                            return econtactorTel;
                        }

                        public void setEcontactorTel(Object econtactorTel) {
                            this.econtactorTel = econtactorTel;
                        }

                        public Object getHomeAddress() {
                            return homeAddress;
                        }

                        public void setHomeAddress(Object homeAddress) {
                            this.homeAddress = homeAddress;
                        }

                        public Object getCensusRegister() {
                            return censusRegister;
                        }

                        public void setCensusRegister(Object censusRegister) {
                            this.censusRegister = censusRegister;
                        }

                        public Object getEntryBatch() {
                            return entryBatch;
                        }

                        public void setEntryBatch(Object entryBatch) {
                            this.entryBatch = entryBatch;
                        }

                        public Object getFstContractBeginDate() {
                            return fstContractBeginDate;
                        }

                        public void setFstContractBeginDate(Object fstContractBeginDate) {
                            this.fstContractBeginDate = fstContractBeginDate;
                        }

                        public Object getFstContractEndDate() {
                            return fstContractEndDate;
                        }

                        public void setFstContractEndDate(Object fstContractEndDate) {
                            this.fstContractEndDate = fstContractEndDate;
                        }

                        public Object getScdContractBeginDate() {
                            return scdContractBeginDate;
                        }

                        public void setScdContractBeginDate(Object scdContractBeginDate) {
                            this.scdContractBeginDate = scdContractBeginDate;
                        }

                        public Object getScdContractEndDate() {
                            return scdContractEndDate;
                        }

                        public void setScdContractEndDate(Object scdContractEndDate) {
                            this.scdContractEndDate = scdContractEndDate;
                        }

                        public Object getThdContractBeginDate() {
                            return thdContractBeginDate;
                        }

                        public void setThdContractBeginDate(Object thdContractBeginDate) {
                            this.thdContractBeginDate = thdContractBeginDate;
                        }

                        public Object getThdContractEndDate() {
                            return thdContractEndDate;
                        }

                        public void setThdContractEndDate(Object thdContractEndDate) {
                            this.thdContractEndDate = thdContractEndDate;
                        }

                        public Object getAnnualLeaveDays() {
                            return annualLeaveDays;
                        }

                        public void setAnnualLeaveDays(Object annualLeaveDays) {
                            this.annualLeaveDays = annualLeaveDays;
                        }

                        public Object getLieuLeaveDays() {
                            return lieuLeaveDays;
                        }

                        public void setLieuLeaveDays(Object lieuLeaveDays) {
                            this.lieuLeaveDays = lieuLeaveDays;
                        }

                        public Object getSurplusAnnualLeaveDays() {
                            return surplusAnnualLeaveDays;
                        }

                        public void setSurplusAnnualLeaveDays(Object surplusAnnualLeaveDays) {
                            this.surplusAnnualLeaveDays = surplusAnnualLeaveDays;
                        }

                        public Object getSurplusLieuLeaveDays() {
                            return surplusLieuLeaveDays;
                        }

                        public void setSurplusLieuLeaveDays(Object surplusLieuLeaveDays) {
                            this.surplusLieuLeaveDays = surplusLieuLeaveDays;
                        }

                        public Object getAnnualSalary() {
                            return annualSalary;
                        }

                        public void setAnnualSalary(Object annualSalary) {
                            this.annualSalary = annualSalary;
                        }

                        public Object getSocialSecurityBase() {
                            return socialSecurityBase;
                        }

                        public void setSocialSecurityBase(Object socialSecurityBase) {
                            this.socialSecurityBase = socialSecurityBase;
                        }

                        public Object getTelSubsidy() {
                            return telSubsidy;
                        }

                        public void setTelSubsidy(Object telSubsidy) {
                            this.telSubsidy = telSubsidy;
                        }

                        public Object getOtherSalary() {
                            return otherSalary;
                        }

                        public void setOtherSalary(Object otherSalary) {
                            this.otherSalary = otherSalary;
                        }

                        public Object getIsOnJob() {
                            return isOnJob;
                        }

                        public void setIsOnJob(Object isOnJob) {
                            this.isOnJob = isOnJob;
                        }

                        public Object getIsBlock() {
                            return isBlock;
                        }

                        public void setIsBlock(Object isBlock) {
                            this.isBlock = isBlock;
                        }

                        public Object getBlockReason() {
                            return blockReason;
                        }

                        public void setBlockReason(Object blockReason) {
                            this.blockReason = blockReason;
                        }

                        public Object getBlockDate() {
                            return blockDate;
                        }

                        public void setBlockDate(Object blockDate) {
                            this.blockDate = blockDate;
                        }

                        public Object getIsErasable() {
                            return isErasable;
                        }

                        public void setIsErasable(Object isErasable) {
                            this.isErasable = isErasable;
                        }

                        public Object getFailAttempts() {
                            return failAttempts;
                        }

                        public void setFailAttempts(Object failAttempts) {
                            this.failAttempts = failAttempts;
                        }

                        public Object getLastLoginDate() {
                            return lastLoginDate;
                        }

                        public void setLastLoginDate(Object lastLoginDate) {
                            this.lastLoginDate = lastLoginDate;
                        }

                        public Object getResetPwdDate() {
                            return resetPwdDate;
                        }

                        public void setResetPwdDate(Object resetPwdDate) {
                            this.resetPwdDate = resetPwdDate;
                        }

                        public Object getCreatedBy() {
                            return createdBy;
                        }

                        public void setCreatedBy(Object createdBy) {
                            this.createdBy = createdBy;
                        }

                        public Object getCreatedTime() {
                            return createdTime;
                        }

                        public void setCreatedTime(Object createdTime) {
                            this.createdTime = createdTime;
                        }

                        public Object getLastUpdBy() {
                            return lastUpdBy;
                        }

                        public void setLastUpdBy(Object lastUpdBy) {
                            this.lastUpdBy = lastUpdBy;
                        }

                        public Object getLastUpdTime() {
                            return lastUpdTime;
                        }

                        public void setLastUpdTime(Object lastUpdTime) {
                            this.lastUpdTime = lastUpdTime;
                        }

                        public Object getDeletedBy() {
                            return deletedBy;
                        }

                        public void setDeletedBy(Object deletedBy) {
                            this.deletedBy = deletedBy;
                        }

                        public Object getDeletedTime() {
                            return deletedTime;
                        }

                        public void setDeletedTime(Object deletedTime) {
                            this.deletedTime = deletedTime;
                        }

                        public Object getReserveddecimal1() {
                            return reserveddecimal1;
                        }

                        public void setReserveddecimal1(Object reserveddecimal1) {
                            this.reserveddecimal1 = reserveddecimal1;
                        }

                        public Object getReserveddecimal2() {
                            return reserveddecimal2;
                        }

                        public void setReserveddecimal2(Object reserveddecimal2) {
                            this.reserveddecimal2 = reserveddecimal2;
                        }

                        public Object getReserveddecimal3() {
                            return reserveddecimal3;
                        }

                        public void setReserveddecimal3(Object reserveddecimal3) {
                            this.reserveddecimal3 = reserveddecimal3;
                        }

                        public Object getReserveddecimal4() {
                            return reserveddecimal4;
                        }

                        public void setReserveddecimal4(Object reserveddecimal4) {
                            this.reserveddecimal4 = reserveddecimal4;
                        }

                        public Object getReserveddecimal5() {
                            return reserveddecimal5;
                        }

                        public void setReserveddecimal5(Object reserveddecimal5) {
                            this.reserveddecimal5 = reserveddecimal5;
                        }

                        public Object getExtendInfo() {
                            return extendInfo;
                        }

                        public void setExtendInfo(Object extendInfo) {
                            this.extendInfo = extendInfo;
                        }

                        public Object getActAssigneeFlag() {
                            return actAssigneeFlag;
                        }

                        public void setActAssigneeFlag(Object actAssigneeFlag) {
                            this.actAssigneeFlag = actAssigneeFlag;
                        }

                        public Object getActAssigneeId() {
                            return actAssigneeId;
                        }

                        public void setActAssigneeId(Object actAssigneeId) {
                            this.actAssigneeId = actAssigneeId;
                        }

                        public Object getActProcessKeyList() {
                            return actProcessKeyList;
                        }

                        public void setActProcessKeyList(Object actProcessKeyList) {
                            this.actProcessKeyList = actProcessKeyList;
                        }

                        public Object getResume() {
                            return resume;
                        }

                        public void setResume(Object resume) {
                            this.resume = resume;
                        }

                        public Object getRemark() {
                            return remark;
                        }

                        public void setRemark(Object remark) {
                            this.remark = remark;
                        }

                        public Object getReservedstring1() {
                            return reservedstring1;
                        }

                        public void setReservedstring1(Object reservedstring1) {
                            this.reservedstring1 = reservedstring1;
                        }

                        public Object getReservedstring2() {
                            return reservedstring2;
                        }

                        public void setReservedstring2(Object reservedstring2) {
                            this.reservedstring2 = reservedstring2;
                        }

                        public Object getReservedstring3() {
                            return reservedstring3;
                        }

                        public void setReservedstring3(Object reservedstring3) {
                            this.reservedstring3 = reservedstring3;
                        }

                        public Object getReservedstring4() {
                            return reservedstring4;
                        }

                        public void setReservedstring4(Object reservedstring4) {
                            this.reservedstring4 = reservedstring4;
                        }

                        public Object getReservedstring5() {
                            return reservedstring5;
                        }

                        public void setReservedstring5(Object reservedstring5) {
                            this.reservedstring5 = reservedstring5;
                        }

                        public Object getAccessibleDeptCodes() {
                            return accessibleDeptCodes;
                        }

                        public void setAccessibleDeptCodes(Object accessibleDeptCodes) {
                            this.accessibleDeptCodes = accessibleDeptCodes;
                        }

                        public Object getAccessibleRoleCodes() {
                            return accessibleRoleCodes;
                        }

                        public void setAccessibleRoleCodes(Object accessibleRoleCodes) {
                            this.accessibleRoleCodes = accessibleRoleCodes;
                        }

                        public Object getAccessibleDeptCodesStr() {
                            return accessibleDeptCodesStr;
                        }

                        public void setAccessibleDeptCodesStr(Object accessibleDeptCodesStr) {
                            this.accessibleDeptCodesStr = accessibleDeptCodesStr;
                        }

                        public Object getAccessibleRoleCodesStr() {
                            return accessibleRoleCodesStr;
                        }

                        public void setAccessibleRoleCodesStr(Object accessibleRoleCodesStr) {
                            this.accessibleRoleCodesStr = accessibleRoleCodesStr;
                        }

                        public Object getInstIdPathList() {
                            return instIdPathList;
                        }

                        public void setInstIdPathList(Object instIdPathList) {
                            this.instIdPathList = instIdPathList;
                        }

                        public Object getRoleIds() {
                            return roleIds;
                        }

                        public void setRoleIds(Object roleIds) {
                            this.roleIds = roleIds;
                        }

                        public Object getRoleIdList() {
                            return roleIdList;
                        }

                        public void setRoleIdList(Object roleIdList) {
                            this.roleIdList = roleIdList;
                        }

                        public Object getRoleCodes() {
                            return roleCodes;
                        }

                        public void setRoleCodes(Object roleCodes) {
                            this.roleCodes = roleCodes;
                        }

                        public Object getRoleCodeList() {
                            return roleCodeList;
                        }

                        public void setRoleCodeList(Object roleCodeList) {
                            this.roleCodeList = roleCodeList;
                        }

                        public Object getRoleNames() {
                            return roleNames;
                        }

                        public void setRoleNames(Object roleNames) {
                            this.roleNames = roleNames;
                        }

                        public Object getRoleNameList() {
                            return roleNameList;
                        }

                        public void setRoleNameList(Object roleNameList) {
                            this.roleNameList = roleNameList;
                        }

                        public String getDescription() {
                            return description;
                        }

                        public void setDescription(String description) {
                            this.description = description;
                        }

                        public Object getGroupId() {
                            return groupId;
                        }

                        public void setGroupId(Object groupId) {
                            this.groupId = groupId;
                        }

                        public Object getGroupCode() {
                            return groupCode;
                        }

                        public void setGroupCode(Object groupCode) {
                            this.groupCode = groupCode;
                        }

                        public Object getGroupName() {
                            return groupName;
                        }

                        public void setGroupName(Object groupName) {
                            this.groupName = groupName;
                        }

                        public Object getCompanyId() {
                            return companyId;
                        }

                        public void setCompanyId(Object companyId) {
                            this.companyId = companyId;
                        }

                        public Object getCompanyCode() {
                            return companyCode;
                        }

                        public void setCompanyCode(Object companyCode) {
                            this.companyCode = companyCode;
                        }

                        public Object getCompanyName() {
                            return companyName;
                        }

                        public void setCompanyName(Object companyName) {
                            this.companyName = companyName;
                        }

                        public Object getDepartmentName() {
                            return departmentName;
                        }

                        public void setDepartmentName(Object departmentName) {
                            this.departmentName = departmentName;
                        }

                        public Object getDepartmentCode() {
                            return departmentCode;
                        }

                        public void setDepartmentCode(Object departmentCode) {
                            this.departmentCode = departmentCode;
                        }

                        public Object getDepartmentId() {
                            return departmentId;
                        }

                        public void setDepartmentId(Object departmentId) {
                            this.departmentId = departmentId;
                        }

                        public Object getDepartmentIds() {
                            return departmentIds;
                        }

                        public void setDepartmentIds(Object departmentIds) {
                            this.departmentIds = departmentIds;
                        }

                        public Object getDepartmentIdList() {
                            return departmentIdList;
                        }

                        public void setDepartmentIdList(Object departmentIdList) {
                            this.departmentIdList = departmentIdList;
                        }

                        public Object getDepartmentCodes() {
                            return departmentCodes;
                        }

                        public void setDepartmentCodes(Object departmentCodes) {
                            this.departmentCodes = departmentCodes;
                        }

                        public Object getDepartmentCodeList() {
                            return departmentCodeList;
                        }

                        public void setDepartmentCodeList(Object departmentCodeList) {
                            this.departmentCodeList = departmentCodeList;
                        }

                        public Object getDepartmentNames() {
                            return departmentNames;
                        }

                        public void setDepartmentNames(Object departmentNames) {
                            this.departmentNames = departmentNames;
                        }

                        public Object getDepartmentNameList() {
                            return departmentNameList;
                        }

                        public void setDepartmentNameList(Object departmentNameList) {
                            this.departmentNameList = departmentNameList;
                        }

                        public Object getDepartmentExtendInfo() {
                            return departmentExtendInfo;
                        }

                        public void setDepartmentExtendInfo(Object departmentExtendInfo) {
                            this.departmentExtendInfo = departmentExtendInfo;
                        }

                        public Object getProfileAttachmentId() {
                            return profileAttachmentId;
                        }

                        public void setProfileAttachmentId(Object profileAttachmentId) {
                            this.profileAttachmentId = profileAttachmentId;
                        }

                        public Object getProfileHttpUrl() {
                            return profileHttpUrl;
                        }

                        public void setProfileHttpUrl(Object profileHttpUrl) {
                            this.profileHttpUrl = profileHttpUrl;
                        }

                        public Object getParent() {
                            return parent;
                        }

                        public void setParent(Object parent) {
                            this.parent = parent;
                        }

                        public List<InstListBeanX> getInstList() {
                            return instList;
                        }

                        public void setInstList(List<InstListBeanX> instList) {
                            this.instList = instList;
                        }

                        public List<RoleListBeanX> getRoleList() {
                            return roleList;
                        }

                        public void setRoleList(List<RoleListBeanX> roleList) {
                            this.roleList = roleList;
                        }

                        public static class InstListBeanX {
                            /**
                             * id : 98092356963663994
                             * pId : null
                             * name : 风险合规部
                             * nodeType : null
                             * isParent : null
                             * checked : false
                             * open : null
                             * isSelected : null
                             * fullPath : null
                             * title : null
                             * code : null
                             * sortNo : null
                             * remark : null
                             * version : null
                             * children : null
                             * userList : null
                             * extendInfo : null
                             * parent : null
                             */

                            private String id;
                            private Object pId;
                            private String name;
                            private Object nodeType;
                            private Object isParent;
                            private boolean checked;
                            private Object open;
                            private Object isSelected;
                            private Object fullPath;
                            private Object title;
                            private Object code;
                            private Object sortNo;
                            private Object remark;
                            private Object version;
                            private Object children;
                            private Object userList;
                            private Object extendInfo;
                            private Object parent;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }

                            public Object getPId() {
                                return pId;
                            }

                            public void setPId(Object pId) {
                                this.pId = pId;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public Object getNodeType() {
                                return nodeType;
                            }

                            public void setNodeType(Object nodeType) {
                                this.nodeType = nodeType;
                            }

                            public Object getIsParent() {
                                return isParent;
                            }

                            public void setIsParent(Object isParent) {
                                this.isParent = isParent;
                            }

                            public boolean isChecked() {
                                return checked;
                            }

                            public void setChecked(boolean checked) {
                                this.checked = checked;
                            }

                            public Object getOpen() {
                                return open;
                            }

                            public void setOpen(Object open) {
                                this.open = open;
                            }

                            public Object getIsSelected() {
                                return isSelected;
                            }

                            public void setIsSelected(Object isSelected) {
                                this.isSelected = isSelected;
                            }

                            public Object getFullPath() {
                                return fullPath;
                            }

                            public void setFullPath(Object fullPath) {
                                this.fullPath = fullPath;
                            }

                            public Object getTitle() {
                                return title;
                            }

                            public void setTitle(Object title) {
                                this.title = title;
                            }

                            public Object getCode() {
                                return code;
                            }

                            public void setCode(Object code) {
                                this.code = code;
                            }

                            public Object getSortNo() {
                                return sortNo;
                            }

                            public void setSortNo(Object sortNo) {
                                this.sortNo = sortNo;
                            }

                            public Object getRemark() {
                                return remark;
                            }

                            public void setRemark(Object remark) {
                                this.remark = remark;
                            }

                            public Object getVersion() {
                                return version;
                            }

                            public void setVersion(Object version) {
                                this.version = version;
                            }

                            public Object getChildren() {
                                return children;
                            }

                            public void setChildren(Object children) {
                                this.children = children;
                            }

                            public Object getUserList() {
                                return userList;
                            }

                            public void setUserList(Object userList) {
                                this.userList = userList;
                            }

                            public Object getExtendInfo() {
                                return extendInfo;
                            }

                            public void setExtendInfo(Object extendInfo) {
                                this.extendInfo = extendInfo;
                            }

                            public Object getParent() {
                                return parent;
                            }

                            public void setParent(Object parent) {
                                this.parent = parent;
                            }
                        }

                        public static class RoleListBeanX {
                            /**
                             * id : 98092356963665434
                             * pId : null
                             * name : 风控部经理
                             * nodeType : null
                             * isParent : null
                             * checked : false
                             * open : null
                             * isSelected : null
                             * fullPath : null
                             * title : null
                             * code : null
                             * description : [15519884477]刘金盘
                             * category : null
                             * userList : null
                             * extendInfo : null
                             * parent : null
                             */

                            private String id;
                            private Object pId;
                            private String name;
                            private Object nodeType;
                            private Object isParent;
                            private boolean checked;
                            private Object open;
                            private Object isSelected;
                            private Object fullPath;
                            private Object title;
                            private Object code;
                            private String description;
                            private Object category;
                            private Object userList;
                            private Object extendInfo;
                            private Object parent;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }

                            public Object getPId() {
                                return pId;
                            }

                            public void setPId(Object pId) {
                                this.pId = pId;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public Object getNodeType() {
                                return nodeType;
                            }

                            public void setNodeType(Object nodeType) {
                                this.nodeType = nodeType;
                            }

                            public Object getIsParent() {
                                return isParent;
                            }

                            public void setIsParent(Object isParent) {
                                this.isParent = isParent;
                            }

                            public boolean isChecked() {
                                return checked;
                            }

                            public void setChecked(boolean checked) {
                                this.checked = checked;
                            }

                            public Object getOpen() {
                                return open;
                            }

                            public void setOpen(Object open) {
                                this.open = open;
                            }

                            public Object getIsSelected() {
                                return isSelected;
                            }

                            public void setIsSelected(Object isSelected) {
                                this.isSelected = isSelected;
                            }

                            public Object getFullPath() {
                                return fullPath;
                            }

                            public void setFullPath(Object fullPath) {
                                this.fullPath = fullPath;
                            }

                            public Object getTitle() {
                                return title;
                            }

                            public void setTitle(Object title) {
                                this.title = title;
                            }

                            public Object getCode() {
                                return code;
                            }

                            public void setCode(Object code) {
                                this.code = code;
                            }

                            public String getDescription() {
                                return description;
                            }

                            public void setDescription(String description) {
                                this.description = description;
                            }

                            public Object getCategory() {
                                return category;
                            }

                            public void setCategory(Object category) {
                                this.category = category;
                            }

                            public Object getUserList() {
                                return userList;
                            }

                            public void setUserList(Object userList) {
                                this.userList = userList;
                            }

                            public Object getExtendInfo() {
                                return extendInfo;
                            }

                            public void setExtendInfo(Object extendInfo) {
                                this.extendInfo = extendInfo;
                            }

                            public Object getParent() {
                                return parent;
                            }

                            public void setParent(Object parent) {
                                this.parent = parent;
                            }
                        }
                    }

                    public static class SettleBean {
                        /**
                         * id : 98092356963664015
                         * pId : null
                         * name : null
                         * nodeType : null
                         * isParent : null
                         * checked : false
                         * open : null
                         * isSelected : null
                         * fullPath : null
                         * title : null
                         * username : 18216592503
                         * password : null
                         * fullname : 方彦国
                         * mobile : null
                         * idNo : null
                         * roles : null
                         * department : null
                         * sex : null
                         * nativePlace : null
                         * telephone : null
                         * email : null
                         * politicalStatus : null
                         * job : null
                         * graduationDate : null
                         * entryDate : null
                         * demissionDate : null
                         * converseDate : null
                         * trasferDate : null
                         * socialSecurityDate : null
                         * servingAge : null
                         * onDutyAge : null
                         * workingAge : null
                         * birthday : null
                         * age : null
                         * education : null
                         * school : null
                         * professtionalTitle : null
                         * professional : null
                         * econtactorName : null
                         * econtactorRelation : null
                         * econtactorTel : null
                         * homeAddress : null
                         * censusRegister : null
                         * entryBatch : null
                         * fstContractBeginDate : null
                         * fstContractEndDate : null
                         * scdContractBeginDate : null
                         * scdContractEndDate : null
                         * thdContractBeginDate : null
                         * thdContractEndDate : null
                         * annualLeaveDays : null
                         * lieuLeaveDays : null
                         * surplusAnnualLeaveDays : null
                         * surplusLieuLeaveDays : null
                         * annualSalary : null
                         * socialSecurityBase : null
                         * telSubsidy : null
                         * otherSalary : null
                         * isOnJob : null
                         * isBlock : null
                         * blockReason : null
                         * blockDate : null
                         * isErasable : null
                         * failAttempts : null
                         * lastLoginDate : null
                         * resetPwdDate : null
                         * createdBy : null
                         * createdTime : null
                         * lastUpdBy : null
                         * lastUpdTime : null
                         * deletedBy : null
                         * deletedTime : null
                         * reserveddecimal1 : null
                         * reserveddecimal2 : null
                         * reserveddecimal3 : null
                         * reserveddecimal4 : null
                         * reserveddecimal5 : null
                         * extendInfo : null
                         * actAssigneeFlag : null
                         * actAssigneeId : null
                         * actProcessKeyList : null
                         * resume : null
                         * remark : null
                         * reservedstring1 : null
                         * reservedstring2 : null
                         * reservedstring3 : null
                         * reservedstring4 : null
                         * reservedstring5 : null
                         * accessibleDeptCodes : null
                         * accessibleRoleCodes : null
                         * accessibleDeptCodesStr : null
                         * accessibleRoleCodesStr : null
                         * instIdPathList : null
                         * instList : [{"id":"98092356963663988","pId":null,"name":"财务管理部","nodeType":null,"isParent":null,"checked":false,"open":null,"isSelected":null,"fullPath":null,"title":null,"code":null,"sortNo":null,"remark":null,"version":null,"children":null,"userList":null,"extendInfo":null,"parent":null}]
                         * roleList : [{"id":"98092356963665439","pId":null,"name":"财务部经理","nodeType":null,"isParent":null,"checked":false,"open":null,"isSelected":null,"fullPath":null,"title":null,"code":null,"description":"[18216592503]方彦国","category":null,"userList":null,"extendInfo":null,"parent":null}]
                         * roleIds : null
                         * roleIdList : null
                         * roleCodes : null
                         * roleCodeList : null
                         * roleNames : null
                         * roleNameList : null
                         * description : [18216592503]方彦国
                         * groupId : null
                         * groupCode : null
                         * groupName : null
                         * companyId : null
                         * companyCode : null
                         * companyName : null
                         * departmentName : null
                         * departmentCode : null
                         * departmentId : null
                         * departmentIds : null
                         * departmentIdList : null
                         * departmentCodes : null
                         * departmentCodeList : null
                         * departmentNames : null
                         * departmentNameList : null
                         * departmentExtendInfo : null
                         * profileAttachmentId : null
                         * profileHttpUrl : null
                         * parent : null
                         */

                        private String id;
                        private Object pId;
                        private Object name;
                        private Object nodeType;
                        private Object isParent;
                        private boolean checked;
                        private Object open;
                        private Object isSelected;
                        private Object fullPath;
                        private Object title;
                        private String username;
                        private Object password;
                        private String fullname;
                        private Object mobile;
                        private Object idNo;
                        private Object roles;
                        private Object department;
                        private Object sex;
                        private Object nativePlace;
                        private Object telephone;
                        private Object email;
                        private Object politicalStatus;
                        private Object job;
                        private Object graduationDate;
                        private Object entryDate;
                        private Object demissionDate;
                        private Object converseDate;
                        private Object trasferDate;
                        private Object socialSecurityDate;
                        private Object servingAge;
                        private Object onDutyAge;
                        private Object workingAge;
                        private Object birthday;
                        private Object age;
                        private Object education;
                        private Object school;
                        private Object professtionalTitle;
                        private Object professional;
                        private Object econtactorName;
                        private Object econtactorRelation;
                        private Object econtactorTel;
                        private Object homeAddress;
                        private Object censusRegister;
                        private Object entryBatch;
                        private Object fstContractBeginDate;
                        private Object fstContractEndDate;
                        private Object scdContractBeginDate;
                        private Object scdContractEndDate;
                        private Object thdContractBeginDate;
                        private Object thdContractEndDate;
                        private Object annualLeaveDays;
                        private Object lieuLeaveDays;
                        private Object surplusAnnualLeaveDays;
                        private Object surplusLieuLeaveDays;
                        private Object annualSalary;
                        private Object socialSecurityBase;
                        private Object telSubsidy;
                        private Object otherSalary;
                        private Object isOnJob;
                        private Object isBlock;
                        private Object blockReason;
                        private Object blockDate;
                        private Object isErasable;
                        private Object failAttempts;
                        private Object lastLoginDate;
                        private Object resetPwdDate;
                        private Object createdBy;
                        private Object createdTime;
                        private Object lastUpdBy;
                        private Object lastUpdTime;
                        private Object deletedBy;
                        private Object deletedTime;
                        private Object reserveddecimal1;
                        private Object reserveddecimal2;
                        private Object reserveddecimal3;
                        private Object reserveddecimal4;
                        private Object reserveddecimal5;
                        private Object extendInfo;
                        private Object actAssigneeFlag;
                        private Object actAssigneeId;
                        private Object actProcessKeyList;
                        private Object resume;
                        private Object remark;
                        private Object reservedstring1;
                        private Object reservedstring2;
                        private Object reservedstring3;
                        private Object reservedstring4;
                        private Object reservedstring5;
                        private Object accessibleDeptCodes;
                        private Object accessibleRoleCodes;
                        private Object accessibleDeptCodesStr;
                        private Object accessibleRoleCodesStr;
                        private Object instIdPathList;
                        private Object roleIds;
                        private Object roleIdList;
                        private Object roleCodes;
                        private Object roleCodeList;
                        private Object roleNames;
                        private Object roleNameList;
                        private String description;
                        private Object groupId;
                        private Object groupCode;
                        private Object groupName;
                        private Object companyId;
                        private Object companyCode;
                        private Object companyName;
                        private Object departmentName;
                        private Object departmentCode;
                        private Object departmentId;
                        private Object departmentIds;
                        private Object departmentIdList;
                        private Object departmentCodes;
                        private Object departmentCodeList;
                        private Object departmentNames;
                        private Object departmentNameList;
                        private Object departmentExtendInfo;
                        private Object profileAttachmentId;
                        private Object profileHttpUrl;
                        private Object parent;
                        private List<InstListBeanXX> instList;
                        private List<RoleListBeanXX> roleList;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public Object getPId() {
                            return pId;
                        }

                        public void setPId(Object pId) {
                            this.pId = pId;
                        }

                        public Object getName() {
                            return name;
                        }

                        public void setName(Object name) {
                            this.name = name;
                        }

                        public Object getNodeType() {
                            return nodeType;
                        }

                        public void setNodeType(Object nodeType) {
                            this.nodeType = nodeType;
                        }

                        public Object getIsParent() {
                            return isParent;
                        }

                        public void setIsParent(Object isParent) {
                            this.isParent = isParent;
                        }

                        public boolean isChecked() {
                            return checked;
                        }

                        public void setChecked(boolean checked) {
                            this.checked = checked;
                        }

                        public Object getOpen() {
                            return open;
                        }

                        public void setOpen(Object open) {
                            this.open = open;
                        }

                        public Object getIsSelected() {
                            return isSelected;
                        }

                        public void setIsSelected(Object isSelected) {
                            this.isSelected = isSelected;
                        }

                        public Object getFullPath() {
                            return fullPath;
                        }

                        public void setFullPath(Object fullPath) {
                            this.fullPath = fullPath;
                        }

                        public Object getTitle() {
                            return title;
                        }

                        public void setTitle(Object title) {
                            this.title = title;
                        }

                        public String getUsername() {
                            return username;
                        }

                        public void setUsername(String username) {
                            this.username = username;
                        }

                        public Object getPassword() {
                            return password;
                        }

                        public void setPassword(Object password) {
                            this.password = password;
                        }

                        public String getFullname() {
                            return fullname;
                        }

                        public void setFullname(String fullname) {
                            this.fullname = fullname;
                        }

                        public Object getMobile() {
                            return mobile;
                        }

                        public void setMobile(Object mobile) {
                            this.mobile = mobile;
                        }

                        public Object getIdNo() {
                            return idNo;
                        }

                        public void setIdNo(Object idNo) {
                            this.idNo = idNo;
                        }

                        public Object getRoles() {
                            return roles;
                        }

                        public void setRoles(Object roles) {
                            this.roles = roles;
                        }

                        public Object getDepartment() {
                            return department;
                        }

                        public void setDepartment(Object department) {
                            this.department = department;
                        }

                        public Object getSex() {
                            return sex;
                        }

                        public void setSex(Object sex) {
                            this.sex = sex;
                        }

                        public Object getNativePlace() {
                            return nativePlace;
                        }

                        public void setNativePlace(Object nativePlace) {
                            this.nativePlace = nativePlace;
                        }

                        public Object getTelephone() {
                            return telephone;
                        }

                        public void setTelephone(Object telephone) {
                            this.telephone = telephone;
                        }

                        public Object getEmail() {
                            return email;
                        }

                        public void setEmail(Object email) {
                            this.email = email;
                        }

                        public Object getPoliticalStatus() {
                            return politicalStatus;
                        }

                        public void setPoliticalStatus(Object politicalStatus) {
                            this.politicalStatus = politicalStatus;
                        }

                        public Object getJob() {
                            return job;
                        }

                        public void setJob(Object job) {
                            this.job = job;
                        }

                        public Object getGraduationDate() {
                            return graduationDate;
                        }

                        public void setGraduationDate(Object graduationDate) {
                            this.graduationDate = graduationDate;
                        }

                        public Object getEntryDate() {
                            return entryDate;
                        }

                        public void setEntryDate(Object entryDate) {
                            this.entryDate = entryDate;
                        }

                        public Object getDemissionDate() {
                            return demissionDate;
                        }

                        public void setDemissionDate(Object demissionDate) {
                            this.demissionDate = demissionDate;
                        }

                        public Object getConverseDate() {
                            return converseDate;
                        }

                        public void setConverseDate(Object converseDate) {
                            this.converseDate = converseDate;
                        }

                        public Object getTrasferDate() {
                            return trasferDate;
                        }

                        public void setTrasferDate(Object trasferDate) {
                            this.trasferDate = trasferDate;
                        }

                        public Object getSocialSecurityDate() {
                            return socialSecurityDate;
                        }

                        public void setSocialSecurityDate(Object socialSecurityDate) {
                            this.socialSecurityDate = socialSecurityDate;
                        }

                        public Object getServingAge() {
                            return servingAge;
                        }

                        public void setServingAge(Object servingAge) {
                            this.servingAge = servingAge;
                        }

                        public Object getOnDutyAge() {
                            return onDutyAge;
                        }

                        public void setOnDutyAge(Object onDutyAge) {
                            this.onDutyAge = onDutyAge;
                        }

                        public Object getWorkingAge() {
                            return workingAge;
                        }

                        public void setWorkingAge(Object workingAge) {
                            this.workingAge = workingAge;
                        }

                        public Object getBirthday() {
                            return birthday;
                        }

                        public void setBirthday(Object birthday) {
                            this.birthday = birthday;
                        }

                        public Object getAge() {
                            return age;
                        }

                        public void setAge(Object age) {
                            this.age = age;
                        }

                        public Object getEducation() {
                            return education;
                        }

                        public void setEducation(Object education) {
                            this.education = education;
                        }

                        public Object getSchool() {
                            return school;
                        }

                        public void setSchool(Object school) {
                            this.school = school;
                        }

                        public Object getProfesstionalTitle() {
                            return professtionalTitle;
                        }

                        public void setProfesstionalTitle(Object professtionalTitle) {
                            this.professtionalTitle = professtionalTitle;
                        }

                        public Object getProfessional() {
                            return professional;
                        }

                        public void setProfessional(Object professional) {
                            this.professional = professional;
                        }

                        public Object getEcontactorName() {
                            return econtactorName;
                        }

                        public void setEcontactorName(Object econtactorName) {
                            this.econtactorName = econtactorName;
                        }

                        public Object getEcontactorRelation() {
                            return econtactorRelation;
                        }

                        public void setEcontactorRelation(Object econtactorRelation) {
                            this.econtactorRelation = econtactorRelation;
                        }

                        public Object getEcontactorTel() {
                            return econtactorTel;
                        }

                        public void setEcontactorTel(Object econtactorTel) {
                            this.econtactorTel = econtactorTel;
                        }

                        public Object getHomeAddress() {
                            return homeAddress;
                        }

                        public void setHomeAddress(Object homeAddress) {
                            this.homeAddress = homeAddress;
                        }

                        public Object getCensusRegister() {
                            return censusRegister;
                        }

                        public void setCensusRegister(Object censusRegister) {
                            this.censusRegister = censusRegister;
                        }

                        public Object getEntryBatch() {
                            return entryBatch;
                        }

                        public void setEntryBatch(Object entryBatch) {
                            this.entryBatch = entryBatch;
                        }

                        public Object getFstContractBeginDate() {
                            return fstContractBeginDate;
                        }

                        public void setFstContractBeginDate(Object fstContractBeginDate) {
                            this.fstContractBeginDate = fstContractBeginDate;
                        }

                        public Object getFstContractEndDate() {
                            return fstContractEndDate;
                        }

                        public void setFstContractEndDate(Object fstContractEndDate) {
                            this.fstContractEndDate = fstContractEndDate;
                        }

                        public Object getScdContractBeginDate() {
                            return scdContractBeginDate;
                        }

                        public void setScdContractBeginDate(Object scdContractBeginDate) {
                            this.scdContractBeginDate = scdContractBeginDate;
                        }

                        public Object getScdContractEndDate() {
                            return scdContractEndDate;
                        }

                        public void setScdContractEndDate(Object scdContractEndDate) {
                            this.scdContractEndDate = scdContractEndDate;
                        }

                        public Object getThdContractBeginDate() {
                            return thdContractBeginDate;
                        }

                        public void setThdContractBeginDate(Object thdContractBeginDate) {
                            this.thdContractBeginDate = thdContractBeginDate;
                        }

                        public Object getThdContractEndDate() {
                            return thdContractEndDate;
                        }

                        public void setThdContractEndDate(Object thdContractEndDate) {
                            this.thdContractEndDate = thdContractEndDate;
                        }

                        public Object getAnnualLeaveDays() {
                            return annualLeaveDays;
                        }

                        public void setAnnualLeaveDays(Object annualLeaveDays) {
                            this.annualLeaveDays = annualLeaveDays;
                        }

                        public Object getLieuLeaveDays() {
                            return lieuLeaveDays;
                        }

                        public void setLieuLeaveDays(Object lieuLeaveDays) {
                            this.lieuLeaveDays = lieuLeaveDays;
                        }

                        public Object getSurplusAnnualLeaveDays() {
                            return surplusAnnualLeaveDays;
                        }

                        public void setSurplusAnnualLeaveDays(Object surplusAnnualLeaveDays) {
                            this.surplusAnnualLeaveDays = surplusAnnualLeaveDays;
                        }

                        public Object getSurplusLieuLeaveDays() {
                            return surplusLieuLeaveDays;
                        }

                        public void setSurplusLieuLeaveDays(Object surplusLieuLeaveDays) {
                            this.surplusLieuLeaveDays = surplusLieuLeaveDays;
                        }

                        public Object getAnnualSalary() {
                            return annualSalary;
                        }

                        public void setAnnualSalary(Object annualSalary) {
                            this.annualSalary = annualSalary;
                        }

                        public Object getSocialSecurityBase() {
                            return socialSecurityBase;
                        }

                        public void setSocialSecurityBase(Object socialSecurityBase) {
                            this.socialSecurityBase = socialSecurityBase;
                        }

                        public Object getTelSubsidy() {
                            return telSubsidy;
                        }

                        public void setTelSubsidy(Object telSubsidy) {
                            this.telSubsidy = telSubsidy;
                        }

                        public Object getOtherSalary() {
                            return otherSalary;
                        }

                        public void setOtherSalary(Object otherSalary) {
                            this.otherSalary = otherSalary;
                        }

                        public Object getIsOnJob() {
                            return isOnJob;
                        }

                        public void setIsOnJob(Object isOnJob) {
                            this.isOnJob = isOnJob;
                        }

                        public Object getIsBlock() {
                            return isBlock;
                        }

                        public void setIsBlock(Object isBlock) {
                            this.isBlock = isBlock;
                        }

                        public Object getBlockReason() {
                            return blockReason;
                        }

                        public void setBlockReason(Object blockReason) {
                            this.blockReason = blockReason;
                        }

                        public Object getBlockDate() {
                            return blockDate;
                        }

                        public void setBlockDate(Object blockDate) {
                            this.blockDate = blockDate;
                        }

                        public Object getIsErasable() {
                            return isErasable;
                        }

                        public void setIsErasable(Object isErasable) {
                            this.isErasable = isErasable;
                        }

                        public Object getFailAttempts() {
                            return failAttempts;
                        }

                        public void setFailAttempts(Object failAttempts) {
                            this.failAttempts = failAttempts;
                        }

                        public Object getLastLoginDate() {
                            return lastLoginDate;
                        }

                        public void setLastLoginDate(Object lastLoginDate) {
                            this.lastLoginDate = lastLoginDate;
                        }

                        public Object getResetPwdDate() {
                            return resetPwdDate;
                        }

                        public void setResetPwdDate(Object resetPwdDate) {
                            this.resetPwdDate = resetPwdDate;
                        }

                        public Object getCreatedBy() {
                            return createdBy;
                        }

                        public void setCreatedBy(Object createdBy) {
                            this.createdBy = createdBy;
                        }

                        public Object getCreatedTime() {
                            return createdTime;
                        }

                        public void setCreatedTime(Object createdTime) {
                            this.createdTime = createdTime;
                        }

                        public Object getLastUpdBy() {
                            return lastUpdBy;
                        }

                        public void setLastUpdBy(Object lastUpdBy) {
                            this.lastUpdBy = lastUpdBy;
                        }

                        public Object getLastUpdTime() {
                            return lastUpdTime;
                        }

                        public void setLastUpdTime(Object lastUpdTime) {
                            this.lastUpdTime = lastUpdTime;
                        }

                        public Object getDeletedBy() {
                            return deletedBy;
                        }

                        public void setDeletedBy(Object deletedBy) {
                            this.deletedBy = deletedBy;
                        }

                        public Object getDeletedTime() {
                            return deletedTime;
                        }

                        public void setDeletedTime(Object deletedTime) {
                            this.deletedTime = deletedTime;
                        }

                        public Object getReserveddecimal1() {
                            return reserveddecimal1;
                        }

                        public void setReserveddecimal1(Object reserveddecimal1) {
                            this.reserveddecimal1 = reserveddecimal1;
                        }

                        public Object getReserveddecimal2() {
                            return reserveddecimal2;
                        }

                        public void setReserveddecimal2(Object reserveddecimal2) {
                            this.reserveddecimal2 = reserveddecimal2;
                        }

                        public Object getReserveddecimal3() {
                            return reserveddecimal3;
                        }

                        public void setReserveddecimal3(Object reserveddecimal3) {
                            this.reserveddecimal3 = reserveddecimal3;
                        }

                        public Object getReserveddecimal4() {
                            return reserveddecimal4;
                        }

                        public void setReserveddecimal4(Object reserveddecimal4) {
                            this.reserveddecimal4 = reserveddecimal4;
                        }

                        public Object getReserveddecimal5() {
                            return reserveddecimal5;
                        }

                        public void setReserveddecimal5(Object reserveddecimal5) {
                            this.reserveddecimal5 = reserveddecimal5;
                        }

                        public Object getExtendInfo() {
                            return extendInfo;
                        }

                        public void setExtendInfo(Object extendInfo) {
                            this.extendInfo = extendInfo;
                        }

                        public Object getActAssigneeFlag() {
                            return actAssigneeFlag;
                        }

                        public void setActAssigneeFlag(Object actAssigneeFlag) {
                            this.actAssigneeFlag = actAssigneeFlag;
                        }

                        public Object getActAssigneeId() {
                            return actAssigneeId;
                        }

                        public void setActAssigneeId(Object actAssigneeId) {
                            this.actAssigneeId = actAssigneeId;
                        }

                        public Object getActProcessKeyList() {
                            return actProcessKeyList;
                        }

                        public void setActProcessKeyList(Object actProcessKeyList) {
                            this.actProcessKeyList = actProcessKeyList;
                        }

                        public Object getResume() {
                            return resume;
                        }

                        public void setResume(Object resume) {
                            this.resume = resume;
                        }

                        public Object getRemark() {
                            return remark;
                        }

                        public void setRemark(Object remark) {
                            this.remark = remark;
                        }

                        public Object getReservedstring1() {
                            return reservedstring1;
                        }

                        public void setReservedstring1(Object reservedstring1) {
                            this.reservedstring1 = reservedstring1;
                        }

                        public Object getReservedstring2() {
                            return reservedstring2;
                        }

                        public void setReservedstring2(Object reservedstring2) {
                            this.reservedstring2 = reservedstring2;
                        }

                        public Object getReservedstring3() {
                            return reservedstring3;
                        }

                        public void setReservedstring3(Object reservedstring3) {
                            this.reservedstring3 = reservedstring3;
                        }

                        public Object getReservedstring4() {
                            return reservedstring4;
                        }

                        public void setReservedstring4(Object reservedstring4) {
                            this.reservedstring4 = reservedstring4;
                        }

                        public Object getReservedstring5() {
                            return reservedstring5;
                        }

                        public void setReservedstring5(Object reservedstring5) {
                            this.reservedstring5 = reservedstring5;
                        }

                        public Object getAccessibleDeptCodes() {
                            return accessibleDeptCodes;
                        }

                        public void setAccessibleDeptCodes(Object accessibleDeptCodes) {
                            this.accessibleDeptCodes = accessibleDeptCodes;
                        }

                        public Object getAccessibleRoleCodes() {
                            return accessibleRoleCodes;
                        }

                        public void setAccessibleRoleCodes(Object accessibleRoleCodes) {
                            this.accessibleRoleCodes = accessibleRoleCodes;
                        }

                        public Object getAccessibleDeptCodesStr() {
                            return accessibleDeptCodesStr;
                        }

                        public void setAccessibleDeptCodesStr(Object accessibleDeptCodesStr) {
                            this.accessibleDeptCodesStr = accessibleDeptCodesStr;
                        }

                        public Object getAccessibleRoleCodesStr() {
                            return accessibleRoleCodesStr;
                        }

                        public void setAccessibleRoleCodesStr(Object accessibleRoleCodesStr) {
                            this.accessibleRoleCodesStr = accessibleRoleCodesStr;
                        }

                        public Object getInstIdPathList() {
                            return instIdPathList;
                        }

                        public void setInstIdPathList(Object instIdPathList) {
                            this.instIdPathList = instIdPathList;
                        }

                        public Object getRoleIds() {
                            return roleIds;
                        }

                        public void setRoleIds(Object roleIds) {
                            this.roleIds = roleIds;
                        }

                        public Object getRoleIdList() {
                            return roleIdList;
                        }

                        public void setRoleIdList(Object roleIdList) {
                            this.roleIdList = roleIdList;
                        }

                        public Object getRoleCodes() {
                            return roleCodes;
                        }

                        public void setRoleCodes(Object roleCodes) {
                            this.roleCodes = roleCodes;
                        }

                        public Object getRoleCodeList() {
                            return roleCodeList;
                        }

                        public void setRoleCodeList(Object roleCodeList) {
                            this.roleCodeList = roleCodeList;
                        }

                        public Object getRoleNames() {
                            return roleNames;
                        }

                        public void setRoleNames(Object roleNames) {
                            this.roleNames = roleNames;
                        }

                        public Object getRoleNameList() {
                            return roleNameList;
                        }

                        public void setRoleNameList(Object roleNameList) {
                            this.roleNameList = roleNameList;
                        }

                        public String getDescription() {
                            return description;
                        }

                        public void setDescription(String description) {
                            this.description = description;
                        }

                        public Object getGroupId() {
                            return groupId;
                        }

                        public void setGroupId(Object groupId) {
                            this.groupId = groupId;
                        }

                        public Object getGroupCode() {
                            return groupCode;
                        }

                        public void setGroupCode(Object groupCode) {
                            this.groupCode = groupCode;
                        }

                        public Object getGroupName() {
                            return groupName;
                        }

                        public void setGroupName(Object groupName) {
                            this.groupName = groupName;
                        }

                        public Object getCompanyId() {
                            return companyId;
                        }

                        public void setCompanyId(Object companyId) {
                            this.companyId = companyId;
                        }

                        public Object getCompanyCode() {
                            return companyCode;
                        }

                        public void setCompanyCode(Object companyCode) {
                            this.companyCode = companyCode;
                        }

                        public Object getCompanyName() {
                            return companyName;
                        }

                        public void setCompanyName(Object companyName) {
                            this.companyName = companyName;
                        }

                        public Object getDepartmentName() {
                            return departmentName;
                        }

                        public void setDepartmentName(Object departmentName) {
                            this.departmentName = departmentName;
                        }

                        public Object getDepartmentCode() {
                            return departmentCode;
                        }

                        public void setDepartmentCode(Object departmentCode) {
                            this.departmentCode = departmentCode;
                        }

                        public Object getDepartmentId() {
                            return departmentId;
                        }

                        public void setDepartmentId(Object departmentId) {
                            this.departmentId = departmentId;
                        }

                        public Object getDepartmentIds() {
                            return departmentIds;
                        }

                        public void setDepartmentIds(Object departmentIds) {
                            this.departmentIds = departmentIds;
                        }

                        public Object getDepartmentIdList() {
                            return departmentIdList;
                        }

                        public void setDepartmentIdList(Object departmentIdList) {
                            this.departmentIdList = departmentIdList;
                        }

                        public Object getDepartmentCodes() {
                            return departmentCodes;
                        }

                        public void setDepartmentCodes(Object departmentCodes) {
                            this.departmentCodes = departmentCodes;
                        }

                        public Object getDepartmentCodeList() {
                            return departmentCodeList;
                        }

                        public void setDepartmentCodeList(Object departmentCodeList) {
                            this.departmentCodeList = departmentCodeList;
                        }

                        public Object getDepartmentNames() {
                            return departmentNames;
                        }

                        public void setDepartmentNames(Object departmentNames) {
                            this.departmentNames = departmentNames;
                        }

                        public Object getDepartmentNameList() {
                            return departmentNameList;
                        }

                        public void setDepartmentNameList(Object departmentNameList) {
                            this.departmentNameList = departmentNameList;
                        }

                        public Object getDepartmentExtendInfo() {
                            return departmentExtendInfo;
                        }

                        public void setDepartmentExtendInfo(Object departmentExtendInfo) {
                            this.departmentExtendInfo = departmentExtendInfo;
                        }

                        public Object getProfileAttachmentId() {
                            return profileAttachmentId;
                        }

                        public void setProfileAttachmentId(Object profileAttachmentId) {
                            this.profileAttachmentId = profileAttachmentId;
                        }

                        public Object getProfileHttpUrl() {
                            return profileHttpUrl;
                        }

                        public void setProfileHttpUrl(Object profileHttpUrl) {
                            this.profileHttpUrl = profileHttpUrl;
                        }

                        public Object getParent() {
                            return parent;
                        }

                        public void setParent(Object parent) {
                            this.parent = parent;
                        }

                        public List<InstListBeanXX> getInstList() {
                            return instList;
                        }

                        public void setInstList(List<InstListBeanXX> instList) {
                            this.instList = instList;
                        }

                        public List<RoleListBeanXX> getRoleList() {
                            return roleList;
                        }

                        public void setRoleList(List<RoleListBeanXX> roleList) {
                            this.roleList = roleList;
                        }

                        public static class InstListBeanXX {
                            /**
                             * id : 98092356963663988
                             * pId : null
                             * name : 财务管理部
                             * nodeType : null
                             * isParent : null
                             * checked : false
                             * open : null
                             * isSelected : null
                             * fullPath : null
                             * title : null
                             * code : null
                             * sortNo : null
                             * remark : null
                             * version : null
                             * children : null
                             * userList : null
                             * extendInfo : null
                             * parent : null
                             */

                            private String id;
                            private Object pId;
                            private String name;
                            private Object nodeType;
                            private Object isParent;
                            private boolean checked;
                            private Object open;
                            private Object isSelected;
                            private Object fullPath;
                            private Object title;
                            private Object code;
                            private Object sortNo;
                            private Object remark;
                            private Object version;
                            private Object children;
                            private Object userList;
                            private Object extendInfo;
                            private Object parent;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }

                            public Object getPId() {
                                return pId;
                            }

                            public void setPId(Object pId) {
                                this.pId = pId;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public Object getNodeType() {
                                return nodeType;
                            }

                            public void setNodeType(Object nodeType) {
                                this.nodeType = nodeType;
                            }

                            public Object getIsParent() {
                                return isParent;
                            }

                            public void setIsParent(Object isParent) {
                                this.isParent = isParent;
                            }

                            public boolean isChecked() {
                                return checked;
                            }

                            public void setChecked(boolean checked) {
                                this.checked = checked;
                            }

                            public Object getOpen() {
                                return open;
                            }

                            public void setOpen(Object open) {
                                this.open = open;
                            }

                            public Object getIsSelected() {
                                return isSelected;
                            }

                            public void setIsSelected(Object isSelected) {
                                this.isSelected = isSelected;
                            }

                            public Object getFullPath() {
                                return fullPath;
                            }

                            public void setFullPath(Object fullPath) {
                                this.fullPath = fullPath;
                            }

                            public Object getTitle() {
                                return title;
                            }

                            public void setTitle(Object title) {
                                this.title = title;
                            }

                            public Object getCode() {
                                return code;
                            }

                            public void setCode(Object code) {
                                this.code = code;
                            }

                            public Object getSortNo() {
                                return sortNo;
                            }

                            public void setSortNo(Object sortNo) {
                                this.sortNo = sortNo;
                            }

                            public Object getRemark() {
                                return remark;
                            }

                            public void setRemark(Object remark) {
                                this.remark = remark;
                            }

                            public Object getVersion() {
                                return version;
                            }

                            public void setVersion(Object version) {
                                this.version = version;
                            }

                            public Object getChildren() {
                                return children;
                            }

                            public void setChildren(Object children) {
                                this.children = children;
                            }

                            public Object getUserList() {
                                return userList;
                            }

                            public void setUserList(Object userList) {
                                this.userList = userList;
                            }

                            public Object getExtendInfo() {
                                return extendInfo;
                            }

                            public void setExtendInfo(Object extendInfo) {
                                this.extendInfo = extendInfo;
                            }

                            public Object getParent() {
                                return parent;
                            }

                            public void setParent(Object parent) {
                                this.parent = parent;
                            }
                        }

                        public static class RoleListBeanXX {
                            /**
                             * id : 98092356963665439
                             * pId : null
                             * name : 财务部经理
                             * nodeType : null
                             * isParent : null
                             * checked : false
                             * open : null
                             * isSelected : null
                             * fullPath : null
                             * title : null
                             * code : null
                             * description : [18216592503]方彦国
                             * category : null
                             * userList : null
                             * extendInfo : null
                             * parent : null
                             */

                            private String id;
                            private Object pId;
                            private String name;
                            private Object nodeType;
                            private Object isParent;
                            private boolean checked;
                            private Object open;
                            private Object isSelected;
                            private Object fullPath;
                            private Object title;
                            private Object code;
                            private String description;
                            private Object category;
                            private Object userList;
                            private Object extendInfo;
                            private Object parent;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }

                            public Object getPId() {
                                return pId;
                            }

                            public void setPId(Object pId) {
                                this.pId = pId;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public Object getNodeType() {
                                return nodeType;
                            }

                            public void setNodeType(Object nodeType) {
                                this.nodeType = nodeType;
                            }

                            public Object getIsParent() {
                                return isParent;
                            }

                            public void setIsParent(Object isParent) {
                                this.isParent = isParent;
                            }

                            public boolean isChecked() {
                                return checked;
                            }

                            public void setChecked(boolean checked) {
                                this.checked = checked;
                            }

                            public Object getOpen() {
                                return open;
                            }

                            public void setOpen(Object open) {
                                this.open = open;
                            }

                            public Object getIsSelected() {
                                return isSelected;
                            }

                            public void setIsSelected(Object isSelected) {
                                this.isSelected = isSelected;
                            }

                            public Object getFullPath() {
                                return fullPath;
                            }

                            public void setFullPath(Object fullPath) {
                                this.fullPath = fullPath;
                            }

                            public Object getTitle() {
                                return title;
                            }

                            public void setTitle(Object title) {
                                this.title = title;
                            }

                            public Object getCode() {
                                return code;
                            }

                            public void setCode(Object code) {
                                this.code = code;
                            }

                            public String getDescription() {
                                return description;
                            }

                            public void setDescription(String description) {
                                this.description = description;
                            }

                            public Object getCategory() {
                                return category;
                            }

                            public void setCategory(Object category) {
                                this.category = category;
                            }

                            public Object getUserList() {
                                return userList;
                            }

                            public void setUserList(Object userList) {
                                this.userList = userList;
                            }

                            public Object getExtendInfo() {
                                return extendInfo;
                            }

                            public void setExtendInfo(Object extendInfo) {
                                this.extendInfo = extendInfo;
                            }

                            public Object getParent() {
                                return parent;
                            }

                            public void setParent(Object parent) {
                                this.parent = parent;
                            }
                        }
                    }
                }

                public static class ExtendInfoBean {
                    /**
                     * taskEndNotice : [{"wechatOpenIds":"","mobiles":"","smsTemplateId":"","enabled":"true","content":""}]
                     * rolesOfDeptIds : null
                     * taskEndSql : {"enabled":"true","sql":"update CFBIZ_Business_Xiaodai set Status='JQ' where ID = '${CFBIZ_Prepayment.F_ID}'"}
                     * approvalResultList : [{"default":"false","code":"OK","nextNodes":[{"nodeKey":""}],"isEnd":"false","desc":"同意","validate":"true"},{"default":"false","code":"BK","nextNodes":[{"nodeKey":""}],"isEnd":"false","desc":"驳回","validate":"false"}]
                     * timelimit : {"enabled":"false"}
                     * allTaskBeginNotice : [{"wechatOpenIds":"","mobiles":"","smsTemplateId":"","enabled":"false","content":""}]
                     * procEndNotice : [{"wechatOpenIds":"","mobiles":"","smsTemplateId":"","enabled":"false","content":""}]
                     * rolesOfParentDept : false
                     * approvalComment : {"enabled":"true","required":"false"}
                     * taskBeginSql : {"enabled":"true","sql":""}
                     * isAutoComplete : false
                     * nextNode : {"enabled":"false","required":"false"}
                     * nextOperators : {"enabled":"false","required":"false"}
                     * rolesOfMyDept : false
                     * nextProcess : [{"params":{"masterId":"","formGroupCode":"","processKey":""},"enabled":"false"}]
                     * backtrack : {"enabled":"false"}
                     */

                    private Object rolesOfDeptIds;
                    private TaskEndSqlBean taskEndSql;
                    private TimelimitBean timelimit;
                    private String rolesOfParentDept;
                    private ApprovalCommentBean approvalComment;
                    private TaskBeginSqlBean taskBeginSql;
                    private String isAutoComplete;
                    private NextNodeBean nextNode;
                    private NextOperatorsBean nextOperators;
                    private String rolesOfMyDept;
                    private BacktrackBean backtrack;
                    private List<TaskEndNoticeBean> taskEndNotice;
                    private List<ApprovalResultListBean> approvalResultList;
                    private List<AllTaskBeginNoticeBean> allTaskBeginNotice;
                    private List<ProcEndNoticeBean> procEndNotice;
                    private List<NextProcessBean> nextProcess;

                    public Object getRolesOfDeptIds() {
                        return rolesOfDeptIds;
                    }

                    public void setRolesOfDeptIds(Object rolesOfDeptIds) {
                        this.rolesOfDeptIds = rolesOfDeptIds;
                    }

                    public TaskEndSqlBean getTaskEndSql() {
                        return taskEndSql;
                    }

                    public void setTaskEndSql(TaskEndSqlBean taskEndSql) {
                        this.taskEndSql = taskEndSql;
                    }

                    public TimelimitBean getTimelimit() {
                        return timelimit;
                    }

                    public void setTimelimit(TimelimitBean timelimit) {
                        this.timelimit = timelimit;
                    }

                    public String getRolesOfParentDept() {
                        return rolesOfParentDept;
                    }

                    public void setRolesOfParentDept(String rolesOfParentDept) {
                        this.rolesOfParentDept = rolesOfParentDept;
                    }

                    public ApprovalCommentBean getApprovalComment() {
                        return approvalComment;
                    }

                    public void setApprovalComment(ApprovalCommentBean approvalComment) {
                        this.approvalComment = approvalComment;
                    }

                    public TaskBeginSqlBean getTaskBeginSql() {
                        return taskBeginSql;
                    }

                    public void setTaskBeginSql(TaskBeginSqlBean taskBeginSql) {
                        this.taskBeginSql = taskBeginSql;
                    }

                    public String getIsAutoComplete() {
                        return isAutoComplete;
                    }

                    public void setIsAutoComplete(String isAutoComplete) {
                        this.isAutoComplete = isAutoComplete;
                    }

                    public NextNodeBean getNextNode() {
                        return nextNode;
                    }

                    public void setNextNode(NextNodeBean nextNode) {
                        this.nextNode = nextNode;
                    }

                    public NextOperatorsBean getNextOperators() {
                        return nextOperators;
                    }

                    public void setNextOperators(NextOperatorsBean nextOperators) {
                        this.nextOperators = nextOperators;
                    }

                    public String getRolesOfMyDept() {
                        return rolesOfMyDept;
                    }

                    public void setRolesOfMyDept(String rolesOfMyDept) {
                        this.rolesOfMyDept = rolesOfMyDept;
                    }

                    public BacktrackBean getBacktrack() {
                        return backtrack;
                    }

                    public void setBacktrack(BacktrackBean backtrack) {
                        this.backtrack = backtrack;
                    }

                    public List<TaskEndNoticeBean> getTaskEndNotice() {
                        return taskEndNotice;
                    }

                    public void setTaskEndNotice(List<TaskEndNoticeBean> taskEndNotice) {
                        this.taskEndNotice = taskEndNotice;
                    }

                    public List<ApprovalResultListBean> getApprovalResultList() {
                        return approvalResultList;
                    }

                    public void setApprovalResultList(List<ApprovalResultListBean> approvalResultList) {
                        this.approvalResultList = approvalResultList;
                    }

                    public List<AllTaskBeginNoticeBean> getAllTaskBeginNotice() {
                        return allTaskBeginNotice;
                    }

                    public void setAllTaskBeginNotice(List<AllTaskBeginNoticeBean> allTaskBeginNotice) {
                        this.allTaskBeginNotice = allTaskBeginNotice;
                    }

                    public List<ProcEndNoticeBean> getProcEndNotice() {
                        return procEndNotice;
                    }

                    public void setProcEndNotice(List<ProcEndNoticeBean> procEndNotice) {
                        this.procEndNotice = procEndNotice;
                    }

                    public List<NextProcessBean> getNextProcess() {
                        return nextProcess;
                    }

                    public void setNextProcess(List<NextProcessBean> nextProcess) {
                        this.nextProcess = nextProcess;
                    }

                    public static class TaskEndSqlBean {
                        /**
                         * enabled : true
                         * sql : update CFBIZ_Business_Xiaodai set Status='JQ' where ID = '${CFBIZ_Prepayment.F_ID}'
                         */

                        private String enabled;
                        private String sql;

                        public String getEnabled() {
                            return enabled;
                        }

                        public void setEnabled(String enabled) {
                            this.enabled = enabled;
                        }

                        public String getSql() {
                            return sql;
                        }

                        public void setSql(String sql) {
                            this.sql = sql;
                        }
                    }

                    public static class TimelimitBean {
                        /**
                         * enabled : false
                         */

                        private String enabled;

                        public String getEnabled() {
                            return enabled;
                        }

                        public void setEnabled(String enabled) {
                            this.enabled = enabled;
                        }
                    }

                    public static class ApprovalCommentBean {
                        /**
                         * enabled : true
                         * required : false
                         */

                        private String enabled;
                        private String required;

                        public String getEnabled() {
                            return enabled;
                        }

                        public void setEnabled(String enabled) {
                            this.enabled = enabled;
                        }

                        public String getRequired() {
                            return required;
                        }

                        public void setRequired(String required) {
                            this.required = required;
                        }
                    }

                    public static class TaskBeginSqlBean {
                        /**
                         * enabled : true
                         * sql :
                         */

                        private String enabled;
                        private String sql;

                        public String getEnabled() {
                            return enabled;
                        }

                        public void setEnabled(String enabled) {
                            this.enabled = enabled;
                        }

                        public String getSql() {
                            return sql;
                        }

                        public void setSql(String sql) {
                            this.sql = sql;
                        }
                    }

                    public static class NextNodeBean {
                        /**
                         * enabled : false
                         * required : false
                         */

                        private String enabled;
                        private String required;

                        public String getEnabled() {
                            return enabled;
                        }

                        public void setEnabled(String enabled) {
                            this.enabled = enabled;
                        }

                        public String getRequired() {
                            return required;
                        }

                        public void setRequired(String required) {
                            this.required = required;
                        }
                    }

                    public static class NextOperatorsBean {
                        /**
                         * enabled : false
                         * required : false
                         */

                        private String enabled;
                        private String required;

                        public String getEnabled() {
                            return enabled;
                        }

                        public void setEnabled(String enabled) {
                            this.enabled = enabled;
                        }

                        public String getRequired() {
                            return required;
                        }

                        public void setRequired(String required) {
                            this.required = required;
                        }
                    }

                    public static class BacktrackBean {
                        /**
                         * enabled : false
                         */

                        private String enabled;

                        public String getEnabled() {
                            return enabled;
                        }

                        public void setEnabled(String enabled) {
                            this.enabled = enabled;
                        }
                    }

                    public static class TaskEndNoticeBean {
                        /**
                         * wechatOpenIds :
                         * mobiles :
                         * smsTemplateId :
                         * enabled : true
                         * content :
                         */

                        private String wechatOpenIds;
                        private String mobiles;
                        private String smsTemplateId;
                        private String enabled;
                        private String content;

                        public String getWechatOpenIds() {
                            return wechatOpenIds;
                        }

                        public void setWechatOpenIds(String wechatOpenIds) {
                            this.wechatOpenIds = wechatOpenIds;
                        }

                        public String getMobiles() {
                            return mobiles;
                        }

                        public void setMobiles(String mobiles) {
                            this.mobiles = mobiles;
                        }

                        public String getSmsTemplateId() {
                            return smsTemplateId;
                        }

                        public void setSmsTemplateId(String smsTemplateId) {
                            this.smsTemplateId = smsTemplateId;
                        }

                        public String getEnabled() {
                            return enabled;
                        }

                        public void setEnabled(String enabled) {
                            this.enabled = enabled;
                        }

                        public String getContent() {
                            return content;
                        }

                        public void setContent(String content) {
                            this.content = content;
                        }
                    }



                    public static class AllTaskBeginNoticeBean {
                        /**
                         * wechatOpenIds :
                         * mobiles :
                         * smsTemplateId :
                         * enabled : false
                         * content :
                         */

                        private String wechatOpenIds;
                        private String mobiles;
                        private String smsTemplateId;
                        private String enabled;
                        private String content;

                        public String getWechatOpenIds() {
                            return wechatOpenIds;
                        }

                        public void setWechatOpenIds(String wechatOpenIds) {
                            this.wechatOpenIds = wechatOpenIds;
                        }

                        public String getMobiles() {
                            return mobiles;
                        }

                        public void setMobiles(String mobiles) {
                            this.mobiles = mobiles;
                        }

                        public String getSmsTemplateId() {
                            return smsTemplateId;
                        }

                        public void setSmsTemplateId(String smsTemplateId) {
                            this.smsTemplateId = smsTemplateId;
                        }

                        public String getEnabled() {
                            return enabled;
                        }

                        public void setEnabled(String enabled) {
                            this.enabled = enabled;
                        }

                        public String getContent() {
                            return content;
                        }

                        public void setContent(String content) {
                            this.content = content;
                        }
                    }

                    public static class ProcEndNoticeBean {
                        /**
                         * wechatOpenIds :
                         * mobiles :
                         * smsTemplateId :
                         * enabled : false
                         * content :
                         */

                        private String wechatOpenIds;
                        private String mobiles;
                        private String smsTemplateId;
                        private String enabled;
                        private String content;

                        public String getWechatOpenIds() {
                            return wechatOpenIds;
                        }

                        public void setWechatOpenIds(String wechatOpenIds) {
                            this.wechatOpenIds = wechatOpenIds;
                        }

                        public String getMobiles() {
                            return mobiles;
                        }

                        public void setMobiles(String mobiles) {
                            this.mobiles = mobiles;
                        }

                        public String getSmsTemplateId() {
                            return smsTemplateId;
                        }

                        public void setSmsTemplateId(String smsTemplateId) {
                            this.smsTemplateId = smsTemplateId;
                        }

                        public String getEnabled() {
                            return enabled;
                        }

                        public void setEnabled(String enabled) {
                            this.enabled = enabled;
                        }

                        public String getContent() {
                            return content;
                        }

                        public void setContent(String content) {
                            this.content = content;
                        }
                    }

                    public static class NextProcessBean {
                        /**
                         * params : {"masterId":"","formGroupCode":"","processKey":""}
                         * enabled : false
                         */

                        private ParamsBean params;
                        private String enabled;

                        public ParamsBean getParams() {
                            return params;
                        }

                        public void setParams(ParamsBean params) {
                            this.params = params;
                        }

                        public String getEnabled() {
                            return enabled;
                        }

                        public void setEnabled(String enabled) {
                            this.enabled = enabled;
                        }

                        public static class ParamsBean {
                            /**
                             * masterId :
                             * formGroupCode :
                             * processKey :
                             */

                            private String masterId;
                            private String formGroupCode;
                            private String processKey;

                            public String getMasterId() {
                                return masterId;
                            }

                            public void setMasterId(String masterId) {
                                this.masterId = masterId;
                            }

                            public String getFormGroupCode() {
                                return formGroupCode;
                            }

                            public void setFormGroupCode(String formGroupCode) {
                                this.formGroupCode = formGroupCode;
                            }

                            public String getProcessKey() {
                                return processKey;
                            }

                            public void setProcessKey(String processKey) {
                                this.processKey = processKey;
                            }
                        }
                    }
                }

                public static class ExperiencedListBean {
                    /**
                     * nodeKey : Apply
                     * nodeName : 客户经理提交
                     * enabled : null
                     */

                    private String nodeKey;
                    private String nodeName;
                    private Object enabled;

                    public String getNodeKey() {
                        return nodeKey;
                    }

                    public void setNodeKey(String nodeKey) {
                        this.nodeKey = nodeKey;
                    }

                    public String getNodeName() {
                        return nodeName;
                    }

                    public void setNodeName(String nodeName) {
                        this.nodeName = nodeName;
                    }

                    public Object getEnabled() {
                        return enabled;
                    }

                    public void setEnabled(Object enabled) {
                        this.enabled = enabled;
                    }
                }

                public static class AllNodeListBean {
                    /**
                     * nodeKey : Apply
                     * nodeName : 客户经理提交
                     * enabled : null
                     */

                    private String nodeKey;
                    private String nodeName;
                    private Object enabled;

                    public String getNodeKey() {
                        return nodeKey;
                    }

                    public void setNodeKey(String nodeKey) {
                        this.nodeKey = nodeKey;
                    }

                    public String getNodeName() {
                        return nodeName;
                    }

                    public void setNodeName(String nodeName) {
                        this.nodeName = nodeName;
                    }

                    public Object getEnabled() {
                        return enabled;
                    }

                    public void setEnabled(Object enabled) {
                        this.enabled = enabled;
                    }
                }
            }
        }