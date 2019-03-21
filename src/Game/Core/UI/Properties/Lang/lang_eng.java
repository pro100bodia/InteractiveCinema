package Game.Core.UI.Properties.Lang;

import java.util.ListResourceBundle;

public class lang_eng extends ListResourceBundle {

    private static final  String[][]contents={
            {"newGame","New game"},
            {"continueGame","Продолжить игру"},
            {"loadGame","Load Game"},
            {"settings","Settings"},
            {"fullscreen","Fullcreen"},
            {"lang","Language"},
            {"music","Music"},
            {"sound","Sound"},
            {"dispResol","Разрешение экрана"},
            {"back","Go Back"},
            {"toTheStreet","To The Street"},
            {"toTheBedroom","To The Bedroom"},
            {"street", "Street"},
            {"bedroom","Bedroom"},
            {"agree","Agree"},
            {"disagree","Disagree"}

            
    };


    @Override
    protected Object[][] getContents() { return contents;}
}
