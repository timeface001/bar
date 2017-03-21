package com.fs.bar.entity;

import java.io.Serializable;

public class BarLocation implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;//
    private Long barId;//
    private String province;//
    private Integer provinceInt;//
    private String city;//
    private Integer cityInt;//
    private String area;//
    private Integer areaInt;//

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBarId() {
        return barId;
    }

    public void setBarId(Long barId) {
        this.barId = barId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getProvinceInt() {
        return provinceInt;
    }

    public void setProvinceInt(Integer provinceInt) {
        this.provinceInt = provinceInt;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCityInt() {
        return cityInt;
    }

    public void setCityInt(Integer cityInt) {
        this.cityInt = cityInt;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getAreaInt() {
        return areaInt;
    }

    public void setAreaInt(Integer areaInt) {
        this.areaInt = areaInt;
    }
}