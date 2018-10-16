# <div align=center>Android自定义View学习</div>

常用的属性如下：

|属性|解释|举例|
|-|-|-|
|`string`|字符串|`<attr name="text" format="string" />`|
|`color`|颜色|`<attr name="text_color" format="color" />`|
|`demension`|尺寸|`<attr name="text_width" format="dimension" />`|
|`integer`|整形常量|`<attr name="text_num" format="integer" />`|
|`enum`|枚举|`<declare-styleable name="MyView"><attr name="orientation"><enum name="horizontal" value="0" /><enum name="vertical" value="1" /></attr></declare-styleable>`|
|`reference`|参考某一资源ID值|`<attr name="textcolor" format="reference" />`|
|`float`|浮点数|`<attr name="text_color_alpha" format="float" />`|
|`boolean`|布尔值|`<attr name="text_show_hide" format="boolean" />`|
|`fraction`|百分数|`<attr name="text_angle" format="fraction" />`|
|`flag`|位或运算|`<attr name="age">             <flag name="child" value="10"/>             <flag name="young" value="18"/>             <flag name="old" value="50"/>         </attr> `|

<div align=center><img src="https://upload-images.jianshu.io/upload_images/3012005-e11b09f02b14bb7a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/300"></div>


