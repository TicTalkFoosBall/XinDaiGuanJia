package hxz.www.commonbase.model.client;

import android.support.annotation.NonNull;

import hxz.www.commonbase.util.GsonUtil;

public class ClientDetail {

    private long id;
    private String name;
    private String idPhotoFront;
    private String idPhotoBack;
    private String idCard;
    private String gender;
    private String marriageStatus;
    private String source;
    private String manager;
    private String createdFullName;
    private String address;
    public void setId(long id) {
         this.id = id;
     }
     public long getId() {
         return id;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setIdPhotoFront(String idPhotoFront) {
         this.idPhotoFront = idPhotoFront;
     }
     public String getIdPhotoFront() {
         return idPhotoFront;
     }

    public void setIdPhotoBack(String idPhotoBack) {
         this.idPhotoBack = idPhotoBack;
     }
     public String getIdPhotoBack() {
         return idPhotoBack;
     }

    public void setIdCard(String idCard) {
         this.idCard = idCard;
     }
     public String getIdCard() {
         return idCard;
     }

    public void setGender(String gender) {
         this.gender = gender;
     }
     public String getGender() {
         return gender;
     }

    public void setMarriageStatus(String marriageStatus) {
         this.marriageStatus = marriageStatus;
     }
     public String getMarriageStatus() {
         return marriageStatus;
     }

    public void setSource(String source) {
         this.source = source;
     }
     public String getSource() {
         return source;
     }

    public void setManager(String manager) {
         this.manager = manager;
     }
     public String getManager() {
         return manager;
     }

    public void setCreatedFullName(String createdFullName) {
         this.createdFullName = createdFullName;
     }
     public String getCreatedFullName() {
         return createdFullName;
     }

    public void setAddress(String address) {
         this.address = address;
     }
     public String getAddress() {
         return address;
     }

    @NonNull
    @Override
    public String toString() {
        return GsonUtil.toJson(this);
    }
}