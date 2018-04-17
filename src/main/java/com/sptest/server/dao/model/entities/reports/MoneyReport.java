package com.sptest.server.dao.model.entities.reports;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "money_report")
public class MoneyReport {

    @Id
    private String id;
    private String employeeId;
    private String dayMoney;
    private String lastLocalDate;
    private int code;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getDayMoney() {
        return dayMoney;
    }

    public String getLastLocalDate() {
        return lastLocalDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setDayMoney(String dayMoney) {
        this.dayMoney = dayMoney;
    }

    public void setLastLocalDate(String lastLocalDate) {
        this.lastLocalDate = lastLocalDate;
    }


    public MoneyReport(int code, String id, String employeeId, String dayMoney,
        String lastLocalDate) {
        this(id, employeeId, dayMoney, lastLocalDate);
        this.code = code;
    }

    public MoneyReport(String id, String employeeId, String dayMoney, String lastLocalDate) {
        this(employeeId, dayMoney, lastLocalDate);
        this.id = id;
    }

    public MoneyReport(String employeeId, String dayMoney, String lastLocalDate) {
        this.employeeId = employeeId;
        this.dayMoney = dayMoney;
        this.lastLocalDate = lastLocalDate;
    }

    public MoneyReport() {
        //default
    }

    @Override
    public String toString() {
        return "MoneyReport{" +
            "id='" + id + '\'' +
            ", employeeId='" + employeeId + '\'' +
            ", dayMoney='" + dayMoney + '\'' +
            ", lastLocalDate='" + lastLocalDate + '\'' +
            ", code=" + code +
            '}';
    }
}
