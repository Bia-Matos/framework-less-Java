package simplerest.demo.entity;

public class Student {
    private Integer id;
    private String name;
    private Integer grade;

    public Student() {

    }

    public Student(String name, Integer grade) {
        this.name = name;
        this.grade = grade;
    }

    public Student(Integer id, String name, Integer grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
