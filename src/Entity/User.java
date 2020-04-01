package Entity;

public class User {

    private String id;
    private String username;
    private String email;
    private int enabled;
    private String password;
    private String firstName;
    private String lastName;
    private String gender;
    private String userType;
    private String joiningDate;
    private String address;
    private String phone;
    private String picture;
    private String bloodGroup;
    private Float salaire;
    private String occupation;
    private String placeofbirth;
    private String academicyear;
    private String classe;
    private String last_login;
    private String roles;
    private String birthDay;

    public User(String id, String username, String email, int enabled, String password, String firstName, String lastName, String gender, String userType, String joiningDate, String address, String phone, String picture, String bloodGroup, Float salaire, String occupation, String placeofbirth, String academicyear, String classe, String last_login, String roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.userType = userType;
        this.joiningDate = joiningDate;
        this.address = address;
        this.phone = phone;
        this.picture = picture;
        this.bloodGroup = bloodGroup;
        this.salaire = salaire;
        this.occupation = occupation;
        this.placeofbirth = placeofbirth;
        this.academicyear = academicyear;
        this.classe = classe;
        this.last_login = last_login;
        this.roles = roles;
    }



    public User(String id, String email, String firstName, String lastName, String gender, String address, String phone, String picture,String birthDay) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.picture = picture;
        this.birthDay = birthDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Float getSalaire() {
        return salaire;
    }

    public void setSalaire(Float salaire) {
        this.salaire = salaire;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPlaceofbirth() {
        return placeofbirth;
    }

    public void setPlaceofbirth(String placeofbirth) {
        this.placeofbirth = placeofbirth;
    }

    public String getAcademicyear() {
        return academicyear;
    }

    public void setAcademicyear(String academicyear) {
        this.academicyear = academicyear;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
}
