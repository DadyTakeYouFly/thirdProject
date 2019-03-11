package com.gameloft9.demo.dataaccess.model.system;

public class Supplier {
    private String id;
    private String supplierName;
    private String supplierDescribe;
    private String phone;

    @Override
    public String toString() {
        return "Supplier{" +
                "id='" + id + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", supplierDescribe='" + supplierDescribe + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierDescribe() {
        return supplierDescribe;
    }

    public void setSupplierDescribe(String supplierDescribe) {
        this.supplierDescribe = supplierDescribe;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Supplier(String id, String supplierName, String supplierDescribe, String phone) {
        this.id = id;
        this.supplierName = supplierName;
        this.supplierDescribe = supplierDescribe;
        this.phone = phone;
    }

    public Supplier() {
    }
}
