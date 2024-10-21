package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@TableName("fasonglepu")
@Data
public class Fasonglepu {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
	
	@TableField(value = "lepubianhao")	private String lepubianhao;	@TableField(value = "lepumingcheng")	private String lepumingcheng;	@TableField(value = "lepuleibie")	private String lepuleibie;	@TableField(value = "chuangzuoren")	private String chuangzuoren;	@TableField(value = "goumairen")	private String goumairen;	@TableField(value = "lepuchuansong")	private String lepuchuansong;	
    
	
	
    @TableField(value = "addtime")
    private Date addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getLepubianhao() {
        return lepubianhao;
    }
    public void setLepubianhao(String lepubianhao) {
		this.lepubianhao = lepubianhao;
    }	public String getLepumingcheng() {
        return lepumingcheng;
    }
    public void setLepumingcheng(String lepumingcheng) {
		this.lepumingcheng = lepumingcheng;
    }	public String getLepuleibie() {
        return lepuleibie;
    }
    public void setLepuleibie(String lepuleibie) {
		this.lepuleibie = lepuleibie;
    }	public String getChuangzuoren() {
        return chuangzuoren;
    }
    public void setChuangzuoren(String chuangzuoren) {
		this.chuangzuoren = chuangzuoren;
    }	public String getGoumairen() {
        return goumairen;
    }
    public void setGoumairen(String goumairen) {
		this.goumairen = goumairen;
    }	public String getLepuchuansong() {
        return lepuchuansong;
    }
    public void setLepuchuansong(String lepuchuansong) {
		this.lepuchuansong = lepuchuansong;
    }	
	

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtme(Date addtime) {
        this.addtime = addtime;
    }
}