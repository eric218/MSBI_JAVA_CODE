package com.hpe.msbireport.domain;

import java.util.ArrayList;
import java.util.List;

public class MonthReportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MonthReportExample() {
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

        public Criteria andServerNameIsNull() {
            addCriterion("server_name is null");
            return (Criteria) this;
        }

        public Criteria andServerNameIsNotNull() {
            addCriterion("server_name is not null");
            return (Criteria) this;
        }

        public Criteria andServerNameEqualTo(String value) {
            addCriterion("server_name =", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameNotEqualTo(String value) {
            addCriterion("server_name <>", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameGreaterThan(String value) {
            addCriterion("server_name >", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameGreaterThanOrEqualTo(String value) {
            addCriterion("server_name >=", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameLessThan(String value) {
            addCriterion("server_name <", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameLessThanOrEqualTo(String value) {
            addCriterion("server_name <=", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameLike(String value) {
            addCriterion("server_name like", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameNotLike(String value) {
            addCriterion("server_name not like", value, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameIn(List<String> values) {
            addCriterion("server_name in", values, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameNotIn(List<String> values) {
            addCriterion("server_name not in", values, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameBetween(String value1, String value2) {
            addCriterion("server_name between", value1, value2, "serverName");
            return (Criteria) this;
        }

        public Criteria andServerNameNotBetween(String value1, String value2) {
            addCriterion("server_name not between", value1, value2, "serverName");
            return (Criteria) this;
        }

        public Criteria andScheduleNameIsNull() {
            addCriterion("schedule_name is null");
            return (Criteria) this;
        }

        public Criteria andScheduleNameIsNotNull() {
            addCriterion("schedule_name is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleNameEqualTo(String value) {
            addCriterion("schedule_name =", value, "scheduleName");
            return (Criteria) this;
        }

        public Criteria andScheduleNameNotEqualTo(String value) {
            addCriterion("schedule_name <>", value, "scheduleName");
            return (Criteria) this;
        }

        public Criteria andScheduleNameGreaterThan(String value) {
            addCriterion("schedule_name >", value, "scheduleName");
            return (Criteria) this;
        }

        public Criteria andScheduleNameGreaterThanOrEqualTo(String value) {
            addCriterion("schedule_name >=", value, "scheduleName");
            return (Criteria) this;
        }

        public Criteria andScheduleNameLessThan(String value) {
            addCriterion("schedule_name <", value, "scheduleName");
            return (Criteria) this;
        }

        public Criteria andScheduleNameLessThanOrEqualTo(String value) {
            addCriterion("schedule_name <=", value, "scheduleName");
            return (Criteria) this;
        }

        public Criteria andScheduleNameLike(String value) {
            addCriterion("schedule_name like", value, "scheduleName");
            return (Criteria) this;
        }

        public Criteria andScheduleNameNotLike(String value) {
            addCriterion("schedule_name not like", value, "scheduleName");
            return (Criteria) this;
        }

        public Criteria andScheduleNameIn(List<String> values) {
            addCriterion("schedule_name in", values, "scheduleName");
            return (Criteria) this;
        }

        public Criteria andScheduleNameNotIn(List<String> values) {
            addCriterion("schedule_name not in", values, "scheduleName");
            return (Criteria) this;
        }

        public Criteria andScheduleNameBetween(String value1, String value2) {
            addCriterion("schedule_name between", value1, value2, "scheduleName");
            return (Criteria) this;
        }

        public Criteria andScheduleNameNotBetween(String value1, String value2) {
            addCriterion("schedule_name not between", value1, value2, "scheduleName");
            return (Criteria) this;
        }

        public Criteria andSchedStyleIsNull() {
            addCriterion("sched_style is null");
            return (Criteria) this;
        }

        public Criteria andSchedStyleIsNotNull() {
            addCriterion("sched_style is not null");
            return (Criteria) this;
        }

        public Criteria andSchedStyleEqualTo(String value) {
            addCriterion("sched_style =", value, "schedStyle");
            return (Criteria) this;
        }

        public Criteria andSchedStyleNotEqualTo(String value) {
            addCriterion("sched_style <>", value, "schedStyle");
            return (Criteria) this;
        }

        public Criteria andSchedStyleGreaterThan(String value) {
            addCriterion("sched_style >", value, "schedStyle");
            return (Criteria) this;
        }

        public Criteria andSchedStyleGreaterThanOrEqualTo(String value) {
            addCriterion("sched_style >=", value, "schedStyle");
            return (Criteria) this;
        }

        public Criteria andSchedStyleLessThan(String value) {
            addCriterion("sched_style <", value, "schedStyle");
            return (Criteria) this;
        }

        public Criteria andSchedStyleLessThanOrEqualTo(String value) {
            addCriterion("sched_style <=", value, "schedStyle");
            return (Criteria) this;
        }

        public Criteria andSchedStyleLike(String value) {
            addCriterion("sched_style like", value, "schedStyle");
            return (Criteria) this;
        }

        public Criteria andSchedStyleNotLike(String value) {
            addCriterion("sched_style not like", value, "schedStyle");
            return (Criteria) this;
        }

        public Criteria andSchedStyleIn(List<String> values) {
            addCriterion("sched_style in", values, "schedStyle");
            return (Criteria) this;
        }

        public Criteria andSchedStyleNotIn(List<String> values) {
            addCriterion("sched_style not in", values, "schedStyle");
            return (Criteria) this;
        }

        public Criteria andSchedStyleBetween(String value1, String value2) {
            addCriterion("sched_style between", value1, value2, "schedStyle");
            return (Criteria) this;
        }

        public Criteria andSchedStyleNotBetween(String value1, String value2) {
            addCriterion("sched_style not between", value1, value2, "schedStyle");
            return (Criteria) this;
        }

        public Criteria andDateOfWeekIsNull() {
            addCriterion("date_of_week is null");
            return (Criteria) this;
        }

        public Criteria andDateOfWeekIsNotNull() {
            addCriterion("date_of_week is not null");
            return (Criteria) this;
        }

        public Criteria andDateOfWeekEqualTo(String value) {
            addCriterion("date_of_week =", value, "dateOfWeek");
            return (Criteria) this;
        }

        public Criteria andDateOfWeekNotEqualTo(String value) {
            addCriterion("date_of_week <>", value, "dateOfWeek");
            return (Criteria) this;
        }

        public Criteria andDateOfWeekGreaterThan(String value) {
            addCriterion("date_of_week >", value, "dateOfWeek");
            return (Criteria) this;
        }

        public Criteria andDateOfWeekGreaterThanOrEqualTo(String value) {
            addCriterion("date_of_week >=", value, "dateOfWeek");
            return (Criteria) this;
        }

        public Criteria andDateOfWeekLessThan(String value) {
            addCriterion("date_of_week <", value, "dateOfWeek");
            return (Criteria) this;
        }

        public Criteria andDateOfWeekLessThanOrEqualTo(String value) {
            addCriterion("date_of_week <=", value, "dateOfWeek");
            return (Criteria) this;
        }

        public Criteria andDateOfWeekLike(String value) {
            addCriterion("date_of_week like", value, "dateOfWeek");
            return (Criteria) this;
        }

        public Criteria andDateOfWeekNotLike(String value) {
            addCriterion("date_of_week not like", value, "dateOfWeek");
            return (Criteria) this;
        }

        public Criteria andDateOfWeekIn(List<String> values) {
            addCriterion("date_of_week in", values, "dateOfWeek");
            return (Criteria) this;
        }

        public Criteria andDateOfWeekNotIn(List<String> values) {
            addCriterion("date_of_week not in", values, "dateOfWeek");
            return (Criteria) this;
        }

        public Criteria andDateOfWeekBetween(String value1, String value2) {
            addCriterion("date_of_week between", value1, value2, "dateOfWeek");
            return (Criteria) this;
        }

        public Criteria andDateOfWeekNotBetween(String value1, String value2) {
            addCriterion("date_of_week not between", value1, value2, "dateOfWeek");
            return (Criteria) this;
        }

        public Criteria andEachMonthIsNull() {
            addCriterion("each_month is null");
            return (Criteria) this;
        }

        public Criteria andEachMonthIsNotNull() {
            addCriterion("each_month is not null");
            return (Criteria) this;
        }

        public Criteria andEachMonthEqualTo(String value) {
            addCriterion("each_month =", value, "eachMonth");
            return (Criteria) this;
        }

        public Criteria andEachMonthNotEqualTo(String value) {
            addCriterion("each_month <>", value, "eachMonth");
            return (Criteria) this;
        }

        public Criteria andEachMonthGreaterThan(String value) {
            addCriterion("each_month >", value, "eachMonth");
            return (Criteria) this;
        }

        public Criteria andEachMonthGreaterThanOrEqualTo(String value) {
            addCriterion("each_month >=", value, "eachMonth");
            return (Criteria) this;
        }

        public Criteria andEachMonthLessThan(String value) {
            addCriterion("each_month <", value, "eachMonth");
            return (Criteria) this;
        }

        public Criteria andEachMonthLessThanOrEqualTo(String value) {
            addCriterion("each_month <=", value, "eachMonth");
            return (Criteria) this;
        }

        public Criteria andEachMonthLike(String value) {
            addCriterion("each_month like", value, "eachMonth");
            return (Criteria) this;
        }

        public Criteria andEachMonthNotLike(String value) {
            addCriterion("each_month not like", value, "eachMonth");
            return (Criteria) this;
        }

        public Criteria andEachMonthIn(List<String> values) {
            addCriterion("each_month in", values, "eachMonth");
            return (Criteria) this;
        }

        public Criteria andEachMonthNotIn(List<String> values) {
            addCriterion("each_month not in", values, "eachMonth");
            return (Criteria) this;
        }

        public Criteria andEachMonthBetween(String value1, String value2) {
            addCriterion("each_month between", value1, value2, "eachMonth");
            return (Criteria) this;
        }

        public Criteria andEachMonthNotBetween(String value1, String value2) {
            addCriterion("each_month not between", value1, value2, "eachMonth");
            return (Criteria) this;
        }

        public Criteria andDateOfMonthIsNull() {
            addCriterion("date_of_month is null");
            return (Criteria) this;
        }

        public Criteria andDateOfMonthIsNotNull() {
            addCriterion("date_of_month is not null");
            return (Criteria) this;
        }

        public Criteria andDateOfMonthEqualTo(String value) {
            addCriterion("date_of_month =", value, "dateOfMonth");
            return (Criteria) this;
        }

        public Criteria andDateOfMonthNotEqualTo(String value) {
            addCriterion("date_of_month <>", value, "dateOfMonth");
            return (Criteria) this;
        }

        public Criteria andDateOfMonthGreaterThan(String value) {
            addCriterion("date_of_month >", value, "dateOfMonth");
            return (Criteria) this;
        }

        public Criteria andDateOfMonthGreaterThanOrEqualTo(String value) {
            addCriterion("date_of_month >=", value, "dateOfMonth");
            return (Criteria) this;
        }

        public Criteria andDateOfMonthLessThan(String value) {
            addCriterion("date_of_month <", value, "dateOfMonth");
            return (Criteria) this;
        }

        public Criteria andDateOfMonthLessThanOrEqualTo(String value) {
            addCriterion("date_of_month <=", value, "dateOfMonth");
            return (Criteria) this;
        }

        public Criteria andDateOfMonthLike(String value) {
            addCriterion("date_of_month like", value, "dateOfMonth");
            return (Criteria) this;
        }

        public Criteria andDateOfMonthNotLike(String value) {
            addCriterion("date_of_month not like", value, "dateOfMonth");
            return (Criteria) this;
        }

        public Criteria andDateOfMonthIn(List<String> values) {
            addCriterion("date_of_month in", values, "dateOfMonth");
            return (Criteria) this;
        }

        public Criteria andDateOfMonthNotIn(List<String> values) {
            addCriterion("date_of_month not in", values, "dateOfMonth");
            return (Criteria) this;
        }

        public Criteria andDateOfMonthBetween(String value1, String value2) {
            addCriterion("date_of_month between", value1, value2, "dateOfMonth");
            return (Criteria) this;
        }

        public Criteria andDateOfMonthNotBetween(String value1, String value2) {
            addCriterion("date_of_month not between", value1, value2, "dateOfMonth");
            return (Criteria) this;
        }

        public Criteria andWeekOfMonthIsNull() {
            addCriterion("week_of_month is null");
            return (Criteria) this;
        }

        public Criteria andWeekOfMonthIsNotNull() {
            addCriterion("week_of_month is not null");
            return (Criteria) this;
        }

        public Criteria andWeekOfMonthEqualTo(String value) {
            addCriterion("week_of_month =", value, "weekOfMonth");
            return (Criteria) this;
        }

        public Criteria andWeekOfMonthNotEqualTo(String value) {
            addCriterion("week_of_month <>", value, "weekOfMonth");
            return (Criteria) this;
        }

        public Criteria andWeekOfMonthGreaterThan(String value) {
            addCriterion("week_of_month >", value, "weekOfMonth");
            return (Criteria) this;
        }

        public Criteria andWeekOfMonthGreaterThanOrEqualTo(String value) {
            addCriterion("week_of_month >=", value, "weekOfMonth");
            return (Criteria) this;
        }

        public Criteria andWeekOfMonthLessThan(String value) {
            addCriterion("week_of_month <", value, "weekOfMonth");
            return (Criteria) this;
        }

        public Criteria andWeekOfMonthLessThanOrEqualTo(String value) {
            addCriterion("week_of_month <=", value, "weekOfMonth");
            return (Criteria) this;
        }

        public Criteria andWeekOfMonthLike(String value) {
            addCriterion("week_of_month like", value, "weekOfMonth");
            return (Criteria) this;
        }

        public Criteria andWeekOfMonthNotLike(String value) {
            addCriterion("week_of_month not like", value, "weekOfMonth");
            return (Criteria) this;
        }

        public Criteria andWeekOfMonthIn(List<String> values) {
            addCriterion("week_of_month in", values, "weekOfMonth");
            return (Criteria) this;
        }

        public Criteria andWeekOfMonthNotIn(List<String> values) {
            addCriterion("week_of_month not in", values, "weekOfMonth");
            return (Criteria) this;
        }

        public Criteria andWeekOfMonthBetween(String value1, String value2) {
            addCriterion("week_of_month between", value1, value2, "weekOfMonth");
            return (Criteria) this;
        }

        public Criteria andWeekOfMonthNotBetween(String value1, String value2) {
            addCriterion("week_of_month not between", value1, value2, "weekOfMonth");
            return (Criteria) this;
        }

        public Criteria andPerunitsIsNull() {
            addCriterion("perunits is null");
            return (Criteria) this;
        }

        public Criteria andPerunitsIsNotNull() {
            addCriterion("perunits is not null");
            return (Criteria) this;
        }

        public Criteria andPerunitsEqualTo(String value) {
            addCriterion("perunits =", value, "perunits");
            return (Criteria) this;
        }

        public Criteria andPerunitsNotEqualTo(String value) {
            addCriterion("perunits <>", value, "perunits");
            return (Criteria) this;
        }

        public Criteria andPerunitsGreaterThan(String value) {
            addCriterion("perunits >", value, "perunits");
            return (Criteria) this;
        }

        public Criteria andPerunitsGreaterThanOrEqualTo(String value) {
            addCriterion("perunits >=", value, "perunits");
            return (Criteria) this;
        }

        public Criteria andPerunitsLessThan(String value) {
            addCriterion("perunits <", value, "perunits");
            return (Criteria) this;
        }

        public Criteria andPerunitsLessThanOrEqualTo(String value) {
            addCriterion("perunits <=", value, "perunits");
            return (Criteria) this;
        }

        public Criteria andPerunitsLike(String value) {
            addCriterion("perunits like", value, "perunits");
            return (Criteria) this;
        }

        public Criteria andPerunitsNotLike(String value) {
            addCriterion("perunits not like", value, "perunits");
            return (Criteria) this;
        }

        public Criteria andPerunitsIn(List<String> values) {
            addCriterion("perunits in", values, "perunits");
            return (Criteria) this;
        }

        public Criteria andPerunitsNotIn(List<String> values) {
            addCriterion("perunits not in", values, "perunits");
            return (Criteria) this;
        }

        public Criteria andPerunitsBetween(String value1, String value2) {
            addCriterion("perunits between", value1, value2, "perunits");
            return (Criteria) this;
        }

        public Criteria andPerunitsNotBetween(String value1, String value2) {
            addCriterion("perunits not between", value1, value2, "perunits");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNull() {
            addCriterion("period is null");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNotNull() {
            addCriterion("period is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodEqualTo(Integer value) {
            addCriterion("period =", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotEqualTo(Integer value) {
            addCriterion("period <>", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThan(Integer value) {
            addCriterion("period >", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("period >=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThan(Integer value) {
            addCriterion("period <", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("period <=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodIn(List<Integer> values) {
            addCriterion("period in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotIn(List<Integer> values) {
            addCriterion("period not in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodBetween(Integer value1, Integer value2) {
            addCriterion("period between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("period not between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andBsrIsNull() {
            addCriterion("bsr is null");
            return (Criteria) this;
        }

        public Criteria andBsrIsNotNull() {
            addCriterion("bsr is not null");
            return (Criteria) this;
        }

        public Criteria andBsrEqualTo(String value) {
            addCriterion("bsr =", value, "bsr");
            return (Criteria) this;
        }

        public Criteria andBsrNotEqualTo(String value) {
            addCriterion("bsr <>", value, "bsr");
            return (Criteria) this;
        }

        public Criteria andBsrGreaterThan(String value) {
            addCriterion("bsr >", value, "bsr");
            return (Criteria) this;
        }

        public Criteria andBsrGreaterThanOrEqualTo(String value) {
            addCriterion("bsr >=", value, "bsr");
            return (Criteria) this;
        }

        public Criteria andBsrLessThan(String value) {
            addCriterion("bsr <", value, "bsr");
            return (Criteria) this;
        }

        public Criteria andBsrLessThanOrEqualTo(String value) {
            addCriterion("bsr <=", value, "bsr");
            return (Criteria) this;
        }

        public Criteria andBsrLike(String value) {
            addCriterion("bsr like", value, "bsr");
            return (Criteria) this;
        }

        public Criteria andBsrNotLike(String value) {
            addCriterion("bsr not like", value, "bsr");
            return (Criteria) this;
        }

        public Criteria andBsrIn(List<String> values) {
            addCriterion("bsr in", values, "bsr");
            return (Criteria) this;
        }

        public Criteria andBsrNotIn(List<String> values) {
            addCriterion("bsr not in", values, "bsr");
            return (Criteria) this;
        }

        public Criteria andBsrBetween(String value1, String value2) {
            addCriterion("bsr between", value1, value2, "bsr");
            return (Criteria) this;
        }

        public Criteria andBsrNotBetween(String value1, String value2) {
            addCriterion("bsr not between", value1, value2, "bsr");
            return (Criteria) this;
        }

        public Criteria andTotalScheduleIsNull() {
            addCriterion("total_schedule is null");
            return (Criteria) this;
        }

        public Criteria andTotalScheduleIsNotNull() {
            addCriterion("total_schedule is not null");
            return (Criteria) this;
        }

        public Criteria andTotalScheduleEqualTo(String value) {
            addCriterion("total_schedule =", value, "totalSchedule");
            return (Criteria) this;
        }

        public Criteria andTotalScheduleNotEqualTo(String value) {
            addCriterion("total_schedule <>", value, "totalSchedule");
            return (Criteria) this;
        }

        public Criteria andTotalScheduleGreaterThan(String value) {
            addCriterion("total_schedule >", value, "totalSchedule");
            return (Criteria) this;
        }

        public Criteria andTotalScheduleGreaterThanOrEqualTo(String value) {
            addCriterion("total_schedule >=", value, "totalSchedule");
            return (Criteria) this;
        }

        public Criteria andTotalScheduleLessThan(String value) {
            addCriterion("total_schedule <", value, "totalSchedule");
            return (Criteria) this;
        }

        public Criteria andTotalScheduleLessThanOrEqualTo(String value) {
            addCriterion("total_schedule <=", value, "totalSchedule");
            return (Criteria) this;
        }

        public Criteria andTotalScheduleLike(String value) {
            addCriterion("total_schedule like", value, "totalSchedule");
            return (Criteria) this;
        }

        public Criteria andTotalScheduleNotLike(String value) {
            addCriterion("total_schedule not like", value, "totalSchedule");
            return (Criteria) this;
        }

        public Criteria andTotalScheduleIn(List<String> values) {
            addCriterion("total_schedule in", values, "totalSchedule");
            return (Criteria) this;
        }

        public Criteria andTotalScheduleNotIn(List<String> values) {
            addCriterion("total_schedule not in", values, "totalSchedule");
            return (Criteria) this;
        }

        public Criteria andTotalScheduleBetween(String value1, String value2) {
            addCriterion("total_schedule between", value1, value2, "totalSchedule");
            return (Criteria) this;
        }

        public Criteria andTotalScheduleNotBetween(String value1, String value2) {
            addCriterion("total_schedule not between", value1, value2, "totalSchedule");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessfulIsNull() {
            addCriterion("total_successful is null");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessfulIsNotNull() {
            addCriterion("total_successful is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessfulEqualTo(String value) {
            addCriterion("total_successful =", value, "totalSuccessful");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessfulNotEqualTo(String value) {
            addCriterion("total_successful <>", value, "totalSuccessful");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessfulGreaterThan(String value) {
            addCriterion("total_successful >", value, "totalSuccessful");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessfulGreaterThanOrEqualTo(String value) {
            addCriterion("total_successful >=", value, "totalSuccessful");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessfulLessThan(String value) {
            addCriterion("total_successful <", value, "totalSuccessful");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessfulLessThanOrEqualTo(String value) {
            addCriterion("total_successful <=", value, "totalSuccessful");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessfulLike(String value) {
            addCriterion("total_successful like", value, "totalSuccessful");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessfulNotLike(String value) {
            addCriterion("total_successful not like", value, "totalSuccessful");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessfulIn(List<String> values) {
            addCriterion("total_successful in", values, "totalSuccessful");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessfulNotIn(List<String> values) {
            addCriterion("total_successful not in", values, "totalSuccessful");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessfulBetween(String value1, String value2) {
            addCriterion("total_successful between", value1, value2, "totalSuccessful");
            return (Criteria) this;
        }

        public Criteria andTotalSuccessfulNotBetween(String value1, String value2) {
            addCriterion("total_successful not between", value1, value2, "totalSuccessful");
            return (Criteria) this;
        }

        public Criteria andDay011IsNull() {
            addCriterion("day_01_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay011IsNotNull() {
            addCriterion("day_01_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay011EqualTo(String value) {
            addCriterion("day_01_1 =", value, "day011");
            return (Criteria) this;
        }

        public Criteria andDay011NotEqualTo(String value) {
            addCriterion("day_01_1 <>", value, "day011");
            return (Criteria) this;
        }

        public Criteria andDay011GreaterThan(String value) {
            addCriterion("day_01_1 >", value, "day011");
            return (Criteria) this;
        }

        public Criteria andDay011GreaterThanOrEqualTo(String value) {
            addCriterion("day_01_1 >=", value, "day011");
            return (Criteria) this;
        }

        public Criteria andDay011LessThan(String value) {
            addCriterion("day_01_1 <", value, "day011");
            return (Criteria) this;
        }

        public Criteria andDay011LessThanOrEqualTo(String value) {
            addCriterion("day_01_1 <=", value, "day011");
            return (Criteria) this;
        }

        public Criteria andDay011Like(String value) {
            addCriterion("day_01_1 like", value, "day011");
            return (Criteria) this;
        }

        public Criteria andDay011NotLike(String value) {
            addCriterion("day_01_1 not like", value, "day011");
            return (Criteria) this;
        }

        public Criteria andDay011In(List<String> values) {
            addCriterion("day_01_1 in", values, "day011");
            return (Criteria) this;
        }

        public Criteria andDay011NotIn(List<String> values) {
            addCriterion("day_01_1 not in", values, "day011");
            return (Criteria) this;
        }

        public Criteria andDay011Between(String value1, String value2) {
            addCriterion("day_01_1 between", value1, value2, "day011");
            return (Criteria) this;
        }

        public Criteria andDay011NotBetween(String value1, String value2) {
            addCriterion("day_01_1 not between", value1, value2, "day011");
            return (Criteria) this;
        }

        public Criteria andDay012IsNull() {
            addCriterion("day_01_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay012IsNotNull() {
            addCriterion("day_01_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay012EqualTo(String value) {
            addCriterion("day_01_2 =", value, "day012");
            return (Criteria) this;
        }

        public Criteria andDay012NotEqualTo(String value) {
            addCriterion("day_01_2 <>", value, "day012");
            return (Criteria) this;
        }

        public Criteria andDay012GreaterThan(String value) {
            addCriterion("day_01_2 >", value, "day012");
            return (Criteria) this;
        }

        public Criteria andDay012GreaterThanOrEqualTo(String value) {
            addCriterion("day_01_2 >=", value, "day012");
            return (Criteria) this;
        }

        public Criteria andDay012LessThan(String value) {
            addCriterion("day_01_2 <", value, "day012");
            return (Criteria) this;
        }

        public Criteria andDay012LessThanOrEqualTo(String value) {
            addCriterion("day_01_2 <=", value, "day012");
            return (Criteria) this;
        }

        public Criteria andDay012Like(String value) {
            addCriterion("day_01_2 like", value, "day012");
            return (Criteria) this;
        }

        public Criteria andDay012NotLike(String value) {
            addCriterion("day_01_2 not like", value, "day012");
            return (Criteria) this;
        }

        public Criteria andDay012In(List<String> values) {
            addCriterion("day_01_2 in", values, "day012");
            return (Criteria) this;
        }

        public Criteria andDay012NotIn(List<String> values) {
            addCriterion("day_01_2 not in", values, "day012");
            return (Criteria) this;
        }

        public Criteria andDay012Between(String value1, String value2) {
            addCriterion("day_01_2 between", value1, value2, "day012");
            return (Criteria) this;
        }

        public Criteria andDay012NotBetween(String value1, String value2) {
            addCriterion("day_01_2 not between", value1, value2, "day012");
            return (Criteria) this;
        }

        public Criteria andDay021IsNull() {
            addCriterion("day_02_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay021IsNotNull() {
            addCriterion("day_02_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay021EqualTo(String value) {
            addCriterion("day_02_1 =", value, "day021");
            return (Criteria) this;
        }

        public Criteria andDay021NotEqualTo(String value) {
            addCriterion("day_02_1 <>", value, "day021");
            return (Criteria) this;
        }

        public Criteria andDay021GreaterThan(String value) {
            addCriterion("day_02_1 >", value, "day021");
            return (Criteria) this;
        }

        public Criteria andDay021GreaterThanOrEqualTo(String value) {
            addCriterion("day_02_1 >=", value, "day021");
            return (Criteria) this;
        }

        public Criteria andDay021LessThan(String value) {
            addCriterion("day_02_1 <", value, "day021");
            return (Criteria) this;
        }

        public Criteria andDay021LessThanOrEqualTo(String value) {
            addCriterion("day_02_1 <=", value, "day021");
            return (Criteria) this;
        }

        public Criteria andDay021Like(String value) {
            addCriterion("day_02_1 like", value, "day021");
            return (Criteria) this;
        }

        public Criteria andDay021NotLike(String value) {
            addCriterion("day_02_1 not like", value, "day021");
            return (Criteria) this;
        }

        public Criteria andDay021In(List<String> values) {
            addCriterion("day_02_1 in", values, "day021");
            return (Criteria) this;
        }

        public Criteria andDay021NotIn(List<String> values) {
            addCriterion("day_02_1 not in", values, "day021");
            return (Criteria) this;
        }

        public Criteria andDay021Between(String value1, String value2) {
            addCriterion("day_02_1 between", value1, value2, "day021");
            return (Criteria) this;
        }

        public Criteria andDay021NotBetween(String value1, String value2) {
            addCriterion("day_02_1 not between", value1, value2, "day021");
            return (Criteria) this;
        }

        public Criteria andDay022IsNull() {
            addCriterion("day_02_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay022IsNotNull() {
            addCriterion("day_02_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay022EqualTo(String value) {
            addCriterion("day_02_2 =", value, "day022");
            return (Criteria) this;
        }

        public Criteria andDay022NotEqualTo(String value) {
            addCriterion("day_02_2 <>", value, "day022");
            return (Criteria) this;
        }

        public Criteria andDay022GreaterThan(String value) {
            addCriterion("day_02_2 >", value, "day022");
            return (Criteria) this;
        }

        public Criteria andDay022GreaterThanOrEqualTo(String value) {
            addCriterion("day_02_2 >=", value, "day022");
            return (Criteria) this;
        }

        public Criteria andDay022LessThan(String value) {
            addCriterion("day_02_2 <", value, "day022");
            return (Criteria) this;
        }

        public Criteria andDay022LessThanOrEqualTo(String value) {
            addCriterion("day_02_2 <=", value, "day022");
            return (Criteria) this;
        }

        public Criteria andDay022Like(String value) {
            addCriterion("day_02_2 like", value, "day022");
            return (Criteria) this;
        }

        public Criteria andDay022NotLike(String value) {
            addCriterion("day_02_2 not like", value, "day022");
            return (Criteria) this;
        }

        public Criteria andDay022In(List<String> values) {
            addCriterion("day_02_2 in", values, "day022");
            return (Criteria) this;
        }

        public Criteria andDay022NotIn(List<String> values) {
            addCriterion("day_02_2 not in", values, "day022");
            return (Criteria) this;
        }

        public Criteria andDay022Between(String value1, String value2) {
            addCriterion("day_02_2 between", value1, value2, "day022");
            return (Criteria) this;
        }

        public Criteria andDay022NotBetween(String value1, String value2) {
            addCriterion("day_02_2 not between", value1, value2, "day022");
            return (Criteria) this;
        }

        public Criteria andDay031IsNull() {
            addCriterion("day_03_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay031IsNotNull() {
            addCriterion("day_03_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay031EqualTo(String value) {
            addCriterion("day_03_1 =", value, "day031");
            return (Criteria) this;
        }

        public Criteria andDay031NotEqualTo(String value) {
            addCriterion("day_03_1 <>", value, "day031");
            return (Criteria) this;
        }

        public Criteria andDay031GreaterThan(String value) {
            addCriterion("day_03_1 >", value, "day031");
            return (Criteria) this;
        }

        public Criteria andDay031GreaterThanOrEqualTo(String value) {
            addCriterion("day_03_1 >=", value, "day031");
            return (Criteria) this;
        }

        public Criteria andDay031LessThan(String value) {
            addCriterion("day_03_1 <", value, "day031");
            return (Criteria) this;
        }

        public Criteria andDay031LessThanOrEqualTo(String value) {
            addCriterion("day_03_1 <=", value, "day031");
            return (Criteria) this;
        }

        public Criteria andDay031Like(String value) {
            addCriterion("day_03_1 like", value, "day031");
            return (Criteria) this;
        }

        public Criteria andDay031NotLike(String value) {
            addCriterion("day_03_1 not like", value, "day031");
            return (Criteria) this;
        }

        public Criteria andDay031In(List<String> values) {
            addCriterion("day_03_1 in", values, "day031");
            return (Criteria) this;
        }

        public Criteria andDay031NotIn(List<String> values) {
            addCriterion("day_03_1 not in", values, "day031");
            return (Criteria) this;
        }

        public Criteria andDay031Between(String value1, String value2) {
            addCriterion("day_03_1 between", value1, value2, "day031");
            return (Criteria) this;
        }

        public Criteria andDay031NotBetween(String value1, String value2) {
            addCriterion("day_03_1 not between", value1, value2, "day031");
            return (Criteria) this;
        }

        public Criteria andDay032IsNull() {
            addCriterion("day_03_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay032IsNotNull() {
            addCriterion("day_03_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay032EqualTo(String value) {
            addCriterion("day_03_2 =", value, "day032");
            return (Criteria) this;
        }

        public Criteria andDay032NotEqualTo(String value) {
            addCriterion("day_03_2 <>", value, "day032");
            return (Criteria) this;
        }

        public Criteria andDay032GreaterThan(String value) {
            addCriterion("day_03_2 >", value, "day032");
            return (Criteria) this;
        }

        public Criteria andDay032GreaterThanOrEqualTo(String value) {
            addCriterion("day_03_2 >=", value, "day032");
            return (Criteria) this;
        }

        public Criteria andDay032LessThan(String value) {
            addCriterion("day_03_2 <", value, "day032");
            return (Criteria) this;
        }

        public Criteria andDay032LessThanOrEqualTo(String value) {
            addCriterion("day_03_2 <=", value, "day032");
            return (Criteria) this;
        }

        public Criteria andDay032Like(String value) {
            addCriterion("day_03_2 like", value, "day032");
            return (Criteria) this;
        }

        public Criteria andDay032NotLike(String value) {
            addCriterion("day_03_2 not like", value, "day032");
            return (Criteria) this;
        }

        public Criteria andDay032In(List<String> values) {
            addCriterion("day_03_2 in", values, "day032");
            return (Criteria) this;
        }

        public Criteria andDay032NotIn(List<String> values) {
            addCriterion("day_03_2 not in", values, "day032");
            return (Criteria) this;
        }

        public Criteria andDay032Between(String value1, String value2) {
            addCriterion("day_03_2 between", value1, value2, "day032");
            return (Criteria) this;
        }

        public Criteria andDay032NotBetween(String value1, String value2) {
            addCriterion("day_03_2 not between", value1, value2, "day032");
            return (Criteria) this;
        }

        public Criteria andDay041IsNull() {
            addCriterion("day_04_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay041IsNotNull() {
            addCriterion("day_04_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay041EqualTo(String value) {
            addCriterion("day_04_1 =", value, "day041");
            return (Criteria) this;
        }

        public Criteria andDay041NotEqualTo(String value) {
            addCriterion("day_04_1 <>", value, "day041");
            return (Criteria) this;
        }

        public Criteria andDay041GreaterThan(String value) {
            addCriterion("day_04_1 >", value, "day041");
            return (Criteria) this;
        }

        public Criteria andDay041GreaterThanOrEqualTo(String value) {
            addCriterion("day_04_1 >=", value, "day041");
            return (Criteria) this;
        }

        public Criteria andDay041LessThan(String value) {
            addCriterion("day_04_1 <", value, "day041");
            return (Criteria) this;
        }

        public Criteria andDay041LessThanOrEqualTo(String value) {
            addCriterion("day_04_1 <=", value, "day041");
            return (Criteria) this;
        }

        public Criteria andDay041Like(String value) {
            addCriterion("day_04_1 like", value, "day041");
            return (Criteria) this;
        }

        public Criteria andDay041NotLike(String value) {
            addCriterion("day_04_1 not like", value, "day041");
            return (Criteria) this;
        }

        public Criteria andDay041In(List<String> values) {
            addCriterion("day_04_1 in", values, "day041");
            return (Criteria) this;
        }

        public Criteria andDay041NotIn(List<String> values) {
            addCriterion("day_04_1 not in", values, "day041");
            return (Criteria) this;
        }

        public Criteria andDay041Between(String value1, String value2) {
            addCriterion("day_04_1 between", value1, value2, "day041");
            return (Criteria) this;
        }

        public Criteria andDay041NotBetween(String value1, String value2) {
            addCriterion("day_04_1 not between", value1, value2, "day041");
            return (Criteria) this;
        }

        public Criteria andDay042IsNull() {
            addCriterion("day_04_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay042IsNotNull() {
            addCriterion("day_04_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay042EqualTo(String value) {
            addCriterion("day_04_2 =", value, "day042");
            return (Criteria) this;
        }

        public Criteria andDay042NotEqualTo(String value) {
            addCriterion("day_04_2 <>", value, "day042");
            return (Criteria) this;
        }

        public Criteria andDay042GreaterThan(String value) {
            addCriterion("day_04_2 >", value, "day042");
            return (Criteria) this;
        }

        public Criteria andDay042GreaterThanOrEqualTo(String value) {
            addCriterion("day_04_2 >=", value, "day042");
            return (Criteria) this;
        }

        public Criteria andDay042LessThan(String value) {
            addCriterion("day_04_2 <", value, "day042");
            return (Criteria) this;
        }

        public Criteria andDay042LessThanOrEqualTo(String value) {
            addCriterion("day_04_2 <=", value, "day042");
            return (Criteria) this;
        }

        public Criteria andDay042Like(String value) {
            addCriterion("day_04_2 like", value, "day042");
            return (Criteria) this;
        }

        public Criteria andDay042NotLike(String value) {
            addCriterion("day_04_2 not like", value, "day042");
            return (Criteria) this;
        }

        public Criteria andDay042In(List<String> values) {
            addCriterion("day_04_2 in", values, "day042");
            return (Criteria) this;
        }

        public Criteria andDay042NotIn(List<String> values) {
            addCriterion("day_04_2 not in", values, "day042");
            return (Criteria) this;
        }

        public Criteria andDay042Between(String value1, String value2) {
            addCriterion("day_04_2 between", value1, value2, "day042");
            return (Criteria) this;
        }

        public Criteria andDay042NotBetween(String value1, String value2) {
            addCriterion("day_04_2 not between", value1, value2, "day042");
            return (Criteria) this;
        }

        public Criteria andDay051IsNull() {
            addCriterion("day_05_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay051IsNotNull() {
            addCriterion("day_05_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay051EqualTo(String value) {
            addCriterion("day_05_1 =", value, "day051");
            return (Criteria) this;
        }

        public Criteria andDay051NotEqualTo(String value) {
            addCriterion("day_05_1 <>", value, "day051");
            return (Criteria) this;
        }

        public Criteria andDay051GreaterThan(String value) {
            addCriterion("day_05_1 >", value, "day051");
            return (Criteria) this;
        }

        public Criteria andDay051GreaterThanOrEqualTo(String value) {
            addCriterion("day_05_1 >=", value, "day051");
            return (Criteria) this;
        }

        public Criteria andDay051LessThan(String value) {
            addCriterion("day_05_1 <", value, "day051");
            return (Criteria) this;
        }

        public Criteria andDay051LessThanOrEqualTo(String value) {
            addCriterion("day_05_1 <=", value, "day051");
            return (Criteria) this;
        }

        public Criteria andDay051Like(String value) {
            addCriterion("day_05_1 like", value, "day051");
            return (Criteria) this;
        }

        public Criteria andDay051NotLike(String value) {
            addCriterion("day_05_1 not like", value, "day051");
            return (Criteria) this;
        }

        public Criteria andDay051In(List<String> values) {
            addCriterion("day_05_1 in", values, "day051");
            return (Criteria) this;
        }

        public Criteria andDay051NotIn(List<String> values) {
            addCriterion("day_05_1 not in", values, "day051");
            return (Criteria) this;
        }

        public Criteria andDay051Between(String value1, String value2) {
            addCriterion("day_05_1 between", value1, value2, "day051");
            return (Criteria) this;
        }

        public Criteria andDay051NotBetween(String value1, String value2) {
            addCriterion("day_05_1 not between", value1, value2, "day051");
            return (Criteria) this;
        }

        public Criteria andDay052IsNull() {
            addCriterion("day_05_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay052IsNotNull() {
            addCriterion("day_05_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay052EqualTo(String value) {
            addCriterion("day_05_2 =", value, "day052");
            return (Criteria) this;
        }

        public Criteria andDay052NotEqualTo(String value) {
            addCriterion("day_05_2 <>", value, "day052");
            return (Criteria) this;
        }

        public Criteria andDay052GreaterThan(String value) {
            addCriterion("day_05_2 >", value, "day052");
            return (Criteria) this;
        }

        public Criteria andDay052GreaterThanOrEqualTo(String value) {
            addCriterion("day_05_2 >=", value, "day052");
            return (Criteria) this;
        }

        public Criteria andDay052LessThan(String value) {
            addCriterion("day_05_2 <", value, "day052");
            return (Criteria) this;
        }

        public Criteria andDay052LessThanOrEqualTo(String value) {
            addCriterion("day_05_2 <=", value, "day052");
            return (Criteria) this;
        }

        public Criteria andDay052Like(String value) {
            addCriterion("day_05_2 like", value, "day052");
            return (Criteria) this;
        }

        public Criteria andDay052NotLike(String value) {
            addCriterion("day_05_2 not like", value, "day052");
            return (Criteria) this;
        }

        public Criteria andDay052In(List<String> values) {
            addCriterion("day_05_2 in", values, "day052");
            return (Criteria) this;
        }

        public Criteria andDay052NotIn(List<String> values) {
            addCriterion("day_05_2 not in", values, "day052");
            return (Criteria) this;
        }

        public Criteria andDay052Between(String value1, String value2) {
            addCriterion("day_05_2 between", value1, value2, "day052");
            return (Criteria) this;
        }

        public Criteria andDay052NotBetween(String value1, String value2) {
            addCriterion("day_05_2 not between", value1, value2, "day052");
            return (Criteria) this;
        }

        public Criteria andDay061IsNull() {
            addCriterion("day_06_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay061IsNotNull() {
            addCriterion("day_06_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay061EqualTo(String value) {
            addCriterion("day_06_1 =", value, "day061");
            return (Criteria) this;
        }

        public Criteria andDay061NotEqualTo(String value) {
            addCriterion("day_06_1 <>", value, "day061");
            return (Criteria) this;
        }

        public Criteria andDay061GreaterThan(String value) {
            addCriterion("day_06_1 >", value, "day061");
            return (Criteria) this;
        }

        public Criteria andDay061GreaterThanOrEqualTo(String value) {
            addCriterion("day_06_1 >=", value, "day061");
            return (Criteria) this;
        }

        public Criteria andDay061LessThan(String value) {
            addCriterion("day_06_1 <", value, "day061");
            return (Criteria) this;
        }

        public Criteria andDay061LessThanOrEqualTo(String value) {
            addCriterion("day_06_1 <=", value, "day061");
            return (Criteria) this;
        }

        public Criteria andDay061Like(String value) {
            addCriterion("day_06_1 like", value, "day061");
            return (Criteria) this;
        }

        public Criteria andDay061NotLike(String value) {
            addCriterion("day_06_1 not like", value, "day061");
            return (Criteria) this;
        }

        public Criteria andDay061In(List<String> values) {
            addCriterion("day_06_1 in", values, "day061");
            return (Criteria) this;
        }

        public Criteria andDay061NotIn(List<String> values) {
            addCriterion("day_06_1 not in", values, "day061");
            return (Criteria) this;
        }

        public Criteria andDay061Between(String value1, String value2) {
            addCriterion("day_06_1 between", value1, value2, "day061");
            return (Criteria) this;
        }

        public Criteria andDay061NotBetween(String value1, String value2) {
            addCriterion("day_06_1 not between", value1, value2, "day061");
            return (Criteria) this;
        }

        public Criteria andDay062IsNull() {
            addCriterion("day_06_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay062IsNotNull() {
            addCriterion("day_06_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay062EqualTo(String value) {
            addCriterion("day_06_2 =", value, "day062");
            return (Criteria) this;
        }

        public Criteria andDay062NotEqualTo(String value) {
            addCriterion("day_06_2 <>", value, "day062");
            return (Criteria) this;
        }

        public Criteria andDay062GreaterThan(String value) {
            addCriterion("day_06_2 >", value, "day062");
            return (Criteria) this;
        }

        public Criteria andDay062GreaterThanOrEqualTo(String value) {
            addCriterion("day_06_2 >=", value, "day062");
            return (Criteria) this;
        }

        public Criteria andDay062LessThan(String value) {
            addCriterion("day_06_2 <", value, "day062");
            return (Criteria) this;
        }

        public Criteria andDay062LessThanOrEqualTo(String value) {
            addCriterion("day_06_2 <=", value, "day062");
            return (Criteria) this;
        }

        public Criteria andDay062Like(String value) {
            addCriterion("day_06_2 like", value, "day062");
            return (Criteria) this;
        }

        public Criteria andDay062NotLike(String value) {
            addCriterion("day_06_2 not like", value, "day062");
            return (Criteria) this;
        }

        public Criteria andDay062In(List<String> values) {
            addCriterion("day_06_2 in", values, "day062");
            return (Criteria) this;
        }

        public Criteria andDay062NotIn(List<String> values) {
            addCriterion("day_06_2 not in", values, "day062");
            return (Criteria) this;
        }

        public Criteria andDay062Between(String value1, String value2) {
            addCriterion("day_06_2 between", value1, value2, "day062");
            return (Criteria) this;
        }

        public Criteria andDay062NotBetween(String value1, String value2) {
            addCriterion("day_06_2 not between", value1, value2, "day062");
            return (Criteria) this;
        }

        public Criteria andDay071IsNull() {
            addCriterion("day_07_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay071IsNotNull() {
            addCriterion("day_07_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay071EqualTo(String value) {
            addCriterion("day_07_1 =", value, "day071");
            return (Criteria) this;
        }

        public Criteria andDay071NotEqualTo(String value) {
            addCriterion("day_07_1 <>", value, "day071");
            return (Criteria) this;
        }

        public Criteria andDay071GreaterThan(String value) {
            addCriterion("day_07_1 >", value, "day071");
            return (Criteria) this;
        }

        public Criteria andDay071GreaterThanOrEqualTo(String value) {
            addCriterion("day_07_1 >=", value, "day071");
            return (Criteria) this;
        }

        public Criteria andDay071LessThan(String value) {
            addCriterion("day_07_1 <", value, "day071");
            return (Criteria) this;
        }

        public Criteria andDay071LessThanOrEqualTo(String value) {
            addCriterion("day_07_1 <=", value, "day071");
            return (Criteria) this;
        }

        public Criteria andDay071Like(String value) {
            addCriterion("day_07_1 like", value, "day071");
            return (Criteria) this;
        }

        public Criteria andDay071NotLike(String value) {
            addCriterion("day_07_1 not like", value, "day071");
            return (Criteria) this;
        }

        public Criteria andDay071In(List<String> values) {
            addCriterion("day_07_1 in", values, "day071");
            return (Criteria) this;
        }

        public Criteria andDay071NotIn(List<String> values) {
            addCriterion("day_07_1 not in", values, "day071");
            return (Criteria) this;
        }

        public Criteria andDay071Between(String value1, String value2) {
            addCriterion("day_07_1 between", value1, value2, "day071");
            return (Criteria) this;
        }

        public Criteria andDay071NotBetween(String value1, String value2) {
            addCriterion("day_07_1 not between", value1, value2, "day071");
            return (Criteria) this;
        }

        public Criteria andDay072IsNull() {
            addCriterion("day_07_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay072IsNotNull() {
            addCriterion("day_07_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay072EqualTo(String value) {
            addCriterion("day_07_2 =", value, "day072");
            return (Criteria) this;
        }

        public Criteria andDay072NotEqualTo(String value) {
            addCriterion("day_07_2 <>", value, "day072");
            return (Criteria) this;
        }

        public Criteria andDay072GreaterThan(String value) {
            addCriterion("day_07_2 >", value, "day072");
            return (Criteria) this;
        }

        public Criteria andDay072GreaterThanOrEqualTo(String value) {
            addCriterion("day_07_2 >=", value, "day072");
            return (Criteria) this;
        }

        public Criteria andDay072LessThan(String value) {
            addCriterion("day_07_2 <", value, "day072");
            return (Criteria) this;
        }

        public Criteria andDay072LessThanOrEqualTo(String value) {
            addCriterion("day_07_2 <=", value, "day072");
            return (Criteria) this;
        }

        public Criteria andDay072Like(String value) {
            addCriterion("day_07_2 like", value, "day072");
            return (Criteria) this;
        }

        public Criteria andDay072NotLike(String value) {
            addCriterion("day_07_2 not like", value, "day072");
            return (Criteria) this;
        }

        public Criteria andDay072In(List<String> values) {
            addCriterion("day_07_2 in", values, "day072");
            return (Criteria) this;
        }

        public Criteria andDay072NotIn(List<String> values) {
            addCriterion("day_07_2 not in", values, "day072");
            return (Criteria) this;
        }

        public Criteria andDay072Between(String value1, String value2) {
            addCriterion("day_07_2 between", value1, value2, "day072");
            return (Criteria) this;
        }

        public Criteria andDay072NotBetween(String value1, String value2) {
            addCriterion("day_07_2 not between", value1, value2, "day072");
            return (Criteria) this;
        }

        public Criteria andDay081IsNull() {
            addCriterion("day_08_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay081IsNotNull() {
            addCriterion("day_08_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay081EqualTo(String value) {
            addCriterion("day_08_1 =", value, "day081");
            return (Criteria) this;
        }

        public Criteria andDay081NotEqualTo(String value) {
            addCriterion("day_08_1 <>", value, "day081");
            return (Criteria) this;
        }

        public Criteria andDay081GreaterThan(String value) {
            addCriterion("day_08_1 >", value, "day081");
            return (Criteria) this;
        }

        public Criteria andDay081GreaterThanOrEqualTo(String value) {
            addCriterion("day_08_1 >=", value, "day081");
            return (Criteria) this;
        }

        public Criteria andDay081LessThan(String value) {
            addCriterion("day_08_1 <", value, "day081");
            return (Criteria) this;
        }

        public Criteria andDay081LessThanOrEqualTo(String value) {
            addCriterion("day_08_1 <=", value, "day081");
            return (Criteria) this;
        }

        public Criteria andDay081Like(String value) {
            addCriterion("day_08_1 like", value, "day081");
            return (Criteria) this;
        }

        public Criteria andDay081NotLike(String value) {
            addCriterion("day_08_1 not like", value, "day081");
            return (Criteria) this;
        }

        public Criteria andDay081In(List<String> values) {
            addCriterion("day_08_1 in", values, "day081");
            return (Criteria) this;
        }

        public Criteria andDay081NotIn(List<String> values) {
            addCriterion("day_08_1 not in", values, "day081");
            return (Criteria) this;
        }

        public Criteria andDay081Between(String value1, String value2) {
            addCriterion("day_08_1 between", value1, value2, "day081");
            return (Criteria) this;
        }

        public Criteria andDay081NotBetween(String value1, String value2) {
            addCriterion("day_08_1 not between", value1, value2, "day081");
            return (Criteria) this;
        }

        public Criteria andDay082IsNull() {
            addCriterion("day_08_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay082IsNotNull() {
            addCriterion("day_08_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay082EqualTo(String value) {
            addCriterion("day_08_2 =", value, "day082");
            return (Criteria) this;
        }

        public Criteria andDay082NotEqualTo(String value) {
            addCriterion("day_08_2 <>", value, "day082");
            return (Criteria) this;
        }

        public Criteria andDay082GreaterThan(String value) {
            addCriterion("day_08_2 >", value, "day082");
            return (Criteria) this;
        }

        public Criteria andDay082GreaterThanOrEqualTo(String value) {
            addCriterion("day_08_2 >=", value, "day082");
            return (Criteria) this;
        }

        public Criteria andDay082LessThan(String value) {
            addCriterion("day_08_2 <", value, "day082");
            return (Criteria) this;
        }

        public Criteria andDay082LessThanOrEqualTo(String value) {
            addCriterion("day_08_2 <=", value, "day082");
            return (Criteria) this;
        }

        public Criteria andDay082Like(String value) {
            addCriterion("day_08_2 like", value, "day082");
            return (Criteria) this;
        }

        public Criteria andDay082NotLike(String value) {
            addCriterion("day_08_2 not like", value, "day082");
            return (Criteria) this;
        }

        public Criteria andDay082In(List<String> values) {
            addCriterion("day_08_2 in", values, "day082");
            return (Criteria) this;
        }

        public Criteria andDay082NotIn(List<String> values) {
            addCriterion("day_08_2 not in", values, "day082");
            return (Criteria) this;
        }

        public Criteria andDay082Between(String value1, String value2) {
            addCriterion("day_08_2 between", value1, value2, "day082");
            return (Criteria) this;
        }

        public Criteria andDay082NotBetween(String value1, String value2) {
            addCriterion("day_08_2 not between", value1, value2, "day082");
            return (Criteria) this;
        }

        public Criteria andDay091IsNull() {
            addCriterion("day_09_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay091IsNotNull() {
            addCriterion("day_09_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay091EqualTo(String value) {
            addCriterion("day_09_1 =", value, "day091");
            return (Criteria) this;
        }

        public Criteria andDay091NotEqualTo(String value) {
            addCriterion("day_09_1 <>", value, "day091");
            return (Criteria) this;
        }

        public Criteria andDay091GreaterThan(String value) {
            addCriterion("day_09_1 >", value, "day091");
            return (Criteria) this;
        }

        public Criteria andDay091GreaterThanOrEqualTo(String value) {
            addCriterion("day_09_1 >=", value, "day091");
            return (Criteria) this;
        }

        public Criteria andDay091LessThan(String value) {
            addCriterion("day_09_1 <", value, "day091");
            return (Criteria) this;
        }

        public Criteria andDay091LessThanOrEqualTo(String value) {
            addCriterion("day_09_1 <=", value, "day091");
            return (Criteria) this;
        }

        public Criteria andDay091Like(String value) {
            addCriterion("day_09_1 like", value, "day091");
            return (Criteria) this;
        }

        public Criteria andDay091NotLike(String value) {
            addCriterion("day_09_1 not like", value, "day091");
            return (Criteria) this;
        }

        public Criteria andDay091In(List<String> values) {
            addCriterion("day_09_1 in", values, "day091");
            return (Criteria) this;
        }

        public Criteria andDay091NotIn(List<String> values) {
            addCriterion("day_09_1 not in", values, "day091");
            return (Criteria) this;
        }

        public Criteria andDay091Between(String value1, String value2) {
            addCriterion("day_09_1 between", value1, value2, "day091");
            return (Criteria) this;
        }

        public Criteria andDay091NotBetween(String value1, String value2) {
            addCriterion("day_09_1 not between", value1, value2, "day091");
            return (Criteria) this;
        }

        public Criteria andDay092IsNull() {
            addCriterion("day_09_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay092IsNotNull() {
            addCriterion("day_09_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay092EqualTo(String value) {
            addCriterion("day_09_2 =", value, "day092");
            return (Criteria) this;
        }

        public Criteria andDay092NotEqualTo(String value) {
            addCriterion("day_09_2 <>", value, "day092");
            return (Criteria) this;
        }

        public Criteria andDay092GreaterThan(String value) {
            addCriterion("day_09_2 >", value, "day092");
            return (Criteria) this;
        }

        public Criteria andDay092GreaterThanOrEqualTo(String value) {
            addCriterion("day_09_2 >=", value, "day092");
            return (Criteria) this;
        }

        public Criteria andDay092LessThan(String value) {
            addCriterion("day_09_2 <", value, "day092");
            return (Criteria) this;
        }

        public Criteria andDay092LessThanOrEqualTo(String value) {
            addCriterion("day_09_2 <=", value, "day092");
            return (Criteria) this;
        }

        public Criteria andDay092Like(String value) {
            addCriterion("day_09_2 like", value, "day092");
            return (Criteria) this;
        }

        public Criteria andDay092NotLike(String value) {
            addCriterion("day_09_2 not like", value, "day092");
            return (Criteria) this;
        }

        public Criteria andDay092In(List<String> values) {
            addCriterion("day_09_2 in", values, "day092");
            return (Criteria) this;
        }

        public Criteria andDay092NotIn(List<String> values) {
            addCriterion("day_09_2 not in", values, "day092");
            return (Criteria) this;
        }

        public Criteria andDay092Between(String value1, String value2) {
            addCriterion("day_09_2 between", value1, value2, "day092");
            return (Criteria) this;
        }

        public Criteria andDay092NotBetween(String value1, String value2) {
            addCriterion("day_09_2 not between", value1, value2, "day092");
            return (Criteria) this;
        }

        public Criteria andDay101IsNull() {
            addCriterion("day_10_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay101IsNotNull() {
            addCriterion("day_10_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay101EqualTo(String value) {
            addCriterion("day_10_1 =", value, "day101");
            return (Criteria) this;
        }

        public Criteria andDay101NotEqualTo(String value) {
            addCriterion("day_10_1 <>", value, "day101");
            return (Criteria) this;
        }

        public Criteria andDay101GreaterThan(String value) {
            addCriterion("day_10_1 >", value, "day101");
            return (Criteria) this;
        }

        public Criteria andDay101GreaterThanOrEqualTo(String value) {
            addCriterion("day_10_1 >=", value, "day101");
            return (Criteria) this;
        }

        public Criteria andDay101LessThan(String value) {
            addCriterion("day_10_1 <", value, "day101");
            return (Criteria) this;
        }

        public Criteria andDay101LessThanOrEqualTo(String value) {
            addCriterion("day_10_1 <=", value, "day101");
            return (Criteria) this;
        }

        public Criteria andDay101Like(String value) {
            addCriterion("day_10_1 like", value, "day101");
            return (Criteria) this;
        }

        public Criteria andDay101NotLike(String value) {
            addCriterion("day_10_1 not like", value, "day101");
            return (Criteria) this;
        }

        public Criteria andDay101In(List<String> values) {
            addCriterion("day_10_1 in", values, "day101");
            return (Criteria) this;
        }

        public Criteria andDay101NotIn(List<String> values) {
            addCriterion("day_10_1 not in", values, "day101");
            return (Criteria) this;
        }

        public Criteria andDay101Between(String value1, String value2) {
            addCriterion("day_10_1 between", value1, value2, "day101");
            return (Criteria) this;
        }

        public Criteria andDay101NotBetween(String value1, String value2) {
            addCriterion("day_10_1 not between", value1, value2, "day101");
            return (Criteria) this;
        }

        public Criteria andDay102IsNull() {
            addCriterion("day_10_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay102IsNotNull() {
            addCriterion("day_10_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay102EqualTo(String value) {
            addCriterion("day_10_2 =", value, "day102");
            return (Criteria) this;
        }

        public Criteria andDay102NotEqualTo(String value) {
            addCriterion("day_10_2 <>", value, "day102");
            return (Criteria) this;
        }

        public Criteria andDay102GreaterThan(String value) {
            addCriterion("day_10_2 >", value, "day102");
            return (Criteria) this;
        }

        public Criteria andDay102GreaterThanOrEqualTo(String value) {
            addCriterion("day_10_2 >=", value, "day102");
            return (Criteria) this;
        }

        public Criteria andDay102LessThan(String value) {
            addCriterion("day_10_2 <", value, "day102");
            return (Criteria) this;
        }

        public Criteria andDay102LessThanOrEqualTo(String value) {
            addCriterion("day_10_2 <=", value, "day102");
            return (Criteria) this;
        }

        public Criteria andDay102Like(String value) {
            addCriterion("day_10_2 like", value, "day102");
            return (Criteria) this;
        }

        public Criteria andDay102NotLike(String value) {
            addCriterion("day_10_2 not like", value, "day102");
            return (Criteria) this;
        }

        public Criteria andDay102In(List<String> values) {
            addCriterion("day_10_2 in", values, "day102");
            return (Criteria) this;
        }

        public Criteria andDay102NotIn(List<String> values) {
            addCriterion("day_10_2 not in", values, "day102");
            return (Criteria) this;
        }

        public Criteria andDay102Between(String value1, String value2) {
            addCriterion("day_10_2 between", value1, value2, "day102");
            return (Criteria) this;
        }

        public Criteria andDay102NotBetween(String value1, String value2) {
            addCriterion("day_10_2 not between", value1, value2, "day102");
            return (Criteria) this;
        }

        public Criteria andDay111IsNull() {
            addCriterion("day_11_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay111IsNotNull() {
            addCriterion("day_11_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay111EqualTo(String value) {
            addCriterion("day_11_1 =", value, "day111");
            return (Criteria) this;
        }

        public Criteria andDay111NotEqualTo(String value) {
            addCriterion("day_11_1 <>", value, "day111");
            return (Criteria) this;
        }

        public Criteria andDay111GreaterThan(String value) {
            addCriterion("day_11_1 >", value, "day111");
            return (Criteria) this;
        }

        public Criteria andDay111GreaterThanOrEqualTo(String value) {
            addCriterion("day_11_1 >=", value, "day111");
            return (Criteria) this;
        }

        public Criteria andDay111LessThan(String value) {
            addCriterion("day_11_1 <", value, "day111");
            return (Criteria) this;
        }

        public Criteria andDay111LessThanOrEqualTo(String value) {
            addCriterion("day_11_1 <=", value, "day111");
            return (Criteria) this;
        }

        public Criteria andDay111Like(String value) {
            addCriterion("day_11_1 like", value, "day111");
            return (Criteria) this;
        }

        public Criteria andDay111NotLike(String value) {
            addCriterion("day_11_1 not like", value, "day111");
            return (Criteria) this;
        }

        public Criteria andDay111In(List<String> values) {
            addCriterion("day_11_1 in", values, "day111");
            return (Criteria) this;
        }

        public Criteria andDay111NotIn(List<String> values) {
            addCriterion("day_11_1 not in", values, "day111");
            return (Criteria) this;
        }

        public Criteria andDay111Between(String value1, String value2) {
            addCriterion("day_11_1 between", value1, value2, "day111");
            return (Criteria) this;
        }

        public Criteria andDay111NotBetween(String value1, String value2) {
            addCriterion("day_11_1 not between", value1, value2, "day111");
            return (Criteria) this;
        }

        public Criteria andDay112IsNull() {
            addCriterion("day_11_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay112IsNotNull() {
            addCriterion("day_11_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay112EqualTo(String value) {
            addCriterion("day_11_2 =", value, "day112");
            return (Criteria) this;
        }

        public Criteria andDay112NotEqualTo(String value) {
            addCriterion("day_11_2 <>", value, "day112");
            return (Criteria) this;
        }

        public Criteria andDay112GreaterThan(String value) {
            addCriterion("day_11_2 >", value, "day112");
            return (Criteria) this;
        }

        public Criteria andDay112GreaterThanOrEqualTo(String value) {
            addCriterion("day_11_2 >=", value, "day112");
            return (Criteria) this;
        }

        public Criteria andDay112LessThan(String value) {
            addCriterion("day_11_2 <", value, "day112");
            return (Criteria) this;
        }

        public Criteria andDay112LessThanOrEqualTo(String value) {
            addCriterion("day_11_2 <=", value, "day112");
            return (Criteria) this;
        }

        public Criteria andDay112Like(String value) {
            addCriterion("day_11_2 like", value, "day112");
            return (Criteria) this;
        }

        public Criteria andDay112NotLike(String value) {
            addCriterion("day_11_2 not like", value, "day112");
            return (Criteria) this;
        }

        public Criteria andDay112In(List<String> values) {
            addCriterion("day_11_2 in", values, "day112");
            return (Criteria) this;
        }

        public Criteria andDay112NotIn(List<String> values) {
            addCriterion("day_11_2 not in", values, "day112");
            return (Criteria) this;
        }

        public Criteria andDay112Between(String value1, String value2) {
            addCriterion("day_11_2 between", value1, value2, "day112");
            return (Criteria) this;
        }

        public Criteria andDay112NotBetween(String value1, String value2) {
            addCriterion("day_11_2 not between", value1, value2, "day112");
            return (Criteria) this;
        }

        public Criteria andDay121IsNull() {
            addCriterion("day_12_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay121IsNotNull() {
            addCriterion("day_12_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay121EqualTo(String value) {
            addCriterion("day_12_1 =", value, "day121");
            return (Criteria) this;
        }

        public Criteria andDay121NotEqualTo(String value) {
            addCriterion("day_12_1 <>", value, "day121");
            return (Criteria) this;
        }

        public Criteria andDay121GreaterThan(String value) {
            addCriterion("day_12_1 >", value, "day121");
            return (Criteria) this;
        }

        public Criteria andDay121GreaterThanOrEqualTo(String value) {
            addCriterion("day_12_1 >=", value, "day121");
            return (Criteria) this;
        }

        public Criteria andDay121LessThan(String value) {
            addCriterion("day_12_1 <", value, "day121");
            return (Criteria) this;
        }

        public Criteria andDay121LessThanOrEqualTo(String value) {
            addCriterion("day_12_1 <=", value, "day121");
            return (Criteria) this;
        }

        public Criteria andDay121Like(String value) {
            addCriterion("day_12_1 like", value, "day121");
            return (Criteria) this;
        }

        public Criteria andDay121NotLike(String value) {
            addCriterion("day_12_1 not like", value, "day121");
            return (Criteria) this;
        }

        public Criteria andDay121In(List<String> values) {
            addCriterion("day_12_1 in", values, "day121");
            return (Criteria) this;
        }

        public Criteria andDay121NotIn(List<String> values) {
            addCriterion("day_12_1 not in", values, "day121");
            return (Criteria) this;
        }

        public Criteria andDay121Between(String value1, String value2) {
            addCriterion("day_12_1 between", value1, value2, "day121");
            return (Criteria) this;
        }

        public Criteria andDay121NotBetween(String value1, String value2) {
            addCriterion("day_12_1 not between", value1, value2, "day121");
            return (Criteria) this;
        }

        public Criteria andDay122IsNull() {
            addCriterion("day_12_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay122IsNotNull() {
            addCriterion("day_12_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay122EqualTo(String value) {
            addCriterion("day_12_2 =", value, "day122");
            return (Criteria) this;
        }

        public Criteria andDay122NotEqualTo(String value) {
            addCriterion("day_12_2 <>", value, "day122");
            return (Criteria) this;
        }

        public Criteria andDay122GreaterThan(String value) {
            addCriterion("day_12_2 >", value, "day122");
            return (Criteria) this;
        }

        public Criteria andDay122GreaterThanOrEqualTo(String value) {
            addCriterion("day_12_2 >=", value, "day122");
            return (Criteria) this;
        }

        public Criteria andDay122LessThan(String value) {
            addCriterion("day_12_2 <", value, "day122");
            return (Criteria) this;
        }

        public Criteria andDay122LessThanOrEqualTo(String value) {
            addCriterion("day_12_2 <=", value, "day122");
            return (Criteria) this;
        }

        public Criteria andDay122Like(String value) {
            addCriterion("day_12_2 like", value, "day122");
            return (Criteria) this;
        }

        public Criteria andDay122NotLike(String value) {
            addCriterion("day_12_2 not like", value, "day122");
            return (Criteria) this;
        }

        public Criteria andDay122In(List<String> values) {
            addCriterion("day_12_2 in", values, "day122");
            return (Criteria) this;
        }

        public Criteria andDay122NotIn(List<String> values) {
            addCriterion("day_12_2 not in", values, "day122");
            return (Criteria) this;
        }

        public Criteria andDay122Between(String value1, String value2) {
            addCriterion("day_12_2 between", value1, value2, "day122");
            return (Criteria) this;
        }

        public Criteria andDay122NotBetween(String value1, String value2) {
            addCriterion("day_12_2 not between", value1, value2, "day122");
            return (Criteria) this;
        }

        public Criteria andDay131IsNull() {
            addCriterion("day_13_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay131IsNotNull() {
            addCriterion("day_13_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay131EqualTo(String value) {
            addCriterion("day_13_1 =", value, "day131");
            return (Criteria) this;
        }

        public Criteria andDay131NotEqualTo(String value) {
            addCriterion("day_13_1 <>", value, "day131");
            return (Criteria) this;
        }

        public Criteria andDay131GreaterThan(String value) {
            addCriterion("day_13_1 >", value, "day131");
            return (Criteria) this;
        }

        public Criteria andDay131GreaterThanOrEqualTo(String value) {
            addCriterion("day_13_1 >=", value, "day131");
            return (Criteria) this;
        }

        public Criteria andDay131LessThan(String value) {
            addCriterion("day_13_1 <", value, "day131");
            return (Criteria) this;
        }

        public Criteria andDay131LessThanOrEqualTo(String value) {
            addCriterion("day_13_1 <=", value, "day131");
            return (Criteria) this;
        }

        public Criteria andDay131Like(String value) {
            addCriterion("day_13_1 like", value, "day131");
            return (Criteria) this;
        }

        public Criteria andDay131NotLike(String value) {
            addCriterion("day_13_1 not like", value, "day131");
            return (Criteria) this;
        }

        public Criteria andDay131In(List<String> values) {
            addCriterion("day_13_1 in", values, "day131");
            return (Criteria) this;
        }

        public Criteria andDay131NotIn(List<String> values) {
            addCriterion("day_13_1 not in", values, "day131");
            return (Criteria) this;
        }

        public Criteria andDay131Between(String value1, String value2) {
            addCriterion("day_13_1 between", value1, value2, "day131");
            return (Criteria) this;
        }

        public Criteria andDay131NotBetween(String value1, String value2) {
            addCriterion("day_13_1 not between", value1, value2, "day131");
            return (Criteria) this;
        }

        public Criteria andDay132IsNull() {
            addCriterion("day_13_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay132IsNotNull() {
            addCriterion("day_13_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay132EqualTo(String value) {
            addCriterion("day_13_2 =", value, "day132");
            return (Criteria) this;
        }

        public Criteria andDay132NotEqualTo(String value) {
            addCriterion("day_13_2 <>", value, "day132");
            return (Criteria) this;
        }

        public Criteria andDay132GreaterThan(String value) {
            addCriterion("day_13_2 >", value, "day132");
            return (Criteria) this;
        }

        public Criteria andDay132GreaterThanOrEqualTo(String value) {
            addCriterion("day_13_2 >=", value, "day132");
            return (Criteria) this;
        }

        public Criteria andDay132LessThan(String value) {
            addCriterion("day_13_2 <", value, "day132");
            return (Criteria) this;
        }

        public Criteria andDay132LessThanOrEqualTo(String value) {
            addCriterion("day_13_2 <=", value, "day132");
            return (Criteria) this;
        }

        public Criteria andDay132Like(String value) {
            addCriterion("day_13_2 like", value, "day132");
            return (Criteria) this;
        }

        public Criteria andDay132NotLike(String value) {
            addCriterion("day_13_2 not like", value, "day132");
            return (Criteria) this;
        }

        public Criteria andDay132In(List<String> values) {
            addCriterion("day_13_2 in", values, "day132");
            return (Criteria) this;
        }

        public Criteria andDay132NotIn(List<String> values) {
            addCriterion("day_13_2 not in", values, "day132");
            return (Criteria) this;
        }

        public Criteria andDay132Between(String value1, String value2) {
            addCriterion("day_13_2 between", value1, value2, "day132");
            return (Criteria) this;
        }

        public Criteria andDay132NotBetween(String value1, String value2) {
            addCriterion("day_13_2 not between", value1, value2, "day132");
            return (Criteria) this;
        }

        public Criteria andDay141IsNull() {
            addCriterion("day_14_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay141IsNotNull() {
            addCriterion("day_14_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay141EqualTo(String value) {
            addCriterion("day_14_1 =", value, "day141");
            return (Criteria) this;
        }

        public Criteria andDay141NotEqualTo(String value) {
            addCriterion("day_14_1 <>", value, "day141");
            return (Criteria) this;
        }

        public Criteria andDay141GreaterThan(String value) {
            addCriterion("day_14_1 >", value, "day141");
            return (Criteria) this;
        }

        public Criteria andDay141GreaterThanOrEqualTo(String value) {
            addCriterion("day_14_1 >=", value, "day141");
            return (Criteria) this;
        }

        public Criteria andDay141LessThan(String value) {
            addCriterion("day_14_1 <", value, "day141");
            return (Criteria) this;
        }

        public Criteria andDay141LessThanOrEqualTo(String value) {
            addCriterion("day_14_1 <=", value, "day141");
            return (Criteria) this;
        }

        public Criteria andDay141Like(String value) {
            addCriterion("day_14_1 like", value, "day141");
            return (Criteria) this;
        }

        public Criteria andDay141NotLike(String value) {
            addCriterion("day_14_1 not like", value, "day141");
            return (Criteria) this;
        }

        public Criteria andDay141In(List<String> values) {
            addCriterion("day_14_1 in", values, "day141");
            return (Criteria) this;
        }

        public Criteria andDay141NotIn(List<String> values) {
            addCriterion("day_14_1 not in", values, "day141");
            return (Criteria) this;
        }

        public Criteria andDay141Between(String value1, String value2) {
            addCriterion("day_14_1 between", value1, value2, "day141");
            return (Criteria) this;
        }

        public Criteria andDay141NotBetween(String value1, String value2) {
            addCriterion("day_14_1 not between", value1, value2, "day141");
            return (Criteria) this;
        }

        public Criteria andDay142IsNull() {
            addCriterion("day_14_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay142IsNotNull() {
            addCriterion("day_14_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay142EqualTo(String value) {
            addCriterion("day_14_2 =", value, "day142");
            return (Criteria) this;
        }

        public Criteria andDay142NotEqualTo(String value) {
            addCriterion("day_14_2 <>", value, "day142");
            return (Criteria) this;
        }

        public Criteria andDay142GreaterThan(String value) {
            addCriterion("day_14_2 >", value, "day142");
            return (Criteria) this;
        }

        public Criteria andDay142GreaterThanOrEqualTo(String value) {
            addCriterion("day_14_2 >=", value, "day142");
            return (Criteria) this;
        }

        public Criteria andDay142LessThan(String value) {
            addCriterion("day_14_2 <", value, "day142");
            return (Criteria) this;
        }

        public Criteria andDay142LessThanOrEqualTo(String value) {
            addCriterion("day_14_2 <=", value, "day142");
            return (Criteria) this;
        }

        public Criteria andDay142Like(String value) {
            addCriterion("day_14_2 like", value, "day142");
            return (Criteria) this;
        }

        public Criteria andDay142NotLike(String value) {
            addCriterion("day_14_2 not like", value, "day142");
            return (Criteria) this;
        }

        public Criteria andDay142In(List<String> values) {
            addCriterion("day_14_2 in", values, "day142");
            return (Criteria) this;
        }

        public Criteria andDay142NotIn(List<String> values) {
            addCriterion("day_14_2 not in", values, "day142");
            return (Criteria) this;
        }

        public Criteria andDay142Between(String value1, String value2) {
            addCriterion("day_14_2 between", value1, value2, "day142");
            return (Criteria) this;
        }

        public Criteria andDay142NotBetween(String value1, String value2) {
            addCriterion("day_14_2 not between", value1, value2, "day142");
            return (Criteria) this;
        }

        public Criteria andDay151IsNull() {
            addCriterion("day_15_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay151IsNotNull() {
            addCriterion("day_15_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay151EqualTo(String value) {
            addCriterion("day_15_1 =", value, "day151");
            return (Criteria) this;
        }

        public Criteria andDay151NotEqualTo(String value) {
            addCriterion("day_15_1 <>", value, "day151");
            return (Criteria) this;
        }

        public Criteria andDay151GreaterThan(String value) {
            addCriterion("day_15_1 >", value, "day151");
            return (Criteria) this;
        }

        public Criteria andDay151GreaterThanOrEqualTo(String value) {
            addCriterion("day_15_1 >=", value, "day151");
            return (Criteria) this;
        }

        public Criteria andDay151LessThan(String value) {
            addCriterion("day_15_1 <", value, "day151");
            return (Criteria) this;
        }

        public Criteria andDay151LessThanOrEqualTo(String value) {
            addCriterion("day_15_1 <=", value, "day151");
            return (Criteria) this;
        }

        public Criteria andDay151Like(String value) {
            addCriterion("day_15_1 like", value, "day151");
            return (Criteria) this;
        }

        public Criteria andDay151NotLike(String value) {
            addCriterion("day_15_1 not like", value, "day151");
            return (Criteria) this;
        }

        public Criteria andDay151In(List<String> values) {
            addCriterion("day_15_1 in", values, "day151");
            return (Criteria) this;
        }

        public Criteria andDay151NotIn(List<String> values) {
            addCriterion("day_15_1 not in", values, "day151");
            return (Criteria) this;
        }

        public Criteria andDay151Between(String value1, String value2) {
            addCriterion("day_15_1 between", value1, value2, "day151");
            return (Criteria) this;
        }

        public Criteria andDay151NotBetween(String value1, String value2) {
            addCriterion("day_15_1 not between", value1, value2, "day151");
            return (Criteria) this;
        }

        public Criteria andDay152IsNull() {
            addCriterion("day_15_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay152IsNotNull() {
            addCriterion("day_15_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay152EqualTo(String value) {
            addCriterion("day_15_2 =", value, "day152");
            return (Criteria) this;
        }

        public Criteria andDay152NotEqualTo(String value) {
            addCriterion("day_15_2 <>", value, "day152");
            return (Criteria) this;
        }

        public Criteria andDay152GreaterThan(String value) {
            addCriterion("day_15_2 >", value, "day152");
            return (Criteria) this;
        }

        public Criteria andDay152GreaterThanOrEqualTo(String value) {
            addCriterion("day_15_2 >=", value, "day152");
            return (Criteria) this;
        }

        public Criteria andDay152LessThan(String value) {
            addCriterion("day_15_2 <", value, "day152");
            return (Criteria) this;
        }

        public Criteria andDay152LessThanOrEqualTo(String value) {
            addCriterion("day_15_2 <=", value, "day152");
            return (Criteria) this;
        }

        public Criteria andDay152Like(String value) {
            addCriterion("day_15_2 like", value, "day152");
            return (Criteria) this;
        }

        public Criteria andDay152NotLike(String value) {
            addCriterion("day_15_2 not like", value, "day152");
            return (Criteria) this;
        }

        public Criteria andDay152In(List<String> values) {
            addCriterion("day_15_2 in", values, "day152");
            return (Criteria) this;
        }

        public Criteria andDay152NotIn(List<String> values) {
            addCriterion("day_15_2 not in", values, "day152");
            return (Criteria) this;
        }

        public Criteria andDay152Between(String value1, String value2) {
            addCriterion("day_15_2 between", value1, value2, "day152");
            return (Criteria) this;
        }

        public Criteria andDay152NotBetween(String value1, String value2) {
            addCriterion("day_15_2 not between", value1, value2, "day152");
            return (Criteria) this;
        }

        public Criteria andDay161IsNull() {
            addCriterion("day_16_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay161IsNotNull() {
            addCriterion("day_16_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay161EqualTo(String value) {
            addCriterion("day_16_1 =", value, "day161");
            return (Criteria) this;
        }

        public Criteria andDay161NotEqualTo(String value) {
            addCriterion("day_16_1 <>", value, "day161");
            return (Criteria) this;
        }

        public Criteria andDay161GreaterThan(String value) {
            addCriterion("day_16_1 >", value, "day161");
            return (Criteria) this;
        }

        public Criteria andDay161GreaterThanOrEqualTo(String value) {
            addCriterion("day_16_1 >=", value, "day161");
            return (Criteria) this;
        }

        public Criteria andDay161LessThan(String value) {
            addCriterion("day_16_1 <", value, "day161");
            return (Criteria) this;
        }

        public Criteria andDay161LessThanOrEqualTo(String value) {
            addCriterion("day_16_1 <=", value, "day161");
            return (Criteria) this;
        }

        public Criteria andDay161Like(String value) {
            addCriterion("day_16_1 like", value, "day161");
            return (Criteria) this;
        }

        public Criteria andDay161NotLike(String value) {
            addCriterion("day_16_1 not like", value, "day161");
            return (Criteria) this;
        }

        public Criteria andDay161In(List<String> values) {
            addCriterion("day_16_1 in", values, "day161");
            return (Criteria) this;
        }

        public Criteria andDay161NotIn(List<String> values) {
            addCriterion("day_16_1 not in", values, "day161");
            return (Criteria) this;
        }

        public Criteria andDay161Between(String value1, String value2) {
            addCriterion("day_16_1 between", value1, value2, "day161");
            return (Criteria) this;
        }

        public Criteria andDay161NotBetween(String value1, String value2) {
            addCriterion("day_16_1 not between", value1, value2, "day161");
            return (Criteria) this;
        }

        public Criteria andDay162IsNull() {
            addCriterion("day_16_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay162IsNotNull() {
            addCriterion("day_16_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay162EqualTo(String value) {
            addCriterion("day_16_2 =", value, "day162");
            return (Criteria) this;
        }

        public Criteria andDay162NotEqualTo(String value) {
            addCriterion("day_16_2 <>", value, "day162");
            return (Criteria) this;
        }

        public Criteria andDay162GreaterThan(String value) {
            addCriterion("day_16_2 >", value, "day162");
            return (Criteria) this;
        }

        public Criteria andDay162GreaterThanOrEqualTo(String value) {
            addCriterion("day_16_2 >=", value, "day162");
            return (Criteria) this;
        }

        public Criteria andDay162LessThan(String value) {
            addCriterion("day_16_2 <", value, "day162");
            return (Criteria) this;
        }

        public Criteria andDay162LessThanOrEqualTo(String value) {
            addCriterion("day_16_2 <=", value, "day162");
            return (Criteria) this;
        }

        public Criteria andDay162Like(String value) {
            addCriterion("day_16_2 like", value, "day162");
            return (Criteria) this;
        }

        public Criteria andDay162NotLike(String value) {
            addCriterion("day_16_2 not like", value, "day162");
            return (Criteria) this;
        }

        public Criteria andDay162In(List<String> values) {
            addCriterion("day_16_2 in", values, "day162");
            return (Criteria) this;
        }

        public Criteria andDay162NotIn(List<String> values) {
            addCriterion("day_16_2 not in", values, "day162");
            return (Criteria) this;
        }

        public Criteria andDay162Between(String value1, String value2) {
            addCriterion("day_16_2 between", value1, value2, "day162");
            return (Criteria) this;
        }

        public Criteria andDay162NotBetween(String value1, String value2) {
            addCriterion("day_16_2 not between", value1, value2, "day162");
            return (Criteria) this;
        }

        public Criteria andDay171IsNull() {
            addCriterion("day_17_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay171IsNotNull() {
            addCriterion("day_17_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay171EqualTo(String value) {
            addCriterion("day_17_1 =", value, "day171");
            return (Criteria) this;
        }

        public Criteria andDay171NotEqualTo(String value) {
            addCriterion("day_17_1 <>", value, "day171");
            return (Criteria) this;
        }

        public Criteria andDay171GreaterThan(String value) {
            addCriterion("day_17_1 >", value, "day171");
            return (Criteria) this;
        }

        public Criteria andDay171GreaterThanOrEqualTo(String value) {
            addCriterion("day_17_1 >=", value, "day171");
            return (Criteria) this;
        }

        public Criteria andDay171LessThan(String value) {
            addCriterion("day_17_1 <", value, "day171");
            return (Criteria) this;
        }

        public Criteria andDay171LessThanOrEqualTo(String value) {
            addCriterion("day_17_1 <=", value, "day171");
            return (Criteria) this;
        }

        public Criteria andDay171Like(String value) {
            addCriterion("day_17_1 like", value, "day171");
            return (Criteria) this;
        }

        public Criteria andDay171NotLike(String value) {
            addCriterion("day_17_1 not like", value, "day171");
            return (Criteria) this;
        }

        public Criteria andDay171In(List<String> values) {
            addCriterion("day_17_1 in", values, "day171");
            return (Criteria) this;
        }

        public Criteria andDay171NotIn(List<String> values) {
            addCriterion("day_17_1 not in", values, "day171");
            return (Criteria) this;
        }

        public Criteria andDay171Between(String value1, String value2) {
            addCriterion("day_17_1 between", value1, value2, "day171");
            return (Criteria) this;
        }

        public Criteria andDay171NotBetween(String value1, String value2) {
            addCriterion("day_17_1 not between", value1, value2, "day171");
            return (Criteria) this;
        }

        public Criteria andDay172IsNull() {
            addCriterion("day_17_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay172IsNotNull() {
            addCriterion("day_17_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay172EqualTo(String value) {
            addCriterion("day_17_2 =", value, "day172");
            return (Criteria) this;
        }

        public Criteria andDay172NotEqualTo(String value) {
            addCriterion("day_17_2 <>", value, "day172");
            return (Criteria) this;
        }

        public Criteria andDay172GreaterThan(String value) {
            addCriterion("day_17_2 >", value, "day172");
            return (Criteria) this;
        }

        public Criteria andDay172GreaterThanOrEqualTo(String value) {
            addCriterion("day_17_2 >=", value, "day172");
            return (Criteria) this;
        }

        public Criteria andDay172LessThan(String value) {
            addCriterion("day_17_2 <", value, "day172");
            return (Criteria) this;
        }

        public Criteria andDay172LessThanOrEqualTo(String value) {
            addCriterion("day_17_2 <=", value, "day172");
            return (Criteria) this;
        }

        public Criteria andDay172Like(String value) {
            addCriterion("day_17_2 like", value, "day172");
            return (Criteria) this;
        }

        public Criteria andDay172NotLike(String value) {
            addCriterion("day_17_2 not like", value, "day172");
            return (Criteria) this;
        }

        public Criteria andDay172In(List<String> values) {
            addCriterion("day_17_2 in", values, "day172");
            return (Criteria) this;
        }

        public Criteria andDay172NotIn(List<String> values) {
            addCriterion("day_17_2 not in", values, "day172");
            return (Criteria) this;
        }

        public Criteria andDay172Between(String value1, String value2) {
            addCriterion("day_17_2 between", value1, value2, "day172");
            return (Criteria) this;
        }

        public Criteria andDay172NotBetween(String value1, String value2) {
            addCriterion("day_17_2 not between", value1, value2, "day172");
            return (Criteria) this;
        }

        public Criteria andDay181IsNull() {
            addCriterion("day_18_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay181IsNotNull() {
            addCriterion("day_18_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay181EqualTo(String value) {
            addCriterion("day_18_1 =", value, "day181");
            return (Criteria) this;
        }

        public Criteria andDay181NotEqualTo(String value) {
            addCriterion("day_18_1 <>", value, "day181");
            return (Criteria) this;
        }

        public Criteria andDay181GreaterThan(String value) {
            addCriterion("day_18_1 >", value, "day181");
            return (Criteria) this;
        }

        public Criteria andDay181GreaterThanOrEqualTo(String value) {
            addCriterion("day_18_1 >=", value, "day181");
            return (Criteria) this;
        }

        public Criteria andDay181LessThan(String value) {
            addCriterion("day_18_1 <", value, "day181");
            return (Criteria) this;
        }

        public Criteria andDay181LessThanOrEqualTo(String value) {
            addCriterion("day_18_1 <=", value, "day181");
            return (Criteria) this;
        }

        public Criteria andDay181Like(String value) {
            addCriterion("day_18_1 like", value, "day181");
            return (Criteria) this;
        }

        public Criteria andDay181NotLike(String value) {
            addCriterion("day_18_1 not like", value, "day181");
            return (Criteria) this;
        }

        public Criteria andDay181In(List<String> values) {
            addCriterion("day_18_1 in", values, "day181");
            return (Criteria) this;
        }

        public Criteria andDay181NotIn(List<String> values) {
            addCriterion("day_18_1 not in", values, "day181");
            return (Criteria) this;
        }

        public Criteria andDay181Between(String value1, String value2) {
            addCriterion("day_18_1 between", value1, value2, "day181");
            return (Criteria) this;
        }

        public Criteria andDay181NotBetween(String value1, String value2) {
            addCriterion("day_18_1 not between", value1, value2, "day181");
            return (Criteria) this;
        }

        public Criteria andDay182IsNull() {
            addCriterion("day_18_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay182IsNotNull() {
            addCriterion("day_18_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay182EqualTo(String value) {
            addCriterion("day_18_2 =", value, "day182");
            return (Criteria) this;
        }

        public Criteria andDay182NotEqualTo(String value) {
            addCriterion("day_18_2 <>", value, "day182");
            return (Criteria) this;
        }

        public Criteria andDay182GreaterThan(String value) {
            addCriterion("day_18_2 >", value, "day182");
            return (Criteria) this;
        }

        public Criteria andDay182GreaterThanOrEqualTo(String value) {
            addCriterion("day_18_2 >=", value, "day182");
            return (Criteria) this;
        }

        public Criteria andDay182LessThan(String value) {
            addCriterion("day_18_2 <", value, "day182");
            return (Criteria) this;
        }

        public Criteria andDay182LessThanOrEqualTo(String value) {
            addCriterion("day_18_2 <=", value, "day182");
            return (Criteria) this;
        }

        public Criteria andDay182Like(String value) {
            addCriterion("day_18_2 like", value, "day182");
            return (Criteria) this;
        }

        public Criteria andDay182NotLike(String value) {
            addCriterion("day_18_2 not like", value, "day182");
            return (Criteria) this;
        }

        public Criteria andDay182In(List<String> values) {
            addCriterion("day_18_2 in", values, "day182");
            return (Criteria) this;
        }

        public Criteria andDay182NotIn(List<String> values) {
            addCriterion("day_18_2 not in", values, "day182");
            return (Criteria) this;
        }

        public Criteria andDay182Between(String value1, String value2) {
            addCriterion("day_18_2 between", value1, value2, "day182");
            return (Criteria) this;
        }

        public Criteria andDay182NotBetween(String value1, String value2) {
            addCriterion("day_18_2 not between", value1, value2, "day182");
            return (Criteria) this;
        }

        public Criteria andDay191IsNull() {
            addCriterion("day_19_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay191IsNotNull() {
            addCriterion("day_19_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay191EqualTo(String value) {
            addCriterion("day_19_1 =", value, "day191");
            return (Criteria) this;
        }

        public Criteria andDay191NotEqualTo(String value) {
            addCriterion("day_19_1 <>", value, "day191");
            return (Criteria) this;
        }

        public Criteria andDay191GreaterThan(String value) {
            addCriterion("day_19_1 >", value, "day191");
            return (Criteria) this;
        }

        public Criteria andDay191GreaterThanOrEqualTo(String value) {
            addCriterion("day_19_1 >=", value, "day191");
            return (Criteria) this;
        }

        public Criteria andDay191LessThan(String value) {
            addCriterion("day_19_1 <", value, "day191");
            return (Criteria) this;
        }

        public Criteria andDay191LessThanOrEqualTo(String value) {
            addCriterion("day_19_1 <=", value, "day191");
            return (Criteria) this;
        }

        public Criteria andDay191Like(String value) {
            addCriterion("day_19_1 like", value, "day191");
            return (Criteria) this;
        }

        public Criteria andDay191NotLike(String value) {
            addCriterion("day_19_1 not like", value, "day191");
            return (Criteria) this;
        }

        public Criteria andDay191In(List<String> values) {
            addCriterion("day_19_1 in", values, "day191");
            return (Criteria) this;
        }

        public Criteria andDay191NotIn(List<String> values) {
            addCriterion("day_19_1 not in", values, "day191");
            return (Criteria) this;
        }

        public Criteria andDay191Between(String value1, String value2) {
            addCriterion("day_19_1 between", value1, value2, "day191");
            return (Criteria) this;
        }

        public Criteria andDay191NotBetween(String value1, String value2) {
            addCriterion("day_19_1 not between", value1, value2, "day191");
            return (Criteria) this;
        }

        public Criteria andDay192IsNull() {
            addCriterion("day_19_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay192IsNotNull() {
            addCriterion("day_19_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay192EqualTo(String value) {
            addCriterion("day_19_2 =", value, "day192");
            return (Criteria) this;
        }

        public Criteria andDay192NotEqualTo(String value) {
            addCriterion("day_19_2 <>", value, "day192");
            return (Criteria) this;
        }

        public Criteria andDay192GreaterThan(String value) {
            addCriterion("day_19_2 >", value, "day192");
            return (Criteria) this;
        }

        public Criteria andDay192GreaterThanOrEqualTo(String value) {
            addCriterion("day_19_2 >=", value, "day192");
            return (Criteria) this;
        }

        public Criteria andDay192LessThan(String value) {
            addCriterion("day_19_2 <", value, "day192");
            return (Criteria) this;
        }

        public Criteria andDay192LessThanOrEqualTo(String value) {
            addCriterion("day_19_2 <=", value, "day192");
            return (Criteria) this;
        }

        public Criteria andDay192Like(String value) {
            addCriterion("day_19_2 like", value, "day192");
            return (Criteria) this;
        }

        public Criteria andDay192NotLike(String value) {
            addCriterion("day_19_2 not like", value, "day192");
            return (Criteria) this;
        }

        public Criteria andDay192In(List<String> values) {
            addCriterion("day_19_2 in", values, "day192");
            return (Criteria) this;
        }

        public Criteria andDay192NotIn(List<String> values) {
            addCriterion("day_19_2 not in", values, "day192");
            return (Criteria) this;
        }

        public Criteria andDay192Between(String value1, String value2) {
            addCriterion("day_19_2 between", value1, value2, "day192");
            return (Criteria) this;
        }

        public Criteria andDay192NotBetween(String value1, String value2) {
            addCriterion("day_19_2 not between", value1, value2, "day192");
            return (Criteria) this;
        }

        public Criteria andDay201IsNull() {
            addCriterion("day_20_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay201IsNotNull() {
            addCriterion("day_20_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay201EqualTo(String value) {
            addCriterion("day_20_1 =", value, "day201");
            return (Criteria) this;
        }

        public Criteria andDay201NotEqualTo(String value) {
            addCriterion("day_20_1 <>", value, "day201");
            return (Criteria) this;
        }

        public Criteria andDay201GreaterThan(String value) {
            addCriterion("day_20_1 >", value, "day201");
            return (Criteria) this;
        }

        public Criteria andDay201GreaterThanOrEqualTo(String value) {
            addCriterion("day_20_1 >=", value, "day201");
            return (Criteria) this;
        }

        public Criteria andDay201LessThan(String value) {
            addCriterion("day_20_1 <", value, "day201");
            return (Criteria) this;
        }

        public Criteria andDay201LessThanOrEqualTo(String value) {
            addCriterion("day_20_1 <=", value, "day201");
            return (Criteria) this;
        }

        public Criteria andDay201Like(String value) {
            addCriterion("day_20_1 like", value, "day201");
            return (Criteria) this;
        }

        public Criteria andDay201NotLike(String value) {
            addCriterion("day_20_1 not like", value, "day201");
            return (Criteria) this;
        }

        public Criteria andDay201In(List<String> values) {
            addCriterion("day_20_1 in", values, "day201");
            return (Criteria) this;
        }

        public Criteria andDay201NotIn(List<String> values) {
            addCriterion("day_20_1 not in", values, "day201");
            return (Criteria) this;
        }

        public Criteria andDay201Between(String value1, String value2) {
            addCriterion("day_20_1 between", value1, value2, "day201");
            return (Criteria) this;
        }

        public Criteria andDay201NotBetween(String value1, String value2) {
            addCriterion("day_20_1 not between", value1, value2, "day201");
            return (Criteria) this;
        }

        public Criteria andDay202IsNull() {
            addCriterion("day_20_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay202IsNotNull() {
            addCriterion("day_20_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay202EqualTo(String value) {
            addCriterion("day_20_2 =", value, "day202");
            return (Criteria) this;
        }

        public Criteria andDay202NotEqualTo(String value) {
            addCriterion("day_20_2 <>", value, "day202");
            return (Criteria) this;
        }

        public Criteria andDay202GreaterThan(String value) {
            addCriterion("day_20_2 >", value, "day202");
            return (Criteria) this;
        }

        public Criteria andDay202GreaterThanOrEqualTo(String value) {
            addCriterion("day_20_2 >=", value, "day202");
            return (Criteria) this;
        }

        public Criteria andDay202LessThan(String value) {
            addCriterion("day_20_2 <", value, "day202");
            return (Criteria) this;
        }

        public Criteria andDay202LessThanOrEqualTo(String value) {
            addCriterion("day_20_2 <=", value, "day202");
            return (Criteria) this;
        }

        public Criteria andDay202Like(String value) {
            addCriterion("day_20_2 like", value, "day202");
            return (Criteria) this;
        }

        public Criteria andDay202NotLike(String value) {
            addCriterion("day_20_2 not like", value, "day202");
            return (Criteria) this;
        }

        public Criteria andDay202In(List<String> values) {
            addCriterion("day_20_2 in", values, "day202");
            return (Criteria) this;
        }

        public Criteria andDay202NotIn(List<String> values) {
            addCriterion("day_20_2 not in", values, "day202");
            return (Criteria) this;
        }

        public Criteria andDay202Between(String value1, String value2) {
            addCriterion("day_20_2 between", value1, value2, "day202");
            return (Criteria) this;
        }

        public Criteria andDay202NotBetween(String value1, String value2) {
            addCriterion("day_20_2 not between", value1, value2, "day202");
            return (Criteria) this;
        }

        public Criteria andDay211IsNull() {
            addCriterion("day_21_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay211IsNotNull() {
            addCriterion("day_21_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay211EqualTo(String value) {
            addCriterion("day_21_1 =", value, "day211");
            return (Criteria) this;
        }

        public Criteria andDay211NotEqualTo(String value) {
            addCriterion("day_21_1 <>", value, "day211");
            return (Criteria) this;
        }

        public Criteria andDay211GreaterThan(String value) {
            addCriterion("day_21_1 >", value, "day211");
            return (Criteria) this;
        }

        public Criteria andDay211GreaterThanOrEqualTo(String value) {
            addCriterion("day_21_1 >=", value, "day211");
            return (Criteria) this;
        }

        public Criteria andDay211LessThan(String value) {
            addCriterion("day_21_1 <", value, "day211");
            return (Criteria) this;
        }

        public Criteria andDay211LessThanOrEqualTo(String value) {
            addCriterion("day_21_1 <=", value, "day211");
            return (Criteria) this;
        }

        public Criteria andDay211Like(String value) {
            addCriterion("day_21_1 like", value, "day211");
            return (Criteria) this;
        }

        public Criteria andDay211NotLike(String value) {
            addCriterion("day_21_1 not like", value, "day211");
            return (Criteria) this;
        }

        public Criteria andDay211In(List<String> values) {
            addCriterion("day_21_1 in", values, "day211");
            return (Criteria) this;
        }

        public Criteria andDay211NotIn(List<String> values) {
            addCriterion("day_21_1 not in", values, "day211");
            return (Criteria) this;
        }

        public Criteria andDay211Between(String value1, String value2) {
            addCriterion("day_21_1 between", value1, value2, "day211");
            return (Criteria) this;
        }

        public Criteria andDay211NotBetween(String value1, String value2) {
            addCriterion("day_21_1 not between", value1, value2, "day211");
            return (Criteria) this;
        }

        public Criteria andDay212IsNull() {
            addCriterion("day_21_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay212IsNotNull() {
            addCriterion("day_21_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay212EqualTo(String value) {
            addCriterion("day_21_2 =", value, "day212");
            return (Criteria) this;
        }

        public Criteria andDay212NotEqualTo(String value) {
            addCriterion("day_21_2 <>", value, "day212");
            return (Criteria) this;
        }

        public Criteria andDay212GreaterThan(String value) {
            addCriterion("day_21_2 >", value, "day212");
            return (Criteria) this;
        }

        public Criteria andDay212GreaterThanOrEqualTo(String value) {
            addCriterion("day_21_2 >=", value, "day212");
            return (Criteria) this;
        }

        public Criteria andDay212LessThan(String value) {
            addCriterion("day_21_2 <", value, "day212");
            return (Criteria) this;
        }

        public Criteria andDay212LessThanOrEqualTo(String value) {
            addCriterion("day_21_2 <=", value, "day212");
            return (Criteria) this;
        }

        public Criteria andDay212Like(String value) {
            addCriterion("day_21_2 like", value, "day212");
            return (Criteria) this;
        }

        public Criteria andDay212NotLike(String value) {
            addCriterion("day_21_2 not like", value, "day212");
            return (Criteria) this;
        }

        public Criteria andDay212In(List<String> values) {
            addCriterion("day_21_2 in", values, "day212");
            return (Criteria) this;
        }

        public Criteria andDay212NotIn(List<String> values) {
            addCriterion("day_21_2 not in", values, "day212");
            return (Criteria) this;
        }

        public Criteria andDay212Between(String value1, String value2) {
            addCriterion("day_21_2 between", value1, value2, "day212");
            return (Criteria) this;
        }

        public Criteria andDay212NotBetween(String value1, String value2) {
            addCriterion("day_21_2 not between", value1, value2, "day212");
            return (Criteria) this;
        }

        public Criteria andDay221IsNull() {
            addCriterion("day_22_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay221IsNotNull() {
            addCriterion("day_22_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay221EqualTo(String value) {
            addCriterion("day_22_1 =", value, "day221");
            return (Criteria) this;
        }

        public Criteria andDay221NotEqualTo(String value) {
            addCriterion("day_22_1 <>", value, "day221");
            return (Criteria) this;
        }

        public Criteria andDay221GreaterThan(String value) {
            addCriterion("day_22_1 >", value, "day221");
            return (Criteria) this;
        }

        public Criteria andDay221GreaterThanOrEqualTo(String value) {
            addCriterion("day_22_1 >=", value, "day221");
            return (Criteria) this;
        }

        public Criteria andDay221LessThan(String value) {
            addCriterion("day_22_1 <", value, "day221");
            return (Criteria) this;
        }

        public Criteria andDay221LessThanOrEqualTo(String value) {
            addCriterion("day_22_1 <=", value, "day221");
            return (Criteria) this;
        }

        public Criteria andDay221Like(String value) {
            addCriterion("day_22_1 like", value, "day221");
            return (Criteria) this;
        }

        public Criteria andDay221NotLike(String value) {
            addCriterion("day_22_1 not like", value, "day221");
            return (Criteria) this;
        }

        public Criteria andDay221In(List<String> values) {
            addCriterion("day_22_1 in", values, "day221");
            return (Criteria) this;
        }

        public Criteria andDay221NotIn(List<String> values) {
            addCriterion("day_22_1 not in", values, "day221");
            return (Criteria) this;
        }

        public Criteria andDay221Between(String value1, String value2) {
            addCriterion("day_22_1 between", value1, value2, "day221");
            return (Criteria) this;
        }

        public Criteria andDay221NotBetween(String value1, String value2) {
            addCriterion("day_22_1 not between", value1, value2, "day221");
            return (Criteria) this;
        }

        public Criteria andDay222IsNull() {
            addCriterion("day_22_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay222IsNotNull() {
            addCriterion("day_22_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay222EqualTo(String value) {
            addCriterion("day_22_2 =", value, "day222");
            return (Criteria) this;
        }

        public Criteria andDay222NotEqualTo(String value) {
            addCriterion("day_22_2 <>", value, "day222");
            return (Criteria) this;
        }

        public Criteria andDay222GreaterThan(String value) {
            addCriterion("day_22_2 >", value, "day222");
            return (Criteria) this;
        }

        public Criteria andDay222GreaterThanOrEqualTo(String value) {
            addCriterion("day_22_2 >=", value, "day222");
            return (Criteria) this;
        }

        public Criteria andDay222LessThan(String value) {
            addCriterion("day_22_2 <", value, "day222");
            return (Criteria) this;
        }

        public Criteria andDay222LessThanOrEqualTo(String value) {
            addCriterion("day_22_2 <=", value, "day222");
            return (Criteria) this;
        }

        public Criteria andDay222Like(String value) {
            addCriterion("day_22_2 like", value, "day222");
            return (Criteria) this;
        }

        public Criteria andDay222NotLike(String value) {
            addCriterion("day_22_2 not like", value, "day222");
            return (Criteria) this;
        }

        public Criteria andDay222In(List<String> values) {
            addCriterion("day_22_2 in", values, "day222");
            return (Criteria) this;
        }

        public Criteria andDay222NotIn(List<String> values) {
            addCriterion("day_22_2 not in", values, "day222");
            return (Criteria) this;
        }

        public Criteria andDay222Between(String value1, String value2) {
            addCriterion("day_22_2 between", value1, value2, "day222");
            return (Criteria) this;
        }

        public Criteria andDay222NotBetween(String value1, String value2) {
            addCriterion("day_22_2 not between", value1, value2, "day222");
            return (Criteria) this;
        }

        public Criteria andDay231IsNull() {
            addCriterion("day_23_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay231IsNotNull() {
            addCriterion("day_23_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay231EqualTo(String value) {
            addCriterion("day_23_1 =", value, "day231");
            return (Criteria) this;
        }

        public Criteria andDay231NotEqualTo(String value) {
            addCriterion("day_23_1 <>", value, "day231");
            return (Criteria) this;
        }

        public Criteria andDay231GreaterThan(String value) {
            addCriterion("day_23_1 >", value, "day231");
            return (Criteria) this;
        }

        public Criteria andDay231GreaterThanOrEqualTo(String value) {
            addCriterion("day_23_1 >=", value, "day231");
            return (Criteria) this;
        }

        public Criteria andDay231LessThan(String value) {
            addCriterion("day_23_1 <", value, "day231");
            return (Criteria) this;
        }

        public Criteria andDay231LessThanOrEqualTo(String value) {
            addCriterion("day_23_1 <=", value, "day231");
            return (Criteria) this;
        }

        public Criteria andDay231Like(String value) {
            addCriterion("day_23_1 like", value, "day231");
            return (Criteria) this;
        }

        public Criteria andDay231NotLike(String value) {
            addCriterion("day_23_1 not like", value, "day231");
            return (Criteria) this;
        }

        public Criteria andDay231In(List<String> values) {
            addCriterion("day_23_1 in", values, "day231");
            return (Criteria) this;
        }

        public Criteria andDay231NotIn(List<String> values) {
            addCriterion("day_23_1 not in", values, "day231");
            return (Criteria) this;
        }

        public Criteria andDay231Between(String value1, String value2) {
            addCriterion("day_23_1 between", value1, value2, "day231");
            return (Criteria) this;
        }

        public Criteria andDay231NotBetween(String value1, String value2) {
            addCriterion("day_23_1 not between", value1, value2, "day231");
            return (Criteria) this;
        }

        public Criteria andDay232IsNull() {
            addCriterion("day_23_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay232IsNotNull() {
            addCriterion("day_23_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay232EqualTo(String value) {
            addCriterion("day_23_2 =", value, "day232");
            return (Criteria) this;
        }

        public Criteria andDay232NotEqualTo(String value) {
            addCriterion("day_23_2 <>", value, "day232");
            return (Criteria) this;
        }

        public Criteria andDay232GreaterThan(String value) {
            addCriterion("day_23_2 >", value, "day232");
            return (Criteria) this;
        }

        public Criteria andDay232GreaterThanOrEqualTo(String value) {
            addCriterion("day_23_2 >=", value, "day232");
            return (Criteria) this;
        }

        public Criteria andDay232LessThan(String value) {
            addCriterion("day_23_2 <", value, "day232");
            return (Criteria) this;
        }

        public Criteria andDay232LessThanOrEqualTo(String value) {
            addCriterion("day_23_2 <=", value, "day232");
            return (Criteria) this;
        }

        public Criteria andDay232Like(String value) {
            addCriterion("day_23_2 like", value, "day232");
            return (Criteria) this;
        }

        public Criteria andDay232NotLike(String value) {
            addCriterion("day_23_2 not like", value, "day232");
            return (Criteria) this;
        }

        public Criteria andDay232In(List<String> values) {
            addCriterion("day_23_2 in", values, "day232");
            return (Criteria) this;
        }

        public Criteria andDay232NotIn(List<String> values) {
            addCriterion("day_23_2 not in", values, "day232");
            return (Criteria) this;
        }

        public Criteria andDay232Between(String value1, String value2) {
            addCriterion("day_23_2 between", value1, value2, "day232");
            return (Criteria) this;
        }

        public Criteria andDay232NotBetween(String value1, String value2) {
            addCriterion("day_23_2 not between", value1, value2, "day232");
            return (Criteria) this;
        }

        public Criteria andDay241IsNull() {
            addCriterion("day_24_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay241IsNotNull() {
            addCriterion("day_24_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay241EqualTo(String value) {
            addCriterion("day_24_1 =", value, "day241");
            return (Criteria) this;
        }

        public Criteria andDay241NotEqualTo(String value) {
            addCriterion("day_24_1 <>", value, "day241");
            return (Criteria) this;
        }

        public Criteria andDay241GreaterThan(String value) {
            addCriterion("day_24_1 >", value, "day241");
            return (Criteria) this;
        }

        public Criteria andDay241GreaterThanOrEqualTo(String value) {
            addCriterion("day_24_1 >=", value, "day241");
            return (Criteria) this;
        }

        public Criteria andDay241LessThan(String value) {
            addCriterion("day_24_1 <", value, "day241");
            return (Criteria) this;
        }

        public Criteria andDay241LessThanOrEqualTo(String value) {
            addCriterion("day_24_1 <=", value, "day241");
            return (Criteria) this;
        }

        public Criteria andDay241Like(String value) {
            addCriterion("day_24_1 like", value, "day241");
            return (Criteria) this;
        }

        public Criteria andDay241NotLike(String value) {
            addCriterion("day_24_1 not like", value, "day241");
            return (Criteria) this;
        }

        public Criteria andDay241In(List<String> values) {
            addCriterion("day_24_1 in", values, "day241");
            return (Criteria) this;
        }

        public Criteria andDay241NotIn(List<String> values) {
            addCriterion("day_24_1 not in", values, "day241");
            return (Criteria) this;
        }

        public Criteria andDay241Between(String value1, String value2) {
            addCriterion("day_24_1 between", value1, value2, "day241");
            return (Criteria) this;
        }

        public Criteria andDay241NotBetween(String value1, String value2) {
            addCriterion("day_24_1 not between", value1, value2, "day241");
            return (Criteria) this;
        }

        public Criteria andDay242IsNull() {
            addCriterion("day_24_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay242IsNotNull() {
            addCriterion("day_24_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay242EqualTo(String value) {
            addCriterion("day_24_2 =", value, "day242");
            return (Criteria) this;
        }

        public Criteria andDay242NotEqualTo(String value) {
            addCriterion("day_24_2 <>", value, "day242");
            return (Criteria) this;
        }

        public Criteria andDay242GreaterThan(String value) {
            addCriterion("day_24_2 >", value, "day242");
            return (Criteria) this;
        }

        public Criteria andDay242GreaterThanOrEqualTo(String value) {
            addCriterion("day_24_2 >=", value, "day242");
            return (Criteria) this;
        }

        public Criteria andDay242LessThan(String value) {
            addCriterion("day_24_2 <", value, "day242");
            return (Criteria) this;
        }

        public Criteria andDay242LessThanOrEqualTo(String value) {
            addCriterion("day_24_2 <=", value, "day242");
            return (Criteria) this;
        }

        public Criteria andDay242Like(String value) {
            addCriterion("day_24_2 like", value, "day242");
            return (Criteria) this;
        }

        public Criteria andDay242NotLike(String value) {
            addCriterion("day_24_2 not like", value, "day242");
            return (Criteria) this;
        }

        public Criteria andDay242In(List<String> values) {
            addCriterion("day_24_2 in", values, "day242");
            return (Criteria) this;
        }

        public Criteria andDay242NotIn(List<String> values) {
            addCriterion("day_24_2 not in", values, "day242");
            return (Criteria) this;
        }

        public Criteria andDay242Between(String value1, String value2) {
            addCriterion("day_24_2 between", value1, value2, "day242");
            return (Criteria) this;
        }

        public Criteria andDay242NotBetween(String value1, String value2) {
            addCriterion("day_24_2 not between", value1, value2, "day242");
            return (Criteria) this;
        }

        public Criteria andDay251IsNull() {
            addCriterion("day_25_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay251IsNotNull() {
            addCriterion("day_25_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay251EqualTo(String value) {
            addCriterion("day_25_1 =", value, "day251");
            return (Criteria) this;
        }

        public Criteria andDay251NotEqualTo(String value) {
            addCriterion("day_25_1 <>", value, "day251");
            return (Criteria) this;
        }

        public Criteria andDay251GreaterThan(String value) {
            addCriterion("day_25_1 >", value, "day251");
            return (Criteria) this;
        }

        public Criteria andDay251GreaterThanOrEqualTo(String value) {
            addCriterion("day_25_1 >=", value, "day251");
            return (Criteria) this;
        }

        public Criteria andDay251LessThan(String value) {
            addCriterion("day_25_1 <", value, "day251");
            return (Criteria) this;
        }

        public Criteria andDay251LessThanOrEqualTo(String value) {
            addCriterion("day_25_1 <=", value, "day251");
            return (Criteria) this;
        }

        public Criteria andDay251Like(String value) {
            addCriterion("day_25_1 like", value, "day251");
            return (Criteria) this;
        }

        public Criteria andDay251NotLike(String value) {
            addCriterion("day_25_1 not like", value, "day251");
            return (Criteria) this;
        }

        public Criteria andDay251In(List<String> values) {
            addCriterion("day_25_1 in", values, "day251");
            return (Criteria) this;
        }

        public Criteria andDay251NotIn(List<String> values) {
            addCriterion("day_25_1 not in", values, "day251");
            return (Criteria) this;
        }

        public Criteria andDay251Between(String value1, String value2) {
            addCriterion("day_25_1 between", value1, value2, "day251");
            return (Criteria) this;
        }

        public Criteria andDay251NotBetween(String value1, String value2) {
            addCriterion("day_25_1 not between", value1, value2, "day251");
            return (Criteria) this;
        }

        public Criteria andDay252IsNull() {
            addCriterion("day_25_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay252IsNotNull() {
            addCriterion("day_25_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay252EqualTo(String value) {
            addCriterion("day_25_2 =", value, "day252");
            return (Criteria) this;
        }

        public Criteria andDay252NotEqualTo(String value) {
            addCriterion("day_25_2 <>", value, "day252");
            return (Criteria) this;
        }

        public Criteria andDay252GreaterThan(String value) {
            addCriterion("day_25_2 >", value, "day252");
            return (Criteria) this;
        }

        public Criteria andDay252GreaterThanOrEqualTo(String value) {
            addCriterion("day_25_2 >=", value, "day252");
            return (Criteria) this;
        }

        public Criteria andDay252LessThan(String value) {
            addCriterion("day_25_2 <", value, "day252");
            return (Criteria) this;
        }

        public Criteria andDay252LessThanOrEqualTo(String value) {
            addCriterion("day_25_2 <=", value, "day252");
            return (Criteria) this;
        }

        public Criteria andDay252Like(String value) {
            addCriterion("day_25_2 like", value, "day252");
            return (Criteria) this;
        }

        public Criteria andDay252NotLike(String value) {
            addCriterion("day_25_2 not like", value, "day252");
            return (Criteria) this;
        }

        public Criteria andDay252In(List<String> values) {
            addCriterion("day_25_2 in", values, "day252");
            return (Criteria) this;
        }

        public Criteria andDay252NotIn(List<String> values) {
            addCriterion("day_25_2 not in", values, "day252");
            return (Criteria) this;
        }

        public Criteria andDay252Between(String value1, String value2) {
            addCriterion("day_25_2 between", value1, value2, "day252");
            return (Criteria) this;
        }

        public Criteria andDay252NotBetween(String value1, String value2) {
            addCriterion("day_25_2 not between", value1, value2, "day252");
            return (Criteria) this;
        }

        public Criteria andDay261IsNull() {
            addCriterion("day_26_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay261IsNotNull() {
            addCriterion("day_26_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay261EqualTo(String value) {
            addCriterion("day_26_1 =", value, "day261");
            return (Criteria) this;
        }

        public Criteria andDay261NotEqualTo(String value) {
            addCriterion("day_26_1 <>", value, "day261");
            return (Criteria) this;
        }

        public Criteria andDay261GreaterThan(String value) {
            addCriterion("day_26_1 >", value, "day261");
            return (Criteria) this;
        }

        public Criteria andDay261GreaterThanOrEqualTo(String value) {
            addCriterion("day_26_1 >=", value, "day261");
            return (Criteria) this;
        }

        public Criteria andDay261LessThan(String value) {
            addCriterion("day_26_1 <", value, "day261");
            return (Criteria) this;
        }

        public Criteria andDay261LessThanOrEqualTo(String value) {
            addCriterion("day_26_1 <=", value, "day261");
            return (Criteria) this;
        }

        public Criteria andDay261Like(String value) {
            addCriterion("day_26_1 like", value, "day261");
            return (Criteria) this;
        }

        public Criteria andDay261NotLike(String value) {
            addCriterion("day_26_1 not like", value, "day261");
            return (Criteria) this;
        }

        public Criteria andDay261In(List<String> values) {
            addCriterion("day_26_1 in", values, "day261");
            return (Criteria) this;
        }

        public Criteria andDay261NotIn(List<String> values) {
            addCriterion("day_26_1 not in", values, "day261");
            return (Criteria) this;
        }

        public Criteria andDay261Between(String value1, String value2) {
            addCriterion("day_26_1 between", value1, value2, "day261");
            return (Criteria) this;
        }

        public Criteria andDay261NotBetween(String value1, String value2) {
            addCriterion("day_26_1 not between", value1, value2, "day261");
            return (Criteria) this;
        }

        public Criteria andDay262IsNull() {
            addCriterion("day_26_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay262IsNotNull() {
            addCriterion("day_26_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay262EqualTo(String value) {
            addCriterion("day_26_2 =", value, "day262");
            return (Criteria) this;
        }

        public Criteria andDay262NotEqualTo(String value) {
            addCriterion("day_26_2 <>", value, "day262");
            return (Criteria) this;
        }

        public Criteria andDay262GreaterThan(String value) {
            addCriterion("day_26_2 >", value, "day262");
            return (Criteria) this;
        }

        public Criteria andDay262GreaterThanOrEqualTo(String value) {
            addCriterion("day_26_2 >=", value, "day262");
            return (Criteria) this;
        }

        public Criteria andDay262LessThan(String value) {
            addCriterion("day_26_2 <", value, "day262");
            return (Criteria) this;
        }

        public Criteria andDay262LessThanOrEqualTo(String value) {
            addCriterion("day_26_2 <=", value, "day262");
            return (Criteria) this;
        }

        public Criteria andDay262Like(String value) {
            addCriterion("day_26_2 like", value, "day262");
            return (Criteria) this;
        }

        public Criteria andDay262NotLike(String value) {
            addCriterion("day_26_2 not like", value, "day262");
            return (Criteria) this;
        }

        public Criteria andDay262In(List<String> values) {
            addCriterion("day_26_2 in", values, "day262");
            return (Criteria) this;
        }

        public Criteria andDay262NotIn(List<String> values) {
            addCriterion("day_26_2 not in", values, "day262");
            return (Criteria) this;
        }

        public Criteria andDay262Between(String value1, String value2) {
            addCriterion("day_26_2 between", value1, value2, "day262");
            return (Criteria) this;
        }

        public Criteria andDay262NotBetween(String value1, String value2) {
            addCriterion("day_26_2 not between", value1, value2, "day262");
            return (Criteria) this;
        }

        public Criteria andDay271IsNull() {
            addCriterion("day_27_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay271IsNotNull() {
            addCriterion("day_27_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay271EqualTo(String value) {
            addCriterion("day_27_1 =", value, "day271");
            return (Criteria) this;
        }

        public Criteria andDay271NotEqualTo(String value) {
            addCriterion("day_27_1 <>", value, "day271");
            return (Criteria) this;
        }

        public Criteria andDay271GreaterThan(String value) {
            addCriterion("day_27_1 >", value, "day271");
            return (Criteria) this;
        }

        public Criteria andDay271GreaterThanOrEqualTo(String value) {
            addCriterion("day_27_1 >=", value, "day271");
            return (Criteria) this;
        }

        public Criteria andDay271LessThan(String value) {
            addCriterion("day_27_1 <", value, "day271");
            return (Criteria) this;
        }

        public Criteria andDay271LessThanOrEqualTo(String value) {
            addCriterion("day_27_1 <=", value, "day271");
            return (Criteria) this;
        }

        public Criteria andDay271Like(String value) {
            addCriterion("day_27_1 like", value, "day271");
            return (Criteria) this;
        }

        public Criteria andDay271NotLike(String value) {
            addCriterion("day_27_1 not like", value, "day271");
            return (Criteria) this;
        }

        public Criteria andDay271In(List<String> values) {
            addCriterion("day_27_1 in", values, "day271");
            return (Criteria) this;
        }

        public Criteria andDay271NotIn(List<String> values) {
            addCriterion("day_27_1 not in", values, "day271");
            return (Criteria) this;
        }

        public Criteria andDay271Between(String value1, String value2) {
            addCriterion("day_27_1 between", value1, value2, "day271");
            return (Criteria) this;
        }

        public Criteria andDay271NotBetween(String value1, String value2) {
            addCriterion("day_27_1 not between", value1, value2, "day271");
            return (Criteria) this;
        }

        public Criteria andDay272IsNull() {
            addCriterion("day_27_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay272IsNotNull() {
            addCriterion("day_27_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay272EqualTo(String value) {
            addCriterion("day_27_2 =", value, "day272");
            return (Criteria) this;
        }

        public Criteria andDay272NotEqualTo(String value) {
            addCriterion("day_27_2 <>", value, "day272");
            return (Criteria) this;
        }

        public Criteria andDay272GreaterThan(String value) {
            addCriterion("day_27_2 >", value, "day272");
            return (Criteria) this;
        }

        public Criteria andDay272GreaterThanOrEqualTo(String value) {
            addCriterion("day_27_2 >=", value, "day272");
            return (Criteria) this;
        }

        public Criteria andDay272LessThan(String value) {
            addCriterion("day_27_2 <", value, "day272");
            return (Criteria) this;
        }

        public Criteria andDay272LessThanOrEqualTo(String value) {
            addCriterion("day_27_2 <=", value, "day272");
            return (Criteria) this;
        }

        public Criteria andDay272Like(String value) {
            addCriterion("day_27_2 like", value, "day272");
            return (Criteria) this;
        }

        public Criteria andDay272NotLike(String value) {
            addCriterion("day_27_2 not like", value, "day272");
            return (Criteria) this;
        }

        public Criteria andDay272In(List<String> values) {
            addCriterion("day_27_2 in", values, "day272");
            return (Criteria) this;
        }

        public Criteria andDay272NotIn(List<String> values) {
            addCriterion("day_27_2 not in", values, "day272");
            return (Criteria) this;
        }

        public Criteria andDay272Between(String value1, String value2) {
            addCriterion("day_27_2 between", value1, value2, "day272");
            return (Criteria) this;
        }

        public Criteria andDay272NotBetween(String value1, String value2) {
            addCriterion("day_27_2 not between", value1, value2, "day272");
            return (Criteria) this;
        }

        public Criteria andDay281IsNull() {
            addCriterion("day_28_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay281IsNotNull() {
            addCriterion("day_28_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay281EqualTo(String value) {
            addCriterion("day_28_1 =", value, "day281");
            return (Criteria) this;
        }

        public Criteria andDay281NotEqualTo(String value) {
            addCriterion("day_28_1 <>", value, "day281");
            return (Criteria) this;
        }

        public Criteria andDay281GreaterThan(String value) {
            addCriterion("day_28_1 >", value, "day281");
            return (Criteria) this;
        }

        public Criteria andDay281GreaterThanOrEqualTo(String value) {
            addCriterion("day_28_1 >=", value, "day281");
            return (Criteria) this;
        }

        public Criteria andDay281LessThan(String value) {
            addCriterion("day_28_1 <", value, "day281");
            return (Criteria) this;
        }

        public Criteria andDay281LessThanOrEqualTo(String value) {
            addCriterion("day_28_1 <=", value, "day281");
            return (Criteria) this;
        }

        public Criteria andDay281Like(String value) {
            addCriterion("day_28_1 like", value, "day281");
            return (Criteria) this;
        }

        public Criteria andDay281NotLike(String value) {
            addCriterion("day_28_1 not like", value, "day281");
            return (Criteria) this;
        }

        public Criteria andDay281In(List<String> values) {
            addCriterion("day_28_1 in", values, "day281");
            return (Criteria) this;
        }

        public Criteria andDay281NotIn(List<String> values) {
            addCriterion("day_28_1 not in", values, "day281");
            return (Criteria) this;
        }

        public Criteria andDay281Between(String value1, String value2) {
            addCriterion("day_28_1 between", value1, value2, "day281");
            return (Criteria) this;
        }

        public Criteria andDay281NotBetween(String value1, String value2) {
            addCriterion("day_28_1 not between", value1, value2, "day281");
            return (Criteria) this;
        }

        public Criteria andDay282IsNull() {
            addCriterion("day_28_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay282IsNotNull() {
            addCriterion("day_28_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay282EqualTo(String value) {
            addCriterion("day_28_2 =", value, "day282");
            return (Criteria) this;
        }

        public Criteria andDay282NotEqualTo(String value) {
            addCriterion("day_28_2 <>", value, "day282");
            return (Criteria) this;
        }

        public Criteria andDay282GreaterThan(String value) {
            addCriterion("day_28_2 >", value, "day282");
            return (Criteria) this;
        }

        public Criteria andDay282GreaterThanOrEqualTo(String value) {
            addCriterion("day_28_2 >=", value, "day282");
            return (Criteria) this;
        }

        public Criteria andDay282LessThan(String value) {
            addCriterion("day_28_2 <", value, "day282");
            return (Criteria) this;
        }

        public Criteria andDay282LessThanOrEqualTo(String value) {
            addCriterion("day_28_2 <=", value, "day282");
            return (Criteria) this;
        }

        public Criteria andDay282Like(String value) {
            addCriterion("day_28_2 like", value, "day282");
            return (Criteria) this;
        }

        public Criteria andDay282NotLike(String value) {
            addCriterion("day_28_2 not like", value, "day282");
            return (Criteria) this;
        }

        public Criteria andDay282In(List<String> values) {
            addCriterion("day_28_2 in", values, "day282");
            return (Criteria) this;
        }

        public Criteria andDay282NotIn(List<String> values) {
            addCriterion("day_28_2 not in", values, "day282");
            return (Criteria) this;
        }

        public Criteria andDay282Between(String value1, String value2) {
            addCriterion("day_28_2 between", value1, value2, "day282");
            return (Criteria) this;
        }

        public Criteria andDay282NotBetween(String value1, String value2) {
            addCriterion("day_28_2 not between", value1, value2, "day282");
            return (Criteria) this;
        }

        public Criteria andDay291IsNull() {
            addCriterion("day_29_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay291IsNotNull() {
            addCriterion("day_29_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay291EqualTo(String value) {
            addCriterion("day_29_1 =", value, "day291");
            return (Criteria) this;
        }

        public Criteria andDay291NotEqualTo(String value) {
            addCriterion("day_29_1 <>", value, "day291");
            return (Criteria) this;
        }

        public Criteria andDay291GreaterThan(String value) {
            addCriterion("day_29_1 >", value, "day291");
            return (Criteria) this;
        }

        public Criteria andDay291GreaterThanOrEqualTo(String value) {
            addCriterion("day_29_1 >=", value, "day291");
            return (Criteria) this;
        }

        public Criteria andDay291LessThan(String value) {
            addCriterion("day_29_1 <", value, "day291");
            return (Criteria) this;
        }

        public Criteria andDay291LessThanOrEqualTo(String value) {
            addCriterion("day_29_1 <=", value, "day291");
            return (Criteria) this;
        }

        public Criteria andDay291Like(String value) {
            addCriterion("day_29_1 like", value, "day291");
            return (Criteria) this;
        }

        public Criteria andDay291NotLike(String value) {
            addCriterion("day_29_1 not like", value, "day291");
            return (Criteria) this;
        }

        public Criteria andDay291In(List<String> values) {
            addCriterion("day_29_1 in", values, "day291");
            return (Criteria) this;
        }

        public Criteria andDay291NotIn(List<String> values) {
            addCriterion("day_29_1 not in", values, "day291");
            return (Criteria) this;
        }

        public Criteria andDay291Between(String value1, String value2) {
            addCriterion("day_29_1 between", value1, value2, "day291");
            return (Criteria) this;
        }

        public Criteria andDay291NotBetween(String value1, String value2) {
            addCriterion("day_29_1 not between", value1, value2, "day291");
            return (Criteria) this;
        }

        public Criteria andDay292IsNull() {
            addCriterion("day_29_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay292IsNotNull() {
            addCriterion("day_29_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay292EqualTo(String value) {
            addCriterion("day_29_2 =", value, "day292");
            return (Criteria) this;
        }

        public Criteria andDay292NotEqualTo(String value) {
            addCriterion("day_29_2 <>", value, "day292");
            return (Criteria) this;
        }

        public Criteria andDay292GreaterThan(String value) {
            addCriterion("day_29_2 >", value, "day292");
            return (Criteria) this;
        }

        public Criteria andDay292GreaterThanOrEqualTo(String value) {
            addCriterion("day_29_2 >=", value, "day292");
            return (Criteria) this;
        }

        public Criteria andDay292LessThan(String value) {
            addCriterion("day_29_2 <", value, "day292");
            return (Criteria) this;
        }

        public Criteria andDay292LessThanOrEqualTo(String value) {
            addCriterion("day_29_2 <=", value, "day292");
            return (Criteria) this;
        }

        public Criteria andDay292Like(String value) {
            addCriterion("day_29_2 like", value, "day292");
            return (Criteria) this;
        }

        public Criteria andDay292NotLike(String value) {
            addCriterion("day_29_2 not like", value, "day292");
            return (Criteria) this;
        }

        public Criteria andDay292In(List<String> values) {
            addCriterion("day_29_2 in", values, "day292");
            return (Criteria) this;
        }

        public Criteria andDay292NotIn(List<String> values) {
            addCriterion("day_29_2 not in", values, "day292");
            return (Criteria) this;
        }

        public Criteria andDay292Between(String value1, String value2) {
            addCriterion("day_29_2 between", value1, value2, "day292");
            return (Criteria) this;
        }

        public Criteria andDay292NotBetween(String value1, String value2) {
            addCriterion("day_29_2 not between", value1, value2, "day292");
            return (Criteria) this;
        }

        public Criteria andDay301IsNull() {
            addCriterion("day_30_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay301IsNotNull() {
            addCriterion("day_30_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay301EqualTo(String value) {
            addCriterion("day_30_1 =", value, "day301");
            return (Criteria) this;
        }

        public Criteria andDay301NotEqualTo(String value) {
            addCriterion("day_30_1 <>", value, "day301");
            return (Criteria) this;
        }

        public Criteria andDay301GreaterThan(String value) {
            addCriterion("day_30_1 >", value, "day301");
            return (Criteria) this;
        }

        public Criteria andDay301GreaterThanOrEqualTo(String value) {
            addCriterion("day_30_1 >=", value, "day301");
            return (Criteria) this;
        }

        public Criteria andDay301LessThan(String value) {
            addCriterion("day_30_1 <", value, "day301");
            return (Criteria) this;
        }

        public Criteria andDay301LessThanOrEqualTo(String value) {
            addCriterion("day_30_1 <=", value, "day301");
            return (Criteria) this;
        }

        public Criteria andDay301Like(String value) {
            addCriterion("day_30_1 like", value, "day301");
            return (Criteria) this;
        }

        public Criteria andDay301NotLike(String value) {
            addCriterion("day_30_1 not like", value, "day301");
            return (Criteria) this;
        }

        public Criteria andDay301In(List<String> values) {
            addCriterion("day_30_1 in", values, "day301");
            return (Criteria) this;
        }

        public Criteria andDay301NotIn(List<String> values) {
            addCriterion("day_30_1 not in", values, "day301");
            return (Criteria) this;
        }

        public Criteria andDay301Between(String value1, String value2) {
            addCriterion("day_30_1 between", value1, value2, "day301");
            return (Criteria) this;
        }

        public Criteria andDay301NotBetween(String value1, String value2) {
            addCriterion("day_30_1 not between", value1, value2, "day301");
            return (Criteria) this;
        }

        public Criteria andDay302IsNull() {
            addCriterion("day_30_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay302IsNotNull() {
            addCriterion("day_30_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay302EqualTo(String value) {
            addCriterion("day_30_2 =", value, "day302");
            return (Criteria) this;
        }

        public Criteria andDay302NotEqualTo(String value) {
            addCriterion("day_30_2 <>", value, "day302");
            return (Criteria) this;
        }

        public Criteria andDay302GreaterThan(String value) {
            addCriterion("day_30_2 >", value, "day302");
            return (Criteria) this;
        }

        public Criteria andDay302GreaterThanOrEqualTo(String value) {
            addCriterion("day_30_2 >=", value, "day302");
            return (Criteria) this;
        }

        public Criteria andDay302LessThan(String value) {
            addCriterion("day_30_2 <", value, "day302");
            return (Criteria) this;
        }

        public Criteria andDay302LessThanOrEqualTo(String value) {
            addCriterion("day_30_2 <=", value, "day302");
            return (Criteria) this;
        }

        public Criteria andDay302Like(String value) {
            addCriterion("day_30_2 like", value, "day302");
            return (Criteria) this;
        }

        public Criteria andDay302NotLike(String value) {
            addCriterion("day_30_2 not like", value, "day302");
            return (Criteria) this;
        }

        public Criteria andDay302In(List<String> values) {
            addCriterion("day_30_2 in", values, "day302");
            return (Criteria) this;
        }

        public Criteria andDay302NotIn(List<String> values) {
            addCriterion("day_30_2 not in", values, "day302");
            return (Criteria) this;
        }

        public Criteria andDay302Between(String value1, String value2) {
            addCriterion("day_30_2 between", value1, value2, "day302");
            return (Criteria) this;
        }

        public Criteria andDay302NotBetween(String value1, String value2) {
            addCriterion("day_30_2 not between", value1, value2, "day302");
            return (Criteria) this;
        }

        public Criteria andDay311IsNull() {
            addCriterion("day_31_1 is null");
            return (Criteria) this;
        }

        public Criteria andDay311IsNotNull() {
            addCriterion("day_31_1 is not null");
            return (Criteria) this;
        }

        public Criteria andDay311EqualTo(String value) {
            addCriterion("day_31_1 =", value, "day311");
            return (Criteria) this;
        }

        public Criteria andDay311NotEqualTo(String value) {
            addCriterion("day_31_1 <>", value, "day311");
            return (Criteria) this;
        }

        public Criteria andDay311GreaterThan(String value) {
            addCriterion("day_31_1 >", value, "day311");
            return (Criteria) this;
        }

        public Criteria andDay311GreaterThanOrEqualTo(String value) {
            addCriterion("day_31_1 >=", value, "day311");
            return (Criteria) this;
        }

        public Criteria andDay311LessThan(String value) {
            addCriterion("day_31_1 <", value, "day311");
            return (Criteria) this;
        }

        public Criteria andDay311LessThanOrEqualTo(String value) {
            addCriterion("day_31_1 <=", value, "day311");
            return (Criteria) this;
        }

        public Criteria andDay311Like(String value) {
            addCriterion("day_31_1 like", value, "day311");
            return (Criteria) this;
        }

        public Criteria andDay311NotLike(String value) {
            addCriterion("day_31_1 not like", value, "day311");
            return (Criteria) this;
        }

        public Criteria andDay311In(List<String> values) {
            addCriterion("day_31_1 in", values, "day311");
            return (Criteria) this;
        }

        public Criteria andDay311NotIn(List<String> values) {
            addCriterion("day_31_1 not in", values, "day311");
            return (Criteria) this;
        }

        public Criteria andDay311Between(String value1, String value2) {
            addCriterion("day_31_1 between", value1, value2, "day311");
            return (Criteria) this;
        }

        public Criteria andDay311NotBetween(String value1, String value2) {
            addCriterion("day_31_1 not between", value1, value2, "day311");
            return (Criteria) this;
        }

        public Criteria andDay312IsNull() {
            addCriterion("day_31_2 is null");
            return (Criteria) this;
        }

        public Criteria andDay312IsNotNull() {
            addCriterion("day_31_2 is not null");
            return (Criteria) this;
        }

        public Criteria andDay312EqualTo(String value) {
            addCriterion("day_31_2 =", value, "day312");
            return (Criteria) this;
        }

        public Criteria andDay312NotEqualTo(String value) {
            addCriterion("day_31_2 <>", value, "day312");
            return (Criteria) this;
        }

        public Criteria andDay312GreaterThan(String value) {
            addCriterion("day_31_2 >", value, "day312");
            return (Criteria) this;
        }

        public Criteria andDay312GreaterThanOrEqualTo(String value) {
            addCriterion("day_31_2 >=", value, "day312");
            return (Criteria) this;
        }

        public Criteria andDay312LessThan(String value) {
            addCriterion("day_31_2 <", value, "day312");
            return (Criteria) this;
        }

        public Criteria andDay312LessThanOrEqualTo(String value) {
            addCriterion("day_31_2 <=", value, "day312");
            return (Criteria) this;
        }

        public Criteria andDay312Like(String value) {
            addCriterion("day_31_2 like", value, "day312");
            return (Criteria) this;
        }

        public Criteria andDay312NotLike(String value) {
            addCriterion("day_31_2 not like", value, "day312");
            return (Criteria) this;
        }

        public Criteria andDay312In(List<String> values) {
            addCriterion("day_31_2 in", values, "day312");
            return (Criteria) this;
        }

        public Criteria andDay312NotIn(List<String> values) {
            addCriterion("day_31_2 not in", values, "day312");
            return (Criteria) this;
        }

        public Criteria andDay312Between(String value1, String value2) {
            addCriterion("day_31_2 between", value1, value2, "day312");
            return (Criteria) this;
        }

        public Criteria andDay312NotBetween(String value1, String value2) {
            addCriterion("day_31_2 not between", value1, value2, "day312");
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