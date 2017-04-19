package com.fs.bar.exchange.request;/**
 * Created by fengsong on 2017/4/13.
 */

import com.fs.bar.entity.Bar;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * @author fengsong
 * @description:一句话描述下类的功能
 * @time 2017-04-13 13:56
 **/

public class BarSaveRequest {
    @NotEmpty
    private String name;//网吧名称
    private String area;//区域
    @NotEmpty
    private String addDetail;//地址详情
    @NotNull
    private Integer type;//网吧类型
    @NotNull
    private String phone;
    private Integer capacity;//网吧容量
    private String images;//图片
    private String description;//网吧简介


    private String com_cpu;
    private String com_board;
    private String com_memory;
    private String com_card;
    private String com_chassis;
    private String com_keyboard;
    private String com_mouse;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddDetail() {
        return addDetail;
    }

    public void setAddDetail(String addDetail) {
        this.addDetail = addDetail;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getCom_cpu() {
        return com_cpu;
    }

    public void setCom_cpu(String com_cpu) {
        this.com_cpu = com_cpu;
    }

    public String getCom_board() {
        return com_board;
    }

    public void setCom_board(String com_board) {
        this.com_board = com_board;
    }

    public String getCom_memory() {
        return com_memory;
    }

    public void setCom_memory(String com_memory) {
        this.com_memory = com_memory;
    }

    public String getCom_card() {
        return com_card;
    }

    public void setCom_card(String com_card) {
        this.com_card = com_card;
    }

    public String getCom_chassis() {
        return com_chassis;
    }

    public void setCom_chassis(String com_chassis) {
        this.com_chassis = com_chassis;
    }

    public String getCom_keyboard() {
        return com_keyboard;
    }

    public void setCom_keyboard(String com_keyboard) {
        this.com_keyboard = com_keyboard;
    }

    public String getCom_mouse() {
        return com_mouse;
    }

    public void setCom_mouse(String com_mouse) {
        this.com_mouse = com_mouse;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bar generateBar() {
        Bar bar = new Bar();

        bar.setName(this.name);
        bar.setAddress("安徽省合肥市" + this.area + " " + this.addDetail);
        bar.setCapacity(this.capacity);
        bar.setComments(0);
        bar.setDescription(this.description);

        return bar;
    }


    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
    }
}
