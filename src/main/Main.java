package main;

import crud.AbilityCRUD;
import crud.HeroCRUD;
import entity.Ability;
import entity.Hero;
import exceptions.NedovoljanUnosException;
import exceptions.NegativanBrojException;
import exceptions.NeispravanUnosException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override  
    public void start(Stage primaryStage) {
        
        StackPane stackBegin = new StackPane();
        Scene scene = new Scene(stackBegin, 500, 500);
        
        primaryStage.setTitle("Heroes of the Storm");
        primaryStage.setScene(scene);
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.show();
        
        primaryStage.setOnCloseRequest(e->{
            util.HibernateUtil.getSessionFactory().close();
        });
        
        // Pocetna scena
        ImageView logo = new ImageView(new Image("logo.jpg"));
        stackBegin.getChildren().add(logo);
        
        Label labelMainMenu = new Label("MAIN MENU");
        labelMainMenu.setStyle("-fx-font-weight: bold; -fx-font-size: 32px;");
        labelMainMenu.setTranslateY(-220);
        stackBegin.getChildren().add(labelMainMenu);
        
        Label labelSvePogledaj = new Label("HERO LIST");
        labelSvePogledaj.setStyle("-fx-font-weight: bold;");
        labelSvePogledaj.setTranslateX(-106);
        labelSvePogledaj.setTranslateY(-150);
        stackBegin.getChildren().add(labelSvePogledaj);
        
        Button buttonSve = new Button("LIST");
        buttonSve.setTranslateX(100);
        buttonSve.setTranslateY(-150);
        buttonSve.setMinSize(50, 25);
        buttonSve.setMaxSize(50, 25);
        stackBegin.getChildren().add(buttonSve);
        
        Label labelOdredjeni = new Label("HERO INFO");
        labelOdredjeni.setStyle("-fx-font-weight: bold;");
        labelOdredjeni.setTranslateX(-106);
        labelOdredjeni.setTranslateY(-100);
        stackBegin.getChildren().add(labelOdredjeni);
        
        Button buttonInfo = new Button("INFO");
        buttonInfo.setTranslateX(100);
        buttonInfo.setTranslateY(-100);
        buttonInfo.setMinSize(50, 25);
        buttonInfo.setMaxSize(50, 25);
        stackBegin.getChildren().add(buttonInfo);
        
        Label labelDodaj = new Label("ADD HERO");
        labelDodaj.setStyle("-fx-font-weight: bold;");
        labelDodaj.setTranslateX(-106);
        labelDodaj.setTranslateY(-50);
        stackBegin.getChildren().add(labelDodaj);
        
        Button buttonDodaj = new Button("ADD");
        buttonDodaj.setTranslateX(100);
        buttonDodaj.setTranslateY(-50);
        buttonDodaj.setMinSize(50, 25);
        buttonDodaj.setMaxSize(50, 25);
        stackBegin.getChildren().add(buttonDodaj);
        
        Label labelBorba = new Label("HERO BATTLE");
        labelBorba.setStyle("-fx-font-weight: bold;");
        labelBorba.setTranslateX(-106);
        labelBorba.setTranslateY(0);
        stackBegin.getChildren().add(labelBorba);
        
        Button buttonBorba = new Button("FIGHT");
        buttonBorba.setTranslateX(100);
        buttonBorba.setTranslateY(0);
        buttonBorba.setMinSize(50, 25);
        buttonBorba.setMaxSize(50, 25);
        stackBegin.getChildren().add(buttonBorba);
        
        // Scena za HERO LIST
        StackPane stackList = new StackPane();
        Scene sceneList = new Scene(stackList, 500, 500);
        
        buttonSve.setOnAction(e->{
            primaryStage.setScene(sceneList);
        });
        
        ImageView logoZaListu = new ImageView(new Image("logo.jpg"));
        stackList.getChildren().add(logoZaListu);
        
        Label labelHeroList = new Label("HERO LIST");
        labelHeroList.setStyle("-fx-font-weight: bold; -fx-font-size: 32px;");
        labelHeroList.setTranslateY(-220);
        stackList.getChildren().add(labelHeroList);
        
        Label labelList = new Label(HeroCRUD.readAllHeroes().toString());
        labelList.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");
        labelList.setTranslateX(0);
        stackList.getChildren().add(labelList);
        
        Button buttonAzurirajListu = new Button("UPDATE");
        buttonAzurirajListu.setTranslateX(220);
        buttonAzurirajListu.setTranslateY(-240);
        buttonAzurirajListu.setMinSize(80, 25);
        buttonAzurirajListu.setMaxSize(80, 25);
        stackList.getChildren().add(buttonAzurirajListu);
        
        buttonAzurirajListu.setOnAction(e->{
            labelList.setText(HeroCRUD.readAllHeroes().toString());
        });
        
        Button buttonNazadLista = new Button("BACK");
        buttonNazadLista.setTranslateX(230);
        buttonNazadLista.setTranslateY(240);
        buttonNazadLista.setMinSize(50, 25);
        buttonNazadLista.setMaxSize(50, 25);
        stackList.getChildren().add(buttonNazadLista);
        
        buttonNazadLista.setOnAction(e->{
            primaryStage.setScene(scene);
        });
        
        // Scena za HERO INFO
        StackPane stackInfo = new StackPane();
        Scene sceneInfo = new Scene(stackInfo, 500, 500);
        
        buttonInfo.setOnAction(e->{
            primaryStage.setScene(sceneInfo);
        });
        
        ImageView logoZaInfo = new ImageView(new Image("logo.jpg"));
        stackInfo.getChildren().add(logoZaInfo);
        
        Label labelHeroInfo = new Label("HERO INFO");
        labelHeroInfo.setStyle("-fx-font-weight: bold; -fx-font-size: 32px;");
        labelHeroInfo.setTranslateY(-220);
        stackInfo.getChildren().add(labelHeroInfo);
        
        Label labelUnesiInfo = new Label("ENTER HERO ID:");
        labelUnesiInfo.setStyle("-fx-font-weight: bold;");
        labelUnesiInfo.setTranslateX(-200);
        labelUnesiInfo.setTranslateY(-170);
        stackInfo.getChildren().add(labelUnesiInfo);
        
        TextField tfHeroId = new TextField();
        tfHeroId.setTranslateX(-120);
        tfHeroId.setTranslateY(-170);
        tfHeroId.setMinSize(50, 20);
        tfHeroId.setMaxSize(50, 20);
        stackInfo.getChildren().add(tfHeroId);
        
        Button buttonHeroInfo = new Button("FIND");
        buttonHeroInfo.setTranslateX(100);
        buttonHeroInfo.setTranslateY(-170);
        buttonHeroInfo.setMinSize(50, 25);
        buttonHeroInfo.setMaxSize(50, 25);
        stackInfo.getChildren().add(buttonHeroInfo);
        
        Label heroNameInfo = new Label("");
        heroNameInfo.setStyle("-fx-font-weight: bold; -fx-font-size: 26px;");
        heroNameInfo.setTranslateX(0);
        heroNameInfo.setTranslateY(-130);
        stackInfo.getChildren().add(heroNameInfo);
        
        Label heroRoleText = new Label("ROLE:");
        heroRoleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
        heroRoleText.setTranslateX(-100);
        heroRoleText.setTranslateY(-100);
        heroRoleText.setOpacity(0);
        stackInfo.getChildren().add(heroRoleText);
        
        Label heroRoleInfo = new Label("");
        heroRoleInfo.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
        heroRoleInfo.setTranslateX(100);
        heroRoleInfo.setTranslateY(-100);
        stackInfo.getChildren().add(heroRoleInfo);
        
        Label heroUniverseText = new Label("UNIVERSE:");
        heroUniverseText.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
        heroUniverseText.setTranslateX(-100);
        heroUniverseText.setTranslateY(-50);
        heroUniverseText.setOpacity(0);
        stackInfo.getChildren().add(heroUniverseText);
        
        Label heroUniverseInfo = new Label("");
        heroUniverseInfo.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
        heroUniverseInfo.setTranslateX(100);
        heroUniverseInfo.setTranslateY(-50);
        stackInfo.getChildren().add(heroUniverseInfo);
        
        Label heroDamageText = new Label("DAMAGE:");
        heroDamageText.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
        heroDamageText.setTranslateX(-100);
        heroDamageText.setTranslateY(0);
        heroDamageText.setOpacity(0);
        stackInfo.getChildren().add(heroDamageText);
        
        Label heroDamageInfo = new Label("");
        heroDamageInfo.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
        heroDamageInfo.setTranslateX(100);
        heroDamageInfo.setTranslateY(0);
        stackInfo.getChildren().add(heroDamageInfo);
        
        Label heroUtilityText = new Label("UTILITY:");
        heroUtilityText.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
        heroUtilityText.setTranslateX(-100);
        heroUtilityText.setTranslateY(50);
        heroUtilityText.setOpacity(0);
        stackInfo.getChildren().add(heroUtilityText);
        
        Label heroUtilityInfo = new Label("");
        heroUtilityInfo.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
        heroUtilityInfo.setTranslateX(100);
        heroUtilityInfo.setTranslateY(50);
        stackInfo.getChildren().add(heroUtilityInfo);
        
        Label heroSurvivabilityText = new Label("SURVIVABILITY:");
        heroSurvivabilityText.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
        heroSurvivabilityText.setTranslateX(-100);
        heroSurvivabilityText.setTranslateY(100);
        heroSurvivabilityText.setOpacity(0);
        stackInfo.getChildren().add(heroSurvivabilityText);
        
        Label heroSurvivabilityInfo = new Label("");
        heroSurvivabilityInfo.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
        heroSurvivabilityInfo.setTranslateX(100);
        heroSurvivabilityInfo.setTranslateY(100);
        stackInfo.getChildren().add(heroSurvivabilityInfo);
        
        Label heroComplexityText = new Label("COMPLEXITY:");
        heroComplexityText.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
        heroComplexityText.setTranslateX(-100);
        heroComplexityText.setTranslateY(150);
        heroComplexityText.setOpacity(0);
        stackInfo.getChildren().add(heroComplexityText);
        
        Label heroComplexityInfo = new Label("");
        heroComplexityInfo.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
        heroComplexityInfo.setTranslateX(100);
        heroComplexityInfo.setTranslateY(150);
        stackInfo.getChildren().add(heroComplexityInfo);
        
        Label heroAbilityText = new Label("ABILITIES:");
        heroAbilityText.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
        heroAbilityText.setTranslateX(-200);
        heroAbilityText.setTranslateY(200);
        heroAbilityText.setOpacity(0);
        stackInfo.getChildren().add(heroAbilityText);
        
        Label heroAbilityInfo = new Label("");
        heroAbilityInfo.setStyle("-fx-font-weight: bold; -fx-font-size: 10px;");
        heroAbilityInfo.setTranslateX(20);
        heroAbilityInfo.setTranslateY(200);
        stackInfo.getChildren().add(heroAbilityInfo);
        
        List<Hero> heroji = HeroCRUD.readAllHeroes();
        List<Ability> abilitiji = AbilityCRUD.readAllAbilities();
        
        buttonHeroInfo.setOnAction(e->{
            int br = Integer.parseInt(tfHeroId.getText());
            Hero h = new Hero();
            h = crud.HeroCRUD.readHeroById(br);
            heroNameInfo.setText(h.getName());
            heroRoleText.setOpacity(100);
            heroRoleInfo.setText(h.getRole());
            heroUniverseText.setOpacity(100);
            heroUniverseInfo.setText((h.getUniverse()));
            heroDamageText.setOpacity(100);
            heroDamageInfo.setText(String.valueOf(h.getDamage()));
            heroUtilityText.setOpacity(100);
            heroUtilityInfo.setText(String.valueOf(h.getUtility()));
            heroSurvivabilityText.setOpacity(100);
            heroSurvivabilityInfo.setText(String.valueOf(h.getSurvivability()));
            heroComplexityText.setOpacity(100);
            heroComplexityInfo.setText(String.valueOf(h.getComplexity()));
            heroAbilityText.setOpacity(100);
            
            List<Ability> zaHeroja = util.Util.findAbility(abilitiji, h);
            heroAbilityInfo.setText(zaHeroja.toString());
        });
        
        Button buttonNazadInfo = new Button("BACK");
        buttonNazadInfo.setTranslateX(230);
        buttonNazadInfo.setTranslateY(240);
        buttonNazadInfo.setMinSize(50, 25);
        buttonNazadInfo.setMaxSize(50, 25);
        stackInfo.getChildren().add(buttonNazadInfo);
        
        buttonNazadInfo.setOnAction(e->{
            primaryStage.setScene(scene);
        });
        
        // Scena za ADD HERO
        StackPane stackAdd = new StackPane();
        Scene sceneAdd = new Scene(stackAdd, 500, 500);
        
        buttonDodaj.setOnAction(e->{
            primaryStage.setScene(sceneAdd);
        });
        
        ImageView logoZaAdd = new ImageView(new Image("logo.jpg"));
        stackAdd.getChildren().add(logoZaAdd);
        
        Label labelHeroAdd = new Label("ADD HERO");
        labelHeroAdd.setStyle("-fx-font-weight: bold; -fx-font-size: 32px;");
        labelHeroAdd.setTranslateY(-220);
        stackAdd.getChildren().add(labelHeroAdd);
        
        Label labelUnesiIme = new Label("HERO NAME:");
        labelUnesiIme.setStyle("-fx-font-weight: bold;");
        labelUnesiIme.setTranslateX(-130);
        labelUnesiIme.setTranslateY(-170);
        stackAdd.getChildren().add(labelUnesiIme);
        
        TextField tfHeroName = new TextField();
        tfHeroName.setTranslateX(0);
        tfHeroName.setTranslateY(-170);
        tfHeroName.setMinSize(100, 20);
        tfHeroName.setMaxSize(100, 20);
        stackAdd.getChildren().add(tfHeroName);
        
        Label labelUnesiRole = new Label("HERO ROLE:");
        labelUnesiRole.setStyle("-fx-font-weight: bold;");
        labelUnesiRole.setTranslateX(-130);
        labelUnesiRole.setTranslateY(-120);
        stackAdd.getChildren().add(labelUnesiRole);
        
        TextField tfHeroRole = new TextField();
        tfHeroRole.setTranslateX(0);
        tfHeroRole.setTranslateY(-120);
        tfHeroRole.setMinSize(100, 20);
        tfHeroRole.setMaxSize(100, 20);
        stackAdd.getChildren().add(tfHeroRole);
        
        Label labelUnesiUniverse = new Label("HERO UNIVERSE:");
        labelUnesiUniverse.setStyle("-fx-font-weight: bold;");
        labelUnesiUniverse.setTranslateX(-130);
        labelUnesiUniverse.setTranslateY(-70);
        stackAdd.getChildren().add(labelUnesiUniverse);
        
        TextField tfHeroUniverse = new TextField();
        tfHeroUniverse.setTranslateX(0);
        tfHeroUniverse.setTranslateY(-70);
        tfHeroUniverse.setMinSize(100, 20);
        tfHeroUniverse.setMaxSize(100, 20);
        stackAdd.getChildren().add(tfHeroUniverse);
        
        Label labelUnesiDamage = new Label("HERO DAMAGE:");
        labelUnesiDamage.setStyle("-fx-font-weight: bold;");
        labelUnesiDamage.setTranslateX(-130);
        labelUnesiDamage.setTranslateY(-20);
        stackAdd.getChildren().add(labelUnesiDamage);
        
        TextField tfHeroDamage = new TextField();
        tfHeroDamage.setTranslateX(0);
        tfHeroDamage.setTranslateY(-20);
        tfHeroDamage.setMinSize(50, 20);
        tfHeroDamage.setMaxSize(50, 20);
        stackAdd.getChildren().add(tfHeroDamage);
        
        Label labelUnesiUtility = new Label("HERO UTILITY:");
        labelUnesiUtility.setStyle("-fx-font-weight: bold;");
        labelUnesiUtility.setTranslateX(-130);
        labelUnesiUtility.setTranslateY(30);
        stackAdd.getChildren().add(labelUnesiUtility);
        
        TextField tfHeroUtility = new TextField();
        tfHeroUtility.setTranslateX(0);
        tfHeroUtility.setTranslateY(30);
        tfHeroUtility.setMinSize(50, 20);
        tfHeroUtility.setMaxSize(50, 20);
        stackAdd.getChildren().add(tfHeroUtility);
        
        Label labelUnesiSurvivability = new Label("HERO SURVIVABILITY:");
        labelUnesiSurvivability.setStyle("-fx-font-weight: bold;");
        labelUnesiSurvivability.setTranslateX(-130);
        labelUnesiSurvivability.setTranslateY(80);
        stackAdd.getChildren().add(labelUnesiSurvivability);
        
        TextField tfHeroSurvivability = new TextField();
        tfHeroSurvivability.setTranslateX(0);
        tfHeroSurvivability.setTranslateY(80);
        tfHeroSurvivability.setMinSize(50, 20);
        tfHeroSurvivability.setMaxSize(50, 20);
        stackAdd.getChildren().add(tfHeroSurvivability);
        
        Label labelUnesiComplexity = new Label("HERO COMPLEXITY:");
        labelUnesiComplexity.setStyle("-fx-font-weight: bold;");
        labelUnesiComplexity.setTranslateX(-130);
        labelUnesiComplexity.setTranslateY(130);
        stackAdd.getChildren().add(labelUnesiComplexity);
        
        TextField tfHeroComplexity = new TextField();
        tfHeroComplexity.setTranslateX(0);
        tfHeroComplexity.setTranslateY(130);
        tfHeroComplexity.setMinSize(50, 20);
        tfHeroComplexity.setMaxSize(50, 20);
        stackAdd.getChildren().add(tfHeroComplexity);
        
        Button buttonAdd = new Button("ADD");
        buttonAdd.setTranslateX(0);
        buttonAdd.setTranslateY(180);
        buttonAdd.setMinSize(80, 35);
        buttonAdd.setMaxSize(80, 35);
        stackAdd.getChildren().add(buttonAdd);
        
        buttonAdd.setOnAction(e->{
            try {
                String name, role, universe, ability;
                int damage, utility, survivability, complexity;
                Hero h = new Hero();
                name = tfHeroName.getText();
                role = tfHeroRole.getText();
                universe = tfHeroUniverse.getText();
                ability = name.toLowerCase();
                damage = Integer.parseInt(tfHeroDamage.getText());
                utility = Integer.parseInt(tfHeroUtility.getText());
                survivability = Integer.parseInt(tfHeroSurvivability.getText());
                complexity = Integer.parseInt(tfHeroComplexity.getText());
                h.setName(name);
                h.setRole(role);
                h.setUniverse(universe);
                h.setDamage(damage);
                h.setUtility(utility);
                h.setSurvivability(survivability);
                h.setComplexity(complexity);
                util.Util.createHero(h);
                List<Ability> sveSposobnosti = crud.AbilityCRUD.readAllAbilities();
                for(Ability a : sveSposobnosti){
                    if(a.getHeroId().equals(h)){
                        abilitiji.add(a);
                    }
                }
            } catch (NegativanBrojException ex) {
                System.out.println(ex.getMessage());
            } catch (NeispravanUnosException ex) {
                System.out.println(ex.getMessage());
            } catch (NedovoljanUnosException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Button buttonNazadAdd = new Button("BACK");
        buttonNazadAdd.setTranslateX(230);
        buttonNazadAdd.setTranslateY(240);
        buttonNazadAdd.setMinSize(50, 25);
        buttonNazadAdd.setMaxSize(50, 25);
        stackAdd.getChildren().add(buttonNazadAdd);
        
        buttonNazadAdd.setOnAction(e->{
            primaryStage.setScene(scene);
        });
        
        // Scena za HERO BATTLE
        StackPane stackBattle = new StackPane();
        Scene sceneBattle = new Scene(stackBattle, 500, 500);
        
        buttonBorba.setOnAction(e->{
            primaryStage.setScene(sceneBattle);
        });
        
        ImageView logoZaBattle = new ImageView(new Image("logo.jpg"));
        stackBattle.getChildren().add(logoZaBattle);
        
        Label labelHeroBattle = new Label("HERO BATTLE");
        labelHeroBattle.setStyle("-fx-font-weight: bold; -fx-font-size: 32px;");
        labelHeroBattle.setTranslateY(-220);
        stackBattle.getChildren().add(labelHeroBattle);
        
        Label labelUnesiPrvog = new Label("FIRST HERO ID:");
        labelUnesiPrvog.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
        labelUnesiPrvog.setTranslateX(-50);
        labelUnesiPrvog.setTranslateY(-130);
        stackBattle.getChildren().add(labelUnesiPrvog);
        
        TextField tfHeroPrvi = new TextField();
        tfHeroPrvi.setTranslateX(80);
        tfHeroPrvi.setTranslateY(-130);
        tfHeroPrvi.setMinSize(50, 20);
        tfHeroPrvi.setMaxSize(50, 20);
        stackBattle.getChildren().add(tfHeroPrvi);
        
        Label labelUnesiDrugog = new Label("SECOND HERO ID:");
        labelUnesiDrugog.setStyle("-fx-font-weight: bold; -fx-font-size: 20px;");
        labelUnesiDrugog.setTranslateX(-50);
        labelUnesiDrugog.setTranslateY(-80);
        stackBattle.getChildren().add(labelUnesiDrugog);
        
        TextField tfHeroDrugi = new TextField();
        tfHeroDrugi.setTranslateX(80);
        tfHeroDrugi.setTranslateY(-80);
        tfHeroDrugi.setMinSize(50, 20);
        tfHeroDrugi.setMaxSize(50, 20);
        stackBattle.getChildren().add(tfHeroDrugi);
        
        Button buttonBattle = new Button("BATTLE");
        buttonBattle.setTranslateX(0);
        buttonBattle.setTranslateY(0);
        buttonBattle.setMinSize(80, 25);
        buttonBattle.setMaxSize(80, 25);
        stackBattle.getChildren().add(buttonBattle);
        
        buttonBattle.setOnAction(e->{
            int idJedan, idDva;
            idJedan = Integer.parseInt(tfHeroPrvi.getText());
            idDva = Integer.parseInt(tfHeroDrugi.getText());
            
            Hero jedan = crud.HeroCRUD.readHeroById(idJedan);
            Hero dva = crud.HeroCRUD.readHeroById(idDva);
            
            int dmg1, util1, surv1, comp1;
            int dmg2, util2, surv2, comp2;
            int ukupan1, ukupan2;
            
            dmg1 = jedan.getDamage();
            util1 = jedan.getUtility();
            surv1 = jedan.getSurvivability();
            comp1 = jedan.getComplexity();
            ukupan1 = (dmg1 + util1 + surv1) - comp1;
            
            dmg2 = dva.getDamage();
            util2 = dva.getUtility();
            surv2 = dva.getSurvivability();
            comp2= dva.getComplexity();
            ukupan2 = (dmg2 + util2 + surv2) - comp2;
            
            String rezultat = "";
            if(ukupan1 > ukupan2){
                rezultat = "The First hero won.";
            }
            else if(ukupan1 < ukupan2){
                rezultat = "The Second hero won.";
            }
            else if(ukupan1 == ukupan2){
                rezultat = "It is a draw.";
            }
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("BATTLE RESULT");
            alert.setHeaderText("After a long and difficult battle: ");
            alert.setContentText(rezultat);
            alert.show();
        });
        
        // Nazad
        Button buttonNazadBattle = new Button("BACK");
        buttonNazadBattle.setTranslateX(230);
        buttonNazadBattle.setTranslateY(240);
        buttonNazadBattle.setMinSize(50, 25);
        buttonNazadBattle.setMaxSize(50, 25);
        stackBattle.getChildren().add(buttonNazadBattle);
        
        buttonNazadBattle.setOnAction(e->{
            primaryStage.setScene(scene);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
