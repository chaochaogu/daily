package com.chaochaogu.model;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"createdAt", "updatedAt"})
public class GroupMember implements Serializable {

    private Integer id;
    /**
     * 队员名称
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 员工编号
     */
    private String yyEmployeeId;
    /**
     * 咕咚会员编号
     */
    private String gdMemberId;
    /**
     * YYSPORT会员编号
     */
    private String yyMemberId;
    /**
     * 渠道Id
     */
    private String channelId;
    /**
     * 血型
     */
    private String bloodType;
    /**
     * 职等
     */
    private Integer level;
    /**
     * 入职日期
     */
    private String hiredate;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 1.5倍奖励
     */
    private Double promoteValue;
    /**
     * 邀请码
     */
    private String registCode;
    /**
     * 所属队的ID
     */
    private Integer groupId;
    /**
     * 是否是队长
     */
    private Integer isLeader;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 更新时间
     */
    private Date updatedAt;
    /**
     * 是否删除
     */
    private Integer deleted;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getYyEmployeeId() {
        return yyEmployeeId;
    }

    public void setYyEmployeeId(String yyEmployeeId) {
        this.yyEmployeeId = yyEmployeeId == null ? null : yyEmployeeId.trim();
    }

    public String getGdMemberId() {
        return gdMemberId;
    }

    public void setGdMemberId(String gdMemberId) {
        this.gdMemberId = gdMemberId == null ? null : gdMemberId.trim();
    }

    public String getYyMemberId() {
        return yyMemberId;
    }

    public void setYyMemberId(String yyMemberId) {
        this.yyMemberId = yyMemberId == null ? null : yyMemberId.trim();
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId == null ? null : channelId.trim();
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType == null ? null : bloodType.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate == null ? null : hiredate.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getPromoteValue() {
        return promoteValue;
    }

    public void setPromoteValue(Double promoteValue) {
        this.promoteValue = promoteValue;
    }

    public String getRegistCode() {
        return registCode;
    }

    public void setRegistCode(String registCode) {
        this.registCode = registCode == null ? null : registCode.trim();
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(Integer isLeader) {
        this.isLeader = isLeader;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}