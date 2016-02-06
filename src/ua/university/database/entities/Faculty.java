package ua.university.database.entities;

/**
 * Created by Vladyslav on 04.01.2016.
 */
public class Faculty {
    private int id;
    private String name;
    private int vacancies;
    private String subject1;
    private String subject2;
    private String subject3;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVacancies(int vacancies) {
        this.vacancies = vacancies;
    }

    public void setSubject1(String subject1) {
        this.subject1 = subject1;
    }

    public void setSubject2(String subject2) {
        this.subject2 = subject2;
    }

    public void setSubject3(String subject3) {
        this.subject3 = subject3;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getVacancies() {
        return vacancies;
    }

    public String getSubject1() {
        return subject1;
    }

    public String getSubject2() {
        return subject2;
    }

    public String getSubject3() {
        return subject3;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vacancies=" + vacancies +
                ", subject1='" + subject1 + '\'' +
                ", subject2='" + subject2 + '\'' +
                ", subject3='" + subject3 + '\'' +
                '}';
    }
}
