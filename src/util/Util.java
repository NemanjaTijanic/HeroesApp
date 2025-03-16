package util;

import entity.Ability;
import entity.Hero;
import exceptions.NedovoljanUnosException;
import exceptions.NegativanBrojException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Util {
    // Ucitavanje opisa sposobnosti
    public static String scanAbilityDesc(String heroName, int br){
        String ability = "";
        
        try {
            //Document doc = Jsoup.connect("https://heroesofthestorm.com/en-us/heroes/yrel/").get();
            Document doc = Jsoup.connect("https://heroesofthestorm.com/en-us/heroes/" + heroName).get();
            Element ha = doc.getElementById("hero-abilities");
            Elements haa = ha.children().select("span.heroAbility-description");
            
            int i = 0;
            for(Element e : haa){
                if(i == br){
                    ability = e.ownText();
                }
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ability;
    }
    
    // Ucitavanje naziva sposobnosti
    public static String scanAbilityName(String heroName, int br){
        String ability = "";
        
        try {
            //Document doc = Jsoup.connect("https://heroesofthestorm.com/en-us/heroes/yrel/").get();
            Document doc = Jsoup.connect("https://heroesofthestorm.com/en-us/heroes/" + heroName).get();
            Element ha = doc.getElementById("hero-abilities");
            Elements haa = ha.children().select("span.heroAbility-name-text");
            
            int i = 0;
            for(Element e : haa){
                if(i == br){
                    ability = e.ownText();
                }
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ability;
    }
    
    // Nalazenje heroja iz liste preko ID-ja
    public static Hero findHero(List<Hero> heroji, int br){
        Hero h = new Hero();
        for(Hero e : heroji){
            if(e.getId() == br){
                h = e;
            }
        }
        return h;
    }
    
    // Nalazenje abilitija iz liste preko ID heroja
    public static List<Ability> findAbility(List<Ability> abilitiji, Hero br){
        List<Ability> a = new ArrayList<>();
        
        for(Ability ab : abilitiji){
            if(ab.getHeroId().equals(br)){
                a.add(ab);
            }
        }
        
        return a;
    }
    
    // Dodavanje novog heroja i njegovih sposobnosti u bazu podataka
    public static void createHero(Hero hero) throws NedovoljanUnosException, NegativanBrojException{
        Ability a = new Ability();
        Hero h;
        String ability, name, desc;
        
        crud.HeroCRUD.addHero(hero);
        ability = hero.getName().toLowerCase();
        
        a.setHeroId(hero);
        // Ucitavanje sposobnosti
        for(int i = 0; i < 5; i++){
            name = scanAbilityName(ability, i);
            desc = scanAbilityDesc(ability, i);
            a.setTitle(name);
            a.setDescription(desc);
            crud.AbilityCRUD.addAbility(a);
        }
        
    }
    
}
