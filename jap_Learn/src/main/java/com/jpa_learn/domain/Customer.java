package com.jpa_learn.domain;

import javax.persistence.*;

/*客户的买体类
        配置映射关系
        1.实体类和表的映射关系
        * @Entity:声明实体类
        2其体类中属性和表中字段的映射关系
        : @Tablg :配置实体类和表的映射关系
        */
@Entity
@Table(name = "cst_customer")


public class Customer {
    /* @Id:声明主键的配置

        @GeneratedValue :配置主键的生成策略

        GenerationType. IDENTITY :自增
        @Column:配置 属性和字段的映射关系
        name:数据库表中字段的名称
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId; //客户的主键
    @Column(name = "cust_name")
    private String custName;//客户名称
    @Column(name = "cust_source")
    private String custSource;//客户来源
    @Column(name = "cust_level")
    private String custLevel;//客 户级别
    @Column(name = "cust_industry")
    private String custIndustry;//客户 所属行业
    @Column(name = "cust_phone")
    private String custPhone;//客户的联系方式
    @Column(name = "cust_address")

    private String custAddress;//客户地址


    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custAddress='" + custAddress + '\'' +
                '}';
    }
}
