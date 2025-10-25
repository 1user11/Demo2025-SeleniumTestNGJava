package com.websitename.utils;

public final class Config {
    private Config(){}

    // Глобальный дефолт (если не задано более узкое)
    public static int waitDefaultSec()      { return Integer.getInteger("wait.default", 3); }

    // Раздельные таймауты (можно переопределять из CI)
    public static int waitVisibleSec()      { return Integer.getInteger("wait.visible", 2); }
    public static int waitClickableSec()    { return Integer.getInteger("wait.click",   1); }
    public static int waitPresenceSec()     { return Integer.getInteger("wait.presence",2); }
    public static int waitInvisibleSec()    { return Integer.getInteger("wait.invis",   2); }

    // Таймаут ленивой инициализации PageFactory (AjaxElementLocatorFactory)
    public static int pageFactoryTimeoutSec(){ return Integer.getInteger("wait.pf",     1); }
}

