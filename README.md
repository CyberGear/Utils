CyberGear Utils 0.0.1
====================

helpful tools for android

Usage
====================

Project build.gradle
```Groovy
allprojects {
    repositories {
        ...
        maven {
            url "https://github.com/CyberGear/Utils/raw/master/repo/"
        }
    }
}
```

module build.gradle
```Groovy
dependencies {
    ...
    compile 'lt.cybergear.utils:utils:0.0.1'
}
```

Contents
====================

Metrics.dpToPx(int dp)

FinishBroadcast // helps to handle all activitys close

DecimalDigitsInputFilter // constrain entering double