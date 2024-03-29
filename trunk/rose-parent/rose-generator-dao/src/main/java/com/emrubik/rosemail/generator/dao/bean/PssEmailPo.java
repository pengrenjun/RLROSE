package com.emrubik.rosemail.generator.dao.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table UEC_PSS_EMAIL
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class PssEmailPo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UEC_PSS_EMAIL.MOID
     *
     * @mbggenerated
     */
    private BigDecimal moid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UEC_PSS_EMAIL.MAILTO
     *
     * @mbggenerated
     */
    private String mailto;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UEC_PSS_EMAIL.MTITLE
     *
     * @mbggenerated
     */
    private String mtitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UEC_PSS_EMAIL.MTEXT
     *
     * @mbggenerated
     */
    private String mtext;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UEC_PSS_EMAIL.STARTTIME
     *
     * @mbggenerated
     */
    private String starttime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UEC_PSS_EMAIL.ENDTIME
     *
     * @mbggenerated
     */
    private String endtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UEC_PSS_EMAIL.SENDFLAG
     *
     * @mbggenerated
     */
    private BigDecimal sendflag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UEC_PSS_EMAIL.STRAPPDEF1
     *
     * @mbggenerated
     */
    private String strappdef1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UEC_PSS_EMAIL.STRAPPDEF2
     *
     * @mbggenerated
     */
    private String strappdef2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UEC_PSS_EMAIL.CREATIONTIME
     *
     * @mbggenerated
     */
    private Date creationtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UEC_PSS_EMAIL.MOID
     *
     * @return the value of UEC_PSS_EMAIL.MOID
     *
     * @mbggenerated
     */
    public BigDecimal getMoid() {
        return moid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UEC_PSS_EMAIL.MOID
     *
     * @param moid the value for UEC_PSS_EMAIL.MOID
     *
     * @mbggenerated
     */
    public void setMoid(BigDecimal moid) {
        this.moid = moid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UEC_PSS_EMAIL.MAILTO
     *
     * @return the value of UEC_PSS_EMAIL.MAILTO
     *
     * @mbggenerated
     */
    public String getMailto() {
        return mailto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UEC_PSS_EMAIL.MAILTO
     *
     * @param mailto the value for UEC_PSS_EMAIL.MAILTO
     *
     * @mbggenerated
     */
    public void setMailto(String mailto) {
        this.mailto = mailto == null ? null : mailto.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UEC_PSS_EMAIL.MTITLE
     *
     * @return the value of UEC_PSS_EMAIL.MTITLE
     *
     * @mbggenerated
     */
    public String getMtitle() {
        return mtitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UEC_PSS_EMAIL.MTITLE
     *
     * @param mtitle the value for UEC_PSS_EMAIL.MTITLE
     *
     * @mbggenerated
     */
    public void setMtitle(String mtitle) {
        this.mtitle = mtitle == null ? null : mtitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UEC_PSS_EMAIL.MTEXT
     *
     * @return the value of UEC_PSS_EMAIL.MTEXT
     *
     * @mbggenerated
     */
    public String getMtext() {
        return mtext;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UEC_PSS_EMAIL.MTEXT
     *
     * @param mtext the value for UEC_PSS_EMAIL.MTEXT
     *
     * @mbggenerated
     */
    public void setMtext(String mtext) {
        this.mtext = mtext == null ? null : mtext.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UEC_PSS_EMAIL.STARTTIME
     *
     * @return the value of UEC_PSS_EMAIL.STARTTIME
     *
     * @mbggenerated
     */
    public String getStarttime() {
        return starttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UEC_PSS_EMAIL.STARTTIME
     *
     * @param starttime the value for UEC_PSS_EMAIL.STARTTIME
     *
     * @mbggenerated
     */
    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UEC_PSS_EMAIL.ENDTIME
     *
     * @return the value of UEC_PSS_EMAIL.ENDTIME
     *
     * @mbggenerated
     */
    public String getEndtime() {
        return endtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UEC_PSS_EMAIL.ENDTIME
     *
     * @param endtime the value for UEC_PSS_EMAIL.ENDTIME
     *
     * @mbggenerated
     */
    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UEC_PSS_EMAIL.SENDFLAG
     *
     * @return the value of UEC_PSS_EMAIL.SENDFLAG
     *
     * @mbggenerated
     */
    public BigDecimal getSendflag() {
        return sendflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UEC_PSS_EMAIL.SENDFLAG
     *
     * @param sendflag the value for UEC_PSS_EMAIL.SENDFLAG
     *
     * @mbggenerated
     */
    public void setSendflag(BigDecimal sendflag) {
        this.sendflag = sendflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UEC_PSS_EMAIL.STRAPPDEF1
     *
     * @return the value of UEC_PSS_EMAIL.STRAPPDEF1
     *
     * @mbggenerated
     */
    public String getStrappdef1() {
        return strappdef1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UEC_PSS_EMAIL.STRAPPDEF1
     *
     * @param strappdef1 the value for UEC_PSS_EMAIL.STRAPPDEF1
     *
     * @mbggenerated
     */
    public void setStrappdef1(String strappdef1) {
        this.strappdef1 = strappdef1 == null ? null : strappdef1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UEC_PSS_EMAIL.STRAPPDEF2
     *
     * @return the value of UEC_PSS_EMAIL.STRAPPDEF2
     *
     * @mbggenerated
     */
    public String getStrappdef2() {
        return strappdef2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UEC_PSS_EMAIL.STRAPPDEF2
     *
     * @param strappdef2 the value for UEC_PSS_EMAIL.STRAPPDEF2
     *
     * @mbggenerated
     */
    public void setStrappdef2(String strappdef2) {
        this.strappdef2 = strappdef2 == null ? null : strappdef2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UEC_PSS_EMAIL.CREATIONTIME
     *
     * @return the value of UEC_PSS_EMAIL.CREATIONTIME
     *
     * @mbggenerated
     */
    public Date getCreationtime() {
        return creationtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UEC_PSS_EMAIL.CREATIONTIME
     *
     * @param creationtime the value for UEC_PSS_EMAIL.CREATIONTIME
     *
     * @mbggenerated
     */
    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }
}