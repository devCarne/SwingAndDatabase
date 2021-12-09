package member.model;

public class MemberModel {
    private String name;
    private String birthday;
    private String tel;

    public MemberModel(String name, String birthday, String tel) {
        this.name = name;
        this.birthday = birthday;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "MemberModel{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
