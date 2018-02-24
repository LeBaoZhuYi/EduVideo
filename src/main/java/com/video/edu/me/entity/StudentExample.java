package com.video.edu.me.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Integer value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Integer value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Integer value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Integer value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Integer> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Integer> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNull() {
            addCriterion("group_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("group_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("group_name =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("group_name >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("group_name <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("group_name like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("group_name not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("group_name in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("group_name not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andStudyIdIsNull() {
            addCriterion("study_id is null");
            return (Criteria) this;
        }

        public Criteria andStudyIdIsNotNull() {
            addCriterion("study_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudyIdEqualTo(String value) {
            addCriterion("study_id =", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdNotEqualTo(String value) {
            addCriterion("study_id <>", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdGreaterThan(String value) {
            addCriterion("study_id >", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdGreaterThanOrEqualTo(String value) {
            addCriterion("study_id >=", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdLessThan(String value) {
            addCriterion("study_id <", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdLessThanOrEqualTo(String value) {
            addCriterion("study_id <=", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdLike(String value) {
            addCriterion("study_id like", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdNotLike(String value) {
            addCriterion("study_id not like", value, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdIn(List<String> values) {
            addCriterion("study_id in", values, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdNotIn(List<String> values) {
            addCriterion("study_id not in", values, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdBetween(String value1, String value2) {
            addCriterion("study_id between", value1, value2, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyIdNotBetween(String value1, String value2) {
            addCriterion("study_id not between", value1, value2, "studyId");
            return (Criteria) this;
        }

        public Criteria andStudyNameIsNull() {
            addCriterion("study_name is null");
            return (Criteria) this;
        }

        public Criteria andStudyNameIsNotNull() {
            addCriterion("study_name is not null");
            return (Criteria) this;
        }

        public Criteria andStudyNameEqualTo(String value) {
            addCriterion("study_name =", value, "studyName");
            return (Criteria) this;
        }

        public Criteria andStudyNameNotEqualTo(String value) {
            addCriterion("study_name <>", value, "studyName");
            return (Criteria) this;
        }

        public Criteria andStudyNameGreaterThan(String value) {
            addCriterion("study_name >", value, "studyName");
            return (Criteria) this;
        }

        public Criteria andStudyNameGreaterThanOrEqualTo(String value) {
            addCriterion("study_name >=", value, "studyName");
            return (Criteria) this;
        }

        public Criteria andStudyNameLessThan(String value) {
            addCriterion("study_name <", value, "studyName");
            return (Criteria) this;
        }

        public Criteria andStudyNameLessThanOrEqualTo(String value) {
            addCriterion("study_name <=", value, "studyName");
            return (Criteria) this;
        }

        public Criteria andStudyNameLike(String value) {
            addCriterion("study_name like", value, "studyName");
            return (Criteria) this;
        }

        public Criteria andStudyNameNotLike(String value) {
            addCriterion("study_name not like", value, "studyName");
            return (Criteria) this;
        }

        public Criteria andStudyNameIn(List<String> values) {
            addCriterion("study_name in", values, "studyName");
            return (Criteria) this;
        }

        public Criteria andStudyNameNotIn(List<String> values) {
            addCriterion("study_name not in", values, "studyName");
            return (Criteria) this;
        }

        public Criteria andStudyNameBetween(String value1, String value2) {
            addCriterion("study_name between", value1, value2, "studyName");
            return (Criteria) this;
        }

        public Criteria andStudyNameNotBetween(String value1, String value2) {
            addCriterion("study_name not between", value1, value2, "studyName");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(Date value) {
            addCriterion("ctime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(Date value) {
            addCriterion("ctime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(Date value) {
            addCriterion("ctime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ctime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(Date value) {
            addCriterion("ctime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(Date value) {
            addCriterion("ctime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<Date> values) {
            addCriterion("ctime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<Date> values) {
            addCriterion("ctime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(Date value1, Date value2) {
            addCriterion("ctime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(Date value1, Date value2) {
            addCriterion("ctime not between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andUtimeIsNull() {
            addCriterion("utime is null");
            return (Criteria) this;
        }

        public Criteria andUtimeIsNotNull() {
            addCriterion("utime is not null");
            return (Criteria) this;
        }

        public Criteria andUtimeEqualTo(Date value) {
            addCriterion("utime =", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotEqualTo(Date value) {
            addCriterion("utime <>", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeGreaterThan(Date value) {
            addCriterion("utime >", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("utime >=", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeLessThan(Date value) {
            addCriterion("utime <", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeLessThanOrEqualTo(Date value) {
            addCriterion("utime <=", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeIn(List<Date> values) {
            addCriterion("utime in", values, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotIn(List<Date> values) {
            addCriterion("utime not in", values, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeBetween(Date value1, Date value2) {
            addCriterion("utime between", value1, value2, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotBetween(Date value1, Date value2) {
            addCriterion("utime not between", value1, value2, "utime");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Byte value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Byte value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Byte value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Byte value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Byte value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Byte> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Byte> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Byte value1, Byte value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Byte value1, Byte value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andStudyIntroIsNull() {
            addCriterion("study_intro is null");
            return (Criteria) this;
        }

        public Criteria andStudyIntroIsNotNull() {
            addCriterion("study_intro is not null");
            return (Criteria) this;
        }

        public Criteria andStudyIntroEqualTo(String value) {
            addCriterion("study_intro =", value, "studyIntro");
            return (Criteria) this;
        }

        public Criteria andStudyIntroNotEqualTo(String value) {
            addCriterion("study_intro <>", value, "studyIntro");
            return (Criteria) this;
        }

        public Criteria andStudyIntroGreaterThan(String value) {
            addCriterion("study_intro >", value, "studyIntro");
            return (Criteria) this;
        }

        public Criteria andStudyIntroGreaterThanOrEqualTo(String value) {
            addCriterion("study_intro >=", value, "studyIntro");
            return (Criteria) this;
        }

        public Criteria andStudyIntroLessThan(String value) {
            addCriterion("study_intro <", value, "studyIntro");
            return (Criteria) this;
        }

        public Criteria andStudyIntroLessThanOrEqualTo(String value) {
            addCriterion("study_intro <=", value, "studyIntro");
            return (Criteria) this;
        }

        public Criteria andStudyIntroLike(String value) {
            addCriterion("study_intro like", value, "studyIntro");
            return (Criteria) this;
        }

        public Criteria andStudyIntroNotLike(String value) {
            addCriterion("study_intro not like", value, "studyIntro");
            return (Criteria) this;
        }

        public Criteria andStudyIntroIn(List<String> values) {
            addCriterion("study_intro in", values, "studyIntro");
            return (Criteria) this;
        }

        public Criteria andStudyIntroNotIn(List<String> values) {
            addCriterion("study_intro not in", values, "studyIntro");
            return (Criteria) this;
        }

        public Criteria andStudyIntroBetween(String value1, String value2) {
            addCriterion("study_intro between", value1, value2, "studyIntro");
            return (Criteria) this;
        }

        public Criteria andStudyIntroNotBetween(String value1, String value2) {
            addCriterion("study_intro not between", value1, value2, "studyIntro");
            return (Criteria) this;
        }

        public Criteria andTeacherRemarkIsNull() {
            addCriterion("teacher_remark is null");
            return (Criteria) this;
        }

        public Criteria andTeacherRemarkIsNotNull() {
            addCriterion("teacher_remark is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherRemarkEqualTo(String value) {
            addCriterion("teacher_remark =", value, "teacherRemark");
            return (Criteria) this;
        }

        public Criteria andTeacherRemarkNotEqualTo(String value) {
            addCriterion("teacher_remark <>", value, "teacherRemark");
            return (Criteria) this;
        }

        public Criteria andTeacherRemarkGreaterThan(String value) {
            addCriterion("teacher_remark >", value, "teacherRemark");
            return (Criteria) this;
        }

        public Criteria andTeacherRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_remark >=", value, "teacherRemark");
            return (Criteria) this;
        }

        public Criteria andTeacherRemarkLessThan(String value) {
            addCriterion("teacher_remark <", value, "teacherRemark");
            return (Criteria) this;
        }

        public Criteria andTeacherRemarkLessThanOrEqualTo(String value) {
            addCriterion("teacher_remark <=", value, "teacherRemark");
            return (Criteria) this;
        }

        public Criteria andTeacherRemarkLike(String value) {
            addCriterion("teacher_remark like", value, "teacherRemark");
            return (Criteria) this;
        }

        public Criteria andTeacherRemarkNotLike(String value) {
            addCriterion("teacher_remark not like", value, "teacherRemark");
            return (Criteria) this;
        }

        public Criteria andTeacherRemarkIn(List<String> values) {
            addCriterion("teacher_remark in", values, "teacherRemark");
            return (Criteria) this;
        }

        public Criteria andTeacherRemarkNotIn(List<String> values) {
            addCriterion("teacher_remark not in", values, "teacherRemark");
            return (Criteria) this;
        }

        public Criteria andTeacherRemarkBetween(String value1, String value2) {
            addCriterion("teacher_remark between", value1, value2, "teacherRemark");
            return (Criteria) this;
        }

        public Criteria andTeacherRemarkNotBetween(String value1, String value2) {
            addCriterion("teacher_remark not between", value1, value2, "teacherRemark");
            return (Criteria) this;
        }

        public Criteria andParentWordsIsNull() {
            addCriterion("parent_words is null");
            return (Criteria) this;
        }

        public Criteria andParentWordsIsNotNull() {
            addCriterion("parent_words is not null");
            return (Criteria) this;
        }

        public Criteria andParentWordsEqualTo(String value) {
            addCriterion("parent_words =", value, "parentWords");
            return (Criteria) this;
        }

        public Criteria andParentWordsNotEqualTo(String value) {
            addCriterion("parent_words <>", value, "parentWords");
            return (Criteria) this;
        }

        public Criteria andParentWordsGreaterThan(String value) {
            addCriterion("parent_words >", value, "parentWords");
            return (Criteria) this;
        }

        public Criteria andParentWordsGreaterThanOrEqualTo(String value) {
            addCriterion("parent_words >=", value, "parentWords");
            return (Criteria) this;
        }

        public Criteria andParentWordsLessThan(String value) {
            addCriterion("parent_words <", value, "parentWords");
            return (Criteria) this;
        }

        public Criteria andParentWordsLessThanOrEqualTo(String value) {
            addCriterion("parent_words <=", value, "parentWords");
            return (Criteria) this;
        }

        public Criteria andParentWordsLike(String value) {
            addCriterion("parent_words like", value, "parentWords");
            return (Criteria) this;
        }

        public Criteria andParentWordsNotLike(String value) {
            addCriterion("parent_words not like", value, "parentWords");
            return (Criteria) this;
        }

        public Criteria andParentWordsIn(List<String> values) {
            addCriterion("parent_words in", values, "parentWords");
            return (Criteria) this;
        }

        public Criteria andParentWordsNotIn(List<String> values) {
            addCriterion("parent_words not in", values, "parentWords");
            return (Criteria) this;
        }

        public Criteria andParentWordsBetween(String value1, String value2) {
            addCriterion("parent_words between", value1, value2, "parentWords");
            return (Criteria) this;
        }

        public Criteria andParentWordsNotBetween(String value1, String value2) {
            addCriterion("parent_words not between", value1, value2, "parentWords");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("birthday like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("birthday not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andFoodIsNull() {
            addCriterion("food is null");
            return (Criteria) this;
        }

        public Criteria andFoodIsNotNull() {
            addCriterion("food is not null");
            return (Criteria) this;
        }

        public Criteria andFoodEqualTo(String value) {
            addCriterion("food =", value, "food");
            return (Criteria) this;
        }

        public Criteria andFoodNotEqualTo(String value) {
            addCriterion("food <>", value, "food");
            return (Criteria) this;
        }

        public Criteria andFoodGreaterThan(String value) {
            addCriterion("food >", value, "food");
            return (Criteria) this;
        }

        public Criteria andFoodGreaterThanOrEqualTo(String value) {
            addCriterion("food >=", value, "food");
            return (Criteria) this;
        }

        public Criteria andFoodLessThan(String value) {
            addCriterion("food <", value, "food");
            return (Criteria) this;
        }

        public Criteria andFoodLessThanOrEqualTo(String value) {
            addCriterion("food <=", value, "food");
            return (Criteria) this;
        }

        public Criteria andFoodLike(String value) {
            addCriterion("food like", value, "food");
            return (Criteria) this;
        }

        public Criteria andFoodNotLike(String value) {
            addCriterion("food not like", value, "food");
            return (Criteria) this;
        }

        public Criteria andFoodIn(List<String> values) {
            addCriterion("food in", values, "food");
            return (Criteria) this;
        }

        public Criteria andFoodNotIn(List<String> values) {
            addCriterion("food not in", values, "food");
            return (Criteria) this;
        }

        public Criteria andFoodBetween(String value1, String value2) {
            addCriterion("food between", value1, value2, "food");
            return (Criteria) this;
        }

        public Criteria andFoodNotBetween(String value1, String value2) {
            addCriterion("food not between", value1, value2, "food");
            return (Criteria) this;
        }

        public Criteria andInterestIsNull() {
            addCriterion("interest is null");
            return (Criteria) this;
        }

        public Criteria andInterestIsNotNull() {
            addCriterion("interest is not null");
            return (Criteria) this;
        }

        public Criteria andInterestEqualTo(String value) {
            addCriterion("interest =", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotEqualTo(String value) {
            addCriterion("interest <>", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestGreaterThan(String value) {
            addCriterion("interest >", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestGreaterThanOrEqualTo(String value) {
            addCriterion("interest >=", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLessThan(String value) {
            addCriterion("interest <", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLessThanOrEqualTo(String value) {
            addCriterion("interest <=", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestLike(String value) {
            addCriterion("interest like", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotLike(String value) {
            addCriterion("interest not like", value, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestIn(List<String> values) {
            addCriterion("interest in", values, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotIn(List<String> values) {
            addCriterion("interest not in", values, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestBetween(String value1, String value2) {
            addCriterion("interest between", value1, value2, "interest");
            return (Criteria) this;
        }

        public Criteria andInterestNotBetween(String value1, String value2) {
            addCriterion("interest not between", value1, value2, "interest");
            return (Criteria) this;
        }

        public Criteria andDisagreeIsNull() {
            addCriterion("disagree is null");
            return (Criteria) this;
        }

        public Criteria andDisagreeIsNotNull() {
            addCriterion("disagree is not null");
            return (Criteria) this;
        }

        public Criteria andDisagreeEqualTo(String value) {
            addCriterion("disagree =", value, "disagree");
            return (Criteria) this;
        }

        public Criteria andDisagreeNotEqualTo(String value) {
            addCriterion("disagree <>", value, "disagree");
            return (Criteria) this;
        }

        public Criteria andDisagreeGreaterThan(String value) {
            addCriterion("disagree >", value, "disagree");
            return (Criteria) this;
        }

        public Criteria andDisagreeGreaterThanOrEqualTo(String value) {
            addCriterion("disagree >=", value, "disagree");
            return (Criteria) this;
        }

        public Criteria andDisagreeLessThan(String value) {
            addCriterion("disagree <", value, "disagree");
            return (Criteria) this;
        }

        public Criteria andDisagreeLessThanOrEqualTo(String value) {
            addCriterion("disagree <=", value, "disagree");
            return (Criteria) this;
        }

        public Criteria andDisagreeLike(String value) {
            addCriterion("disagree like", value, "disagree");
            return (Criteria) this;
        }

        public Criteria andDisagreeNotLike(String value) {
            addCriterion("disagree not like", value, "disagree");
            return (Criteria) this;
        }

        public Criteria andDisagreeIn(List<String> values) {
            addCriterion("disagree in", values, "disagree");
            return (Criteria) this;
        }

        public Criteria andDisagreeNotIn(List<String> values) {
            addCriterion("disagree not in", values, "disagree");
            return (Criteria) this;
        }

        public Criteria andDisagreeBetween(String value1, String value2) {
            addCriterion("disagree between", value1, value2, "disagree");
            return (Criteria) this;
        }

        public Criteria andDisagreeNotBetween(String value1, String value2) {
            addCriterion("disagree not between", value1, value2, "disagree");
            return (Criteria) this;
        }

        public Criteria andIdealIsNull() {
            addCriterion("ideal is null");
            return (Criteria) this;
        }

        public Criteria andIdealIsNotNull() {
            addCriterion("ideal is not null");
            return (Criteria) this;
        }

        public Criteria andIdealEqualTo(String value) {
            addCriterion("ideal =", value, "ideal");
            return (Criteria) this;
        }

        public Criteria andIdealNotEqualTo(String value) {
            addCriterion("ideal <>", value, "ideal");
            return (Criteria) this;
        }

        public Criteria andIdealGreaterThan(String value) {
            addCriterion("ideal >", value, "ideal");
            return (Criteria) this;
        }

        public Criteria andIdealGreaterThanOrEqualTo(String value) {
            addCriterion("ideal >=", value, "ideal");
            return (Criteria) this;
        }

        public Criteria andIdealLessThan(String value) {
            addCriterion("ideal <", value, "ideal");
            return (Criteria) this;
        }

        public Criteria andIdealLessThanOrEqualTo(String value) {
            addCriterion("ideal <=", value, "ideal");
            return (Criteria) this;
        }

        public Criteria andIdealLike(String value) {
            addCriterion("ideal like", value, "ideal");
            return (Criteria) this;
        }

        public Criteria andIdealNotLike(String value) {
            addCriterion("ideal not like", value, "ideal");
            return (Criteria) this;
        }

        public Criteria andIdealIn(List<String> values) {
            addCriterion("ideal in", values, "ideal");
            return (Criteria) this;
        }

        public Criteria andIdealNotIn(List<String> values) {
            addCriterion("ideal not in", values, "ideal");
            return (Criteria) this;
        }

        public Criteria andIdealBetween(String value1, String value2) {
            addCriterion("ideal between", value1, value2, "ideal");
            return (Criteria) this;
        }

        public Criteria andIdealNotBetween(String value1, String value2) {
            addCriterion("ideal not between", value1, value2, "ideal");
            return (Criteria) this;
        }

        public Criteria andImgUrlsIsNull() {
            addCriterion("img_urls is null");
            return (Criteria) this;
        }

        public Criteria andImgUrlsIsNotNull() {
            addCriterion("img_urls is not null");
            return (Criteria) this;
        }

        public Criteria andImgUrlsEqualTo(String value) {
            addCriterion("img_urls =", value, "imgUrls");
            return (Criteria) this;
        }

        public Criteria andImgUrlsNotEqualTo(String value) {
            addCriterion("img_urls <>", value, "imgUrls");
            return (Criteria) this;
        }

        public Criteria andImgUrlsGreaterThan(String value) {
            addCriterion("img_urls >", value, "imgUrls");
            return (Criteria) this;
        }

        public Criteria andImgUrlsGreaterThanOrEqualTo(String value) {
            addCriterion("img_urls >=", value, "imgUrls");
            return (Criteria) this;
        }

        public Criteria andImgUrlsLessThan(String value) {
            addCriterion("img_urls <", value, "imgUrls");
            return (Criteria) this;
        }

        public Criteria andImgUrlsLessThanOrEqualTo(String value) {
            addCriterion("img_urls <=", value, "imgUrls");
            return (Criteria) this;
        }

        public Criteria andImgUrlsLike(String value) {
            addCriterion("img_urls like", value, "imgUrls");
            return (Criteria) this;
        }

        public Criteria andImgUrlsNotLike(String value) {
            addCriterion("img_urls not like", value, "imgUrls");
            return (Criteria) this;
        }

        public Criteria andImgUrlsIn(List<String> values) {
            addCriterion("img_urls in", values, "imgUrls");
            return (Criteria) this;
        }

        public Criteria andImgUrlsNotIn(List<String> values) {
            addCriterion("img_urls not in", values, "imgUrls");
            return (Criteria) this;
        }

        public Criteria andImgUrlsBetween(String value1, String value2) {
            addCriterion("img_urls between", value1, value2, "imgUrls");
            return (Criteria) this;
        }

        public Criteria andImgUrlsNotBetween(String value1, String value2) {
            addCriterion("img_urls not between", value1, value2, "imgUrls");
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