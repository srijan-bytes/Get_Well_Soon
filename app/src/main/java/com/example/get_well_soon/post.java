package com.example.get_well_soon;

public class post {

    private static String name;

    private static String degree;


    public post() {
    }

    @Override
    public String toString() {
        return "post{" +
                "name='" + name + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }

    public static String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public static String getDegree() {

        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
