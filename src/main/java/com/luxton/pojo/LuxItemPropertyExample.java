package com.luxton.pojo;

import java.util.ArrayList;
import java.util.List;

public class LuxItemPropertyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LuxItemPropertyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIpropertyIdIsNull() {
            addCriterion("iproperty_id is null");
            return (Criteria) this;
        }

        public Criteria andIpropertyIdIsNotNull() {
            addCriterion("iproperty_id is not null");
            return (Criteria) this;
        }

        public Criteria andIpropertyIdEqualTo(Integer value) {
            addCriterion("iproperty_id =", value, "ipropertyId");
            return (Criteria) this;
        }

        public Criteria andIpropertyIdNotEqualTo(Integer value) {
            addCriterion("iproperty_id <>", value, "ipropertyId");
            return (Criteria) this;
        }

        public Criteria andIpropertyIdGreaterThan(Integer value) {
            addCriterion("iproperty_id >", value, "ipropertyId");
            return (Criteria) this;
        }

        public Criteria andIpropertyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("iproperty_id >=", value, "ipropertyId");
            return (Criteria) this;
        }

        public Criteria andIpropertyIdLessThan(Integer value) {
            addCriterion("iproperty_id <", value, "ipropertyId");
            return (Criteria) this;
        }

        public Criteria andIpropertyIdLessThanOrEqualTo(Integer value) {
            addCriterion("iproperty_id <=", value, "ipropertyId");
            return (Criteria) this;
        }

        public Criteria andIpropertyIdIn(List<Integer> values) {
            addCriterion("iproperty_id in", values, "ipropertyId");
            return (Criteria) this;
        }

        public Criteria andIpropertyIdNotIn(List<Integer> values) {
            addCriterion("iproperty_id not in", values, "ipropertyId");
            return (Criteria) this;
        }

        public Criteria andIpropertyIdBetween(Integer value1, Integer value2) {
            addCriterion("iproperty_id between", value1, value2, "ipropertyId");
            return (Criteria) this;
        }

        public Criteria andIpropertyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("iproperty_id not between", value1, value2, "ipropertyId");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Integer value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Integer value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Integer value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Integer value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Integer> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Integer> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Integer value1, Integer value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andPropertyIdIsNull() {
            addCriterion("property_id is null");
            return (Criteria) this;
        }

        public Criteria andPropertyIdIsNotNull() {
            addCriterion("property_id is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyIdEqualTo(Integer value) {
            addCriterion("property_id =", value, "propertyId");
            return (Criteria) this;
        }

        public Criteria andPropertyIdNotEqualTo(Integer value) {
            addCriterion("property_id <>", value, "propertyId");
            return (Criteria) this;
        }

        public Criteria andPropertyIdGreaterThan(Integer value) {
            addCriterion("property_id >", value, "propertyId");
            return (Criteria) this;
        }

        public Criteria andPropertyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("property_id >=", value, "propertyId");
            return (Criteria) this;
        }

        public Criteria andPropertyIdLessThan(Integer value) {
            addCriterion("property_id <", value, "propertyId");
            return (Criteria) this;
        }

        public Criteria andPropertyIdLessThanOrEqualTo(Integer value) {
            addCriterion("property_id <=", value, "propertyId");
            return (Criteria) this;
        }

        public Criteria andPropertyIdIn(List<Integer> values) {
            addCriterion("property_id in", values, "propertyId");
            return (Criteria) this;
        }

        public Criteria andPropertyIdNotIn(List<Integer> values) {
            addCriterion("property_id not in", values, "propertyId");
            return (Criteria) this;
        }

        public Criteria andPropertyIdBetween(Integer value1, Integer value2) {
            addCriterion("property_id between", value1, value2, "propertyId");
            return (Criteria) this;
        }

        public Criteria andPropertyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("property_id not between", value1, value2, "propertyId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdIsNull() {
            addCriterion("property_value_id is null");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdIsNotNull() {
            addCriterion("property_value_id is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdEqualTo(Integer value) {
            addCriterion("property_value_id =", value, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdNotEqualTo(Integer value) {
            addCriterion("property_value_id <>", value, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdGreaterThan(Integer value) {
            addCriterion("property_value_id >", value, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("property_value_id >=", value, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdLessThan(Integer value) {
            addCriterion("property_value_id <", value, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdLessThanOrEqualTo(Integer value) {
            addCriterion("property_value_id <=", value, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdIn(List<Integer> values) {
            addCriterion("property_value_id in", values, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdNotIn(List<Integer> values) {
            addCriterion("property_value_id not in", values, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdBetween(Integer value1, Integer value2) {
            addCriterion("property_value_id between", value1, value2, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andPropertyValueIdNotBetween(Integer value1, Integer value2) {
            addCriterion("property_value_id not between", value1, value2, "propertyValueId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNull() {
            addCriterion("sku_id is null");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNotNull() {
            addCriterion("sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkuIdEqualTo(Integer value) {
            addCriterion("sku_id =", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotEqualTo(Integer value) {
            addCriterion("sku_id <>", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThan(Integer value) {
            addCriterion("sku_id >", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sku_id >=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThan(Integer value) {
            addCriterion("sku_id <", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThanOrEqualTo(Integer value) {
            addCriterion("sku_id <=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIn(List<Integer> values) {
            addCriterion("sku_id in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotIn(List<Integer> values) {
            addCriterion("sku_id not in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdBetween(Integer value1, Integer value2) {
            addCriterion("sku_id between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sku_id not between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andIsSkuIsNull() {
            addCriterion("is_sku is null");
            return (Criteria) this;
        }

        public Criteria andIsSkuIsNotNull() {
            addCriterion("is_sku is not null");
            return (Criteria) this;
        }

        public Criteria andIsSkuEqualTo(Boolean value) {
            addCriterion("is_sku =", value, "isSku");
            return (Criteria) this;
        }

        public Criteria andIsSkuNotEqualTo(Boolean value) {
            addCriterion("is_sku <>", value, "isSku");
            return (Criteria) this;
        }

        public Criteria andIsSkuGreaterThan(Boolean value) {
            addCriterion("is_sku >", value, "isSku");
            return (Criteria) this;
        }

        public Criteria andIsSkuGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_sku >=", value, "isSku");
            return (Criteria) this;
        }

        public Criteria andIsSkuLessThan(Boolean value) {
            addCriterion("is_sku <", value, "isSku");
            return (Criteria) this;
        }

        public Criteria andIsSkuLessThanOrEqualTo(Boolean value) {
            addCriterion("is_sku <=", value, "isSku");
            return (Criteria) this;
        }

        public Criteria andIsSkuIn(List<Boolean> values) {
            addCriterion("is_sku in", values, "isSku");
            return (Criteria) this;
        }

        public Criteria andIsSkuNotIn(List<Boolean> values) {
            addCriterion("is_sku not in", values, "isSku");
            return (Criteria) this;
        }

        public Criteria andIsSkuBetween(Boolean value1, Boolean value2) {
            addCriterion("is_sku between", value1, value2, "isSku");
            return (Criteria) this;
        }

        public Criteria andIsSkuNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_sku not between", value1, value2, "isSku");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}