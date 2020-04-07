package com.uh.urbanhouser;

public class ModelSearchpost {

    String uid,uemail,uname,udp,pid,ptime,phone,address,pincode,pimage,city,price,date,bhkconfig,locality,day,month,year,furnishstatus;

    public ModelSearchpost() {

    }

    public ModelSearchpost(String uid, String uemail, String uname, String udp, String pid, String ptime, String phone, String address, String pincode, String pimage, String city, String price, String date,String bhkconfig,String locality,String day,String month,String year,String furnishstatus) {
        this.uid = uid;
        this.uemail = uemail;
        this.uname = uname;
        this.udp = udp;
        this.pid = pid;
        this.ptime = ptime;
        this.phone = phone;
        this.address = address;
        this.pincode = pincode;
        this.pimage = pimage;
        this.city = city;
        this.price = price;
        this.date = date;
        this.bhkconfig = bhkconfig;
        this.locality = locality;
        this.day=day;
        this.month=month;
        this.year=year;
        this.furnishstatus=furnishstatus;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUdp() {
        return udp;
    }

    public void setUdp(String udp) {
        this.udp = udp;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBhkconfig() {
        return bhkconfig;
    }

    public void setBhkconfig(String bhkconfig) {
        this.bhkconfig = bhkconfig;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getFurnishstatus() {
        return furnishstatus;
    }

    public void setFurnishstatus(String furnishstatus) {
        this.furnishstatus = furnishstatus;
    }


}