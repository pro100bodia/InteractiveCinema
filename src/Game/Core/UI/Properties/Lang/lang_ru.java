package Game.Core.UI.Properties.Lang;

import java.util.ListResourceBundle;

public class lang_ru extends ListResourceBundle {

    private static final  String[][]contents={
            {"newGame","Новая Игра"},
            {"continueGame","Продолжить игру"},
            {"loadGame","Загрузить"},
            {"settings","Настройки"},
            {"fullscreen","На весь экран"},
            {"lang","Язык"},
            {"music","Музыка"},
            {"sound","Звуки"},
            {"dispResol","Разрешение экрана"},
            {"back","Go Back ru"},
            {"toTheStreet","To The Street"},
            {"toTheBedroom","To The Bedroom"},
            {"toTheLivingRoom","To The Living Room"},
            {"street", "Street"},
            {"bedroom","Bedroom"},
            {"askExit","Do you want to leave the game?"},
            {"agree","Yes, I am sure"},
            {"disagree","No, I was wrong"},
            {"Park","Park"}
    };


    @Override
    protected Object[][] getContents() { return contents;}
}
