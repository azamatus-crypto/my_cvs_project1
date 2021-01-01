package Data;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "mycv")
public class MyCv {
    @PrimaryKey(autoGenerate = true)
    private int uniqId;
   // private String urlimage;
    private String nameandlastname;
    private String profession;
    private String personalinformation;
    private String expirience;
    private String education;
    private String languages;
    private String skills;
    private String awards;

    public MyCv(int uniqId, String nameandlastname, String profession, String personalinformation, String expirience, String education, String languages, String skills, String awards) {
       // this.urlimage = urlimage;
        this.nameandlastname = nameandlastname;
        this.profession = profession;
        this.personalinformation = personalinformation;
        this.expirience = expirience;
        this.education = education;
        this.languages = languages;
        this.skills = skills;
        this.awards = awards;
    }
    @Ignore
    public MyCv(  String nameandlastname, String profession, String personalinformation, String expirience, String education, String languages, String skills, String awards) {
        //this.urlimage = urlimage;
        this.nameandlastname = nameandlastname;
        this.profession = profession;
        this.personalinformation = personalinformation;
        this.expirience = expirience;
        this.education = education;
        this.languages = languages;
        this.skills = skills;
        this.awards = awards;
    }

//
//    public String getUrlimage() {
//        return urlimage;
//    }
//
//    public void setUrlimage(String urlimage) {
//        this.urlimage = urlimage;
//    }

    public String getNameandlastname() {
        return nameandlastname;
    }

    public void setNameandlastname(String nameandlastname) {
        this.nameandlastname = nameandlastname;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPersonalinformation() {
        return personalinformation;
    }

    public void setPersonalinformation(String personalinformation) {
        this.personalinformation = personalinformation;
    }

    public String getExpirience() {
        return expirience;
    }

    public void setExpirience(String expirience) {
        this.expirience = expirience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public int getUniqId() {
        return uniqId;
    }

    public void setUniqId(int uniqId) {
        this.uniqId = uniqId;
    }
}
