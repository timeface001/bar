package com.fs.bar.entity;
import java.io.Serializable;
public class BarComputer implements Serializable{
private static final long serialVersionUID = 1L;
private Long id;//
private String cpu;//
private String board;//主板
private String memory;//内存
private String disk;//
private String solidDisk;//
private String card;//显卡
private String power;//电源
private String chassis;//机箱
private String keyboard;//键盘
private String mouse;//鼠标
private Long barId;//网吧ID

public Long getId(){
return id;
}

public void setId(Long id) {
this.id = id;
}

public String getCpu(){
return cpu;
}

public void setCpu(String cpu) {
this.cpu = cpu;
}

public String getBoard(){
return board;
}

public void setBoard(String board) {
this.board = board;
}

public String getMemory(){
return memory;
}

public void setMemory(String memory) {
this.memory = memory;
}

public String getDisk(){
return disk;
}

public void setDisk(String disk) {
this.disk = disk;
}

public String getSolidDisk(){
return solidDisk;
}

public void setSolidDisk(String solidDisk) {
this.solidDisk = solidDisk;
}

public String getCard(){
return card;
}

public void setCard(String card) {
this.card = card;
}

public String getPower(){
return power;
}

public void setPower(String power) {
this.power = power;
}

public String getChassis(){
return chassis;
}

public void setChassis(String chassis) {
this.chassis = chassis;
}

public String getKeyboard(){
return keyboard;
}

public void setKeyboard(String keyboard) {
this.keyboard = keyboard;
}

public String getMouse(){
return mouse;
}

public void setMouse(String mouse) {
this.mouse = mouse;
}

public Long getBarId(){
return barId;
}

public void setBarId(Long barId) {
this.barId = barId;
}
}