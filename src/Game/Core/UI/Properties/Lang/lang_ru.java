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
            {"street", "Street"},
            {"bedroom","Bedroom"}
    };


    @Override
    protected Object[][] getContents() { return contents;}
}
