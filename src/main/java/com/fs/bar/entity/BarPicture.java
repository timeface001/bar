package com.fs.bar.entity;
import java.io.Serializable;
import java.util.Date;
public class BarPicture implements Serializable{
private static final long serialVersionUID = 1L;
private Long id;//
private Integer type;//图片类型 0普通图片 1主图
private String url;//图片路径
private Date createTime;//创建时间
private Long barId;//网吧ID

public Long getId(){
return id;
}

public void setId(Long id) {
this.id = id;
}

public Integer getType(){
return type;
}

public void setType(Integer type) {
this.type = type;
}

public String getUrl(){
return url;
}

public void setUrl(String url) {
this.url = url;
}

public Date getCreateTime(){
return createTime;
}

public void setCreateTime(Date createTime) {
this.createTime = createTime;
}

public Long getBarId(){
return barId;
}

public void setBarId(Long barId) {
this.barId = barId;
}
}