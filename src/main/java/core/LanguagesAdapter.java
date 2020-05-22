package core;

import texts.texts;

public class LanguagesAdapter {
    private Languages languages;
    private texts texts;

    {
        texts=new texts();
    }

    public LanguagesAdapter(Languages languages){
        this.languages=languages;
    }

    public String getFirstInit(int index){
        if(languages.equals(Languages.ENGLISH)){
            return texts.firstInitEng[index];
        }
        if(languages.equals(Languages.RUSSIAN)){
            return texts.firstInitRus[index];
        }
        return null;
    }
}
