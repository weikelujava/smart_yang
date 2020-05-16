package com.smart.canal.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: BlcCategory
 * @description: 公园
 * @author: lukewei
 * @date: 2020/4/29 10:45
 * @remark: 修改字段类型 公园名称搜索，定义公园名称类型为Text
 *
 */
@Document(indexName = "blc_category", type = "docs", shards = 5, replicas = 1)
public class BlcCategory implements Serializable {

    private static final long serialVersionUID = -3151422205936432777L;

    @Id
    private Long id;

    @Field(type = FieldType.Date)
    private Date activeEndDate;

    @Field(type = FieldType.Date)
    private Date activeStartDate;

    @Field(type = FieldType.Keyword)
    private String archived;

    @Field(type = FieldType.Keyword)
    private String businesshours;

    @Field(type = FieldType.Keyword)
    private String description;

    @Field(type = FieldType.Keyword)
    private String displayTemplate;

    @Field(type = FieldType.Keyword)
    private String externalId;

    @Field(type = FieldType.Keyword)
    private String fulfillmentType;

    @Field(type = FieldType.Keyword)
    private String inventoryType;

    @Field(type = FieldType.Keyword)
    private String longDescription;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Integer)
    private Integer overrideGeneratedUrl;

    @Field(type = FieldType.Keyword)
    private String taxCode;

    @Field(type = FieldType.Keyword)
    private String traffic;

    @Field(type = FieldType.Keyword)
    private String url;

    @Field(type = FieldType.Keyword)
    private String urlKey;

    @Field(type = FieldType.Keyword)
    private String notice;

    @Field(type = FieldType.Keyword)
    private String optimumseason;

    @Field(type = FieldType.Keyword)
    private String tag;

    @Field(type = FieldType.Long)
    private Long defaultParentCategoryId;

    @Field(type = FieldType.Keyword)
    private String touristPolicy;

    @Field(type = FieldType.Keyword)
    private String travellingTips;

    @Field(type = FieldType.Long)
    private Integer priority;

    @Field(type = FieldType.Integer)
    private Integer displayOrder;

    @Field(type = FieldType.Keyword)
    private String logoUrl;

    @Field(type = FieldType.Integer)
    private Integer receiptDelayDay;

    @Field(type = FieldType.Keyword)
    private String receiptTips;

    @Field(type = FieldType.Boolean)
    private Boolean isSelling;

    @Field(type = FieldType.Date)
    private Date modifiedTime;

    @Field(type = FieldType.Integer)
    private Integer version;

    public BlcCategory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getActiveEndDate() {
        return activeEndDate;
    }

    public void setActiveEndDate(Date activeEndDate) {
        this.activeEndDate = activeEndDate;
    }

    public Date getActiveStartDate() {
        return activeStartDate;
    }

    public void setActiveStartDate(Date activeStartDate) {
        this.activeStartDate = activeStartDate;
    }

    public String getArchived() {
        return archived;
    }

    public void setArchived(String archived) {
        this.archived = archived;
    }

    public String getBusinesshours() {
        return businesshours;
    }

    public void setBusinesshours(String businesshours) {
        this.businesshours = businesshours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayTemplate() {
        return displayTemplate;
    }

    public void setDisplayTemplate(String displayTemplate) {
        this.displayTemplate = displayTemplate;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getFulfillmentType() {
        return fulfillmentType;
    }

    public void setFulfillmentType(String fulfillmentType) {
        this.fulfillmentType = fulfillmentType;
    }

    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOverrideGeneratedUrl() {
        return overrideGeneratedUrl;
    }

    public void setOverrideGeneratedUrl(Integer overrideGeneratedUrl) {
        this.overrideGeneratedUrl = overrideGeneratedUrl;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlKey() {
        return urlKey;
    }

    public void setUrlKey(String urlKey) {
        this.urlKey = urlKey;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getOptimumseason() {
        return optimumseason;
    }

    public void setOptimumseason(String optimumseason) {
        this.optimumseason = optimumseason;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Long getDefaultParentCategoryId() {
        return defaultParentCategoryId;
    }

    public void setDefaultParentCategoryId(Long defaultParentCategoryId) {
        this.defaultParentCategoryId = defaultParentCategoryId;
    }

    public String getTouristPolicy() {
        return touristPolicy;
    }

    public void setTouristPolicy(String touristPolicy) {
        this.touristPolicy = touristPolicy;
    }

    public String getTravellingTips() {
        return travellingTips;
    }

    public void setTravellingTips(String travellingTips) {
        this.travellingTips = travellingTips;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Integer getReceiptDelayDay() {
        return receiptDelayDay;
    }

    public void setReceiptDelayDay(Integer receiptDelayDay) {
        this.receiptDelayDay = receiptDelayDay;
    }

    public String getReceiptTips() {
        return receiptTips;
    }

    public void setReceiptTips(String receiptTips) {
        this.receiptTips = receiptTips;
    }

    public Boolean getSelling() {
        return isSelling;
    }

    public void setSelling(Boolean selling) {
        isSelling = selling;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
