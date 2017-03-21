package com.fs.bar.entity;
import java.io.Serializable;
import java.util.Date;
public class BarPrice implements Serializable{
private static final long serialVersionUID = 1L;
private Long id;//
private Long barId;//
private Integer type;//类型 0普通上网 1VIP上网
private String price;//每小时上网费用 

public Long getId(){
return id;
}

public void setId(Long id) {
this.id = id;
}

public Long getBarId(){
return barId;
}

public void setBarId(Long barId) {
this.barId = barId;
}

public Integer getType(){
return type;
}

public void setType(Integer type) {
this.type = type;
}

public String getPrice(){
return price;
}

public void setPrice(String price) {
this.price = price;
}
}