package com.creator.model;

/**
 * @author zhangzeyu
 */

public enum WindDirection {

    /**
     *
     */
    NORTHWEST(1,"西北风"),
    /**
     *
     */
    SOUTHWEST(2,"西南风"),
    /**
     *
     */
    NORTHEAST(3,"东北风"),
    /**
     *
     */
    SOUTHEAST(4,"东南风"),
    /**
     *
     */
    NORTH(5,"北风"),
    /**
     *
     */
    SOUTH(7,"南风"),
    /**
     *
     */
    WEST(6,"西风"),
    /**
     *
     */
    EAST(8,"东风");

    private Integer key;
    private String windDirection;

    WindDirection(Integer key, String windDirection)
    {
        this.key = key;
        this.windDirection = windDirection;
    }

    public static WindDirection of(int key)
    {
        for(WindDirection windDirection : WindDirection.values()){
            if(windDirection.key == key){
                return windDirection;
            }
        }
        return null;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }
}
