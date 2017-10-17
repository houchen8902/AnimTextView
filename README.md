# AnimTextView
Change the number of TextView with a animation.  

Use a valueAnimator to change the value of TextView. you can set animation duration and whether show animation.  

## Features
1. change the value of TextView from 0 to a number which you set with a animation.  
2. set animation duration, default is 1500. unit is ms.  
3. set whether show animation, default is true.  
4. other TextView properties are set just as normal TextView.  

## Properties
``` xml
<declare-styleable name="AnimTextView">
    <attr name="animValue" format="integer" />
    <attr name="duration" format="integer" />
    <attr name="showAnim" format="boolean" />
</declare-styleable>
```

## Usage
``` xml
<com.hc.animtext.AnimTextView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:animValue="99"
    app:duration="1200"
    app:showAnim="true"/>
```
