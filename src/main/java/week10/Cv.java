package week10;

import java.util.ArrayList;
import java.util.List;

public class Cv {

    private String name;

    private List<Skill> skills;

    public Cv(String name) {
        this.name = name;
        skills = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void addSkills(String... skillArray) {
        for (String item : skillArray) {
            String s = item.substring(0, item.length() - 4);
            int n = Integer.parseInt(item.substring(item.length()-2, item.length()-1));
            skills.add(new Skill(s, n));
        }
    }

    public int findSkillLevelByName(String name) {
        int level = 0;
        for (Skill skill : skills)
            if (name.equals(skill.getName())) {
                level = skill.getLevel();
            }
        if (level == 0) {
            throw new SkillNotFoundException();
        }
        return level;
    }


}


//    Egy önéletrajzot reprezentáló osztályt kell létrehozni, melyben van egy név,
//    valamint skillek (hogy mihez ért az illető).
//
//    A skill egy névvel és egy számmal (szint) rendelkezik, utóbbi 1 - 5 között.
//        Az önéletrajz a Cv osztály pár metódussal, a skill a Skill osztály.
//
//        A skillek megadása a nevével, valamint a szintjével történik, pl. programming (5).
//
//        A findSkillLevelByName() a skill neve alapján visszaadja annak szintjét.