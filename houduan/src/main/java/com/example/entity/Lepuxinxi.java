package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@TableName("lepuxinxi")
@Data
public class Lepuxinxi {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
	
	@TableField(value = "lepubianhao")	private String lepubianhao;	@TableField(value = "lepumingcheng")	private String lepumingcheng;	@TableField(value = "lepufenlei")	private String lepufenlei;	@TableField(value = "leqi")	private String leqi;	@TableField(value = "lepujieshao")	private String lepujieshao;	@TableField(value = "jiage")	private String jiage;	@TableField(value = "leputu")	private String leputu;	@TableField(value = "chuangzuoren")	private String chuangzuoren;	
    
	
	
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
    }	public String getLepufenlei() {
        return lepufenlei;
    }
    public void setLepufenlei(String lepufenlei) {
		this.lepufenlei = lepufenlei;
    }	public String getLeqi() {
        return leqi;
    }
    public void setLeqi(String leqi) {
		this.leqi = leqi;
    }	public String getLepujieshao() {
        return lepujieshao;
    }
    public void setLepujieshao(String lepujieshao) {
		this.lepujieshao = lepujieshao;
    }	public String getJiage() {
        return jiage;
    }
    public void setJiage(String jiage) {
		this.jiage = jiage;
    }	public String getLeputu() {
        return leputu;
    }
    public void setLeputu(String leputu) {
		this.leputu = leputu;
    }	public String getChuangzuoren() {
        return chuangzuoren;
    }
    public void setChuangzuoren(String chuangzuoren) {
		this.chuangzuoren = chuangzuoren;
    }	
	

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtme(Date addtime) {
        this.addtime = addtime;
    }
}