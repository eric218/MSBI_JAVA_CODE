package com.hpe.msbireport.domain;

import java.util.ArrayList;
import java.util.List;

public class TotalSummaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TotalSummaryExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMonthIndicatorIsNull() {
            addCriterion("month_indicator is null");
            return (Criteria) this;
        }

        public Criteria andMonthIndicatorIsNotNull() {
            addCriterion("month_indicator is not null");
            return (Criteria) this;
        }

        public Criteria andMonthIndicatorEqualTo(Integer value) {
            addCriterion("month_indicator =", value, "monthIndicator");
            return (Criteria) this;
        }

        public Criteria andMonthIndicatorNotEqualTo(Integer value) {
            addCriterion("month_indicator <>", value, "monthIndicator");
            return (Criteria) this;
        }

        public Criteria andMonthIndicatorGreaterThan(Integer value) {
            addCriterion("month_indicator >", value, "monthIndicator");
            return (Criteria) this;
        }

        public Criteria andMonthIndicatorGreaterThanOrEqualTo(Integer value) {
            addCriterion("month_indicator >=", value, "monthIndicator");
            return (Criteria) this;
        }

        public Criteria andMonthIndicatorLessThan(Integer value) {
            addCriterion("month_indicator <", value, "monthIndicator");
            return (Criteria) this;
        }

        public Criteria andMonthIndicatorLessThanOrEqualTo(Integer value) {
            addCriterion("month_indicator <=", value, "monthIndicator");
            return (Criteria) this;
        }

        public Criteria andMonthIndicatorIn(List<Integer> values) {
            addCriterion("month_indicator in", values, "monthIndicator");
            return (Criteria) this;
        }

        public Criteria andMonthIndicatorNotIn(List<Integer> values) {
            addCriterion("month_indicator not in", values, "monthIndicator");
            return (Criteria) this;
        }

        public Criteria andMonthIndicatorBetween(Integer value1, Integer value2) {
            addCriterion("month_indicator between", value1, value2, "monthIndicator");
            return (Criteria) this;
        }

        public Criteria andMonthIndicatorNotBetween(Integer value1, Integer value2) {
            addCriterion("month_indicator not between", value1, value2, "monthIndicator");
            return (Criteria) this;
        }

        public Criteria andTotalNameIsNull() {
            addCriterion("total_name is null");
            return (Criteria) this;
        }

        public Criteria andTotalNameIsNotNull() {
            addCriterion("total_name is not null");
            return (Criteria) this;
        }

        public Criteria andTotalNameEqualTo(Integer value) {
            addCriterion("total_name =", value, "totalName");
            return (Criteria) this;
        }

        public Criteria andTotalNameNotEqualTo(Integer value) {
            addCriterion("total_name <>", value, "totalName");
            return (Criteria) this;
        }

        public Criteria andTotalNameGreaterThan(Integer value) {
            addCriterion("total_name >", value, "totalName");
            return (Criteria) this;
        }

        public Criteria andTotalNameGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_name >=", value, "totalName");
            return (Criteria) this;
        }

        public Criteria andTotalNameLessThan(Integer value) {
            addCriterion("total_name <", value, "totalName");
            return (Criteria) this;
        }

        public Criteria andTotalNameLessThanOrEqualTo(Integer value) {
            addCriterion("total_name <=", value, "totalName");
            return (Criteria) this;
        }

        public Criteria andTotalNameIn(List<Integer> values) {
            addCriterion("total_name in", values, "totalName");
            return (Criteria) this;
        }

        public Criteria andTotalNameNotIn(List<Integer> values) {
            addCriterion("total_name not in", values, "totalName");
            return (Criteria) this;
        }

        public Criteria andTotalNameBetween(Integer value1, Integer value2) {
            addCriterion("total_name between", value1, value2, "totalName");
            return (Criteria) this;
        }

        public Criteria andTotalNameNotBetween(Integer value1, Integer value2) {
            addCriterion("total_name not between", value1, value2, "totalName");
            return (Criteria) this;
        }

        public Criteria andDay01IsNull() {
            addCriterion("day_01 is null");
            return (Criteria) this;
        }

        public Criteria andDay01IsNotNull() {
            addCriterion("day_01 is not null");
            return (Criteria) this;
        }

        public Criteria andDay01EqualTo(Integer value) {
            addCriterion("day_01 =", value, "day01");
            return (Criteria) this;
        }

        public Criteria andDay01NotEqualTo(Integer value) {
            addCriterion("day_01 <>", value, "day01");
            return (Criteria) this;
        }

        public Criteria andDay01GreaterThan(Integer value) {
            addCriterion("day_01 >", value, "day01");
            return (Criteria) this;
        }

        public Criteria andDay01GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_01 >=", value, "day01");
            return (Criteria) this;
        }

        public Criteria andDay01LessThan(Integer value) {
            addCriterion("day_01 <", value, "day01");
            return (Criteria) this;
        }

        public Criteria andDay01LessThanOrEqualTo(Integer value) {
            addCriterion("day_01 <=", value, "day01");
            return (Criteria) this;
        }

        public Criteria andDay01In(List<Integer> values) {
            addCriterion("day_01 in", values, "day01");
            return (Criteria) this;
        }

        public Criteria andDay01NotIn(List<Integer> values) {
            addCriterion("day_01 not in", values, "day01");
            return (Criteria) this;
        }

        public Criteria andDay01Between(Integer value1, Integer value2) {
            addCriterion("day_01 between", value1, value2, "day01");
            return (Criteria) this;
        }

        public Criteria andDay01NotBetween(Integer value1, Integer value2) {
            addCriterion("day_01 not between", value1, value2, "day01");
            return (Criteria) this;
        }

        public Criteria andDay02IsNull() {
            addCriterion("day_02 is null");
            return (Criteria) this;
        }

        public Criteria andDay02IsNotNull() {
            addCriterion("day_02 is not null");
            return (Criteria) this;
        }

        public Criteria andDay02EqualTo(Integer value) {
            addCriterion("day_02 =", value, "day02");
            return (Criteria) this;
        }

        public Criteria andDay02NotEqualTo(Integer value) {
            addCriterion("day_02 <>", value, "day02");
            return (Criteria) this;
        }

        public Criteria andDay02GreaterThan(Integer value) {
            addCriterion("day_02 >", value, "day02");
            return (Criteria) this;
        }

        public Criteria andDay02GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_02 >=", value, "day02");
            return (Criteria) this;
        }

        public Criteria andDay02LessThan(Integer value) {
            addCriterion("day_02 <", value, "day02");
            return (Criteria) this;
        }

        public Criteria andDay02LessThanOrEqualTo(Integer value) {
            addCriterion("day_02 <=", value, "day02");
            return (Criteria) this;
        }

        public Criteria andDay02In(List<Integer> values) {
            addCriterion("day_02 in", values, "day02");
            return (Criteria) this;
        }

        public Criteria andDay02NotIn(List<Integer> values) {
            addCriterion("day_02 not in", values, "day02");
            return (Criteria) this;
        }

        public Criteria andDay02Between(Integer value1, Integer value2) {
            addCriterion("day_02 between", value1, value2, "day02");
            return (Criteria) this;
        }

        public Criteria andDay02NotBetween(Integer value1, Integer value2) {
            addCriterion("day_02 not between", value1, value2, "day02");
            return (Criteria) this;
        }

        public Criteria andDay03IsNull() {
            addCriterion("day_03 is null");
            return (Criteria) this;
        }

        public Criteria andDay03IsNotNull() {
            addCriterion("day_03 is not null");
            return (Criteria) this;
        }

        public Criteria andDay03EqualTo(Integer value) {
            addCriterion("day_03 =", value, "day03");
            return (Criteria) this;
        }

        public Criteria andDay03NotEqualTo(Integer value) {
            addCriterion("day_03 <>", value, "day03");
            return (Criteria) this;
        }

        public Criteria andDay03GreaterThan(Integer value) {
            addCriterion("day_03 >", value, "day03");
            return (Criteria) this;
        }

        public Criteria andDay03GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_03 >=", value, "day03");
            return (Criteria) this;
        }

        public Criteria andDay03LessThan(Integer value) {
            addCriterion("day_03 <", value, "day03");
            return (Criteria) this;
        }

        public Criteria andDay03LessThanOrEqualTo(Integer value) {
            addCriterion("day_03 <=", value, "day03");
            return (Criteria) this;
        }

        public Criteria andDay03In(List<Integer> values) {
            addCriterion("day_03 in", values, "day03");
            return (Criteria) this;
        }

        public Criteria andDay03NotIn(List<Integer> values) {
            addCriterion("day_03 not in", values, "day03");
            return (Criteria) this;
        }

        public Criteria andDay03Between(Integer value1, Integer value2) {
            addCriterion("day_03 between", value1, value2, "day03");
            return (Criteria) this;
        }

        public Criteria andDay03NotBetween(Integer value1, Integer value2) {
            addCriterion("day_03 not between", value1, value2, "day03");
            return (Criteria) this;
        }

        public Criteria andDay04IsNull() {
            addCriterion("day_04 is null");
            return (Criteria) this;
        }

        public Criteria andDay04IsNotNull() {
            addCriterion("day_04 is not null");
            return (Criteria) this;
        }

        public Criteria andDay04EqualTo(Integer value) {
            addCriterion("day_04 =", value, "day04");
            return (Criteria) this;
        }

        public Criteria andDay04NotEqualTo(Integer value) {
            addCriterion("day_04 <>", value, "day04");
            return (Criteria) this;
        }

        public Criteria andDay04GreaterThan(Integer value) {
            addCriterion("day_04 >", value, "day04");
            return (Criteria) this;
        }

        public Criteria andDay04GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_04 >=", value, "day04");
            return (Criteria) this;
        }

        public Criteria andDay04LessThan(Integer value) {
            addCriterion("day_04 <", value, "day04");
            return (Criteria) this;
        }

        public Criteria andDay04LessThanOrEqualTo(Integer value) {
            addCriterion("day_04 <=", value, "day04");
            return (Criteria) this;
        }

        public Criteria andDay04In(List<Integer> values) {
            addCriterion("day_04 in", values, "day04");
            return (Criteria) this;
        }

        public Criteria andDay04NotIn(List<Integer> values) {
            addCriterion("day_04 not in", values, "day04");
            return (Criteria) this;
        }

        public Criteria andDay04Between(Integer value1, Integer value2) {
            addCriterion("day_04 between", value1, value2, "day04");
            return (Criteria) this;
        }

        public Criteria andDay04NotBetween(Integer value1, Integer value2) {
            addCriterion("day_04 not between", value1, value2, "day04");
            return (Criteria) this;
        }

        public Criteria andDay05IsNull() {
            addCriterion("day_05 is null");
            return (Criteria) this;
        }

        public Criteria andDay05IsNotNull() {
            addCriterion("day_05 is not null");
            return (Criteria) this;
        }

        public Criteria andDay05EqualTo(Integer value) {
            addCriterion("day_05 =", value, "day05");
            return (Criteria) this;
        }

        public Criteria andDay05NotEqualTo(Integer value) {
            addCriterion("day_05 <>", value, "day05");
            return (Criteria) this;
        }

        public Criteria andDay05GreaterThan(Integer value) {
            addCriterion("day_05 >", value, "day05");
            return (Criteria) this;
        }

        public Criteria andDay05GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_05 >=", value, "day05");
            return (Criteria) this;
        }

        public Criteria andDay05LessThan(Integer value) {
            addCriterion("day_05 <", value, "day05");
            return (Criteria) this;
        }

        public Criteria andDay05LessThanOrEqualTo(Integer value) {
            addCriterion("day_05 <=", value, "day05");
            return (Criteria) this;
        }

        public Criteria andDay05In(List<Integer> values) {
            addCriterion("day_05 in", values, "day05");
            return (Criteria) this;
        }

        public Criteria andDay05NotIn(List<Integer> values) {
            addCriterion("day_05 not in", values, "day05");
            return (Criteria) this;
        }

        public Criteria andDay05Between(Integer value1, Integer value2) {
            addCriterion("day_05 between", value1, value2, "day05");
            return (Criteria) this;
        }

        public Criteria andDay05NotBetween(Integer value1, Integer value2) {
            addCriterion("day_05 not between", value1, value2, "day05");
            return (Criteria) this;
        }

        public Criteria andDay06IsNull() {
            addCriterion("day_06 is null");
            return (Criteria) this;
        }

        public Criteria andDay06IsNotNull() {
            addCriterion("day_06 is not null");
            return (Criteria) this;
        }

        public Criteria andDay06EqualTo(Integer value) {
            addCriterion("day_06 =", value, "day06");
            return (Criteria) this;
        }

        public Criteria andDay06NotEqualTo(Integer value) {
            addCriterion("day_06 <>", value, "day06");
            return (Criteria) this;
        }

        public Criteria andDay06GreaterThan(Integer value) {
            addCriterion("day_06 >", value, "day06");
            return (Criteria) this;
        }

        public Criteria andDay06GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_06 >=", value, "day06");
            return (Criteria) this;
        }

        public Criteria andDay06LessThan(Integer value) {
            addCriterion("day_06 <", value, "day06");
            return (Criteria) this;
        }

        public Criteria andDay06LessThanOrEqualTo(Integer value) {
            addCriterion("day_06 <=", value, "day06");
            return (Criteria) this;
        }

        public Criteria andDay06In(List<Integer> values) {
            addCriterion("day_06 in", values, "day06");
            return (Criteria) this;
        }

        public Criteria andDay06NotIn(List<Integer> values) {
            addCriterion("day_06 not in", values, "day06");
            return (Criteria) this;
        }

        public Criteria andDay06Between(Integer value1, Integer value2) {
            addCriterion("day_06 between", value1, value2, "day06");
            return (Criteria) this;
        }

        public Criteria andDay06NotBetween(Integer value1, Integer value2) {
            addCriterion("day_06 not between", value1, value2, "day06");
            return (Criteria) this;
        }

        public Criteria andDay07IsNull() {
            addCriterion("day_07 is null");
            return (Criteria) this;
        }

        public Criteria andDay07IsNotNull() {
            addCriterion("day_07 is not null");
            return (Criteria) this;
        }

        public Criteria andDay07EqualTo(Integer value) {
            addCriterion("day_07 =", value, "day07");
            return (Criteria) this;
        }

        public Criteria andDay07NotEqualTo(Integer value) {
            addCriterion("day_07 <>", value, "day07");
            return (Criteria) this;
        }

        public Criteria andDay07GreaterThan(Integer value) {
            addCriterion("day_07 >", value, "day07");
            return (Criteria) this;
        }

        public Criteria andDay07GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_07 >=", value, "day07");
            return (Criteria) this;
        }

        public Criteria andDay07LessThan(Integer value) {
            addCriterion("day_07 <", value, "day07");
            return (Criteria) this;
        }

        public Criteria andDay07LessThanOrEqualTo(Integer value) {
            addCriterion("day_07 <=", value, "day07");
            return (Criteria) this;
        }

        public Criteria andDay07In(List<Integer> values) {
            addCriterion("day_07 in", values, "day07");
            return (Criteria) this;
        }

        public Criteria andDay07NotIn(List<Integer> values) {
            addCriterion("day_07 not in", values, "day07");
            return (Criteria) this;
        }

        public Criteria andDay07Between(Integer value1, Integer value2) {
            addCriterion("day_07 between", value1, value2, "day07");
            return (Criteria) this;
        }

        public Criteria andDay07NotBetween(Integer value1, Integer value2) {
            addCriterion("day_07 not between", value1, value2, "day07");
            return (Criteria) this;
        }

        public Criteria andDay08IsNull() {
            addCriterion("day_08 is null");
            return (Criteria) this;
        }

        public Criteria andDay08IsNotNull() {
            addCriterion("day_08 is not null");
            return (Criteria) this;
        }

        public Criteria andDay08EqualTo(Integer value) {
            addCriterion("day_08 =", value, "day08");
            return (Criteria) this;
        }

        public Criteria andDay08NotEqualTo(Integer value) {
            addCriterion("day_08 <>", value, "day08");
            return (Criteria) this;
        }

        public Criteria andDay08GreaterThan(Integer value) {
            addCriterion("day_08 >", value, "day08");
            return (Criteria) this;
        }

        public Criteria andDay08GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_08 >=", value, "day08");
            return (Criteria) this;
        }

        public Criteria andDay08LessThan(Integer value) {
            addCriterion("day_08 <", value, "day08");
            return (Criteria) this;
        }

        public Criteria andDay08LessThanOrEqualTo(Integer value) {
            addCriterion("day_08 <=", value, "day08");
            return (Criteria) this;
        }

        public Criteria andDay08In(List<Integer> values) {
            addCriterion("day_08 in", values, "day08");
            return (Criteria) this;
        }

        public Criteria andDay08NotIn(List<Integer> values) {
            addCriterion("day_08 not in", values, "day08");
            return (Criteria) this;
        }

        public Criteria andDay08Between(Integer value1, Integer value2) {
            addCriterion("day_08 between", value1, value2, "day08");
            return (Criteria) this;
        }

        public Criteria andDay08NotBetween(Integer value1, Integer value2) {
            addCriterion("day_08 not between", value1, value2, "day08");
            return (Criteria) this;
        }

        public Criteria andDay09IsNull() {
            addCriterion("day_09 is null");
            return (Criteria) this;
        }

        public Criteria andDay09IsNotNull() {
            addCriterion("day_09 is not null");
            return (Criteria) this;
        }

        public Criteria andDay09EqualTo(Integer value) {
            addCriterion("day_09 =", value, "day09");
            return (Criteria) this;
        }

        public Criteria andDay09NotEqualTo(Integer value) {
            addCriterion("day_09 <>", value, "day09");
            return (Criteria) this;
        }

        public Criteria andDay09GreaterThan(Integer value) {
            addCriterion("day_09 >", value, "day09");
            return (Criteria) this;
        }

        public Criteria andDay09GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_09 >=", value, "day09");
            return (Criteria) this;
        }

        public Criteria andDay09LessThan(Integer value) {
            addCriterion("day_09 <", value, "day09");
            return (Criteria) this;
        }

        public Criteria andDay09LessThanOrEqualTo(Integer value) {
            addCriterion("day_09 <=", value, "day09");
            return (Criteria) this;
        }

        public Criteria andDay09In(List<Integer> values) {
            addCriterion("day_09 in", values, "day09");
            return (Criteria) this;
        }

        public Criteria andDay09NotIn(List<Integer> values) {
            addCriterion("day_09 not in", values, "day09");
            return (Criteria) this;
        }

        public Criteria andDay09Between(Integer value1, Integer value2) {
            addCriterion("day_09 between", value1, value2, "day09");
            return (Criteria) this;
        }

        public Criteria andDay09NotBetween(Integer value1, Integer value2) {
            addCriterion("day_09 not between", value1, value2, "day09");
            return (Criteria) this;
        }

        public Criteria andDay10IsNull() {
            addCriterion("day_10 is null");
            return (Criteria) this;
        }

        public Criteria andDay10IsNotNull() {
            addCriterion("day_10 is not null");
            return (Criteria) this;
        }

        public Criteria andDay10EqualTo(Integer value) {
            addCriterion("day_10 =", value, "day10");
            return (Criteria) this;
        }

        public Criteria andDay10NotEqualTo(Integer value) {
            addCriterion("day_10 <>", value, "day10");
            return (Criteria) this;
        }

        public Criteria andDay10GreaterThan(Integer value) {
            addCriterion("day_10 >", value, "day10");
            return (Criteria) this;
        }

        public Criteria andDay10GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_10 >=", value, "day10");
            return (Criteria) this;
        }

        public Criteria andDay10LessThan(Integer value) {
            addCriterion("day_10 <", value, "day10");
            return (Criteria) this;
        }

        public Criteria andDay10LessThanOrEqualTo(Integer value) {
            addCriterion("day_10 <=", value, "day10");
            return (Criteria) this;
        }

        public Criteria andDay10In(List<Integer> values) {
            addCriterion("day_10 in", values, "day10");
            return (Criteria) this;
        }

        public Criteria andDay10NotIn(List<Integer> values) {
            addCriterion("day_10 not in", values, "day10");
            return (Criteria) this;
        }

        public Criteria andDay10Between(Integer value1, Integer value2) {
            addCriterion("day_10 between", value1, value2, "day10");
            return (Criteria) this;
        }

        public Criteria andDay10NotBetween(Integer value1, Integer value2) {
            addCriterion("day_10 not between", value1, value2, "day10");
            return (Criteria) this;
        }

        public Criteria andDay11IsNull() {
            addCriterion("day_11 is null");
            return (Criteria) this;
        }

        public Criteria andDay11IsNotNull() {
            addCriterion("day_11 is not null");
            return (Criteria) this;
        }

        public Criteria andDay11EqualTo(Integer value) {
            addCriterion("day_11 =", value, "day11");
            return (Criteria) this;
        }

        public Criteria andDay11NotEqualTo(Integer value) {
            addCriterion("day_11 <>", value, "day11");
            return (Criteria) this;
        }

        public Criteria andDay11GreaterThan(Integer value) {
            addCriterion("day_11 >", value, "day11");
            return (Criteria) this;
        }

        public Criteria andDay11GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_11 >=", value, "day11");
            return (Criteria) this;
        }

        public Criteria andDay11LessThan(Integer value) {
            addCriterion("day_11 <", value, "day11");
            return (Criteria) this;
        }

        public Criteria andDay11LessThanOrEqualTo(Integer value) {
            addCriterion("day_11 <=", value, "day11");
            return (Criteria) this;
        }

        public Criteria andDay11In(List<Integer> values) {
            addCriterion("day_11 in", values, "day11");
            return (Criteria) this;
        }

        public Criteria andDay11NotIn(List<Integer> values) {
            addCriterion("day_11 not in", values, "day11");
            return (Criteria) this;
        }

        public Criteria andDay11Between(Integer value1, Integer value2) {
            addCriterion("day_11 between", value1, value2, "day11");
            return (Criteria) this;
        }

        public Criteria andDay11NotBetween(Integer value1, Integer value2) {
            addCriterion("day_11 not between", value1, value2, "day11");
            return (Criteria) this;
        }

        public Criteria andDay12IsNull() {
            addCriterion("day_12 is null");
            return (Criteria) this;
        }

        public Criteria andDay12IsNotNull() {
            addCriterion("day_12 is not null");
            return (Criteria) this;
        }

        public Criteria andDay12EqualTo(Integer value) {
            addCriterion("day_12 =", value, "day12");
            return (Criteria) this;
        }

        public Criteria andDay12NotEqualTo(Integer value) {
            addCriterion("day_12 <>", value, "day12");
            return (Criteria) this;
        }

        public Criteria andDay12GreaterThan(Integer value) {
            addCriterion("day_12 >", value, "day12");
            return (Criteria) this;
        }

        public Criteria andDay12GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_12 >=", value, "day12");
            return (Criteria) this;
        }

        public Criteria andDay12LessThan(Integer value) {
            addCriterion("day_12 <", value, "day12");
            return (Criteria) this;
        }

        public Criteria andDay12LessThanOrEqualTo(Integer value) {
            addCriterion("day_12 <=", value, "day12");
            return (Criteria) this;
        }

        public Criteria andDay12In(List<Integer> values) {
            addCriterion("day_12 in", values, "day12");
            return (Criteria) this;
        }

        public Criteria andDay12NotIn(List<Integer> values) {
            addCriterion("day_12 not in", values, "day12");
            return (Criteria) this;
        }

        public Criteria andDay12Between(Integer value1, Integer value2) {
            addCriterion("day_12 between", value1, value2, "day12");
            return (Criteria) this;
        }

        public Criteria andDay12NotBetween(Integer value1, Integer value2) {
            addCriterion("day_12 not between", value1, value2, "day12");
            return (Criteria) this;
        }

        public Criteria andDay13IsNull() {
            addCriterion("day_13 is null");
            return (Criteria) this;
        }

        public Criteria andDay13IsNotNull() {
            addCriterion("day_13 is not null");
            return (Criteria) this;
        }

        public Criteria andDay13EqualTo(Integer value) {
            addCriterion("day_13 =", value, "day13");
            return (Criteria) this;
        }

        public Criteria andDay13NotEqualTo(Integer value) {
            addCriterion("day_13 <>", value, "day13");
            return (Criteria) this;
        }

        public Criteria andDay13GreaterThan(Integer value) {
            addCriterion("day_13 >", value, "day13");
            return (Criteria) this;
        }

        public Criteria andDay13GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_13 >=", value, "day13");
            return (Criteria) this;
        }

        public Criteria andDay13LessThan(Integer value) {
            addCriterion("day_13 <", value, "day13");
            return (Criteria) this;
        }

        public Criteria andDay13LessThanOrEqualTo(Integer value) {
            addCriterion("day_13 <=", value, "day13");
            return (Criteria) this;
        }

        public Criteria andDay13In(List<Integer> values) {
            addCriterion("day_13 in", values, "day13");
            return (Criteria) this;
        }

        public Criteria andDay13NotIn(List<Integer> values) {
            addCriterion("day_13 not in", values, "day13");
            return (Criteria) this;
        }

        public Criteria andDay13Between(Integer value1, Integer value2) {
            addCriterion("day_13 between", value1, value2, "day13");
            return (Criteria) this;
        }

        public Criteria andDay13NotBetween(Integer value1, Integer value2) {
            addCriterion("day_13 not between", value1, value2, "day13");
            return (Criteria) this;
        }

        public Criteria andDay14IsNull() {
            addCriterion("day_14 is null");
            return (Criteria) this;
        }

        public Criteria andDay14IsNotNull() {
            addCriterion("day_14 is not null");
            return (Criteria) this;
        }

        public Criteria andDay14EqualTo(Integer value) {
            addCriterion("day_14 =", value, "day14");
            return (Criteria) this;
        }

        public Criteria andDay14NotEqualTo(Integer value) {
            addCriterion("day_14 <>", value, "day14");
            return (Criteria) this;
        }

        public Criteria andDay14GreaterThan(Integer value) {
            addCriterion("day_14 >", value, "day14");
            return (Criteria) this;
        }

        public Criteria andDay14GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_14 >=", value, "day14");
            return (Criteria) this;
        }

        public Criteria andDay14LessThan(Integer value) {
            addCriterion("day_14 <", value, "day14");
            return (Criteria) this;
        }

        public Criteria andDay14LessThanOrEqualTo(Integer value) {
            addCriterion("day_14 <=", value, "day14");
            return (Criteria) this;
        }

        public Criteria andDay14In(List<Integer> values) {
            addCriterion("day_14 in", values, "day14");
            return (Criteria) this;
        }

        public Criteria andDay14NotIn(List<Integer> values) {
            addCriterion("day_14 not in", values, "day14");
            return (Criteria) this;
        }

        public Criteria andDay14Between(Integer value1, Integer value2) {
            addCriterion("day_14 between", value1, value2, "day14");
            return (Criteria) this;
        }

        public Criteria andDay14NotBetween(Integer value1, Integer value2) {
            addCriterion("day_14 not between", value1, value2, "day14");
            return (Criteria) this;
        }

        public Criteria andDay15IsNull() {
            addCriterion("day_15 is null");
            return (Criteria) this;
        }

        public Criteria andDay15IsNotNull() {
            addCriterion("day_15 is not null");
            return (Criteria) this;
        }

        public Criteria andDay15EqualTo(Integer value) {
            addCriterion("day_15 =", value, "day15");
            return (Criteria) this;
        }

        public Criteria andDay15NotEqualTo(Integer value) {
            addCriterion("day_15 <>", value, "day15");
            return (Criteria) this;
        }

        public Criteria andDay15GreaterThan(Integer value) {
            addCriterion("day_15 >", value, "day15");
            return (Criteria) this;
        }

        public Criteria andDay15GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_15 >=", value, "day15");
            return (Criteria) this;
        }

        public Criteria andDay15LessThan(Integer value) {
            addCriterion("day_15 <", value, "day15");
            return (Criteria) this;
        }

        public Criteria andDay15LessThanOrEqualTo(Integer value) {
            addCriterion("day_15 <=", value, "day15");
            return (Criteria) this;
        }

        public Criteria andDay15In(List<Integer> values) {
            addCriterion("day_15 in", values, "day15");
            return (Criteria) this;
        }

        public Criteria andDay15NotIn(List<Integer> values) {
            addCriterion("day_15 not in", values, "day15");
            return (Criteria) this;
        }

        public Criteria andDay15Between(Integer value1, Integer value2) {
            addCriterion("day_15 between", value1, value2, "day15");
            return (Criteria) this;
        }

        public Criteria andDay15NotBetween(Integer value1, Integer value2) {
            addCriterion("day_15 not between", value1, value2, "day15");
            return (Criteria) this;
        }

        public Criteria andDay16IsNull() {
            addCriterion("day_16 is null");
            return (Criteria) this;
        }

        public Criteria andDay16IsNotNull() {
            addCriterion("day_16 is not null");
            return (Criteria) this;
        }

        public Criteria andDay16EqualTo(Integer value) {
            addCriterion("day_16 =", value, "day16");
            return (Criteria) this;
        }

        public Criteria andDay16NotEqualTo(Integer value) {
            addCriterion("day_16 <>", value, "day16");
            return (Criteria) this;
        }

        public Criteria andDay16GreaterThan(Integer value) {
            addCriterion("day_16 >", value, "day16");
            return (Criteria) this;
        }

        public Criteria andDay16GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_16 >=", value, "day16");
            return (Criteria) this;
        }

        public Criteria andDay16LessThan(Integer value) {
            addCriterion("day_16 <", value, "day16");
            return (Criteria) this;
        }

        public Criteria andDay16LessThanOrEqualTo(Integer value) {
            addCriterion("day_16 <=", value, "day16");
            return (Criteria) this;
        }

        public Criteria andDay16In(List<Integer> values) {
            addCriterion("day_16 in", values, "day16");
            return (Criteria) this;
        }

        public Criteria andDay16NotIn(List<Integer> values) {
            addCriterion("day_16 not in", values, "day16");
            return (Criteria) this;
        }

        public Criteria andDay16Between(Integer value1, Integer value2) {
            addCriterion("day_16 between", value1, value2, "day16");
            return (Criteria) this;
        }

        public Criteria andDay16NotBetween(Integer value1, Integer value2) {
            addCriterion("day_16 not between", value1, value2, "day16");
            return (Criteria) this;
        }

        public Criteria andDay17IsNull() {
            addCriterion("day_17 is null");
            return (Criteria) this;
        }

        public Criteria andDay17IsNotNull() {
            addCriterion("day_17 is not null");
            return (Criteria) this;
        }

        public Criteria andDay17EqualTo(Integer value) {
            addCriterion("day_17 =", value, "day17");
            return (Criteria) this;
        }

        public Criteria andDay17NotEqualTo(Integer value) {
            addCriterion("day_17 <>", value, "day17");
            return (Criteria) this;
        }

        public Criteria andDay17GreaterThan(Integer value) {
            addCriterion("day_17 >", value, "day17");
            return (Criteria) this;
        }

        public Criteria andDay17GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_17 >=", value, "day17");
            return (Criteria) this;
        }

        public Criteria andDay17LessThan(Integer value) {
            addCriterion("day_17 <", value, "day17");
            return (Criteria) this;
        }

        public Criteria andDay17LessThanOrEqualTo(Integer value) {
            addCriterion("day_17 <=", value, "day17");
            return (Criteria) this;
        }

        public Criteria andDay17In(List<Integer> values) {
            addCriterion("day_17 in", values, "day17");
            return (Criteria) this;
        }

        public Criteria andDay17NotIn(List<Integer> values) {
            addCriterion("day_17 not in", values, "day17");
            return (Criteria) this;
        }

        public Criteria andDay17Between(Integer value1, Integer value2) {
            addCriterion("day_17 between", value1, value2, "day17");
            return (Criteria) this;
        }

        public Criteria andDay17NotBetween(Integer value1, Integer value2) {
            addCriterion("day_17 not between", value1, value2, "day17");
            return (Criteria) this;
        }

        public Criteria andDay18IsNull() {
            addCriterion("day_18 is null");
            return (Criteria) this;
        }

        public Criteria andDay18IsNotNull() {
            addCriterion("day_18 is not null");
            return (Criteria) this;
        }

        public Criteria andDay18EqualTo(Integer value) {
            addCriterion("day_18 =", value, "day18");
            return (Criteria) this;
        }

        public Criteria andDay18NotEqualTo(Integer value) {
            addCriterion("day_18 <>", value, "day18");
            return (Criteria) this;
        }

        public Criteria andDay18GreaterThan(Integer value) {
            addCriterion("day_18 >", value, "day18");
            return (Criteria) this;
        }

        public Criteria andDay18GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_18 >=", value, "day18");
            return (Criteria) this;
        }

        public Criteria andDay18LessThan(Integer value) {
            addCriterion("day_18 <", value, "day18");
            return (Criteria) this;
        }

        public Criteria andDay18LessThanOrEqualTo(Integer value) {
            addCriterion("day_18 <=", value, "day18");
            return (Criteria) this;
        }

        public Criteria andDay18In(List<Integer> values) {
            addCriterion("day_18 in", values, "day18");
            return (Criteria) this;
        }

        public Criteria andDay18NotIn(List<Integer> values) {
            addCriterion("day_18 not in", values, "day18");
            return (Criteria) this;
        }

        public Criteria andDay18Between(Integer value1, Integer value2) {
            addCriterion("day_18 between", value1, value2, "day18");
            return (Criteria) this;
        }

        public Criteria andDay18NotBetween(Integer value1, Integer value2) {
            addCriterion("day_18 not between", value1, value2, "day18");
            return (Criteria) this;
        }

        public Criteria andDay19IsNull() {
            addCriterion("day_19 is null");
            return (Criteria) this;
        }

        public Criteria andDay19IsNotNull() {
            addCriterion("day_19 is not null");
            return (Criteria) this;
        }

        public Criteria andDay19EqualTo(Integer value) {
            addCriterion("day_19 =", value, "day19");
            return (Criteria) this;
        }

        public Criteria andDay19NotEqualTo(Integer value) {
            addCriterion("day_19 <>", value, "day19");
            return (Criteria) this;
        }

        public Criteria andDay19GreaterThan(Integer value) {
            addCriterion("day_19 >", value, "day19");
            return (Criteria) this;
        }

        public Criteria andDay19GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_19 >=", value, "day19");
            return (Criteria) this;
        }

        public Criteria andDay19LessThan(Integer value) {
            addCriterion("day_19 <", value, "day19");
            return (Criteria) this;
        }

        public Criteria andDay19LessThanOrEqualTo(Integer value) {
            addCriterion("day_19 <=", value, "day19");
            return (Criteria) this;
        }

        public Criteria andDay19In(List<Integer> values) {
            addCriterion("day_19 in", values, "day19");
            return (Criteria) this;
        }

        public Criteria andDay19NotIn(List<Integer> values) {
            addCriterion("day_19 not in", values, "day19");
            return (Criteria) this;
        }

        public Criteria andDay19Between(Integer value1, Integer value2) {
            addCriterion("day_19 between", value1, value2, "day19");
            return (Criteria) this;
        }

        public Criteria andDay19NotBetween(Integer value1, Integer value2) {
            addCriterion("day_19 not between", value1, value2, "day19");
            return (Criteria) this;
        }

        public Criteria andDay20IsNull() {
            addCriterion("day_20 is null");
            return (Criteria) this;
        }

        public Criteria andDay20IsNotNull() {
            addCriterion("day_20 is not null");
            return (Criteria) this;
        }

        public Criteria andDay20EqualTo(Integer value) {
            addCriterion("day_20 =", value, "day20");
            return (Criteria) this;
        }

        public Criteria andDay20NotEqualTo(Integer value) {
            addCriterion("day_20 <>", value, "day20");
            return (Criteria) this;
        }

        public Criteria andDay20GreaterThan(Integer value) {
            addCriterion("day_20 >", value, "day20");
            return (Criteria) this;
        }

        public Criteria andDay20GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_20 >=", value, "day20");
            return (Criteria) this;
        }

        public Criteria andDay20LessThan(Integer value) {
            addCriterion("day_20 <", value, "day20");
            return (Criteria) this;
        }

        public Criteria andDay20LessThanOrEqualTo(Integer value) {
            addCriterion("day_20 <=", value, "day20");
            return (Criteria) this;
        }

        public Criteria andDay20In(List<Integer> values) {
            addCriterion("day_20 in", values, "day20");
            return (Criteria) this;
        }

        public Criteria andDay20NotIn(List<Integer> values) {
            addCriterion("day_20 not in", values, "day20");
            return (Criteria) this;
        }

        public Criteria andDay20Between(Integer value1, Integer value2) {
            addCriterion("day_20 between", value1, value2, "day20");
            return (Criteria) this;
        }

        public Criteria andDay20NotBetween(Integer value1, Integer value2) {
            addCriterion("day_20 not between", value1, value2, "day20");
            return (Criteria) this;
        }

        public Criteria andDay21IsNull() {
            addCriterion("day_21 is null");
            return (Criteria) this;
        }

        public Criteria andDay21IsNotNull() {
            addCriterion("day_21 is not null");
            return (Criteria) this;
        }

        public Criteria andDay21EqualTo(Integer value) {
            addCriterion("day_21 =", value, "day21");
            return (Criteria) this;
        }

        public Criteria andDay21NotEqualTo(Integer value) {
            addCriterion("day_21 <>", value, "day21");
            return (Criteria) this;
        }

        public Criteria andDay21GreaterThan(Integer value) {
            addCriterion("day_21 >", value, "day21");
            return (Criteria) this;
        }

        public Criteria andDay21GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_21 >=", value, "day21");
            return (Criteria) this;
        }

        public Criteria andDay21LessThan(Integer value) {
            addCriterion("day_21 <", value, "day21");
            return (Criteria) this;
        }

        public Criteria andDay21LessThanOrEqualTo(Integer value) {
            addCriterion("day_21 <=", value, "day21");
            return (Criteria) this;
        }

        public Criteria andDay21In(List<Integer> values) {
            addCriterion("day_21 in", values, "day21");
            return (Criteria) this;
        }

        public Criteria andDay21NotIn(List<Integer> values) {
            addCriterion("day_21 not in", values, "day21");
            return (Criteria) this;
        }

        public Criteria andDay21Between(Integer value1, Integer value2) {
            addCriterion("day_21 between", value1, value2, "day21");
            return (Criteria) this;
        }

        public Criteria andDay21NotBetween(Integer value1, Integer value2) {
            addCriterion("day_21 not between", value1, value2, "day21");
            return (Criteria) this;
        }

        public Criteria andDay22IsNull() {
            addCriterion("day_22 is null");
            return (Criteria) this;
        }

        public Criteria andDay22IsNotNull() {
            addCriterion("day_22 is not null");
            return (Criteria) this;
        }

        public Criteria andDay22EqualTo(Integer value) {
            addCriterion("day_22 =", value, "day22");
            return (Criteria) this;
        }

        public Criteria andDay22NotEqualTo(Integer value) {
            addCriterion("day_22 <>", value, "day22");
            return (Criteria) this;
        }

        public Criteria andDay22GreaterThan(Integer value) {
            addCriterion("day_22 >", value, "day22");
            return (Criteria) this;
        }

        public Criteria andDay22GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_22 >=", value, "day22");
            return (Criteria) this;
        }

        public Criteria andDay22LessThan(Integer value) {
            addCriterion("day_22 <", value, "day22");
            return (Criteria) this;
        }

        public Criteria andDay22LessThanOrEqualTo(Integer value) {
            addCriterion("day_22 <=", value, "day22");
            return (Criteria) this;
        }

        public Criteria andDay22In(List<Integer> values) {
            addCriterion("day_22 in", values, "day22");
            return (Criteria) this;
        }

        public Criteria andDay22NotIn(List<Integer> values) {
            addCriterion("day_22 not in", values, "day22");
            return (Criteria) this;
        }

        public Criteria andDay22Between(Integer value1, Integer value2) {
            addCriterion("day_22 between", value1, value2, "day22");
            return (Criteria) this;
        }

        public Criteria andDay22NotBetween(Integer value1, Integer value2) {
            addCriterion("day_22 not between", value1, value2, "day22");
            return (Criteria) this;
        }

        public Criteria andDay23IsNull() {
            addCriterion("day_23 is null");
            return (Criteria) this;
        }

        public Criteria andDay23IsNotNull() {
            addCriterion("day_23 is not null");
            return (Criteria) this;
        }

        public Criteria andDay23EqualTo(Integer value) {
            addCriterion("day_23 =", value, "day23");
            return (Criteria) this;
        }

        public Criteria andDay23NotEqualTo(Integer value) {
            addCriterion("day_23 <>", value, "day23");
            return (Criteria) this;
        }

        public Criteria andDay23GreaterThan(Integer value) {
            addCriterion("day_23 >", value, "day23");
            return (Criteria) this;
        }

        public Criteria andDay23GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_23 >=", value, "day23");
            return (Criteria) this;
        }

        public Criteria andDay23LessThan(Integer value) {
            addCriterion("day_23 <", value, "day23");
            return (Criteria) this;
        }

        public Criteria andDay23LessThanOrEqualTo(Integer value) {
            addCriterion("day_23 <=", value, "day23");
            return (Criteria) this;
        }

        public Criteria andDay23In(List<Integer> values) {
            addCriterion("day_23 in", values, "day23");
            return (Criteria) this;
        }

        public Criteria andDay23NotIn(List<Integer> values) {
            addCriterion("day_23 not in", values, "day23");
            return (Criteria) this;
        }

        public Criteria andDay23Between(Integer value1, Integer value2) {
            addCriterion("day_23 between", value1, value2, "day23");
            return (Criteria) this;
        }

        public Criteria andDay23NotBetween(Integer value1, Integer value2) {
            addCriterion("day_23 not between", value1, value2, "day23");
            return (Criteria) this;
        }

        public Criteria andDay24IsNull() {
            addCriterion("day_24 is null");
            return (Criteria) this;
        }

        public Criteria andDay24IsNotNull() {
            addCriterion("day_24 is not null");
            return (Criteria) this;
        }

        public Criteria andDay24EqualTo(Integer value) {
            addCriterion("day_24 =", value, "day24");
            return (Criteria) this;
        }

        public Criteria andDay24NotEqualTo(Integer value) {
            addCriterion("day_24 <>", value, "day24");
            return (Criteria) this;
        }

        public Criteria andDay24GreaterThan(Integer value) {
            addCriterion("day_24 >", value, "day24");
            return (Criteria) this;
        }

        public Criteria andDay24GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_24 >=", value, "day24");
            return (Criteria) this;
        }

        public Criteria andDay24LessThan(Integer value) {
            addCriterion("day_24 <", value, "day24");
            return (Criteria) this;
        }

        public Criteria andDay24LessThanOrEqualTo(Integer value) {
            addCriterion("day_24 <=", value, "day24");
            return (Criteria) this;
        }

        public Criteria andDay24In(List<Integer> values) {
            addCriterion("day_24 in", values, "day24");
            return (Criteria) this;
        }

        public Criteria andDay24NotIn(List<Integer> values) {
            addCriterion("day_24 not in", values, "day24");
            return (Criteria) this;
        }

        public Criteria andDay24Between(Integer value1, Integer value2) {
            addCriterion("day_24 between", value1, value2, "day24");
            return (Criteria) this;
        }

        public Criteria andDay24NotBetween(Integer value1, Integer value2) {
            addCriterion("day_24 not between", value1, value2, "day24");
            return (Criteria) this;
        }

        public Criteria andDay25IsNull() {
            addCriterion("day_25 is null");
            return (Criteria) this;
        }

        public Criteria andDay25IsNotNull() {
            addCriterion("day_25 is not null");
            return (Criteria) this;
        }

        public Criteria andDay25EqualTo(Integer value) {
            addCriterion("day_25 =", value, "day25");
            return (Criteria) this;
        }

        public Criteria andDay25NotEqualTo(Integer value) {
            addCriterion("day_25 <>", value, "day25");
            return (Criteria) this;
        }

        public Criteria andDay25GreaterThan(Integer value) {
            addCriterion("day_25 >", value, "day25");
            return (Criteria) this;
        }

        public Criteria andDay25GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_25 >=", value, "day25");
            return (Criteria) this;
        }

        public Criteria andDay25LessThan(Integer value) {
            addCriterion("day_25 <", value, "day25");
            return (Criteria) this;
        }

        public Criteria andDay25LessThanOrEqualTo(Integer value) {
            addCriterion("day_25 <=", value, "day25");
            return (Criteria) this;
        }

        public Criteria andDay25In(List<Integer> values) {
            addCriterion("day_25 in", values, "day25");
            return (Criteria) this;
        }

        public Criteria andDay25NotIn(List<Integer> values) {
            addCriterion("day_25 not in", values, "day25");
            return (Criteria) this;
        }

        public Criteria andDay25Between(Integer value1, Integer value2) {
            addCriterion("day_25 between", value1, value2, "day25");
            return (Criteria) this;
        }

        public Criteria andDay25NotBetween(Integer value1, Integer value2) {
            addCriterion("day_25 not between", value1, value2, "day25");
            return (Criteria) this;
        }

        public Criteria andDay26IsNull() {
            addCriterion("day_26 is null");
            return (Criteria) this;
        }

        public Criteria andDay26IsNotNull() {
            addCriterion("day_26 is not null");
            return (Criteria) this;
        }

        public Criteria andDay26EqualTo(Integer value) {
            addCriterion("day_26 =", value, "day26");
            return (Criteria) this;
        }

        public Criteria andDay26NotEqualTo(Integer value) {
            addCriterion("day_26 <>", value, "day26");
            return (Criteria) this;
        }

        public Criteria andDay26GreaterThan(Integer value) {
            addCriterion("day_26 >", value, "day26");
            return (Criteria) this;
        }

        public Criteria andDay26GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_26 >=", value, "day26");
            return (Criteria) this;
        }

        public Criteria andDay26LessThan(Integer value) {
            addCriterion("day_26 <", value, "day26");
            return (Criteria) this;
        }

        public Criteria andDay26LessThanOrEqualTo(Integer value) {
            addCriterion("day_26 <=", value, "day26");
            return (Criteria) this;
        }

        public Criteria andDay26In(List<Integer> values) {
            addCriterion("day_26 in", values, "day26");
            return (Criteria) this;
        }

        public Criteria andDay26NotIn(List<Integer> values) {
            addCriterion("day_26 not in", values, "day26");
            return (Criteria) this;
        }

        public Criteria andDay26Between(Integer value1, Integer value2) {
            addCriterion("day_26 between", value1, value2, "day26");
            return (Criteria) this;
        }

        public Criteria andDay26NotBetween(Integer value1, Integer value2) {
            addCriterion("day_26 not between", value1, value2, "day26");
            return (Criteria) this;
        }

        public Criteria andDay27IsNull() {
            addCriterion("day_27 is null");
            return (Criteria) this;
        }

        public Criteria andDay27IsNotNull() {
            addCriterion("day_27 is not null");
            return (Criteria) this;
        }

        public Criteria andDay27EqualTo(Integer value) {
            addCriterion("day_27 =", value, "day27");
            return (Criteria) this;
        }

        public Criteria andDay27NotEqualTo(Integer value) {
            addCriterion("day_27 <>", value, "day27");
            return (Criteria) this;
        }

        public Criteria andDay27GreaterThan(Integer value) {
            addCriterion("day_27 >", value, "day27");
            return (Criteria) this;
        }

        public Criteria andDay27GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_27 >=", value, "day27");
            return (Criteria) this;
        }

        public Criteria andDay27LessThan(Integer value) {
            addCriterion("day_27 <", value, "day27");
            return (Criteria) this;
        }

        public Criteria andDay27LessThanOrEqualTo(Integer value) {
            addCriterion("day_27 <=", value, "day27");
            return (Criteria) this;
        }

        public Criteria andDay27In(List<Integer> values) {
            addCriterion("day_27 in", values, "day27");
            return (Criteria) this;
        }

        public Criteria andDay27NotIn(List<Integer> values) {
            addCriterion("day_27 not in", values, "day27");
            return (Criteria) this;
        }

        public Criteria andDay27Between(Integer value1, Integer value2) {
            addCriterion("day_27 between", value1, value2, "day27");
            return (Criteria) this;
        }

        public Criteria andDay27NotBetween(Integer value1, Integer value2) {
            addCriterion("day_27 not between", value1, value2, "day27");
            return (Criteria) this;
        }

        public Criteria andDay28IsNull() {
            addCriterion("day_28 is null");
            return (Criteria) this;
        }

        public Criteria andDay28IsNotNull() {
            addCriterion("day_28 is not null");
            return (Criteria) this;
        }

        public Criteria andDay28EqualTo(Integer value) {
            addCriterion("day_28 =", value, "day28");
            return (Criteria) this;
        }

        public Criteria andDay28NotEqualTo(Integer value) {
            addCriterion("day_28 <>", value, "day28");
            return (Criteria) this;
        }

        public Criteria andDay28GreaterThan(Integer value) {
            addCriterion("day_28 >", value, "day28");
            return (Criteria) this;
        }

        public Criteria andDay28GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_28 >=", value, "day28");
            return (Criteria) this;
        }

        public Criteria andDay28LessThan(Integer value) {
            addCriterion("day_28 <", value, "day28");
            return (Criteria) this;
        }

        public Criteria andDay28LessThanOrEqualTo(Integer value) {
            addCriterion("day_28 <=", value, "day28");
            return (Criteria) this;
        }

        public Criteria andDay28In(List<Integer> values) {
            addCriterion("day_28 in", values, "day28");
            return (Criteria) this;
        }

        public Criteria andDay28NotIn(List<Integer> values) {
            addCriterion("day_28 not in", values, "day28");
            return (Criteria) this;
        }

        public Criteria andDay28Between(Integer value1, Integer value2) {
            addCriterion("day_28 between", value1, value2, "day28");
            return (Criteria) this;
        }

        public Criteria andDay28NotBetween(Integer value1, Integer value2) {
            addCriterion("day_28 not between", value1, value2, "day28");
            return (Criteria) this;
        }

        public Criteria andDay29IsNull() {
            addCriterion("day_29 is null");
            return (Criteria) this;
        }

        public Criteria andDay29IsNotNull() {
            addCriterion("day_29 is not null");
            return (Criteria) this;
        }

        public Criteria andDay29EqualTo(Integer value) {
            addCriterion("day_29 =", value, "day29");
            return (Criteria) this;
        }

        public Criteria andDay29NotEqualTo(Integer value) {
            addCriterion("day_29 <>", value, "day29");
            return (Criteria) this;
        }

        public Criteria andDay29GreaterThan(Integer value) {
            addCriterion("day_29 >", value, "day29");
            return (Criteria) this;
        }

        public Criteria andDay29GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_29 >=", value, "day29");
            return (Criteria) this;
        }

        public Criteria andDay29LessThan(Integer value) {
            addCriterion("day_29 <", value, "day29");
            return (Criteria) this;
        }

        public Criteria andDay29LessThanOrEqualTo(Integer value) {
            addCriterion("day_29 <=", value, "day29");
            return (Criteria) this;
        }

        public Criteria andDay29In(List<Integer> values) {
            addCriterion("day_29 in", values, "day29");
            return (Criteria) this;
        }

        public Criteria andDay29NotIn(List<Integer> values) {
            addCriterion("day_29 not in", values, "day29");
            return (Criteria) this;
        }

        public Criteria andDay29Between(Integer value1, Integer value2) {
            addCriterion("day_29 between", value1, value2, "day29");
            return (Criteria) this;
        }

        public Criteria andDay29NotBetween(Integer value1, Integer value2) {
            addCriterion("day_29 not between", value1, value2, "day29");
            return (Criteria) this;
        }

        public Criteria andDay30IsNull() {
            addCriterion("day_30 is null");
            return (Criteria) this;
        }

        public Criteria andDay30IsNotNull() {
            addCriterion("day_30 is not null");
            return (Criteria) this;
        }

        public Criteria andDay30EqualTo(Integer value) {
            addCriterion("day_30 =", value, "day30");
            return (Criteria) this;
        }

        public Criteria andDay30NotEqualTo(Integer value) {
            addCriterion("day_30 <>", value, "day30");
            return (Criteria) this;
        }

        public Criteria andDay30GreaterThan(Integer value) {
            addCriterion("day_30 >", value, "day30");
            return (Criteria) this;
        }

        public Criteria andDay30GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_30 >=", value, "day30");
            return (Criteria) this;
        }

        public Criteria andDay30LessThan(Integer value) {
            addCriterion("day_30 <", value, "day30");
            return (Criteria) this;
        }

        public Criteria andDay30LessThanOrEqualTo(Integer value) {
            addCriterion("day_30 <=", value, "day30");
            return (Criteria) this;
        }

        public Criteria andDay30In(List<Integer> values) {
            addCriterion("day_30 in", values, "day30");
            return (Criteria) this;
        }

        public Criteria andDay30NotIn(List<Integer> values) {
            addCriterion("day_30 not in", values, "day30");
            return (Criteria) this;
        }

        public Criteria andDay30Between(Integer value1, Integer value2) {
            addCriterion("day_30 between", value1, value2, "day30");
            return (Criteria) this;
        }

        public Criteria andDay30NotBetween(Integer value1, Integer value2) {
            addCriterion("day_30 not between", value1, value2, "day30");
            return (Criteria) this;
        }

        public Criteria andDay31IsNull() {
            addCriterion("day_31 is null");
            return (Criteria) this;
        }

        public Criteria andDay31IsNotNull() {
            addCriterion("day_31 is not null");
            return (Criteria) this;
        }

        public Criteria andDay31EqualTo(Integer value) {
            addCriterion("day_31 =", value, "day31");
            return (Criteria) this;
        }

        public Criteria andDay31NotEqualTo(Integer value) {
            addCriterion("day_31 <>", value, "day31");
            return (Criteria) this;
        }

        public Criteria andDay31GreaterThan(Integer value) {
            addCriterion("day_31 >", value, "day31");
            return (Criteria) this;
        }

        public Criteria andDay31GreaterThanOrEqualTo(Integer value) {
            addCriterion("day_31 >=", value, "day31");
            return (Criteria) this;
        }

        public Criteria andDay31LessThan(Integer value) {
            addCriterion("day_31 <", value, "day31");
            return (Criteria) this;
        }

        public Criteria andDay31LessThanOrEqualTo(Integer value) {
            addCriterion("day_31 <=", value, "day31");
            return (Criteria) this;
        }

        public Criteria andDay31In(List<Integer> values) {
            addCriterion("day_31 in", values, "day31");
            return (Criteria) this;
        }

        public Criteria andDay31NotIn(List<Integer> values) {
            addCriterion("day_31 not in", values, "day31");
            return (Criteria) this;
        }

        public Criteria andDay31Between(Integer value1, Integer value2) {
            addCriterion("day_31 between", value1, value2, "day31");
            return (Criteria) this;
        }

        public Criteria andDay31NotBetween(Integer value1, Integer value2) {
            addCriterion("day_31 not between", value1, value2, "day31");
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