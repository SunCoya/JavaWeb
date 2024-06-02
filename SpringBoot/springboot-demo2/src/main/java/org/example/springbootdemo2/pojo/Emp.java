package org.example.springbootdemo2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Short gender;
    private String image;
    private Short job;
    private LocalDate entrydate;
    private Integer deptId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Emp(String username, String name, Short gender, String image, Short job, LocalDate entrydate, Integer deptId, LocalDateTime createTime, LocalDateTime updateTime) {
        this.username = username;
        this.name = name;
        this.gender = gender;
        this.image = image;
        this.job = job;
        this.entrydate = entrydate;
        this.deptId = deptId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
