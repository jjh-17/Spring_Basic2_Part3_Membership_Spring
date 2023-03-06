package spring_basic2.part3_Membership_Spring.member;

public class Member {
    //변수
    private long id;
    private String name;
    private Grade grade;

    //생성자
    public Member(long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    //메서드
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGradle(Grade grade) {
        this.grade = grade;
    }
}
