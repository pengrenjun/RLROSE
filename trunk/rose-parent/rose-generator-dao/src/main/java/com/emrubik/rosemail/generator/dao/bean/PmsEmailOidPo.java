package com.emrubik.rosemail.generator.dao.bean;

import java.math.BigDecimal;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table UEC_PMS_EMAIL_OID
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class PmsEmailOidPo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UEC_PMS_EMAIL_OID.ID
     *
     * @mbggenerated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UEC_PMS_EMAIL_OID.PROCESS_INSTANCE_ID
     *
     * @mbggenerated
     */
    private String processInstanceId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column UEC_PMS_EMAIL_OID.OID
     *
     * @mbggenerated
     */
    private BigDecimal oid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UEC_PMS_EMAIL_OID.ID
     *
     * @return the value of UEC_PMS_EMAIL_OID.ID
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UEC_PMS_EMAIL_OID.ID
     *
     * @param id the value for UEC_PMS_EMAIL_OID.ID
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UEC_PMS_EMAIL_OID.PROCESS_INSTANCE_ID
     *
     * @return the value of UEC_PMS_EMAIL_OID.PROCESS_INSTANCE_ID
     *
     * @mbggenerated
     */
    public String getProcessInstanceId() {
        return processInstanceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UEC_PMS_EMAIL_OID.PROCESS_INSTANCE_ID
     *
     * @param processInstanceId the value for UEC_PMS_EMAIL_OID.PROCESS_INSTANCE_ID
     *
     * @mbggenerated
     */
    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId == null ? null : processInstanceId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column UEC_PMS_EMAIL_OID.OID
     *
     * @return the value of UEC_PMS_EMAIL_OID.OID
     *
     * @mbggenerated
     */
    public BigDecimal getOid() {
        return oid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column UEC_PMS_EMAIL_OID.OID
     *
     * @param oid the value for UEC_PMS_EMAIL_OID.OID
     *
     * @mbggenerated
     */
    public void setOid(BigDecimal oid) {
        this.oid = oid;
    }
}