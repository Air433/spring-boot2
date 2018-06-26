package com.renjie.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户详情表
 * </p>
 *
 * @author oyg
 * @since 2018-06-26
 */
@TableName("ucenter_user_details")
public class UcenterUserDetails extends Model<UcenterUserDetails> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId("user_id")
    private Integer userId;
    /**
     * 个性签名
     */
    private String signature;
    /**
     * 真实姓名
     */
    @TableField("real_name")
    private String realName;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 帐号安全问题
     */
    private String question;
    /**
     * 帐号安全答案
     */
    private String answer;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "UcenterUserDetails{" +
        "userId=" + userId +
        ", signature=" + signature +
        ", realName=" + realName +
        ", birthday=" + birthday +
        ", question=" + question +
        ", answer=" + answer +
        "}";
    }
}
