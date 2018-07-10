package com.creator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Setter
@Getter
@ToString
public class Breakfast implements Serializable{
    private Date wakingTime;
    private List<String> food;
    private List<String> medicine;
}
