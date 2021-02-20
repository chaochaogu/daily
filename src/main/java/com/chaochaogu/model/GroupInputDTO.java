package com.chaochaogu.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chaochao Gu
 * @date 2019/7/16
 */
@Data
public class GroupInputDTO implements Serializable {

    private Integer id;
    /**
     * 队伍名称
     */
    private String groupName;
    /**
     * 渠道Id
     */
    private String channelId;
    /**
     * 队长YYsport会员编号
     */
    private String leader;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 区部
     */
    private String area;
    /**
     * 渠道类型
     */
    private Integer channelType;
    /**
     * 队伍成员
     */
    private GroupMember groupMember;

    public GroupInputDTO() {
    }

    public Integer getChannelType() {
        return channelType;
    }

    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public GroupMember getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(GroupMember groupMember) {
        this.groupMember = groupMember;
    }
}
